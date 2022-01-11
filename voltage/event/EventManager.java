package voltage.event;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import voltage.Client;
import voltage.event.impl.command.EventChat;
import voltage.event.impl.key.EventKey;
import voltage.module.Module;

public class EventManager {
	
	public static void onEvent(Event e) {
		if(e instanceof EventChat) {
			Client.INSTANCE.commandManager.handleChat((EventChat)e);
		}
		
		for(Module m : Client.INSTANCE.moduleManager.getModuleList()) {
			if(e instanceof EventKey) {
				EventKey eventKey = (EventKey) e;
				if(m.getKeyCode() == eventKey.getKeyCode()) {
					m.toggle();
				}
			}
			if(m.isEnabled()) {
				m.onEvent(e);
			}
		}
	}
	
	public static void addChatMessage(String message) {
		message = "\u00A72" + Client.name + ":\u00A7a " + message;
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(message));
	}

}
