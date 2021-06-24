package zeroday.command;

import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.client.Minecraft;
import zeroday.command.inpl.Toggle;
import zeroday.events.EventChat;
import zeroday.ui.ChatWrap;

public class CommandManager {

	public List<mainCommands> commands = new ArrayList<mainCommands>();
	public String prefix = ".";
	
	public void CommandManger() {
		setup();
	}
	
	public void setup() {
		commands.add(new Toggle());
	}
	
	public void handleChat(EventChat event) {
		String message = event.getMessage();
		
		if(!message.startsWith(prefix))
			return;
		
		event.setCancelled(true);
				
		if(message.contains("help")) {
			ChatWrap.addTitle("Help");
			try {
				ChatWrap.addHelpMessage(".help", "Show Help Menu", ".help");
				ChatWrap.addHelpMessage(".fly", "Set Fly Speed", ".fly 20");
				ChatWrap.addHelpMessage(".info", "Grab All Server Infomation", ".info 192.168.1.7");
				ChatWrap.addHelpMessage(".crash", "Crash people running 1.12+", ".crash Notch");
				ChatWrap.addHelpMessage(".rce", "Exeucute Shell Commands via local network", ".rce echo test;");
			} 
			catch (Exception e) {
				  e.printStackTrace();
			}
		}
		
		if(message.contains("players")) {
			try {
				String players = Minecraft.getMinecraft().getCurrentServerData().playerList.strip();
				ChatWrap.addChatMessage(players);
			}
			catch (Exception e) {
				  e.printStackTrace();
			}
		}
	}
	
}
