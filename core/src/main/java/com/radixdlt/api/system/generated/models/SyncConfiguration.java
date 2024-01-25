/*
 * Radix System API - Babylon (Anemone)
 * This API is exposed by the Babylon Radix node to give clients access to information about the node itself, its configuration, status and subsystems.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against ledger state, you may also wish to consider using the [Core API or Gateway API instead](https://docs-babylon.radixdlt.com/main/apis/api-specification.html). 
 *
 * The version of the OpenAPI document: v1.1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.radixdlt.api.system.generated.models;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * SyncConfiguration
 */
@JsonPropertyOrder({
  SyncConfiguration.JSON_PROPERTY_SYNC_CHECK_INTERVAL,
  SyncConfiguration.JSON_PROPERTY_SYNC_CHECK_MAX_PEERS,
  SyncConfiguration.JSON_PROPERTY_REQUEST_TIMEOUT,
  SyncConfiguration.JSON_PROPERTY_LEDGER_STATUS_UPDATE_MAX_PEERS_TO_NOTIFY,
  SyncConfiguration.JSON_PROPERTY_MAX_LEDGER_UPDATES_RATE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SyncConfiguration {
  public static final String JSON_PROPERTY_SYNC_CHECK_INTERVAL = "sync_check_interval";
  private Long syncCheckInterval;

  public static final String JSON_PROPERTY_SYNC_CHECK_MAX_PEERS = "sync_check_max_peers";
  private Integer syncCheckMaxPeers;

  public static final String JSON_PROPERTY_REQUEST_TIMEOUT = "request_timeout";
  private Long requestTimeout;

  public static final String JSON_PROPERTY_LEDGER_STATUS_UPDATE_MAX_PEERS_TO_NOTIFY = "ledger_status_update_max_peers_to_notify";
  private Integer ledgerStatusUpdateMaxPeersToNotify;

  public static final String JSON_PROPERTY_MAX_LEDGER_UPDATES_RATE = "max_ledger_updates_rate";
  private BigDecimal maxLedgerUpdatesRate;


  public SyncConfiguration syncCheckInterval(Long syncCheckInterval) {
    this.syncCheckInterval = syncCheckInterval;
    return this;
  }

   /**
   * Get syncCheckInterval
   * @return syncCheckInterval
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SYNC_CHECK_INTERVAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getSyncCheckInterval() {
    return syncCheckInterval;
  }


  @JsonProperty(JSON_PROPERTY_SYNC_CHECK_INTERVAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSyncCheckInterval(Long syncCheckInterval) {
    this.syncCheckInterval = syncCheckInterval;
  }


  public SyncConfiguration syncCheckMaxPeers(Integer syncCheckMaxPeers) {
    this.syncCheckMaxPeers = syncCheckMaxPeers;
    return this;
  }

   /**
   * Get syncCheckMaxPeers
   * @return syncCheckMaxPeers
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SYNC_CHECK_MAX_PEERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getSyncCheckMaxPeers() {
    return syncCheckMaxPeers;
  }


  @JsonProperty(JSON_PROPERTY_SYNC_CHECK_MAX_PEERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSyncCheckMaxPeers(Integer syncCheckMaxPeers) {
    this.syncCheckMaxPeers = syncCheckMaxPeers;
  }


  public SyncConfiguration requestTimeout(Long requestTimeout) {
    this.requestTimeout = requestTimeout;
    return this;
  }

   /**
   * Get requestTimeout
   * @return requestTimeout
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_REQUEST_TIMEOUT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getRequestTimeout() {
    return requestTimeout;
  }


  @JsonProperty(JSON_PROPERTY_REQUEST_TIMEOUT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRequestTimeout(Long requestTimeout) {
    this.requestTimeout = requestTimeout;
  }


  public SyncConfiguration ledgerStatusUpdateMaxPeersToNotify(Integer ledgerStatusUpdateMaxPeersToNotify) {
    this.ledgerStatusUpdateMaxPeersToNotify = ledgerStatusUpdateMaxPeersToNotify;
    return this;
  }

   /**
   * Get ledgerStatusUpdateMaxPeersToNotify
   * @return ledgerStatusUpdateMaxPeersToNotify
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_LEDGER_STATUS_UPDATE_MAX_PEERS_TO_NOTIFY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getLedgerStatusUpdateMaxPeersToNotify() {
    return ledgerStatusUpdateMaxPeersToNotify;
  }


  @JsonProperty(JSON_PROPERTY_LEDGER_STATUS_UPDATE_MAX_PEERS_TO_NOTIFY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLedgerStatusUpdateMaxPeersToNotify(Integer ledgerStatusUpdateMaxPeersToNotify) {
    this.ledgerStatusUpdateMaxPeersToNotify = ledgerStatusUpdateMaxPeersToNotify;
  }


  public SyncConfiguration maxLedgerUpdatesRate(BigDecimal maxLedgerUpdatesRate) {
    this.maxLedgerUpdatesRate = maxLedgerUpdatesRate;
    return this;
  }

   /**
   * Get maxLedgerUpdatesRate
   * @return maxLedgerUpdatesRate
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_MAX_LEDGER_UPDATES_RATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BigDecimal getMaxLedgerUpdatesRate() {
    return maxLedgerUpdatesRate;
  }


  @JsonProperty(JSON_PROPERTY_MAX_LEDGER_UPDATES_RATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMaxLedgerUpdatesRate(BigDecimal maxLedgerUpdatesRate) {
    this.maxLedgerUpdatesRate = maxLedgerUpdatesRate;
  }


  /**
   * Return true if this SyncConfiguration object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SyncConfiguration syncConfiguration = (SyncConfiguration) o;
    return Objects.equals(this.syncCheckInterval, syncConfiguration.syncCheckInterval) &&
        Objects.equals(this.syncCheckMaxPeers, syncConfiguration.syncCheckMaxPeers) &&
        Objects.equals(this.requestTimeout, syncConfiguration.requestTimeout) &&
        Objects.equals(this.ledgerStatusUpdateMaxPeersToNotify, syncConfiguration.ledgerStatusUpdateMaxPeersToNotify) &&
        Objects.equals(this.maxLedgerUpdatesRate, syncConfiguration.maxLedgerUpdatesRate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(syncCheckInterval, syncCheckMaxPeers, requestTimeout, ledgerStatusUpdateMaxPeersToNotify, maxLedgerUpdatesRate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SyncConfiguration {\n");
    sb.append("    syncCheckInterval: ").append(toIndentedString(syncCheckInterval)).append("\n");
    sb.append("    syncCheckMaxPeers: ").append(toIndentedString(syncCheckMaxPeers)).append("\n");
    sb.append("    requestTimeout: ").append(toIndentedString(requestTimeout)).append("\n");
    sb.append("    ledgerStatusUpdateMaxPeersToNotify: ").append(toIndentedString(ledgerStatusUpdateMaxPeersToNotify)).append("\n");
    sb.append("    maxLedgerUpdatesRate: ").append(toIndentedString(maxLedgerUpdatesRate)).append("\n");
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

