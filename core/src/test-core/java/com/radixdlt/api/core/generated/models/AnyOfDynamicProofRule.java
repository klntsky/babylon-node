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
import com.radixdlt.api.core.generated.models.AllOfDynamicProofRuleAllOf;
import com.radixdlt.api.core.generated.models.DynamicProofRuleBase;
import com.radixdlt.api.core.generated.models.DynamicProofRuleType;
import com.radixdlt.api.core.generated.models.DynamicResourceDescriptorList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * AnyOfDynamicProofRule
 */
@JsonPropertyOrder({
  AnyOfDynamicProofRule.JSON_PROPERTY_TYPE,
  AnyOfDynamicProofRule.JSON_PROPERTY_LIST
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class AnyOfDynamicProofRule {
  public static final String JSON_PROPERTY_TYPE = "type";
  private DynamicProofRuleType type;

  public static final String JSON_PROPERTY_LIST = "list";
  private DynamicResourceDescriptorList _list;

  public AnyOfDynamicProofRule() { 
  }

  public AnyOfDynamicProofRule type(DynamicProofRuleType type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public DynamicProofRuleType getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(DynamicProofRuleType type) {
    this.type = type;
  }


  public AnyOfDynamicProofRule _list(DynamicResourceDescriptorList _list) {
    this._list = _list;
    return this;
  }

   /**
   * Get _list
   * @return _list
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_LIST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public DynamicResourceDescriptorList getList() {
    return _list;
  }


  @JsonProperty(JSON_PROPERTY_LIST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setList(DynamicResourceDescriptorList _list) {
    this._list = _list;
  }


  /**
   * Return true if this AnyOfDynamicProofRule object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnyOfDynamicProofRule anyOfDynamicProofRule = (AnyOfDynamicProofRule) o;
    return Objects.equals(this.type, anyOfDynamicProofRule.type) &&
        Objects.equals(this._list, anyOfDynamicProofRule._list);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, _list);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnyOfDynamicProofRule {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    _list: ").append(toIndentedString(_list)).append("\n");
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

