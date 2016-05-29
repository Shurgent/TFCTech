package ua.pp.shurgent.tfctech.handlers;

import java.util.Random;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.core.ModOptions;
import ua.pp.shurgent.tfctech.core.ModUtils;

import com.bioxx.tfc.Blocks.Terrain.BlockIgEx;
import com.bioxx.tfc.Blocks.Terrain.BlockIgIn;
import com.bioxx.tfc.Blocks.Terrain.BlockMM;
import com.bioxx.tfc.Blocks.Terrain.BlockSed;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class TFCTechEventListener {
	
	public static boolean triedToWarnPlayer = false;
	
	@SubscribeEvent
	public void onTick(TickEvent.ClientTickEvent event) {
		
		if (triedToWarnPlayer) {
			return;
		}
		
		if (ModOptions.cfgCheckUpdates && event.phase == TickEvent.Phase.END) {
			
			triedToWarnPlayer = true;
			
			TFCTech.singleThreadExecutor.execute(new Runnable() {
				
				@Override
				public void run() {
					
					int tries = 0;
					EntityClientPlayerMP pe;
					do {
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							return;
						}
						
						pe = FMLClientHandler.instance().getClientPlayerEntity();
						++tries;
						
					} while (pe == null && tries <= 60);
					
					if (tries > 60) {
						return;
					}
					
					assert pe != null;
					
					ModUtils.checkUpdate((EntityPlayer) pe);
					
				}
			});
		}
		
	}
	
	@SubscribeEvent
	public void onHarvestDropsEvent(HarvestDropsEvent event) {
		
		handleQuartzDrops(event);
		
	}
	
	@SubscribeEvent
	public void onBreakEvent(BreakEvent event) {
		
		handleQuartzDrops(event);
		
	}
	
	private void handleQuartzDrops(BlockEvent event) {
		
		if (ModOptions.cfgDropQuartz) {
			
			Random rnd = event.world.rand;
			int minQty = ModOptions.cfgDropQuartzMinQty;
			int maxQty = ModOptions.cfgDropQuartzMaxQty;
			
			final int HARVEST = 1;
			final int BREAK = 2;
			
			int eventType = event instanceof HarvestDropsEvent ? HARVEST : event instanceof BreakEvent ? BREAK : 0;
			
			ItemStack is = null;
			
			if (event.block instanceof BlockIgEx) {
				if (rnd.nextInt(ModOptions.cfgDropQuartzIgExChance) == 0) {
					is = new ItemStack(ModItems.gemQuartz, minQty + rnd.nextInt(maxQty));
				}
			}
			
			if (event.block instanceof BlockIgIn) {
				if (rnd.nextInt(ModOptions.cfgDropQuartzIgInChance) == 0) {
					is = new ItemStack(ModItems.gemQuartz, minQty + rnd.nextInt(maxQty));
				}
			}
			
			if (event.block instanceof BlockMM) {
				if (rnd.nextInt(ModOptions.cfgDropQuartzMMChance) == 0) {
					is = new ItemStack(ModItems.gemQuartz, minQty + rnd.nextInt(maxQty));
				}
			}
			
			if (event.block instanceof BlockSed) {
				if (rnd.nextInt(ModOptions.cfgDropQuartzSedChance) == 0) {
					is = new ItemStack(ModItems.gemQuartz, minQty + rnd.nextInt(maxQty));
				}
			}
			
			if (is != null)
				switch (eventType) {
				case HARVEST:
					HarvestDropsEvent eh = (HarvestDropsEvent) event;
					eh.drops.add(is);
					break;
				case BREAK:
					BreakEvent eb = (BreakEvent) event;
					EntityItem ei = new EntityItem(eb.world, eb.x + 0.5, eb.y + 0.5, eb.z + 0.5, is);
					ei.motionX = 0;
					ei.motionY = 0;
					ei.motionZ = 0;
					eb.world.spawnEntityInWorld(ei);
					break;
				default:
				}
		}
		
	}
	
}
