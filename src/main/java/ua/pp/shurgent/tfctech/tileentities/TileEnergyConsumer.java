package ua.pp.shurgent.tfctech.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyReceiver;

import com.bioxx.tfc.TileEntities.NetworkTileEntity;

public class TileEnergyConsumer extends NetworkTileEntity implements IEnergyReceiver {
	
	protected EnergyStorage battery = new EnergyStorage(32000);
	public byte rotation = 0;
	
	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return true;
	}
	
	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
		return battery.receiveEnergy(maxReceive, simulate);
	}
	
	@Override
	public int getEnergyStored(ForgeDirection from) {
		return battery.getEnergyStored();
	}
	
	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		return battery.getMaxEnergyStored();
	}
	
	@Override
	public void handleInitPacket(NBTTagCompound nbt) {
		readNBT(nbt);
		this.worldObj.func_147479_m(xCoord, yCoord, zCoord);
	}
	
	@Override
	public void createInitNBT(NBTTagCompound nbt) {
		writeNBT(nbt);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		readNBT(nbt);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		writeNBT(nbt);
	}
	
	private void readNBT(NBTTagCompound nbt) {
		rotation = nbt.getByte("rotation");
		battery.readFromNBT(nbt);
	}
	
	private void writeNBT(NBTTagCompound nbt) {
		nbt.setByte("rotation", rotation);
		battery.writeToNBT(nbt);
	}
	
}
