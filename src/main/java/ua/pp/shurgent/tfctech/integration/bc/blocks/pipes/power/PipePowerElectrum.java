package ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.core.ModPipeIconProvider;
import buildcraft.api.core.IIconProvider;
import buildcraft.transport.pipes.PipePowerGold;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PipePowerElectrum extends PipePowerGold {

	public PipePowerElectrum(Item item) {
		super(item);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIconProvider getIconProvider() {
		return TFCTech.instance.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		return ModPipeIconProvider.TYPE.PipePowerElectrum.ordinal();
	}
}
