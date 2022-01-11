package voltage;

import org.lwjgl.opengl.Display;

import net.minecraft.client.Minecraft;
import voltage.alt.AltManager;
import voltage.command.CommandManager;
import voltage.module.ModuleManager;
import voltage.module.impl.render.ClickGUIToggle;
import voltage.ui.font.FontUtil;
import voltage.util.SessionChanger;

public class Client {

	private Minecraft mc = Minecraft.getMinecraft();
	public static Client INSTANCE = new Client();
	public static String name = "voltage", version = "v1", fullname = name + " " + version;
	public ModuleManager moduleManager;
	public AltManager altManager;
	public CommandManager commandManager = new CommandManager();
	public ClickGUIToggle clickGUI;
	
	public void start() {
		altManager = new AltManager();
		moduleManager = new ModuleManager();
		FontUtil.bootstrap();
		SessionChanger.getInstance().setUserOffline("time");
		Display.setTitle(fullname + " | Minecraft 1.8.9");
	}
	
	public void shutdown() {
		
	}
}
