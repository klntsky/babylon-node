/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API - Babylon (Anemone)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { AddressType } from './AddressType';
import {
    AddressTypeFromJSON,
    AddressTypeFromJSONTyped,
    AddressTypeToJSON,
} from './AddressType';
import type { NetworkConfigurationResponseVersion } from './NetworkConfigurationResponseVersion';
import {
    NetworkConfigurationResponseVersionFromJSON,
    NetworkConfigurationResponseVersionFromJSONTyped,
    NetworkConfigurationResponseVersionToJSON,
} from './NetworkConfigurationResponseVersion';
import type { NetworkConfigurationResponseWellKnownAddresses } from './NetworkConfigurationResponseWellKnownAddresses';
import {
    NetworkConfigurationResponseWellKnownAddressesFromJSON,
    NetworkConfigurationResponseWellKnownAddressesFromJSONTyped,
    NetworkConfigurationResponseWellKnownAddressesToJSON,
} from './NetworkConfigurationResponseWellKnownAddresses';

/**
 * 
 * @export
 * @interface NetworkConfigurationResponse
 */
export interface NetworkConfigurationResponse {
    /**
     * 
     * @type {NetworkConfigurationResponseVersion}
     * @memberof NetworkConfigurationResponse
     */
    version: NetworkConfigurationResponseVersion;
    /**
     * The logical name of the network
     * @type {string}
     * @memberof NetworkConfigurationResponse
     */
    network: string;
    /**
     * The logical id of the network
     * @type {number}
     * @memberof NetworkConfigurationResponse
     */
    network_id: number;
    /**
     * The network suffix used for Bech32m HRPs used for addressing.
     * @type {string}
     * @memberof NetworkConfigurationResponse
     */
    network_hrp_suffix: string;
    /**
     * The current value of the protocol-based USD/XRD multiplier (i.e. an amount of XRDs to be paid for 1 USD).
     * A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`.
     * @type {string}
     * @memberof NetworkConfigurationResponse
     */
    usd_price_in_xrd: string;
    /**
     * 
     * @type {Array<AddressType>}
     * @memberof NetworkConfigurationResponse
     */
    address_types: Array<AddressType>;
    /**
     * 
     * @type {NetworkConfigurationResponseWellKnownAddresses}
     * @memberof NetworkConfigurationResponse
     */
    well_known_addresses: NetworkConfigurationResponseWellKnownAddresses;
}

/**
 * Check if a given object implements the NetworkConfigurationResponse interface.
 */
export function instanceOfNetworkConfigurationResponse(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "version" in value;
    isInstance = isInstance && "network" in value;
    isInstance = isInstance && "network_id" in value;
    isInstance = isInstance && "network_hrp_suffix" in value;
    isInstance = isInstance && "usd_price_in_xrd" in value;
    isInstance = isInstance && "address_types" in value;
    isInstance = isInstance && "well_known_addresses" in value;

    return isInstance;
}

export function NetworkConfigurationResponseFromJSON(json: any): NetworkConfigurationResponse {
    return NetworkConfigurationResponseFromJSONTyped(json, false);
}

export function NetworkConfigurationResponseFromJSONTyped(json: any, ignoreDiscriminator: boolean): NetworkConfigurationResponse {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'version': NetworkConfigurationResponseVersionFromJSON(json['version']),
        'network': json['network'],
        'network_id': json['network_id'],
        'network_hrp_suffix': json['network_hrp_suffix'],
        'usd_price_in_xrd': json['usd_price_in_xrd'],
        'address_types': ((json['address_types'] as Array<any>).map(AddressTypeFromJSON)),
        'well_known_addresses': NetworkConfigurationResponseWellKnownAddressesFromJSON(json['well_known_addresses']),
    };
}

export function NetworkConfigurationResponseToJSON(value?: NetworkConfigurationResponse | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'version': NetworkConfigurationResponseVersionToJSON(value.version),
        'network': value.network,
        'network_id': value.network_id,
        'network_hrp_suffix': value.network_hrp_suffix,
        'usd_price_in_xrd': value.usd_price_in_xrd,
        'address_types': ((value.address_types as Array<any>).map(AddressTypeToJSON)),
        'well_known_addresses': NetworkConfigurationResponseWellKnownAddressesToJSON(value.well_known_addresses),
    };
}

