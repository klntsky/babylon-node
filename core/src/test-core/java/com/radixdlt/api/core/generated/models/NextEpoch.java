/*
 * Radix Core API - Babylon (Anemone)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.1.0
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
import com.radixdlt.api.core.generated.models.ActiveValidator;
import com.radixdlt.api.core.generated.models.SignificantProtocolUpdateReadinessEntry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * NextEpoch
 */
@JsonPropertyOrder({
  NextEpoch.JSON_PROPERTY_EPOCH,
  NextEpoch.JSON_PROPERTY_VALIDATORS,
  NextEpoch.JSON_PROPERTY_SIGNIFICANT_PROTOCOL_UPDATE_READINESS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class NextEpoch {
  public static final String JSON_PROPERTY_EPOCH = "epoch";
  private Long epoch;

  public static final String JSON_PROPERTY_VALIDATORS = "validators";
  private List<ActiveValidator> validators = new ArrayList<>();

  public static final String JSON_PROPERTY_SIGNIFICANT_PROTOCOL_UPDATE_READINESS = "significant_protocol_update_readiness";
  private List<SignificantProtocolUpdateReadinessEntry> significantProtocolUpdateReadiness = null;

  public NextEpoch() { 
  }

  public NextEpoch epoch(Long epoch) {
    this.epoch = epoch;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, marking the new epoch
   * minimum: 0
   * maximum: 10000000000
   * @return epoch
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^10`, marking the new epoch")
  @JsonProperty(JSON_PROPERTY_EPOCH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getEpoch() {
    return epoch;
  }


  @JsonProperty(JSON_PROPERTY_EPOCH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEpoch(Long epoch) {
    this.epoch = epoch;
  }


  public NextEpoch validators(List<ActiveValidator> validators) {
    this.validators = validators;
    return this;
  }

  public NextEpoch addValidatorsItem(ActiveValidator validatorsItem) {
    this.validators.add(validatorsItem);
    return this;
  }

   /**
   * Active validator set for the new epoch, ordered by stake descending.
   * @return validators
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Active validator set for the new epoch, ordered by stake descending.")
  @JsonProperty(JSON_PROPERTY_VALIDATORS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<ActiveValidator> getValidators() {
    return validators;
  }


  @JsonProperty(JSON_PROPERTY_VALIDATORS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValidators(List<ActiveValidator> validators) {
    this.validators = validators;
  }


  public NextEpoch significantProtocolUpdateReadiness(List<SignificantProtocolUpdateReadinessEntry> significantProtocolUpdateReadiness) {
    this.significantProtocolUpdateReadiness = significantProtocolUpdateReadiness;
    return this;
  }

  public NextEpoch addSignificantProtocolUpdateReadinessItem(SignificantProtocolUpdateReadinessEntry significantProtocolUpdateReadinessItem) {
    if (this.significantProtocolUpdateReadiness == null) {
      this.significantProtocolUpdateReadiness = new ArrayList<>();
    }
    this.significantProtocolUpdateReadiness.add(significantProtocolUpdateReadinessItem);
    return this;
  }

   /**
   * Get significantProtocolUpdateReadiness
   * @return significantProtocolUpdateReadiness
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SIGNIFICANT_PROTOCOL_UPDATE_READINESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<SignificantProtocolUpdateReadinessEntry> getSignificantProtocolUpdateReadiness() {
    return significantProtocolUpdateReadiness;
  }


  @JsonProperty(JSON_PROPERTY_SIGNIFICANT_PROTOCOL_UPDATE_READINESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSignificantProtocolUpdateReadiness(List<SignificantProtocolUpdateReadinessEntry> significantProtocolUpdateReadiness) {
    this.significantProtocolUpdateReadiness = significantProtocolUpdateReadiness;
  }


  /**
   * Return true if this NextEpoch object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NextEpoch nextEpoch = (NextEpoch) o;
    return Objects.equals(this.epoch, nextEpoch.epoch) &&
        Objects.equals(this.validators, nextEpoch.validators) &&
        Objects.equals(this.significantProtocolUpdateReadiness, nextEpoch.significantProtocolUpdateReadiness);
  }

  @Override
  public int hashCode() {
    return Objects.hash(epoch, validators, significantProtocolUpdateReadiness);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NextEpoch {\n");
    sb.append("    epoch: ").append(toIndentedString(epoch)).append("\n");
    sb.append("    validators: ").append(toIndentedString(validators)).append("\n");
    sb.append("    significantProtocolUpdateReadiness: ").append(toIndentedString(significantProtocolUpdateReadiness)).append("\n");
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

