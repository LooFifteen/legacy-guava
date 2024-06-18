package dev.lu15.legacyguava.mixin.client;

import com.google.common.base.MoreObjects;
import net.minecraft.client.BlockStateMapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockStateMapper.class)
public abstract class BlockStateMapperMixin {

    /**
     * uses the newer {@code firstNonNull} from Guava
     */
    @Redirect(
            method = "getBlockStateMap",
            at = @At(value = "INVOKE", target = "Lcom/google/common/base/Objects;firstNonNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", remap = false)
    )
    private <T> T firstNonNull(T first, T second) {
        return MoreObjects.firstNonNull(first, second);
    }

}
