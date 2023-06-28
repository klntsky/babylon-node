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
import com.radixdlt.api.core.generated.models.ConsensusManagerFieldConfigSubstateAllOf;
import com.radixdlt.api.core.generated.models.ConsensusManagerFieldCurrentProposalStatisticSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerFieldCurrentTimeRoundedToMinutesSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerFieldCurrentTimeSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerFieldCurrentValidatorSetSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerFieldStateSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerFieldValidatorRewardsSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerRegisteredValidatorsByStakeIndexEntrySubstate;
import com.radixdlt.api.core.generated.models.EpochChangeCondition;
import com.radixdlt.api.core.generated.models.FungibleResourceManagerFieldDivisibilitySubstate;
import com.radixdlt.api.core.generated.models.FungibleResourceManagerFieldTotalSupplySubstate;
import com.radixdlt.api.core.generated.models.FungibleVaultFieldBalanceSubstate;
import com.radixdlt.api.core.generated.models.FungibleVaultFieldFrozenStatusSubstate;
import com.radixdlt.api.core.generated.models.GenericKeyValueStoreEntrySubstate;
import com.radixdlt.api.core.generated.models.GenericScryptoComponentFieldStateSubstate;
import com.radixdlt.api.core.generated.models.MetadataModuleEntrySubstate;
import com.radixdlt.api.core.generated.models.MultiResourcePoolFieldStateSubstate;
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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * ConsensusManagerFieldConfigSubstate
 */
@JsonPropertyOrder({
  ConsensusManagerFieldConfigSubstate.JSON_PROPERTY_MAX_VALIDATORS,
  ConsensusManagerFieldConfigSubstate.JSON_PROPERTY_EPOCH_CHANGE_CONDITION,
  ConsensusManagerFieldConfigSubstate.JSON_PROPERTY_NUM_UNSTAKE_EPOCHS,
  ConsensusManagerFieldConfigSubstate.JSON_PROPERTY_TOTAL_EMISSION_XRD_PER_EPOCH,
  ConsensusManagerFieldConfigSubstate.JSON_PROPERTY_MIN_VALIDATOR_RELIABILITY,
  ConsensusManagerFieldConfigSubstate.JSON_PROPERTY_NUM_OWNER_STAKE_UNITS_UNLOCK_EPOCHS,
  ConsensusManagerFieldConfigSubstate.JSON_PROPERTY_NUM_FEE_INCREASE_DELAY_EPOCHS,
  ConsensusManagerFieldConfigSubstate.JSON_PROPERTY_VALIDATOR_CREATION_XRD_COST
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

public class ConsensusManagerFieldConfigSubstate extends Substate {
  public static final String JSON_PROPERTY_MAX_VALIDATORS = "max_validators";
  private Long maxValidators;

  public static final String JSON_PROPERTY_EPOCH_CHANGE_CONDITION = "epoch_change_condition";
  private EpochChangeCondition epochChangeCondition;

  public static final String JSON_PROPERTY_NUM_UNSTAKE_EPOCHS = "num_unstake_epochs";
  private Long numUnstakeEpochs;

  public static final String JSON_PROPERTY_TOTAL_EMISSION_XRD_PER_EPOCH = "total_emission_xrd_per_epoch";
  private String totalEmissionXrdPerEpoch;

  public static final String JSON_PROPERTY_MIN_VALIDATOR_RELIABILITY = "min_validator_reliability";
  private String minValidatorReliability;

  public static final String JSON_PROPERTY_NUM_OWNER_STAKE_UNITS_UNLOCK_EPOCHS = "num_owner_stake_units_unlock_epochs";
  private Long numOwnerStakeUnitsUnlockEpochs;

  public static final String JSON_PROPERTY_NUM_FEE_INCREASE_DELAY_EPOCHS = "num_fee_increase_delay_epochs";
  private Long numFeeIncreaseDelayEpochs;

  public static final String JSON_PROPERTY_VALIDATOR_CREATION_XRD_COST = "validator_creation_xrd_cost";
  private String validatorCreationXrdCost;

  public ConsensusManagerFieldConfigSubstate() { 
  }

  public ConsensusManagerFieldConfigSubstate maxValidators(Long maxValidators) {
    this.maxValidators = maxValidators;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, specifying the maximum number of validators in the active validator set. 
   * minimum: 0
   * maximum: 10000000000
   * @return maxValidators
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^10`, specifying the maximum number of validators in the active validator set. ")
  @JsonProperty(JSON_PROPERTY_MAX_VALIDATORS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getMaxValidators() {
    return maxValidators;
  }


  @JsonProperty(JSON_PROPERTY_MAX_VALIDATORS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMaxValidators(Long maxValidators) {
    this.maxValidators = maxValidators;
  }


  public ConsensusManagerFieldConfigSubstate epochChangeCondition(EpochChangeCondition epochChangeCondition) {
    this.epochChangeCondition = epochChangeCondition;
    return this;
  }

   /**
   * Get epochChangeCondition
   * @return epochChangeCondition
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_EPOCH_CHANGE_CONDITION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EpochChangeCondition getEpochChangeCondition() {
    return epochChangeCondition;
  }


  @JsonProperty(JSON_PROPERTY_EPOCH_CHANGE_CONDITION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEpochChangeCondition(EpochChangeCondition epochChangeCondition) {
    this.epochChangeCondition = epochChangeCondition;
  }


  public ConsensusManagerFieldConfigSubstate numUnstakeEpochs(Long numUnstakeEpochs) {
    this.numUnstakeEpochs = numUnstakeEpochs;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, specifying the minimum number of epochs before an unstaker can withdraw their XRD. 
   * minimum: 0
   * maximum: 10000000000
   * @return numUnstakeEpochs
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^10`, specifying the minimum number of epochs before an unstaker can withdraw their XRD. ")
  @JsonProperty(JSON_PROPERTY_NUM_UNSTAKE_EPOCHS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getNumUnstakeEpochs() {
    return numUnstakeEpochs;
  }


  @JsonProperty(JSON_PROPERTY_NUM_UNSTAKE_EPOCHS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNumUnstakeEpochs(Long numUnstakeEpochs) {
    this.numUnstakeEpochs = numUnstakeEpochs;
  }


  public ConsensusManagerFieldConfigSubstate totalEmissionXrdPerEpoch(String totalEmissionXrdPerEpoch) {
    this.totalEmissionXrdPerEpoch = totalEmissionXrdPerEpoch;
    return this;
  }

   /**
   * A string-encoded fixed-precision decimal to 18 decimal places. A decimal is formed of some signed integer &#x60;m&#x60; of attos (&#x60;10^(-18)&#x60;) units, where &#x60;-2^(256 - 1) &lt;&#x3D; m &lt; 2^(256 - 1)&#x60;. 
   * @return totalEmissionXrdPerEpoch
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A string-encoded fixed-precision decimal to 18 decimal places. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. ")
  @JsonProperty(JSON_PROPERTY_TOTAL_EMISSION_XRD_PER_EPOCH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTotalEmissionXrdPerEpoch() {
    return totalEmissionXrdPerEpoch;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL_EMISSION_XRD_PER_EPOCH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTotalEmissionXrdPerEpoch(String totalEmissionXrdPerEpoch) {
    this.totalEmissionXrdPerEpoch = totalEmissionXrdPerEpoch;
  }


  public ConsensusManagerFieldConfigSubstate minValidatorReliability(String minValidatorReliability) {
    this.minValidatorReliability = minValidatorReliability;
    return this;
  }

   /**
   * A string-encoded fixed-precision decimal to 18 decimal places. A decimal is formed of some signed integer &#x60;m&#x60; of attos (&#x60;10^(-18)&#x60;) units, where &#x60;-2^(256 - 1) &lt;&#x3D; m &lt; 2^(256 - 1)&#x60;. 
   * @return minValidatorReliability
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A string-encoded fixed-precision decimal to 18 decimal places. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. ")
  @JsonProperty(JSON_PROPERTY_MIN_VALIDATOR_RELIABILITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getMinValidatorReliability() {
    return minValidatorReliability;
  }


  @JsonProperty(JSON_PROPERTY_MIN_VALIDATOR_RELIABILITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMinValidatorReliability(String minValidatorReliability) {
    this.minValidatorReliability = minValidatorReliability;
  }


  public ConsensusManagerFieldConfigSubstate numOwnerStakeUnitsUnlockEpochs(Long numOwnerStakeUnitsUnlockEpochs) {
    this.numOwnerStakeUnitsUnlockEpochs = numOwnerStakeUnitsUnlockEpochs;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, specifying the minimum number of epochs before an owner can take their stake units after attempting to withdraw them. 
   * minimum: 0
   * maximum: 10000000000
   * @return numOwnerStakeUnitsUnlockEpochs
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^10`, specifying the minimum number of epochs before an owner can take their stake units after attempting to withdraw them. ")
  @JsonProperty(JSON_PROPERTY_NUM_OWNER_STAKE_UNITS_UNLOCK_EPOCHS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getNumOwnerStakeUnitsUnlockEpochs() {
    return numOwnerStakeUnitsUnlockEpochs;
  }


  @JsonProperty(JSON_PROPERTY_NUM_OWNER_STAKE_UNITS_UNLOCK_EPOCHS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNumOwnerStakeUnitsUnlockEpochs(Long numOwnerStakeUnitsUnlockEpochs) {
    this.numOwnerStakeUnitsUnlockEpochs = numOwnerStakeUnitsUnlockEpochs;
  }


  public ConsensusManagerFieldConfigSubstate numFeeIncreaseDelayEpochs(Long numFeeIncreaseDelayEpochs) {
    this.numFeeIncreaseDelayEpochs = numFeeIncreaseDelayEpochs;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, specifying the minimum number of epochs before a fee increase takes effect. 
   * minimum: 0
   * maximum: 10000000000
   * @return numFeeIncreaseDelayEpochs
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^10`, specifying the minimum number of epochs before a fee increase takes effect. ")
  @JsonProperty(JSON_PROPERTY_NUM_FEE_INCREASE_DELAY_EPOCHS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getNumFeeIncreaseDelayEpochs() {
    return numFeeIncreaseDelayEpochs;
  }


  @JsonProperty(JSON_PROPERTY_NUM_FEE_INCREASE_DELAY_EPOCHS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNumFeeIncreaseDelayEpochs(Long numFeeIncreaseDelayEpochs) {
    this.numFeeIncreaseDelayEpochs = numFeeIncreaseDelayEpochs;
  }


  public ConsensusManagerFieldConfigSubstate validatorCreationXrdCost(String validatorCreationXrdCost) {
    this.validatorCreationXrdCost = validatorCreationXrdCost;
    return this;
  }

   /**
   * The amount of XRD required to be passed in a bucket to create a validator. A decimal is formed of some signed integer &#x60;m&#x60; of attos (&#x60;10^(-18)&#x60;) units, where &#x60;-2^(256 - 1) &lt;&#x3D; m &lt; 2^(256 - 1)&#x60;. 
   * @return validatorCreationXrdCost
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The amount of XRD required to be passed in a bucket to create a validator. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. ")
  @JsonProperty(JSON_PROPERTY_VALIDATOR_CREATION_XRD_COST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getValidatorCreationXrdCost() {
    return validatorCreationXrdCost;
  }


  @JsonProperty(JSON_PROPERTY_VALIDATOR_CREATION_XRD_COST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValidatorCreationXrdCost(String validatorCreationXrdCost) {
    this.validatorCreationXrdCost = validatorCreationXrdCost;
  }


  /**
   * Return true if this ConsensusManagerFieldConfigSubstate object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsensusManagerFieldConfigSubstate consensusManagerFieldConfigSubstate = (ConsensusManagerFieldConfigSubstate) o;
    return Objects.equals(this.maxValidators, consensusManagerFieldConfigSubstate.maxValidators) &&
        Objects.equals(this.epochChangeCondition, consensusManagerFieldConfigSubstate.epochChangeCondition) &&
        Objects.equals(this.numUnstakeEpochs, consensusManagerFieldConfigSubstate.numUnstakeEpochs) &&
        Objects.equals(this.totalEmissionXrdPerEpoch, consensusManagerFieldConfigSubstate.totalEmissionXrdPerEpoch) &&
        Objects.equals(this.minValidatorReliability, consensusManagerFieldConfigSubstate.minValidatorReliability) &&
        Objects.equals(this.numOwnerStakeUnitsUnlockEpochs, consensusManagerFieldConfigSubstate.numOwnerStakeUnitsUnlockEpochs) &&
        Objects.equals(this.numFeeIncreaseDelayEpochs, consensusManagerFieldConfigSubstate.numFeeIncreaseDelayEpochs) &&
        Objects.equals(this.validatorCreationXrdCost, consensusManagerFieldConfigSubstate.validatorCreationXrdCost) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxValidators, epochChangeCondition, numUnstakeEpochs, totalEmissionXrdPerEpoch, minValidatorReliability, numOwnerStakeUnitsUnlockEpochs, numFeeIncreaseDelayEpochs, validatorCreationXrdCost, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsensusManagerFieldConfigSubstate {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    maxValidators: ").append(toIndentedString(maxValidators)).append("\n");
    sb.append("    epochChangeCondition: ").append(toIndentedString(epochChangeCondition)).append("\n");
    sb.append("    numUnstakeEpochs: ").append(toIndentedString(numUnstakeEpochs)).append("\n");
    sb.append("    totalEmissionXrdPerEpoch: ").append(toIndentedString(totalEmissionXrdPerEpoch)).append("\n");
    sb.append("    minValidatorReliability: ").append(toIndentedString(minValidatorReliability)).append("\n");
    sb.append("    numOwnerStakeUnitsUnlockEpochs: ").append(toIndentedString(numOwnerStakeUnitsUnlockEpochs)).append("\n");
    sb.append("    numFeeIncreaseDelayEpochs: ").append(toIndentedString(numFeeIncreaseDelayEpochs)).append("\n");
    sb.append("    validatorCreationXrdCost: ").append(toIndentedString(validatorCreationXrdCost)).append("\n");
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
  mappings.put("ConsensusManagerFieldConfigSubstate", ConsensusManagerFieldConfigSubstate.class);
  JSON.registerDiscriminator(ConsensusManagerFieldConfigSubstate.class, "substate_type", mappings);
}
}

