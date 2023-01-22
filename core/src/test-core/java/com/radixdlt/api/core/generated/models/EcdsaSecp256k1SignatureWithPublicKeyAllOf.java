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
import com.radixdlt.api.core.generated.models.EcdsaSecp256k1Signature;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Because ECDSA has recoverable signatures, this only includes a signature
 */
@ApiModel(description = "Because ECDSA has recoverable signatures, this only includes a signature")
@JsonPropertyOrder({
  EcdsaSecp256k1SignatureWithPublicKeyAllOf.JSON_PROPERTY_RECOVERABLE_SIGNATURE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class EcdsaSecp256k1SignatureWithPublicKeyAllOf {
  public static final String JSON_PROPERTY_RECOVERABLE_SIGNATURE = "recoverable_signature";
  private EcdsaSecp256k1Signature recoverableSignature;

  public EcdsaSecp256k1SignatureWithPublicKeyAllOf() { 
  }

  public EcdsaSecp256k1SignatureWithPublicKeyAllOf recoverableSignature(EcdsaSecp256k1Signature recoverableSignature) {
    this.recoverableSignature = recoverableSignature;
    return this;
  }

   /**
   * Get recoverableSignature
   * @return recoverableSignature
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_RECOVERABLE_SIGNATURE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EcdsaSecp256k1Signature getRecoverableSignature() {
    return recoverableSignature;
  }


  @JsonProperty(JSON_PROPERTY_RECOVERABLE_SIGNATURE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRecoverableSignature(EcdsaSecp256k1Signature recoverableSignature) {
    this.recoverableSignature = recoverableSignature;
  }


  /**
   * Return true if this EcdsaSecp256k1SignatureWithPublicKey_allOf object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EcdsaSecp256k1SignatureWithPublicKeyAllOf ecdsaSecp256k1SignatureWithPublicKeyAllOf = (EcdsaSecp256k1SignatureWithPublicKeyAllOf) o;
    return Objects.equals(this.recoverableSignature, ecdsaSecp256k1SignatureWithPublicKeyAllOf.recoverableSignature);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recoverableSignature);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EcdsaSecp256k1SignatureWithPublicKeyAllOf {\n");
    sb.append("    recoverableSignature: ").append(toIndentedString(recoverableSignature)).append("\n");
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

