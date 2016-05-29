package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power;

import net.minecraft.item.Item;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.integration.bc.ModPipeIconProvider;
import buildcraft.api.core.IIconProvider;
import buildcraft.transport.pipes.PipePowerEmerald;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PipePowerRedSteel extends PipePowerEmerald {

	public PipePowerRedSteel(Item item) {
		super(item);
		standardIconIndex = ModPipeIconProvider.TYPE.PipePowerRedSteel_Standard.ordinal();
		solidIconIndex = ModPipeIconProvider.TYPE.PipeAllRedSteel_Solid.ordinal();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIconProvider getIconProvider() {
		return BCStuff.pipeIconProvider;
	}

}
