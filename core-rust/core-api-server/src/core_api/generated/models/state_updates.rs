/*
 * Babylon Core API - RCnet v3.1
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the fourth release candidate of the Radix Babylon network (\"RCnet v3.1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.1
 * 
 * Generated by: https://openapi-generator.tech
 */

/// StateUpdates : Transaction state updates (only present if status is Succeeded or Failed)



#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct StateUpdates {
    #[serde(rename = "created_substates")]
    pub created_substates: Vec<crate::core_api::generated::models::CreatedSubstate>,
    #[serde(rename = "updated_substates")]
    pub updated_substates: Vec<crate::core_api::generated::models::UpdatedSubstate>,
    #[serde(rename = "deleted_substates")]
    pub deleted_substates: Vec<crate::core_api::generated::models::DeletedSubstate>,
    #[serde(rename = "new_global_entities")]
    pub new_global_entities: Vec<crate::core_api::generated::models::EntityReference>,
}

impl StateUpdates {
    /// Transaction state updates (only present if status is Succeeded or Failed)
    pub fn new(created_substates: Vec<crate::core_api::generated::models::CreatedSubstate>, updated_substates: Vec<crate::core_api::generated::models::UpdatedSubstate>, deleted_substates: Vec<crate::core_api::generated::models::DeletedSubstate>, new_global_entities: Vec<crate::core_api::generated::models::EntityReference>) -> StateUpdates {
        StateUpdates {
            created_substates,
            updated_substates,
            deleted_substates,
            new_global_entities,
        }
    }
}


