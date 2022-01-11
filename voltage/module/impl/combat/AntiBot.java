package voltage.module.impl.combat;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.Entity;
import voltage.event.Event;
import voltage.event.impl.update.EventUpdate;
import voltage.module.Category;
import voltage.module.Module;

public class AntiBot extends Module {

	public AntiBot() {
		super("AntiBot", "anti-bottery, doesn't bot you i think", Category.COMBAT, Keyboard.KEY_NONE);
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			for(Object entity : mc.theWorld.loadedEntityList) {
				if(((Entity)entity).isInvisible() && entity != mc.thePlayer) {
					mc.theWorld.removeEntity((Entity)entity);
				}
			}
		}
	}

}
