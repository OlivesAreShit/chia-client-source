package me.gamrboy4life.paradox.module.movement;

import org.lwjgl.input.Keyboard;

import me.gamrboy4life.paradox.Paradox;
import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;
import me.gamrboy4life.paradox.utils.Wrapper;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.MathHelper;

public final class Fly extends Module {

	public Fly() {		
	super("Fly", Keyboard.KEY_G, Category.MOVEMENT);
	}
	
	@Override
	public void onDisable(){
		mc.thePlayer.capabilities.isFlying = false;
		super.onDisable();
	}
	
	@Override
	public void onUpdate()
	{
		if(this.isToggled()) {
			damage();
			if(mc.thePlayer.isSprinting()) {
				mc.thePlayer.setSprinting(false);
			}	
			if(mc.thePlayer.onGround) {
				mc.thePlayer.jump();
			}
			if(mc.thePlayer.isCollidedHorizontally) {
				this.setToggled(false);
				mc.thePlayer.capabilities.isFlying = false;
				mc.thePlayer.capabilities.allowFlying = false;
				return;	
			}
			mc.thePlayer.capabilities.isFlying = true;
			mc.gameSettings.keyBindLeft.pressed = false;
			mc.gameSettings.keyBindJump.pressed = false;
			mc.gameSettings.keyBindRight.pressed = false;
			mc.gameSettings.keyBindBack.pressed = false;
			mc.gameSettings.keyBindSneak.pressed = false;
			mc.gameSettings.keyBindSprint.pressed = false;
			mc.thePlayer.capabilities.setFlySpeed(0.3f);
			super.onUpdate();
		}
	}
	
	public void damage(){

        int damage = 1;
        if (damage > MathHelper.floor_double(mc.thePlayer.getMaxHealth()))
            damage = MathHelper.floor_double(mc.thePlayer.getMaxHealth());

        double offset = 0.0625;
        if (mc.thePlayer != null && mc.getNetHandler() != null && mc.thePlayer.onGround) {
            for (short i = 0; i <= ((3 + damage) / offset); i++) {
                mc.getNetHandler().addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX,
                        mc.thePlayer.posY + offset, mc.thePlayer.posZ, false));
                mc.getNetHandler().addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX,
                        mc.thePlayer.posY, mc.thePlayer.posZ, (i == ((3 + damage) / offset))));
            }
        }
	}
}