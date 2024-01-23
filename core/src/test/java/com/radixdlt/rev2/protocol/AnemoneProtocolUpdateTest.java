/* Copyright 2021 Radix Publishing Ltd incorporated in Jersey (Channel Islands).
 *
 * Licensed under the Radix License, Version 1.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at:
 *
 * radixfoundation.org/licenses/LICENSE-v1
 *
 * The Licensor hereby grants permission for the Canonical version of the Work to be
 * published, distributed and used under or by reference to the Licensor’s trademark
 * Radix ® and use of any unregistered trade names, logos or get-up.
 *
 * The Licensor provides the Work (and each Contributor provides its Contributions) on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * including, without limitation, any warranties or conditions of TITLE, NON-INFRINGEMENT,
 * MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Whilst the Work is capable of being deployed, used and adopted (instantiated) to create
 * a distributed ledger it is your responsibility to test and validate the code, together
 * with all logic and performance of that code under all foreseeable scenarios.
 *
 * The Licensor does not make or purport to make and hereby excludes liability for all
 * and any representation, warranty or undertaking in any form whatsoever, whether express
 * or implied, to any entity or person, including any representation, warranty or
 * undertaking, as to the functionality security use, value or other characteristics of
 * any distributed ledger nor in respect the functioning or value of any tokens which may
 * be created stored or transferred using the Work. The Licensor does not warrant that the
 * Work or any use of the Work complies with any law or regulation in any territory where
 * it may be implemented or used or that it will be appropriate for any specific purpose.
 *
 * Neither the licensor nor any current or former employees, officers, directors, partners,
 * trustees, representatives, agents, advisors, contractors, or volunteers of the Licensor
 * shall be liable for any direct or indirect, special, incidental, consequential or other
 * losses of any kind, in tort, contract or otherwise (including but not limited to loss
 * of revenue, income or profits, or loss of use or data, or loss of reputation, or loss
 * of any economic or other opportunity of whatsoever nature or howsoever arising), arising
 * out of or in connection with (without limitation of any use, misuse, of any ledger system
 * or use made or its functionality or any performance or operation of any code or protocol
 * caused by bugs or programming or logic errors or otherwise);
 *
 * A. any offer, purchase, holding, use, sale, exchange or transmission of any
 * cryptographic keys, tokens or assets created, exchanged, stored or arising from any
 * interaction with the Work;
 *
 * B. any failure in a transmission or loss of any token or assets keys or other digital
 * artefacts due to errors in transmission;
 *
 * C. bugs, hacks, logic errors or faults in the Work or any communication;
 *
 * D. system software or apparatus including but not limited to losses caused by errors
 * in holding or transmitting tokens by any third-party;
 *
 * E. breaches or failure of security including hacker attacks, loss or disclosure of
 * password, loss of private key, unauthorised use or misuse of such passwords or keys;
 *
 * F. any losses including loss of anticipated savings or other benefits resulting from
 * use of the Work or any changes to the Work (however implemented).
 *
 * You are solely responsible for; testing, validating and evaluation of all operation
 * logic, functionality, security and appropriateness of using the Work for any commercial
 * or non-commercial purpose and for any reproduction or redistribution by You of the
 * Work. You assume all risks associated with Your use of the Work and the exercise of
 * permissions under this License.
 */

package com.radixdlt.rev2.protocol;

import static com.radixdlt.environment.deterministic.network.MessageSelector.firstSelector;
import static com.radixdlt.harness.predicates.NodePredicate.committedFailedUserTransaction;
import static com.radixdlt.harness.predicates.NodesPredicate.*;
import static com.radixdlt.protocol.ProtocolUpdateEnactmentCondition.unconditionallyAtEpoch;
import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Streams;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.ProvidesIntoSet;
import com.radixdlt.api.CoreApiServer;
import com.radixdlt.api.CoreApiServerModule;
import com.radixdlt.api.core.generated.api.StreamApi;
import com.radixdlt.api.core.generated.client.ApiClient;
import com.radixdlt.api.core.generated.models.*;
import com.radixdlt.environment.CoreApiServerFlags;
import com.radixdlt.environment.EventDispatcher;
import com.radixdlt.environment.StartProcessorOnRunner;
import com.radixdlt.environment.deterministic.network.MessageMutator;
import com.radixdlt.genesis.GenesisBuilder;
import com.radixdlt.genesis.GenesisConsensusManagerConfig;
import com.radixdlt.harness.deterministic.DeterministicTest;
import com.radixdlt.harness.deterministic.PhysicalNodeConfig;
import com.radixdlt.mempool.MempoolAdd;
import com.radixdlt.modules.FunctionalRadixNodeModule;
import com.radixdlt.modules.StateComputerConfig;
import com.radixdlt.networks.Network;
import com.radixdlt.protocol.ProtocolConfig;
import com.radixdlt.protocol.ProtocolUpdateTrigger;
import com.radixdlt.rev2.*;
import com.radixdlt.statecomputer.RustStateComputer;
import com.radixdlt.transactions.PreparedNotarizedTransaction;
import com.radixdlt.utils.FreePortFinder;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public final class AnemoneProtocolUpdateTest {
  private static final String PROTOCOL_VERSION_NAME = ProtocolUpdateTrigger.ANEMONE;
  private static final long PROTOCOL_UPDATE_EPOCH = 4L;

  // Enact anemone at fixed epoch 4
  private static final ProtocolConfig PROTOCOL_CONFIG =
      new ProtocolConfig(
          ImmutableList.of(
              new ProtocolUpdateTrigger(
                  PROTOCOL_VERSION_NAME, unconditionallyAtEpoch(PROTOCOL_UPDATE_EPOCH))));

  @Rule public TemporaryFolder folder = new TemporaryFolder();

  private DeterministicTest createTest(Module... extraModules) {
    return DeterministicTest.builder()
        .addPhysicalNodes(PhysicalNodeConfig.createBatch(1, true))
        .messageSelector(firstSelector())
        .messageMutator(MessageMutator.dropTimeouts())
        .addModules(extraModules)
        .functionalNodeModule(
            new FunctionalRadixNodeModule(
                FunctionalRadixNodeModule.NodeStorageConfig.tempFolder(folder),
                true,
                FunctionalRadixNodeModule.SafetyRecoveryConfig.BERKELEY_DB,
                FunctionalRadixNodeModule.ConsensusConfig.of(1000),
                FunctionalRadixNodeModule.LedgerConfig.stateComputerNoSync(
                    StateComputerConfig.rev2(
                        Network.INTEGRATIONTESTNET.getId(),
                        GenesisBuilder.createTestGenesisWithNumValidators(
                            1,
                            Decimal.ONE,
                            GenesisConsensusManagerConfig.Builder.testWithRoundsPerEpoch(5)),
                        StateComputerConfig.REV2ProposerConfig.Mempool.singleTransaction(),
                        PROTOCOL_CONFIG))));
  }

  private PreparedNotarizedTransaction createGetTimeCallTxn(boolean secondPrecision) {
    final var rawEnumValue = secondPrecision ? 1 : 0;
    return TransactionBuilder.forTests()
        .manifest(
            Manifest.singleMethodCall(
                ScryptoConstants.CONSENSUS_MANAGER_COMPONENT_ADDRESS,
                "get_current_time",
                "Enum<" + rawEnumValue + "u8>()"))
        .prepare();
  }

  @Test
  public void test_get_current_time_second_precision() {
    try (var test = createTest()) {
      // Arrange: Start single node network
      test.startAllNodes();
      final var mempoolDispatcher =
          test.getInstance(0, Key.get(new TypeLiteral<EventDispatcher<MempoolAdd>>() {}));

      // Act & Assert #1: Submit TimePrecision::Minute transaction and expect a success
      final var minutePrecisionBeforeTx = createGetTimeCallTxn(false).raw();
      mempoolDispatcher.dispatch(MempoolAdd.create(minutePrecisionBeforeTx));
      test.runUntilState(allCommittedTransactionSuccess(minutePrecisionBeforeTx));

      // Act & Assert #2: Submit TimePrecision::Second transaction and expect a failure
      final var secondPrecisionBeforeTx = createGetTimeCallTxn(true).raw();
      mempoolDispatcher.dispatch(MempoolAdd.create(secondPrecisionBeforeTx));
      test.runUntilState(allNodesMatch(committedFailedUserTransaction(secondPrecisionBeforeTx)));

      // Act & Assert #3: Run until protocol update epoch and verify protocol update
      test.runUntilState(allAtOrOverEpoch(PROTOCOL_UPDATE_EPOCH));

      assertEquals(
          PROTOCOL_VERSION_NAME,
          test.getInstance(0, RustStateComputer.class).protocolState().currentProtocolVersion());
      final var postProtocolUpdateProof =
          test.getInstance(0, REv2TransactionsAndProofReader.class)
              .getLatestProofBundle()
              .orElseThrow();
      assertEquals(
          PROTOCOL_VERSION_NAME,
          postProtocolUpdateProof
              .closestProtocolUpdateInitProofOnOrBefore()
              .unwrap()
              .ledgerHeader()
              .nextProtocolVersion()
              .unwrap());

      // Act & Assert #4: Submit TimePrecision::Minute transaction and expect a success
      final var minutePrecisionAfterTx = createGetTimeCallTxn(false).raw();
      mempoolDispatcher.dispatch(MempoolAdd.create(minutePrecisionAfterTx));
      test.runUntilState(allCommittedTransactionSuccess(minutePrecisionAfterTx));

      // Act & Assert #5: Submit TimePrecision::Second transaction and expect a success
      final var secondPrecisionAfterTx = createGetTimeCallTxn(true).raw();
      mempoolDispatcher.dispatch(MempoolAdd.create(secondPrecisionAfterTx));
      test.runUntilState(allCommittedTransactionSuccess(secondPrecisionAfterTx));
    }
  }

  @Test
  public void core_api_streams_anemone_flash_transactions() throws Exception {
    final var coreApiPort = FreePortFinder.findFreeLocalPort();
    try (var test = createTest(createCoreApiModule(coreApiPort))) {
      // Start a single node network and run until protocol update:
      test.startAllNodes();
      test.runUntilState(allAtOrOverEpoch(PROTOCOL_UPDATE_EPOCH));

      // Fetch all flash transactions:
      final var apiClient = new ApiClient();
      apiClient.updateBaseUri("http://127.0.0.1:" + coreApiPort + "/core");
      final var committedFlashTransactions =
          new StreamApi(apiClient)
                  .streamTransactionsPost(
                      new StreamTransactionsRequest()
                          .network(Network.INTEGRATIONTESTNET.getLogicalName())
                          .limit(1000)
                          .fromStateVersion(1L))
                  .getTransactions()
                  .stream()
                  .filter(
                      txn -> txn.getLedgerTransaction().getType() == LedgerTransactionType.FLASH)
                  .toList();

      final var flashTransactions =
          committedFlashTransactions.stream()
              .map(txn -> (FlashLedgerTransaction) txn.getLedgerTransaction())
              .toList();
      final var transactionNames =
          flashTransactions.stream().map(FlashLedgerTransaction::getName).toList();
      final var flashStateUpdates =
          flashTransactions.stream().map(FlashLedgerTransaction::getFlashedStateUpdates).toList();
      final var receiptStateUpdates =
          committedFlashTransactions.stream()
              .map(txn -> txn.getReceipt().getStateUpdates())
              .toList();

      // Assert some known facts about Anemone's flashes:
      assertEquals(
          transactionNames,
          Arrays.asList(
              "anemone-validator-fee-fix",
              "anemone-seconds-precision",
              "anemone-vm-boot",
              "anemone-pools"));

      Streams.forEachPair(
          flashStateUpdates.stream(),
          receiptStateUpdates.stream(),
          (fromFlash, fromReceipt) -> {
            // all deleted partitions specified by flash were really deleted:
            assertEquals(fromFlash.getDeletedPartitions(), fromReceipt.getDeletedPartitions());

            // substate values set by flash transactions end up as the receipt's created + updated:
            final var setFromFlash =
                fromFlash.getSetSubstates().stream()
                    .collect(
                        Collectors.toMap(
                            FlashSetSubstate::getSubstateId, FlashSetSubstate::getValue));
            final var setFromReceipt =
                Streams.concat(
                        fromReceipt.getCreatedSubstates().stream()
                            .map(create -> Map.entry(create.getSubstateId(), create.getValue())),
                        fromReceipt.getUpdatedSubstates().stream()
                            .map(update -> Map.entry(update.getSubstateId(), update.getNewValue())))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            assertEquals(setFromFlash, setFromReceipt);

            // and the same for deletes:
            final var deletedFromReceipt =
                fromReceipt.getDeletedSubstates().stream()
                    .map(DeletedSubstate::getSubstateId)
                    .toList();
            assertEquals(fromFlash.getDeletedSubstates(), deletedFromReceipt);
          });
    }
  }

  private static Module createCoreApiModule(int coreApiPort) {
    return new AbstractModule() {

      @Override
      protected void configure() {
        install(new CoreApiServerModule("127.0.0.1", coreApiPort, new CoreApiServerFlags(true)));
      }

      @ProvidesIntoSet
      private StartProcessorOnRunner startCoreApi(CoreApiServer coreApiServer) {
        // This is a slightly hacky way to run something on node start-up in a Deterministic test.
        // Stop is called by the AutoClosable binding in CoreApiServerModule
        return new StartProcessorOnRunner("N/A", coreApiServer::start);
      }
    };
  }
}
