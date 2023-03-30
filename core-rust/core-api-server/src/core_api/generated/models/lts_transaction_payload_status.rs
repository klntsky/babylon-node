/*
 * Babylon Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.3.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct LtsTransactionPayloadStatus {
    /// The hex-encoded notarized transaction hash. This is known as the Notarized Transaction Hash, Payload Hash or User Payload Hash. This hash is `Blake2b-256(compiled_notarized_transaction)`
    #[serde(rename = "payload_hash")]
    pub payload_hash: String,
    /// The status of the transaction payload, as per this node. A NotInMempool status means that it wasn't rejected at last execution attempt, but it's not currently in the mempool either. 
    #[serde(rename = "status")]
    pub status: Status,
    /// An explanation for the error, if failed or rejected
    #[serde(rename = "error_message", skip_serializing_if = "Option::is_none")]
    pub error_message: Option<String>,
}

impl LtsTransactionPayloadStatus {
    pub fn new(payload_hash: String, status: Status) -> LtsTransactionPayloadStatus {
        LtsTransactionPayloadStatus {
            payload_hash,
            status,
            error_message: None,
        }
    }
}

/// The status of the transaction payload, as per this node. A NotInMempool status means that it wasn't rejected at last execution attempt, but it's not currently in the mempool either. 
#[derive(Clone, Copy, Debug, Eq, PartialEq, Ord, PartialOrd, Hash, serde::Serialize, serde::Deserialize)]
pub enum Status {
    #[serde(rename = "CommittedSuccess")]
    CommittedSuccess,
    #[serde(rename = "CommittedFailure")]
    CommittedFailure,
    #[serde(rename = "PermanentlyRejected")]
    PermanentlyRejected,
    #[serde(rename = "TransientlyRejected")]
    TransientlyRejected,
    #[serde(rename = "InMempool")]
    InMempool,
    #[serde(rename = "NotInMempool")]
    NotInMempool,
}

impl Default for Status {
    fn default() -> Status {
        Self::CommittedSuccess
    }
}

