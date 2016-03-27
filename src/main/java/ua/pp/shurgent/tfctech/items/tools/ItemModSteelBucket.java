package ua.pp.shurgent.tfctech.items.tools;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import ua.pp.shurgent.tfctech.core.ModDetails;

import com.bioxx.tfc.Items.Tools.ItemSteelBucket;

public class ItemModSteelBucket extends ItemSteelBucket {
	public ItemModSteelBucket(Block liquid) {
		super(liquid);
		
	}

	@Override
	public void registerIcons(IIconRegister registerer) {
		if (this.iconString != null)
			this.itemIcon = registerer.registerIcon(ModDetails.ModID + ":" + this.textureFolder + this.getIconString());
		else
			this.itemIcon = registerer.registerIcon(ModDetails.ModID + ":" + this.textureFolder + this.getUnlocalizedName().replace("item.", ""));
	}
}
