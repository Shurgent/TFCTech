package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.IFluidHandler;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.ModPipeIconProvider;
import buildcraft.api.core.IIconProvider;
import buildcraft.transport.pipes.PipeFluidsWood;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PipeFluidsCopper extends PipeFluidsWood {

	public PipeFluidsCopper(Item item) {
		super(item);
		standardIconIndex = ModPipeIconProvider.TYPE.PipeFluidsCopper_Standard.ordinal();
		solidIconIndex = ModPipeIconProvider.TYPE.PipeAllCopper_Solid.ordinal();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		if (direction == ForgeDirection.UNKNOWN) {
			return standardIconIndex;
		} else {
			int metadata = container.getBlockMetadata();

			if (metadata == direction.ordinal()) {
				return solidIconIndex;
			} else {
				return standardIconIndex;
			}
		}
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
	public void initialize() {
		super.initialize();
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
	}

	public int extractFluid(IFluidHandler fluidHandler, ForgeDirection side) {
		return super.extractFluid(fluidHandler, side);
	}

	@Override
	public boolean outputOpen(ForgeDirection to) {
		return super.outputOpen(to);
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

	@Override
	public void writeData(ByteBuf data) {
		super.writeData(data);
	}

	@Override
	public void readData(ByteBuf data) {
		super.readData(data);
	}
}
