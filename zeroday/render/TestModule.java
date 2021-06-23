package zeroday.render;

import java.sql.Time;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import zeroday.events.mainEvent;
import zeroday.events.listeners.EventRenderGUI;
import zeroday.events.listeners.EventUpdate;
import zeroday.modules.mainModule;
import zeroday.ui.ChatWrap;

public class TestModule extends mainModule{
	
	public TestModule() {
		super("HUD", Keyboard.KEY_RSHIFT, Category.RENDER);
	}

	public void onEnabled() {
		ChatWrap.addChatMessage("HUD Enabled");
	}
	
	public void onDisable() {
		ChatWrap.addChatMessage("HUD Disabled");
	}
	
	
	public void onEvent(mainEvent e) {
		if(e instanceof EventRenderGUI) {
			mc.fontRendererObj.drawString(mc.debug.formatted(), 4, 16, -1);
		}
	}
}
