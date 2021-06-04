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

package com.radixdlt.atommodel.tokens;

import com.radixdlt.constraintmachine.AuthorizationException;
import com.radixdlt.constraintmachine.ExecutionContext;
import com.radixdlt.constraintmachine.PermissionLevel;
import com.radixdlt.crypto.ECPublicKey;
import com.radixdlt.identifiers.REAddr;
import com.radixdlt.store.ReadableAddrs;

// TODO: these methods are really here for client api,
// TODO: fix to be more in line with scrypto abstractions
public interface Bucket {
	PermissionLevel withdrawPermissionLevel();
	void verifyWithdrawAuthorization(ReadableAddrs readable, ExecutionContext context) throws AuthorizationException;

	REAddr resourceAddr();
	REAddr getOwner();
	ECPublicKey getValidatorKey();
	Long getEpochUnlock();
}
