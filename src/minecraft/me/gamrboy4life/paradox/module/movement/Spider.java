package me.gamrboy4life.paradox.module.movement;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;
import me.gamrboy4life.paradox.utils.Invoker;

public class Spider extends Module{

	public Spider() {
		super("Spider", 0, Category.MOVEMENT);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
				if(mc.thePlayer.isCollidedHorizontally){
					mc.thePlayer.motionY = 0.4f;
					mc.thePlayer.capabilities.allowFlying = true;
			}
		}
	}
}
