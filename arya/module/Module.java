package arya.module;

import arya.Client;
import arya.event.Event;
import net.minecraft.client.Minecraft;

public class Module {
	
	public String name;
	public String description;
	public int keyCode;
	public boolean enabled;
	public Category category;
	public Minecraft mc = Minecraft.getMinecraft();
	
	private int x, y;

	public Module(String name, String description, Category category, int keyCode) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.keyCode = keyCode;
		setup();
	}
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
	
	public void onEvent(Event e) {
		
	}
	
	public void setup() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(int keyCode) {
		this.keyCode = keyCode;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		if(enabled) {
			onEnable();
		} else {
			onDisable();
		}
	}
	
	public void setEnabledSilent(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void toggle() {
		if(enabled) {
			enabled = false;
			onDisable();
		} else {
			enabled = true;
			onEnable();
		}
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
