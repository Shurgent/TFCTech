package ua.pp.shurgent.tfctech.items;

import com.bioxx.tfc.Core.TFCTabs;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;

public class ItemModMetalSheet extends ItemModMetalItem {
	
	public ItemModMetalSheet(String metal, int amt) {
		super(metal, amt, "ingots");
		this.setCreativeTab(TFCTabs.TFC_MATERIALS);
		this.setWeight(EnumWeight.MEDIUM);
		this.setSize(EnumSize.MEDIUM);
	}
	
	public ItemModMetalSheet(String metal) {
		this(metal, 200);
	}
	
}
