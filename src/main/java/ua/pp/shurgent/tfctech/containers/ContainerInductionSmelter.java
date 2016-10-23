package ua.pp.shurgent.tfctech.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ua.pp.shurgent.tfctech.containerslots.SlotMolds;
import ua.pp.shurgent.tfctech.tileentities.TEInductionSmelter;

import com.bioxx.tfc.Containers.ContainerTFC;
import com.bioxx.tfc.Core.Player.PlayerInventory;
import com.bioxx.tfc.Items.ItemMeltedMetal;
import com.bioxx.tfc.api.TFCItems;

public class ContainerInductionSmelter extends ContainerTFC {
	
	private TEInductionSmelter te;
	private float curTemp;
	private float curEnergy;
	private float curMaxTemp;
	private float curHeating;
	private float curMetalAmount;
	
	public ContainerInductionSmelter(InventoryPlayer inventoryplayer, TEInductionSmelter tileentitysmelter, World world, int x, int y, int z) {
		te = tileentitysmelter;
		curTemp = -1000;
		curEnergy = -1000;
		curMaxTemp = -1000;
		curHeating = -1;
		curMetalAmount = -1000;
		
		// Input slot
		addSlotToContainer(new Slot(tileentitysmelter, 0, 152, 7) {
			@Override
			public boolean isItemValid(ItemStack itemstack) {
				return !(itemstack.getItem() == TFCItems.rawBloom || itemstack.getItem() == TFCItems.bloom && itemstack.getItemDamage() > 100);
			}
		});
		
		// Output slot
		addSlotToContainer(new Slot(tileentitysmelter, 1, 152, 142) {
			@Override
			public boolean isItemValid(ItemStack itemstack) {
				return false;
			}
		});
		
		// Mold slot
		addSlotToContainer(new SlotMolds(tileentitysmelter, 2, 152, 112));
		
		PlayerInventory.buildInventoryLayout(this, inventoryplayer, 8, 171, false, true);
		
		te.updateGui((byte) 0);
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}
	
	@Override
	public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
		ItemStack origStack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotNum);
		
		if (slot != null && slot.getHasStack()) {
			ItemStack slotStack = slot.getStack();
			origStack = slotStack.copy();
			
			// From smelter to inventory
			if (slotNum < 3) {
				if (!this.mergeItemStack(slotStack, 3, inventorySlots.size(), true))
					return null;
			}
			// Ceramic molds into mold slot
			else if (slotStack.getItem() == TFCItems.ceramicMold && slotStack.getItemDamage() == 1 || slotStack.getItem() instanceof ItemMeltedMetal) {
				if (!this.mergeItemStack(slotStack, 2, 3, true))
					return null;
			}
			// To input slot
			else {
				if (!this.mergeItemStack(slotStack, 0, 1, true))
					return null;
			}
			
			if (slotStack.stackSize <= 0)
				slot.putStack(null);
			else
				slot.onSlotChanged();
			
			if (slotStack.stackSize == origStack.stackSize)
				return null;
			
			slot.onPickupFromSlot(player, slotStack);
		}
		
		return origStack;
	}
	
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for (int var1 = 0; var1 < this.crafters.size(); ++var1) {
			ICrafting var2 = (ICrafting) this.crafters.get(var1);
			if (this.curTemp != this.te.temperature)
				var2.sendProgressBarUpdate(this, 0, this.te.temperature);
			if (this.curEnergy != this.te.getEnergyStored(null))
				var2.sendProgressBarUpdate(this, 1, this.te.getEnergyStored(null));
			if (this.curMaxTemp != this.te.maxTemp)
				var2.sendProgressBarUpdate(this, 2, this.te.maxTemp);
			if (this.curHeating != (this.te.heating ? 1 : 0))
				var2.sendProgressBarUpdate(this, 3, (this.te.heating ? 1 : 0));
			if (this.te.currentAlloy != null && this.curMetalAmount != this.te.currentAlloy.outputAmount)
				var2.sendProgressBarUpdate(this, 4, (int) this.te.currentAlloy.outputAmount);
			
		}
		
		this.curTemp = this.te.temperature;
		this.curEnergy = this.te.getEnergyStored(null);
		this.curMaxTemp = this.te.maxTemp;
		this.curHeating = (this.te.heating ? 1 : 0);
	}
	
	@Override
	public void updateProgressBar(int id, int value) {
		
		if (te != null) {
			if (id == 0)
				this.te.temperature = value;
			else if (id == 1)
				this.te.energy = value;
			else if (id == 2) {
				this.te.maxTemp = value;
				this.te.minTemp = value - 200;
			} else if (id == 3)
				this.te.heating = (value == 1 ? true : false);
			else if (id == 4 && this.te.currentAlloy != null)
				this.te.currentAlloy.outputAmount = value;
		}
	}
	
	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		te.closeInventory();
	}
}
