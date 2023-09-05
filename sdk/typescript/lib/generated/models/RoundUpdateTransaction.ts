/* tslint:disable */
/* eslint-disable */
/**
 * Babylon Core API - RCnet v3.1
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the fourth release candidate of the Radix Babylon network (\"RCnet v3.1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { Instant } from './Instant';
import {
    InstantFromJSON,
    InstantFromJSONTyped,
    InstantToJSON,
} from './Instant';
import type { LeaderProposalHistory } from './LeaderProposalHistory';
import {
    LeaderProposalHistoryFromJSON,
    LeaderProposalHistoryFromJSONTyped,
    LeaderProposalHistoryToJSON,
} from './LeaderProposalHistory';

/**
 * 
 * @export
 * @interface RoundUpdateTransaction
 */
export interface RoundUpdateTransaction {
    /**
     * 
     * @type {Instant}
     * @memberof RoundUpdateTransaction
     */
    proposer_timestamp: Instant;
    /**
     * An integer between `0` and `10^10`, marking the epoch.
     * @type {number}
     * @memberof RoundUpdateTransaction
     */
    epoch: number;
    /**
     * An integer between `0` and `10^10`, marking the consensus round in the epoch
     * @type {number}
     * @memberof RoundUpdateTransaction
     */
    round_in_epoch: number;
    /**
     * 
     * @type {LeaderProposalHistory}
     * @memberof RoundUpdateTransaction
     */
    leader_proposal_history: LeaderProposalHistory;
}

/**
 * Check if a given object implements the RoundUpdateTransaction interface.
 */
export function instanceOfRoundUpdateTransaction(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "proposer_timestamp" in value;
    isInstance = isInstance && "epoch" in value;
    isInstance = isInstance && "round_in_epoch" in value;
    isInstance = isInstance && "leader_proposal_history" in value;

    return isInstance;
}

export function RoundUpdateTransactionFromJSON(json: any): RoundUpdateTransaction {
    return RoundUpdateTransactionFromJSONTyped(json, false);
}

export function RoundUpdateTransactionFromJSONTyped(json: any, ignoreDiscriminator: boolean): RoundUpdateTransaction {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'proposer_timestamp': InstantFromJSON(json['proposer_timestamp']),
        'epoch': json['epoch'],
        'round_in_epoch': json['round_in_epoch'],
        'leader_proposal_history': LeaderProposalHistoryFromJSON(json['leader_proposal_history']),
    };
}

export function RoundUpdateTransactionToJSON(value?: RoundUpdateTransaction | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'proposer_timestamp': InstantToJSON(value.proposer_timestamp),
        'epoch': value.epoch,
        'round_in_epoch': value.round_in_epoch,
        'leader_proposal_history': LeaderProposalHistoryToJSON(value.leader_proposal_history),
    };
}

