/*
 * Radix Core API - Babylon (Anemone)
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.1.0
 * 
 * Generated by: https://openapi-generator.tech
 */

/// TransactionReceipt : The transaction execution receipt



#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct TransactionReceipt {
    #[serde(rename = "status")]
    pub status: crate::core_api::generated::models::TransactionStatus,
    #[serde(rename = "fee_summary")]
    pub fee_summary: Box<crate::core_api::generated::models::FeeSummary>,
    #[serde(rename = "costing_parameters")]
    pub costing_parameters: Box<crate::core_api::generated::models::CostingParameters>,
    #[serde(rename = "fee_source", skip_serializing_if = "Option::is_none")]
    pub fee_source: Option<Box<crate::core_api::generated::models::FeeSource>>,
    #[serde(rename = "fee_destination", skip_serializing_if = "Option::is_none")]
    pub fee_destination: Option<Box<crate::core_api::generated::models::FeeDestination>>,
    #[serde(rename = "state_updates")]
    pub state_updates: Box<crate::core_api::generated::models::StateUpdates>,
    #[serde(rename = "events", skip_serializing_if = "Option::is_none")]
    pub events: Option<Vec<crate::core_api::generated::models::Event>>,
    #[serde(rename = "next_epoch", skip_serializing_if = "Option::is_none")]
    pub next_epoch: Option<Box<crate::core_api::generated::models::NextEpoch>>,
    /// The manifest line-by-line engine return data (only present if `status` is `Succeeded`)
    #[serde(rename = "output", skip_serializing_if = "Option::is_none")]
    pub output: Option<Vec<crate::core_api::generated::models::SborData>>,
    /// Error message (only present if status is `Failed` or `Rejected`)
    #[serde(rename = "error_message", skip_serializing_if = "Option::is_none")]
    pub error_message: Option<String>,
}

impl TransactionReceipt {
    /// The transaction execution receipt
    pub fn new(status: crate::core_api::generated::models::TransactionStatus, fee_summary: crate::core_api::generated::models::FeeSummary, costing_parameters: crate::core_api::generated::models::CostingParameters, state_updates: crate::core_api::generated::models::StateUpdates) -> TransactionReceipt {
        TransactionReceipt {
            status,
            fee_summary: Box::new(fee_summary),
            costing_parameters: Box::new(costing_parameters),
            fee_source: None,
            fee_destination: None,
            state_updates: Box::new(state_updates),
            events: None,
            next_epoch: None,
            output: None,
            error_message: None,
        }
    }
}


