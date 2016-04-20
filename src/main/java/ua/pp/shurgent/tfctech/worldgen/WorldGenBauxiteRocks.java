package ua.pp.shurgent.tfctech.worldgen;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import ua.pp.shurgent.tfctech.blocks.terrain.BlockModOre;
import ua.pp.shurgent.tfctech.core.ModBlocks;

import com.bioxx.tfc.TileEntities.TEWorldItem;
import com.bioxx.tfc.WorldGen.TFCBiome;
import com.bioxx.tfc.api.TFCBlocks;

import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenBauxiteRocks implements IWorldGenerator {

	public WorldGenBauxiteRocks() {
	}

	private boolean generateRocks(World world, Random random, int i, int j, int k) {
		if ((world.isAirBlock(i, j + 1, k) || world.getBlock(i, j + 1, k) == Blocks.snow || world.getBlock(i, j + 1, k) == TFCBlocks.tallGrass)
				&& (world.getBlock(i, j, k).getMaterial() == Material.grass || world.getBlock(i, j, k).getMaterial() == Material.rock)
				&& world.getBlock(i, j, k).isOpaqueCube()) {
			if (world.rand.nextInt(3) == 0) {
				ItemStack is = getCoreSample(world, i, j, k);
				if (is != null) {
					if (world.setBlock(i, j + 1, k, TFCBlocks.worldItem, 0, 2)) {
						TEWorldItem te = (TEWorldItem) world.getTileEntity(i, j + 1, k);
						te.storage[0] = is;
					}
				}
			}
		}
		return true;
	}

	private ItemStack getCoreSample(World world, int xCoord, int yCoord, int zCoord) {
		Item it = null;
		ItemStack is = null;
		int x1 = (xCoord >> 4) << 4;
		int z1 = (zCoord >> 4) << 4;
		for (int x = 0; x <= 15; x++) {
			for (int z = 0; z <= 15; z++) {
				for (int y = yCoord; y > yCoord - 35; y--) {
					if (world.getBlock(x1 + x, y, z1 + z) == ModBlocks.ore) {
						int m = world.getBlockMetadata(x1 + x, y, z1 + z);
						it = BlockModOre.getDroppedItem(m);
						is = new ItemStack(it, 1, m);
						return is;
					}
				}
			}
		}
		return is;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		chunkX *= 16;
		chunkZ *= 16;

		if (world.getBiomeGenForCoords(chunkX, chunkZ) instanceof TFCBiome) // Fixes ClassCastException
		{
			TFCBiome biome = (TFCBiome) world.getBiomeGenForCoords(chunkX, chunkZ);
			if (biome == TFCBiome.OCEAN || biome == TFCBiome.DEEP_OCEAN)
				return;
		}

		// ore
		for (int var2 = 0; var2 < 8; var2++) {
			int var7 = chunkX + random.nextInt(16) + 8;
			int var3 = chunkZ + random.nextInt(16) + 8;
			generateRocks(world, random, var7, world.getTopSolidOrLiquidBlock(var7, var3) - 1, var3);
		}
	}

}
