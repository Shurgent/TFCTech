package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport;

import java.util.Collection;
import java.util.LinkedList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.ModPipeIconProvider;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.handlers.PipeItemsInsertionHandler;
import buildcraft.api.core.EnumColor;
import buildcraft.api.core.IIconProvider;
import buildcraft.api.statements.IActionInternal;
import buildcraft.api.statements.StatementSlot;
import buildcraft.transport.pipes.PipeItemsLapis;
import buildcraft.transport.pipes.events.PipeEventItem;

public class PipeItemsMarker extends PipeItemsLapis {

	public PipeItemsMarker(Item item) {
		super(item);
	}

	@Override
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		if (container == null) {
			return ModPipeIconProvider.TYPE.PipeItemsMarker_Black.ordinal();
		}
		return ModPipeIconProvider.TYPE.PipeItemsMarker_Black.ordinal() + container.getBlockMetadata();
	}

	@Override
	public boolean blockActivated(EntityPlayer player, ForgeDirection direction) {
		return super.blockActivated(player, direction);
	}

	public EnumColor getColor() {
		return super.getColor();
	}

	public void setColor(EnumColor color) {
		super.setColor(color);
	}

	public void eventHandler(PipeEventItem.ReachedCenter event) {
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

	public void eventHandler(PipeEventItem.Entered event) {
		event.item.setInsertionHandler(PipeItemsInsertionHandler.INSTANCE);
	}
}
