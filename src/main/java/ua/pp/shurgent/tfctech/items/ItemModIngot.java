package ua.pp.shurgent.tfctech.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import ua.pp.shurgent.tfctech.core.ModDetails;

import com.bioxx.tfc.Items.ItemIngot;
import com.bioxx.tfc.api.Enums.EnumSize;

public class ItemModIngot extends ItemIngot {

	public ItemModIngot(String m, int amt) {
		super();
		this.setMetal(m, amt);
		if (amt > 100) {
			this.setSize(EnumSize.LARGE);
		}
	}

	@Override
	public void registerIcons(IIconRegister registerer) {
		this.itemIcon = registerer.registerIcon(ModDetails.ModID + ":" + textureFolder + this.getUnlocalizedName().replace("item.", ""));
	}

}
