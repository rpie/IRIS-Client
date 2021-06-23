package zeroday.player;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import zeroday.events.mainEvent;
import zeroday.events.listeners.EventUpdate;
import zeroday.modules.mainModule;

public class NoFall extends mainModule{
	
	public NoFall() {
		super("No Fall", Keyboard.KEY_O, Category.RENDER);
	}
	
	public void onEvent(mainEvent e) {
		if(e instanceof EventUpdate) {
			if(mc.thePlayer.fallDistance > 2 && e.isPre()) {
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
			}
		}
	}
}
