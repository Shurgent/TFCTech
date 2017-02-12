package ua.pp.shurgent.tfctech.integration.bc;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.core.ModRecipes;
import buildcraft.BuildCraftCore;

import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Crafting.AnvilManager;
import com.bioxx.tfc.api.Crafting.AnvilRecipe;
import com.bioxx.tfc.api.Crafting.AnvilReq;

import cpw.mods.fml.common.registry.GameRegistry;

public class TFCTechBCCore {
	
	public static void removeRecipes() {
		ModRecipes.removeRecipe(new ItemStack(BuildCraftCore.stoneGearItem));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftCore.woodenGearItem));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftCore.ironGearItem));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftCore.goldGearItem));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftCore.diamondGearItem));
		
		ModRecipes.removeRecipe(new ItemStack(BuildCraftCore.wrenchItem));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftCore.paintbrushItem));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftCore.markerBlock));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftCore.pathMarkerBlock));

		ModRecipes.removeRecipe(new ItemStack(BuildCraftCore.engineBlock, 1, 0));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftCore.engineBlock, 1, 1));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftCore.engineBlock, 1, 2));
		
		/*
		for (int i = 0; i < 16; i++) {
			ItemStack outputStack = new ItemStack(BuildCraftCore.paintbrushItem);
			NBTUtils.getItemData(outputStack).setByte("color", (byte) i);
			ModRecipes.removeRecipe(outputStack);
		}
		*/
	}
	
	public static void registerRecipes() {
		// Redstone
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftCore.engineBlock, 1, 0), new Object [] {
			"WWW", " # ", "GPG",
			'W', "plankWood",
			'#', Blocks.glass,
			'G', ModItems.copperGear,
			'P', Blocks.piston
		}));
		
		for (Item gear : ModItems.bronzeGears) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftCore.engineBlock, 1, 0), new Object [] {
				"WWW", " # ", "GPG",
				'W', "plankWood",
				'#', Blocks.glass,
				'G', gear,
				'P', Blocks.piston
			}));
		}

		// Stirling
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftCore.engineBlock, 1, 1), new Object [] {
			"CCC", " # ", "GPG",
			'C', "stoneCobble",
			'#', Blocks.glass,
			'G', ModItems.wroughtIronGear,
			'P', Blocks.piston
		}));

		// Combustion
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftCore.engineBlock, 1, 2), new Object [] {
			"SSS", " # ", "GPG",
			'S', "plateDoubleWroughtIron",
			'#', Blocks.glass,
			'G', ModItems.steelGear,
			'P', Blocks.piston
		}));
		
		// Paintbrush
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftCore.paintbrushItem), new Object [] {
			" GI", " WG", "S  ",
			'S', TFCItems.shears,
			'W', TFCItems.wool,
			'G', "materialString",
			'I', "stickWood"
		}));
		
		// Markers
		GameRegistry.addRecipe(new ItemStack(BuildCraftCore.markerBlock), new Object [] {
			"D", "I",
			'D', new ItemStack(TFCItems.powder, 1, 6),
			'I', Blocks.redstone_torch
		});
		
		GameRegistry.addRecipe(new ItemStack(BuildCraftCore.pathMarkerBlock), new Object [] {
			"D", "I",
			'D', new ItemStack(TFCItems.powder, 1, 8),
			'I', Blocks.redstone_torch
		});
	}
	
	public static void registerAnvilRecipes(AnvilManager anvilManager) {
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(ModItems.invarIngot2x), null, "wrench", AnvilReq.BRONZE, new ItemStack(BuildCraftCore.wrenchItem, 1)));
	}
}
