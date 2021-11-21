package me.gamrboy4life.paradox.gui;

import me.gamrboy4life.paradox.Paradox;
import me.gamrboy4life.paradox.module.Module;
import me.gamrboy4life.paradox.module.movement.Fly;
import me.gamrboy4life.paradox.utils.ColorUtils;
import me.gamrboy4life.paradox.utils.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;

public class GuiIngameHook extends GuiIngame{

	public GuiIngameHook(Minecraft mcIn) {
		super(mcIn);
	}
	
	public void renderGameOverlay(float p_175180_1_){
		int count = 0;
		int index = 0;
		long x = 0;
	    super.renderGameOverlay(p_175180_1_);
	    if(!mc.gameSettings.showDebugInfo) {
			Wrapper.fr.drawStringWithShadow("C", 4, 4, ColorUtils.getRainbow(4, 0.8f, 1, count * 170));
			Wrapper.fr.drawStringWithShadow("  hia", 4, 4, -1);
			Wrapper.fr.drawStringWithShadow("        b2.4", 4, 4, ColorUtils.getRainbow(4, 0.8f, 1, count * 170));
			renderArrayList();
			index++;
			x++;
	    }
	}
	
	private void renderArrayList() {
		int yCount = 12;
		int count = 0;
		for(Module m : Paradox.instance.moduleManager.getModules()) {
			m.onRender();
			
			if(m.isToggled()) {
				Wrapper.fr.drawStringWithShadow(m.getName(), 4, yCount + 5, ColorUtils.getRainbow(4, 0.8f, 1, count * 170));
				yCount += 10;
			}
		}
	}

}
