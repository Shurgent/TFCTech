package ua.pp.shurgent.tfctech.items;

import com.bioxx.tfc.Core.TFCTabs;

public class ItemDust extends ItemModMetalItem {

	public ItemDust(String m, int amt) {
		super(m, amt, "dust");
		setCreativeTab(TFCTabs.TFC_MATERIALS);
	}
	
}
