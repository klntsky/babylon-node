package com.radixdlt.atomos;

import com.google.common.collect.ImmutableMap;
import com.radixdlt.atomos.AtomOSKernel.AtomKernelCompute;
import com.radixdlt.common.Pair;
import com.radixdlt.compute.AtomCompute;
import com.radixdlt.constraintmachine.TransitionProcedure;
import com.radixdlt.store.CMStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import com.radixdlt.constraintmachine.ConstraintMachine.Builder;
import com.radixdlt.constraintmachine.ConstraintMachine;
import com.radixdlt.constraintmachine.KernelConstraintProcedure;
import com.radixdlt.constraintmachine.KernelProcedureError;
import com.radixdlt.atoms.Particle;
import com.radixdlt.atoms.Spin;
import com.radixdlt.store.CMStores;
import com.radixdlt.common.EUID;
import com.radixdlt.universe.Universe;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implementation of the AtomOS interface on top of a UTXO based Constraint Machine.
 */
public final class CMAtomOS {
	private final List<KernelConstraintProcedure> kernelProcedures = new ArrayList<>();
	private AtomKernelCompute atomKernelCompute;

	private final Map<Class<? extends Particle>, Function<Particle, Stream<RadixAddress>>> particleMapper = new LinkedHashMap<>();
	private final Map<Class<? extends Particle>, Function<Particle, Result>> particleStaticValidation = new HashMap<>();

	private final ImmutableMap.Builder<Pair<Class<? extends Particle>, Class<? extends Particle>>, TransitionProcedure> proceduresBuilder = new ImmutableMap.Builder<>();

	private final Supplier<Universe> universeSupplier;
	private final LongSupplier timestampSupplier;

	public CMAtomOS(
		Supplier<Universe> universeSupplier,
		LongSupplier timestampSupplier
	) {
		this.universeSupplier = Objects.requireNonNull(universeSupplier);
		this.timestampSupplier = Objects.requireNonNull(timestampSupplier);

		// RRI particle is a low level particle managed by the OS used for the management of all other resources
		this.particleMapper.put(RRIParticle.class, rri -> Stream.of(((RRIParticle) rri).getRri().getAddress()));
	}

	public void load(ConstraintScrypt constraintScrypt) {
		final Map<Class<? extends Particle>, Function<Particle, Stream<RadixAddress>>> scryptParticleClasses = new HashMap<>();

		constraintScrypt.main(new SysCalls() {
			@Override
			public <T extends Particle> void registerParticleMultipleAddress(
				Class<T> particleClass,
				Function<T, Set<RadixAddress>> mapper,
				Function<T, Result> staticCheck
			) {
				if (scryptParticleClasses.containsKey(particleClass) || particleMapper.containsKey(particleClass)) {
					throw new IllegalStateException("Particle " + particleClass + " is already registered");
				}

				scryptParticleClasses.put(particleClass, p -> mapper.apply((T) p).stream());
				particleStaticValidation.merge(particleClass, p -> staticCheck.apply((T) p),
					(old, next) -> p -> Result.combine(old.apply(p), next.apply(p)));
			}

			@Override
			public <T extends Particle> void registerParticle(
				Class<T> particleClass,
				Function<T, RadixAddress> mapper,
				Function<T, Result> staticCheck
			) {
				registerParticleMultipleAddress(
					particleClass,
					(T particle) -> Collections.singleton(mapper.apply(particle)),
					staticCheck
				);
			}

			@Override
			public <T extends Particle> void newRRIResource(
				Class<T> particleClass,
				Function<T, RRI> rriMapper
			) {
				if (!scryptParticleClasses.containsKey(particleClass)) {
					throw new IllegalStateException(particleClass + " must be registered in calling scrypt.");
				}

				TransitionProcedure procedure = new RRIResourceCreation<>(particleClass, rriMapper);
				procedure.supports().forEach(p -> proceduresBuilder.put(p, procedure));
			}

			@Override
			public <T extends Particle, U extends Particle> void newRRIResourceCombined(
				Class<T> particleClass0,
				Function<T, RRI> rriMapper0,
				Class<U> particleClass1,
				Function<U, RRI> rriMapper1,
				BiPredicate<T, U> combinedCheck
			) {
				if (!scryptParticleClasses.containsKey(particleClass0)) {
					throw new IllegalStateException(particleClass0 + " must be registered in calling scrypt.");
				}
				if (!scryptParticleClasses.containsKey(particleClass1)) {
					throw new IllegalStateException(particleClass1 + " must be registered in calling scrypt.");
				}

				TransitionProcedure procedure = new RRIResourceCombinedCreation<>(
					particleClass0,
					rriMapper0,
					particleClass1,
					rriMapper1,
					combinedCheck
				);
				procedure.supports().forEach(p -> proceduresBuilder.put(p, procedure));
			}

			@Override
			public void newTransition(TransitionProcedure procedure) {
				if (!procedure.supports().stream()
					.flatMap(p -> Stream.of(p.getFirst(), p.getSecond()))
					.filter(Objects::nonNull)
					.allMatch(scryptParticleClasses::containsKey)
				) {
					throw new IllegalStateException(procedure.supports() + " must be all registered in calling scrypt.");
				}
				procedure.supports().forEach(p -> proceduresBuilder.put(p, procedure));
			}
		});

		particleMapper.putAll(scryptParticleClasses);
	}

	public void loadKernelConstraintScrypt(AtomOSDriver driverScrypt) {
		driverScrypt.main(new AtomOSKernel() {
			@Override
			public AtomKernel onAtom() {
				return new AtomKernel() {
					@Override
					public void require(AtomKernelConstraintCheck constraint) {
						CMAtomOS.this.kernelProcedures.add(
							(cmAtom) -> constraint.check(cmAtom).errorStream().map(errMsg -> KernelProcedureError.of(cmAtom.getAtom(), errMsg))
						);
					}

					@Override
					public void setCompute(AtomKernelCompute compute) {

						if (CMAtomOS.this.atomKernelCompute != null) {
							throw new IllegalStateException("Compute already set.");
						}

						CMAtomOS.this.atomKernelCompute = compute;
					}
				};
			}

			@Override
			public long getCurrentTimestamp() {
				return timestampSupplier.getAsLong();
			}

			@Override
			public Universe getUniverse() {
				return universeSupplier.get();
			}
		});
	}

	/**
	 * Checks that the machine is set up correctly where invariants aren't broken.
	 * If all is well, this then returns an instance of a machine in which atom
	 * validation can be done with the Quarks and Particles it's been set up with.
	 *
	 * @return a constraint machine which can validate atoms and the virtual layer on top of the store
	 */
	public Pair<ConstraintMachine, AtomCompute> buildMachine() {
		ConstraintMachine.Builder cmBuilder = new Builder();

		this.kernelProcedures.forEach(cmBuilder::addProcedure);

		ImmutableMap<Pair<Class<? extends Particle>, Class<? extends Particle>>, TransitionProcedure> procedures = proceduresBuilder.build();
		cmBuilder.setParticleProcedures((input, output) -> procedures.get(
			Pair.<Class<? extends Particle>, Class<? extends Particle>>of(
				input == null ? null : input.getClass(),
				output == null ? null : output.getClass()))
		);

		UnaryOperator<CMStore> rriTransformer = base ->
			CMStores.virtualizeDefault(base, p -> p instanceof RRIParticle && ((RRIParticle) p).getNonce() == 0, Spin.UP);

		UnaryOperator<CMStore> virtualizedDefault = base -> {
			CMStore virtualizeNeutral = CMStores.virtualizeDefault(base, p -> {
				Function<Particle, Stream<RadixAddress>> mapper = particleMapper.get(p.getClass());
				if (mapper == null) {
					return false;
				}

				Function<Particle, Result> staticValidation = particleStaticValidation.get(p.getClass());
				if (staticValidation != null) {
					if (staticValidation.apply(p).isError()) {
						return false;
					}
				}

				final Set<EUID> destinations = mapper.apply(p).map(RadixAddress::getUID).collect(Collectors.toSet());

				return !(destinations.isEmpty())
					&& destinations.containsAll(p.getDestinations())
					&& p.getDestinations().containsAll(destinations);
			}, Spin.NEUTRAL);

			return rriTransformer.apply(virtualizeNeutral);
		};

		cmBuilder.virtualStore(virtualizedDefault);

		final AtomCompute compute = atomKernelCompute != null ? a -> atomKernelCompute.compute(a.getAtom()) : null;

		return Pair.of(cmBuilder.build(), compute);
	}
}
