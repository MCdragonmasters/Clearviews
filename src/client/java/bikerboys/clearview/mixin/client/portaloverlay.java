package bikerboys.clearview.mixin.client;


import bikerboys.clearview.ClearviewConfig;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class portaloverlay {

    private DrawContext context;
    private float nauseaStrength;



    /**
     * @author d
     * @reason d
     */

    @Inject(method = "renderPortalOverlay", at = @At("HEAD"), cancellable = true)
    private void renderPortalOverlay(DrawContext context, float nauseaStrength, CallbackInfo ci) {

        if (ClearviewConfig.PortalOverlayDisabled) {
            ci.cancel();
        }
    }
    @Inject(method = "renderSpyglassOverlay", at = @At("HEAD"), cancellable = true)
    private void changespygalass(DrawContext context, float scale, CallbackInfo ci) {
        if (ClearviewConfig.RemoveSpyglassBorder) {
            ci.cancel();
        }


    }

}
