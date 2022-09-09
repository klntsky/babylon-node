/*
 * Babylon Core API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.1.0
 * 
 * Generated by: https://openapi-generator.tech
 */



#[derive(Clone, Debug, PartialEq, serde::Serialize, serde::Deserialize)]
#[serde(tag = "substate_type")]
pub enum Substate {
    #[serde(rename="ComponentInfo")]
    ComponentInfoSubstate {
        #[serde(rename = "entity_type")]
        entity_type: crate::core_api::generated::models::EntityType,
        /// Package address, Bech32m-encoded.
        #[serde(rename = "package_address")]
        package_address: String,
        #[serde(rename = "blueprint_name")]
        blueprint_name: String,
    },
    #[serde(rename="ComponentState")]
    ComponentStateSubstate {
        #[serde(rename = "entity_type")]
        entity_type: crate::core_api::generated::models::EntityType,
        /// Hex-encoded SBOR-encoded state data
        #[serde(rename = "state_bytes")]
        state_bytes: String,
        #[serde(rename = "data_struct")]
        data_struct: Box<crate::core_api::generated::models::DataStruct>,
    },
    #[serde(rename="KeyValueStoreEntry")]
    KeyValueStoreEntrySubstate {
        #[serde(rename = "entity_type")]
        entity_type: crate::core_api::generated::models::EntityType,
        /// Hex-encoded bytes of its key
        #[serde(rename = "key")]
        key: String,
        #[serde(rename = "is_deleted")]
        is_deleted: bool,
        #[serde(rename = "data_struct", skip_serializing_if = "Option::is_none")]
        data_struct: Option<Box<crate::core_api::generated::models::DataStruct>>,
    },
    #[serde(rename="NonFungible")]
    NonFungibleSubstate {
        #[serde(rename = "entity_type")]
        entity_type: crate::core_api::generated::models::EntityType,
        /// Hex-encoded bytes of its non-fungible id
        #[serde(rename = "nf_id")]
        nf_id: String,
        #[serde(rename = "is_deleted")]
        is_deleted: bool,
        #[serde(rename = "non_fungible_data", skip_serializing_if = "Option::is_none")]
        non_fungible_data: Option<Box<crate::core_api::generated::models::NonFungibleData>>,
    },
    #[serde(rename="Package")]
    PackageSubstate {
        #[serde(rename = "entity_type")]
        entity_type: crate::core_api::generated::models::EntityType,
        /// Package code, hex-encoded.
        #[serde(rename = "code")]
        code: String,
    },
    #[serde(rename="ResourceManager")]
    ResourceManagerSubstate {
        #[serde(rename = "entity_type")]
        entity_type: crate::core_api::generated::models::EntityType,
        #[serde(rename = "resource_type")]
        resource_type: crate::core_api::generated::models::ResourceType,
        #[serde(rename = "fungible_divisibility", skip_serializing_if = "Option::is_none")]
        fungible_divisibility: Option<i32>,
        #[serde(rename = "metadata")]
        metadata: Vec<crate::core_api::generated::models::ResourceManagerSubstateAllOfMetadata>,
        #[serde(rename = "total_supply")]
        total_supply: String,
    },
    #[serde(rename="System")]
    SystemSubstate {
        #[serde(rename = "entity_type")]
        entity_type: crate::core_api::generated::models::EntityType,
        #[serde(rename = "epoch")]
        epoch: i64,
    },
    #[serde(rename="Vault")]
    VaultSubstate {
        #[serde(rename = "entity_type")]
        entity_type: crate::core_api::generated::models::EntityType,
        #[serde(rename = "resource_amount")]
        resource_amount: Box<crate::core_api::generated::models::ResourceAmount>,
    },
}




