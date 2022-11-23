/*
 * Babylon Core API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.1.0
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
import com.radixdlt.api.core.generated.models.LedgerTransaction;
import com.radixdlt.api.core.generated.models.ParsedLedgerTransactionAllOf;
import com.radixdlt.api.core.generated.models.ParsedLedgerTransactionAllOfIdentifiers;
import com.radixdlt.api.core.generated.models.ParsedTransactionType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ParsedLedgerTransaction
 */
@JsonPropertyOrder({
  ParsedLedgerTransaction.JSON_PROPERTY_LEDGER_TRANSACTION,
  ParsedLedgerTransaction.JSON_PROPERTY_IDENTIFIERS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ParsedLedgerTransaction {
  public static final String JSON_PROPERTY_LEDGER_TRANSACTION = "ledger_transaction";
  private LedgerTransaction ledgerTransaction;

  public static final String JSON_PROPERTY_IDENTIFIERS = "identifiers";
  private ParsedLedgerTransactionAllOfIdentifiers identifiers;

  public ParsedLedgerTransaction() { 
  }

  public ParsedLedgerTransaction ledgerTransaction(LedgerTransaction ledgerTransaction) {
    this.ledgerTransaction = ledgerTransaction;
    return this;
  }

   /**
   * Get ledgerTransaction
   * @return ledgerTransaction
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_LEDGER_TRANSACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LedgerTransaction getLedgerTransaction() {
    return ledgerTransaction;
  }


  @JsonProperty(JSON_PROPERTY_LEDGER_TRANSACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLedgerTransaction(LedgerTransaction ledgerTransaction) {
    this.ledgerTransaction = ledgerTransaction;
  }


  public ParsedLedgerTransaction identifiers(ParsedLedgerTransactionAllOfIdentifiers identifiers) {
    this.identifiers = identifiers;
    return this;
  }

   /**
   * Get identifiers
   * @return identifiers
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_IDENTIFIERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ParsedLedgerTransactionAllOfIdentifiers getIdentifiers() {
    return identifiers;
  }


  @JsonProperty(JSON_PROPERTY_IDENTIFIERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIdentifiers(ParsedLedgerTransactionAllOfIdentifiers identifiers) {
    this.identifiers = identifiers;
  }


  /**
   * Return true if this ParsedLedgerTransaction object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParsedLedgerTransaction parsedLedgerTransaction = (ParsedLedgerTransaction) o;
    return Objects.equals(this.ledgerTransaction, parsedLedgerTransaction.ledgerTransaction) &&
        Objects.equals(this.identifiers, parsedLedgerTransaction.identifiers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ledgerTransaction, identifiers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParsedLedgerTransaction {\n");
    sb.append("    ledgerTransaction: ").append(toIndentedString(ledgerTransaction)).append("\n");
    sb.append("    identifiers: ").append(toIndentedString(identifiers)).append("\n");
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

