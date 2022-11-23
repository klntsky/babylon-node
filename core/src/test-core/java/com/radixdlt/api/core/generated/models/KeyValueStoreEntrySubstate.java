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
import com.radixdlt.api.core.generated.models.DataStruct;
import com.radixdlt.api.core.generated.models.EntityType;
import com.radixdlt.api.core.generated.models.KeyValueStoreEntrySubstateAllOf;
import com.radixdlt.api.core.generated.models.SubstateBase;
import com.radixdlt.api.core.generated.models.SubstateType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * KeyValueStoreEntrySubstate
 */
@JsonPropertyOrder({
  KeyValueStoreEntrySubstate.JSON_PROPERTY_ENTITY_TYPE,
  KeyValueStoreEntrySubstate.JSON_PROPERTY_SUBSTATE_TYPE,
  KeyValueStoreEntrySubstate.JSON_PROPERTY_KEY_HEX,
  KeyValueStoreEntrySubstate.JSON_PROPERTY_IS_DELETED,
  KeyValueStoreEntrySubstate.JSON_PROPERTY_DATA_STRUCT
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class KeyValueStoreEntrySubstate {
  public static final String JSON_PROPERTY_ENTITY_TYPE = "entity_type";
  private EntityType entityType;

  public static final String JSON_PROPERTY_SUBSTATE_TYPE = "substate_type";
  private SubstateType substateType;

  public static final String JSON_PROPERTY_KEY_HEX = "key_hex";
  private String keyHex;

  public static final String JSON_PROPERTY_IS_DELETED = "is_deleted";
  private Boolean isDeleted;

  public static final String JSON_PROPERTY_DATA_STRUCT = "data_struct";
  private DataStruct dataStruct;

  public KeyValueStoreEntrySubstate() { 
  }

  public KeyValueStoreEntrySubstate entityType(EntityType entityType) {
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


  public KeyValueStoreEntrySubstate substateType(SubstateType substateType) {
    this.substateType = substateType;
    return this;
  }

   /**
   * Get substateType
   * @return substateType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SUBSTATE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SubstateType getSubstateType() {
    return substateType;
  }


  @JsonProperty(JSON_PROPERTY_SUBSTATE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSubstateType(SubstateType substateType) {
    this.substateType = substateType;
  }


  public KeyValueStoreEntrySubstate keyHex(String keyHex) {
    this.keyHex = keyHex;
    return this;
  }

   /**
   * The hex-encoded bytes of its key
   * @return keyHex
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded bytes of its key")
  @JsonProperty(JSON_PROPERTY_KEY_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getKeyHex() {
    return keyHex;
  }


  @JsonProperty(JSON_PROPERTY_KEY_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKeyHex(String keyHex) {
    this.keyHex = keyHex;
  }


  public KeyValueStoreEntrySubstate isDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
    return this;
  }

   /**
   * Get isDeleted
   * @return isDeleted
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_IS_DELETED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getIsDeleted() {
    return isDeleted;
  }


  @JsonProperty(JSON_PROPERTY_IS_DELETED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }


  public KeyValueStoreEntrySubstate dataStruct(DataStruct dataStruct) {
    this.dataStruct = dataStruct;
    return this;
  }

   /**
   * Get dataStruct
   * @return dataStruct
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DATA_STRUCT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public DataStruct getDataStruct() {
    return dataStruct;
  }


  @JsonProperty(JSON_PROPERTY_DATA_STRUCT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDataStruct(DataStruct dataStruct) {
    this.dataStruct = dataStruct;
  }


  /**
   * Return true if this KeyValueStoreEntrySubstate object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeyValueStoreEntrySubstate keyValueStoreEntrySubstate = (KeyValueStoreEntrySubstate) o;
    return Objects.equals(this.entityType, keyValueStoreEntrySubstate.entityType) &&
        Objects.equals(this.substateType, keyValueStoreEntrySubstate.substateType) &&
        Objects.equals(this.keyHex, keyValueStoreEntrySubstate.keyHex) &&
        Objects.equals(this.isDeleted, keyValueStoreEntrySubstate.isDeleted) &&
        Objects.equals(this.dataStruct, keyValueStoreEntrySubstate.dataStruct);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entityType, substateType, keyHex, isDeleted, dataStruct);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeyValueStoreEntrySubstate {\n");
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
    sb.append("    substateType: ").append(toIndentedString(substateType)).append("\n");
    sb.append("    keyHex: ").append(toIndentedString(keyHex)).append("\n");
    sb.append("    isDeleted: ").append(toIndentedString(isDeleted)).append("\n");
    sb.append("    dataStruct: ").append(toIndentedString(dataStruct)).append("\n");
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

