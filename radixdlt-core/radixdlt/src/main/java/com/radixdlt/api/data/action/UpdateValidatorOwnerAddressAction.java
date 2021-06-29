/*
 * (C) Copyright 2021 Radix DLT Ltd
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

package com.radixdlt.api.data.action;

import com.radixdlt.atom.TxAction;
import com.radixdlt.atom.actions.UpdateValidatorOwnerAddress;
import com.radixdlt.crypto.ECPublicKey;
import com.radixdlt.identifiers.REAddr;

import java.util.stream.Stream;

class UpdateValidatorOwnerAddressAction implements TransactionAction {
	private final ECPublicKey validatorKey;
	private final REAddr ownerAddress;

	UpdateValidatorOwnerAddressAction(ECPublicKey validatorKey, REAddr ownerAddress) {
		this.validatorKey = validatorKey;
		this.ownerAddress = ownerAddress;
	}

	@Override
	public Stream<TxAction> toAction() {
		return Stream.of(new UpdateValidatorOwnerAddress(validatorKey, ownerAddress));
	}
}