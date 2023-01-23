/*
 * Babylon Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.2.0
 * 
 * Generated by: https://openapi-generator.tech
 */



#[derive(Clone, Debug, PartialEq, serde::Serialize, serde::Deserialize)]
#[serde(tag = "type")]
pub enum ParsedTransaction {
    #[serde(rename="LedgerTransaction")]
    ParsedLedgerTransaction {
        #[serde(rename = "ledger_transaction", skip_serializing_if = "Option::is_none")]
        ledger_transaction: Option<Box<crate::core_api::generated::models::LedgerTransaction>>,
        #[serde(rename = "identifiers")]
        identifiers: Box<crate::core_api::generated::models::ParsedLedgerTransactionAllOfIdentifiers>,
    },
    #[serde(rename="NotarizedTransaction")]
    ParsedNotarizedTransaction {
        #[serde(rename = "notarized_transaction", skip_serializing_if = "Option::is_none")]
        notarized_transaction: Option<Box<crate::core_api::generated::models::NotarizedTransaction>>,
        #[serde(rename = "identifiers")]
        identifiers: Box<crate::core_api::generated::models::ParsedNotarizedTransactionAllOfIdentifiers>,
        #[serde(rename = "validation_error", skip_serializing_if = "Option::is_none")]
        validation_error: Option<Box<crate::core_api::generated::models::ParsedNotarizedTransactionAllOfValidationError>>,
    },
    #[serde(rename="SignedTransactionIntent")]
    ParsedSignedTransactionIntent {
        #[serde(rename = "signed_intent", skip_serializing_if = "Option::is_none")]
        signed_intent: Option<Box<crate::core_api::generated::models::SignedTransactionIntent>>,
        #[serde(rename = "identifiers")]
        identifiers: Box<crate::core_api::generated::models::ParsedSignedTransactionIntentAllOfIdentifiers>,
    },
    #[serde(rename="TransactionIntent")]
    ParsedTransactionIntent {
        #[serde(rename = "intent", skip_serializing_if = "Option::is_none")]
        intent: Option<Box<crate::core_api::generated::models::TransactionIntent>>,
        #[serde(rename = "identifiers")]
        identifiers: Box<crate::core_api::generated::models::ParsedTransactionIntentAllOfIdentifiers>,
    },
    #[serde(rename="TransactionManifest")]
    ParsedTransactionManifest {
        #[serde(rename = "manifest", skip_serializing_if = "Option::is_none")]
        manifest: Option<Box<crate::core_api::generated::models::TransactionManifest>>,
    },
}




