package dev.lu15.legacyguava.mixin.client;

import com.google.common.base.MoreObjects;
import net.minecraft.client.gui.hud.spectator.SpectatorMenuState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SpectatorMenuState.class)
public abstract class SpectatorMenuStateMixin {

    @Redirect(
            method = "getCommand",
            at = @At(value = "INVOKE", target = "Lcom/google/common/base/Objects;firstNonNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", remap = false)
    )
    private <T> T firstNonNull(T first, T second) {
        return MoreObjects.firstNonNull(first, second);
    }

}
