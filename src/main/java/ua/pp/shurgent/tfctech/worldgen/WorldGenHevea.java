package ua.pp.shurgent.tfctech.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import ua.pp.shurgent.tfctech.core.ModOptions;

import com.bioxx.tfc.Core.TFC_Climate;
import com.bioxx.tfc.WorldGen.TFCBiome;
import com.bioxx.tfc.api.Constant.Global;

import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenHevea implements IWorldGenerator {

	private float evt;
	private float rainfall;
	private float temperature = 20f;
	private int tl0;
	private int tl1;
	private int tl2;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		chunkX *= 16;
		chunkZ *= 16;

		if (world.getBiomeGenForCoords(chunkX, chunkZ) instanceof TFCBiome) // Fixes ClassCastException
		{
			TFCBiome biome = (TFCBiome) world.getBiomeGenForCoords(chunkX, chunkZ);
			if (biome == TFCBiome.OCEAN || biome == TFCBiome.DEEP_OCEAN)
				return;

			tl0 = TFC_Climate.getTreeLayer(world, chunkX, Global.SEALEVEL, chunkZ, 0);
			tl1 = TFC_Climate.getTreeLayer(world, chunkX, Global.SEALEVEL, chunkZ, 1);
			tl2 = TFC_Climate.getTreeLayer(world, chunkX, Global.SEALEVEL, chunkZ, 2);
			// If at least one tree layer present, otherwise no Heveas
			if (tl0 == -1 && tl1 == -1 && tl2 == -1)
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

		int out = ModOptions.cfgHeveaSpawnChanceBase;

		boolean idealTemp = temperature >= treeTempMin && temperature <= treeTempMax;
		boolean idealRainfall = rainfall >= treeRainMin && rainfall <= treeRainMax;
		boolean idealEVT = evt >= treeEVTMin && evt <= treeEVTMax;
		
		if (idealTemp && idealRainfall && idealEVT) // Ideal climate conditions
			return out + ModOptions.cfgHeveaSpawnChanceIncIdealClimate;
		
		if (idealTemp)
			out += ModOptions.cfgHeveaSpawnChanceIncIdealTemp;
		if (idealRainfall)
			out += ModOptions.cfgHeveaSpawnChanceIncIdealRain;
		if (rainfall >= 500 && rainfall < treeRainMin)
			out += ModOptions.cfgHeveaSpawnChanceIncRain500;
		if (idealEVT)
			out += ModOptions.cfgHeveaSpawnChanceIncIdealEVT;

		return out;
	}

}
