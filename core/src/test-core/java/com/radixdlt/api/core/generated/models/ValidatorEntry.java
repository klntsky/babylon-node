/*
 * Babylon Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.2.0
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
import com.radixdlt.api.core.generated.models.Validator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ValidatorEntry
 */
@JsonPropertyOrder({
  ValidatorEntry.JSON_PROPERTY_ADDRESS,
  ValidatorEntry.JSON_PROPERTY_VALIDATOR
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ValidatorEntry {
  public static final String JSON_PROPERTY_ADDRESS = "address";
  private String address;

  public static final String JSON_PROPERTY_VALIDATOR = "validator";
  private Validator validator;

  public ValidatorEntry() { 
  }

  public ValidatorEntry address(String address) {
    this.address = address;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the component address
   * @return address
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the component address")
  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getAddress() {
    return address;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAddress(String address) {
    this.address = address;
  }


  public ValidatorEntry validator(Validator validator) {
    this.validator = validator;
    return this;
  }

   /**
   * Get validator
   * @return validator
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_VALIDATOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Validator getValidator() {
    return validator;
  }


  @JsonProperty(JSON_PROPERTY_VALIDATOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValidator(Validator validator) {
    this.validator = validator;
  }


  /**
   * Return true if this ValidatorEntry object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidatorEntry validatorEntry = (ValidatorEntry) o;
    return Objects.equals(this.address, validatorEntry.address) &&
        Objects.equals(this.validator, validatorEntry.validator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, validator);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidatorEntry {\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    validator: ").append(toIndentedString(validator)).append("\n");
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

