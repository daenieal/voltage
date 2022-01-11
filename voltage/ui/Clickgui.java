package voltage.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import voltage.Client;
import voltage.module.Category;
import voltage.module.Module;
import voltage.ui.font.FontUtil;
import voltage.ui.font.MinecraftFontRenderer;
	
public class Clickgui extends GuiScreen {
		
	private int oldPosX, oldPosY;
	
	
	private long getTime() {
		return System.currentTimeMillis();
	}
		
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	    MinecraftFontRenderer font = FontUtil.normal;
	    
	    for(Category category : Category.values()) {
	    	if(category.mouseClicked) {
	    		category.posX += mouseX - oldPosX;
	    		category.posY += mouseY - oldPosY;
	    	}
	    		
	    		font.drawStringWithShadow(category.name, category.posX, category.posY, -1);
	    		Gui.drawRect(123, 123, 123, 123, -1);
	    		
	    		int posX = category.posX;
	    		int posY = category.posY + 15;
	    		for(Module m : Client.INSTANCE.moduleManager.moduleList) {
	    			if(m.getCategory() == category) {
	    				font.drawStringWithShadow(m.getName(), posX, posY, m.isEnabled() ? new Color(16, 199, 40).getRGB() : -1);
	    				GuiIngame.drawRect(10, 10, 10, 10, -1);
	    				posY += 12;
	    			}
	    		}
	    	}
	    	
	    	oldPosX = mouseX;
	    	oldPosY = mouseY;
		}
	    
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		MinecraftFontRenderer font = FontUtil.normal;
		for(Category category : Category.values()) {
			if(mouseX >= category.posX && mouseX <= category.posX + font.getStringWidth(category.name) && mouseY >= category.posY && mouseY <= category.posY + 10) {
				if(mouseButton == 0) {
					category.mouseClicked = true;
				}
			}
	    		
			int posX = category.posX;
			int posY = category.posY + 15;
			for(Module m : Client.INSTANCE.moduleManager.moduleList) {
				if(m.getCategory() == category) {
					if(mouseX >= posX && mouseX <= posX + font.getStringWidth(m.getName()) && mouseY >= posY && mouseY <= posY + 9) {
						if(mouseButton == 0) {
							m.toggle();
						}
					}
	    				
					posY += 12;
				}
			}
		}
	}
	    
	protected void keyTyped(char typedChar, int keyCode) throws IOException{ 
		if (keyCode == 1) {
			this.mc.displayGuiScreen((GuiScreen)null);
	            
			Client.INSTANCE.clickGUI.setEnabled(false);
	            
			if(this.mc.currentScreen == null) {
				this.mc.setIngameFocus();
			}
		}
	}
	    
	protected void mouseReleased(int mouseX, int mouseY, int state) {
	    for(Category category : Category.values()) {
	    	category.mouseClicked = false;
	    }
	}
	    
	public boolean doesGuiPauseGame() {
	    return false;
	}
		
}
