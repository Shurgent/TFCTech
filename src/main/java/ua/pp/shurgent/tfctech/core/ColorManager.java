package ua.pp.shurgent.tfctech.core;

import buildcraft.api.core.EnumColor;

public class ColorManager {
	public enum Color {
		LIME,
		BLACK,
		BLUE,
		CYAN,
		GRAY,
		YELLOW,
		ORANGE,
		GREEN,
		BROWN,
		PINK,
		SILVER,
		LIGHT_BLUE,
		WHITE,
		RED,
		PURPLE,
		MAGENTA;
		
		public static final String[] DYES = {
				"dyeLime",
				"dyeBlack",
				"dyeBlue",
				"dyeCyan",
				"dyeGray",
				"dyeYellow",
				"dyeOrange",
				"dyeGreen",
				"dyeBrown",
				"dyePink",
				"dyeLightGray",
				"dyeLightBlue",
				"dyeWhite",
				"dyeRed",
				"dyePurple",
				"dyeMagenta"
		};
		
		public static final String[] NAMES = {
				"lime",
				"black",
				"blue",
				"cyan",
				"gray",
				"yellow",
				"orange",
				"green",
				"brown",
				"pink",
				"silver",
				"light_blue",
				"white",
				"red",
				"purple",
				"magenta"
		};
		
		public static final Color[] VALUES = values();
		
		public static Color fromId(int id) {
			if (id < 0 || id >= VALUES.length)
				return WHITE;
			return VALUES[id];
		}
		
		public static Color fromName(String name) {
			for (int id = 0; id < NAMES.length; id++) {
				if (NAMES[id].equals(name)) {
					return VALUES[id];
				}
			}
			return null;
		}
		
		public String getName() {
			return NAMES[ordinal()];
		}
		
		public String getDye() {
			return DYES[ordinal()];
		}
	}
	
	public static int getBCColorIndex(int i) {
		return EnumColor.fromDye(Color.fromId(i).getDye()).ordinal();
	}
	
}
