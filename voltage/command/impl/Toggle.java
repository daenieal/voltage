package voltage.command.impl;

import voltage.Client;
import voltage.command.Command;
import voltage.event.EventManager;
import voltage.module.Module;

public class Toggle extends Command {

	public Toggle() {
		super("Toggle", "Toggles module by name", "toggle <name>", "t");
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length > 0) {
			String moduleName = args[0];
			
			boolean foundModule = false;
			
			for(Module m : Client.INSTANCE.moduleManager.moduleList) {
				if(m.name.equalsIgnoreCase(moduleName)) {
					m.toggle();
					
					EventManager.addChatMessage((m.isEnabled() ? "Enabled" : "Disabled") + " " + m.name);
					
					foundModule = true;
					break;
				}
			}
			
			if(!foundModule) {
				EventManager.addChatMessage("Could not find module.");
			}
		}
	}

}
