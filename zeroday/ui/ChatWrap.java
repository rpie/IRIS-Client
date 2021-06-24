package zeroday.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class ChatWrap {	
	
	public static void addChatMessage(String str){
		Minecraft mc = Minecraft.getMinecraft();
		Object chat = new ChatComponentText("§5[ZeroDay]§f " + str);
		if(str != null){
			mc.getMinecraft().ingameGUI.getChatGUI().printChatMessage((IChatComponent)chat);	
		}	
	}
	
	public static void addHelpMessage(String str, String disc, String args){
		Minecraft mc = Minecraft.getMinecraft();
		Object chat = new ChatComponentText("§3" + str + "§5 - §f" + disc + "\n( ex : " + args + ")\n");
		if(str != null){
			mc.getMinecraft().ingameGUI.getChatGUI().printChatMessage((IChatComponent)chat);	
		}	
	}
	
	public static void addTitle(String str){
		Minecraft mc = Minecraft.getMinecraft();
		Object chat = new ChatComponentText("§f=======================§5[" + str + "]§f======================\n");
		if(str != null){
			mc.getMinecraft().ingameGUI.getChatGUI().printChatMessage((IChatComponent)chat);	
		}
	}
}
