package ua.pp.shurgent.tfctech.tileentities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.api.EnergyTier;
import ua.pp.shurgent.tfctech.api.Helper;
import ua.pp.shurgent.tfctech.api.Sides;
import ua.pp.shurgent.tfctech.core.ModDetails;
import ua.pp.shurgent.tfctech.core.ModOptions;
import ua.pp.shurgent.tfctech.core.ModSounds;
import ua.pp.shurgent.tfctech.render.models.ModelInductionSmelter;
import cofh.api.energy.EnergyStorage;
import cofh.api.inventory.IInventoryConnection;

import com.bioxx.tfc.Core.TFC_Climate;
import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.Core.Metal.Alloy;
import com.bioxx.tfc.Core.Metal.AlloyManager;
import com.bioxx.tfc.Core.Metal.AlloyMetal;
import com.bioxx.tfc.Core.Metal.MetalPair;
import com.bioxx.tfc.Core.Metal.MetalRegistry;
import com.bioxx.tfc.Items.ItemMeltedMetal;
import com.bioxx.tfc.Items.Pottery.ItemPotteryMold;
import com.bioxx.tfc.api.Metal;
import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.TFCOptions;
import com.bioxx.tfc.api.TFC_ItemHeat;
import com.bioxx.tfc.api.Constant.Global;
import com.bioxx.tfc.api.Interfaces.ISmeltable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TEInductionSmelter extends TileEnergyConsumer implements IInventory, ISidedInventory, IInventoryConnection {
	
	public Map<String, MetalPair> metals = new HashMap<String, MetalPair>();
	public Alloy currentAlloy;
	public int temperature;
	public int energy;
	public ItemStack[] storage;
	public byte inputTick;
	public byte outputTick;
	public byte tempTick;
	public byte textureAnimationTick;
	public byte textureAnimationFrame;
	public byte textureAnimationDir;
	public byte soundLoopDelay;
	private int cookDelay;
	public static final int MAX_UNITS = 3000;
	
	public int maxTemp;
	public int minTemp;
	public boolean heating;
	
	private static final int[] slotsTop = new int[] {
			0,
			2
	};
	private static final int[] slotsBottom = new int[] {
		1
	};
	
	private ModelInductionSmelter model;
	
	public TEInductionSmelter() {
		this.storage = new ItemStack[3];
		this.broadcastRange = 8;
		this.model = new ModelInductionSmelter();
		this.maxTemp = 3500;
		this.minTemp = 3300;
		this.heating = false;
		this.textureAnimationDir = 1;
		this.battery = new EnergyStorage(ModOptions.cfgInductionSmelterRFStorage, EnergyTier.getRate(EnergyTier.HV));
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		
		nbt.setInteger("temp", temperature);
		nbt.setInteger("minTemp", minTemp);
		nbt.setInteger("maxTemp", maxTemp);
		nbt.setBoolean("heating", heating);
		nbt.setByte("rotation", rotation);
		
		NBTTagList nbttaglist = new NBTTagList();
		Iterator<MetalPair> iter = metals.values().iterator();
		while (iter.hasNext()) {
			MetalPair m = iter.next();
			if (m != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setInteger("ID", Item.getIdFromItem(m.type.ingot));
				nbttagcompound1.setFloat("AmountF", m.amount);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbt.setTag("Metals", nbttaglist);
		
		nbttaglist = new NBTTagList();
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				storage[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbt.setTag("Items", nbttaglist);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		readFromItemNBT(nbt);
		
	}
	
	public void readFromItemNBT(NBTTagCompound nbt) {
		temperature = nbt.getInteger("temp");
		minTemp = nbt.getInteger("minTemp");
		maxTemp = nbt.getInteger("maxTemp");
		heating = nbt.getBoolean("heating");
		NBTTagList nbttaglist = nbt.getTagList("Metals", 10);
		
		for (int i = 0; i < nbttaglist.tagCount(); i++) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			int id = nbttagcompound1.getInteger("ID");
			float amount = nbttagcompound1.getShort("Amount");
			// Added so that hopefully old worlds that stored metal as shorts wont break
			float amountF = amount + nbttagcompound1.getFloat("AmountF");
			addMetal(MetalRegistry.instance.getMetalFromItem(Item.getItemById(id)), amountF);
		}
		
		nbttaglist = nbt.getTagList("Items", 10);
		storage = new ItemStack[getSizeInventory()];
		for (int i = 0; i < nbttaglist.tagCount(); i++) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte byte0 = nbttagcompound1.getByte("Slot");
			if (byte0 >= 0 && byte0 < storage.length)
				storage[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
		}
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
	public void updateEntity() {
		if (!worldObj.isRemote) {
			inputTick++;
			outputTick++;
			tempTick++;
			energy = battery.getEnergyStored();
			
			if (cookDelay > 0)
				cookDelay--;
			
			/* Heat the smelter based on thermostat settings */
			if (TFCOptions.enableDebugMode) {
				temperature = 3000;
				heating = true;
			} else {
				
				boolean prevHeating = heating;
				if (temperature < minTemp && !heating && energy > 0) {
					heating = true;
					if (prevHeating != heating) {
						worldObj.playSoundEffect(xCoord, yCoord, zCoord, "random.click", 0.3F, 2.0F);
						updateGui((byte) 6);
					}
				} else if (temperature >= maxTemp && heating || energy <= 0) {
					heating = false;
					if (prevHeating != heating) {
						worldObj.playSoundEffect(xCoord, yCoord, zCoord, "random.click", 0.3F, 1.5F);
						updateGui((byte) 6);
					}
				}
				
				if (heating) {
					int consumBase = ModOptions.cfgInductionSmelterRFConsumption;
					int consumed = battery.extractEnergy(consumBase, false);
					energy = battery.getEnergyStored();
					updateGui((byte) 5);
					
					if (temperature < 1500)
						temperature += consumed / (consumBase / 4);
					else if (temperature < 2500)
						temperature += consumed / (consumBase / 2);
					else
						temperature++;
					if (temperature > 3500)
						temperature = 3500;
				}
			}
			
			if (tempTick > 22) {
				tempTick = 0;
				if (temperature > TFC_Climate.getHeightAdjustedTemp(worldObj, xCoord, yCoord, zCoord))
					temperature--;
				int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
				if (meta < 8 && isMetalLiquid()) {
					worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, meta + 8, 3);
				} else if (meta >= 8 && !isMetalLiquid()) {
					worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, meta - 8, 3);
				}
				// worldObj.func_147479_m(xCoord, yCoord, zCoord);
				// worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			}
			
			ItemStack stackToSmelt = storage[0];
			if (stackToSmelt != null) {
				Item itemToSmelt = stackToSmelt.getItem();
				int newDamage = stackToSmelt.getItemDamage() + 1;
				int maxDamage = stackToSmelt.getMaxDamage() - 1; // Subtract one so we never have an unshaped metal with 0/100 units
				
				if (itemToSmelt instanceof ItemMeltedMetal && TFC_ItemHeat.getIsLiquid(storage[0])) {
					if (inputTick > 10) {
						Metal inputMetal = MetalRegistry.instance.getMetalFromItem(itemToSmelt);
						
						if (currentAlloy != null && currentAlloy.outputType != null && itemToSmelt == currentAlloy.outputType.meltedItem) {
							this.addMetal(inputMetal, (short) 1);
							if (newDamage >= maxDamage) {
								storage[0] = new ItemStack(TFCItems.ceramicMold, 1, 1);
							} else {
								stackToSmelt.setItemDamage(newDamage);
							}
						} else {
							this.addMetal(inputMetal, (short) 1);
							if (newDamage >= maxDamage) {
								storage[0] = new ItemStack(TFCItems.ceramicMold, 1, 1);
							} else {
								stackToSmelt.setItemDamage(newDamage);
							}
						}
						inputTick = 0;
						updateGui((byte) 0);
					}
				} else if (itemToSmelt instanceof ISmeltable && ((ISmeltable) itemToSmelt).isSmeltable(stackToSmelt) && !TFC_Core.isOreIron(stackToSmelt)
						&& temperature >= TFC_ItemHeat.isCookable(stackToSmelt) && cookDelay == 0) {
					Metal mType = ((ISmeltable) itemToSmelt).getMetalType(stackToSmelt);
					if (addMetal(mType, ((ISmeltable) itemToSmelt).getMetalReturnAmount(stackToSmelt))) {
						temperature *= 0.9f;
						cookDelay = 20;
						if (stackToSmelt.stackSize <= 1)
							storage[0] = null;
						else
							storage[0].stackSize--;
						updateGui((byte) 0);
					}
				}
			}
			// Metal Output handling
			if (currentAlloy != null && storage[1] != null && currentAlloy.outputType != null && outputTick >= 2
					&& temperature >= TFC_ItemHeat.isCookable(currentAlloy.outputType)) {
				if (storage[1].getItem() == TFCItems.ceramicMold) {
					storage[1] = new ItemStack(currentAlloy.outputType.meltedItem, 1, 99);
					TFC_ItemHeat.setTemp(storage[1], temperature);
					drainOutput(1.0f);
					updateGui((byte) 1);
				} else if (storage[1].getItem() == currentAlloy.outputType.meltedItem && storage[1].getItemDamage() > 0) {
					storage[1].setItemDamage(storage[1].getItemDamage() - 1);
					float inTemp = TFC_ItemHeat.getTemp(storage[1]);
					float temp = (temperature - inTemp) / 2;
					TFC_ItemHeat.setTemp(storage[1], inTemp + temp);
					drainOutput(1.0f);
					storage[1].stackSize = 1;
					updateGui((byte) 1);
				}
				outputTick = 0;
			}
			
			if (currentAlloy != null && this.getTotalMetal() < 1) {
				metals = new HashMap<String, MetalPair>();
				updateCurrentAlloy();
				this.updateGui((byte) 2);
				currentAlloy = null;
			}
			
			if (storage[1] != null && storage[1].stackSize <= 0)
				storage[1].stackSize = 1;
			if (inputTick > 10)
				inputTick = 0;
			if (outputTick >= 2)
				outputTick = 0;
			
			if (storage[2] != null && storage[1] == null) {
				setInventorySlotContents(1, decrStackSize(2, 1));
			}
			
			// Try to automatically transfer empty molds from input to molds slot
			if (storage[0] != null && storage[0].getItem() == TFCItems.ceramicMold && storage[0].getItemDamage() == 1) {
				int qtyMolds = storage[2] == null ? 0 : storage[2].stackSize;
				int qtyCanTransfer = Math.min(storage[0].stackSize, TFCItems.ceramicMold.getItemStackLimit(null) - qtyMolds);
				if (qtyCanTransfer > 0) {
					ItemStack splitIS = decrStackSize(0, qtyCanTransfer);
					splitIS.stackSize = qtyCanTransfer + qtyMolds;
					setInventorySlotContents(2, splitIS);
				}
			}
		} else {
			textureAnimationTick++;
			
			if (textureAnimationTick > 2) {
				textureAnimationTick = 0;
				if (textureAnimationDir == 0)
					textureAnimationDir = 1;
				textureAnimationFrame += textureAnimationDir;
				if (textureAnimationFrame >= 19 || textureAnimationFrame <= 0)
					textureAnimationDir = (byte) (0 - textureAnimationDir);
			}
		}
		
		if (soundLoopDelay <= 0) {
			if (heating) {
				worldObj.playSoundEffect(xCoord, yCoord, zCoord, ModSounds.INDUCTOR, 0.5F, 1.0F);
				soundLoopDelay = 78;
			}
		} else
			soundLoopDelay--;
		
	}
	
	public boolean isMetalLiquid() {
		if (currentAlloy != null)
			return temperature >= TFC_ItemHeat.isCookable(currentAlloy.outputType);
		return false;
	}
	
	public boolean drainOutput(float amount) {
		if (metals != null && metals.values().size() > 0) {
			for (Object am : metals.values()) {
				float percent = currentAlloy.getPercentForMetal(((MetalPair) am).type) / 100;
				((MetalPair) am).amount -= amount * percent;
			}
			updateCurrentAlloy();
		}
		return true;
	}
	
	public boolean addMetal(Metal m, float amt) {
		if (getTotalMetal() + amt <= MAX_UNITS && m.name != null && !"Unknown".equals(m.name)) {
			if (metals.containsKey(m.name))
				metals.get(m.name).amount += amt;
			else
				metals.put(m.name, new MetalPair(m, amt));
			
			updateCurrentAlloy();
			return true;
		}
		return false;
	}
	
	public float getTotalMetal() {
		Iterator<MetalPair> iter = metals.values().iterator();
		float totalAmount = 0;
		while (iter.hasNext()) {
			MetalPair m = iter.next();
			if (m != null)
				totalAmount += m.amount;
		}
		return totalAmount;
	}
	
	private void updateCurrentAlloy() {
		List<AlloyMetal> a = new ArrayList<AlloyMetal>();
		Iterator<MetalPair> iter = metals.values().iterator();
		float totalAmount = getTotalMetal();
		iter = metals.values().iterator();
		while (iter.hasNext()) {
			MetalPair m = iter.next();
			if (m != null)
				a.add(new AlloyMetal(m.type, (m.amount / totalAmount) * 100f));
		}
		
		Metal match = AlloyManager.INSTANCE.matchesAlloy(a, Alloy.EnumTier.TierV);
		if (match != null) {
			currentAlloy = new Alloy(match, totalAmount);
			currentAlloy.alloyIngred = a;
		} else {
			currentAlloy = new Alloy(Global.UNKNOWN, totalAmount);
			currentAlloy.alloyIngred = a;
		}
	}
	
	public void incTemp() {
		if (!worldObj.isRemote) {
			this.maxTemp += 100;
			if (this.maxTemp > 3500)
				this.maxTemp = 3500;
			this.minTemp = this.maxTemp - 200;
		} else {
			this.sendThermostatAjustPacket(3);
		}
	}
	
	public void decTemp() {
		if (!worldObj.isRemote) {
			this.minTemp -= 100;
			if (this.minTemp < 0)
				this.minTemp = 0;
			this.maxTemp = this.minTemp + 200;
		} else {
			this.sendThermostatAjustPacket(4);
		}
	}
	
	@SideOnly(Side.CLIENT)
	private void sendThermostatAjustPacket(int i) {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setByte("action", (byte) i);
		nbt.setInteger("minTemp", minTemp);
		nbt.setInteger("maxTemp", maxTemp);
		this.broadcastPacketInRange(this.createDataPacket(nbt));
	}
	
	public int getOutCountScaled(int length) {
		if (currentAlloy != null)
			return ((int) this.currentAlloy.outputAmount * length) / MAX_UNITS;
		else
			return 0;
	}
	
	public int getTemperatureScaled(int s) {
		return (temperature * s) / 3500;
	}
	
	public int getEnergyScaled(int s) {
		return (energy * s) / 32000;
	}
	
	public int getThermostatScaled(int s) {
		return (maxTemp * s) / 3000;
	}
	
	public void updateGui(byte action) {
		if (!worldObj.isRemote) {
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setByte("action", action);
			if (currentAlloy != null) {
				if (action == 0) {
					currentAlloy.toNBT(nbt);
				} else if (action == 1 && currentAlloy != null) {
					nbt.setFloat("outputAmount", currentAlloy.outputAmount);
				}
			}
			
			if (action == 5) {
				nbt.setInteger("energy", energy);
			}
			
			if (action == 6) {
				nbt.setBoolean("heating", heating);
			}
			
			this.broadcastPacketInRange(this.createDataPacket(nbt));
		}
	}
	
	@Override
	public void handleDataPacket(NBTTagCompound nbt) {
		byte action = nbt.getByte("action");
		if (action == 0)
			this.currentAlloy = new Alloy().fromNBT(nbt);
		else if (action == 1 && currentAlloy != null) {
			currentAlloy.outputAmount = nbt.getFloat("outputAmount");
		} else if (action == 2)
			currentAlloy = null;
		
		else if (action == 3)
			this.incTemp();
		else if (action == 4)
			this.decTemp();
		
		else if (action == 5) {
			energy = nbt.getInteger("energy");
		} else if (action == 6) {
			heating = nbt.getBoolean("heating");
		}
		
	}
	
	@Override
	public ConnectionType canConnectInventory(ForgeDirection from) {
		return from == ForgeDirection.UP ? ConnectionType.DEFAULT : ConnectionType.DENY;
	}
	
	public ModelInductionSmelter getModel() {
		if (worldObj.isRemote) {
			return model;
		}
		return null;
	}
	
	public void setModel(ModelInductionSmelter m) {
		if (worldObj.isRemote) {
			model = m;
		}
	}
	
	public ResourceLocation getResource() {
		return new ResourceLocation(ModDetails.ModID, "textures/blocks/devices/InductionSmelter.png");
	}
	
	@Override
	public int getSizeInventory() {
		return 3;
	}
	
	@Override
	public ItemStack getStackInSlot(int slot) {
		return storage[slot];
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		return storage[slot];
	}
	
	@Override
	public ItemStack decrStackSize(int slot, int qty) {
		
		if (storage[slot] != null) {
			if (storage[slot].stackSize <= qty) {
				ItemStack is = storage[slot];
				storage[slot] = null;
				return is;
			}
			ItemStack isSplit = storage[slot].splitStack(qty);
			if (storage[slot].stackSize == 0)
				storage[slot] = null;
			return isSplit;
		} else {
			return null;
		}
		
	}
	
	@Override
	public void setInventorySlotContents(int slot, ItemStack is) {
		storage[slot] = is;
	}
	
	@Override
	public String getInventoryName() {
		return "Induction Smelter";
	}
	
	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}
	
	@Override
	public void openInventory() {
	}
	
	@Override
	public void closeInventory() {
	}
	
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack is) {
		
		if (slot == 2 && (is.getItem() == TFCItems.ceramicMold && is.getItemDamage() == 1 || is.getItem() instanceof ItemPotteryMold && is.getItemDamage() > 0))
			return true;
		
		if (slot == 0 && !(is.getItem() == TFCItems.rawBloom || is.getItem() == TFCItems.bloom && is.getItemDamage() > 100) && !isItemValidForSlot(2, is))
			return true;
		
		return false;
	}
	
	/**
	 * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this block.
	 */
	public int[] getAccessibleSlotsFromSide(int side) {
		if (!ModOptions.cfgAllowAutomationInductionSmelter)
			return new int[0];
		
		return side == 0 ? slotsBottom : (side == 1 ? slotsTop : new int[0]); // Resources and molds from top, result from bottom
	}
	
	/**
	 * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item, side
	 */
	public boolean canInsertItem(int slot, ItemStack is, int side) {
		return ModOptions.cfgAllowAutomationInductionSmelter ? this.isItemValidForSlot(slot, is) : false;
	}
	
	/**
	 * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item, side
	 */
	public boolean canExtractItem(int slot, ItemStack is, int side) {
		if (!ModOptions.cfgAllowAutomationInductionSmelter)
			return false;
		
		if (slot == 1 && is.getItem() instanceof ItemMeltedMetal && is.getItemDamage() == 0)
			return true;
		
		return false;
	}
	
	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return Helper.rotatedSide(rotation, Sides.BACK).equals(from); // Only from back of smelter
	}
	
	public EnergyStorage getEnergyStorage() {
		return this.battery;
	}
}
