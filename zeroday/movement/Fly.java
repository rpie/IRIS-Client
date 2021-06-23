package zeroday.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import zeroday.events.mainEvent;
import zeroday.events.listeners.EventUpdate;
import zeroday.modules.mainModule;
import zeroday.ui.ChatWrap;

public class Fly extends mainModule{
	
	public Fly() {
		super("Fly", Keyboard.KEY_G, Category.MOVEMENT);
	}
	
	public void onEnabled() {
		ChatWrap.addChatMessage("Auto No-Fall is enabled");
	}
	
	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
		mc.thePlayer.capabilities.allowFlying = false;
	}
	
	public void onEvent(mainEvent e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
				mc.thePlayer.capabilities.allowFlying = true;
				mc.thePlayer.capabilities.setFlySpeed((float) 0.2);
			}
		}
	}
	
}
