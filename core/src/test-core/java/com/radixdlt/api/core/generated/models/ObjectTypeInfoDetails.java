/*
 * Babylon Core API - RCnet V2
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.InstanceSchema;
import com.radixdlt.api.core.generated.models.KeyValueStoreTypeInfoDetails;
import com.radixdlt.api.core.generated.models.ObjectTypeInfoDetails;
import com.radixdlt.api.core.generated.models.ObjectTypeInfoDetailsAllOf;
import com.radixdlt.api.core.generated.models.TypeInfoDetails;
import com.radixdlt.api.core.generated.models.TypeInfoType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * ObjectTypeInfoDetails
 */
@JsonPropertyOrder({
  ObjectTypeInfoDetails.JSON_PROPERTY_PACKAGE_ADDRESS,
  ObjectTypeInfoDetails.JSON_PROPERTY_BLUEPRINT_NAME,
  ObjectTypeInfoDetails.JSON_PROPERTY_BLUEPRINT_VERSION,
  ObjectTypeInfoDetails.JSON_PROPERTY_GLOBAL,
  ObjectTypeInfoDetails.JSON_PROPERTY_OUTER_OBJECT,
  ObjectTypeInfoDetails.JSON_PROPERTY_INSTANCE_SCHEMA,
  ObjectTypeInfoDetails.JSON_PROPERTY_FEATURES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = KeyValueStoreTypeInfoDetails.class, name = "KeyValueStore"),
  @JsonSubTypes.Type(value = ObjectTypeInfoDetails.class, name = "Object"),
})

public class ObjectTypeInfoDetails extends TypeInfoDetails {
  public static final String JSON_PROPERTY_PACKAGE_ADDRESS = "package_address";
  private String packageAddress;

  public static final String JSON_PROPERTY_BLUEPRINT_NAME = "blueprint_name";
  private String blueprintName;

  public static final String JSON_PROPERTY_BLUEPRINT_VERSION = "blueprint_version";
  private String blueprintVersion;

  public static final String JSON_PROPERTY_GLOBAL = "global";
  private Boolean global;

  public static final String JSON_PROPERTY_OUTER_OBJECT = "outer_object";
  private String outerObject;

  public static final String JSON_PROPERTY_INSTANCE_SCHEMA = "instance_schema";
  private InstanceSchema instanceSchema;

  public static final String JSON_PROPERTY_FEATURES = "features";
  private List<String> features = new ArrayList<>();

  public ObjectTypeInfoDetails() { 
  }

  public ObjectTypeInfoDetails packageAddress(String packageAddress) {
    this.packageAddress = packageAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the package address
   * @return packageAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the package address")
  @JsonProperty(JSON_PROPERTY_PACKAGE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getPackageAddress() {
    return packageAddress;
  }


  @JsonProperty(JSON_PROPERTY_PACKAGE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPackageAddress(String packageAddress) {
    this.packageAddress = packageAddress;
  }


  public ObjectTypeInfoDetails blueprintName(String blueprintName) {
    this.blueprintName = blueprintName;
    return this;
  }

   /**
   * Get blueprintName
   * @return blueprintName
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_BLUEPRINT_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getBlueprintName() {
    return blueprintName;
  }


  @JsonProperty(JSON_PROPERTY_BLUEPRINT_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBlueprintName(String blueprintName) {
    this.blueprintName = blueprintName;
  }


  public ObjectTypeInfoDetails blueprintVersion(String blueprintVersion) {
    this.blueprintVersion = blueprintVersion;
    return this;
  }

   /**
   * Get blueprintVersion
   * @return blueprintVersion
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_BLUEPRINT_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getBlueprintVersion() {
    return blueprintVersion;
  }


  @JsonProperty(JSON_PROPERTY_BLUEPRINT_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBlueprintVersion(String blueprintVersion) {
    this.blueprintVersion = blueprintVersion;
  }


  public ObjectTypeInfoDetails global(Boolean global) {
    this.global = global;
    return this;
  }

   /**
   * Get global
   * @return global
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_GLOBAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getGlobal() {
    return global;
  }


  @JsonProperty(JSON_PROPERTY_GLOBAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGlobal(Boolean global) {
    this.global = global;
  }


  public ObjectTypeInfoDetails outerObject(String outerObject) {
    this.outerObject = outerObject;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of any global address
   * @return outerObject
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The Bech32m-encoded human readable version of any global address")
  @JsonProperty(JSON_PROPERTY_OUTER_OBJECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOuterObject() {
    return outerObject;
  }


  @JsonProperty(JSON_PROPERTY_OUTER_OBJECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOuterObject(String outerObject) {
    this.outerObject = outerObject;
  }


  public ObjectTypeInfoDetails instanceSchema(InstanceSchema instanceSchema) {
    this.instanceSchema = instanceSchema;
    return this;
  }

   /**
   * Get instanceSchema
   * @return instanceSchema
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INSTANCE_SCHEMA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public InstanceSchema getInstanceSchema() {
    return instanceSchema;
  }


  @JsonProperty(JSON_PROPERTY_INSTANCE_SCHEMA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInstanceSchema(InstanceSchema instanceSchema) {
    this.instanceSchema = instanceSchema;
  }


  public ObjectTypeInfoDetails features(List<String> features) {
    this.features = features;
    return this;
  }

  public ObjectTypeInfoDetails addFeaturesItem(String featuresItem) {
    this.features.add(featuresItem);
    return this;
  }

   /**
   * Get features
   * @return features
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_FEATURES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<String> getFeatures() {
    return features;
  }


  @JsonProperty(JSON_PROPERTY_FEATURES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFeatures(List<String> features) {
    this.features = features;
  }


  /**
   * Return true if this ObjectTypeInfoDetails object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjectTypeInfoDetails objectTypeInfoDetails = (ObjectTypeInfoDetails) o;
    return Objects.equals(this.packageAddress, objectTypeInfoDetails.packageAddress) &&
        Objects.equals(this.blueprintName, objectTypeInfoDetails.blueprintName) &&
        Objects.equals(this.blueprintVersion, objectTypeInfoDetails.blueprintVersion) &&
        Objects.equals(this.global, objectTypeInfoDetails.global) &&
        Objects.equals(this.outerObject, objectTypeInfoDetails.outerObject) &&
        Objects.equals(this.instanceSchema, objectTypeInfoDetails.instanceSchema) &&
        Objects.equals(this.features, objectTypeInfoDetails.features) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(packageAddress, blueprintName, blueprintVersion, global, outerObject, instanceSchema, features, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectTypeInfoDetails {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    packageAddress: ").append(toIndentedString(packageAddress)).append("\n");
    sb.append("    blueprintName: ").append(toIndentedString(blueprintName)).append("\n");
    sb.append("    blueprintVersion: ").append(toIndentedString(blueprintVersion)).append("\n");
    sb.append("    global: ").append(toIndentedString(global)).append("\n");
    sb.append("    outerObject: ").append(toIndentedString(outerObject)).append("\n");
    sb.append("    instanceSchema: ").append(toIndentedString(instanceSchema)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
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

static {
  // Initialize and register the discriminator mappings.
  Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
  mappings.put("KeyValueStore", KeyValueStoreTypeInfoDetails.class);
  mappings.put("Object", ObjectTypeInfoDetails.class);
  mappings.put("ObjectTypeInfoDetails", ObjectTypeInfoDetails.class);
  JSON.registerDiscriminator(ObjectTypeInfoDetails.class, "type", mappings);
}
}

