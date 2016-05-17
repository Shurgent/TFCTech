package ua.pp.shurgent.tfctech.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import buildcraft.BuildCraftCore;

import com.bioxx.tfc.api.TFCItems;

import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class CraftingHandlerBC {

	public static void OnCraftingBC(ItemCraftedEvent e) {
		EntityPlayer player = e.player;
		ItemStack itemstack = e.crafting;
		Item item = itemstack.getItem();
		IInventory inventory = e.craftMatrix;
		
		if (item == BuildCraftCore.paintbrushItem) {
			CraftingHandler.handleItem(player, inventory, new Item[] {
				TFCItems.shears
			});
		}
	}
	
}
