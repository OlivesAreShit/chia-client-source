package me.gamrboy4life.paradox.module.misc;

import me.gamrboy4life.paradox.Paradox;
import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;

public class Timer extends Module{
	public Timer() {
		super("Timer", 0, Category.MISC);
	}
	
	@Override
	public void onEnable() {
		if(this.isToggled()) {
			mc.timer.timerSpeed = 2.0F;
			super.onEnable();
		}
	}
	
	@Override
	public void onDisable() {
		if(!this.isToggled()) {
			mc.timer.timerSpeed = 1.0F;
			super.onDisable();
		}
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			mc.timer.timerSpeed = 2.0F;
			super.onEnable();
		}
	}

}
