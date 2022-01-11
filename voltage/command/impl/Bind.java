package voltage.command.impl;

import org.lwjgl.input.Keyboard;

import voltage.Client;
import voltage.command.Command;
import voltage.event.EventManager;
import voltage.module.Module;

public class Bind extends Command {

	public Bind() {
		super("Bind", "Binds module by name", "bind <name> <key> | clear", "b");
	}

	
	Module m;
	@Override
	public void onCommand(String[] args, String command) {
		if(args.length == 2) {
			String moduleName = args[0];
			String keyName = args[1];
			
			boolean foundModule = false;
			
			for(Module m : Client.INSTANCE.moduleManager.moduleList) {
				if(m.name.equalsIgnoreCase(moduleName) || !m.getName().equals("ClickGUI")) {
					m.setKeyCode(Keyboard.getKeyIndex(keyName.toUpperCase()));
					EventManager.addChatMessage(String.format("Bound %s to %s", m.name, Keyboard.getKeyName(m.getKeyCode())));
					foundModule = true;
					break;
				}
			}
			
			if(!foundModule) {
				EventManager.addChatMessage("Could not find module.");
			}
		}
		
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("clear")) {
				for(Module m : Client.INSTANCE.moduleManager.moduleList) {
					if(m.getName().equals("ClickGUIToggle")) {
						m.setKeyCode(Keyboard.KEY_NONE);
					}
				}
			}
			
			EventManager.addChatMessage("Cleared all binds.");
		}
	}

}
