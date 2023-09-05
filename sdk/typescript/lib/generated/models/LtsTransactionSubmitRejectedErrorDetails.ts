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

/**
 * 
 * @export
 * @interface LtsTransactionSubmitRejectedErrorDetails
 */
export interface LtsTransactionSubmitRejectedErrorDetails {
    /**
     * 
     * @type {string}
     * @memberof LtsTransactionSubmitRejectedErrorDetails
     */
    type: LtsTransactionSubmitRejectedErrorDetailsTypeEnum;
    /**
     * An explanation of the error
     * @type {string}
     * @memberof LtsTransactionSubmitRejectedErrorDetails
     */
    error_message: string;
    /**
     * Whether (true) this rejected status has just been calculated fresh, or (false) the status is from the pending
     * transaction result cache.
     * @type {boolean}
     * @memberof LtsTransactionSubmitRejectedErrorDetails
     */
    is_fresh: boolean;
    /**
     * Whether the rejection of this payload is known to be permanent.
     * @type {boolean}
     * @memberof LtsTransactionSubmitRejectedErrorDetails
     */
    is_payload_rejection_permanent: boolean;
    /**
     * Whether the rejection of this intent is known to be permanent - this is a stronger statement than the payload rejection
     * being permanent, as it implies any payloads containing the intent will also be permanently rejected.
     * @type {boolean}
     * @memberof LtsTransactionSubmitRejectedErrorDetails
     */
    is_intent_rejection_permanent: boolean;
    /**
     * 
     * @type {Instant}
     * @memberof LtsTransactionSubmitRejectedErrorDetails
     */
    retry_from_timestamp?: Instant;
    /**
     * An integer between `0` and `10^10`, marking the epoch after which the node will consider recalculating the validity of the transaction.
     * Only present if the rejection is temporary due to a header specifying a "from epoch" in the future.
     * @type {number}
     * @memberof LtsTransactionSubmitRejectedErrorDetails
     */
    retry_from_epoch?: number;
    /**
     * An integer between `0` and `10^10`, marking the epoch from which the transaction will no longer be valid, and be permanently rejected.
     * Only present if the rejection isn't permanent.
     * @type {number}
     * @memberof LtsTransactionSubmitRejectedErrorDetails
     */
    invalid_from_epoch?: number;
}


/**
 * @export
 */
export const LtsTransactionSubmitRejectedErrorDetailsTypeEnum = {
    Rejected: 'Rejected'
} as const;
export type LtsTransactionSubmitRejectedErrorDetailsTypeEnum = typeof LtsTransactionSubmitRejectedErrorDetailsTypeEnum[keyof typeof LtsTransactionSubmitRejectedErrorDetailsTypeEnum];


/**
 * Check if a given object implements the LtsTransactionSubmitRejectedErrorDetails interface.
 */
export function instanceOfLtsTransactionSubmitRejectedErrorDetails(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "type" in value;
    isInstance = isInstance && "error_message" in value;
    isInstance = isInstance && "is_fresh" in value;
    isInstance = isInstance && "is_payload_rejection_permanent" in value;
    isInstance = isInstance && "is_intent_rejection_permanent" in value;

    return isInstance;
}

export function LtsTransactionSubmitRejectedErrorDetailsFromJSON(json: any): LtsTransactionSubmitRejectedErrorDetails {
    return LtsTransactionSubmitRejectedErrorDetailsFromJSONTyped(json, false);
}

export function LtsTransactionSubmitRejectedErrorDetailsFromJSONTyped(json: any, ignoreDiscriminator: boolean): LtsTransactionSubmitRejectedErrorDetails {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'type': json['type'],
        'error_message': json['error_message'],
        'is_fresh': json['is_fresh'],
        'is_payload_rejection_permanent': json['is_payload_rejection_permanent'],
        'is_intent_rejection_permanent': json['is_intent_rejection_permanent'],
        'retry_from_timestamp': !exists(json, 'retry_from_timestamp') ? undefined : InstantFromJSON(json['retry_from_timestamp']),
        'retry_from_epoch': !exists(json, 'retry_from_epoch') ? undefined : json['retry_from_epoch'],
        'invalid_from_epoch': !exists(json, 'invalid_from_epoch') ? undefined : json['invalid_from_epoch'],
    };
}

export function LtsTransactionSubmitRejectedErrorDetailsToJSON(value?: LtsTransactionSubmitRejectedErrorDetails | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'type': value.type,
        'error_message': value.error_message,
        'is_fresh': value.is_fresh,
        'is_payload_rejection_permanent': value.is_payload_rejection_permanent,
        'is_intent_rejection_permanent': value.is_intent_rejection_permanent,
        'retry_from_timestamp': InstantToJSON(value.retry_from_timestamp),
        'retry_from_epoch': value.retry_from_epoch,
        'invalid_from_epoch': value.invalid_from_epoch,
    };
}

