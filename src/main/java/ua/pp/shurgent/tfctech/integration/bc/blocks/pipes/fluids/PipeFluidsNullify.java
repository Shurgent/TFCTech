package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.ModPipeIconProvider;
import buildcraft.api.core.IIconProvider;
import buildcraft.transport.pipes.PipeFluidsVoid;

public class PipeFluidsNullify extends PipeFluidsVoid {

	public PipeFluidsNullify(Item item) {
		super(item);
	}

	@Override
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		return ModPipeIconProvider.TYPE.PipeFluidsNullify.ordinal();
	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		return super.fill(from, resource, doFill);
	}
}
