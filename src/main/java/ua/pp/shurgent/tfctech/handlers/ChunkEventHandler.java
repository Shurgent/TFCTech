package ua.pp.shurgent.tfctech.handlers;

import net.minecraftforge.event.world.WorldEvent;
import ua.pp.shurgent.tfctech.core.ModRecipes;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ChunkEventHandler {
	
	@SubscribeEvent
	public void onLoadWorld(WorldEvent.Load e) {
		if (!e.world.isRemote && e.world.provider.dimensionId == 0 && !ModRecipes.areAnvilRecipesInitialised()) {
			ModRecipes.initialiseAnvil(e.world);
		}
	}

	@SubscribeEvent
	public void onUnloadWorld(WorldEvent.Unload e) {

	}

}
