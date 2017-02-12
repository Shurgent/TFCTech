package ua.pp.shurgent.tfctech.integration.bc;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.core.ModRecipes;
import buildcraft.BuildCraftSilicon;

import com.bioxx.tfc.api.TFCBlocks;
import com.bioxx.tfc.api.TFCItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class TFCTechBCSilicon {
	
	public static void removeRecipes() {
		
		ModRecipes.removeRecipe(new ItemStack(BuildCraftSilicon.laserBlock));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftSilicon.packagerBlock));
		for (int i = 0; i <= 5; i++) {
			ModRecipes.removeRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, i));
		}
		
	}
	
	public static void registerRecipes() {
		
		// Laser
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftSilicon.laserBlock), new Object [] {
			"PRR", "DDR", "PRR",
			'P', "plateDoubleBlackSteel",
			'D', new ItemStack(TFCItems.gemDiamond, 1, 4), //Exquisite Diamond
			'R', Items.redstone
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftSilicon.laserBlock), new Object [] {
			"RRP", "RDD", "RRP",
			'P', "plateDoubleBlackSteel",
			'D', new ItemStack(TFCItems.gemDiamond, 1, 4), //Exquisite Diamond
			'R', Items.redstone
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftSilicon.laserBlock), new Object [] {
			"RRR", "RDR", "PDP",
			'P', "plateDoubleBlackSteel",
			'D', new ItemStack(TFCItems.gemDiamond, 1, 4), //Exquisite Diamond
			'R', Items.redstone
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftSilicon.laserBlock), new Object [] {
			"PDP", "RDR", "RRR",
			'P', "plateDoubleBlackSteel",
			'D', new ItemStack(TFCItems.gemDiamond, 1, 4), //Exquisite Diamond
			'R', Items.redstone
		}));

		// Assembly Table
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, 0), new Object [] {
			"PDP", "PRP", "PGP",
			'P', "plateDoubleBlackSteel",
			'D', new ItemStack(TFCItems.gemDiamond, 1, 4), //Exquisite Diamond
			'R', Items.redstone,
			'G', ModItems.blueSteelGear
		}));

		// Integration Table
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, 2), new Object [] {
			"PEP", "PCP", "PGP",
			'P', "plateDoubleBlackSteel",
			'E', ModItems.electrumIngot,
			'C', new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 0), //Redstone Chipset
			'G', ModItems.blueSteelGear
		}));

		// Charging Table
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, 3), new Object [] {
			"PRP", "PCP", "PGP",
			'P', "plateDoubleBlackSteel",
			'R', Items.redstone,
			'C', new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 0), //Redstone Chipset
			'G', ModItems.goldGear
		}));

		// Integration Table
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, 4), new Object [] {
			"PEP", "PCP", "PGP",
			'P', "plateDoubleBlackSteel",
			'E', new ItemStack(TFCItems.gemEmerald, 1, 4), //Exquisite Emerald
			'C', new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 0), //Redstone Chipset
			'G', ModItems.blueSteelGear
		}));

		// Stamping Table
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, 5), new Object [] {
			"PWP", "PCP", "PGP",
			'P', "plateDoubleBlackSteel",
			'W', TFCBlocks.workbench,
			'C', new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 0), //Redstone Chipset
			'G', ModItems.goldGear
		}));

		// Stamping Table
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftSilicon.packagerBlock), new Object [] {
			" S ", "SWS", " P ",
			'S', "plateDoubleSteel",
			'W', TFCBlocks.workbench,
			'P', Blocks.piston
		}));
		
	}
	
}
