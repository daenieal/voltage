package voltage.module.impl.render;

import java.awt.Color;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import voltage.event.Event;
import voltage.event.impl.render.EventRender;
import voltage.module.Category;
import voltage.module.Module;
import voltage.ui.font.FontUtil;

public class TargetHUD extends Module {
	
	public TargetHUD() {
		super("TargetHUD", "Displays current closest target", Category.RENDER, Keyboard.KEY_NONE);
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventRender) {
			if(!mc.gameSettings.showDebugInfo) {
				drawTarget();
			}
		}
	}
	
	public void drawTarget() {
		List<EntityLivingBase> targets = (List) mc.theWorld.loadedEntityList.stream().filter(EntityLivingBase.class::isInstance).collect(Collectors.toList());
		
		targets = targets.stream().filter(entity -> entity.getDistanceToEntity(mc.thePlayer) < 5 && entity != mc.thePlayer).collect(Collectors.toList());
		
		targets.sort(Comparator.comparingDouble(entity -> ((EntityLivingBase)entity).getDistanceToEntity(mc.thePlayer)));
		
		targets = targets.stream().filter(EntityPlayer.class::isInstance).collect(Collectors.toList());
		
		if(!targets.isEmpty()) {
			EntityLivingBase target = targets.get(0);
			Gui.drawRect(40, 40, 120, 100, new Color(1, 1, 1, 150).getRGB());
			FontUtil.normal.drawStringWithShadow(target.getName(), 50, 70, -1);
			FontUtil.normal.drawStringWithShadow("Health: " + target.getHealth(), 50, 60, -1);
			GuiInventory.drawEntityOnScreen(105, 75, 10, 50, 50, target);
		}
	}
}
