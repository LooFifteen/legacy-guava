package dev.lu15.legacyguava;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;

public final class LegacyGuava {

    private LegacyGuava() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static <T> void addCallback(ListenableFuture<T> listenableFuture, FutureCallback<? super T> futureCallback) {
        Futures.addCallback(listenableFuture, futureCallback, MoreExecutors.directExecutor());
    }

}
