package me.gamrboy4life.paradox.module.player;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Regen extends Module {

	public Regen() {
		super("Regen", 0, Category.PLAYER);
	}
	
	@Override
	public void onUpdate() {
		if(!this.isToggled()) {
			return;
		}
		if(this.isToggled()) {
			if (!mc.thePlayer.capabilities.isCreativeMode && mc.thePlayer.getFoodStats().getFoodLevel() > 17
					&& mc.thePlayer.getHealth() < mc.thePlayer.getMaxHealth() && mc.thePlayer.getHealth() != 0) {
				for (int i = 0; i < 2; i++) {
					mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer());
				}
			}
			super.onUpdate();
		}
	}
}