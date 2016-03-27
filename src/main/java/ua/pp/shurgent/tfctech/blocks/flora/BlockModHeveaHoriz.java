package ua.pp.shurgent.tfctech.blocks.flora;

import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import ua.pp.shurgent.tfctech.Globals;
import ua.pp.shurgent.tfctech.core.ModBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModHeveaHoriz extends BlockModHeveaVert {

	public BlockModHeveaHoriz() {
		super();
		int size = Globals.WOOD_ALL.length;
		woodNames = new String[size];
		System.arraycopy(Globals.WOOD_ALL, 0, woodNames, 0, size);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		int dir = meta >> 3;
		meta = (meta & 7); // NOPMD

		if (dir == 0) {
			if (side == 0 || side == 1)
				return ((BlockModHeveaNatural) ModBlocks.logHeveaNatural).sideIcons[meta];
			else if (side == 2 || side == 3)
				return ((BlockModHeveaNatural) ModBlocks.logHeveaNatural).innerIcons[meta];
			else
				return ((BlockModHeveaNatural) ModBlocks.logHeveaNatural).rotatedSideIcons[meta];
		} else {
			if (side == 0 || side == 1 || side == 2 || side == 3)
				return ((BlockModHeveaNatural) ModBlocks.logHeveaNatural).rotatedSideIcons[meta];
			else
				return ((BlockModHeveaNatural) ModBlocks.logHeveaNatural).innerIcons[meta];
		}
	}

	@Override
	public int damageDropped(int dmg) {
		return (dmg & 7); // NOPMD
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityliving) {
		int dir = MathHelper.floor_double(entityliving.rotationYaw * 4F / 360F + 0.5D) & 3;
		int metadata = world.getBlockMetadata(x, y, z);

		if (dir == 1 || dir == 3)
			world.setBlockMetadataWithNotify(x, y, z, metadata + 8, 3);
	}
}
