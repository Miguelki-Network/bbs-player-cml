package mchorse.bbs_mod.client.cinematic;

import mchorse.bbs_mod.film.Film;
import mchorse.bbs_mod.mixin.client.GhostClientTickMixin;

/**
 * Public client API to control ghost lifecycle from film playback.
 */
public class GhostClientAPI {
    public static void onFilmStart(Film film) {
        // Delegate to mixin's private static via an accessor bridge
        // We can't call private methods; instead, keep a controller here.
        GhostLifecycleHolder.CONTROLLER.onFilmStart(film);
    }
    public static void onFilmEnd() {
        GhostLifecycleHolder.CONTROLLER.onFilmEnd();
    }

    // Holder to keep a singleton controller accessible outside mixin
    private static class GhostLifecycleHolder {
        private static final FirstPersonGhostController CONTROLLER = new FirstPersonGhostController();
    }
}
