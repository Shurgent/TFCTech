package ua.pp.shurgent.tfctech.integration.bc;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.core.ModRecipes;
import buildcraft.BuildCraftRobotics;
import buildcraft.BuildCraftSilicon;
import buildcraft.silicon.ItemRedstoneChipset;

import com.bioxx.tfc.api.TFCItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class TFCTechBCRobotics {
	
	public static void removeRecipes() {
		ModRecipes.removeRecipe(new ItemStack(BuildCraftRobotics.requesterBlock));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftRobotics.zonePlanBlock));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftRobotics.robotItem));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftRobotics.robotStationItem));
	}
	
	public static void registerRecipes() {
		
		// Zone Planner
		GameRegistry.addRecipe(new ItemStack(BuildCraftRobotics.zonePlanBlock), new Object [] {
			"IRI", "GMG", "IBI",
			'I', TFCItems.wroughtIronIngot,
			'R', Items.redstone,
			'G', ModItems.goldGear,
			'M', Items.map,
			'B', ModItems.blueSteelGear
		});
		
		// Requester
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftRobotics.requesterBlock), new Object [] {
			"IPI", "GCG", "IRI",
			'I', TFCItems.wroughtIronIngot,
			'P', Blocks.piston,
			'G', ModItems.wroughtIronGear,
			'C', "chestWood",
			'R', Items.redstone
		}));
		
		if (TFCTech.enableBCSilicon) {
			// Robot
			GameRegistry.addRecipe(new ItemStack(BuildCraftRobotics.robotItem), new Object [] {
				"AAA", "ARA", "D D",
				//'A', TFCTech.enableRC ? ModItems.aluminumPlate : ModItems.aluminumIngot,
				'A', ModItems.aluminumIngot,
				'R', BuildCraftSilicon.redstoneCrystal,
				'D', ItemRedstoneChipset.Chipset.DIAMOND.getStack()
			});

			// Docking Station
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftRobotics.robotStationItem), new Object [] {
				"   ", " T ", "IGI",
				'T', "plateTin",
				'I', "plateIron",
				'G', ItemRedstoneChipset.Chipset.GOLD.getStack()
			}));
		}
		
	}
	
}
