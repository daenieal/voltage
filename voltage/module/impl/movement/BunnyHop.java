package voltage.module.impl.movement;

import org.lwjgl.input.Keyboard;

import voltage.event.Event;
import voltage.event.impl.update.EventUpdate;
import voltage.module.Category;
import voltage.module.Module;

public class BunnyHop extends Module {

	public BunnyHop() {
		super("Bhop", "bunny hop", Category.MOVEMENT, Keyboard.KEY_NONE);
	}
	
	public void onDisable() {
		mc.gameSettings.keyBindJump.pressed = false;
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(this.enabled) {
				mc.gameSettings.keyBindJump.pressed = false;
			}
		}
	}
}
