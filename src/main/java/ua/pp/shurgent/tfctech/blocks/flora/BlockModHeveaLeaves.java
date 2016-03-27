package ua.pp.shurgent.tfctech.blocks.flora;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import ua.pp.shurgent.tfctech.Globals;
import ua.pp.shurgent.tfctech.core.ModBlocks;
import ua.pp.shurgent.tfctech.core.ModDetails;

import com.bioxx.tfc.Blocks.Vanilla.BlockCustomLeaves;

public class BlockModHeveaLeaves extends BlockCustomLeaves {

	public BlockModHeveaLeaves() {
		int size = Globals.WOOD_ALL.length;
		this.woodNames = new String[size];
		System.arraycopy(Globals.WOOD_ALL, 0, this.woodNames, 0, size);
		this.icons = new IIcon[size];
		this.iconsOpaque = new IIcon[size];
	}

	public void onNeighborBlockChange(World world, int xOrig, int yOrig, int zOrig, Block b) {
		if (!world.isRemote) {
			int meta = world.getBlockMetadata(xOrig, yOrig, zOrig);

			byte searchRadius = 4;
			int maxDist = searchRadius + 1;
			byte searchDistance = 11;
			int center = searchDistance / 2;
			adjacentTreeBlocks = null;
			if (this.adjacentTreeBlocks == null)
				this.adjacentTreeBlocks = new int[searchDistance][searchDistance][searchDistance];

			if (world.checkChunksExist(xOrig - maxDist, yOrig - maxDist, zOrig - maxDist, xOrig + maxDist, yOrig + maxDist, zOrig + maxDist)) {
				for (int xd = -searchRadius; xd <= searchRadius; ++xd) {
					int searchY = searchRadius - Math.abs(xd);
					for (int yd = -searchY; yd <= searchY; ++yd) {
						int searchZ = searchY - Math.abs(yd);
						for (int zd = -searchZ; zd <= searchZ; ++zd) {
							Block block = world.getBlock(xOrig + xd, yOrig + yd, zOrig + zd);

							if (block instanceof BlockModHeveaNatural && block != ModBlocks.logHeveaNaturalDead)
								this.adjacentTreeBlocks[xd + center][yd + center][zd + center] = 0;
							//else if (block == this && meta == world.getBlockMetadata(xOrig + xd, yOrig + yd, zOrig + zd))
							else if (block == this && meta == 0)
								this.adjacentTreeBlocks[xd + center][yd + center][zd + center] = -2;
							else
								this.adjacentTreeBlocks[xd + center][yd + center][zd + center] = -1;
						}
					}
				}

				for (int pass = 1; pass <= 4; ++pass) {
					for (int xd = -searchRadius; xd <= searchRadius; ++xd) {
						int searchY = searchRadius - Math.abs(xd);
						for (int yd = -searchY; yd <= searchY; ++yd) {
							int searchZ = searchY - Math.abs(yd);
							for (int zd = -searchZ; zd <= searchZ; ++zd) {
								if (this.adjacentTreeBlocks[xd + center][yd + center][zd + center] == pass - 1) {
									if (this.adjacentTreeBlocks[xd + center - 1][yd + center][zd + center] == -2)
										this.adjacentTreeBlocks[xd + center - 1][yd + center][zd + center] = pass;

									if (this.adjacentTreeBlocks[xd + center + 1][yd + center][zd + center] == -2)
										this.adjacentTreeBlocks[xd + center + 1][yd + center][zd + center] = pass;

									if (this.adjacentTreeBlocks[xd + center][yd + center - 1][zd + center] == -2)
										this.adjacentTreeBlocks[xd + center][yd + center - 1][zd + center] = pass;

									if (this.adjacentTreeBlocks[xd + center][yd + center + 1][zd + center] == -2)
										this.adjacentTreeBlocks[xd + center][yd + center + 1][zd + center] = pass;

									if (this.adjacentTreeBlocks[xd + center][yd + center][zd + center - 1] == -2)
										this.adjacentTreeBlocks[xd + center][yd + center][zd + center - 1] = pass;

									if (this.adjacentTreeBlocks[xd + center][yd + center][zd + center + 1] == -2)
										this.adjacentTreeBlocks[xd + center][yd + center][zd + center + 1] = pass;
								}
							}
						}
					}
				}
			}

			int res = this.adjacentTreeBlocks[center][center][center];

			if (res < 0) {
				if (world.getChunkFromBlockCoords(xOrig, zOrig) != null)
					this.destroyLeaves(world, xOrig, yOrig, zOrig);
			}
		}
	}

	private void destroyLeaves(World world, int x, int y, int z) {
		world.setBlockToAir(x, y, z);
	}

	@Override
	public Item getItemDropped(int i, Random rand, int j) {
		return Item.getItemFromBlock(ModBlocks.heveaSapling);
	}

	@Override
	protected void dropSapling(World world, int x, int y, int z, int meta) {
		dropBlockAsItem(world, x, y, z, new ItemStack(this.getItemDropped(0, null, 0), 1, meta));
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegisterer) {
		for (int i = 0; i < this.woodNames.length; i++) {
			this.icons[i] = iconRegisterer.registerIcon(ModDetails.ModID + ":" + "wood/trees/" + this.woodNames[i] + " Leaves Fancy");
			this.iconsOpaque[i] = iconRegisterer.registerIcon(ModDetails.ModID + ":" + "wood/trees/" + this.woodNames[i] + " Leaves");
		}
	}

}
