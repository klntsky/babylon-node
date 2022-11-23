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
import com.radixdlt.api.core.generated.models.ResourceType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ResourceAmountBase
 */
@JsonPropertyOrder({
  ResourceAmountBase.JSON_PROPERTY_RESOURCE_TYPE,
  ResourceAmountBase.JSON_PROPERTY_RESOURCE_ADDRESS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ResourceAmountBase {
  public static final String JSON_PROPERTY_RESOURCE_TYPE = "resource_type";
  private ResourceType resourceType;

  public static final String JSON_PROPERTY_RESOURCE_ADDRESS = "resource_address";
  private String resourceAddress;

  public ResourceAmountBase() { 
  }

  public ResourceAmountBase resourceType(ResourceType resourceType) {
    this.resourceType = resourceType;
    return this;
  }

   /**
   * Get resourceType
   * @return resourceType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ResourceType getResourceType() {
    return resourceType;
  }


  @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResourceType(ResourceType resourceType) {
    this.resourceType = resourceType;
  }


  public ResourceAmountBase resourceAddress(String resourceAddress) {
    this.resourceAddress = resourceAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the resource address
   * @return resourceAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the resource address")
  @JsonProperty(JSON_PROPERTY_RESOURCE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getResourceAddress() {
    return resourceAddress;
  }


  @JsonProperty(JSON_PROPERTY_RESOURCE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResourceAddress(String resourceAddress) {
    this.resourceAddress = resourceAddress;
  }


  /**
   * Return true if this ResourceAmountBase object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceAmountBase resourceAmountBase = (ResourceAmountBase) o;
    return Objects.equals(this.resourceType, resourceAmountBase.resourceType) &&
        Objects.equals(this.resourceAddress, resourceAmountBase.resourceAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourceType, resourceAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceAmountBase {\n");
    sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
    sb.append("    resourceAddress: ").append(toIndentedString(resourceAddress)).append("\n");
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

