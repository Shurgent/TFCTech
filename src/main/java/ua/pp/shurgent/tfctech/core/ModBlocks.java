package ua.pp.shurgent.tfctech.core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.blocks.devices.BlockInductionSmelter;
import ua.pp.shurgent.tfctech.blocks.devices.BlockLatexExtractor;
import ua.pp.shurgent.tfctech.blocks.devices.BlockWireDrawBench;
import ua.pp.shurgent.tfctech.blocks.flora.BlockModHeveaHoriz;
import ua.pp.shurgent.tfctech.blocks.flora.BlockModHeveaLeaves;
import ua.pp.shurgent.tfctech.blocks.flora.BlockModHeveaNatural;
import ua.pp.shurgent.tfctech.blocks.flora.BlockModHeveaSapling;
import ua.pp.shurgent.tfctech.blocks.flora.BlockModHeveaVert;
import ua.pp.shurgent.tfctech.blocks.flora.ItemModSapling;
import ua.pp.shurgent.tfctech.blocks.liquids.BlockLatex;
import ua.pp.shurgent.tfctech.blocks.terrain.BlockModOre;
import ua.pp.shurgent.tfctech.items.ItemBlocks.ItemModCustomWood;
import ua.pp.shurgent.tfctech.items.ItemBlocks.ItemModCustomWoodH;
import ua.pp.shurgent.tfctech.items.ItemBlocks.ItemModOreBlock;

import com.bioxx.tfc.Core.TFCTabs;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	// Blocks Render Id's
	public static int oreRenderId;
	public static int latexExtractorRenderId;
	public static int wireDrawBenchRenderId;
	public static int inductionSmelterRenderId;

	// Blocks
	public static Block ore;

	public static Block logHeveaNatural;
	public static Block logHeveaNatural1;
	public static Block logHeveaNatural2;
	public static Block logHeveaNatural3;
	public static Block logHeveaNaturalDead;
	public static Block logHeveaVert;
	public static Block logHeveaHoriz;
	public static Block heveaLeaves;
	public static Block heveaSapling;

	// Fluids
	public static Block latex;

	// Devices
	public static Block latexExtractor;
	public static Block wireDrawBench;
	public static Block inductionSmelter;

	public static void initialise() {
		TFCTech.LOG.info("Registering Blocks");

		loadBlocks();
		registerBlocks();
		setupFire();

		TFCTech.LOG.info("Done Registering Blocks");
	}

	private static void setupFire() {
		Blocks.fire.setFireInfo(latex, 300, 5);
		Blocks.fire.setFireInfo(logHeveaNatural, 5, 5);
		Blocks.fire.setFireInfo(logHeveaNatural1, 5, 5);
		Blocks.fire.setFireInfo(logHeveaNatural2, 5, 5);
		Blocks.fire.setFireInfo(logHeveaNatural3, 5, 5);
		Blocks.fire.setFireInfo(logHeveaNaturalDead, 50, 5);
		Blocks.fire.setFireInfo(logHeveaVert, 5, 5);
		Blocks.fire.setFireInfo(logHeveaHoriz, 5, 5);
		Blocks.fire.setFireInfo(wireDrawBench, 5, 5);
	}

	private static void loadBlocks() {

		ore = new BlockModOre(Material.rock).setHardness(10F).setResistance(10F).setBlockName("Ore");
		ore.setHarvestLevel("pickaxe", 1);

		logHeveaNatural = new BlockModHeveaNatural(0).setHardness(50.0F).setStepSound(Block.soundTypeWood).setBlockName("Hevea");
		logHeveaNatural1 = new BlockModHeveaNatural(1).setHardness(50.0F).setStepSound(Block.soundTypeWood).setBlockName("Hevea1");
		logHeveaNatural2 = new BlockModHeveaNatural(2).setHardness(50.0F).setStepSound(Block.soundTypeWood).setBlockName("Hevea2");
		logHeveaNatural3 = new BlockModHeveaNatural(3).setHardness(50.0F).setStepSound(Block.soundTypeWood).setBlockName("Hevea3");
		logHeveaNaturalDead = new BlockModHeveaNatural(4).setHardness(50.0F).setStepSound(Block.soundTypeWood).setBlockName("HeveaDead");
		logHeveaVert = new BlockModHeveaVert().setBlockName("Hevea").setHardness(20).setResistance(15F).setStepSound(Block.soundTypeWood);
		logHeveaHoriz = new BlockModHeveaHoriz().setBlockName("Hevea").setHardness(20).setResistance(15F).setStepSound(Block.soundTypeWood);
		heveaLeaves = new BlockModHeveaLeaves().setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("leaves").setCreativeTab(TFCTabs.TFC_DECORATION);
		heveaSapling = new BlockModHeveaSapling().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("sapling");

		latex = new BlockLatex(ModFluids.LATEX).setHardness(100.0F).setBlockName("Latex");
		
		latexExtractor = new BlockLatexExtractor().setBlockName("LatexExtractor").setHardness(2);
		wireDrawBench = new BlockWireDrawBench().setBlockName("WireDrawBench").setHardness(2).setResistance(20F).setStepSound(Block.soundTypeWood);
		inductionSmelter = new BlockInductionSmelter().setBlockName("InductionSmelter").setHardness(4);
		
	}

	private static void registerBlocks() {
		GameRegistry.registerBlock(ore, ItemModOreBlock.class, "Ore4");
		GameRegistry.registerBlock(latex, "Latex");
		
		GameRegistry.registerBlock(latexExtractor, "LatexExtractor");
		GameRegistry.registerBlock(wireDrawBench, "WireDrawBench");
		GameRegistry.registerBlock(inductionSmelter, "InductionSmelter");

		GameRegistry.registerBlock(logHeveaNatural, ItemModCustomWood.class, "Hevea");
		GameRegistry.registerBlock(logHeveaNatural1, ItemModCustomWood.class, "Hevea1");
		GameRegistry.registerBlock(logHeveaNatural2, ItemModCustomWood.class, "Hevea2");
		GameRegistry.registerBlock(logHeveaNatural3, ItemModCustomWood.class, "Hevea3");
		GameRegistry.registerBlock(logHeveaNaturalDead, ItemModCustomWood.class, "HeveaDead");
		GameRegistry.registerBlock(logHeveaVert, ItemModCustomWood.class, "HeveaV");
		GameRegistry.registerBlock(logHeveaHoriz, ItemModCustomWoodH.class, "HeveaH");
		GameRegistry.registerBlock(heveaLeaves, ItemModCustomWood.class, "HeveaL");
		GameRegistry.registerBlock(heveaSapling, ItemModSapling.class, "HeveaS");
	}
}
