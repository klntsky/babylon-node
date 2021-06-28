/*
 * (C) Copyright 2021 Radix DLT Ltd
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
 *
 */

package com.radixdlt.atom.actions;

import com.google.common.hash.HashCode;
import com.radixdlt.atom.TxAction;
import com.radixdlt.crypto.ECPublicKey;

import java.util.Optional;

public final class RegisterValidator implements TxAction {
	private final ECPublicKey validatorKey;
	private final Optional<HashCode> forkVoteHash;

	public RegisterValidator(ECPublicKey validatorKey, Optional<HashCode> forkVoteHash) {
		this.validatorKey = validatorKey;
		this.forkVoteHash = forkVoteHash;
	}

	public ECPublicKey validatorKey() {
		return validatorKey;
	}

	public Optional<HashCode> forkVoteHash() {
		return forkVoteHash;
	}
}
