package voltage.module.impl.render;

import org.lwjgl.input.Keyboard;

import voltage.module.Category;
import voltage.module.Module;

public class ItemView extends Module {

	public ItemView() {
		super("ItemView", "View item", Category.RENDER, Keyboard.KEY_NONE);
	}
	
	public void onEnable() {
		super.onEnable();
	}

}
