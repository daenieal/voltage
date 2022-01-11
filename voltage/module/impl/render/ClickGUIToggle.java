package voltage.module.impl.render;

import org.lwjgl.input.Keyboard;

import voltage.module.Category;
import voltage.module.Module;
import voltage.ui.Clickgui;

public class ClickGUIToggle extends Module {

	public ClickGUIToggle() {
		super("ClickGUI", "click gui toggle", Category.RENDER, Keyboard.KEY_RSHIFT);
	}
	
	public void onEnable() {
			mc.displayGuiScreen(new Clickgui());
		}
}
