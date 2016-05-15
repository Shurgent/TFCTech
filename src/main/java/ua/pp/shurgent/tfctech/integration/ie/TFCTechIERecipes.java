package ua.pp.shurgent.tfctech.integration.ie;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.core.ModRecipes;
import blusunrize.immersiveengineering.common.IEContent;
import blusunrize.immersiveengineering.common.blocks.metal.BlockMetalDevices;

import com.bioxx.tfc.api.TFCItems;
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
		
	}
	
	public static void registerIERecipes(CraftingManagerTFC craftingManager, KilnCraftingManager kilnCraftingManager) {
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
		kilnCraftingManager.addRecipe(new KilnRecipe(new ItemStack(ModItems.potteryInsulatorPart, 1, 0), 0, new ItemStack(ModItems.potteryInsulatorPart, 1, 1)));		
		
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
			'L', new ItemStack(IEContent.blockMetalDevice, 8, BlockMetalDevices.META_connectorLV),
			'M', new ItemStack(IEContent.blockMetalDevice, 8, BlockMetalDevices.META_connectorMV),
			'C', new ItemStack(IEContent.blockStorage, 1, 9), // Electrum coil
			'I', "plateIron"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(IEContent.blockMetalDevice, 1, BlockMetalDevices.META_transformerHV), new Object [] {
			"M H", "ICI", "III",
			'H', new ItemStack(IEContent.blockMetalDevice, 8, BlockMetalDevices.META_connectorHV),
			'M', new ItemStack(IEContent.blockMetalDevice, 8, BlockMetalDevices.META_connectorMV),
			'C', new ItemStack(IEContent.blockStorage, 1, 10), // HV coil
			'I', "plateIron"
		}));
		
	}
}
