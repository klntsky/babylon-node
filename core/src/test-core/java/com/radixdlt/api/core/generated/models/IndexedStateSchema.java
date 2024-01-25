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
import com.radixdlt.api.core.generated.models.BlueprintSchemaCollectionPartition;
import com.radixdlt.api.core.generated.models.BlueprintSchemaFieldPartition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * IndexedStateSchema
 */
@JsonPropertyOrder({
  IndexedStateSchema.JSON_PROPERTY_FIELDS,
  IndexedStateSchema.JSON_PROPERTY_COLLECTIONS,
  IndexedStateSchema.JSON_PROPERTY_NUM_PARTITIONS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class IndexedStateSchema {
  public static final String JSON_PROPERTY_FIELDS = "fields";
  private BlueprintSchemaFieldPartition fields;

  public static final String JSON_PROPERTY_COLLECTIONS = "collections";
  private List<BlueprintSchemaCollectionPartition> collections = new ArrayList<>();

  public static final String JSON_PROPERTY_NUM_PARTITIONS = "num_partitions";
  private Integer numPartitions;

  public IndexedStateSchema() { 
  }

  public IndexedStateSchema fields(BlueprintSchemaFieldPartition fields) {
    this.fields = fields;
    return this;
  }

   /**
   * Get fields
   * @return fields
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FIELDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BlueprintSchemaFieldPartition getFields() {
    return fields;
  }


  @JsonProperty(JSON_PROPERTY_FIELDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFields(BlueprintSchemaFieldPartition fields) {
    this.fields = fields;
  }


  public IndexedStateSchema collections(List<BlueprintSchemaCollectionPartition> collections) {
    this.collections = collections;
    return this;
  }

  public IndexedStateSchema addCollectionsItem(BlueprintSchemaCollectionPartition collectionsItem) {
    this.collections.add(collectionsItem);
    return this;
  }

   /**
   * Get collections
   * @return collections
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_COLLECTIONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<BlueprintSchemaCollectionPartition> getCollections() {
    return collections;
  }


  @JsonProperty(JSON_PROPERTY_COLLECTIONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCollections(List<BlueprintSchemaCollectionPartition> collections) {
    this.collections = collections;
  }


  public IndexedStateSchema numPartitions(Integer numPartitions) {
    this.numPartitions = numPartitions;
    return this;
  }

   /**
   * Get numPartitions
   * minimum: 0
   * maximum: 255
   * @return numPartitions
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_NUM_PARTITIONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getNumPartitions() {
    return numPartitions;
  }


  @JsonProperty(JSON_PROPERTY_NUM_PARTITIONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNumPartitions(Integer numPartitions) {
    this.numPartitions = numPartitions;
  }


  /**
   * Return true if this IndexedStateSchema object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndexedStateSchema indexedStateSchema = (IndexedStateSchema) o;
    return Objects.equals(this.fields, indexedStateSchema.fields) &&
        Objects.equals(this.collections, indexedStateSchema.collections) &&
        Objects.equals(this.numPartitions, indexedStateSchema.numPartitions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fields, collections, numPartitions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndexedStateSchema {\n");
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
    sb.append("    collections: ").append(toIndentedString(collections)).append("\n");
    sb.append("    numPartitions: ").append(toIndentedString(numPartitions)).append("\n");
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

