package ua.pp.shurgent.tfctech.integration.bc.handlers;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;
import ua.pp.shurgent.tfctech.Globals;
import ua.pp.shurgent.tfctech.core.ModFluids;
import ua.pp.shurgent.tfctech.items.pottery.ItemModPotteryLatexBowl;
import buildcraft.factory.TileTank;

public class LiquidContainerHandler {
	
	public static boolean handleLatexBowlUse(ItemStack is, TileEntity te) {
		
		ItemModPotteryLatexBowl item = (ItemModPotteryLatexBowl) is.getItem();
		
		if (te instanceof TileTank) {
			TileTank tank = (TileTank) te;
			if (is.getItemDamage() == 1) { // Empty bowl
				if (tank.canDrain(ForgeDirection.UNKNOWN, ModFluids.LATEX)) {
					FluidStack fs = tank.drain(ForgeDirection.UNKNOWN, Globals.LATEX_BOWL_CAPACITY, true);
					if (fs != null && fs.amount > 0) {
						is.setItemDamage(item.getDamageFromUnits(fs.amount));
						return true;
					}
				}
			} else if (is.getItemDamage() > 2) { // Partially filled bowl
				if (tank.canFill(ForgeDirection.UNKNOWN, ModFluids.LATEX)) {
					FluidStack fs = new FluidStack(ModFluids.LATEX, item.getUnitsFromDamage(is.getItemDamage()));
					int filled = tank.fill(ForgeDirection.UNKNOWN, fs, true);
					if (filled > 0) {
						is.setItemDamage(item.getDamageFromUnits(item.getUnitsFromDamage(is.getItemDamage()) - filled));
						return true;
					}
				}
			}
		}
		return false;
		
	}
	
}
