package zeroday.command.inpl;

import zeroday.mainClient;
import zeroday.command.mainCommands;
import zeroday.modules.mainModule;
import zeroday.ui.ChatWrap;

public class Toggle extends mainCommands {

	public Toggle() {
		super("Toggle", "Toggle a module by name", "toggle <name>", "t");
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length > 0) {
			String moduleName = args[0];
			
			boolean foundModule = false;
			
			for(mainModule module : mainClient.modules) {
				if(module.name.equalsIgnoreCase(moduleName)) {
					module.toggle();
					
					ChatWrap.addChatMessage((module.isEnabled() ? "Enabled" : "Disabled") + " " + module.name);
					
					foundModule = true;
					break;
				}
			}
			
			if(!foundModule) {
				ChatWrap.addChatMessage("Command not found!");
			}
			
		}
		
	}
	
}
