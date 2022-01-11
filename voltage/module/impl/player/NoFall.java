package voltage.module.impl.player;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import voltage.event.Event;
import voltage.event.impl.update.EventUpdate;
import voltage.module.Category;
import voltage.module.Module;

public class NoFall extends Module {

	public NoFall() {
		super("NoFall", "Can't fall", Category.PLAYER, Keyboard.KEY_NONE);
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(mc.thePlayer.fallDistance > 2) {
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
			}
		}
	}
	
}
