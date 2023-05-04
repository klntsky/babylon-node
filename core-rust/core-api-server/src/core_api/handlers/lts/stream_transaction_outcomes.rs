use crate::core_api::*;
use state_manager::store::traits::{QueryableProofStore, QueryableTransactionStore};
use tracing::warn;

#[tracing::instrument(skip(state))]
pub(crate) async fn handle_lts_stream_transaction_outcomes(
    state: State<CoreApiState>,
    Json(request): Json<models::LtsStreamTransactionOutcomesRequest>,
) -> Result<Json<models::LtsStreamTransactionOutcomesResponse>, ResponseError<()>> {
    assert_matching_network(&request.network, &state.network)?;
    let mapping_context = MappingContext::new(&state.network);

    let from_state_version: u64 = extract_api_state_version(request.from_state_version)
        .map_err(|err| err.into_response_error("from_state_version"))?;

    let limit: u64 = request
        .limit
        .try_into()
        .map_err(|_| client_error("limit cannot be negative"))?;

    if limit == 0 {
        return Err(client_error("limit must be positive"));
    }

    if limit > MAX_STREAM_COUNT_PER_REQUEST.into() {
        return Err(client_error(format!(
            "limit must <= {MAX_STREAM_COUNT_PER_REQUEST}"
        )));
    }

    let database = state.database.read();

    let max_state_version = database.max_state_version();

    let transactions = database.get_committed_transaction_bundles(
        from_state_version,
        limit.try_into().expect("limit out of usize bounds"),
    );

    let mut response = models::LtsStreamTransactionOutcomesResponse {
        from_state_version: to_api_state_version(from_state_version)?,
        count: MAX_STREAM_COUNT_PER_REQUEST as i32, // placeholder to get a better size aproximation for the header
        max_ledger_state_version: to_api_state_version(max_state_version)?,
        committed_transaction_outcomes: Vec::new(),
    };

    // Reserve enough for the "header" fields
    let mut current_total_size = response.get_json_size();
    current_total_size += 8; // This should cover '[' and ']'
    for (ledger_transaction, receipt, identifiers) in transactions {
        let committed_transaction = to_api_lts_committed_transaction_outcome(
            &mapping_context,
            ledger_transaction,
            receipt,
            identifiers,
        )?;

        let committed_transaction_size = committed_transaction.get_json_size();
        if current_total_size + committed_transaction_size > MAX_STREAM_TOTAL_SIZE_PER_RESPONSE {
            warn!("Query from state version {from_state_version} with count limit of {limit} passed total size limit of {MAX_STREAM_TOTAL_SIZE_PER_RESPONSE}.");
            break;
        }
        current_total_size += committed_transaction_size;
        current_total_size += 4; // this is should cover for ',' between array elements

        response
            .committed_transaction_outcomes
            .push(committed_transaction);
    }

    let count: i32 = {
        let transaction_count = response.committed_transaction_outcomes.len();
        if transaction_count > MAX_STREAM_COUNT_PER_REQUEST.into() {
            return Err(server_error("Too many transactions were loaded somehow"));
        }
        transaction_count
            .try_into()
            .map_err(|_| server_error("Unexpected error mapping small usize to i32"))?
    };

    response.count = count;

    Ok(response).map(Json)
}
