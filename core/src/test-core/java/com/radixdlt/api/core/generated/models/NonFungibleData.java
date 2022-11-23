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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Only present if the non fungible isn&#39;t deleted
 */
@ApiModel(description = "Only present if the non fungible isn't deleted")
@JsonPropertyOrder({
  NonFungibleData.JSON_PROPERTY_IMMUTABLE_DATA,
  NonFungibleData.JSON_PROPERTY_MUTABLE_DATA
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class NonFungibleData {
  public static final String JSON_PROPERTY_IMMUTABLE_DATA = "immutable_data";
  private DataStruct immutableData;

  public static final String JSON_PROPERTY_MUTABLE_DATA = "mutable_data";
  private DataStruct mutableData;

  public NonFungibleData() { 
  }

  public NonFungibleData immutableData(DataStruct immutableData) {
    this.immutableData = immutableData;
    return this;
  }

   /**
   * Get immutableData
   * @return immutableData
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_IMMUTABLE_DATA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public DataStruct getImmutableData() {
    return immutableData;
  }


  @JsonProperty(JSON_PROPERTY_IMMUTABLE_DATA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setImmutableData(DataStruct immutableData) {
    this.immutableData = immutableData;
  }


  public NonFungibleData mutableData(DataStruct mutableData) {
    this.mutableData = mutableData;
    return this;
  }

   /**
   * Get mutableData
   * @return mutableData
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_MUTABLE_DATA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public DataStruct getMutableData() {
    return mutableData;
  }


  @JsonProperty(JSON_PROPERTY_MUTABLE_DATA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMutableData(DataStruct mutableData) {
    this.mutableData = mutableData;
  }


  /**
   * Return true if this NonFungibleData object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NonFungibleData nonFungibleData = (NonFungibleData) o;
    return Objects.equals(this.immutableData, nonFungibleData.immutableData) &&
        Objects.equals(this.mutableData, nonFungibleData.mutableData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(immutableData, mutableData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NonFungibleData {\n");
    sb.append("    immutableData: ").append(toIndentedString(immutableData)).append("\n");
    sb.append("    mutableData: ").append(toIndentedString(mutableData)).append("\n");
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

