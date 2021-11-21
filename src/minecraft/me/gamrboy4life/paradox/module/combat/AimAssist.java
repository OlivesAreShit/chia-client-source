package me.gamrboy4life.paradox.module.combat;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;

public class AimAssist extends Module{

	public float oldSens;
	
	public AimAssist() {
		super("AimAssist", 0, Category.COMBAT);
	}

	public void onEnable(){
		oldSens = mc.gameSettings.mouseSensitivity;
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.objectMouseOver.entityHit != null){
				mc.gameSettings.mouseSensitivity = 0.1f;
			}
			else
			{
				mc.gameSettings.mouseSensitivity = oldSens;
			}
		}
	}
}