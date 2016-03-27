package ua.pp.shurgent.tfctech.blocks.bc.pipes.transport;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.blocks.bc.pipes.handlers.PipeItemsInsertionHandler;
import ua.pp.shurgent.tfctech.core.ModPipeIconProvider;
import buildcraft.api.core.IIconProvider;
import buildcraft.transport.pipes.PipeItemsCobblestone;
import buildcraft.transport.pipes.events.PipeEventItem;

public class PipeItemsLead extends PipeItemsCobblestone {

	public PipeItemsLead(Item item) {
		super(item);
	}

	@Override
	public IIconProvider getIconProvider() {
		return TFCTech.instance.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		return ModPipeIconProvider.TYPE.PipeItemsLead.ordinal();
	}

	public void eventHandler(PipeEventItem.Entered event) {
		event.item.setInsertionHandler(PipeItemsInsertionHandler.INSTANCE);
	}
}
