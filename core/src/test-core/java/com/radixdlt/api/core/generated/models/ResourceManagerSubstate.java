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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.AccessControllerSubstate;
import com.radixdlt.api.core.generated.models.AccessRulesChainSubstate;
import com.radixdlt.api.core.generated.models.AccountSubstate;
import com.radixdlt.api.core.generated.models.ClockCurrentMinuteSubstate;
import com.radixdlt.api.core.generated.models.ComponentRoyaltyAccumulatorSubstate;
import com.radixdlt.api.core.generated.models.ComponentRoyaltyConfigSubstate;
import com.radixdlt.api.core.generated.models.ComponentStateSubstate;
import com.radixdlt.api.core.generated.models.EntityReference;
import com.radixdlt.api.core.generated.models.EpochManagerSubstate;
import com.radixdlt.api.core.generated.models.KeyValueStoreEntrySubstate;
import com.radixdlt.api.core.generated.models.MetadataSubstate;
import com.radixdlt.api.core.generated.models.NonFungibleIdType;
import com.radixdlt.api.core.generated.models.NonFungibleStoreEntrySubstate;
import com.radixdlt.api.core.generated.models.PackageCodeSubstate;
import com.radixdlt.api.core.generated.models.PackageCodeTypeSubstate;
import com.radixdlt.api.core.generated.models.PackageInfoSubstate;
import com.radixdlt.api.core.generated.models.PackageRoyaltyAccumulatorSubstate;
import com.radixdlt.api.core.generated.models.PackageRoyaltyConfigSubstate;
import com.radixdlt.api.core.generated.models.PackageTypeInfoSubstate;
import com.radixdlt.api.core.generated.models.ResourceManagerSubstate;
import com.radixdlt.api.core.generated.models.ResourceManagerSubstateAllOf;
import com.radixdlt.api.core.generated.models.ResourceType;
import com.radixdlt.api.core.generated.models.Substate;
import com.radixdlt.api.core.generated.models.SubstateType;
import com.radixdlt.api.core.generated.models.TypeInfoSubstate;
import com.radixdlt.api.core.generated.models.ValidatorSetSubstate;
import com.radixdlt.api.core.generated.models.ValidatorSubstate;
import com.radixdlt.api.core.generated.models.VaultFungibleSubstate;
import com.radixdlt.api.core.generated.models.VaultInfoSubstate;
import com.radixdlt.api.core.generated.models.VaultNonFungibleSubstate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * ResourceManagerSubstate
 */
@JsonPropertyOrder({
  ResourceManagerSubstate.JSON_PROPERTY_RESOURCE_TYPE,
  ResourceManagerSubstate.JSON_PROPERTY_FUNGIBLE_DIVISIBILITY,
  ResourceManagerSubstate.JSON_PROPERTY_NON_FUNGIBLE_ID_TYPE,
  ResourceManagerSubstate.JSON_PROPERTY_TOTAL_SUPPLY,
  ResourceManagerSubstate.JSON_PROPERTY_OWNED_NON_FUNGIBLE_STORE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "substate_type", // ignore manually set substate_type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the substate_type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "substate_type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = AccessControllerSubstate.class, name = "AccessController"),
  @JsonSubTypes.Type(value = AccessRulesChainSubstate.class, name = "AccessRulesChain"),
  @JsonSubTypes.Type(value = AccountSubstate.class, name = "Account"),
  @JsonSubTypes.Type(value = ClockCurrentMinuteSubstate.class, name = "ClockCurrentMinute"),
  @JsonSubTypes.Type(value = ComponentRoyaltyAccumulatorSubstate.class, name = "ComponentRoyaltyAccumulator"),
  @JsonSubTypes.Type(value = ComponentRoyaltyConfigSubstate.class, name = "ComponentRoyaltyConfig"),
  @JsonSubTypes.Type(value = ComponentStateSubstate.class, name = "ComponentState"),
  @JsonSubTypes.Type(value = EpochManagerSubstate.class, name = "EpochManager"),
  @JsonSubTypes.Type(value = KeyValueStoreEntrySubstate.class, name = "KeyValueStoreEntry"),
  @JsonSubTypes.Type(value = MetadataSubstate.class, name = "Metadata"),
  @JsonSubTypes.Type(value = NonFungibleStoreEntrySubstate.class, name = "NonFungibleStoreEntry"),
  @JsonSubTypes.Type(value = PackageCodeSubstate.class, name = "PackageCode"),
  @JsonSubTypes.Type(value = PackageCodeTypeSubstate.class, name = "PackageCodeType"),
  @JsonSubTypes.Type(value = PackageInfoSubstate.class, name = "PackageInfo"),
  @JsonSubTypes.Type(value = PackageRoyaltyAccumulatorSubstate.class, name = "PackageRoyaltyAccumulator"),
  @JsonSubTypes.Type(value = PackageRoyaltyConfigSubstate.class, name = "PackageRoyaltyConfig"),
  @JsonSubTypes.Type(value = PackageTypeInfoSubstate.class, name = "PackageTypeInfo"),
  @JsonSubTypes.Type(value = ResourceManagerSubstate.class, name = "ResourceManager"),
  @JsonSubTypes.Type(value = TypeInfoSubstate.class, name = "TypeInfo"),
  @JsonSubTypes.Type(value = ValidatorSubstate.class, name = "Validator"),
  @JsonSubTypes.Type(value = ValidatorSetSubstate.class, name = "ValidatorSet"),
  @JsonSubTypes.Type(value = VaultFungibleSubstate.class, name = "VaultFungible"),
  @JsonSubTypes.Type(value = VaultInfoSubstate.class, name = "VaultInfo"),
  @JsonSubTypes.Type(value = VaultNonFungibleSubstate.class, name = "VaultNonFungible"),
})

public class ResourceManagerSubstate extends Substate {
  public static final String JSON_PROPERTY_RESOURCE_TYPE = "resource_type";
  private ResourceType resourceType;

  public static final String JSON_PROPERTY_FUNGIBLE_DIVISIBILITY = "fungible_divisibility";
  private Integer fungibleDivisibility;

  public static final String JSON_PROPERTY_NON_FUNGIBLE_ID_TYPE = "non_fungible_id_type";
  private NonFungibleIdType nonFungibleIdType;

  public static final String JSON_PROPERTY_TOTAL_SUPPLY = "total_supply";
  private String totalSupply;

  public static final String JSON_PROPERTY_OWNED_NON_FUNGIBLE_STORE = "owned_non_fungible_store";
  private EntityReference ownedNonFungibleStore;

  public ResourceManagerSubstate() { 
  }

  public ResourceManagerSubstate resourceType(ResourceType resourceType) {
    this.resourceType = resourceType;
    return this;
  }

   /**
   * Get resourceType
   * @return resourceType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ResourceType getResourceType() {
    return resourceType;
  }


  @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResourceType(ResourceType resourceType) {
    this.resourceType = resourceType;
  }


  public ResourceManagerSubstate fungibleDivisibility(Integer fungibleDivisibility) {
    this.fungibleDivisibility = fungibleDivisibility;
    return this;
  }

   /**
   * Get fungibleDivisibility
   * minimum: 0
   * maximum: 18
   * @return fungibleDivisibility
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FUNGIBLE_DIVISIBILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getFungibleDivisibility() {
    return fungibleDivisibility;
  }


  @JsonProperty(JSON_PROPERTY_FUNGIBLE_DIVISIBILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFungibleDivisibility(Integer fungibleDivisibility) {
    this.fungibleDivisibility = fungibleDivisibility;
  }


  public ResourceManagerSubstate nonFungibleIdType(NonFungibleIdType nonFungibleIdType) {
    this.nonFungibleIdType = nonFungibleIdType;
    return this;
  }

   /**
   * Get nonFungibleIdType
   * @return nonFungibleIdType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NON_FUNGIBLE_ID_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public NonFungibleIdType getNonFungibleIdType() {
    return nonFungibleIdType;
  }


  @JsonProperty(JSON_PROPERTY_NON_FUNGIBLE_ID_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNonFungibleIdType(NonFungibleIdType nonFungibleIdType) {
    this.nonFungibleIdType = nonFungibleIdType;
  }


  public ResourceManagerSubstate totalSupply(String totalSupply) {
    this.totalSupply = totalSupply;
    return this;
  }

   /**
   * The string-encoded decimal representing the total supply of this resource. A decimal is formed of some signed integer &#x60;m&#x60; of attos (&#x60;10^(-18)&#x60;) units, where &#x60;-2^(256 - 1) &lt;&#x3D; m &lt; 2^(256 - 1)&#x60;. 
   * @return totalSupply
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The string-encoded decimal representing the total supply of this resource. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. ")
  @JsonProperty(JSON_PROPERTY_TOTAL_SUPPLY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTotalSupply() {
    return totalSupply;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL_SUPPLY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTotalSupply(String totalSupply) {
    this.totalSupply = totalSupply;
  }


  public ResourceManagerSubstate ownedNonFungibleStore(EntityReference ownedNonFungibleStore) {
    this.ownedNonFungibleStore = ownedNonFungibleStore;
    return this;
  }

   /**
   * Get ownedNonFungibleStore
   * @return ownedNonFungibleStore
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_OWNED_NON_FUNGIBLE_STORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public EntityReference getOwnedNonFungibleStore() {
    return ownedNonFungibleStore;
  }


  @JsonProperty(JSON_PROPERTY_OWNED_NON_FUNGIBLE_STORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOwnedNonFungibleStore(EntityReference ownedNonFungibleStore) {
    this.ownedNonFungibleStore = ownedNonFungibleStore;
  }


  /**
   * Return true if this ResourceManagerSubstate object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceManagerSubstate resourceManagerSubstate = (ResourceManagerSubstate) o;
    return Objects.equals(this.resourceType, resourceManagerSubstate.resourceType) &&
        Objects.equals(this.fungibleDivisibility, resourceManagerSubstate.fungibleDivisibility) &&
        Objects.equals(this.nonFungibleIdType, resourceManagerSubstate.nonFungibleIdType) &&
        Objects.equals(this.totalSupply, resourceManagerSubstate.totalSupply) &&
        Objects.equals(this.ownedNonFungibleStore, resourceManagerSubstate.ownedNonFungibleStore) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourceType, fungibleDivisibility, nonFungibleIdType, totalSupply, ownedNonFungibleStore, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceManagerSubstate {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
    sb.append("    fungibleDivisibility: ").append(toIndentedString(fungibleDivisibility)).append("\n");
    sb.append("    nonFungibleIdType: ").append(toIndentedString(nonFungibleIdType)).append("\n");
    sb.append("    totalSupply: ").append(toIndentedString(totalSupply)).append("\n");
    sb.append("    ownedNonFungibleStore: ").append(toIndentedString(ownedNonFungibleStore)).append("\n");
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
  mappings.put("AccessController", AccessControllerSubstate.class);
  mappings.put("AccessRulesChain", AccessRulesChainSubstate.class);
  mappings.put("Account", AccountSubstate.class);
  mappings.put("ClockCurrentMinute", ClockCurrentMinuteSubstate.class);
  mappings.put("ComponentRoyaltyAccumulator", ComponentRoyaltyAccumulatorSubstate.class);
  mappings.put("ComponentRoyaltyConfig", ComponentRoyaltyConfigSubstate.class);
  mappings.put("ComponentState", ComponentStateSubstate.class);
  mappings.put("EpochManager", EpochManagerSubstate.class);
  mappings.put("KeyValueStoreEntry", KeyValueStoreEntrySubstate.class);
  mappings.put("Metadata", MetadataSubstate.class);
  mappings.put("NonFungibleStoreEntry", NonFungibleStoreEntrySubstate.class);
  mappings.put("PackageCode", PackageCodeSubstate.class);
  mappings.put("PackageCodeType", PackageCodeTypeSubstate.class);
  mappings.put("PackageInfo", PackageInfoSubstate.class);
  mappings.put("PackageRoyaltyAccumulator", PackageRoyaltyAccumulatorSubstate.class);
  mappings.put("PackageRoyaltyConfig", PackageRoyaltyConfigSubstate.class);
  mappings.put("PackageTypeInfo", PackageTypeInfoSubstate.class);
  mappings.put("ResourceManager", ResourceManagerSubstate.class);
  mappings.put("TypeInfo", TypeInfoSubstate.class);
  mappings.put("Validator", ValidatorSubstate.class);
  mappings.put("ValidatorSet", ValidatorSetSubstate.class);
  mappings.put("VaultFungible", VaultFungibleSubstate.class);
  mappings.put("VaultInfo", VaultInfoSubstate.class);
  mappings.put("VaultNonFungible", VaultNonFungibleSubstate.class);
  mappings.put("ResourceManagerSubstate", ResourceManagerSubstate.class);
  JSON.registerDiscriminator(ResourceManagerSubstate.class, "substate_type", mappings);
}
}

