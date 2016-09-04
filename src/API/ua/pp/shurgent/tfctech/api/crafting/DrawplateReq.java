package ua.pp.shurgent.tfctech.api.crafting;

import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.items.tools.ItemDrawplate;

public enum DrawplateReq {
	
	WROUGHTIRON("Wrought Iron", 3),
	STEEL("Steel", 4),
	BLACKSTEEL("Black Steel", 5);
	
	public static final DrawplateReq RULES[] = new DrawplateReq[] {
			WROUGHTIRON,
			STEEL,
			BLACKSTEEL
	};
	public final int Tier;
	public final String Name;
	
	private DrawplateReq(String n, int tier) {
		Name = n;
		Tier = tier;
	}
	
	public boolean matches(int tier) {
		return tier >= Tier;
	}
	
	public boolean matches(DrawplateReq req) {
		return req.Tier >= Tier;
	}
	
	public boolean matches(ItemDrawplate drawplate) {
		return matches(getReqFromItem(drawplate));
	}
	
	public static boolean matches(int i, int j) {
		return j >= i;
	}
	
	public static DrawplateReq getReqFromInt(int i) {
		switch (i) {
		case 3:
			return WROUGHTIRON;
		case 4:
			return STEEL;
		case 5:
			return BLACKSTEEL;
		default:
			return WROUGHTIRON;
		}
	}
	
	public static DrawplateReq getReqFromItem(ItemDrawplate item) {
		
		if (item.equals(ModItems.ironDrawplate))
			return WROUGHTIRON;
		else if (item.equals(ModItems.steelDrawplate))
			return STEEL;
		else if (item.equals(ModItems.blackSteelDrawplate))
			return BLACKSTEEL;
		else
			return WROUGHTIRON;
		
	}
}
