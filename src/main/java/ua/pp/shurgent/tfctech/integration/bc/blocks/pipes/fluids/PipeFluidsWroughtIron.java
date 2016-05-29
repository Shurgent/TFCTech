package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids;

import java.util.LinkedList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.ModPipeIconProvider;
import buildcraft.api.core.IIconProvider;
import buildcraft.api.statements.IActionInternal;
import buildcraft.transport.pipes.PipeFluidsIron;

public class PipeFluidsWroughtIron extends PipeFluidsIron {

	public PipeFluidsWroughtIron(Item item) {
		super(item);
		standardIconIndex = ModPipeIconProvider.TYPE.PipeFluidsWroughtIron_Standard.ordinal();
		solidIconIndex = ModPipeIconProvider.TYPE.PipeAllWroughtIron_Solid.ordinal();
	}

	@Override
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		if (direction == ForgeDirection.UNKNOWN) {
			return standardIconIndex;
		}
		if (container != null && container.getBlockMetadata() == direction.ordinal()) {
			return standardIconIndex;
		}
		return solidIconIndex;

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
	public LinkedList<IActionInternal> getActions() {
		return super.getActions();
	}

	@Override
	public boolean canConnectRedstone() {
		return super.canConnectRedstone();
	}
}
