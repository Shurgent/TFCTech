package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.handlers;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import ua.pp.shurgent.tfctech.Globals;
import buildcraft.transport.TravelingItem;
import buildcraft.transport.TravelingItem.InsertionHandler;

import com.bioxx.tfc.Containers.ContainerBarrel;
import com.bioxx.tfc.Containers.ContainerChestTFC;
import com.bioxx.tfc.Containers.Slots.SlotChest;
import com.bioxx.tfc.Items.ItemLogs;
import com.bioxx.tfc.TileEntities.TEBarrel;
import com.bioxx.tfc.TileEntities.TEChest;

public class PipeItemsInsertionHandler extends InsertionHandler {

	public static final PipeItemsInsertionHandler INSTANCE = new PipeItemsInsertionHandler();

	@Override
	public boolean canInsertItem(TravelingItem item, IInventory inv) {
		ItemStack is = item.getItemStack();

		if (inv instanceof TEChest || inv instanceof TEBarrel) {
			if (is.getItem() instanceof ItemLogs)
				return false;
			
			SlotChest testSlot = new SlotChest(inv, 0, 0, 0);
			
			if (inv instanceof TEChest)
				testSlot.addItemException(ContainerChestTFC.getExceptions());
			if (inv instanceof TEBarrel)
				testSlot.addItemException(ContainerBarrel.getExceptions());
			
			testSlot.addItemException(Globals.INGOTS);
			
			return testSlot.isItemValid(is);
		}

		return true;
	}

}
