package voltage.module.impl.movement;

import org.lwjgl.input.Keyboard;

import voltage.event.Event;
import voltage.event.impl.update.EventUpdate;
import voltage.module.Category;
import voltage.module.Module;

public class Speed extends Module {

	public Speed() {
		super("Speed", "speederier", Category.MOVEMENT, Keyboard.KEY_NONE);
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(this.enabled) {
				if(mc.thePlayer.onGround) {
					mc.thePlayer.motionX *= 1.2f;
					mc.thePlayer.motionZ *= 1.2f;
				}
			}
		}
	}

}
