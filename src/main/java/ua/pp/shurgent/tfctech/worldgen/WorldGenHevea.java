package ua.pp.shurgent.tfctech.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.bioxx.tfc.Core.TFC_Climate;
import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.WorldGen.TFCBiome;
import com.bioxx.tfc.api.Constant.Global;

import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenHevea implements IWorldGenerator {

	private float evt;
	private float rainfall;
	private float temperature = 20f;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		chunkX *= 16;
		chunkZ *= 16;

		if (world.getBiomeGenForCoords(chunkX, chunkZ) instanceof TFCBiome) // Fixes ClassCastException
		{
			TFCBiome biome = (TFCBiome) world.getBiomeGenForCoords(chunkX, chunkZ);
			if (biome == TFCBiome.OCEAN || biome == TFCBiome.DEEP_OCEAN)
				return;

			rainfall = TFC_Climate.getRainfall(world, chunkX, 0, chunkZ);
			evt = TFC_Climate.getCacheManager(world).getEVTLayerAt(chunkX + 8, chunkZ + 8).floatdata1;
			generateTree(random, chunkX, chunkZ, world);
		}
	}

	private void generateTree(Random random, int chunkX, int chunkZ, World world) {
		WorldGenerator gen = new WorldGenHeveaTree();
		int xCoord = chunkX;
		int yCoord = Global.SEALEVEL + 1;
		int zCoord = chunkZ;

		int numTrees = 1;
		if (random.nextInt(20) == 0)
			numTrees += random.nextInt(3);

		for (int var2 = 0; var2 < numTrees; ++var2) {
			xCoord = chunkX + random.nextInt(16);
			zCoord = chunkZ + random.nextInt(16);
			yCoord = world.getHeightValue(xCoord, zCoord);

			temperature = TFC_Climate.getBioTemperatureHeight(world, xCoord, world.getHeightValue(xCoord, zCoord), zCoord);
			int spawnChance = this.treeSpawnChance();

			if (getNearWater(world, xCoord, yCoord, zCoord)) {
				rainfall *= 2;
				evt /= 2;
			}

			if (random.nextInt(100) < spawnChance) {
				gen.generate(world, random, xCoord, yCoord, zCoord);
			}
		}
	}

	private int treeSpawnChance() {
		float treeEVTMin = 0;
		float treeEVTMax = 2f;

		float treeRainMin = 1500f;
		float treeRainMax = 2000f;

		float treeTempMin = 25;
		float treeTempMax = 30;

		int out = 0;

		if (temperature >= treeTempMin && temperature <= treeTempMax)
			out += 10;
		if (rainfall >= treeRainMin && rainfall <= treeRainMax)
			out += 10;
		if (rainfall >= 500 && rainfall < treeRainMin)
			out += 5;
		if (evt < treeEVTMin || evt > treeEVTMax)
			out += -1;

		return out;
	}

	public boolean getNearWater(World world, int x, int y, int z) {
		for (int x1 = -4; x1 < 5; ++x1) {
			for (int z1 = -4; z1 < 5; ++z1) {
				for (int y1 = -2; y1 < 1; ++y1) {
					if (world.blockExists(x + x1, y + y1, z + z1) && TFC_Core.isWater(world.getBlock(x + x1, y + y1, z + z1)))
						return true;
				}
			}
		}
		return false;
	}
}
