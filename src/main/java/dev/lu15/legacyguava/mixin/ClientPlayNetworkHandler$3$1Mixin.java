package dev.lu15.legacyguava.mixin;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import dev.lu15.legacyguava.LegacyGuava;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net.minecraft.client.network.ClientPlayNetworkHandler$3$1")
public abstract class ClientPlayNetworkHandler$3$1Mixin {

    @Redirect(
            method = "confirmResult",
            at = @At(value = "INVOKE", target = "Lcom/google/common/util/concurrent/Futures;addCallback(Lcom/google/common/util/concurrent/ListenableFuture;Lcom/google/common/util/concurrent/FutureCallback;)V", remap = false)
    )
    private <T> void addCallback(ListenableFuture<T> listenableFuture, FutureCallback<? super T> futureCallback) {
        LegacyGuava.addCallback(listenableFuture, futureCallback);
    }

}
