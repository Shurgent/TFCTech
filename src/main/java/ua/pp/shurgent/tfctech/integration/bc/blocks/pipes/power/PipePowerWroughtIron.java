package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power;

import java.util.LinkedList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.ModPipeIconProvider;
import buildcraft.api.core.IIconProvider;
import buildcraft.api.statements.IActionInternal;
import buildcraft.core.PowerMode;
import buildcraft.transport.pipes.PipePowerIron;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PipePowerWroughtIron extends PipePowerIron {

	public PipePowerWroughtIron(Item item) {
		super(item);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		if (container == null) {
			return ModPipeIconProvider.TYPE.PipePowerWroughtIronM128.ordinal();
		}
		return ModPipeIconProvider.TYPE.PipePowerWroughtIronM2.ordinal() + container.getBlockMetadata();
	}

	@Override
	public boolean blockActivated(EntityPlayer player, ForgeDirection direction) {
		return super.blockActivated(player, direction);
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
	}

	public PowerMode getMode() {
		return super.getMode();
	}

	public void setMode(PowerMode mode) {
		super.setMode(mode);
	}

	@Override
	public LinkedList<IActionInternal> getActions() {
		return super.getActions();
	}
}
