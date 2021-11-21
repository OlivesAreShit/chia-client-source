package me.gamrboy4life.paradox.module.combat;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;

public class WTap extends Module{
	
	private Float coolDown = 0f;
	
	public WTap() {
		super("WTap", 0, Category.COMBAT);
	}

    @Override
    public void onUpdate() {
    	if(this.isToggled()) {
	    	coolDown -= 1f;
	    	mc.thePlayer.setSprinting(true);
	        if (mc.thePlayer.isSwingInProgress)
	        	if (coolDown < 0) {
	        		mc.thePlayer.setSprinting(false);
	        		coolDown = 3f;
	        	}
    	}
    }
    
    @Override
    public void onDisable() {
    	super.onDisable();
    }
}