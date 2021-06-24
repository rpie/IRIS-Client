package zeroday.player;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import zeroday.events.mainEvent;
import zeroday.events.listeners.EventUpdate;
import zeroday.modules.mainModule;

public class PosXYZ extends mainModule{
	
	public PosXYZ() {
		super("XYZ", Keyboard.KEY_O, Category.RENDER);
	}
	

	public void onEvent(mainEvent e) {
		if(e instanceof EventUpdate) {
			
		}
	}
}
