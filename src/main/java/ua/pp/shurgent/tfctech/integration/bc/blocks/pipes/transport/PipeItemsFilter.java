package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport;

import io.netty.buffer.ByteBuf;

import java.util.Collection;
import java.util.LinkedList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.handlers.PipeItemsInsertionHandler;
import buildcraft.api.core.EnumColor;
import buildcraft.api.core.IIconProvider;
import buildcraft.api.core.ISerializable;
import buildcraft.api.statements.IActionInternal;
import buildcraft.api.statements.StatementSlot;
import buildcraft.transport.pipes.PipeItemsDaizuli;
import buildcraft.transport.pipes.events.PipeEventItem;

public class PipeItemsFilter extends PipeItemsDaizuli implements ISerializable {

	public PipeItemsFilter(Item item) {
		super(item);
	}

	@Override
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

	public EnumColor getColor() {
		return super.getColor();
	}

	public void setColor(EnumColor c) {
		super.setColor(c);
	}

	@Override
	public boolean blockActivated(EntityPlayer player, ForgeDirection side) {
		return super.blockActivated(player, side);
	}

	@Override
	public void onBlockPlaced() {
		super.onBlockPlaced();
	}

	@Override
	public void initialize() {
		super.initialize();
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		return super.getIconIndex(direction);
	}

	@Override
	public boolean canConnectRedstone() {
		return super.canConnectRedstone();
	}

	public void eventHandler(PipeEventItem.FindDest event) {
		super.eventHandler(event);
	}

	public void eventHandler(PipeEventItem.AdjustSpeed event) {
		super.eventHandler(event);
	}

	@Override
	protected void actionsActivated(Collection<StatementSlot> actions) {
		super.actionsActivated(actions);
	}

	@Override
	public LinkedList<IActionInternal> getActions() {
		return super.getActions();
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
	public void writeData(ByteBuf data) {
		super.writeData(data);
	}

	@Override
	public void readData(ByteBuf data) {
		super.readData(data);
	}

	public void eventHandler(PipeEventItem.Entered event) {
		event.item.setInsertionHandler(PipeItemsInsertionHandler.INSTANCE);
	}
}
