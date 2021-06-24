package zeroday.ui.ingame;

import java.awt.Color;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;

public class igUI {

	private Minecraft mc = Minecraft.getMinecraft();
	private FontRenderer font = mc.fontRendererObj;
	
	public igUI(Minecraft mcIN) {
		super();
	}
	
	public void renderGameOverlay(float partialTicks) {		
		if(!mc.gameSettings.showDebugInfo) {
			renderInfo();
			renderKeyStrokes();
			renderPlayer();
		}
	}
	
	private void renderInfo() {
		GL11.glPushMatrix();
		GL11.glScalef(1.5F, 1.5F, 1.5F);
		font.drawString("", 2, 2, 0xff1C4BE0);
		GL11.glPopMatrix();
		
		font.drawString(ChatFormatting.AQUA + "FPS" + ChatFormatting.GRAY + "> " + ChatFormatting.WHITE + mc.getDebugFPS(), 5, 22, 0xffffffff);
		font.drawString(ChatFormatting.AQUA + "X" + ChatFormatting.GRAY + "> " + ChatFormatting.WHITE + Math.round(mc.thePlayer.posX), 5, 32, 0xffffffff);
		font.drawString(ChatFormatting.AQUA + "Y" + ChatFormatting.GRAY + "> " + ChatFormatting.WHITE + Math.round(mc.thePlayer.posY), 5, 42, 0xffffffff);
		font.drawString(ChatFormatting.AQUA + "Z" + ChatFormatting.GRAY + "> " + ChatFormatting.WHITE + Math.round(mc.thePlayer.posZ), 5, 52, 0xffffffff);
	}
	

	private void renderKeyStrokes() {
		ScaledResolution sr = new ScaledResolution(mc, 0, 0);
		
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
	
	private void renderPlayer() {
		GuiInventory.drawEntityOnScreen(80, 55, 25, 0, 0, mc.thePlayer);
	}
	
}
