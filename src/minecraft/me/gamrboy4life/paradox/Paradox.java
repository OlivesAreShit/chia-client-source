package me.gamrboy4life.paradox;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.Display;

import de.Hero.clickgui.ClickGUI;
import de.Hero.settings.SettingsManager;
import me.gamrboy4life.paradox.alt.AltManager;
import me.gamrboy4life.paradox.extensions.DiscordRP;
import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;
import me.gamrboy4life.paradox.module.ModuleManager;


public class Paradox {
	
	public static String name = "Chia", version = "1.8.8", creator = "Trajkot";
	public static Paradox instance = new Paradox();	
	public static SettingsManager settingsManager;
	public static ModuleManager moduleManager;
	public static ClickGUI clickGUI;
	public static DiscordRP discordRP = new DiscordRP();
	public static AltManager altManager;
	
	public static void startClient(){
		settingsManager = new SettingsManager();
		moduleManager = new ModuleManager();
		clickGUI = new ClickGUI();
		discordRP.start();
		altManager = new AltManager();
		Display.setTitle(name + " " + version + " by " + creator);
	}
	
	public static DiscordRP getDiscordRP() {
		return discordRP;
	}
}
