package dev.lu15.legacyguava.mixin;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net.minecraft.util.TypeFilterableList$1")
public abstract class TypeFilterableList$1Mixin {

    /**
     * uses the workaround for the old {@code Iterators.emptyIterator} from Guava
     */
    @Redirect(
            method = "iterator",
            at = @At(value = "INVOKE", target = "Lcom/google/common/collect/Iterators;emptyIterator()Lcom/google/common/collect/UnmodifiableIterator;", remap = false)
    )
    private <T> UnmodifiableIterator<T> firstNonNull() {
        return ImmutableSet.<T>of().iterator();
    }

}
