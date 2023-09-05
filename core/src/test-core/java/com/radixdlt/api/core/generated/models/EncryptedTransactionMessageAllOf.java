/*
 * Babylon Core API - RCnet v3.1
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the fourth release candidate of the Radix Babylon network (\"RCnet v3.1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.1
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
import com.radixdlt.api.core.generated.models.EncryptedMessageCurveDecryptorSet;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * A &#x60;PlaintextTransactionMessage&#x60; encrypted with \&quot;Multi-party ECIES\&quot; for a number of decryptors (public keys).
 */
@ApiModel(description = "A `PlaintextTransactionMessage` encrypted with \"Multi-party ECIES\" for a number of decryptors (public keys).")
@JsonPropertyOrder({
  EncryptedTransactionMessageAllOf.JSON_PROPERTY_ENCRYPTED_HEX,
  EncryptedTransactionMessageAllOf.JSON_PROPERTY_CURVE_DECRYPTOR_SETS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class EncryptedTransactionMessageAllOf {
  public static final String JSON_PROPERTY_ENCRYPTED_HEX = "encrypted_hex";
  private String encryptedHex;

  public static final String JSON_PROPERTY_CURVE_DECRYPTOR_SETS = "curve_decryptor_sets";
  private List<EncryptedMessageCurveDecryptorSet> curveDecryptorSets = new ArrayList<>();

  public EncryptedTransactionMessageAllOf() { 
  }

  public EncryptedTransactionMessageAllOf encryptedHex(String encryptedHex) {
    this.encryptedHex = encryptedHex;
    return this;
  }

   /**
   * The hex-encoded (128-bit) AES-GCM encrypted bytes of an SBOR-encoded &#x60;PlaintextTransactionMessage&#x60;. The bytes are serialized as the concatenation &#x60;Nonce/IV (12 bytes) || Cipher (variable length) || Tag/MAC (16 bytes)&#x60;: 
   * @return encryptedHex
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded (128-bit) AES-GCM encrypted bytes of an SBOR-encoded `PlaintextTransactionMessage`. The bytes are serialized as the concatenation `Nonce/IV (12 bytes) || Cipher (variable length) || Tag/MAC (16 bytes)`: ")
  @JsonProperty(JSON_PROPERTY_ENCRYPTED_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getEncryptedHex() {
    return encryptedHex;
  }


  @JsonProperty(JSON_PROPERTY_ENCRYPTED_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEncryptedHex(String encryptedHex) {
    this.encryptedHex = encryptedHex;
  }


  public EncryptedTransactionMessageAllOf curveDecryptorSets(List<EncryptedMessageCurveDecryptorSet> curveDecryptorSets) {
    this.curveDecryptorSets = curveDecryptorSets;
    return this;
  }

  public EncryptedTransactionMessageAllOf addCurveDecryptorSetsItem(EncryptedMessageCurveDecryptorSet curveDecryptorSetsItem) {
    this.curveDecryptorSets.add(curveDecryptorSetsItem);
    return this;
  }

   /**
   * Get curveDecryptorSets
   * @return curveDecryptorSets
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CURVE_DECRYPTOR_SETS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<EncryptedMessageCurveDecryptorSet> getCurveDecryptorSets() {
    return curveDecryptorSets;
  }


  @JsonProperty(JSON_PROPERTY_CURVE_DECRYPTOR_SETS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCurveDecryptorSets(List<EncryptedMessageCurveDecryptorSet> curveDecryptorSets) {
    this.curveDecryptorSets = curveDecryptorSets;
  }


  /**
   * Return true if this EncryptedTransactionMessage_allOf object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EncryptedTransactionMessageAllOf encryptedTransactionMessageAllOf = (EncryptedTransactionMessageAllOf) o;
    return Objects.equals(this.encryptedHex, encryptedTransactionMessageAllOf.encryptedHex) &&
        Objects.equals(this.curveDecryptorSets, encryptedTransactionMessageAllOf.curveDecryptorSets);
  }

  @Override
  public int hashCode() {
    return Objects.hash(encryptedHex, curveDecryptorSets);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EncryptedTransactionMessageAllOf {\n");
    sb.append("    encryptedHex: ").append(toIndentedString(encryptedHex)).append("\n");
    sb.append("    curveDecryptorSets: ").append(toIndentedString(curveDecryptorSets)).append("\n");
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

