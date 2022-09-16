/*
 * Babylon Core API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.1.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct V0TransactionSubmitRequest {
    /// A hex-encoded, compiled notarized transaction.
    #[serde(rename = "notarized_transaction")]
    pub notarized_transaction: String,
}

impl V0TransactionSubmitRequest {
    pub fn new(notarized_transaction: String) -> V0TransactionSubmitRequest {
        V0TransactionSubmitRequest {
            notarized_transaction,
        }
    }
}


