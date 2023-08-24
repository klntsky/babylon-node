/*
 * Babylon Core API - RCnet v3
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v3\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.0
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
import com.radixdlt.api.core.generated.models.MempoolTransactionResponsePayloadsInner;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * MempoolTransactionResponse
 */
@JsonPropertyOrder({
  MempoolTransactionResponse.JSON_PROPERTY_COUNT,
  MempoolTransactionResponse.JSON_PROPERTY_PAYLOADS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MempoolTransactionResponse {
  public static final String JSON_PROPERTY_COUNT = "count";
  private Integer count;

  public static final String JSON_PROPERTY_PAYLOADS = "payloads";
  private List<MempoolTransactionResponsePayloadsInner> payloads = new ArrayList<>();

  public MempoolTransactionResponse() { 
  }

  public MempoolTransactionResponse count(Integer count) {
    this.count = count;
    return this;
  }

   /**
   * An integer giving the total count of payload hashes checked in the returned response.
   * @return count
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer giving the total count of payload hashes checked in the returned response.")
  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getCount() {
    return count;
  }


  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCount(Integer count) {
    this.count = count;
  }


  public MempoolTransactionResponse payloads(List<MempoolTransactionResponsePayloadsInner> payloads) {
    this.payloads = payloads;
    return this;
  }

  public MempoolTransactionResponse addPayloadsItem(MempoolTransactionResponsePayloadsInner payloadsItem) {
    this.payloads.add(payloadsItem);
    return this;
  }

   /**
   * An array containing pairs of payload hash (query) and payload hex or error (response). Note that this response is bounded - this means it is not guaranteed all queries will be processed. Please query missing payload hashes again. 
   * @return payloads
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An array containing pairs of payload hash (query) and payload hex or error (response). Note that this response is bounded - this means it is not guaranteed all queries will be processed. Please query missing payload hashes again. ")
  @JsonProperty(JSON_PROPERTY_PAYLOADS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<MempoolTransactionResponsePayloadsInner> getPayloads() {
    return payloads;
  }


  @JsonProperty(JSON_PROPERTY_PAYLOADS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPayloads(List<MempoolTransactionResponsePayloadsInner> payloads) {
    this.payloads = payloads;
  }


  /**
   * Return true if this MempoolTransactionResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MempoolTransactionResponse mempoolTransactionResponse = (MempoolTransactionResponse) o;
    return Objects.equals(this.count, mempoolTransactionResponse.count) &&
        Objects.equals(this.payloads, mempoolTransactionResponse.payloads);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, payloads);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MempoolTransactionResponse {\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    payloads: ").append(toIndentedString(payloads)).append("\n");
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

