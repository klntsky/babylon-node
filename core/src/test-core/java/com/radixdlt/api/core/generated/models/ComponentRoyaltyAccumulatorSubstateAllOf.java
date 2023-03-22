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
import com.radixdlt.api.core.generated.models.EntityReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ComponentRoyaltyAccumulatorSubstateAllOf
 */
@JsonPropertyOrder({
  ComponentRoyaltyAccumulatorSubstateAllOf.JSON_PROPERTY_VAULT_ENTITY
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ComponentRoyaltyAccumulatorSubstateAllOf {
  public static final String JSON_PROPERTY_VAULT_ENTITY = "vault_entity";
  private EntityReference vaultEntity;

  public ComponentRoyaltyAccumulatorSubstateAllOf() { 
  }

  public ComponentRoyaltyAccumulatorSubstateAllOf vaultEntity(EntityReference vaultEntity) {
    this.vaultEntity = vaultEntity;
    return this;
  }

   /**
   * Get vaultEntity
   * @return vaultEntity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_VAULT_ENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public EntityReference getVaultEntity() {
    return vaultEntity;
  }


  @JsonProperty(JSON_PROPERTY_VAULT_ENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVaultEntity(EntityReference vaultEntity) {
    this.vaultEntity = vaultEntity;
  }


  /**
   * Return true if this ComponentRoyaltyAccumulatorSubstate_allOf object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ComponentRoyaltyAccumulatorSubstateAllOf componentRoyaltyAccumulatorSubstateAllOf = (ComponentRoyaltyAccumulatorSubstateAllOf) o;
    return Objects.equals(this.vaultEntity, componentRoyaltyAccumulatorSubstateAllOf.vaultEntity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vaultEntity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ComponentRoyaltyAccumulatorSubstateAllOf {\n");
    sb.append("    vaultEntity: ").append(toIndentedString(vaultEntity)).append("\n");
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

