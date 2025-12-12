package mchorse.bbs_mod.mixin.client;

import mchorse.bbs_mod.client.cinematic.FirstPersonGhostController;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class GhostClientTickMixin {
    @Unique
    private static final FirstPersonGhostController BBS_GHOST_CONTROLLER = new FirstPersonGhostController();

    @Inject(method = "tick", at = @At("TAIL"))
    private void bbsTickGhost(CallbackInfo ci) {
        BBS_GHOST_CONTROLLER.tick();
    }

    // Public accessors for integration (optional):
    private static void bbsOnFilmStart(mchorse.bbs_mod.film.Film film) {
        BBS_GHOST_CONTROLLER.onFilmStart(film);
    }
    private static void bbsOnFilmEnd() {
        BBS_GHOST_CONTROLLER.onFilmEnd();
    }
}
