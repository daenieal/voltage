package voltage.module.impl.movement;

import org.lwjgl.input.Keyboard;

import voltage.event.Event;
import voltage.event.impl.update.EventUpdate;
import voltage.module.Category;
import voltage.module.Module;

public class Sprint extends Module {
	
	public Sprint() {
		super("Sprint", "Makes you automatically sprint", Category.MOVEMENT, Keyboard.KEY_LMENU);
	}
	
	public void onDisable() {
		mc.thePlayer.setSprinting(mc.gameSettings.keyBindSprint.isPressed());
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(mc.thePlayer.moveForward > 0 && !mc.thePlayer.isUsingItem() && !mc.thePlayer.isSneaking()
					&& !mc.thePlayer.isCollidedHorizontally) {
				mc.thePlayer.setSprinting(true);
			}
		}
	}
}
