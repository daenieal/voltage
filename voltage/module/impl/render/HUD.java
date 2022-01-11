package voltage.module.impl.render;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import voltage.Client;
import voltage.event.Event;
import voltage.event.impl.render.EventRender;
import voltage.module.Category;
import voltage.module.Module;
import voltage.ui.animations.Animations;
import voltage.ui.font.FontUtil;
import voltage.util.combat.Timer;
import voltage.util.render.ColourUtil;
import voltage.util.render.RenderUtils;

public class HUD extends Module {
	
	private Timer timer = new Timer();
	private FontRenderer fr = mc.fontRendererObj;

	public HUD() {
		super("HUD", "hud render", Category.RENDER, Keyboard.KEY_NONE);
		enabled = true;
	}
	
	private final SimpleDateFormat currentTime = new SimpleDateFormat("hh:mm aa");
	
	public void onEvent(Event e) {
		if(e instanceof EventRender) {
			if(!mc.gameSettings.showDebugInfo) {
				displayInfo();
			}
		}
	}
	
	public void displayInfo() {
		int count = 0;
		ScaledResolution sr = new ScaledResolution(mc);
		Gui.drawRect(4, 2, (int) (FontUtil.normal.getStringWidth
				(Client.fullname + " | " + Minecraft.getDebugFPS() + " FPS" + " | " + " | " + mc.getSession().getUsername() + 1)), 15, new Color(40, 46, 46).getRGB());
		Gui.drawHorizontalLine(5, (int) (FontUtil.normal.getStringWidth
				(Client.fullname + " | " + Minecraft.getDebugFPS() + " FPS" + " | " + " | " + mc.getSession().getUsername())) + 1, 3, ColourUtil.getRainbow(4, 0.8f, 1, count * 1000));
		FontUtil.normal.drawSmoothString(Client.fullname + " | " + Minecraft.getDebugFPS() + " FPS" + " | " + mc.getSession().getUsername(), 7, 5, -1);
		int posY = 8;
		
		ArrayList<Module> enabledModules = new ArrayList<>();
		
		for(Module m : Client.INSTANCE.moduleManager.getModuleList()) {
			if(m.isEnabled() && !m.getName().equals("ClickGUI")) {
				enabledModules.add(m);
				enabledModules.sort((m1, m2) -> FontUtil.normal.getStringWidth(m2.getName()) - FontUtil.normal.getStringWidth(m1.getName()));
			}
		}
		
		for(Module m : enabledModules) {
			if(m.isEnabled()) {
				FontUtil.normal.drawStringWithShadow(m.name, sr.getScaledWidth() - FontUtil.normal.getStringWidth(m.getName()) - 8, 
						posY, ColourUtil.getRainbow(4, 0.8f, 1, count * 150));
				posY += 10;
				count++;
			}
		}
	}
}
