package ua.pp.shurgent.tfctech.containerslots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.bioxx.tfc.Items.ItemMeltedMetal;
import com.bioxx.tfc.api.TFCItems;

public class SlotMolds extends Slot {
	
	public SlotMolds(IInventory iinventory, int i, int j, int k) {
		super(iinventory, i, j, k);
	}
	
	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return itemstack.getItem() instanceof ItemMeltedMetal && itemstack.getItemDamage() > 1 ||
				itemstack.getItem() == TFCItems.ceramicMold	&& itemstack.getItemDamage() == 1;
	}
	
	@Override
	public int getSlotStackLimit() {
		return 64;
	}
}
