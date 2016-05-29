package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.ModPipeIconProvider;
import buildcraft.api.core.IIconProvider;
import buildcraft.transport.pipes.PipeItemsVoid;
import buildcraft.transport.pipes.events.PipeEventItem;

public class PipeItemsNullify extends PipeItemsVoid {

	public PipeItemsNullify(Item item) {
		super(item);
	}

	@Override
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		return ModPipeIconProvider.TYPE.PipeItemsNullify.ordinal();
	}

	public void eventHandler(PipeEventItem.DropItem event) {
		super.eventHandler(event);
	}

	public void eventHandler(PipeEventItem.ReachedCenter event) {
		super.eventHandler(event);
	}
}
