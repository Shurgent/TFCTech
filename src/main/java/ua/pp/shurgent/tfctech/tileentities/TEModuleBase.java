package ua.pp.shurgent.tfctech.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import ua.pp.shurgent.tfctech.api.ModuleConnectionTypes;
import ua.pp.shurgent.tfctech.api.Sides;

import com.bioxx.tfc.TileEntities.NetworkTileEntity;

public abstract class TEModuleBase extends NetworkTileEntity {
	
	/**
	 * Sides: Bottom, Top, Front, Back, Left, Right;
	 * 
	 * Values: -1 - not configurable side; 0 - not connected; >0 - connection type;
	 */
	public int[] sideConfig = {
			0,
			0,
			-1,
			0,
			0,
			0
	};
	/**
	 * Connection types mapping
	 */
	public ModuleConnectionTypes[] connectionTypes = {
		ModuleConnectionTypes.NONE
	};
	
	public byte rotation;
	
	public TEModuleBase() {
		rotation = (byte) (worldObj.getBlockMetadata(xCoord, yCoord, zCoord) & 7);
	}
	
	/**
	 * @return Max value of connection type used in sideConfig
	 */
	public int getMaxConnectionTypes() {
		return 0;
	}
	
	/**
	 * @param side
	 *            - Side index of the module block
	 * @return Current connection type configured on specified side
	 */
	public ModuleConnectionTypes getConnectionType(int side) {
		if (sideConfig[side] >= 0)
			return connectionTypes[sideConfig[side]];
		else
			return ModuleConnectionTypes.NONE;
	}
	
	/**
	 * @param side
	 *            - Side of the module block
	 * @return Current connection type configured on specified side
	 */
	public ModuleConnectionTypes getConnectionType(Sides side) {
		return getConnectionType(side.ordinal());
	}
	
	/**
	 * Toggle connection type on specified side
	 * 
	 * @param side
	 *            - Side index of the module block
	 */
	public void toggleSide(int side) {
		if (sideConfig[side] >= 0) {
			sideConfig[side]++;
			if (sideConfig[side] > getMaxConnectionTypes())
				sideConfig[side] = 0;
		}
	}
	
	/**
	 * Toggle connection type on specified side
	 * 
	 * @param side
	 *            - Side of the module block
	 */
	public void toggleSide(Sides side) {
		toggleSide(side.ordinal());
	}
	
	@Override
	public void handleInitPacket(NBTTagCompound nbt) {
		readFromNBT(nbt);
		this.worldObj.func_147479_m(xCoord, yCoord, zCoord);
	}
	
	@Override
	public void createInitNBT(NBTTagCompound nbt) {
		writeToNBT(nbt);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		sideConfig = nbt.getIntArray("sideConfig");
		if (sideConfig == null || sideConfig.length < 6) {
			sideConfig = new int[6];
			sideConfig[2] = -1;
		}
		this.readCustomNBT(nbt, false);
	}
	
	public abstract void readCustomNBT(NBTTagCompound nbt, boolean descPacket);
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setIntArray("sideConfig", sideConfig);
		this.writeCustomNBT(nbt, false);
	}
	
	public abstract void writeCustomNBT(NBTTagCompound nbt, boolean descPacket);
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeCustomNBT(nbttagcompound, true);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 3, nbttagcompound);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		this.readCustomNBT(pkt.func_148857_g(), true);
	}
	
	public void receiveMessageFromClient(NBTTagCompound message) {
	}
}
