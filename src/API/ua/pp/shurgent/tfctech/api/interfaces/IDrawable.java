package ua.pp.shurgent.tfctech.api.interfaces;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author Shurgent
 *
 */
public interface IDrawable {
	
	/**
	 * @return Wire metal texture for render wire model
	 */
	@SideOnly(Side.CLIENT)
	String getWireMetalName();
	
	/**
	 * @return Wire metal tier
	 */
	int getWireMetalTier();
}
