package voltage.module.impl.movement;

import org.lwjgl.input.Keyboard;

import voltage.event.Event;
import voltage.event.impl.update.EventMotion;
import voltage.module.Category;
import voltage.module.Module;

public class AirJump extends Module {

	public AirJump() {
		super("AirJump", "AirJump", Category.MOVEMENT, Keyboard.KEY_NONE);
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventMotion) {
			if(!mc.thePlayer.onGround) {
				
			}
		}
	}

}
