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

package com.radixdlt.harness.deterministic;

import com.google.common.collect.ImmutableList;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.TypeLiteral;
import com.google.inject.util.Modules;
import com.radixdlt.consensus.EpochNodeWeightMapping;
import com.radixdlt.consensus.MockedConsensusRecoveryModule;
import com.radixdlt.consensus.Proposal;
import com.radixdlt.consensus.bft.*;
import com.radixdlt.consensus.bft.Round;
import com.radixdlt.consensus.epoch.EpochRound;
import com.radixdlt.consensus.liveness.EpochLocalTimeoutOccurrence;
import com.radixdlt.crypto.ECKeyPair;
import com.radixdlt.environment.EventProcessor;
import com.radixdlt.environment.deterministic.network.ControlledMessage;
import com.radixdlt.environment.deterministic.network.DeterministicNetwork;
import com.radixdlt.environment.deterministic.network.MessageMutator;
import com.radixdlt.environment.deterministic.network.MessageSelector;
import com.radixdlt.ledger.LedgerUpdate;
import com.radixdlt.ledger.MockedLedgerRecoveryModule;
import com.radixdlt.messaging.TestMessagingModule;
import com.radixdlt.modules.FunctionalRadixNodeModule;
import com.radixdlt.modules.FunctionalRadixNodeModule.ConsensusConfig;
import com.radixdlt.modules.FunctionalRadixNodeModule.LedgerConfig;
import com.radixdlt.modules.FunctionalRadixNodeModule.MempoolType;
import com.radixdlt.modules.MockedCryptoModule;
import com.radixdlt.modules.MockedKeyModule;
import com.radixdlt.modules.StateComputerConfig;
import com.radixdlt.networks.Addressing;
import com.radixdlt.networks.Network;
import com.radixdlt.p2p.TestP2PModule;
import com.radixdlt.rev1.EpochMaxRound;
import com.radixdlt.rev2.modules.MockedPersistenceStoreModule;
import com.radixdlt.store.InMemoryCommittedReaderModule;
import com.radixdlt.sync.SyncConfig;
import com.radixdlt.utils.KeyComparator;
import com.radixdlt.utils.TimeSupplier;
import io.reactivex.rxjava3.schedulers.Timed;
import java.io.PrintStream;
import java.util.Objects;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * A deterministic test where each event that occurs in the network is emitted and processed
 * synchronously by the caller.
 */
public final class DeterministicTest {
  private final DeterministicNodes nodes;
  private final DeterministicNetwork network;

  private DeterministicTest(
      ImmutableList<BFTNode> nodes,
      MessageSelector messageSelector,
      MessageMutator messageMutator,
      Module baseModule,
      Module overrideModule) {
    this.network = new DeterministicNetwork(nodes, messageSelector, messageMutator);

    this.nodes = new DeterministicNodes(nodes, this.network, baseModule, overrideModule);
  }

  public static class Builder {
    private ImmutableList<BFTNode> nodes =
        ImmutableList.of(BFTNode.create(ECKeyPair.generateNew().getPublicKey()));
    private MessageSelector messageSelector = MessageSelector.firstSelector();
    private MessageMutator messageMutator = MessageMutator.nothing();
    private Function<Long, IntStream> epochToNodeIndexesMapping;
    private EpochNodeWeightMapping epochNodeWeightMapping;
    private Module overrideModule = null;
    private ImmutableList.Builder<Module> modules = ImmutableList.builder();

    private Builder() {
      // Nothing to do here
    }

    public Builder numNodes(int numNodes) {
      this.nodes =
          Stream.generate(ECKeyPair::generateNew)
              .limit(numNodes)
              .map(ECKeyPair::getPublicKey)
              .sorted(KeyComparator.instance())
              .map(BFTNode::create)
              .collect(ImmutableList.toImmutableList());
      return this;
    }

    /**
     * Override with an incorrect module which should cause a test to fail. TODO: Refactor to make
     * the link between incorrect module and failing test more explicit.
     *
     * @param module the incorrect module
     * @return the current builder
     */
    public Builder overrideWithIncorrectModule(Module module) {
      this.overrideModule = module;
      return this;
    }

    public DeterministicTest functionalNodeModule(FunctionalRadixNodeModule module) {
      modules.add(module);
      return build(false);
    }

    public Builder epochNodeIndexesMapping(Function<Long, IntStream> epochToNodeIndexesMapping) {
      Objects.requireNonNull(epochToNodeIndexesMapping);
      this.epochToNodeIndexesMapping = epochToNodeIndexesMapping;
      return this;
    }

    public Builder epochNodeWeightMapping(EpochNodeWeightMapping epochNodeWeightMapping) {
      this.epochNodeWeightMapping = Objects.requireNonNull(epochNodeWeightMapping);
      return this;
    }

    public Builder messageSelector(MessageSelector messageSelector) {
      this.messageSelector = Objects.requireNonNull(messageSelector);
      return this;
    }

    public Builder messageMutator(MessageMutator messageMutator) {
      this.messageMutator = Objects.requireNonNull(messageMutator);
      return this;
    }

    public Builder messageMutators(MessageMutator... messageMutators) {
      final var combinedMutator = Stream.of(messageMutators).reduce(MessageMutator::andThen).get();
      return this.messageMutator(combinedMutator);
    }

    public DeterministicTest buildWithEpochs(Round epochMaxRound) {
      Objects.requireNonNull(epochMaxRound);
      modules.add(
          new FunctionalRadixNodeModule(
              true,
              ConsensusConfig.of(),
              LedgerConfig.stateComputerNoSync(StateComputerConfig.mocked(MempoolType.NONE))));
      addEpochedConsensusProcessorModule(epochMaxRound);
      return build(true);
    }

    public DeterministicTest buildWithEpochsAndSync(Round epochMaxRound, SyncConfig syncConfig) {
      Objects.requireNonNull(epochMaxRound);
      modules.add(
          new FunctionalRadixNodeModule(
              true,
              ConsensusConfig.of(),
              LedgerConfig.stateComputerWithSync(
                  StateComputerConfig.mocked(MempoolType.NONE), syncConfig)));
      modules.add(new InMemoryCommittedReaderModule());
      addEpochedConsensusProcessorModule(epochMaxRound);
      return build(true);
    }

    public DeterministicTest buildWithoutEpochs(ConsensusConfig consensusConfig) {
      modules.add(
          new FunctionalRadixNodeModule(
              false,
              consensusConfig,
              LedgerConfig.stateComputerNoSync(StateComputerConfig.mocked(MempoolType.NONE))));
      return build(false);
    }

    private DeterministicTest build(boolean withEpoch) {
      modules.add(
          new AbstractModule() {
            @Override
            public void configure() {
              bind(Addressing.class).toInstance(Addressing.ofNetwork(Network.INTEGRATIONTESTNET));
              bind(TimeSupplier.class).toInstance(System::currentTimeMillis);
              bind(Random.class).toInstance(new Random(123456));
            }
          });
      modules.add(new MockedKeyModule());
      modules.add(new MockedCryptoModule());
      modules.add(new MockedPersistenceStoreModule());

      MockedConsensusRecoveryModule.Builder mockedConsensusRecoveryModuleBuilder =
          new MockedConsensusRecoveryModule.Builder(withEpoch);
      mockedConsensusRecoveryModuleBuilder.withNodes(nodes);
      if (this.epochNodeWeightMapping != null) {
        mockedConsensusRecoveryModuleBuilder.withEpochNodeWeightMapping(
            this.epochNodeWeightMapping);
      } else if (this.epochToNodeIndexesMapping != null) {
        mockedConsensusRecoveryModuleBuilder.withEpochNodeIndexesMapping(
            this.epochToNodeIndexesMapping);
      }
      modules.add(mockedConsensusRecoveryModuleBuilder.build());

      modules.add(new MockedLedgerRecoveryModule());

      modules.add(new TestP2PModule.Builder().withAllNodes(nodes).build());
      modules.add(new TestMessagingModule.Builder().build());

      return new DeterministicTest(
          this.nodes,
          this.messageSelector,
          this.messageMutator,
          Modules.combine(modules.build()),
          overrideModule);
    }

    private void addEpochedConsensusProcessorModule(Round epochMaxRound) {
      modules.add(
          new AbstractModule() {
            @Override
            public void configure() {
              bind(Round.class).annotatedWith(EpochMaxRound.class).toInstance(epochMaxRound);
              bind(new TypeLiteral<EventProcessor<EpochRound>>() {}).toInstance(epochRound -> {});
              bind(new TypeLiteral<EventProcessor<EpochLocalTimeoutOccurrence>>() {})
                  .toInstance(t -> {});
            }
          });
    }
  }

  public static Builder builder() {
    return new Builder();
  }

  public DeterministicNetwork getNetwork() {
    return this.network;
  }

  public DeterministicNodes getNodes() {
    return this.nodes;
  }

  public interface DeterministicManualExecutor {
    void start();

    void processNext(int senderIndex, int receiverIndex, Class<?> eventClass);
  }

  public DeterministicManualExecutor createExecutor() {
    return new DeterministicManualExecutor() {
      @Override
      public void start() {
        nodes.start();
      }

      @Override
      public void processNext(int senderIndex, int receiverIndex, Class<?> eventClass) {
        Timed<ControlledMessage> nextMsg =
            network.nextMessage(
                msg ->
                    msg.channelId().senderIndex() == senderIndex
                        && msg.channelId().receiverIndex() == receiverIndex
                        && eventClass.isInstance(msg.message()));

        nodes.handleMessage(nextMsg);
      }
    };
  }

  public DeterministicTest runForCount(int count) {
    this.nodes.start();

    for (int i = 0; i < count; i++) {
      Timed<ControlledMessage> nextMsg = this.network.nextMessage();
      this.nodes.handleMessage(nextMsg);
    }

    return this;
  }

  public DeterministicTest runUntil(Predicate<Timed<ControlledMessage>> stopPredicate) {
    this.nodes.start();

    while (true) {
      Timed<ControlledMessage> nextMsg = this.network.nextMessage();
      if (stopPredicate.test(nextMsg)) {
        break;
      }

      this.nodes.handleMessage(nextMsg);
    }

    return this;
  }

  /**
   * Returns a predicate that stops processing messages after a specified number of epochs and
   * rounds.
   *
   * @param maxEpochRound the last epoch and round to process
   * @return a predicate that halts processing after the specified number of epochs and rounds
   */
  public static Predicate<Timed<ControlledMessage>> hasReachedEpochRound(EpochRound maxEpochRound) {
    return timedMsg -> {
      ControlledMessage message = timedMsg.value();
      if (!(message.message() instanceof Proposal)) {
        return false;
      }
      Proposal proposal = (Proposal) message.message();
      EpochRound nev = EpochRound.of(proposal.getEpoch(), proposal.getRound());
      return (nev.compareTo(maxEpochRound) > 0);
    };
  }

  /**
   * Returns a predicate that stops processing messages after a specified number of rounds.
   *
   * @param round the last round to process
   * @return a predicate that return true after the specified number of rounds
   */
  public static Predicate<Timed<ControlledMessage>> hasReachedRound(Round round) {
    final long maxRoundNumber = round.previous().number();
    return timedMsg -> {
      ControlledMessage message = timedMsg.value();
      if (!(message.message() instanceof Proposal)) {
        return false;
      }
      Proposal p = (Proposal) message.message();
      return (p.getRound().number() > maxRoundNumber);
    };
  }

  public static Predicate<Timed<ControlledMessage>> roundUpdateOnNode(Round round, int nodeIndex) {
    return timedMsg -> {
      final var message = timedMsg.value();
      if (!(message.message() instanceof RoundUpdate)) {
        return false;
      }
      final var roundUpdate = (RoundUpdate) message.message();
      return message.channelId().receiverIndex() == nodeIndex
          && roundUpdate.getCurrentRound().gte(round);
    };
  }

  public static Predicate<Timed<ControlledMessage>> ledgerStateVersionOnNode(
      long stateVersion, int nodeIndex) {
    return timedMsg -> {
      final var message = timedMsg.value();
      if (!(message.message() instanceof LedgerUpdate)) {
        return false;
      }
      final var ledgerUpdate = (LedgerUpdate) message.message();
      return message.channelId().receiverIndex() == nodeIndex
          && ledgerUpdate.getTail().getStateVersion() >= stateVersion;
    };
  }

  public <T> T getInstance(int nodeIndex, Class<T> instanceClass) {
    return this.nodes.getInstance(nodeIndex, instanceClass);
  }

  public <T> T getInstance(int nodeIndex, Key<T> key) {
    return this.nodes.getInstance(nodeIndex, key);
  }

  public int numNodes() {
    return this.nodes.numNodes();
  }

  // Debugging aid for messages
  public void dumpMessages(PrintStream out) {
    this.network.dumpMessages(out);
  }
}
