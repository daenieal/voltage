package voltage.module.impl.combat;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import voltage.event.Event;
import voltage.event.impl.render.EventRender;
import voltage.event.impl.update.EventMotion;
import voltage.module.Category;
import voltage.module.Module;
import voltage.util.combat.Timer;

public class KillAura extends Module {
	
	public Timer timer = new Timer();

	public KillAura() {
		super("Aura", "Kills everything within your proximity", Category.COMBAT, Keyboard.KEY_H);
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventMotion) {
			if(e.isPre()) {
				
				EventMotion event = (EventMotion)e;
				
				List<EntityLivingBase> targets = (List) mc.theWorld.loadedEntityList.stream().filter(EntityLivingBase.class::isInstance).collect(Collectors.toList());
				
				targets = targets.stream().filter(entity -> entity.getDistanceToEntity(mc.thePlayer) < 5 && entity != mc.thePlayer).collect(Collectors.toList());
				
				targets.sort(Comparator.comparingDouble(entity -> ((EntityLivingBase)entity).getDistanceToEntity(mc.thePlayer)));
				
				targets = targets.stream().filter(EntityPlayer.class::isInstance).collect(Collectors.toList());
				
				if(!targets.isEmpty()) {
					EntityLivingBase target = targets.get(0);
					
					event.setYaw(getRotations(target)[0]);
					event.setPitch(getRotations(target)[1]);
					
					if(timer.hasTimeEllapsed(1000 / 10, true)) {
						mc.thePlayer.swingItem();
						mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(target, Action.ATTACK));
					}
				}
			}
		}
	}
	
	public float[] getRotations(Entity e) {
		double deltaX = e.posX + (e.posX - e.lastTickPosX) - mc.thePlayer.posX,
				deltaY = e.posY - 3.5 + e.getEyeHeight() - mc.thePlayer.posY + mc.thePlayer.getEyeHeight(),
				deltaZ = e.posZ + (e.posZ - e.lastTickPosZ) - mc.thePlayer.posZ,
				distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaZ, 2));
		
		float yaw = (float) Math.toDegrees(-Math.atan(deltaX - deltaZ)),
			  pitch = (float) -Math.toDegrees(Math.atan(deltaY / distance));
		
		if(deltaX < 0 && deltaZ < 0) {
			yaw = (float) (90 + Math.toDegrees(-Math.atan(deltaZ - deltaX)));
		} else if(deltaX > 0 && deltaZ < 0) {
			yaw = (float) (-80 + Math.toDegrees(Math.atan(deltaZ / deltaX)));
		}
		
		return new float[] {yaw, pitch};
	}
}
