package mchorse.bbs_mod.client.cinematic;

import mchorse.bbs_mod.forms.entities.IEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple registry of cinematic actors to render on client.
 */
public class CinematicActors {
    private CinematicActors() {}

    private static final List<CinematicActor> ACTORS = new ArrayList<>();

    public static void add(CinematicActor actor) {
        ACTORS.add(actor);
    }

    public static void clear() {
        ACTORS.clear();
    }

    public static List<CinematicActor> get() {
        return ACTORS;
    }

    public static void renderAll() {
        var client = MinecraftClient.getInstance();
        if (client.world == null || ACTORS.isEmpty()) return;

        PlayerEntity player = client.player;

        for (CinematicActor actor : ACTORS) {
            IEntity e = actor.getEntity();
            e.setAge(player.age);
        }
    }
}
