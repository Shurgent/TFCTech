package ua.pp.shurgent.tfctech.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import ua.pp.shurgent.tfctech.core.ModDetails;

import com.bioxx.tfc.Items.ItemMeltedMetal;

public class ItemModMeltedMetal extends ItemMeltedMetal {

	@Override
	public void registerIcons(IIconRegister registerer) {
		this.itemIcon = registerer.registerIcon(ModDetails.ModID + ":" + textureFolder + this.getUnlocalizedName().replace("item.", ""));
	}
	
}
