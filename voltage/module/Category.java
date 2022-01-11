package voltage.module;

public enum Category {
	
	COMBAT("Combat", 40, 50, false, true), 
	MOVEMENT("Movement", 160, 50, false, true),
	PLAYER("Player", 280, 50, false, true),
	WORLD("World", 400, 50, false, true), 
	RENDER("Render", 40, 120, false, true), 
	OTHER("Other", 200, 120, false, true);
	
	public String name;
	public int posX, posY;
	public boolean mouseClicked;
	public boolean showModules;
	
	Category(String name, int posX, int posY, boolean mouseClicked, boolean showModules) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.mouseClicked = mouseClicked;
		this.showModules = showModules;
	}

}
