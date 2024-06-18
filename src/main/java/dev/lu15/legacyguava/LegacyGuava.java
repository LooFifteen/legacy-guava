package dev.lu15.legacyguava;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import org.jetbrains.annotations.NotNull;

public final class LegacyGuava {

    private LegacyGuava() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static <T> void addCallback(@NotNull ListenableFuture<T> listenableFuture, @NotNull FutureCallback<? super T> futureCallback) {
        Futures.addCallback(listenableFuture, futureCallback, MoreExecutors.directExecutor());
    }

}
