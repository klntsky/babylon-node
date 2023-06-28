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
import com.radixdlt.api.core.generated.models.AccessControllerFieldStateSubstate;
import com.radixdlt.api.core.generated.models.AccessRulesModuleFieldOwnerRoleSubstate;
import com.radixdlt.api.core.generated.models.AccessRulesModuleRuleEntrySubstate;
import com.radixdlt.api.core.generated.models.AccountDepositRuleIndexEntrySubstate;
import com.radixdlt.api.core.generated.models.AccountFieldStateSubstate;
import com.radixdlt.api.core.generated.models.AccountVaultIndexEntrySubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerFieldConfigSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerFieldCurrentProposalStatisticSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerFieldCurrentTimeRoundedToMinutesSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerFieldCurrentTimeSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerFieldCurrentValidatorSetSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerFieldStateSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerFieldValidatorRewardsSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerRegisteredValidatorsByStakeIndexEntrySubstate;
import com.radixdlt.api.core.generated.models.FungibleResourceManagerFieldDivisibilitySubstate;
import com.radixdlt.api.core.generated.models.FungibleResourceManagerFieldTotalSupplySubstate;
import com.radixdlt.api.core.generated.models.FungibleVaultFieldBalanceSubstate;
import com.radixdlt.api.core.generated.models.FungibleVaultFieldFrozenStatusSubstate;
import com.radixdlt.api.core.generated.models.GenericKeyValueStoreEntrySubstate;
import com.radixdlt.api.core.generated.models.GenericScryptoComponentFieldStateSubstate;
import com.radixdlt.api.core.generated.models.MetadataModuleEntrySubstate;
import com.radixdlt.api.core.generated.models.MultiResourcePoolFieldStateSubstate;
import com.radixdlt.api.core.generated.models.MultiResourcePoolFieldStateSubstateAllOf;
import com.radixdlt.api.core.generated.models.NonFungibleResourceManagerDataEntrySubstate;
import com.radixdlt.api.core.generated.models.NonFungibleResourceManagerFieldIdTypeSubstate;
import com.radixdlt.api.core.generated.models.NonFungibleResourceManagerFieldMutableFieldsSubstate;
import com.radixdlt.api.core.generated.models.NonFungibleResourceManagerFieldTotalSupplySubstate;
import com.radixdlt.api.core.generated.models.NonFungibleVaultContentsIndexEntrySubstate;
import com.radixdlt.api.core.generated.models.NonFungibleVaultFieldBalanceSubstate;
import com.radixdlt.api.core.generated.models.NonFungibleVaultFieldFrozenStatusSubstate;
import com.radixdlt.api.core.generated.models.OneResourcePoolFieldStateSubstate;
import com.radixdlt.api.core.generated.models.PackageBlueprintAuthTemplateEntrySubstate;
import com.radixdlt.api.core.generated.models.PackageBlueprintDefinitionEntrySubstate;
import com.radixdlt.api.core.generated.models.PackageBlueprintDependenciesEntrySubstate;
import com.radixdlt.api.core.generated.models.PackageBlueprintRoyaltyEntrySubstate;
import com.radixdlt.api.core.generated.models.PackageCodeEntrySubstate;
import com.radixdlt.api.core.generated.models.PackageFieldRoyaltyAccumulatorSubstate;
import com.radixdlt.api.core.generated.models.PackageSchemaEntrySubstate;
import com.radixdlt.api.core.generated.models.PoolVault;
import com.radixdlt.api.core.generated.models.RoyaltyMethodRoyaltyEntrySubstate;
import com.radixdlt.api.core.generated.models.RoyaltyModuleFieldStateSubstate;
import com.radixdlt.api.core.generated.models.Substate;
import com.radixdlt.api.core.generated.models.SubstateType;
import com.radixdlt.api.core.generated.models.TransactionTrackerCollectionEntrySubstate;
import com.radixdlt.api.core.generated.models.TransactionTrackerFieldStateSubstate;
import com.radixdlt.api.core.generated.models.TwoResourcePoolFieldStateSubstate;
import com.radixdlt.api.core.generated.models.TypeInfoModuleFieldTypeInfoSubstate;
import com.radixdlt.api.core.generated.models.ValidatorFieldProtocolUpdateReadinessSignalSubstate;
import com.radixdlt.api.core.generated.models.ValidatorFieldStateSubstate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * MultiResourcePoolFieldStateSubstate
 */
@JsonPropertyOrder({
  MultiResourcePoolFieldStateSubstate.JSON_PROPERTY_VAULTS,
  MultiResourcePoolFieldStateSubstate.JSON_PROPERTY_POOL_UNIT_RESOURCE_ADDRESS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "substate_type", // ignore manually set substate_type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the substate_type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "substate_type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = AccessControllerFieldStateSubstate.class, name = "AccessControllerFieldState"),
  @JsonSubTypes.Type(value = AccessRulesModuleFieldOwnerRoleSubstate.class, name = "AccessRulesModuleFieldOwnerRole"),
  @JsonSubTypes.Type(value = AccessRulesModuleRuleEntrySubstate.class, name = "AccessRulesModuleRuleEntry"),
  @JsonSubTypes.Type(value = AccountDepositRuleIndexEntrySubstate.class, name = "AccountDepositRuleIndexEntry"),
  @JsonSubTypes.Type(value = AccountFieldStateSubstate.class, name = "AccountFieldState"),
  @JsonSubTypes.Type(value = AccountVaultIndexEntrySubstate.class, name = "AccountVaultIndexEntry"),
  @JsonSubTypes.Type(value = ConsensusManagerFieldConfigSubstate.class, name = "ConsensusManagerFieldConfig"),
  @JsonSubTypes.Type(value = ConsensusManagerFieldCurrentProposalStatisticSubstate.class, name = "ConsensusManagerFieldCurrentProposalStatistic"),
  @JsonSubTypes.Type(value = ConsensusManagerFieldCurrentTimeSubstate.class, name = "ConsensusManagerFieldCurrentTime"),
  @JsonSubTypes.Type(value = ConsensusManagerFieldCurrentTimeRoundedToMinutesSubstate.class, name = "ConsensusManagerFieldCurrentTimeRoundedToMinutes"),
  @JsonSubTypes.Type(value = ConsensusManagerFieldCurrentValidatorSetSubstate.class, name = "ConsensusManagerFieldCurrentValidatorSet"),
  @JsonSubTypes.Type(value = ConsensusManagerFieldStateSubstate.class, name = "ConsensusManagerFieldState"),
  @JsonSubTypes.Type(value = ConsensusManagerFieldValidatorRewardsSubstate.class, name = "ConsensusManagerFieldValidatorRewards"),
  @JsonSubTypes.Type(value = ConsensusManagerRegisteredValidatorsByStakeIndexEntrySubstate.class, name = "ConsensusManagerRegisteredValidatorsByStakeIndexEntry"),
  @JsonSubTypes.Type(value = FungibleResourceManagerFieldDivisibilitySubstate.class, name = "FungibleResourceManagerFieldDivisibility"),
  @JsonSubTypes.Type(value = FungibleResourceManagerFieldTotalSupplySubstate.class, name = "FungibleResourceManagerFieldTotalSupply"),
  @JsonSubTypes.Type(value = FungibleVaultFieldBalanceSubstate.class, name = "FungibleVaultFieldBalance"),
  @JsonSubTypes.Type(value = FungibleVaultFieldFrozenStatusSubstate.class, name = "FungibleVaultFieldFrozenStatus"),
  @JsonSubTypes.Type(value = GenericKeyValueStoreEntrySubstate.class, name = "GenericKeyValueStoreEntry"),
  @JsonSubTypes.Type(value = GenericScryptoComponentFieldStateSubstate.class, name = "GenericScryptoComponentFieldState"),
  @JsonSubTypes.Type(value = MetadataModuleEntrySubstate.class, name = "MetadataModuleEntry"),
  @JsonSubTypes.Type(value = MultiResourcePoolFieldStateSubstate.class, name = "MultiResourcePoolFieldState"),
  @JsonSubTypes.Type(value = NonFungibleResourceManagerDataEntrySubstate.class, name = "NonFungibleResourceManagerDataEntry"),
  @JsonSubTypes.Type(value = NonFungibleResourceManagerFieldIdTypeSubstate.class, name = "NonFungibleResourceManagerFieldIdType"),
  @JsonSubTypes.Type(value = NonFungibleResourceManagerFieldMutableFieldsSubstate.class, name = "NonFungibleResourceManagerFieldMutableFields"),
  @JsonSubTypes.Type(value = NonFungibleResourceManagerFieldTotalSupplySubstate.class, name = "NonFungibleResourceManagerFieldTotalSupply"),
  @JsonSubTypes.Type(value = NonFungibleVaultContentsIndexEntrySubstate.class, name = "NonFungibleVaultContentsIndexEntry"),
  @JsonSubTypes.Type(value = NonFungibleVaultFieldBalanceSubstate.class, name = "NonFungibleVaultFieldBalance"),
  @JsonSubTypes.Type(value = NonFungibleVaultFieldFrozenStatusSubstate.class, name = "NonFungibleVaultFieldFrozenStatus"),
  @JsonSubTypes.Type(value = OneResourcePoolFieldStateSubstate.class, name = "OneResourcePoolFieldState"),
  @JsonSubTypes.Type(value = PackageBlueprintAuthTemplateEntrySubstate.class, name = "PackageBlueprintAuthTemplateEntry"),
  @JsonSubTypes.Type(value = PackageBlueprintDefinitionEntrySubstate.class, name = "PackageBlueprintDefinitionEntry"),
  @JsonSubTypes.Type(value = PackageBlueprintDependenciesEntrySubstate.class, name = "PackageBlueprintDependenciesEntry"),
  @JsonSubTypes.Type(value = PackageBlueprintRoyaltyEntrySubstate.class, name = "PackageBlueprintRoyaltyEntry"),
  @JsonSubTypes.Type(value = PackageCodeEntrySubstate.class, name = "PackageCodeEntry"),
  @JsonSubTypes.Type(value = PackageFieldRoyaltyAccumulatorSubstate.class, name = "PackageFieldRoyaltyAccumulator"),
  @JsonSubTypes.Type(value = PackageSchemaEntrySubstate.class, name = "PackageSchemaEntry"),
  @JsonSubTypes.Type(value = RoyaltyMethodRoyaltyEntrySubstate.class, name = "RoyaltyMethodRoyaltyEntry"),
  @JsonSubTypes.Type(value = RoyaltyModuleFieldStateSubstate.class, name = "RoyaltyModuleFieldState"),
  @JsonSubTypes.Type(value = TransactionTrackerCollectionEntrySubstate.class, name = "TransactionTrackerCollectionEntry"),
  @JsonSubTypes.Type(value = TransactionTrackerFieldStateSubstate.class, name = "TransactionTrackerFieldState"),
  @JsonSubTypes.Type(value = TwoResourcePoolFieldStateSubstate.class, name = "TwoResourcePoolFieldState"),
  @JsonSubTypes.Type(value = TypeInfoModuleFieldTypeInfoSubstate.class, name = "TypeInfoModuleFieldTypeInfo"),
  @JsonSubTypes.Type(value = ValidatorFieldProtocolUpdateReadinessSignalSubstate.class, name = "ValidatorFieldProtocolUpdateReadinessSignal"),
  @JsonSubTypes.Type(value = ValidatorFieldStateSubstate.class, name = "ValidatorFieldState"),
})

public class MultiResourcePoolFieldStateSubstate extends Substate {
  public static final String JSON_PROPERTY_VAULTS = "vaults";
  private List<PoolVault> vaults = new ArrayList<>();

  public static final String JSON_PROPERTY_POOL_UNIT_RESOURCE_ADDRESS = "pool_unit_resource_address";
  private String poolUnitResourceAddress;

  public MultiResourcePoolFieldStateSubstate() { 
  }

  public MultiResourcePoolFieldStateSubstate vaults(List<PoolVault> vaults) {
    this.vaults = vaults;
    return this;
  }

  public MultiResourcePoolFieldStateSubstate addVaultsItem(PoolVault vaultsItem) {
    this.vaults.add(vaultsItem);
    return this;
  }

   /**
   * Get vaults
   * @return vaults
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_VAULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<PoolVault> getVaults() {
    return vaults;
  }


  @JsonProperty(JSON_PROPERTY_VAULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setVaults(List<PoolVault> vaults) {
    this.vaults = vaults;
  }


  public MultiResourcePoolFieldStateSubstate poolUnitResourceAddress(String poolUnitResourceAddress) {
    this.poolUnitResourceAddress = poolUnitResourceAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the resource address
   * @return poolUnitResourceAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the resource address")
  @JsonProperty(JSON_PROPERTY_POOL_UNIT_RESOURCE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getPoolUnitResourceAddress() {
    return poolUnitResourceAddress;
  }


  @JsonProperty(JSON_PROPERTY_POOL_UNIT_RESOURCE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPoolUnitResourceAddress(String poolUnitResourceAddress) {
    this.poolUnitResourceAddress = poolUnitResourceAddress;
  }


  /**
   * Return true if this MultiResourcePoolFieldStateSubstate object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MultiResourcePoolFieldStateSubstate multiResourcePoolFieldStateSubstate = (MultiResourcePoolFieldStateSubstate) o;
    return Objects.equals(this.vaults, multiResourcePoolFieldStateSubstate.vaults) &&
        Objects.equals(this.poolUnitResourceAddress, multiResourcePoolFieldStateSubstate.poolUnitResourceAddress) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vaults, poolUnitResourceAddress, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MultiResourcePoolFieldStateSubstate {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    vaults: ").append(toIndentedString(vaults)).append("\n");
    sb.append("    poolUnitResourceAddress: ").append(toIndentedString(poolUnitResourceAddress)).append("\n");
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
  mappings.put("AccessControllerFieldState", AccessControllerFieldStateSubstate.class);
  mappings.put("AccessRulesModuleFieldOwnerRole", AccessRulesModuleFieldOwnerRoleSubstate.class);
  mappings.put("AccessRulesModuleRuleEntry", AccessRulesModuleRuleEntrySubstate.class);
  mappings.put("AccountDepositRuleIndexEntry", AccountDepositRuleIndexEntrySubstate.class);
  mappings.put("AccountFieldState", AccountFieldStateSubstate.class);
  mappings.put("AccountVaultIndexEntry", AccountVaultIndexEntrySubstate.class);
  mappings.put("ConsensusManagerFieldConfig", ConsensusManagerFieldConfigSubstate.class);
  mappings.put("ConsensusManagerFieldCurrentProposalStatistic", ConsensusManagerFieldCurrentProposalStatisticSubstate.class);
  mappings.put("ConsensusManagerFieldCurrentTime", ConsensusManagerFieldCurrentTimeSubstate.class);
  mappings.put("ConsensusManagerFieldCurrentTimeRoundedToMinutes", ConsensusManagerFieldCurrentTimeRoundedToMinutesSubstate.class);
  mappings.put("ConsensusManagerFieldCurrentValidatorSet", ConsensusManagerFieldCurrentValidatorSetSubstate.class);
  mappings.put("ConsensusManagerFieldState", ConsensusManagerFieldStateSubstate.class);
  mappings.put("ConsensusManagerFieldValidatorRewards", ConsensusManagerFieldValidatorRewardsSubstate.class);
  mappings.put("ConsensusManagerRegisteredValidatorsByStakeIndexEntry", ConsensusManagerRegisteredValidatorsByStakeIndexEntrySubstate.class);
  mappings.put("FungibleResourceManagerFieldDivisibility", FungibleResourceManagerFieldDivisibilitySubstate.class);
  mappings.put("FungibleResourceManagerFieldTotalSupply", FungibleResourceManagerFieldTotalSupplySubstate.class);
  mappings.put("FungibleVaultFieldBalance", FungibleVaultFieldBalanceSubstate.class);
  mappings.put("FungibleVaultFieldFrozenStatus", FungibleVaultFieldFrozenStatusSubstate.class);
  mappings.put("GenericKeyValueStoreEntry", GenericKeyValueStoreEntrySubstate.class);
  mappings.put("GenericScryptoComponentFieldState", GenericScryptoComponentFieldStateSubstate.class);
  mappings.put("MetadataModuleEntry", MetadataModuleEntrySubstate.class);
  mappings.put("MultiResourcePoolFieldState", MultiResourcePoolFieldStateSubstate.class);
  mappings.put("NonFungibleResourceManagerDataEntry", NonFungibleResourceManagerDataEntrySubstate.class);
  mappings.put("NonFungibleResourceManagerFieldIdType", NonFungibleResourceManagerFieldIdTypeSubstate.class);
  mappings.put("NonFungibleResourceManagerFieldMutableFields", NonFungibleResourceManagerFieldMutableFieldsSubstate.class);
  mappings.put("NonFungibleResourceManagerFieldTotalSupply", NonFungibleResourceManagerFieldTotalSupplySubstate.class);
  mappings.put("NonFungibleVaultContentsIndexEntry", NonFungibleVaultContentsIndexEntrySubstate.class);
  mappings.put("NonFungibleVaultFieldBalance", NonFungibleVaultFieldBalanceSubstate.class);
  mappings.put("NonFungibleVaultFieldFrozenStatus", NonFungibleVaultFieldFrozenStatusSubstate.class);
  mappings.put("OneResourcePoolFieldState", OneResourcePoolFieldStateSubstate.class);
  mappings.put("PackageBlueprintAuthTemplateEntry", PackageBlueprintAuthTemplateEntrySubstate.class);
  mappings.put("PackageBlueprintDefinitionEntry", PackageBlueprintDefinitionEntrySubstate.class);
  mappings.put("PackageBlueprintDependenciesEntry", PackageBlueprintDependenciesEntrySubstate.class);
  mappings.put("PackageBlueprintRoyaltyEntry", PackageBlueprintRoyaltyEntrySubstate.class);
  mappings.put("PackageCodeEntry", PackageCodeEntrySubstate.class);
  mappings.put("PackageFieldRoyaltyAccumulator", PackageFieldRoyaltyAccumulatorSubstate.class);
  mappings.put("PackageSchemaEntry", PackageSchemaEntrySubstate.class);
  mappings.put("RoyaltyMethodRoyaltyEntry", RoyaltyMethodRoyaltyEntrySubstate.class);
  mappings.put("RoyaltyModuleFieldState", RoyaltyModuleFieldStateSubstate.class);
  mappings.put("TransactionTrackerCollectionEntry", TransactionTrackerCollectionEntrySubstate.class);
  mappings.put("TransactionTrackerFieldState", TransactionTrackerFieldStateSubstate.class);
  mappings.put("TwoResourcePoolFieldState", TwoResourcePoolFieldStateSubstate.class);
  mappings.put("TypeInfoModuleFieldTypeInfo", TypeInfoModuleFieldTypeInfoSubstate.class);
  mappings.put("ValidatorFieldProtocolUpdateReadinessSignal", ValidatorFieldProtocolUpdateReadinessSignalSubstate.class);
  mappings.put("ValidatorFieldState", ValidatorFieldStateSubstate.class);
  mappings.put("MultiResourcePoolFieldStateSubstate", MultiResourcePoolFieldStateSubstate.class);
  JSON.registerDiscriminator(MultiResourcePoolFieldStateSubstate.class, "substate_type", mappings);
}
}

