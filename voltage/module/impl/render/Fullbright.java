package voltage.module.impl.render;

import org.lwjgl.input.Keyboard;

import voltage.module.Category;
import voltage.module.Module;

public class Fullbright extends Module {

	public Fullbright() {
		super("Fullbright", "Everything is fully brightened", Category.RENDER, Keyboard.KEY_NONE);
	}
	
	public void onEnable() {
		mc.gameSettings.gammaSetting = 100;
	}
	
	public void onDisable() {
		mc.gameSettings.gammaSetting = 1;
	}

}
