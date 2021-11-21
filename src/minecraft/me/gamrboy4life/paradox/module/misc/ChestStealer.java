package me.gamrboy4life.paradox.module.misc;

import org.lwjgl.input.Keyboard;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;
import me.gamrboy4life.paradox.utils.ChestUtil;
import me.gamrboy4life.paradox.utils.timers.TimerUtils;
import net.minecraft.inventory.ContainerChest;

public class ChestStealer extends Module {

	int delay = 20;

	public ChestStealer() {
		super("ChestStealer", Keyboard.KEY_Q, Category.MISC);
	}

	public void onUpdate() {
		if (this.isToggled()) {
			if ((mc.thePlayer.openContainer != null) && ((mc.thePlayer.openContainer instanceof ContainerChest))) {
				ContainerChest container = (ContainerChest) mc.thePlayer.openContainer;

				for (int i = 0; i < container.getLowerChestInventory().getSizeInventory(); i++) {
					if ((container.getLowerChestInventory().getStackInSlot(i) != null)
							&& (TimerUtils.hasReached((delay)))) {
						mc.playerController.windowClick(container.windowId, i, 0, 1, mc.thePlayer);
						TimerUtils.rt();
					}

				}
				if (ChestUtil.isChestEmpty(container)) {
					mc.thePlayer.closeScreen();
				}
			}
		}
	}
}
