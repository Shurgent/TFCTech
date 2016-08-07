package ua.pp.shurgent.tfctech.items.ItemBlocks;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.blocks.devices.BlockWireDrawBench;
import ua.pp.shurgent.tfctech.core.ModBlocks;
import ua.pp.shurgent.tfctech.core.ModDetails;

import com.bioxx.tfc.Items.ItemTerra;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;

public class ItemWireDrawBench extends ItemTerra {
	
	public ItemWireDrawBench() {
		super();
		this.setFolder("devices/");
		this.setCreativeTab(TFCTech.TFCTECH);
		this.setSize(EnumSize.HUGE);
		this.setWeight(EnumWeight.HEAVY);
	}
	
	@Override
	public void registerIcons(IIconRegister registerer) {
		this.itemIcon = registerer.registerIcon(ModDetails.ModID + ":" + this.textureFolder + this.getUnlocalizedName().replace("item.", ""));
	}
	
	@Override
	public boolean onItemUse(ItemStack is, EntityPlayer ep, World world, int x, int y, int z, int side, float f1, float f2, float f3) {
		if (world.isRemote) {
			return true;
		} else if (side != 1) {
			return false;
		} else {
			++y;
			BlockWireDrawBench block = (BlockWireDrawBench) ModBlocks.wireDrawBench;
			int dir = MathHelper.floor_double((double) (ep.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			int[] offset = BlockWireDrawBench.BLOCKMAP[dir];
			
			byte offX = (byte) offset[0];
			byte offZ = (byte) offset[1];
			
			if (ep.canPlayerEdit(x, y, z, side, is) && ep.canPlayerEdit(x + offX, y, z + offZ, side, is)) {
				if (block.canPlace(world, x, y, z) && block.canPlace(world, x + offX, y, z + offZ)) {
					world.setBlock(x, y, z, block, dir, 3);
					
					block.onBlockPlacedBy(world, x, y, z, ep, is);
					
					--is.stackSize;
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}
}
