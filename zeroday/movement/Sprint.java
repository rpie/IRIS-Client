package zeroday.movement;

import org.lwjgl.input.Keyboard;

import zeroday.events.mainEvent;
import zeroday.events.listeners.EventUpdate;
import zeroday.modules.mainModule;

public class Sprint extends mainModule{
	
	public Sprint() {
		super("Sprint", Keyboard.KEY_N, Category.MOVEMENT);
	}
	
	public void onEnabled() {
	}
	
	public void onDisable() {
		mc.thePlayer.setSprinting(mc.gameSettings.keyBindSprint.getIsKeyPressed());
	}
	
	public void onEvent(mainEvent e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
				if(mc.thePlayer.moveForward > 0 && !mc.thePlayer.isUsingItem() && !mc.thePlayer.isSneaking() && !mc.thePlayer.isCollidedHorizontally)
					mc.thePlayer.setSprinting(true);
			}
		}
	}
	
}
