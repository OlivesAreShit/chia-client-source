package me.gamrboy4life.paradox.module.movement;

import org.lwjgl.input.Keyboard;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;

public class Speed extends Module{

	public Speed() {
		super("Speed", 0, Category.MOVEMENT);
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.onGround) {
				mc.thePlayer.motionX *= 1.11f;
				mc.thePlayer.motionZ *= 1.11f;
			}
		}
	}

}
