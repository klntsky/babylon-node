package com.radixdlt.atommodel.tokens;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import com.radixdlt.atomos.RRI;
import com.radixdlt.atomos.RadixAddress;
import com.radixdlt.constraintmachine.Particle;
import com.radixdlt.serialization.DsonOutput;
import com.radixdlt.serialization.DsonOutput.Output;
import com.radixdlt.serialization.SerializerId2;
import com.radixdlt.utils.UInt256;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Particle representing a mutable supply token definition
 */
@SerializerId2("radix.particles.mutable_supply_token_definition")
public final class MutableSupplyTokenDefinitionParticle extends Particle {
	public enum TokenTransition {
		MINT,
		BURN
	}

	@JsonProperty("rri")
	@DsonOutput(Output.ALL)
	private RRI rri;

	@JsonProperty("name")
	@DsonOutput(DsonOutput.Output.ALL)
	private String name;

	@JsonProperty("description")
	@DsonOutput(DsonOutput.Output.ALL)
	private String	description;

	@JsonProperty("granularity")
	@DsonOutput(Output.ALL)
	private UInt256 granularity;

	@JsonProperty("iconUrl")
	@DsonOutput(DsonOutput.Output.ALL)
	private String iconUrl;

	private Map<TokenTransition, TokenPermission> tokenPermissions;

	private MutableSupplyTokenDefinitionParticle() {
		super();
	}

	public MutableSupplyTokenDefinitionParticle(
		RadixAddress address,
		String symbol,
		String name,
		String description,
		UInt256 granularity,
		String iconUrl,
		Map<TokenTransition, TokenPermission> tokenPermissions
	) {
		super(address.getUID());

		this.rri = RRI.of(address, symbol);
		this.name = name;
		this.description = description;
		this.granularity = Objects.requireNonNull(granularity);
		this.iconUrl = iconUrl;
		this.tokenPermissions = ImmutableMap.copyOf(tokenPermissions);

		if (this.tokenPermissions.keySet().size() != TokenTransition.values().length) {
		    throw new IllegalArgumentException("tokenPermissions must be set for all token instance types.");
		}
	}

	public RRI getRRI() {
		return this.rri;
	}

	public Map<TokenTransition, TokenPermission> getTokenPermissions() {
		return tokenPermissions;
	}

	public TokenPermission getTokenPermission(TokenTransition transition) {
		TokenPermission tokenPermission = tokenPermissions.get(transition);
		if (tokenPermission != null) {
			return tokenPermission;
		}

		throw new IllegalArgumentException("No token permission set for " + transition + " in " + tokenPermissions);
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public UInt256 getGranularity() {
		return this.granularity;
	}

	public String getIconUrl() {
		return this.iconUrl;
	}

	@JsonProperty("permissions")
	@DsonOutput(value = {Output.ALL})
	private Map<String, String> getJsonPermissions() {
		return this.tokenPermissions.entrySet().stream()
			.collect(Collectors.toMap(e -> e.getKey().name().toLowerCase(), e -> e.getValue().name().toLowerCase()));
	}

	@JsonProperty("permissions")
	private void setJsonPermissions(Map<String, String> permissions) {
		if (permissions != null) {
			this.tokenPermissions = permissions.entrySet().stream()
				.collect(
					Collectors.toMap(
						e -> TokenTransition.valueOf(e.getKey().toUpperCase()),
						e -> TokenPermission.valueOf(e.getValue().toUpperCase())
					)
				);
		} else {
			throw new IllegalArgumentException("Permissions cannot be null.");
		}
	}

	@Override
	public String toString() {
		String tokenPermissionsStr = (tokenPermissions == null)
			? "null"
			: tokenPermissions.entrySet().stream()
				.map(e -> String.format("%s:%s", e.getKey().toString().toLowerCase(), e.getValue().toString().toLowerCase()))
				.collect(Collectors.joining(","));
		return String.format("%s[(%s:%s:%s), (am%s), (%s)]", getClass().getSimpleName(),
			String.valueOf(name), String.valueOf(rri), String.valueOf(granularity),
			String.valueOf(description), tokenPermissionsStr);
	}
}
