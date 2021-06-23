package zeroday.render;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C03PacketPlayer;
import zeroday.events.mainEvent;
import zeroday.events.listeners.EventUpdate;
import zeroday.modules.mainModule;
import zeroday.ui.ChatWrap;

public class AdvanceView extends mainModule{
	public AdvanceView() {
		super("Speed", Keyboard.KEY_K, Category.RENDER);
	}
	
	public void onEnabled() {
		ChatWrap.addChatMessage("Speed Enabled");
	}
	
	public void onDisable() {
		ChatWrap.addChatMessage("Speed Disabled");
	}
	
	public void onEvent(mainEvent e) {
		if(e instanceof EventUpdate) {
		}
	}

}
