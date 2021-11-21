package me.gamrboy4life.paradox.module;

import java.util.ArrayList;

import me.gamrboy4life.paradox.module.combat.*;
import me.gamrboy4life.paradox.module.misc.*;
import me.gamrboy4life.paradox.module.movement.*;
import me.gamrboy4life.paradox.module.player.*;
import me.gamrboy4life.paradox.module.render.*;
import me.gamrboy4life.paradox.utils.esp.ChestESPUtils;

public class ModuleManager {

	public static ArrayList<Module> mods;
	
	public ModuleManager(){
		mods = new ArrayList<Module>();
		//COMBAT
		newMod(new KillAura());
		newMod(new WTap());
		newMod(new AimAssist());
		newMod(new FastBow());
		newMod(new AimBot());
		newMod(new Antibot());
		newMod(new InvCleaner());
		
		//MOVEMENT
		newMod(new AutoSprint());
		newMod(new Bhop());
		newMod(new AutoWalk());
		newMod(new Dolphin());
		newMod(new Fly());
		newMod(new Glide());
		newMod(new Jetpack());
		newMod(new Parkour());
		newMod(new Sneak());
		newMod(new Speed());
		newMod(new Spider());
		newMod(new Step());
		newMod(new NoFall());
		newMod(new InventoryMove());
		
		//PLAYER
		newMod(new FastPlace());
		newMod(new FastLadder());
		newMod(new Respawn());
		newMod(new AutoMine());
		newMod(new AntiCobweb());
		newMod(new AutoArmor());
		newMod(new NoBreakDelay());
		newMod(new Regen());
		newMod(new BedBreaker());
		newMod(new Scaffold());
		
		//RENDER
		newMod(new ClickGui());
		newMod(new ESP());
		newMod(new Xray());
		newMod(new FullBright());
		
		//MISC
		newMod(new ChestStealer());
		newMod(new Timer());
	}
	
	public static void newMod(Module m){
		mods.add(m);
	}
	
	public static ArrayList<Module> getModules(){
		return mods;
	}
	
	public static void onUpdate(){
		for(Module m : mods){
			m.onUpdate();
		}
	}
	
	public static void onRender(){
		for(Module m : mods){
			m.onRender();
		}
	}
	
	public static void onKey(int k){
		for(Module m : mods){
			if(m.getKey() == k){
				m.toggle();
			}
		}
	}
}
