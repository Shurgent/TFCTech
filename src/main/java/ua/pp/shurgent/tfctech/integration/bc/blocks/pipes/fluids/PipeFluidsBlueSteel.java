package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.ModPipeIconProvider;
import buildcraft.api.core.IIconProvider;
import buildcraft.transport.IDiamondPipe;
import buildcraft.transport.pipes.PipeFluidsDiamond;
import buildcraft.transport.pipes.events.PipeEventFluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PipeFluidsBlueSteel extends PipeFluidsDiamond implements IDiamondPipe {

	public PipeFluidsBlueSteel(Item item) {
		super(item);
	}

	@Override
	public IInventory getFilters() {
		return super.getFilters();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		switch (direction) {
		case UNKNOWN:
			return ModPipeIconProvider.TYPE.PipeFluidsBlueSteel_Center.ordinal();
		case DOWN:
			return ModPipeIconProvider.TYPE.PipeFluidsBlueSteel_Down.ordinal();
		case UP:
			return ModPipeIconProvider.TYPE.PipeFluidsBlueSteel_Up.ordinal();
		case NORTH:
			return ModPipeIconProvider.TYPE.PipeFluidsBlueSteel_North.ordinal();
		case SOUTH:
			return ModPipeIconProvider.TYPE.PipeFluidsBlueSteel_South.ordinal();
		case WEST:
			return ModPipeIconProvider.TYPE.PipeFluidsBlueSteel_West.ordinal();
		case EAST:
			return ModPipeIconProvider.TYPE.PipeFluidsBlueSteel_East.ordinal();
		default:
			throw new IllegalArgumentException("direction out of bounds");
		}
	}

	@Override
	public int getIconIndexForItem() {
		return ModPipeIconProvider.TYPE.PipeFluidsBlueSteel_Item.ordinal();
	}

	@Override
	public boolean blockActivated(EntityPlayer entityplayer, ForgeDirection direction) {
		return super.blockActivated(entityplayer, direction);
	}

	public void eventHandler(PipeEventFluid.FindDest event) {
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
}
