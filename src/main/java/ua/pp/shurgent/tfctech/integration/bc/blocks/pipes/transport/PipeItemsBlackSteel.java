package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.ModPipeIconProvider;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.handlers.PipeItemsInsertionHandler;
import buildcraft.api.core.IIconProvider;
import buildcraft.transport.pipes.PipeItemsObsidian;
import buildcraft.transport.pipes.events.PipeEventItem;

public class PipeItemsBlackSteel extends PipeItemsObsidian {

	public PipeItemsBlackSteel(Item item) {
		super(item);
	}

	@Override
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		return ModPipeIconProvider.TYPE.PipeItemsBlackSteel.ordinal();
	}

	@Override
	public void onEntityCollidedWithBlock(Entity entity) {
		super.onEntityCollidedWithBlock(entity);
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
	}

	public void pullItemIntoPipe(Entity entity, int distance) {
		super.pullItemIntoPipe(entity, distance);
	}

	public void eventHandler(PipeEventItem.DropItem event) {
		super.eventHandler(event);
	}

	public boolean canSuck(Entity entity, int distance) {
		return super.canSuck(entity, distance);
	}

	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return super.canConnectEnergy(from);
	}

	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
		return super.receiveEnergy(from, maxReceive, simulate);
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
		return super.extractEnergy(from, maxExtract, simulate);
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		return super.getEnergyStored(from);
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		return super.getMaxEnergyStored(from);
	}

	public void eventHandler(PipeEventItem.Entered event) {
		event.item.setInsertionHandler(PipeItemsInsertionHandler.INSTANCE);
	}
}
