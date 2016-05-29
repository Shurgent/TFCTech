package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.ModPipeIconProvider;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.handlers.PipeItemsInsertionHandler;
import buildcraft.api.core.IIconProvider;
import buildcraft.transport.pipes.PipeItemsGold;
import buildcraft.transport.pipes.events.PipeEventItem;

public class PipeItemsElectrum extends PipeItemsGold {

	public PipeItemsElectrum(Item item) {
		super(item);
	}

	@Override
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		return ModPipeIconProvider.TYPE.PipeItemsElectrum.ordinal();
	}

	public void eventHandler(PipeEventItem.AdjustSpeed event) {
		super.eventHandler(event);
	}

	public void eventHandler(PipeEventItem.Entered event) {
		event.item.setInsertionHandler(PipeItemsInsertionHandler.INSTANCE);
	}
}
