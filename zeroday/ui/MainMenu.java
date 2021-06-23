package zeroday.ui;

import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.util.ResourceLocation;

public class MainMenu extends GuiScreen {

	public MainMenu() {
		
	}
	
	public void initGui() {
		
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		mc.getTextureManager().bindTexture(new ResourceLocation("0day/menu.jpg"));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
	
		String[] buttons = {"Singleplayer", "Multiplayer", "Settings", "Quit"};
		int count = 0;
		
		for(String name : buttons) {
			float x = (width/buttons.length) * count + (width/buttons.length)/2f + 5 - mc.fontRendererObj.getStringWidth(name)/2f;
			float y = height - 30;

			boolean hovered = mouseX >= x && mouseY >= y && mouseX < x + mc.fontRendererObj.getStringWidth(name) && mouseY < y + mc.fontRendererObj.FONT_HEIGHT;
			
			this.drawCenteredString(mc.fontRendererObj, name, (width/buttons.length) * count + (width/buttons.length)/2f + 5, height - 30, hovered ? 0x4C5E7A : 0x607699);
			count++;
		}
	}
	
	public void mouseClicked(int mouseX, int mouseY, int button) {
		String[] buttons = {"Singleplayer", "Multiplayer", "Settings", "Quit"};
		
		int count = 0;
		for(String name : buttons) {
			float x = (width/buttons.length) * count + (width/buttons.length)/2f + 5;
			float y = height*5;
			
			if(mouseX >= x && mouseY >= y && mouseX < x + mc.fontRendererObj.getStringWidth(name) && mouseY < y + mc.fontRendererObj.FONT_HEIGHT) {
				switch(name) {
					case "Singleplayer":
						mc.displayGuiScreen(new GuiSelectWorld(this));
						break;
						
					case "Multiplayer":
						mc.displayGuiScreen(new GuiMultiplayer(this));
						break;
						
					case "Settings":
						mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
						break;
						
					case "Exit":
						mc.shutdown();
						break;
				}
			}
			
			count++;
		}
	}
	
	public void onGuiClosed() {
		
	}
}
