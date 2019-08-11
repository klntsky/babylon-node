package com.radixdlt.atomos;

import com.radixdlt.atoms.Particle;
import com.radixdlt.constraintmachine.TransitionProcedure;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * Exposes the interface which application particle constraints can be built on top of.
 */
public interface SysCalls {

	/**
	 * Registers a Particle with a given identifier.
	 * This is required for all other system calls using the particle.
	 * @param particleClass The particle class
	 * @param mapper Mapping to a destination the particle will be stored in
	 */
	<T extends Particle> void registerParticle(
		Class<T> particleClass,
		Function<T, RadixAddress> mapper,
		Function<T, Result> staticCheck
	);

	/**
	 * Registers a Particle with a given identifier.
	 * This is required for all other system calls using the particle.
	 * @param particleClass The particle class
	 * @param mapper Mapping to the destinations a particle will be stored in
	 */
	<T extends Particle> void registerParticleMultipleAddress(
		Class<T> particleClass,
		Function<T, Set<RadixAddress>> mapper,
		Function<T, Result> staticCheck
	);

	/**
	 * Creates a new resource type based on a particle. The resource type can be allocated by consuming
	 * an RRI which then becomes the resource's global identifier.
	 */
	<T extends Particle> void newRRIResource(
		Class<T> particleClass,
		Function<T, RRI> indexer
	);

	/**
	 * Creates a new resource type based on two particles. The resource type can be allocated by consuming
	 * an RRI which then becomes the resource's global identifier.
	 */
	<T extends Particle, U extends Particle> void newRRIResourceCombined(
		Class<T> particleClass0,
		Function<T, RRI> rriMapper0,
		Class<U> particleClass1,
		Function<U, RRI> rriMapper1,
		BiPredicate<T, U> combinedCheck
	);

	void newTransition(TransitionProcedure procedure);
}
