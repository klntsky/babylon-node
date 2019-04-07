package com.radixdlt.client.application.translate.tokens;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.radixdlt.client.application.translate.Action;
import com.radixdlt.client.application.translate.ApplicationState;
import com.radixdlt.client.application.translate.ShardedAppStateId;
import com.radixdlt.client.application.translate.StatefulActionToParticleGroupsMapper;
import com.radixdlt.client.application.translate.tokens.TokenState.TokenSupplyType;
import com.radixdlt.client.atommodel.accounts.RadixAddress;
import com.radixdlt.client.atommodel.tokens.BurnedTokensParticle;
import com.radixdlt.client.atommodel.tokens.MintedTokensParticle;
import com.radixdlt.client.atommodel.tokens.TokenDefinitionParticle.TokenTransition;
import com.radixdlt.client.atommodel.tokens.TokenPermission;
import com.radixdlt.client.atommodel.tokens.TransferredTokensParticle;
import com.radixdlt.client.atommodel.tokens.UnallocatedTokensParticle;
import com.radixdlt.client.core.atoms.ParticleGroup;
import com.radixdlt.client.core.atoms.ParticleGroup.ParticleGroupBuilder;
import com.radixdlt.client.core.atoms.particles.Particle;
import com.radixdlt.client.core.atoms.particles.Spin;
import com.radixdlt.client.core.fungible.FungibleParticleTransitioner;
import com.radixdlt.client.core.fungible.FungibleParticleTransitioner.FungibleParticleTransition;
import io.reactivex.Observable;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.radix.utils.UInt256;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

public class MintAndTransferTokensActionMapper implements StatefulActionToParticleGroupsMapper {
	private final BiFunction<
		FungibleParticleTransition<UnallocatedTokensParticle, TransferredTokensParticle>,
		FungibleParticleTransition<TransferredTokensParticle, TransferredTokensParticle>,
		List<ParticleGroup>> mintAndTransferToGroupMapper;

	public MintAndTransferTokensActionMapper() {
		this((mint, transfer) -> {
			ParticleGroupBuilder mintParticleGroupBuilder = ParticleGroup.builder();
			mint.getRemoved().stream().map(t -> (Particle) t).forEach(p -> mintParticleGroupBuilder.addParticle(p, Spin.DOWN));
			mint.getMigrated().stream().map(t -> (Particle) t).forEach(p -> mintParticleGroupBuilder.addParticle(p, Spin.UP));
			mint.getTransitioned().stream().map(t -> (Particle) t).forEach(p -> mintParticleGroupBuilder.addParticle(p, Spin.UP));

			ParticleGroupBuilder transferParticleGroupBuilder = ParticleGroup.builder();
			transfer.getRemoved().stream().map(t -> (Particle) t).forEach(p -> transferParticleGroupBuilder.addParticle(p, Spin.DOWN));
			transfer.getMigrated().stream().map(t -> (Particle) t).forEach(p -> transferParticleGroupBuilder.addParticle(p, Spin.UP));
			transfer.getTransitioned().stream().map(t -> (Particle) t).forEach(p -> transferParticleGroupBuilder.addParticle(p, Spin.UP));

			return Arrays.asList(
				mintParticleGroupBuilder.build(),
				transferParticleGroupBuilder.build()
			);
		});
	}

	public MintAndTransferTokensActionMapper(
		BiFunction<
			FungibleParticleTransition<UnallocatedTokensParticle, TransferredTokensParticle>,
			FungibleParticleTransition<TransferredTokensParticle, TransferredTokensParticle>,
			List<ParticleGroup>> mintAndTransferToGroupMapper) {
		this.mintAndTransferToGroupMapper = Objects.requireNonNull(mintAndTransferToGroupMapper);
	}

	@Override
	public Observable<ShardedAppStateId> requiredState(Action action) {
		if (!(action instanceof MintAndTransferTokensAction)) {
			return Observable.empty();
		}

		MintAndTransferTokensAction mintAndTransferTokensAction = (MintAndTransferTokensAction) action;
		RadixAddress tokenDefinitionAddress = mintAndTransferTokensAction.getTokenDefinitionReference().getAddress();

		return Observable.just(ShardedAppStateId.of(TokenDefinitionsState.class, tokenDefinitionAddress));
	}

	@Override
	public Observable<ParticleGroup> mapToParticleGroups(Action action, Observable<Observable<? extends ApplicationState>> store) {
		if (!(action instanceof MintAndTransferTokensAction)) {
			return Observable.empty();
		}

		MintAndTransferTokensAction mintTransferAction = (MintAndTransferTokensAction) action;
		TokenDefinitionReference tokenDefinition = mintTransferAction.getTokenDefinitionReference();

		return store.firstOrError()
			.flatMap(Observable::firstOrError)
			.map(TokenDefinitionsState.class::cast)
			.map(TokenDefinitionsState::getState)
			.map(state -> getTokenStateOrError(state, tokenDefinition))
			.map(state -> {
				final FungibleParticleTransition<UnallocatedTokensParticle, TransferredTokensParticle> mintTransition =
					createMint(mintTransferAction.getAmount(), tokenDefinition, state);

				final TransferredTokensParticle transferredTokensParticle = createTransfer(
					state.getTokenSupplyType() == TokenSupplyType.FIXED
						? ImmutableMap.of(TokenTransition.MINT, TokenPermission.TOKEN_CREATION_ONLY, TokenTransition.BURN, TokenPermission.TOKEN_CREATION_ONLY)
						: ImmutableMap.of(TokenTransition.MINT, TokenPermission.TOKEN_OWNER_ONLY, TokenTransition.BURN, TokenPermission.TOKEN_OWNER_ONLY),
					TokenUnitConversions.unitsToSubunits(state.getGranularity()),
					mintTransferAction
				);

				final FungibleParticleTransition<TransferredTokensParticle, TransferredTokensParticle> transferTransition =
					new FungibleParticleTransition<>(
						ImmutableList.copyOf(mintTransition.getTransitioned()),
						ImmutableList.of(),
						ImmutableList.of(transferredTokensParticle)
					);

				return mintAndTransferToGroupMapper.apply(mintTransition, transferTransition);
			})
			.flatMapObservable(Observable::fromIterable);
	}

	private TokenState getTokenStateOrError(Map<TokenDefinitionReference, TokenState> m, TokenDefinitionReference tokenDefinition) {
		TokenState ts = m.get(tokenDefinition);
		if (ts == null) {
			throw new UnknownTokenException(tokenDefinition);
		}
		return ts;
	}

	private TransferredTokensParticle createTransfer(Map<TokenTransition, TokenPermission> permissions, UInt256 granularity, MintAndTransferTokensAction action) {
		return new TransferredTokensParticle(
			TokenUnitConversions.unitsToSubunits(action.getAmount()),
			granularity,
			action.getTo(),
			System.nanoTime(),
			action.getTokenDefinitionReference(),
			System.currentTimeMillis() / 60000L + 60000L,
			permissions
		);
	}

	private FungibleParticleTransition<UnallocatedTokensParticle, TransferredTokensParticle> createMint(
		BigDecimal amount,
		TokenDefinitionReference tokenDefRef,
		TokenState tokenState
	) {
		final BigDecimal unallocatedSupply = tokenState.getUnallocatedSupply();

		if (unallocatedSupply.compareTo(amount) < 0) {
			throw new InsufficientFundsException(tokenDefRef, unallocatedSupply, amount);
		}

		final FungibleParticleTransitioner<UnallocatedTokensParticle, TransferredTokensParticle> transitioner =
			new FungibleParticleTransitioner<>(
				(amt, consumable) -> new TransferredTokensParticle(
					amt,
					consumable.getGranularity(),
					tokenDefRef.getAddress(),
					System.nanoTime(),
					tokenDefRef,
					System.currentTimeMillis() / 60000L + 60000L,
					consumable.getTokenPermissions()
				),
				mintedTokens -> mintedTokens,
				(amt, consumable) -> new UnallocatedTokensParticle(
					amt,
					consumable.getGranularity(),
					System.nanoTime(),
					tokenDefRef,
					consumable.getTokenPermissions()
				),
				unallocated -> unallocated,
				UnallocatedTokensParticle::getAmount
			);

		FungibleParticleTransition<UnallocatedTokensParticle, TransferredTokensParticle> transition = transitioner.createTransition(
			tokenState.getUnallocatedTokens().entrySet().stream()
				.map(Entry::getValue)
				.collect(Collectors.toList()),
			TokenUnitConversions.unitsToSubunits(amount)
		);

		return transition;
	}
}
