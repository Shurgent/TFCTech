package ua.pp.shurgent.tfctech.items;

import com.bioxx.tfc.Core.TFCTabs;
import com.bioxx.tfc.api.Enums.EnumSize;

public class ItemNugget extends ItemModMetalItem {

	public ItemNugget(String m, int amt) {
		super(m, amt, "nuggets");
		setCreativeTab(TFCTabs.TFC_MATERIALS);
		setSize(EnumSize.TINY);
		this.setMetal(m, amt);
	}
	
}
