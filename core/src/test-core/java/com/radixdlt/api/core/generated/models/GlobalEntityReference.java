/*
 * Babylon Core API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.1.0
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
import com.radixdlt.api.core.generated.models.EntityType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * GlobalEntityReference
 */
@JsonPropertyOrder({
  GlobalEntityReference.JSON_PROPERTY_ENTITY_TYPE,
  GlobalEntityReference.JSON_PROPERTY_GLOBAL_ADDRESS_HEX,
  GlobalEntityReference.JSON_PROPERTY_GLOBAL_ADDRESS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class GlobalEntityReference {
  public static final String JSON_PROPERTY_ENTITY_TYPE = "entity_type";
  private EntityType entityType;

  public static final String JSON_PROPERTY_GLOBAL_ADDRESS_HEX = "global_address_hex";
  private String globalAddressHex;

  public static final String JSON_PROPERTY_GLOBAL_ADDRESS = "global_address";
  private String globalAddress;

  public GlobalEntityReference() { 
  }

  public GlobalEntityReference entityType(EntityType entityType) {
    this.entityType = entityType;
    return this;
  }

   /**
   * Get entityType
   * @return entityType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ENTITY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EntityType getEntityType() {
    return entityType;
  }


  @JsonProperty(JSON_PROPERTY_ENTITY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEntityType(EntityType entityType) {
    this.entityType = entityType;
  }


  public GlobalEntityReference globalAddressHex(String globalAddressHex) {
    this.globalAddressHex = globalAddressHex;
    return this;
  }

   /**
   * The hex-encoded bytes of the entity&#39;s global address
   * @return globalAddressHex
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded bytes of the entity's global address")
  @JsonProperty(JSON_PROPERTY_GLOBAL_ADDRESS_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getGlobalAddressHex() {
    return globalAddressHex;
  }


  @JsonProperty(JSON_PROPERTY_GLOBAL_ADDRESS_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGlobalAddressHex(String globalAddressHex) {
    this.globalAddressHex = globalAddressHex;
  }


  public GlobalEntityReference globalAddress(String globalAddress) {
    this.globalAddress = globalAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the entity&#39;s global address
   * @return globalAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the entity's global address")
  @JsonProperty(JSON_PROPERTY_GLOBAL_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getGlobalAddress() {
    return globalAddress;
  }


  @JsonProperty(JSON_PROPERTY_GLOBAL_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGlobalAddress(String globalAddress) {
    this.globalAddress = globalAddress;
  }


  /**
   * Return true if this GlobalEntityReference object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GlobalEntityReference globalEntityReference = (GlobalEntityReference) o;
    return Objects.equals(this.entityType, globalEntityReference.entityType) &&
        Objects.equals(this.globalAddressHex, globalEntityReference.globalAddressHex) &&
        Objects.equals(this.globalAddress, globalEntityReference.globalAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entityType, globalAddressHex, globalAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GlobalEntityReference {\n");
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
    sb.append("    globalAddressHex: ").append(toIndentedString(globalAddressHex)).append("\n");
    sb.append("    globalAddress: ").append(toIndentedString(globalAddress)).append("\n");
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

