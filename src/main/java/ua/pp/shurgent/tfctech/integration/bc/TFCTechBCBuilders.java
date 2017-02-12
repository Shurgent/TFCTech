package ua.pp.shurgent.tfctech.integration.bc;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.core.ModRecipes;
import buildcraft.BuildCraftBuilders;
import buildcraft.BuildCraftCore;

import com.bioxx.tfc.api.TFCItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class TFCTechBCBuilders {
	
	public static void removeRecipes() {
		ModRecipes.removeRecipe(new ItemStack(BuildCraftBuilders.quarryBlock));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftBuilders.fillerBlock));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftBuilders.libraryBlock));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftBuilders.constructionMarkerBlock));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftBuilders.blueprintItem));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftBuilders.builderBlock));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftBuilders.architectBlock));
	}
	
	public static void registerRecipes() {
		
		// Construction Marker
		GameRegistry.addRecipe(new ItemStack(BuildCraftBuilders.constructionMarkerBlock), new Object [] {
			"G", "I",
			'G', ModItems.goldGear,
			'I', Blocks.redstone_torch
		});
		
		// Blueprint
		GameRegistry.addRecipe(new ItemStack(BuildCraftBuilders.blueprintItem), new Object [] {
			"PPP", "PBP", "PPP",
			'P', Items.paper,
			'B', new ItemStack(TFCItems.powder, 1, 6)
		});
		
		// Drill Head
		GameRegistry.addRecipe(new ItemStack(ModItems.drillHead), new Object [] {
			" I ", "DID", " D ",
			'I', TFCItems.steelIngot,
			'D', new ItemStack(TFCItems.gemDiamond, 1, 2)
		});
		
		// Quarry
		GameRegistry.addRecipe(new ItemStack(BuildCraftBuilders.quarryBlock), new Object [] {
			"IRI", "SIS", "BDB",
			'R', Items.redstone,
			'I', ModItems.wroughtIronGear,
			'S', ModItems.steelGear,
			'B', ModItems.blueSteelGear,
			'D', ModItems.drillHead
		});
		
		// Filler
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftBuilders.fillerBlock), new Object [] {
			"BMB", "YIY", "GCG",
			'B', "dyeBlack",
			'M', BuildCraftCore.markerBlock,
			'Y', "dyeYellow",
			'I', ModItems.wroughtIronGear,
			'G', ModItems.goldGear,
			'C', "chestWood"
		}));
		
		// Builder
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftBuilders.builderBlock), new Object [] {
			"BMB", "YSY", "GCG",
			'B', "dyeBlack",
			'M', BuildCraftCore.markerBlock,
			'Y', "dyeYellow",
			'S', ModItems.steelGear,
			'G', ModItems.blueSteelGear,
			'C', "chestWood"
		}));
		
		// Architect Table
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftBuilders.architectBlock), new Object [] {
			"BMB", "YIY", "GPG",
			'B', "dyeBlack",
			'M', BuildCraftCore.markerBlock,
			'Y', "dyeYellow",
			'I', ModItems.wroughtIronGear,
			'G', ModItems.blueSteelGear,
			'P', BuildCraftBuilders.blueprintItem
		}));
		
		// Electronic Library
		GameRegistry.addRecipe(new ItemStack(BuildCraftBuilders.libraryBlock), new Object [] {
			"IGI", "SBS", "IRI",
			'I', TFCItems.wroughtIronIngot,
			'G', ModItems.wroughtIronGear,
			'S', Blocks.bookshelf,
			'B', BuildCraftBuilders.blueprintItem,
			'R', Items.redstone
		});
		
	}
	
}
