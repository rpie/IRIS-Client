package zeroday.render;

import org.lwjgl.input.Keyboard;

import zeroday.events.mainEvent;
import zeroday.events.listeners.EventUpdate;
import zeroday.modules.mainModule;

public class FullBright extends mainModule{
	
	public FullBright() {
		super("Full Bright", Keyboard.KEY_O, Category.RENDER);
	}
	
	public void onEnabled() {
		mc.gameSettings.gammaSetting = 100;
	}
	
	public void onDisable() {
		mc.gameSettings.gammaSetting = 1;
	}	
}
