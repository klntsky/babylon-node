/*
 * (C) Copyright 2020 Radix DLT Ltd
 *
 * Radix DLT Ltd licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the
 * License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the License.
 */

package com.radixdlt.engine;

import com.radixdlt.atom.MutableTokenDefinition;
import com.radixdlt.atom.TxActionListBuilder;
import com.radixdlt.atom.actions.MoveStake;
import com.radixdlt.atom.actions.RegisterValidator;
import com.radixdlt.atom.actions.StakeTokens;
import com.radixdlt.atom.actions.UnstakeTokens;
import com.radixdlt.atommodel.tokens.StakingConstraintScrypt;
import com.radixdlt.constraintmachine.PermissionLevel;
import org.junit.Before;
import org.junit.Test;

import com.radixdlt.atommodel.tokens.TokensConstraintScrypt;
import com.radixdlt.atommodel.validators.ValidatorConstraintScrypt;
import com.radixdlt.atomos.CMAtomOS;
import com.radixdlt.constraintmachine.ConstraintMachine;
import com.radixdlt.crypto.ECKeyPair;
import com.radixdlt.identifiers.Rri;
import com.radixdlt.identifiers.RadixAddress;
import com.radixdlt.store.EngineStore;
import com.radixdlt.store.InMemoryEngineStore;
import com.radixdlt.utils.UInt256;

import java.util.List;

public class StakedTokensTest {
	private static final byte MAGIC = (byte) 0;
	private RadixEngine<Void> engine;
	private EngineStore<Void> store;
	private Rri tokenRri;
	private ECKeyPair tokenOwnerKeyPair = ECKeyPair.generateNew();
	private RadixAddress tokenOwnerAddress = new RadixAddress(MAGIC, this.tokenOwnerKeyPair.getPublicKey());
	private ECKeyPair validatorKeyPair = ECKeyPair.generateNew();
	private RadixAddress validatorAddress = new RadixAddress(MAGIC, this.validatorKeyPair.getPublicKey());

	@Before
	public void setup() throws Exception {
		this.tokenRri = Rri.ofSystem("xrd");

		final var cmAtomOS = new CMAtomOS();
		cmAtomOS.load(new ValidatorConstraintScrypt());
		cmAtomOS.load(new TokensConstraintScrypt());
		cmAtomOS.load(new StakingConstraintScrypt());
		final var cm = new ConstraintMachine.Builder()
			.setVirtualStoreLayer(cmAtomOS.virtualizedUpParticles())
			.setParticleStaticCheck(cmAtomOS.buildParticleStaticCheck())
			.setParticleTransitionProcedures(cmAtomOS.buildTransitionProcedures())
			.build();
		this.store = new InMemoryEngineStore<>();
		this.engine = new RadixEngine<>(cm, this.store);

		var tokDef = new MutableTokenDefinition(
			"xrd",
			"Test",
			"description",
			null,
			null
		);
		var txn0 = engine.construct(
			TxActionListBuilder.create()
				.createMutableToken(tokDef)
				.mint(this.tokenRri, this.tokenOwnerAddress, UInt256.TEN)
				.build()
		).buildWithoutSignature();
		var validatorBuilder = this.engine.construct(this.validatorAddress, new RegisterValidator());
		var txn1 = validatorBuilder.signAndBuild(this.validatorKeyPair::sign);

		this.engine.execute(List.of(txn0, txn1), null, PermissionLevel.SYSTEM);
	}

	@Test
	public void stake_tokens() throws Exception {
		var txn = engine.construct(
			this.tokenOwnerAddress,
			new StakeTokens(this.validatorAddress, UInt256.TEN)
		).signAndBuild(this.tokenOwnerKeyPair::sign);

		this.engine.execute(List.of(txn));
	}

	@Test
	public void unstake_tokens() throws Exception {
		var txn = engine.construct(
			this.tokenOwnerAddress,
			new StakeTokens(this.validatorAddress, UInt256.TEN)
		).signAndBuild(this.tokenOwnerKeyPair::sign);
		this.engine.execute(List.of(txn));

		var txn2 = engine.construct(
			this.tokenOwnerAddress,
			new UnstakeTokens(this.validatorAddress, UInt256.TEN)
		).signAndBuild(this.tokenOwnerKeyPair::sign);
		this.engine.execute(List.of(txn2));
	}

	@Test
	public void unstake_partial_tokens() throws Exception {
		var txn = engine.construct(
			this.tokenOwnerAddress,
			new StakeTokens(this.validatorAddress, UInt256.TEN)
		).signAndBuild(this.tokenOwnerKeyPair::sign);
		this.engine.execute(List.of(txn));

		var txn2 = engine.construct(
			this.tokenOwnerAddress,
			new UnstakeTokens(this.validatorAddress, UInt256.SEVEN)
		).signAndBuild(this.tokenOwnerKeyPair::sign);
		this.engine.execute(List.of(txn2));
	}

	@Test
	public void move_staked_tokens() throws Exception {
		var txn = this.engine.construct(this.tokenOwnerAddress, new StakeTokens(validatorAddress, UInt256.TEN))
			.signAndBuild(this.tokenOwnerKeyPair::sign);
		this.engine.execute(List.of(txn));

		var atom2 = this.engine.construct(this.tokenOwnerAddress, new MoveStake(validatorAddress, newAddress(), UInt256.FIVE))
			.signAndBuild(this.tokenOwnerKeyPair::sign);
		this.engine.execute(List.of(atom2));
	}

	private RadixAddress newAddress() {
		return new RadixAddress(MAGIC, ECKeyPair.generateNew().getPublicKey());
	}
}
