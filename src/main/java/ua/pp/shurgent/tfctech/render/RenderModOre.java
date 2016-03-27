package ua.pp.shurgent.tfctech.render;

import net.minecraft.block.Block;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import ua.pp.shurgent.tfctech.tileentities.TEModOre;

import com.bioxx.tfc.Render.Blocks.RenderOre;

public class RenderModOre extends RenderOre {

	public RenderModOre() {

	}

	public static IIcon getRockTexture(World worldObj, int xCoord, int yCoord, int zCoord) {
		TEModOre te = (TEModOre) worldObj.getTileEntity(xCoord, yCoord, zCoord);
		if (te != null && te.baseBlockID > 0) {
			return Block.getBlockById(te.baseBlockID).getIcon(5, te.baseBlockMeta);
		}
		return null;
	}

}
