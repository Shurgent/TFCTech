package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport;

import io.netty.buffer.ByteBuf;

import java.util.LinkedList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.ModPipeIconProvider;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.handlers.PipeItemsInsertionHandler;
import buildcraft.api.core.IIconProvider;
import buildcraft.api.statements.IActionInternal;
import buildcraft.core.lib.network.IGuiReturnHandler;
import buildcraft.transport.pipes.PipeItemsEmzuli;
import buildcraft.transport.pipes.events.PipeEventItem;

public class PipeItemsMarkerExtractor extends PipeItemsEmzuli implements IGuiReturnHandler {

	public PipeItemsMarkerExtractor(Item item) {
		super(item);
		standardIconIndex = ModPipeIconProvider.TYPE.PipeItemsMarkerExtractor_Standard.ordinal();
		solidIconIndex = ModPipeIconProvider.TYPE.PipeAllMarkerExtractor_Solid.ordinal();
	}

	@Override
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

	@Override
	public void onPostTick() {
		super.onPostTick();
	}

	@Override
	public boolean blockActivated(EntityPlayer entityplayer, ForgeDirection side) {
		return super.blockActivated(entityplayer, side);
	}

	@Override
	public ItemStack[] checkExtract(IInventory inventory, boolean doRemove, ForgeDirection from) {
		return super.checkExtract(inventory, doRemove, from);
	}

	@Override
	public ItemStack checkExtractGeneric(ISidedInventory inventory, boolean doRemove, ForgeDirection from) {
		return super.checkExtractGeneric(inventory, doRemove, from);
	}

	@Override
	public IInventory getFilters() {
		return super.getFilters();
	}

	@Override
	public LinkedList<IActionInternal> getActions() {
		return super.getActions();
	}

	@Override
	public void writeGuiData(ByteBuf paramDataOutputStream) {
		super.writeGuiData(paramDataOutputStream);
	}

	@Override
	public void readGuiData(ByteBuf data, EntityPlayer paramEntityPlayer) {
		super.readGuiData(data, paramEntityPlayer);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
	}

	public void eventHandler(PipeEventItem.Entered event) {
		event.item.setInsertionHandler(PipeItemsInsertionHandler.INSTANCE);
	}
}
