package me.gamrboy4life.paradox.module.render;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;

public class FullBright extends Module{
	
	public FullBright() {
		super("FullBright", 0, Category.RENDER);
	}
	
	@Override
	public void onEnable(){
		if(this.isToggled()) {
			mc.gameSettings.gammaSetting = 100;
		}
	}
	
	@Override
	public void onDisable(){
		mc.gameSettings.gammaSetting = 1;
		super.onDisable();
	}

}
