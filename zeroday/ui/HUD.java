package zeroday.ui;

import java.util.Collections;
import java.util.Comparator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import zeroday.mainClient;
import zeroday.events.listeners.EventRenderGUI;
import zeroday.modules.mainModule;

public class HUD {
	
	public Minecraft mc = Minecraft.getMinecraft();
	
	public static class ModuleComparator implements Comparator<mainModule>{

		@Override
		public int compare(mainModule o1, mainModule o2) {
			if(Minecraft.getMinecraft().fontRendererObj.getStringWidth(o1.name) > Minecraft.getMinecraft().fontRendererObj.getStringWidth(o2.name)) {
				return -1;
			}
			if(Minecraft.getMinecraft().fontRendererObj.getStringWidth(o1.name) < Minecraft.getMinecraft().fontRendererObj.getStringWidth(o2.name)) {
				return 1;
			}
			return 0;
		}
		
	}
	
	public void draw() {
		
		int count = 0;
		
		Collections.sort(mainClient.modules, new ModuleComparator());
		
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		mc.fontRendererObj.drawString("ZeroDay v0.1 - " + mc.thePlayer.getDisplayName().getFormattedText(), 4, 4, -1);
		
		for(mainModule m : mainClient.modules) {
			if(!m.toggled)
				continue;
			mc.fontRendererObj.drawString(m.name, sr.getScaledWidth() - mc.fontRendererObj.getStringWidth(m.name) - 4, 4 + count * (mc.fontRendererObj.FONT_HEIGHT + 4), -1);
			count++;
		}
		
		mainClient.onEvent(new EventRenderGUI());
		
	}
}
