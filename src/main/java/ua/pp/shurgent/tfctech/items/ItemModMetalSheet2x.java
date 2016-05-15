package ua.pp.shurgent.tfctech.items;

import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;

public class ItemModMetalSheet2x extends ItemModMetalSheet {
	
	public ItemModMetalSheet2x(String metal) {
		super(metal, 400);
		this.setWeight(EnumWeight.HEAVY);
		this.setSize(EnumSize.MEDIUM);
	}
	
}
