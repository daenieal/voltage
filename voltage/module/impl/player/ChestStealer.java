package voltage.module.impl.player;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.inventory.ContainerChest;
import voltage.event.Event;
import voltage.event.impl.update.EventUpdate;
import voltage.module.Category;
import voltage.module.Module;
import voltage.util.combat.Timer;

public class ChestStealer extends Module {
	
	public Timer time = new Timer();

	public ChestStealer() {
		super("ChestStealer", "Steals chests", Category.PLAYER, Keyboard.KEY_BACKSLASH);
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if((mc.thePlayer.openContainer != null) && ((mc.thePlayer.openContainer instanceof ContainerChest))) {
				ContainerChest chest = (ContainerChest) mc.thePlayer.openContainer;
				for(int i = 0; i < chest.getLowerChestInventory().getSizeInventory(); i++) {
					if((chest.getLowerChestInventory().getStackInSlot(i) != null) && (time.hasReached(40L))) {
						mc.playerController.windowClick(chest.windowId, i, 0, 1, mc.thePlayer);
						time.resetNano();
					}
				}
				if(chest.getInventory().isEmpty()) {
					mc.displayGuiScreen((GuiScreen)null);
				}
			}
		}
	}

}
