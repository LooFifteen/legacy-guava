package dev.lu15.legacyguava.mixin;

import com.google.common.base.MoreObjects;
import net.minecraft.client.gui.hud.spectator.SpectatorMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SpectatorMenu.class)
public abstract class SpectatorMenuMixin {

    @Redirect(
            method = "getCommand",
            at = @At(value = "INVOKE", target = "Lcom/google/common/base/Objects;firstNonNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", remap = false)
    )
    private <T> T firstNonNull(T first, T second) {
        return MoreObjects.firstNonNull(first, second);
    }

}
