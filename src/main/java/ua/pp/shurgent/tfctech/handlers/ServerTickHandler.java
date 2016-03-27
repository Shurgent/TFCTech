package ua.pp.shurgent.tfctech.handlers;

import ua.pp.shurgent.tfctech.core.ModRecipes;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.WorldTickEvent;

public class ServerTickHandler 
{
    @SubscribeEvent 
    public void onServerWorldTick(WorldTickEvent e) 
    { 
        if (e.phase == Phase.START) 
        { 
        	if (e.world.provider.dimensionId == 0)
        		ModRecipes.initialiseAnvil(); 
        } 
		else if(e.phase == Phase.END)
		{

		}
    } 
}
