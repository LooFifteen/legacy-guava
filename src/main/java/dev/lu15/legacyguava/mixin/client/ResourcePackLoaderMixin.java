package dev.lu15.legacyguava.mixin.client;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import dev.lu15.legacyguava.LegacyGuava;
import net.minecraft.client.resource.ResourcePackLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ResourcePackLoader.class)
public abstract class ResourcePackLoaderMixin {

    @Redirect(
            method = "downloadResourcePack",
            at = @At(value = "INVOKE", target = "Lcom/google/common/util/concurrent/Futures;addCallback(Lcom/google/common/util/concurrent/ListenableFuture;Lcom/google/common/util/concurrent/FutureCallback;)V", remap = false)
    )
    private <T> void addCallback(ListenableFuture<T> listenableFuture, FutureCallback<? super T> futureCallback) {
        LegacyGuava.addCallback(listenableFuture, futureCallback);
    }

}
