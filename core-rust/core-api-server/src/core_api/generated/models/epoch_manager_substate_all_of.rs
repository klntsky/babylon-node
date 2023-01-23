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
pub struct EpochManagerSubstateAllOf {
    /// The Bech32m-encoded human readable version of the system address
    #[serde(rename = "address")]
    pub address: String,
    /// An integer between `0` and `10^10`, marking the current epoch
    #[serde(rename = "epoch")]
    pub epoch: i64,
    /// An integer between `0` and `10^10`, marking the current round in an epoch
    #[serde(rename = "round")]
    pub round: i64,
    /// An integer between `0` and `10^10`, specifying the number of rounds per epoch
    #[serde(rename = "rounds_per_epoch")]
    pub rounds_per_epoch: i64,
}

impl EpochManagerSubstateAllOf {
    pub fn new(address: String, epoch: i64, round: i64, rounds_per_epoch: i64) -> EpochManagerSubstateAllOf {
        EpochManagerSubstateAllOf {
            address,
            epoch,
            round,
            rounds_per_epoch,
        }
    }
}


