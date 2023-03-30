/*
 * Babylon Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.3.0
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
import com.radixdlt.api.core.generated.models.LtsTransactionIntentStatus;
import com.radixdlt.api.core.generated.models.LtsTransactionPayloadStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * LtsTransactionStatusResponse
 */
@JsonPropertyOrder({
  LtsTransactionStatusResponse.JSON_PROPERTY_INTENT_STATUS,
  LtsTransactionStatusResponse.JSON_PROPERTY_STATUS_DESCRIPTION,
  LtsTransactionStatusResponse.JSON_PROPERTY_INVALID_FROM_EPOCH,
  LtsTransactionStatusResponse.JSON_PROPERTY_KNOWN_PAYLOADS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class LtsTransactionStatusResponse {
  public static final String JSON_PROPERTY_INTENT_STATUS = "intent_status";
  private LtsTransactionIntentStatus intentStatus;

  public static final String JSON_PROPERTY_STATUS_DESCRIPTION = "status_description";
  private String statusDescription;

  public static final String JSON_PROPERTY_INVALID_FROM_EPOCH = "invalid_from_epoch";
  private Long invalidFromEpoch;

  public static final String JSON_PROPERTY_KNOWN_PAYLOADS = "known_payloads";
  private List<LtsTransactionPayloadStatus> knownPayloads = new ArrayList<>();

  public LtsTransactionStatusResponse() { 
  }

  public LtsTransactionStatusResponse intentStatus(LtsTransactionIntentStatus intentStatus) {
    this.intentStatus = intentStatus;
    return this;
  }

   /**
   * Get intentStatus
   * @return intentStatus
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_INTENT_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public LtsTransactionIntentStatus getIntentStatus() {
    return intentStatus;
  }


  @JsonProperty(JSON_PROPERTY_INTENT_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIntentStatus(LtsTransactionIntentStatus intentStatus) {
    this.intentStatus = intentStatus;
  }


  public LtsTransactionStatusResponse statusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
    return this;
  }

   /**
   * An explanation as to why the intent status is resolved as it is. 
   * @return statusDescription
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An explanation as to why the intent status is resolved as it is. ")
  @JsonProperty(JSON_PROPERTY_STATUS_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getStatusDescription() {
    return statusDescription;
  }


  @JsonProperty(JSON_PROPERTY_STATUS_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStatusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
  }


  public LtsTransactionStatusResponse invalidFromEpoch(Long invalidFromEpoch) {
    this.invalidFromEpoch = invalidFromEpoch;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, marking the epoch from which the transaction will no longer be valid, and be permanently rejected. Only present if the intent status is InMempool or Unknown and we know about a payload. 
   * minimum: 0
   * maximum: 10000000000
   * @return invalidFromEpoch
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An integer between `0` and `10^10`, marking the epoch from which the transaction will no longer be valid, and be permanently rejected. Only present if the intent status is InMempool or Unknown and we know about a payload. ")
  @JsonProperty(JSON_PROPERTY_INVALID_FROM_EPOCH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getInvalidFromEpoch() {
    return invalidFromEpoch;
  }


  @JsonProperty(JSON_PROPERTY_INVALID_FROM_EPOCH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInvalidFromEpoch(Long invalidFromEpoch) {
    this.invalidFromEpoch = invalidFromEpoch;
  }


  public LtsTransactionStatusResponse knownPayloads(List<LtsTransactionPayloadStatus> knownPayloads) {
    this.knownPayloads = knownPayloads;
    return this;
  }

  public LtsTransactionStatusResponse addKnownPayloadsItem(LtsTransactionPayloadStatus knownPayloadsItem) {
    this.knownPayloads.add(knownPayloadsItem);
    return this;
  }

   /**
   * Get knownPayloads
   * @return knownPayloads
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_KNOWN_PAYLOADS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<LtsTransactionPayloadStatus> getKnownPayloads() {
    return knownPayloads;
  }


  @JsonProperty(JSON_PROPERTY_KNOWN_PAYLOADS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKnownPayloads(List<LtsTransactionPayloadStatus> knownPayloads) {
    this.knownPayloads = knownPayloads;
  }


  /**
   * Return true if this LtsTransactionStatusResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LtsTransactionStatusResponse ltsTransactionStatusResponse = (LtsTransactionStatusResponse) o;
    return Objects.equals(this.intentStatus, ltsTransactionStatusResponse.intentStatus) &&
        Objects.equals(this.statusDescription, ltsTransactionStatusResponse.statusDescription) &&
        Objects.equals(this.invalidFromEpoch, ltsTransactionStatusResponse.invalidFromEpoch) &&
        Objects.equals(this.knownPayloads, ltsTransactionStatusResponse.knownPayloads);
  }

  @Override
  public int hashCode() {
    return Objects.hash(intentStatus, statusDescription, invalidFromEpoch, knownPayloads);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LtsTransactionStatusResponse {\n");
    sb.append("    intentStatus: ").append(toIndentedString(intentStatus)).append("\n");
    sb.append("    statusDescription: ").append(toIndentedString(statusDescription)).append("\n");
    sb.append("    invalidFromEpoch: ").append(toIndentedString(invalidFromEpoch)).append("\n");
    sb.append("    knownPayloads: ").append(toIndentedString(knownPayloads)).append("\n");
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

