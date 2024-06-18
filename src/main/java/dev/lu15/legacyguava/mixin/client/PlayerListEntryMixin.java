package dev.lu15.legacyguava.mixin.client;

import com.google.common.base.MoreObjects;
import net.minecraft.client.network.PlayerListEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerListEntry.class)
public abstract class PlayerListEntryMixin {

    @Redirect(
            method = "getSkinTexture",
            at = @At(value = "INVOKE", target = "Lcom/google/common/base/Objects;firstNonNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", remap = false)
    )
    private <T> T firstNonNull(T first, T second) {
        return MoreObjects.firstNonNull(first, second);
    }

}
