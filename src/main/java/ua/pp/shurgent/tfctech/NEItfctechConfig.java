package ua.pp.shurgent.tfctech;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import ua.pp.shurgent.tfctech.core.ModBlocks;
import ua.pp.shurgent.tfctech.core.ModDetails;
import ua.pp.shurgent.tfctech.core.ModOptions;
import ua.pp.shurgent.tfctech.nei.WireDrawBenchRecipeHandler;
import ua.pp.shurgent.tfctech.nei.gui.NEIGUIHandler;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftTransport;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEItfctechConfig implements IConfigureNEI {
	
	@Override
	public String getName() {
		return ModDetails.ModName;
	}
	
	@Override
	public String getVersion() {
		return ModDetails.ModVersion;
	}
	
	@Override
	public void loadConfig() {
		
		TFCTech.LOG.info("Loading NEI config.");
		
		WireDrawBenchRecipeHandler wireDrawBenchRecipeHandler = new WireDrawBenchRecipeHandler();
		
		API.registerNEIGuiHandler(new NEIGUIHandler());
		API.registerRecipeHandler(wireDrawBenchRecipeHandler);
		API.registerUsageHandler(wireDrawBenchRecipeHandler);
		
		HideNEIItems();
		
		TFCTech.LOG.info("Done NEI integration.");
		
	}
	
	public void HideNEIItems() {
		
		if (ModOptions.cfgEnableNEIHide) {
			API.hideItem(new ItemStack(ModBlocks.ore));
			API.hideItem(new ItemStack(ModBlocks.logHeveaNatural, 1, OreDictionary.WILDCARD_VALUE));
			API.hideItem(new ItemStack(ModBlocks.logHeveaNatural1, 1, OreDictionary.WILDCARD_VALUE));
			API.hideItem(new ItemStack(ModBlocks.logHeveaNatural2, 1, OreDictionary.WILDCARD_VALUE));
			API.hideItem(new ItemStack(ModBlocks.logHeveaNatural3, 1, OreDictionary.WILDCARD_VALUE));
			API.hideItem(new ItemStack(ModBlocks.logHeveaNaturalDead, 1, OreDictionary.WILDCARD_VALUE));
			API.hideItem(new ItemStack(ModBlocks.logHeveaVert, 1, OreDictionary.WILDCARD_VALUE));
			API.hideItem(new ItemStack(ModBlocks.logHeveaHoriz, 1, OreDictionary.WILDCARD_VALUE));
			API.hideItem(new ItemStack(ModBlocks.heveaLeaves, 1, OreDictionary.WILDCARD_VALUE));
			API.hideItem(new ItemStack(ModBlocks.latexExtractor));
			API.hideItem(new ItemStack(ModBlocks.wireDrawBench));
			
			// == Integration =================================================
			
			// Buildcraft
			if (TFCTech.enableBCCore) {
				API.hideItem(new ItemStack(BuildCraftCore.woodenGearItem));
				API.hideItem(new ItemStack(BuildCraftCore.stoneGearItem));
				API.hideItem(new ItemStack(BuildCraftCore.ironGearItem));
				API.hideItem(new ItemStack(BuildCraftCore.goldGearItem));
				API.hideItem(new ItemStack(BuildCraftCore.diamondGearItem));
			}
			
			if (TFCTech.enableBCTransport) {
				API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsClay));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsCobblestone));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsDaizuli));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsDiamond));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsEmerald));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsEmzuli));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsGold));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsIron));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsLapis));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsObsidian));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsQuartz));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsSandstone));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsStone));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsVoid));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsWood));
				
				API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsClay));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsCobblestone));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsDiamond));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsEmerald));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsIron));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsQuartz));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsSandstone));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsStone));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsVoid));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsWood));
				API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsGold));
				
				API.hideItem(new ItemStack(BuildCraftTransport.pipePowerEmerald));
				API.hideItem(new ItemStack(BuildCraftTransport.pipePowerIron));
				API.hideItem(new ItemStack(BuildCraftTransport.pipePowerSandstone));
				API.hideItem(new ItemStack(BuildCraftTransport.pipePowerWood));
				API.hideItem(new ItemStack(BuildCraftTransport.pipePowerDiamond));
				API.hideItem(new ItemStack(BuildCraftTransport.pipePowerQuartz));
				API.hideItem(new ItemStack(BuildCraftTransport.pipePowerGold));
				API.hideItem(new ItemStack(BuildCraftTransport.pipePowerCobblestone));
				API.hideItem(new ItemStack(BuildCraftTransport.pipePowerStone));
				
				API.hideItem(new ItemStack(BuildCraftTransport.pipeStructureCobblestone));
				
				API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsStripes));
			}
			
		}
		
	}
	
}
