package com.radixdlt.tempo.reactive;

import com.radixdlt.tempo.TempoStateBundle;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface TempoFlow<T> {
	<R> TempoFlow<R> map(Function<? super T, ? extends R> mapper);

	<R> TempoFlow<R> flatMap(Function<? super T, Stream<? extends R>> mapper);

	TempoFlow<T> filter(Predicate<? super T> filter);

	void forEach(Consumer<T> consumer);

	<R> TempoFlow<R> map(BiFunction<? super T, TempoStateBundle, ? extends R> mapper,
	                     Class<? extends TempoState> requiredState,
	                     Class<? extends TempoState>... requiredStates);

	<R> TempoFlow<R> flatMap(BiFunction<? super T, TempoStateBundle, Stream<? extends R>> mapper,
	                         Class<? extends TempoState> requiredState,
	                         Class<? extends TempoState>... requiredStates);

	TempoFlow<T> filter(BiPredicate<? super T, TempoStateBundle> filter,
	                    Class<? extends TempoState> requiredState,
	                    Class<? extends TempoState>... requiredStates);

	void forEach(BiConsumer<T, TempoStateBundle> consumer,
	             Class<? extends TempoState> requiredState,
	             Class<? extends TempoState>... requiredStates);
}
