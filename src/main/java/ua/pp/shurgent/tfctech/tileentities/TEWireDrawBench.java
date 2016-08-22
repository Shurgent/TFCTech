package ua.pp.shurgent.tfctech.tileentities;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import ua.pp.shurgent.tfctech.api.crafting.WireDrawBenchManager;
import ua.pp.shurgent.tfctech.api.crafting.WireDrawBenchRecipe;
import ua.pp.shurgent.tfctech.api.interfaces.IDrawable;
import ua.pp.shurgent.tfctech.blocks.devices.BlockWireDrawBench;
import ua.pp.shurgent.tfctech.core.ModDetails;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.core.ModSounds;
import ua.pp.shurgent.tfctech.render.models.ModelWireDrawBench;

import com.bioxx.tfc.TileEntities.NetworkTileEntity;
import com.bioxx.tfc.api.Interfaces.ISmeltable;

public class TEWireDrawBench extends NetworkTileEntity implements IInventory {
	
	public static final int INPUT = 0;
	public static final int OUTPUT = 1;
	public static final int DRAWPLATE = 2;
	
	public byte rotation;
	public String wireMetal = "";
	public String drawplateMetal = "";
	public byte progress = 0;
	public boolean isLubricated = false;
	public boolean isHeadBlock = true;
	
	private ItemStack[] storage = new ItemStack[3];
	
	private boolean drawing;
	private boolean finished;
	
	private byte working = 0;
	
	public WireDrawBenchRecipe recipe;
	
	private ModelWireDrawBench model;
	
	public TEWireDrawBench() {
		model = new ModelWireDrawBench();
	}
	
	public boolean canDraw() {
		this.updateRecipe();
		return recipe != null && !finished;
	}
	
	public void putWire(ItemStack is) {
		if (!isFinished() && getDrawplate() != null && is != null && !this.worldObj.isRemote) {
			WireDrawBenchManager m = WireDrawBenchManager.getInstance();
			recipe = m.findMatchingRecipe(new WireDrawBenchRecipe(is, m.getDrawplateTier(getDrawplate()), this.isLubricated));
			if (recipe != null) {
				is.stackSize--;
				ItemStack i = is.copy();
				i.stackSize = 1;
				this.setInventorySlotContents(0, i);
				this.wireMetal = ((ISmeltable) i.getItem()).getMetalType(i).name;
				this.updateWireDrawBench();
			}
		}
	}
	
	public void putDrawplate(ItemStack is) {
		if (!isFinished() && getDrawplate() == null && is != null && !this.worldObj.isRemote) {
			if (WireDrawBenchManager.getInstance().getDrawplateTier(is) != 0) {
				is.stackSize--;
				ItemStack i = is.copy();
				i.stackSize = 1;
				this.setInventorySlotContents(2, i);
				this.drawplateMetal = ((ISmeltable) i.getItem()).getMetalType(i).name;
				this.updateWireDrawBench();
			}
		}
	}
	
	public ItemStack takeDrawplate() {
		this.recipe = null;
		this.progress = 0;
		this.isLubricated = false;
		ItemStack is = getDrawplate().copy();
		setDrawplate(null);
		this.drawplateMetal = "";
		updateWireDrawBench();
		return is;
	}
	
	public ItemStack takeOutput() {
		
		if (finished) {
			this.finished = false;
			this.recipe = null;
			this.progress = 0;
			ItemStack is = getOutput().copy();
			storage[OUTPUT] = null;
			this.wireMetal = "";
			updateWireDrawBench();
			return is;
		}
		return null;
		
	}
	
	public TEWireDrawBench getMainTileEntity() {
		
		if (this.isHeadBlock) {
			return this;
		} else {
			
			int[] offset = BlockWireDrawBench.BLOCKMAP[this.rotation];
			
			TileEntity te = this.worldObj.getTileEntity(this.xCoord - offset[0], this.yCoord, this.zCoord - offset[1]);
			if (te != null && te instanceof TEWireDrawBench)
				return (TEWireDrawBench) te;
			else
				return null;
		}
	}
	
	public boolean isDrawing() {
		return this.drawing;
	}
	
	public void setIsDrawing(boolean b) {
		if (canDraw()) {
			this.drawing = b;
			if (!worldObj.isRemote) {
				this.updateWireDrawBench();
			}
			this.worldObj.playSoundEffect(xCoord, yCoord, zCoord, ModSounds.DRAWING, 1.0F, 1.0F);
		}
	}
	
	public void finishDrawing() {
		if (recipe == null || getDrawplate() == null)
			return; // Just in case
		setInput(null);
		setOutput(recipe.getOutItemStack().copy());
		this.finished = true;
		this.drawing = false;
		this.progress = 0;
		int damage = 1;
		int gain;
		
		if (getDrawplate().getItem().equals(ModItems.steelDrawplate))
			gain = 16;
		else if (getDrawplate().getItem().equals(ModItems.blackSteelDrawplate))
			gain = 8;
		else
			gain = 32;
		
		if (getOutput().getItem() instanceof IDrawable) {
			IDrawable wire = (IDrawable) getOutput().getItem();
			damage = wire.getWireMetalTier();
		}
		if (getDrawplate().attemptDamageItem(this.isLubricated ? damage * gain / 2 : damage * gain, this.worldObj.rand)) {
			setDrawplate(null);
			this.worldObj.playSoundEffect(xCoord, yCoord, zCoord, "minecraft:random.break", 1.0F, 1.0F);
		}
		
		this.isLubricated = false;
		this.worldObj.playSoundEffect(xCoord, yCoord, zCoord, ModSounds.TONGSFALL, 1.0F, 1.0F);
	}
	
	public boolean isFinished() {
		return this.finished;
	}
	
	public ItemStack getInput() {
		return storage[INPUT];
	}
	
	public void setInput(ItemStack is) {
		storage[INPUT] = is;
	}
	
	public ItemStack getOutput() {
		return storage[OUTPUT];
	}
	
	public void setOutput(ItemStack is) {
		storage[OUTPUT] = is;
	}
	
	public ItemStack getDrawplate() {
		return storage[DRAWPLATE];
	}
	
	public void setDrawplate(ItemStack is) {
		storage[DRAWPLATE] = is;
	}
	
	public void updateRecipe() {
		
		WireDrawBenchManager manager = WireDrawBenchManager.getInstance();
		if (isFinished())
			recipe = manager.findMatchingResult(getOutput());
		else
			recipe = manager.findMatchingRecipe(new WireDrawBenchRecipe(getInput(), manager.getDrawplateTier(getDrawplate()), this.isLubricated));
		
	}
	
	public void ejectContents() {
		float force = 0.03F;
		EntityItem ei;
		Random rand = new Random();
		float xOffset = rand.nextFloat() * 0.3F + 0.1F;
		float yOffset = rand.nextFloat() * 1.0F + 0.4F;
		float zOffset = rand.nextFloat() * 0.3F + 0.1F;
		
		for (int i = 0; i < getSizeInventory(); i++) {
			if (storage[i] != null) {
				ei = new EntityItem(worldObj, xCoord + xOffset, yCoord + yOffset, zCoord + zOffset, storage[i]);
				ei.motionX = (float) rand.nextGaussian() * force;
				ei.motionY = (float) rand.nextGaussian() * force + 0.2F;
				ei.motionZ = (float) rand.nextGaussian() * force;
				worldObj.spawnEntityInWorld(ei);
			}
		}
	}
	
	public void dropItems() {
		if (!worldObj.isRemote) {
			this.ejectContents();
		}
	}
	
	public void updateWireDrawBench() {
		
		this.updateRecipe();
		this.worldObj.func_147479_m(xCoord, yCoord, zCoord);
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		this.broadcastPacketInRange(this.createDataPacket(nbt));
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		readNBT(nbt);
		updateRecipe();
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		writeNBT(nbt);
	}
	
	@Override
	public void handleInitPacket(NBTTagCompound nbt) {
		readNBT(nbt);
		updateRecipe();
		this.worldObj.func_147479_m(xCoord, yCoord, zCoord);
	}
	
	@Override
	public void createInitNBT(NBTTagCompound nbt) {
		writeNBT(nbt);
	}
	
	private void readNBT(NBTTagCompound nbt) {
		
		this.drawplateMetal = nbt.getString("drawplateMetal");
		this.wireMetal = nbt.getString("wireMetal");
		this.isHeadBlock = nbt.getBoolean("isHeadBlock");
		this.isLubricated = nbt.getBoolean("isLubricated");
		this.drawing = nbt.getBoolean("drawing");
		this.finished = nbt.getBoolean("finished");
		this.progress = nbt.getByte("progress");
		this.rotation = nbt.getByte("rotation");
		this.working = nbt.getByte("working");
		
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		storage = new ItemStack[getSizeInventory()];
		for (int i = 0; i < nbttaglist.tagCount(); i++) {
			NBTTagCompound slottag = nbttaglist.getCompoundTagAt(i);
			byte slot = slottag.getByte("Slot");
			if (slot >= 0 && slot < storage.length)
				storage[slot] = ItemStack.loadItemStackFromNBT(slottag);
		}
	}
	
	private void writeNBT(NBTTagCompound nbt) {
		
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {
				NBTTagCompound slottag = new NBTTagCompound();
				slottag.setByte("Slot", (byte) i);
				storage[i].writeToNBT(slottag);
				nbttaglist.appendTag(slottag);
			}
		}
		nbt.setTag("Items", nbttaglist);
		
		nbt.setString("drawplateMetal", drawplateMetal == null ? "" : drawplateMetal);
		nbt.setString("wireMetal", wireMetal == null ? "" : wireMetal);
		nbt.setBoolean("isHeadBlock", isHeadBlock);
		nbt.setBoolean("isLubricated", isLubricated);
		nbt.setBoolean("drawing", drawing);
		nbt.setBoolean("finished", finished);
		nbt.setByte("progress", progress);
		nbt.setByte("rotation", rotation);
		nbt.setByte("working", working);
	}
	
	@Override
	public void updateEntity() {
		if (isWorking()) {
			this.working--;
			this.progress++;
			if (this.isLubricated) {
				this.progress++;
			}
			
			if(this.working <= 0 || this.progress >= 100) {
				NBTTagCompound nbt = new NBTTagCompound();
				this.working = 0;
				this.writeToNBT(nbt);
				this.broadcastPacketInRange(this.createDataPacket(nbt));
			}
			this.worldObj.func_147479_m(xCoord, yCoord, zCoord);
			this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
		
		if (this.progress >= 100) {
			this.finishDrawing();
		}
	}
	
	public boolean isWorking() {
		return this.working > 0;
	}
	
	public void setWorking() {
		this.working = 25;
		if(!worldObj.isRemote){
			this.updateWireDrawBench();
		}
	}
	
	public ModelWireDrawBench getModel() {
		if (worldObj.isRemote) {
			return model;
		}
		return null;
	}
	
	public void setModel(ModelWireDrawBench m) {
		if (worldObj.isRemote) {
			model = m;
		}
	}
	
	public ResourceLocation getResource() {
		return new ResourceLocation(ModDetails.ModID, "textures/blocks/devices/WireDrawBenchModel.png");
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
	public void setInventorySlotContents(int slot, ItemStack is) {
		storage[slot] = is;
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
	public String getInventoryName() {
		return "Wire Draw Bench";
	}
	
	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 1;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return false;
	}
	
	@Override
	public void openInventory() {
	}
	
	@Override
	public void closeInventory() {
	}
	
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack is) {
		return false;
	}
}
