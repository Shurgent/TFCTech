package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.IFluidHandler;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.ModPipeIconProvider;
import buildcraft.api.core.IIconProvider;
import buildcraft.transport.pipes.PipeFluidsEmerald;

public class PipeFluidsRedSteel extends PipeFluidsEmerald {

	public PipeFluidsRedSteel(Item item) {
		super(item);
		standardIconIndex = ModPipeIconProvider.TYPE.PipeFluidsRedSteel_Standard.ordinal();
		solidIconIndex = ModPipeIconProvider.TYPE.PipeAllRedSteel_Solid.ordinal();
	}

	@Override
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

	public IInventory getFilters() {
		return super.getFilters();
	}

	@Override
	public int extractFluid(IFluidHandler fluidHandler, ForgeDirection side) {
		return super.extractFluid(fluidHandler, side);
	}

	@Override
	public boolean blockActivated(EntityPlayer entityplayer, ForgeDirection side) {
		return super.blockActivated(entityplayer, side);
	}

	@Override
	public void writeData(ByteBuf data) {
		super.writeData(data);
	}

	@Override
	public void readData(ByteBuf data) {
		super.readData(data);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
	}
}
