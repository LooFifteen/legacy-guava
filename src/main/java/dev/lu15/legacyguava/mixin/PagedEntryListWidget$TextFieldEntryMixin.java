package dev.lu15.legacyguava.mixin;

import com.google.common.base.MoreObjects;
import net.minecraft.client.gui.widget.PagedEntryListWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PagedEntryListWidget.TextFieldEntry.class)
public abstract class PagedEntryListWidget$TextFieldEntryMixin {

    @Redirect(
            method = "<init>",
            at = @At(value = "INVOKE", target = "Lcom/google/common/base/Objects;firstNonNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;")
    )
    private <T> T firstNonNull(T first, T second) {
        return MoreObjects.firstNonNull(first, second);
    }

}
