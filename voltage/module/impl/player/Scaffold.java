package voltage.module.impl.player;

import java.lang.reflect.Field;
import java.util.concurrent.Delayed;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.BlockAir;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import voltage.event.Event;
import voltage.event.impl.update.EventMotion;
import voltage.module.Category;
import voltage.module.Module;
import voltage.util.combat.Timer;
import voltage.util.player.BlockUtil;

public class Scaffold extends Module {

//	private BlockPos currentPos;
//	private EnumFacing currentFacing;
//	private boolean rotated = false;
//	private Timer timer = new Timer();
////	private Value<Integer> delay = new Value<>("Delay", 0);
////	private Value<Boolean> eagle = new Value<>("Eagle", true);
//	
	public Scaffold() {
		super("Scaffold", "atuomatically place blocks", Category.PLAYER, Keyboard.KEY_B);
	}
//	
//	
//	private void setSneaking(boolean b) {
//		KeyBinding sneakBinding = mc.gameSettings.keyBindSneak;
//		try {
//			Field field = sneakBinding.getClass().getDeclaredField("pressed");
//			field.setAccessible(true);
//			field.setBoolean(sneakBinding, b);	
//		} catch(NoSuchFieldException | IllegalAccessException e) { 
//			e.printStackTrace();
//		}
//	}
//	
//	@Override
//	public void onDisable() {
//		setSneaking(false);
//	}
//	
//	public void onEvent(Event e) {
//		if(e instanceof EventMotion) {
//			EventMotion event = (EventMotion)e;
//			
//			
//			
//			if(e.isPre()) {
//				rotated = false;
//				currentPos = null;
//				currentFacing = null;
//				
//				BlockPos pos = new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 1.0D, mc.thePlayer.posZ);
//				if(mc.theWorld.getBlockState(pos).getBlock() instanceof BlockAir) {
//					setBlockAndFacing(pos);
//					
//					if(currentPos != null) {
//						float facing[] = BlockUtil.getDirectionToBlock(currentPos.getX(), currentPos.getY(), currentPos.getZ(), currentFacing),
//								
//							  yaw = facing[0],
//							  pitch = Math.min(90, facing[1] + 10);
//						
//						rotated = true;
//						mc.thePlayer.rotationYaw = (yaw);
//						mc.thePlayer.rotationPitch = (pitch);
//					}
//				}
//			}
//			
//			if(e.isPost()) {
//				if(currentPos != null) {
//					if(timer.hasTimeReached(1000 / 1000)) {
//						if(mc.thePlayer.getCurrentEquippedItem() != null && mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemBlock) {
//							if(mc.playerController.onPlayerRightClick(mc.thePlayer, mc.theWorld, mc.thePlayer.getCurrentEquippedItem(), currentPos, currentFacing, new Vec3(currentPos.getX(), currentPos.getY(), currentPos.getZ()))) {
//								timer.setLastMS();
//								mc.thePlayer.swingItem();
//							}
//						}
//					}
//				}
//			}
//		}
//	}
//	
//	private void setBlockAndFacing(BlockPos var1) {
//		if(mc.theWorld.getBlockState(var1.add(0, -1, 0)).getBlock() != Blocks.air) {
//			this.currentPos = var1.add(0, -1, 0);
//			currentFacing = EnumFacing.UP;
//		} else if(mc.theWorld.getBlockState(var1.add(-1, 0, 0)).getBlock() != Blocks.air) {
//			this.currentPos = var1.add(-1, 0, 0);
//			currentFacing = EnumFacing.EAST;
//		} else if(mc.theWorld.getBlockState(var1.add(1, 0, 0)).getBlock() != Blocks.air) {
//			this.currentPos = var1.add(1, 0, 0);
//			currentFacing = EnumFacing.WEST;
//		} else if(mc.theWorld.getBlockState(var1.add(0, 0, -1)).getBlock() != Blocks.air) {
//			this.currentPos = var1.add(0, 0, -1);
//			currentFacing = EnumFacing.SOUTH;
//		} else if(mc.theWorld.getBlockState(var1.add(0, 0, 1)).getBlock() != Blocks.air) {
//			this.currentPos = var1.add(0, 0, 1);
//			currentFacing = EnumFacing.NORTH;
//		} else {
//			currentPos = null;
//			currentFacing = null;
//		}
//	}
	
	
	
}
