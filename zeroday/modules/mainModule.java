package zeroday.modules;

import net.minecraft.client.Minecraft;
import zeroday.events.mainEvent;

public class mainModule {

	public String name;
	public boolean toggled;
	public int keyCode;
	public Category category;
	public Minecraft mc = Minecraft.getMinecraft();
	
	public mainModule(String name, int key, Category c) {
		this.name = name;
		this.keyCode = key;
		this.category = c;
	}
	
	public boolean isEnabled() {
		return toggled;
	}
	
	public int getKey() {
		return keyCode;
	}
	
	public void onEvent(mainEvent e) {
		
	}
	
	public void toggle() {
		toggled = !toggled;
		if(toggled) {
			onEnabled();
		}
		else {
			onDisable();
		}
	}
	
	public void onEnabled() {
		
	}
	
	public void onDisable() {
		
	}
	
	public enum Category {
		COMBAT("Combat"),
		MOVEMENT("Movement"),
		PLAYER("Player"),
		RENDER("Render");
		
		public String name;
		
		Category(String name){
			this.name = name;
		}
	}
	
	
	
	
}
