package me.gamrboy4life.paradox.module.movement;

import org.lwjgl.input.Keyboard;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;

public class Bhop extends Module{

	public Bhop() {
		super("Bhop", Keyboard.KEY_M, Category.MOVEMENT);
	}
	
	@Override
	public void onDisable() {
        mc.thePlayer.speedInAir = 0.02F;

        mc.thePlayer.motionX = 0.0;
        mc.thePlayer.motionZ = 0.0;
		super.onDisable();
	}
	
	@Override
	public void onEnable() {
		mc.thePlayer.speedInAir = 0.3223f;
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			mc.thePlayer.setSprinting(false);
			if(mc.thePlayer.onGround){
				mc.thePlayer.speedInAir = 0.5f;
			}else{
				mc.thePlayer.speedInAir = 0.3223f;
				
				mc.thePlayer.motionX = 0.0;
				mc.thePlayer.motionZ = 0.0;
			}
		}
	}

}
