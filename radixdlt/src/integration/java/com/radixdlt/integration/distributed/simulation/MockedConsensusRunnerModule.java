/*
 * (C) Copyright 2020 Radix DLT Ltd
 *
 * Radix DLT Ltd licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the
 * License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the License.
 */

package com.radixdlt.integration.distributed.simulation;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.name.Named;
import com.radixdlt.ModuleRunner;
import com.radixdlt.consensus.BFTConfiguration;
import com.radixdlt.consensus.BFTEventProcessor;
import com.radixdlt.consensus.BFTFactory;
import com.radixdlt.consensus.Ledger;
import com.radixdlt.consensus.ProposerElectionFactory;
import com.radixdlt.consensus.Timeout;
import com.radixdlt.consensus.VertexStoreSyncEventProcessor;
import com.radixdlt.consensus.VertexStoreFactory;
import com.radixdlt.consensus.VertexStoreSyncFactory;
import com.radixdlt.consensus.bft.BFTEventReducer.BFTInfoSender;
import com.radixdlt.consensus.bft.BFTNode;
import com.radixdlt.consensus.bft.SyncVerticesRequestProcessor;
import com.radixdlt.consensus.bft.VertexStore;
import com.radixdlt.consensus.sync.VertexStoreSync;
import com.radixdlt.consensus.sync.VertexStoreSyncVerticesRequestProcessor;
import com.radixdlt.consensus.bft.View;
import com.radixdlt.consensus.epoch.EpochManager.EpochInfoSender;
import com.radixdlt.consensus.epoch.EpochView;
import com.radixdlt.consensus.epoch.LocalTimeout;
import com.radixdlt.consensus.liveness.LocalTimeoutSender;
import com.radixdlt.consensus.liveness.PacemakerFactory;
import com.radixdlt.integration.distributed.BFTRunner;

public class MockedConsensusRunnerModule extends AbstractModule {
	@Override
	public void configure() {
		MapBinder<String, ModuleRunner> moduleRunners = MapBinder.newMapBinder(binder(), String.class, ModuleRunner.class);
		moduleRunners.addBinding("consensus").to(BFTRunner.class).in(Scopes.SINGLETON);
		bind(VertexStoreSyncEventProcessor.class).to(VertexStoreSync.class).in(Scopes.SINGLETON);
		bind(SyncVerticesRequestProcessor.class).to(VertexStoreSyncVerticesRequestProcessor.class);
	}

	@Provides
	@Singleton
	public BFTEventProcessor eventProcessor(
		@Named("self") BFTNode self,
		BFTConfiguration config,
		BFTFactory bftFactory,
		PacemakerFactory pacemakerFactory,
		VertexStore vertexStore,
		VertexStoreSync vertexStoreSync,
		ProposerElectionFactory proposerElectionFactory,
		LocalTimeoutSender localTimeoutSender,
		BFTInfoSender infoSender
	) {
		return bftFactory.create(
			self,
			header -> { },
			pacemakerFactory.create((view, ms) -> localTimeoutSender.scheduleTimeout(new LocalTimeout(1, view), ms)),
			vertexStore,
			vertexStoreSync,
			proposerElectionFactory.create(config.getValidatorSet()),
			config.getValidatorSet(),
			infoSender
		);
	}


	@Provides
	public BFTInfoSender bftInfoSender(EpochInfoSender epochInfoSender) {
		return new BFTInfoSender() {
			@Override
			public void sendCurrentView(View view) {
				epochInfoSender.sendCurrentView(EpochView.of(1, view));
			}

			@Override
			public void sendTimeoutProcessed(View view, BFTNode leader) {
				epochInfoSender.sendTimeoutProcessed(new Timeout(EpochView.of(1, view), leader));
			}
		};
	}

	@Provides
	@Singleton
	public VertexStoreSync vertexStoreSync(
		VertexStore vertexStore,
		VertexStoreSyncFactory vertexStoreSyncFactory
	) {
		return vertexStoreSyncFactory.create(vertexStore);
	}

	@Provides
	@Singleton
	public VertexStore vertexStore(
		BFTConfiguration config,
		VertexStoreFactory vertexStoreFactory,
		Ledger ledger
	) {
		return vertexStoreFactory.create(config.getGenesisVertex(), config.getGenesisQC(), ledger);
	}
}
