package me.gamrboy4life.paradox.module.player;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;

public class NoBreakDelay extends Module {

	public NoBreakDelay() {
		super("NoBreakDelay", 0, Category.PLAYER);
	}
	
	@Override
	public void onUpdate() {
		mc.playerController.blockHitDelay = 0;
		super.onUpdate();
	}
	
}