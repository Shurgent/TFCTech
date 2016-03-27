package ua.pp.shurgent.tfctech.items.ItemBlocks;

import net.minecraft.block.Block;
import ua.pp.shurgent.tfctech.Globals;

import com.bioxx.tfc.Items.ItemBlocks.ItemTerraBlock;

public class ItemModCustomWood extends ItemTerraBlock {

	public ItemModCustomWood(Block b) {
		super(b);
		int size = Globals.WOOD_ALL.length;
		metaNames = new String[size];
		System.arraycopy(Globals.WOOD_ALL, 0, metaNames, 0, size);
	}

}
