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

package com.radixdlt.sanitytestsuite.scenario.radixhashing;

import com.radixdlt.sanitytestsuite.model.SanityTestVector;

import java.nio.charset.StandardCharsets;

// CHECKSTYLE:OFF checkstyle:VisibilityModifier
public final class RadixHashingTestVector implements SanityTestVector {
	public static final class Expected {
		public String hashOfHash;
	}

	public static final class Input {
		private String stringToHash;
		public byte[] bytesToHash() {
			return this.stringToHash.getBytes(StandardCharsets.UTF_8);
		}
	}

	public Expected expected;
	public Input input;
}
// CHECKSTYLE:ON checkstyle:VisibilityModifier