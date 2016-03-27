package ua.pp.shurgent.tfctech.items.pottery;

import net.minecraft.client.renderer.texture.IIconRegister;
import ua.pp.shurgent.tfctech.core.ModDetails;

import com.bioxx.tfc.Items.Pottery.ItemPotteryBase;

public class ItemModPotteryBase extends ItemPotteryBase {

	@Override
	public void registerIcons(IIconRegister registerer)
	{
		this.clayIcon = registerer.registerIcon(ModDetails.ModID + ":" + textureFolder + metaNames[0]);
		this.ceramicIcon = registerer.registerIcon(ModDetails.ModID + ":" + textureFolder + metaNames[1]);
	}


}
