package me.gamrboy4life.paradox.module.combat;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;

public class Antibot extends Module {
    public Antibot() {
        super("Antibot", 0, Category.COMBAT);
    }

    public void onUpdate() {
        if (!this.isToggled()) {
        	return;
        }
        if (this.isToggled()) {
            for (Object entity : mc.theWorld.loadedEntityList) {
                if (((Entity) entity).isInvisible() && entity != mc.thePlayer) {
                    mc.theWorld.removeEntity((Entity) entity);
                }
            }
        }
    }
    
    private boolean isOnTab(Entity entity) {
        for (NetworkPlayerInfo info : mc.getNetHandler().getPlayerInfoMap()) {
            if (info.getGameProfile().getName().equals(entity.getName()))
                return true;
        }
        return false;
    }
}
