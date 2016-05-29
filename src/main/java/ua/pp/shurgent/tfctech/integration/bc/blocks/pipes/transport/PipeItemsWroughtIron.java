package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport;

import java.util.LinkedList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.ModPipeIconProvider;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.handlers.PipeItemsInsertionHandler;
import buildcraft.api.core.IIconProvider;
import buildcraft.api.statements.IActionInternal;
import buildcraft.transport.pipes.PipeItemsIron;
import buildcraft.transport.pipes.events.PipeEventItem;

public class PipeItemsWroughtIron extends PipeItemsIron {
	private int standardIconIndex = ModPipeIconProvider.TYPE.PipeItemsWroughtIron_Standard.ordinal();
	private int solidIconIndex = ModPipeIconProvider.TYPE.PipeAllWroughtIron_Solid.ordinal();

	public PipeItemsWroughtIron(Item item) {
		super(item);
	}

	@Override
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

	@Override
	public boolean blockActivated(EntityPlayer entityplayer, ForgeDirection side) {
		return super.blockActivated(entityplayer, side);
	}

	@Override
	public void onNeighborBlockChange(int blockId) {
		super.onNeighborBlockChange(blockId);
	}

	@Override
	public void onBlockPlaced() {
		super.onBlockPlaced();
	}

	@Override
	public void initialize() {
		super.initialize();
	}

	@Override
	public boolean outputOpen(ForgeDirection to) {
		return super.outputOpen(to);
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		if (direction == ForgeDirection.UNKNOWN) {
			return standardIconIndex;
		} else {
			int metadata = container.getBlockMetadata();

			if (metadata != direction.ordinal()) {
				return solidIconIndex;
			} else {
				return standardIconIndex;
			}
		}
	}

	@Override
	public LinkedList<IActionInternal> getActions() {
		return super.getActions();
	}

	@Override
	public boolean canConnectRedstone() {
		return super.canConnectRedstone();
	}

	public void eventHandler(PipeEventItem.Entered event) {
		event.item.setInsertionHandler(PipeItemsInsertionHandler.INSTANCE);
	}
}
