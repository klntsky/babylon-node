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
import com.radixdlt.api.core.generated.models.AccessRulesSubstate;
import com.radixdlt.api.core.generated.models.AccountSubstate;
import com.radixdlt.api.core.generated.models.ClockCurrentMinuteSubstate;
import com.radixdlt.api.core.generated.models.ComponentRoyaltyAccumulatorSubstate;
import com.radixdlt.api.core.generated.models.ComponentRoyaltyConfigSubstate;
import com.radixdlt.api.core.generated.models.ComponentStateSubstate;
import com.radixdlt.api.core.generated.models.EpochManagerSubstate;
import com.radixdlt.api.core.generated.models.FunctionAccessRulesSubstate;
import com.radixdlt.api.core.generated.models.KeyValueStoreEntrySubstate;
import com.radixdlt.api.core.generated.models.MetadataSubstate;
import com.radixdlt.api.core.generated.models.NonFungibleId;
import com.radixdlt.api.core.generated.models.NonFungibleResourceAmountAllOf;
import com.radixdlt.api.core.generated.models.NonFungibleStoreEntrySubstate;
import com.radixdlt.api.core.generated.models.PackageCodeSubstate;
import com.radixdlt.api.core.generated.models.PackageCodeTypeSubstate;
import com.radixdlt.api.core.generated.models.PackageInfoSubstate;
import com.radixdlt.api.core.generated.models.PackageRoyaltyAccumulatorSubstate;
import com.radixdlt.api.core.generated.models.PackageRoyaltyConfigSubstate;
import com.radixdlt.api.core.generated.models.ResourceManagerSubstate;
import com.radixdlt.api.core.generated.models.Substate;
import com.radixdlt.api.core.generated.models.SubstateType;
import com.radixdlt.api.core.generated.models.TypeInfoSubstate;
import com.radixdlt.api.core.generated.models.ValidatorSetSubstate;
import com.radixdlt.api.core.generated.models.ValidatorSubstate;
import com.radixdlt.api.core.generated.models.VaultFungibleSubstate;
import com.radixdlt.api.core.generated.models.VaultInfoSubstate;
import com.radixdlt.api.core.generated.models.VaultLockedFungibleSubstate;
import com.radixdlt.api.core.generated.models.VaultLockedNonFungibleSubstate;
import com.radixdlt.api.core.generated.models.VaultNonFungibleSubstate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * VaultLockedNonFungibleSubstate
 */
@JsonPropertyOrder({
  VaultLockedNonFungibleSubstate.JSON_PROPERTY_NON_FUNGIBLE_IDS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "substate_type", // ignore manually set substate_type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the substate_type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "substate_type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = AccessControllerSubstate.class, name = "AccessController"),
  @JsonSubTypes.Type(value = AccessRulesSubstate.class, name = "AccessRules"),
  @JsonSubTypes.Type(value = AccountSubstate.class, name = "Account"),
  @JsonSubTypes.Type(value = ClockCurrentMinuteSubstate.class, name = "ClockCurrentMinute"),
  @JsonSubTypes.Type(value = ComponentRoyaltyAccumulatorSubstate.class, name = "ComponentRoyaltyAccumulator"),
  @JsonSubTypes.Type(value = ComponentRoyaltyConfigSubstate.class, name = "ComponentRoyaltyConfig"),
  @JsonSubTypes.Type(value = ComponentStateSubstate.class, name = "ComponentState"),
  @JsonSubTypes.Type(value = EpochManagerSubstate.class, name = "EpochManager"),
  @JsonSubTypes.Type(value = FunctionAccessRulesSubstate.class, name = "FunctionAccessRules"),
  @JsonSubTypes.Type(value = KeyValueStoreEntrySubstate.class, name = "KeyValueStoreEntry"),
  @JsonSubTypes.Type(value = MetadataSubstate.class, name = "Metadata"),
  @JsonSubTypes.Type(value = NonFungibleStoreEntrySubstate.class, name = "NonFungibleStoreEntry"),
  @JsonSubTypes.Type(value = PackageCodeSubstate.class, name = "PackageCode"),
  @JsonSubTypes.Type(value = PackageCodeTypeSubstate.class, name = "PackageCodeType"),
  @JsonSubTypes.Type(value = PackageInfoSubstate.class, name = "PackageInfo"),
  @JsonSubTypes.Type(value = PackageRoyaltyAccumulatorSubstate.class, name = "PackageRoyaltyAccumulator"),
  @JsonSubTypes.Type(value = PackageRoyaltyConfigSubstate.class, name = "PackageRoyaltyConfig"),
  @JsonSubTypes.Type(value = ResourceManagerSubstate.class, name = "ResourceManager"),
  @JsonSubTypes.Type(value = TypeInfoSubstate.class, name = "TypeInfo"),
  @JsonSubTypes.Type(value = ValidatorSubstate.class, name = "Validator"),
  @JsonSubTypes.Type(value = ValidatorSetSubstate.class, name = "ValidatorSet"),
  @JsonSubTypes.Type(value = VaultFungibleSubstate.class, name = "VaultFungible"),
  @JsonSubTypes.Type(value = VaultInfoSubstate.class, name = "VaultInfo"),
  @JsonSubTypes.Type(value = VaultLockedFungibleSubstate.class, name = "VaultLockedFungible"),
  @JsonSubTypes.Type(value = VaultLockedNonFungibleSubstate.class, name = "VaultLockedNonFungible"),
  @JsonSubTypes.Type(value = VaultNonFungibleSubstate.class, name = "VaultNonFungible"),
})

public class VaultLockedNonFungibleSubstate extends Substate {
  public static final String JSON_PROPERTY_NON_FUNGIBLE_IDS = "non_fungible_ids";
  private List<NonFungibleId> nonFungibleIds = new ArrayList<>();

  public VaultLockedNonFungibleSubstate() { 
  }

  public VaultLockedNonFungibleSubstate nonFungibleIds(List<NonFungibleId> nonFungibleIds) {
    this.nonFungibleIds = nonFungibleIds;
    return this;
  }

  public VaultLockedNonFungibleSubstate addNonFungibleIdsItem(NonFungibleId nonFungibleIdsItem) {
    this.nonFungibleIds.add(nonFungibleIdsItem);
    return this;
  }

   /**
   * Get nonFungibleIds
   * @return nonFungibleIds
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_NON_FUNGIBLE_IDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<NonFungibleId> getNonFungibleIds() {
    return nonFungibleIds;
  }


  @JsonProperty(JSON_PROPERTY_NON_FUNGIBLE_IDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNonFungibleIds(List<NonFungibleId> nonFungibleIds) {
    this.nonFungibleIds = nonFungibleIds;
  }


  /**
   * Return true if this VaultLockedNonFungibleSubstate object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VaultLockedNonFungibleSubstate vaultLockedNonFungibleSubstate = (VaultLockedNonFungibleSubstate) o;
    return Objects.equals(this.nonFungibleIds, vaultLockedNonFungibleSubstate.nonFungibleIds) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nonFungibleIds, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VaultLockedNonFungibleSubstate {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    nonFungibleIds: ").append(toIndentedString(nonFungibleIds)).append("\n");
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
  mappings.put("AccessRules", AccessRulesSubstate.class);
  mappings.put("Account", AccountSubstate.class);
  mappings.put("ClockCurrentMinute", ClockCurrentMinuteSubstate.class);
  mappings.put("ComponentRoyaltyAccumulator", ComponentRoyaltyAccumulatorSubstate.class);
  mappings.put("ComponentRoyaltyConfig", ComponentRoyaltyConfigSubstate.class);
  mappings.put("ComponentState", ComponentStateSubstate.class);
  mappings.put("EpochManager", EpochManagerSubstate.class);
  mappings.put("FunctionAccessRules", FunctionAccessRulesSubstate.class);
  mappings.put("KeyValueStoreEntry", KeyValueStoreEntrySubstate.class);
  mappings.put("Metadata", MetadataSubstate.class);
  mappings.put("NonFungibleStoreEntry", NonFungibleStoreEntrySubstate.class);
  mappings.put("PackageCode", PackageCodeSubstate.class);
  mappings.put("PackageCodeType", PackageCodeTypeSubstate.class);
  mappings.put("PackageInfo", PackageInfoSubstate.class);
  mappings.put("PackageRoyaltyAccumulator", PackageRoyaltyAccumulatorSubstate.class);
  mappings.put("PackageRoyaltyConfig", PackageRoyaltyConfigSubstate.class);
  mappings.put("ResourceManager", ResourceManagerSubstate.class);
  mappings.put("TypeInfo", TypeInfoSubstate.class);
  mappings.put("Validator", ValidatorSubstate.class);
  mappings.put("ValidatorSet", ValidatorSetSubstate.class);
  mappings.put("VaultFungible", VaultFungibleSubstate.class);
  mappings.put("VaultInfo", VaultInfoSubstate.class);
  mappings.put("VaultLockedFungible", VaultLockedFungibleSubstate.class);
  mappings.put("VaultLockedNonFungible", VaultLockedNonFungibleSubstate.class);
  mappings.put("VaultNonFungible", VaultNonFungibleSubstate.class);
  mappings.put("VaultLockedNonFungibleSubstate", VaultLockedNonFungibleSubstate.class);
  JSON.registerDiscriminator(VaultLockedNonFungibleSubstate.class, "substate_type", mappings);
}
}

