package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.ModPipeIconProvider;
import buildcraft.api.core.IIconProvider;
import buildcraft.transport.pipes.PipeFluidsStone;

public class PipeFluidsBronze extends PipeFluidsStone {

	public PipeFluidsBronze(Item item) {
		super(item);
	}

	@Override
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		return ModPipeIconProvider.TYPE.PipeFluidsBronze.ordinal();
	}
}
