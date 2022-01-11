package voltage.module.impl.movement;

import org.lwjgl.input.Keyboard;

import voltage.event.Event;
import voltage.event.impl.update.EventUpdate;
import voltage.module.Category;
import voltage.module.Module;

public class AirWalk extends Module {

	public AirWalk() {
		super("AirWalk", "Player can walk on air", Category.MOVEMENT, Keyboard.KEY_NONE);
	}
	
	public void onDisable() {
		//mc.thePlayer.capabilities.isFlying = false;
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			//mc.thePlayer.capabilities.isFlying = true;
			mc.thePlayer.onGround = true;
			mc.thePlayer.motionY = 0;
		}
	}

}
