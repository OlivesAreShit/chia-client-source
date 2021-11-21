package me.gamrboy4life.paradox.module.movement;

import org.lwjgl.input.Keyboard;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;
import me.gamrboy4life.paradox.utils.Wrapper;


public class AutoSprint extends Module{

    public AutoSprint() {
        super("AutoSprint", 0, Category.MOVEMENT);
    }

    public void onUpdate() {
        if (!this.isToggled()) {
            return;
        }
        if(mc.thePlayer.moveForward > 0 && !mc.thePlayer.isBlocking() && !mc.thePlayer.isUsingItem() && !mc.thePlayer.isOnLadder()) {
            Wrapper.mc.thePlayer.setSprinting(true);
        } else {
            Wrapper.mc.thePlayer.setSprinting(false);
        }
    }
}