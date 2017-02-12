package ua.pp.shurgent.tfctech.integration.bc;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.core.ModOptions;
import ua.pp.shurgent.tfctech.core.ModRecipes;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftTransport;

import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Crafting.AnvilManager;
import com.bioxx.tfc.api.Crafting.AnvilRecipe;
import com.bioxx.tfc.api.Crafting.AnvilReq;

import cpw.mods.fml.common.registry.GameRegistry;

public class TFCTechBCTransport {
	
	public static void removeRecipes() {
		
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.powerAdapterItem, 4));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.filteredBufferBlock));
		
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsWood, 8));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsCobblestone, 8));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsClay, 8));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsStone, 8));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsIron, 8));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsGold, 8));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsDiamond, 8));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsEmerald, 8));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsVoid, 8));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsSandstone, 8));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsObsidian, 8));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsDaizuli, 8));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsLapis, 8));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsQuartz, 8));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsEmzuli, 8));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsStripes, 8));
		
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsWood));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsCobblestone));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsClay));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsStone));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsIron));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsGold));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsEmerald));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsDiamond));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsVoid));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsSandstone));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsQuartz));

		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeStructureCobblestone, 8));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.plugItem, 4));

		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipePowerCobblestone));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipePowerStone));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipePowerSandstone));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipePowerWood));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipePowerIron));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipePowerQuartz));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipePowerGold));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipePowerDiamond));
		ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipePowerEmerald));
		
		for (int i = 0; i <= 16; i++) {
			ModRecipes.removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsVoid, 8, i));
		}
		
	}
	
	public static void registerRecipes() {
		
		registerPipeRecipe(ModItems.pipeItemsZinc, ModItems.pipeFrameZinc);
		registerPipeRecipe(ModItems.pipeItemsLead, ModItems.pipeFrameLead);
		registerPipeRecipe(ModItems.pipeItemsFilter, ModItems.pipeFrameBlueSteel, ModItems.wroughtIronGear);
		registerPipeRecipe(ModItems.pipeItemsBlueSteel, ModItems.pipeFrameBlueSteel, ModItems.wroughtIronGear, ModItems.steelGear);
		registerPipeRecipe(ModItems.pipeItemsRedSteel, ModItems.pipeFrameRedSteel, ModItems.wroughtIronGear, Blocks.sticky_piston);
		registerPipeRecipe(ModItems.pipeItemsMarkerExtractor, ModItems.pipeFrameRedSteel, ModItems.wroughtIronGear, BuildCraftCore.paintbrushItem);
		registerPipeRecipe(ModItems.pipeItemsElectrum, ModItems.pipeFrameElectrum, ModItems.goldGear);
		registerPipeRecipe(ModItems.pipeItemsWroughtIron, ModItems.pipeFrameWroughtIron);
		registerPipeRecipe(ModItems.pipeItemsMarker, ModItems.pipeFrameSteel, ModItems.brassGear, BuildCraftCore.paintbrushItem);
		registerPipeRecipe(ModItems.pipeItemsBlackSteel, ModItems.pipeFrameBlackSteel, ModItems.wroughtIronGear, Blocks.piston);
		registerPipeRecipe(ModItems.pipeItemsSterlingSilver, ModItems.pipeFrameSterlingSilver);
		registerPipeRecipe(ModItems.pipeItemsSilver, ModItems.pipeFrameSilver);
		registerPipeRecipe(ModItems.pipeItemsBronze, ModItems.pipeFrameBronze);
		registerPipeRecipe(ModItems.pipeItemsNullify, ModItems.pipeFrameSteel, ModItems.wroughtIronGear, Items.ender_pearl);
		registerPipeRecipe(ModItems.pipeItemsCopper, ModItems.pipeFrameCopper, ModItems.copperGear, Blocks.sticky_piston);
		
		registerFluidPipeRecipe(ModItems.pipeFluidsZinc, ModItems.pipeItemsZinc);
		registerFluidPipeRecipe(ModItems.pipeFluidsLead, ModItems.pipeItemsLead);
		registerFluidPipeRecipe(ModItems.pipeFluidsBlueSteel, ModItems.pipeItemsBlueSteel);
		registerFluidPipeRecipe(ModItems.pipeFluidsRedSteel, ModItems.pipeItemsRedSteel);
		registerFluidPipeRecipe(ModItems.pipeFluidsWroughtIron, ModItems.pipeItemsWroughtIron);
		registerFluidPipeRecipe(ModItems.pipeFluidsSterlingSilver, ModItems.pipeItemsSterlingSilver);
		registerFluidPipeRecipe(ModItems.pipeFluidsSilver, ModItems.pipeItemsSilver);
		registerFluidPipeRecipe(ModItems.pipeFluidsBronze, ModItems.pipeItemsBronze);
		registerFluidPipeRecipe(ModItems.pipeFluidsNullify, ModItems.pipeItemsNullify);
		registerFluidPipeRecipe(ModItems.pipeFluidsCopper, ModItems.pipeItemsCopper);
		registerFluidPipeRecipe(ModItems.pipeFluidsElectrum, ModItems.pipeItemsElectrum);
		
		registerPowerPipeRecipe(ModItems.pipePowerRedSteel, ModItems.pipeItemsRedSteel);
		registerPowerPipeRecipe(ModItems.pipePowerWroughtIron, ModItems.pipeItemsWroughtIron);
		registerPowerPipeRecipe(ModItems.pipePowerSilver, ModItems.pipeItemsSilver);
		registerPowerPipeRecipe(ModItems.pipePowerCopper, ModItems.pipeItemsCopper);
		registerPowerPipeRecipe(ModItems.pipePowerBlueSteel, ModItems.pipeItemsBlueSteel);
		registerPowerPipeRecipe(ModItems.pipePowerSterlingSilver, ModItems.pipeItemsSterlingSilver);
		registerPowerPipeRecipe(ModItems.pipePowerElectrum, ModItems.pipeItemsElectrum);
		registerPowerPipeRecipe(ModItems.pipePowerLead, ModItems.pipeItemsLead);
		registerPowerPipeRecipe(ModItems.pipePowerBronze, ModItems.pipeItemsBronze);
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(ModItems.pipeStructureLead, new Object [] { ModItems.pipeItemsLead, "blockGravel" }));
		GameRegistry.addShapelessRecipe(new ItemStack(BuildCraftTransport.plugItem, 4), new Object [] { ModItems.pipeStructureLead });
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftTransport.filteredBufferBlock), new Object [] {
			"WDW", "WCW", "WPW",
			'W', "plankWood",
			'C', "chestWood",
			'D', ModItems.pipeItemsBlueSteel,
			'P', Blocks.piston
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BuildCraftTransport.powerAdapterItem, 4), new Object [] {
			"SES", "SGS", "SRS",
			'S', ModItems.pipeStructureLead,
			'E', ModItems.electrumIngot,
			'G', ModItems.goldGear,
			'R', "dustRedstone"
		}));
		
	}
	
	public static void registerPipeRecipe(Item out, Item frame, Object sec1, Object sec2) {
		if (sec1 == null) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(out, 8), new Object [] {
					" G ", "GFG", " G ",
					'G', Blocks.glass_pane,
					'F', frame
			}));
		} else {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(out, 8), new Object [] {
					"1G2", "GFG", "2G1",
					'G', Blocks.glass_pane,
					'F', frame,
					'1', sec1,
					'2', sec2 == null ? sec1 : sec2
			}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(out, 8), new Object [] {
					"2G1", "GFG", "1G2",
					'G', Blocks.glass_pane,
					'F', frame,
					'1', sec1,
					'2', sec2 == null ? sec1 : sec2
			}));
		}
	}
	
	public static void registerPipeRecipe(Item out, Item frame, Object sec1) {
		registerPipeRecipe(out, frame, sec1, sec1);
	}

	public static void registerPipeRecipe(Item out, Item frame) {
		registerPipeRecipe(out, frame, null, null);
	}
	
	public static void registerFluidPipeRecipe(Item out, Item itemPipe) {
		if (ModOptions.cfgFluidPipesNeedGlue)
			GameRegistry.addRecipe(new ShapelessOreRecipe(out, new Object [] { itemPipe, "materialRubber", "materialGlue" }));
		else
			GameRegistry.addRecipe(new ShapelessOreRecipe(out, new Object [] { itemPipe, "materialRubber" }));
	}
	
	public static void registerPowerPipeRecipe(Item out, Item itemPipe) {
		GameRegistry.addRecipe(new ShapelessOreRecipe(out, new Object [] { itemPipe, "dustRedstone" }));
	}
	
	public static void registerAnvilRecipes(AnvilManager anvilManager) {
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.zincIngot2x), null, "frame", AnvilReq.STONE, new ItemStack(ModItems.pipeFrameZinc, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.leadIngot2x), null, "frame", AnvilReq.COPPER, new ItemStack(ModItems.pipeFrameLead, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot2x), null, "frame", AnvilReq.BLUESTEEL, new ItemStack(ModItems.pipeFrameBlueSteel, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot2x), null, "frame", AnvilReq.REDSTEEL, new ItemStack(ModItems.pipeFrameRedSteel, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(ModItems.electrumIngot2x), null, "frame", AnvilReq.BRONZE, new ItemStack(ModItems.pipeFrameElectrum, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot2x), null, "frame", AnvilReq.WROUGHTIRON, new ItemStack(ModItems.pipeFrameWroughtIron, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelIngot2x), null, "frame", AnvilReq.STEEL, new ItemStack(ModItems.pipeFrameSteel, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot2x), null, "frame", AnvilReq.BLACKSTEEL, new ItemStack(ModItems.pipeFrameBlackSteel, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.sterlingSilverIngot2x), null, "frame", AnvilReq.BRONZE, new ItemStack(ModItems.pipeFrameSterlingSilver, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.silverIngot2x), null, "frame", AnvilReq.COPPER, new ItemStack(ModItems.pipeFrameSilver, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot2x), null, "frame", AnvilReq.BRONZE, new ItemStack(ModItems.pipeFrameBronze, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.copperIngot2x), null, "frame", AnvilReq.COPPER, new ItemStack(ModItems.pipeFrameCopper, 1)));
	}
	
}
