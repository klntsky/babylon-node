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
import com.radixdlt.api.core.generated.models.EventEmitterIdentifier;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Identifier of a specific event schema.
 */
@ApiModel(description = "Identifier of a specific event schema.")
@JsonPropertyOrder({
  EventTypeIdentifier.JSON_PROPERTY_EMITTER,
  EventTypeIdentifier.JSON_PROPERTY_EVENT_NAME
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class EventTypeIdentifier {
  public static final String JSON_PROPERTY_EMITTER = "emitter";
  private EventEmitterIdentifier emitter;

  public static final String JSON_PROPERTY_EVENT_NAME = "event_name";
  private String eventName;

  public EventTypeIdentifier() { 
  }

  public EventTypeIdentifier emitter(EventEmitterIdentifier emitter) {
    this.emitter = emitter;
    return this;
  }

   /**
   * Get emitter
   * @return emitter
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_EMITTER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EventEmitterIdentifier getEmitter() {
    return emitter;
  }


  @JsonProperty(JSON_PROPERTY_EMITTER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEmitter(EventEmitterIdentifier emitter) {
    this.emitter = emitter;
  }


  public EventTypeIdentifier eventName(String eventName) {
    this.eventName = eventName;
    return this;
  }

   /**
   * Event name.
   * @return eventName
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Event name.")
  @JsonProperty(JSON_PROPERTY_EVENT_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getEventName() {
    return eventName;
  }


  @JsonProperty(JSON_PROPERTY_EVENT_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEventName(String eventName) {
    this.eventName = eventName;
  }


  /**
   * Return true if this EventTypeIdentifier object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventTypeIdentifier eventTypeIdentifier = (EventTypeIdentifier) o;
    return Objects.equals(this.emitter, eventTypeIdentifier.emitter) &&
        Objects.equals(this.eventName, eventTypeIdentifier.eventName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emitter, eventName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventTypeIdentifier {\n");
    sb.append("    emitter: ").append(toIndentedString(emitter)).append("\n");
    sb.append("    eventName: ").append(toIndentedString(eventName)).append("\n");
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

