package ua.pp.shurgent.tfctech.api.crafting;

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
}
