package voltage.module.impl.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import voltage.event.Event;
import voltage.event.impl.update.EventUpdate;
import voltage.module.Category;
import voltage.module.Module;

public class Step extends Module {

	public Step() {
		super("Step", "strafe in the air i think?", Category.MOVEMENT, Keyboard.KEY_NONE);
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(this.enabled) {
				if((mc.thePlayer.isCollidedHorizontally) && (mc.thePlayer.onGround)) {
					mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition
							(mc.thePlayer.posX, mc.thePlayer.posY+0.42, mc.thePlayer.posZ, mc.thePlayer.onGround));
					mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition
							(mc.thePlayer.posX, mc.thePlayer.posY+0.72, mc.thePlayer.posZ, mc.thePlayer.onGround));
					mc.thePlayer.stepHeight = 1.0f;
				}
			}
	} else {
		mc.thePlayer.stepHeight = 0.5f;
	}
  }

}
