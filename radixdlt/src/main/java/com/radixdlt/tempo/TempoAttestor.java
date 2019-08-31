package com.radixdlt.tempo;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.radixdlt.common.AID;
import com.radixdlt.common.EUID;
import com.radixdlt.utils.Pair;
import com.radixdlt.crypto.CryptoException;
import com.radixdlt.crypto.ECKeyPair;
import com.radixdlt.crypto.Hash;
import org.radix.exceptions.ValidationException;
import org.radix.logging.Logger;
import org.radix.logging.Logging;
import org.radix.time.TemporalProof;
import org.radix.time.TemporalVertex;
import org.radix.universe.system.LocalSystem;

import java.util.List;
import java.util.Objects;
import java.util.function.LongSupplier;

public final class TempoAttestor implements Attestor {
	private static final Logger logger = Logging.getLogger("tempo.attestor");

	private final LocalSystem localSystem;
	private final WallclockTimeSupplier wallclockTimeSupplier;

	@Inject
	public TempoAttestor(
		@Named("self") LocalSystem localSystem,
		WallclockTimeSupplier wallclockTimeSupplier
	) {
		this.localSystem = Objects.requireNonNull(localSystem, "localSystem is required");
		this.wallclockTimeSupplier = Objects.requireNonNull(wallclockTimeSupplier, "wallclockTimeSupplier");
	}

	public TemporalProof attestTo(TemporalProof temporalProof, List<EUID> edges) {
		TemporalVertex existingNIDVertex = temporalProof.getVertexByNID(this.localSystem.getNID());
		AID aid = temporalProof.getAID();
		if (existingNIDVertex != null) {
			if (existingNIDVertex.getClock() > this.localSystem.getClock().get()) {
				this.localSystem.set(existingNIDVertex.getClock(), existingNIDVertex.getCommitment(), wallclockTimeSupplier.getAsLong());
			}
			if (logger.hasLevel(Logging.DEBUG)) {
				logger.debug("Refusing to attest to atom '" + aid + "', already attested to it");
			}

			return temporalProof;
		}

		long wallclockTime = wallclockTimeSupplier.getAsLong();
		Pair<Long, Hash> clockAndCommitment = this.localSystem.update(aid, wallclockTime);
		TemporalVertex previousVertex = null;
		if (!temporalProof.isEmpty()) {
			for (TemporalVertex vertex : temporalProof.getVertices()) {
				if (vertex.getEdges().contains(this.localSystem.getNID())) {
					previousVertex = vertex;
					break;
				} else if (previousVertex == null) {
					previousVertex = vertex;
				}
			}
		}

		ECKeyPair nodeKey = this.localSystem.getKeyPair();
		TemporalVertex vertex = new TemporalVertex(nodeKey.getPublicKey(),
			clockAndCommitment.getFirst(),
			wallclockTime,
			clockAndCommitment.getSecond(),
			previousVertex != null ? previousVertex.getHID() : EUID.ZERO,
			edges);
		if (logger.hasLevel(Logging.DEBUG)) {
			logger.debug("Attesting to '" + aid + "' at " + clockAndCommitment.getFirst());
		}
		try {
			temporalProof.add(vertex, nodeKey);
		} catch (ValidationException | CryptoException e) {
			throw new TempoException("Error while attesting to atom '" + aid + "'", e);
		}

		return temporalProof;
	}
}
