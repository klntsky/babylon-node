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
import type { BlueprintPayloadDef } from './BlueprintPayloadDef';
import {
    BlueprintPayloadDefFromJSON,
    BlueprintPayloadDefFromJSONTyped,
    BlueprintPayloadDefToJSON,
} from './BlueprintPayloadDef';

/**
 * 
 * @export
 * @interface SortedIndexBlueprintCollectionSchema
 */
export interface SortedIndexBlueprintCollectionSchema {
    /**
     * 
     * @type {string}
     * @memberof SortedIndexBlueprintCollectionSchema
     */
    type: SortedIndexBlueprintCollectionSchemaTypeEnum;
    /**
     * 
     * @type {BlueprintPayloadDef}
     * @memberof SortedIndexBlueprintCollectionSchema
     */
    key_type_ref: BlueprintPayloadDef;
    /**
     * 
     * @type {BlueprintPayloadDef}
     * @memberof SortedIndexBlueprintCollectionSchema
     */
    value_type_ref: BlueprintPayloadDef;
    /**
     * Whether the entries of the sorted index partition are allowed to own child nodes.
     * @type {boolean}
     * @memberof SortedIndexBlueprintCollectionSchema
     */
    allow_ownership: boolean;
}


/**
 * @export
 */
export const SortedIndexBlueprintCollectionSchemaTypeEnum = {
    SortedIndex: 'SortedIndex'
} as const;
export type SortedIndexBlueprintCollectionSchemaTypeEnum = typeof SortedIndexBlueprintCollectionSchemaTypeEnum[keyof typeof SortedIndexBlueprintCollectionSchemaTypeEnum];


/**
 * Check if a given object implements the SortedIndexBlueprintCollectionSchema interface.
 */
export function instanceOfSortedIndexBlueprintCollectionSchema(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "type" in value;
    isInstance = isInstance && "key_type_ref" in value;
    isInstance = isInstance && "value_type_ref" in value;
    isInstance = isInstance && "allow_ownership" in value;

    return isInstance;
}

export function SortedIndexBlueprintCollectionSchemaFromJSON(json: any): SortedIndexBlueprintCollectionSchema {
    return SortedIndexBlueprintCollectionSchemaFromJSONTyped(json, false);
}

export function SortedIndexBlueprintCollectionSchemaFromJSONTyped(json: any, ignoreDiscriminator: boolean): SortedIndexBlueprintCollectionSchema {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'type': json['type'],
        'key_type_ref': BlueprintPayloadDefFromJSON(json['key_type_ref']),
        'value_type_ref': BlueprintPayloadDefFromJSON(json['value_type_ref']),
        'allow_ownership': json['allow_ownership'],
    };
}

export function SortedIndexBlueprintCollectionSchemaToJSON(value?: SortedIndexBlueprintCollectionSchema | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'type': value.type,
        'key_type_ref': BlueprintPayloadDefToJSON(value.key_type_ref),
        'value_type_ref': BlueprintPayloadDefToJSON(value.value_type_ref),
        'allow_ownership': value.allow_ownership,
    };
}

