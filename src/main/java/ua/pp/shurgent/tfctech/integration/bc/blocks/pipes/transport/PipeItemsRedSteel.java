package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.ModPipeIconProvider;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.handlers.PipeItemsInsertionHandler;
import buildcraft.api.core.IIconProvider;
import buildcraft.api.core.ISerializable;
import buildcraft.core.lib.network.IGuiReturnHandler;
import buildcraft.transport.pipes.PipeItemsEmerald;
import buildcraft.transport.pipes.events.PipeEventItem;

public class PipeItemsRedSteel extends PipeItemsEmerald implements ISerializable, IGuiReturnHandler {

	public PipeItemsRedSteel(Item item) {
		super(item);
		standardIconIndex = ModPipeIconProvider.TYPE.PipeItemsRedSteel_Standard.ordinal();
		solidIconIndex = ModPipeIconProvider.TYPE.PipeAllRedSteel_Solid.ordinal();
	}

	@Override
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

	@Override
	public boolean blockActivated(EntityPlayer entityplayer, ForgeDirection side) {
		return super.blockActivated(entityplayer, side);
	}

	@Override
	public ItemStack[] checkExtract(IInventory inventory, boolean doRemove, ForgeDirection from) {
		return super.checkExtract(inventory, doRemove, from);
	}

	public IInventory getFilters() {
		return super.getFilters();
	}

	public EmeraldPipeSettings getSettings() {
		return super.getSettings();
	}

	@Override
	public void writeData(ByteBuf data) {
		super.writeData(data);
	}

	@Override
	public void readData(ByteBuf data) {
		super.readData(data);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
	}

	@Override
	public void writeGuiData(ByteBuf data) {
		super.writeGuiData(data);
	}

	@Override
	public void readGuiData(ByteBuf data, EntityPlayer sender) {
		super.readGuiData(data, sender);
	}

	public void eventHandler(PipeEventItem.Entered event) {
		event.item.setInsertionHandler(PipeItemsInsertionHandler.INSTANCE);
	}
}
