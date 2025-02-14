package io.smallrye.mutiny.converters.multi;

import java.util.function.Function;

import io.reactivex.rxjava3.core.Completable;
import io.smallrye.mutiny.Multi;

@SuppressWarnings("rawtypes")
public class ToCompletable<T> implements Function<Multi<T>, Completable> {

    public static final ToCompletable INSTANCE = new ToCompletable();

    private ToCompletable() {
        // Avoid direct instantiation
    }

    @Override
    public Completable apply(Multi<T> multi) {
        return Completable.fromPublisher(multi.onItem().ignore());
    }
}
