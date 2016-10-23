package ua.pp.shurgent.tfctech.api;

import ua.pp.shurgent.tfctech.core.ModOptions;

/**
 * Energy tiers
 * @author Shurgent
 * 
 */
public enum EnergyTier {
	LV,
	MV,
	HV;
	
	/**
	 * @param tier - Energy tier
	 * @return Energy transfer rate, RF/t
	 */
	public static int getRate(EnergyTier tier) {
		switch (tier) {
		case HV:
			return ModOptions.cfgHVRate;
		case MV:
			return ModOptions.cfgMVRate;
		case LV:
		default:
			return ModOptions.cfgLVRate;
		}
	}
}
