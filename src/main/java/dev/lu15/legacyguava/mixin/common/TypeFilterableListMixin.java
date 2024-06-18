package dev.lu15.legacyguava.mixin.common;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import net.minecraft.util.TypeFilterableList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TypeFilterableList.class)
public abstract class TypeFilterableListMixin {

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
