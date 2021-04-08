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

package com.radixdlt.statecomputer.transaction;

import com.radixdlt.application.TokenUnitConversions;
import com.radixdlt.atom.Txn;
import com.radixdlt.atommodel.tokens.UnallocatedTokensParticle;
import com.radixdlt.atomos.Result;
import com.radixdlt.constraintmachine.RETxn;
import com.radixdlt.constraintmachine.Particle;
import com.radixdlt.constraintmachine.PermissionLevel;
import com.radixdlt.engine.PostParsedChecker;
import com.radixdlt.fees.FeeTable;
import com.radixdlt.fees.NativeToken;
import com.radixdlt.identifiers.RRI;
import com.radixdlt.utils.UInt256;

import javax.inject.Inject;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Checks that metadata in the ledger atom is well formed and follows what is
 * needed for both consensus and governance.
 */
public class TokenFeeChecker implements PostParsedChecker {
	private static final int MAX_ATOM_SIZE = 1024 * 1024;

	private final FeeTable feeTable;
	private final RRI feeTokenRri;

	@Inject
	public TokenFeeChecker(
		FeeTable feeTable,
		@NativeToken RRI feeTokenRri
	) {
		this.feeTable = feeTable;
		this.feeTokenRri = feeTokenRri;
	}

	@Override
	public Result check(Txn txn, PermissionLevel permissionLevel, RETxn radixEngineTxn) {
		final int totalSize = txn.getPayload().length;
		if (txn.getPayload().length > MAX_ATOM_SIZE) {
			return Result.error("atom too big: " + totalSize);
		}

		if (permissionLevel.equals(PermissionLevel.SYSTEM)) {
			return Result.success();
		}

		// no need for fees if a system update
		// TODO: update should also have no message
		if (!radixEngineTxn.isUserCommand()) {
			return Result.success();
		}

		// FIXME: This logic needs to move into the constraint machine
		Set<Particle> outputParticles = radixEngineTxn.upSubstates().collect(Collectors.toSet());
		UInt256 requiredMinimumFee = feeTable.feeFor(txn, outputParticles, totalSize);
		UInt256 feePaid = computeFeePaid(radixEngineTxn);
		if (feePaid.compareTo(requiredMinimumFee) < 0) {
			String message = String.format(
				"atom fee invalid: '%s' is less than required minimum '%s' atom_size: %s",
				TokenUnitConversions.subunitsToUnits(feePaid),
				TokenUnitConversions.subunitsToUnits(requiredMinimumFee),
				totalSize
			);
			return Result.error(message);
		}

		return Result.success();
	}

	// TODO: Need to make sure that these unallocated particles are never DOWNED.
	private UInt256 computeFeePaid(RETxn radixEngineTxn) {
		return radixEngineTxn.upSubstates()
			.filter(UnallocatedTokensParticle.class::isInstance)
			.map(UnallocatedTokensParticle.class::cast)
			.filter(u -> u.getTokDefRef().equals(this.feeTokenRri))
			.map(UnallocatedTokensParticle::getAmount)
			.reduce(UInt256.ZERO, UInt256::add);
	}
}