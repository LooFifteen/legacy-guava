package dev.lu15.legacyguava.mixin.common;

import com.google.common.base.MoreObjects;
import net.minecraft.world.gen.carver.CaveCarver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CaveCarver.class)
public abstract class CaveCarverMixin {

    /**
     * uses the newer {@code firstNonNull} from Guava
     */
    @Redirect(
            method = "carveCave(JIILnet/minecraft/world/chunk/ChunkBlockStateStorage;DDDFFFIID)V",
            at = @At(value = "INVOKE", target = "Lcom/google/common/base/Objects;firstNonNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", remap = false)
    )
    private <T> T firstNonNull(T first, T second) {
        return MoreObjects.firstNonNull(first, second);
    }

}
