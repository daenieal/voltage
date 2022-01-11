package voltage.module;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import voltage.Client;
import voltage.module.impl.combat.*;
import voltage.module.impl.movement.*;
import voltage.module.impl.player.*;
import voltage.module.impl.render.*;

public class ModuleManager {
	
	public static ArrayList<Module> moduleList;
	
	public ModuleManager() {
		moduleList = new ArrayList<>();

		moduleList.add(new Sprint());
		moduleList.add(new AirWalk());
		moduleList.add(new Fly());
		moduleList.add(new NoFall());
		moduleList.add(new Fullbright());
		moduleList.add(new Step());
		moduleList.add(new AntiBot());
		moduleList.add(new KillAura());
		moduleList.add(new ChestStealer());
		moduleList.add(new HUD());
		moduleList.add(new TargetHUD());
		moduleList.add(Client.INSTANCE.clickGUI = new ClickGUIToggle());
	}

	public ArrayList<Module> getModuleList() {
		return moduleList;
	}

	public void setModuleList(ArrayList<Module> moduleList) {
		this.moduleList = moduleList;
	}
	
	public Module getModule(Class<? extends Module> get) {
		for (Module m : getModuleList()) {
			if (m.getClass() == get) {
				return m;
			}
		}
		return null;
	}


}
