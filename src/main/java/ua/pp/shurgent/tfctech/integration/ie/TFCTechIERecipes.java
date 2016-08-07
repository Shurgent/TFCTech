package ua.pp.shurgent.tfctech.integration.ie;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.core.ModRecipes;
import blusunrize.immersiveengineering.common.IEContent;
import blusunrize.immersiveengineering.common.blocks.metal.BlockMetalDevices;

import com.bioxx.tfc.api.TFCBlocks;
import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Crafting.BarrelManager;
import com.bioxx.tfc.api.Crafting.BarrelRecipe;
import com.bioxx.tfc.api.Crafting.CraftingManagerTFC;
import com.bioxx.tfc.api.Crafting.KilnCraftingManager;
import com.bioxx.tfc.api.Crafting.KilnRecipe;

import cpw.mods.fml.common.registry.GameRegistry;

public class TFCTechIERecipes {
	
	// === Immersive Engineering ==============================================
	
	public static void removeIERecipes() {
		if (!TFCTech.enableIE)
			return;
		
		ModRecipes.removeRecipe(new ItemStack(IEContent.blockMetalDevice, 8, BlockMetalDevices.META_connectorLV));
		ModRecipes.removeRecipe(new ItemStack(IEContent.blockMetalDevice, 8, BlockMetalDevices.META_connectorMV));
		ModRecipes.removeRecipe(new ItemStack(IEContent.blockMetalDevice, 4, BlockMetalDevices.META_connectorHV));
		
		ModRecipes.removeRecipe(new ItemStack(IEContent.blockMetalDevice, 1, BlockMetalDevices.META_capacitorLV));
		ModRecipes.removeRecipe(new ItemStack(IEContent.blockMetalDevice, 1, BlockMetalDevices.META_capacitorMV));
		ModRecipes.removeRecipe(new ItemStack(IEContent.blockMetalDevice, 1, BlockMetalDevices.META_capacitorHV));
		ModRecipes.removeRecipe(new ItemStack(IEContent.blockMetalDevice, 1, BlockMetalDevices.META_transformer));
		ModRecipes.removeRecipe(new ItemStack(IEContent.blockMetalDevice, 1, BlockMetalDevices.META_transformerHV));
		
		ModRecipes.removeRecipe(new ItemStack(IEContent.itemWireCoil, 4, 0)); // LV Copper
		ModRecipes.removeRecipe(new ItemStack(IEContent.itemWireCoil, 4, 1)); // MV Electrum
		ModRecipes.removeRecipe(new ItemStack(IEContent.itemWireCoil, 4, 2)); // HV Steel + Aluminum
		ModRecipes.removeRecipe(new ItemStack(IEContent.itemWireCoil, 4, 3)); // Hemp
		ModRecipes.removeRecipe(new ItemStack(IEContent.itemWireCoil, 4, 4)); // Steel
		
		ModRecipes.removeRecipe(new ItemStack(IEContent.itemMaterial, 4, 0)); // Treated stick
	}
	
	public static void registerIERecipes(CraftingManagerTFC craftingManager, KilnCraftingManager kiln, BarrelManager barrel) {
		if (!TFCTech.enableIE)
			return;
		
		// Ceramic Insulator Part
		craftingManager.addRecipe(new ItemStack(ModItems.potteryInsulatorPart, 1), new Object[] {
			"    #",
			"##  #",
			"##  #",
			"    #",
			"    #",
			'#', new ItemStack(TFCItems.flatClay, 1, 1)});
		
		kiln.addRecipe(new KilnRecipe(new ItemStack(ModItems.potteryInsulatorPart, 1, 0), 0, new ItemStack(ModItems.potteryInsulatorPart, 1, 1)));		
		
		// Barrel of creosote recipes
		barrel.addRecipe(new BarrelRecipe(new ItemStack(TFCItems.stick), new FluidStack(IEContent.fluidCreosote, 8), new ItemStack(
				IEContent.itemMaterial, 1, 0), new FluidStack(IEContent.fluidCreosote, 8)).setMinTechLevel(0));
		for (int i = 0; i < 16; i++)
			barrel.addRecipe(new BarrelRecipe(new ItemStack(TFCBlocks.planks, 1, i), new FluidStack(IEContent.fluidCreosote, 125), new ItemStack(
					IEContent.blockTreatedWood, 1, 0), new FluidStack(IEContent.fluidCreosote, 125)).setMinTechLevel(0));
		barrel.addRecipe(new BarrelRecipe(new ItemStack(TFCBlocks.planks2, 1, 0), new FluidStack(IEContent.fluidCreosote, 125), new ItemStack(
				IEContent.blockTreatedWood, 1, 0), new FluidStack(IEContent.fluidCreosote, 125)).setMinTechLevel(0));
		
		// Connectors
		GameRegistry.addShapedRecipe(new ItemStack(IEContent.blockMetalDevice, 8, BlockMetalDevices.META_connectorLV), new Object [] {
			"IMI", " M ", "IMI",
			'I', new ItemStack(ModItems.potteryInsulatorPart, 1, 1),
			'M', TFCItems.copperIngot
		});
		GameRegistry.addShapedRecipe(new ItemStack(IEContent.blockMetalDevice, 8, BlockMetalDevices.META_connectorMV), new Object [] {
			"IMI", " M ", "IMI",
			'I', new ItemStack(ModItems.potteryInsulatorPart, 1, 1),
			'M', TFCItems.wroughtIronIngot
		});
		GameRegistry.addShapedRecipe(new ItemStack(IEContent.blockMetalDevice, 4, BlockMetalDevices.META_connectorHV), new Object [] {
			"IMI", "IMI", "IMI",
			'I', new ItemStack(ModItems.potteryInsulatorPart, 1, 1),
			'M', ModItems.aluminumIngot
		});
		
		// Capacitors
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.capacitorElectrode, 1), new Object [] {
			"N", "C",
			'N', "plateNickel",
			'C', "plateCeramic"
		}));
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.mlccBlock), new Object [] {
			"EEE", "EEE",
			'E', ModItems.capacitorElectrode
		});
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.capacitorBaseLV), new Object [] {
			"T T", "CMC", "T T",
			'T', "plateTin",
			'C', "plateCopper",
			'M', ModItems.mlccBlock
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(IEContent.blockMetalDevice, 1, BlockMetalDevices.META_capacitorLV), new Object [] {
			"III", "CLC", "WRW",
			'I', "plateIron",
			'C', TFCItems.copperIngot,
			'L', ModItems.capacitorBaseLV,
			'W', "plankTreatedWood",
			'R', "dustRedstone"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.capacitorBaseMV), new Object [] {
			"CLC", "LIL", "CLC",
			'C', "plateCopper",
			'L', ModItems.capacitorBaseLV,
			'I', "plateIron"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(IEContent.blockMetalDevice, 1, BlockMetalDevices.META_capacitorMV), new Object [] {
			"III", "EME", "WRW",
			'I', "plateIron",
			'E', ModItems.electrumIngot,
			'M', ModItems.capacitorBaseMV,
			'W', "plankTreatedWood",
			'R', "blockRedstone"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.capacitorBaseHV), new Object [] {
			"GMG", "MSM", "GMG",
			'G', "plateGold",
			'M', ModItems.capacitorBaseMV,
			'S', "plateSteel"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(IEContent.blockMetalDevice, 1, BlockMetalDevices.META_capacitorHV), new Object [] {
			"SSS", "AHA", "WRW",
			'S', "plateSteel",
			'A', ModItems.aluminumIngot,
			'H', ModItems.capacitorBaseHV,
			'W', "plankTreatedWood",
			'R', "blockRedstone"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(IEContent.blockMetalDevice, 1, BlockMetalDevices.META_transformer), new Object [] {
			"L M", "ICI", "III",
			'L', new ItemStack(IEContent.blockMetalDevice, 1, BlockMetalDevices.META_connectorLV),
			'M', new ItemStack(IEContent.blockMetalDevice, 1, BlockMetalDevices.META_connectorMV),
			'C', new ItemStack(IEContent.blockStorage, 1, 9), // Electrum coil
			'I', "plateIron"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(IEContent.blockMetalDevice, 1, BlockMetalDevices.META_transformerHV), new Object [] {
			"M H", "ICI", "III",
			'H', new ItemStack(IEContent.blockMetalDevice, 1, BlockMetalDevices.META_connectorHV),
			'M', new ItemStack(IEContent.blockMetalDevice, 1, BlockMetalDevices.META_connectorMV),
			'C', new ItemStack(IEContent.blockStorage, 1, 10), // HV coil
			'I', "plateIron"
		}));
		
		// Coils
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(IEContent.itemWireCoil, 2, 0), new Object [] {
			" W ", "WLW", " W ",
			'W', new ItemStack(ModItems.copperWire),
			'L', "woodLumber"
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(IEContent.itemWireCoil, 2, 1), new Object [] {
			" W ", "WLW", " W ",
			'W', new ItemStack(ModItems.electrumWire),
			'L', "woodLumber"
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(IEContent.itemWireCoil, 2, 2), new Object [] {
			" S ", "ALA", " S ",
			'S', new ItemStack(ModItems.steelWire),
			'A', new ItemStack(ModItems.aluminumWire),
			'L', "woodLumber"
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(IEContent.itemWireCoil, 4, 3), new Object [] {
			" W ", "WLW", " W ",
			'W', new ItemStack(TFCItems.juteFiber),
			'L', "woodLumber"
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(IEContent.itemWireCoil, 2, 4), new Object [] {
			" W ", "WLW", " W ",
			'W', new ItemStack(ModItems.steelWire),
			'L', "woodLumber"
		}));
		
		
	}
}
