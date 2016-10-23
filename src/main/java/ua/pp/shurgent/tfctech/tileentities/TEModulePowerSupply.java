package ua.pp.shurgent.tfctech.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import ua.pp.shurgent.tfctech.api.EnergyTier;
import ua.pp.shurgent.tfctech.core.ModOptions;
import cofh.api.energy.EnergyStorage;

public class TEModulePowerSupply extends TEModuleBase {
	
	public EnergyTier energyTier;
	EnergyStorage energyStorage;
	
	public TEModulePowerSupply(EnergyTier tier) {
		energyTier = tier;
		energyStorage = new EnergyStorage(getMaxStorage(), getMaxRate());
	}
	
	public int getMaxStorage() {
		if (this.energyTier == EnergyTier.HV)
			return ModOptions.cfgHVPowerSupplyRFStorage;
		else if (this.energyTier == EnergyTier.MV)
			return ModOptions.cfgMVPowerSupplyRFStorage;
		else
			return ModOptions.cfgLVPowerSupplyRFStorage;
	}
	
	public int getMaxRate() {
		if (this.energyTier == EnergyTier.HV)
			return ModOptions.cfgHVRate;
		else if (this.energyTier == EnergyTier.MV)
			return ModOptions.cfgMVRate;
		else
			return ModOptions.cfgLVRate;
	}
	
	@Override
	public void readCustomNBT(NBTTagCompound nbt, boolean descPacket) {
		energyStorage.readFromNBT(nbt);
	}
	
	@Override
	public void writeCustomNBT(NBTTagCompound nbt, boolean descPacket) {
		energyStorage.writeToNBT(nbt);
	}
	
}
