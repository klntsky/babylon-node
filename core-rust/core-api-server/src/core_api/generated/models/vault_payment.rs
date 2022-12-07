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
pub struct VaultPayment {
    #[serde(rename = "vault_entity")]
    pub vault_entity: Box<crate::core_api::generated::models::EntityReference>,
    /// The string-encoded decimal representing the amount of fee in XRD paid by this vault. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
    #[serde(rename = "xrd_amount")]
    pub xrd_amount: String,
}

impl VaultPayment {
    pub fn new(vault_entity: crate::core_api::generated::models::EntityReference, xrd_amount: String) -> VaultPayment {
        VaultPayment {
            vault_entity: Box::new(vault_entity),
            xrd_amount,
        }
    }
}


