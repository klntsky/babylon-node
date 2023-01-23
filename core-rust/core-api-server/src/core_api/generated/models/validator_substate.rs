/*
 * Babylon Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.2.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct ValidatorSubstate {
    #[serde(rename = "substate_type")]
    pub substate_type: crate::core_api::generated::models::SubstateType,
    /// The Bech32m-encoded human readable version of the system address
    #[serde(rename = "manager")]
    pub manager: String,
    /// The Bech32m-encoded human readable version of the system address
    #[serde(rename = "address")]
    pub address: String,
    #[serde(rename = "key")]
    pub key: Box<crate::core_api::generated::models::EcdsaSecp256k1PublicKey>,
}

impl ValidatorSubstate {
    pub fn new(substate_type: crate::core_api::generated::models::SubstateType, manager: String, address: String, key: crate::core_api::generated::models::EcdsaSecp256k1PublicKey) -> ValidatorSubstate {
        ValidatorSubstate {
            substate_type,
            manager,
            address,
            key: Box::new(key),
        }
    }
}


