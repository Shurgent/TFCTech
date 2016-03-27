package ua.pp.shurgent.tfctech.blocks.flora;

import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import ua.pp.shurgent.tfctech.Globals;
import ua.pp.shurgent.tfctech.core.ModBlocks;
import ua.pp.shurgent.tfctech.core.ModItems;

import com.bioxx.tfc.Blocks.Flora.BlockLogVert;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModHeveaVert extends BlockLogVert {

	public BlockModHeveaVert() {
		woodNames = new String[Globals.WOOD_ALL.length];
		System.arraycopy(Globals.WOOD_ALL, 0, woodNames, 0, Globals.WOOD_ALL.length);
	}

	@Override
	public Item getItemDropped(int i, Random r, int j) {
		return ModItems.logHevea;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return ModBlocks.logHeveaNatural.getIcon(side, meta);
	}
}
