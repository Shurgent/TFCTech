package ua.pp.shurgent.tfctech.blocks.flora;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import ua.pp.shurgent.tfctech.Globals;
import ua.pp.shurgent.tfctech.core.ModDetails;

import com.bioxx.tfc.Items.ItemBlocks.ItemTerraBlock;
import com.bioxx.tfc.api.Enums.EnumWeight;

public class ItemModSapling extends ItemTerraBlock {

	public ItemModSapling(Block b) {
		super(b);
		int size = Globals.WOOD_ALL.length;
		this.metaNames = new String[size];
		System.arraycopy(Globals.WOOD_ALL, 0, this.metaNames, 0, size);
		this.icons = new IIcon[size];
	}

	@Override
	public IIcon getIconFromDamage(int index) {
		return icons[index];
	}

	@Override
	public void registerIcons(IIconRegister registerer) {
		for (int i = 0; i < this.metaNames.length; i++)
			icons[i] = registerer.registerIcon(ModDetails.ModID + ":" + "wood/trees/" + this.metaNames[i] + " Sapling");
	}

	@Override
	public EnumWeight getWeight(ItemStack is) {
		return EnumWeight.MEDIUM;
	}
}
