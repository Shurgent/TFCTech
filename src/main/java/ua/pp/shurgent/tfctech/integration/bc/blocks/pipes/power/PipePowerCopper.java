package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.ModPipeIconProvider;
import buildcraft.api.core.IIconProvider;
import buildcraft.transport.pipes.PipePowerWood;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PipePowerCopper extends PipePowerWood {

	public PipePowerCopper(Item item) {
		super(item);
		standardIconIndex = ModPipeIconProvider.TYPE.PipePowerCopper_Standard.ordinal();
		solidIconIndex = ModPipeIconProvider.TYPE.PipeAllCopper_Solid.ordinal();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
	}

	@Override
	public void writeToNBT(NBTTagCompound data) {
		super.writeToNBT(data);
	}

	@Override
	public void readFromNBT(NBTTagCompound data) {
		super.readFromNBT(data);
	}

	@Override
	public int receiveEnergy(ForgeDirection from, int val) {
		return super.receiveEnergy(from, val);
	}

	@Override
	public int requestEnergy(ForgeDirection from, int amount) {
		return super.requestEnergy(from, amount);
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
	public boolean canConnectRedstoneEngine(ForgeDirection side) {
		return super.canConnectRedstoneEngine(side);
	}

	@Override
	public void getDebugInfo(List<String> info, ForgeDirection side, ItemStack debugger, EntityPlayer player) {
		super.getDebugInfo(info, side, debugger, player);
	}
}
