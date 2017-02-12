package ua.pp.shurgent.tfctech.integration.bc;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.core.ModRecipes;
import buildcraft.BuildCraftFactory;

import com.bioxx.tfc.api.TFCBlocks;
import com.bioxx.tfc.api.TFCItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class TFCTechBCFactory {
	
	public static void removeRecipes() {
		ModRecipes.removeRecipe(new ItemStack(BuildCraftFactory.miningWellBlock));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftFactory.pumpBlock));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftFactory.floodGateBlock));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftFactory.tankBlock));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftFactory.refineryBlock));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftFactory.hopperBlock));
	}
	
	public static void registerRecipes() {
		
		// Tank
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftFactory.tankBlock), new Object [] {
			"IGI", "G G", "IGI",
			'G', "paneGlass",
			'I', TFCItems.wroughtIronIngot
		}));
		
		// Mining Well
		GameRegistry.addRecipe(new ItemStack(BuildCraftFactory.miningWellBlock), new Object [] {
			"IRI", "IGI", "IDI",
			'I', TFCItems.wroughtIronIngot,
			'G', ModItems.steelGear,
			'D', ModItems.drillHead,
			'R', Items.redstone
		});
		
		// Auto Workbench
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock), new Object [] {
			"GWG", "WBW", "GWG",
			'W', "plankWood",
			'G', ModItems.wroughtIronGear,
			'B', TFCBlocks.workbench
		}));
		
		// Pump
		GameRegistry.addRecipe(new ItemStack(BuildCraftFactory.pumpBlock), new Object [] {
			"IRI", "IGI", "TBT",
			'I', TFCItems.wroughtIronIngot,
			'R', Items.redstone,
			'G', ModItems.steelGear,
			'T', BuildCraftFactory.tankBlock,
			'B', TFCItems.blueSteelBucketEmpty
		});
		
		// Flood Gate
		GameRegistry.addRecipe(new ItemStack(BuildCraftFactory.floodGateBlock), new Object [] {
			"IGI", "BTB", "IBI",
			'I', TFCItems.wroughtIronIngot,
			'G', ModItems.brassGear,
			'T', BuildCraftFactory.tankBlock,
			'B', Blocks.iron_bars
		});
		
		// Refinery
		GameRegistry.addRecipe(new ItemStack(BuildCraftFactory.refineryBlock), new Object [] {
			"RTR", "TGT",
			'R', Blocks.redstone_torch,
			'G', ModItems.blueSteelGear,
			'T', BuildCraftFactory.tankBlock
		});
		
		// Chute
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftFactory.hopperBlock), new Object [] {
			"ICI", " G ",
			'I', "plateIron",
			'C', "chestWood",
			'G', ModItems.wroughtIronGear
		}));
		
	}
	
}
