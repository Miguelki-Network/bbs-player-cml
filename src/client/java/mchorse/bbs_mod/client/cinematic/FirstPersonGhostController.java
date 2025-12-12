package mchorse.bbs_mod.client.cinematic;

import mchorse.bbs_mod.film.Film;
import mchorse.bbs_mod.film.replays.Replay;
import mchorse.bbs_mod.forms.forms.Form;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;

/**
 * Controller that spawns a ghost actor when FP replay is active
 * and updates its pose each tick from replay keyframes.
 */
public class FirstPersonGhostController {
    private CinematicActor ghost;
    private Replay fpReplay;

    public void onFilmStart(Film film) {
        fpReplay = film.getFirstPersonReplay();
        if (fpReplay == null) return;

        Form form = fpReplay.form.get();
        if (form == null) return;

        ghost = new CinematicActor(form);
        CinematicActors.add(ghost);
    }

    public void onFilmEnd() {
        CinematicActors.clear();
        ghost = null;
        fpReplay = null;
    }

    public void tick() {
        if (ghost == null || fpReplay == null) return;
        // Minimal pose update; proper integration should read ReplayKeyframes
        var client = MinecraftClient.getInstance();
        var player = client.player;
        if (player == null) return;

        Vec3d pos = player.getPos();
        float yaw = player.getHeadYaw();
        float pitch = player.getPitch();

        ghost.setPose(pos, yaw, pitch);
    }
}
