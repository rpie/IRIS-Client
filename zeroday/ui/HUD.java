package zeroday.ui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import zeroday.mainClient;
import zeroday.events.listeners.EventRenderGUI;
import zeroday.modules.mainModule;

public class HUD {
	
	public Minecraft mc = Minecraft.getMinecraft();
	public ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
	private FontRenderer font = mc.fontRendererObj;
	private List<Long> clicks = new ArrayList<Long>();
	private boolean wasPressed;
    private long lastPress;
    
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
	
	private int getCPS() {
        final long time = System.currentTimeMillis();
        this.clicks.removeIf(aLong -> aLong + 1000L < time);
        return this.clicks.size();
    }
	
	public void keyStrokes() {
		int wAlpha = (Keyboard.isKeyDown(mc.gameSettings.keyBindForward.getKeyCode()) ? 125 : 50);
		int aAlpha = (Keyboard.isKeyDown(mc.gameSettings.keyBindLeft.getKeyCode()) ? 125 : 50);
		int sAlpha = (Keyboard.isKeyDown(mc.gameSettings.keyBindBack.getKeyCode()) ? 125 : 50);
		int dAlpha = (Keyboard.isKeyDown(mc.gameSettings.keyBindRight.getKeyCode()) ? 125 : 50);
		
		Gui.drawRect(sr.getScaledWidth() - 29 - 29, sr.getScaledHeight() - 4 - 25 - 29, sr.getScaledWidth() - 4 - 29, sr.getScaledHeight() - 4 - 29, new Color(0, 0, 0, wAlpha).getRGB());
		Gui.drawRect(sr.getScaledWidth() - 29 - 29 - 29, sr.getScaledHeight() - 4 - 25, sr.getScaledWidth() - 4 - 29 - 29, sr.getScaledHeight() - 4, new Color(0, 0, 0, aAlpha).getRGB());
		Gui.drawRect(sr.getScaledWidth() - 29 - 29, sr.getScaledHeight() - 4 - 25, sr.getScaledWidth() - 4 - 29, sr.getScaledHeight() - 4, new Color(0, 0, 0, sAlpha).getRGB());
		Gui.drawRect(sr.getScaledWidth() - 29, sr.getScaledHeight() - 4 - 25, sr.getScaledWidth() - 4, sr.getScaledHeight() - 4, new Color(0, 0, 0, dAlpha).getRGB());
		
		font.drawString("W", sr.getScaledWidth() - 48, sr.getScaledHeight() - 49, 0xffffffff);
		font.drawString("A", sr.getScaledWidth() - 77, sr.getScaledHeight() - 20, 0xffffffff);
		font.drawString("S", sr.getScaledWidth() - 48, sr.getScaledHeight() - 20, 0xffffffff);
		font.drawString("D", sr.getScaledWidth() - 19, sr.getScaledHeight() - 20, 0xffffffff);
	}
	
	public void FPS() {
		int fps = mc.getDebugFPS();
		mc.fontRendererObj.drawString("FPS : " + fps, 4, 20, -1);
	}
	
	public void CPS() {
		final boolean pressed = Mouse.isButtonDown(0);
        if (pressed != this.wasPressed) {
            this.wasPressed = pressed;
            this.lastPress = System.currentTimeMillis();
            if (pressed) {
                this.clicks.add(this.lastPress);
            }
        }
		final int cps = this.getCPS();
		mc.fontRendererObj.drawString("CPS : " + cps, 4, 30, -1);
	}
	
	public void draw() {
		keyStrokes();
		FPS();
		CPS();
		
		int count = 0;
		
		Collections.sort(mainClient.modules, new ModuleComparator());
		
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
