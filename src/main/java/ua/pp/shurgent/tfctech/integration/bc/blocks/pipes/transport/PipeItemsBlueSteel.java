package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport;

import io.netty.buffer.ByteBuf;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.ModPipeIconProvider;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.handlers.PipeItemsInsertionHandler;
import buildcraft.api.core.IIconProvider;
import buildcraft.transport.IDiamondPipe;
import buildcraft.transport.pipes.PipeItemsDiamond;
import buildcraft.transport.pipes.events.PipeEventItem;
import buildcraft.transport.pipes.events.PipeEventPriority;

public class PipeItemsBlueSteel extends PipeItemsDiamond implements IDiamondPipe {
	
	public PipeItemsBlueSteel(Item item) {
		super(item);
	}

	@Override
	public IInventory getFilters() {
		return super.getFilters();
	}

	@Override
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		switch (direction) {
		case UNKNOWN:
			return ModPipeIconProvider.TYPE.PipeItemsBlueSteel_Center.ordinal();
		case DOWN:
			return ModPipeIconProvider.TYPE.PipeItemsBlueSteel_Down.ordinal();
		case UP:
			return ModPipeIconProvider.TYPE.PipeItemsBlueSteel_Up.ordinal();
		case NORTH:
			return ModPipeIconProvider.TYPE.PipeItemsBlueSteel_North.ordinal();
		case SOUTH:
			return ModPipeIconProvider.TYPE.PipeItemsBlueSteel_South.ordinal();
		case WEST:
			return ModPipeIconProvider.TYPE.PipeItemsBlueSteel_West.ordinal();
		case EAST:
			return ModPipeIconProvider.TYPE.PipeItemsBlueSteel_East.ordinal();
		default:
			throw new IllegalArgumentException("direction out of bounds");
		}
	}

	@PipeEventPriority(priority = -4194304)
	public void eventHandler(PipeEventItem.FindDest event) {
		// We're running last and we can safely assume that nothing else
		// will change the destination.
		// This lets us skip a few logic things.
		super.eventHandler(event);
	}

	/* SAVING & LOADING */
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
	}

	// ICLIENTSTATE
	@Override
	public void writeData(ByteBuf data) {
		super.writeData(data);
	}

	@Override
	public void readData(ByteBuf data) {
		super.readData(data);
	}

	public void eventHandler(PipeEventItem.Entered event) {
		event.item.setInsertionHandler(PipeItemsInsertionHandler.INSTANCE);
	}
}
