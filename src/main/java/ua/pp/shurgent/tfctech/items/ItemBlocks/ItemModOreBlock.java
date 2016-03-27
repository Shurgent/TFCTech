package ua.pp.shurgent.tfctech.items.ItemBlocks;

import net.minecraft.block.Block;
import ua.pp.shurgent.tfctech.Globals;

import com.bioxx.tfc.Items.ItemBlocks.ItemTerraBlock;

public class ItemModOreBlock extends ItemTerraBlock {

	public ItemModOreBlock(Block b) {
		super(b);
		metaNames = Globals.ORE_METAL;
	}

}
