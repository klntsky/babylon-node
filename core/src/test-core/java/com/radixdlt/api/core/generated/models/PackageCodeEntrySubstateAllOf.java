/*
 * Babylon Core API - RCnet V2
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.radixdlt.api.core.generated.models;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.VmType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * PackageCodeEntrySubstateAllOf
 */
@JsonPropertyOrder({
  PackageCodeEntrySubstateAllOf.JSON_PROPERTY_CODE_HASH,
  PackageCodeEntrySubstateAllOf.JSON_PROPERTY_VM_TYPE,
  PackageCodeEntrySubstateAllOf.JSON_PROPERTY_CODE_HEX
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class PackageCodeEntrySubstateAllOf {
  public static final String JSON_PROPERTY_CODE_HASH = "code_hash";
  private String codeHash;

  public static final String JSON_PROPERTY_VM_TYPE = "vm_type";
  private VmType vmType;

  public static final String JSON_PROPERTY_CODE_HEX = "code_hex";
  private String codeHex;

  public PackageCodeEntrySubstateAllOf() { 
  }

  public PackageCodeEntrySubstateAllOf codeHash(String codeHash) {
    this.codeHash = codeHash;
    return this;
  }

   /**
   * The hex-encoded code hash, capturing the vm-type and the code itself.
   * @return codeHash
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded code hash, capturing the vm-type and the code itself.")
  @JsonProperty(JSON_PROPERTY_CODE_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCodeHash() {
    return codeHash;
  }


  @JsonProperty(JSON_PROPERTY_CODE_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCodeHash(String codeHash) {
    this.codeHash = codeHash;
  }


  public PackageCodeEntrySubstateAllOf vmType(VmType vmType) {
    this.vmType = vmType;
    return this;
  }

   /**
   * Get vmType
   * @return vmType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_VM_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public VmType getVmType() {
    return vmType;
  }


  @JsonProperty(JSON_PROPERTY_VM_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setVmType(VmType vmType) {
    this.vmType = vmType;
  }


  public PackageCodeEntrySubstateAllOf codeHex(String codeHex) {
    this.codeHex = codeHex;
    return this;
  }

   /**
   * Either the hex-encoded WASM package code (if Scrypto), or the native package identifier. 
   * @return codeHex
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Either the hex-encoded WASM package code (if Scrypto), or the native package identifier. ")
  @JsonProperty(JSON_PROPERTY_CODE_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCodeHex() {
    return codeHex;
  }


  @JsonProperty(JSON_PROPERTY_CODE_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCodeHex(String codeHex) {
    this.codeHex = codeHex;
  }


  /**
   * Return true if this PackageCodeEntrySubstate_allOf object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PackageCodeEntrySubstateAllOf packageCodeEntrySubstateAllOf = (PackageCodeEntrySubstateAllOf) o;
    return Objects.equals(this.codeHash, packageCodeEntrySubstateAllOf.codeHash) &&
        Objects.equals(this.vmType, packageCodeEntrySubstateAllOf.vmType) &&
        Objects.equals(this.codeHex, packageCodeEntrySubstateAllOf.codeHex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codeHash, vmType, codeHex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PackageCodeEntrySubstateAllOf {\n");
    sb.append("    codeHash: ").append(toIndentedString(codeHash)).append("\n");
    sb.append("    vmType: ").append(toIndentedString(vmType)).append("\n");
    sb.append("    codeHex: ").append(toIndentedString(codeHex)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

