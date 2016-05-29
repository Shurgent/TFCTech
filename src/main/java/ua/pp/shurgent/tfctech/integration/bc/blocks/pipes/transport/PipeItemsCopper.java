package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.ModPipeIconProvider;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.handlers.PipeItemsInsertionHandler;
import buildcraft.api.core.IIconProvider;
import buildcraft.transport.pipes.PipeItemsWood;
import buildcraft.transport.pipes.events.PipeEventItem;
import cofh.api.energy.IEnergyHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PipeItemsCopper extends PipeItemsWood implements IEnergyHandler {

	public PipeItemsCopper(Item item) {
		super(item);
		standardIconIndex = ModPipeIconProvider.TYPE.PipeItemsCopper_Standard.ordinal();
		solidIconIndex = ModPipeIconProvider.TYPE.PipeAllCopper_Solid.ordinal();
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
	@SideOnly(Side.CLIENT)
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		return super.getIconIndex(direction);
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
	}

	public void onPostTick() {
		super.onPostTick();
	}

	public ItemStack[] checkExtract(IInventory inventory, boolean doRemove, ForgeDirection from) {
		return super.checkExtract(inventory, doRemove, from);
	}

	public ItemStack checkExtractGeneric(IInventory inventory, boolean doRemove, ForgeDirection from) {
		return super.checkExtractGeneric(inventory, doRemove, from);
	}

	public ItemStack checkExtractGeneric(ISidedInventory inventory, boolean doRemove, ForgeDirection from) {
		return super.checkExtractGeneric(inventory, doRemove, from);
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
		return super.getEnergyStored(from);
	}

	public void eventHandler(PipeEventItem.Entered event) {
		event.item.setInsertionHandler(PipeItemsInsertionHandler.INSTANCE);
	}
}
