package voltage.module.impl.movement;

import org.lwjgl.input.Keyboard;

import voltage.event.Event;
import voltage.event.impl.update.EventUpdate;
import voltage.module.Category;
import voltage.module.Module;

public class Fly extends Module {

	public Fly() {
		super("Fly", "Makes player fly", Category.MOVEMENT, Keyboard.KEY_NONE);
	}
	
	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			mc.thePlayer.capabilities.isFlying = true;
		}
	}

}
