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

package com.radixdlt.atommodel.validators.state;

import com.radixdlt.constraintmachine.Particle;
import com.radixdlt.crypto.ECPublicKey;

import java.util.Objects;

public final class AllowDelegationFlag implements Particle {
	private final ECPublicKey validatorKey;
	private final boolean allowDelegation;

	public AllowDelegationFlag(ECPublicKey validatorKey, boolean allowDelegation) {
		this.validatorKey = validatorKey;
		this.allowDelegation = allowDelegation;
	}

	public ECPublicKey getValidatorKey() {
		return validatorKey;
	}

	public boolean allowsDelegation() {
		return allowDelegation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(validatorKey, allowDelegation);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof AllowDelegationFlag)) {
			return false;
		}

		var other = (AllowDelegationFlag) o;
		return Objects.equals(this.validatorKey, other.validatorKey)
			&& this.allowDelegation == other.allowDelegation;
	}
}