package ua.pp.shurgent.tfctech.handlers;

import ua.pp.shurgent.tfctech.items.tools.ItemTFCTechForgedItem;

import com.bioxx.tfc.TileEntities.TEAnvil;
import com.bioxx.tfc.api.Crafting.AnvilManager;
import com.bioxx.tfc.api.Events.AnvilCraftEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class AnvilCraftingHandler {
	
	@SubscribeEvent
	public void onAnvilCrafting(AnvilCraftEvent e) {
		
		if (e.result == null)
			return;
		
		if (e.result.getItem() instanceof ItemTFCTechForgedItem) {
			TEAnvil anvil = (TEAnvil) e.anvilTE;
			AnvilManager.setDurabilityBuff(e.result, anvil.workRecipe.getSkillMult(anvil.lastWorker));
		}
		
	}
	
}
