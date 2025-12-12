package mchorse.bbs_mod.client.cinematic;

import mchorse.bbs_mod.forms.entities.StubEntity;
import mchorse.bbs_mod.forms.entities.IEntity;
import mchorse.bbs_mod.forms.forms.Form;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;

/**
 * Lightweight client-side actor used to visually represent the player
 * during first-person film playback without changing the view entity.
 */
public class CinematicActor {
    private final StubEntity entity;

    public CinematicActor(Form form) {
        this.entity = new StubEntity(MinecraftClient.getInstance().world);
        this.entity.setForm(form);
        this.entity.setOnGround(true);
    }

    public IEntity getEntity() {
        return this.entity;
    }

    public void setPose(Vec3d pos, float yaw, float pitch) {
        entity.setPosition(pos.x, pos.y, pos.z);
        entity.setYaw(yaw);
        entity.setPitch(pitch);
    }

    public void setSneaking(boolean sneaking) {
        entity.setSneaking(sneaking);
    }

    public void setSprinting(boolean sprinting) {
        entity.setSprinting(sprinting);
    }
}
