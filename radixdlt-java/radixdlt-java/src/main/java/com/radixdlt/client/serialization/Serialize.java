/*
 * (C) Copyright 2020 Radix DLT Ltd
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the “Software”),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package com.radixdlt.client.serialization;

import com.radixdlt.atom.Atom;
import com.radixdlt.atomos.RRIParticle;
import com.radixdlt.atommodel.tokens.StakedTokensParticle;
import com.radixdlt.atommodel.system.SystemParticle;
import com.radixdlt.atommodel.tokens.UnallocatedTokensParticle;
import com.radixdlt.atommodel.validators.RegisteredValidatorParticle;
import com.radixdlt.atommodel.validators.UnregisteredValidatorParticle;
import java.util.Arrays;
import java.util.Collection;

import com.radixdlt.atommodel.tokens.FixedSupplyTokenDefinitionParticle;
import com.radixdlt.atommodel.tokens.TransferrableTokensParticle;

import com.radixdlt.atommodel.tokens.MutableSupplyTokenDefinitionParticle;
import com.radixdlt.atommodel.unique.UniqueParticle;
import com.radixdlt.client.core.address.RadixUniverseConfig;
import com.radixdlt.client.core.ledger.AtomEvent;
import com.radixdlt.constraintmachine.Particle;
import com.radixdlt.crypto.ECDSASignature;
import com.radixdlt.client.core.network.jsonrpc.NodeRunnerData;
import com.radixdlt.client.core.network.jsonrpc.RadixLocalSystem;
import com.radixdlt.client.core.network.jsonrpc.RadixSystem;
import com.radixdlt.serialization.Serialization;
import com.radixdlt.serialization.SerializationPolicy;
import com.radixdlt.serialization.SerializerIds;

public final class Serialize {

	private static class Holder {
		static final Serialization INSTANCE = Serialization.create(createIds(getClasses()), createPolicy(getClasses()));

		private static SerializerIds createIds(Collection<Class<?>> classes) {
			return CollectionScanningSerializerIds.create(classes);
		}

		private static SerializationPolicy createPolicy(Collection<Class<?>> classes) {
			return CollectionScanningSerializationPolicy.create(classes);
		}

		private static Collection<Class<?>> getClasses() {
			return Arrays.asList(
				Atom.class,
				AtomEvent.class,
				Particle.class,
				RRIParticle.class,
				MutableSupplyTokenDefinitionParticle.class,
				FixedSupplyTokenDefinitionParticle.class,
				UnallocatedTokensParticle.class,
				TransferrableTokensParticle.class,
				StakedTokensParticle.class,
				UniqueParticle.class,
				RegisteredValidatorParticle.class,
				UnregisteredValidatorParticle.class,
				SystemParticle.class,
				ECDSASignature.class,
				NodeRunnerData.class,
				RadixLocalSystem.class,
				RadixSystem.class,
				RadixUniverseConfig.class
			);
		}
	}

	private Serialize() {
		throw new IllegalStateException("Can't construct");
	}

	public static Serialization getInstance() {
		return Holder.INSTANCE;
	}
}
