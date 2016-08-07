package ua.pp.shurgent.tfctech.integration.bc;

import net.minecraft.item.Item;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.handlers.ModBucketHandler;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsBlueSteel;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsBronze;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsCopper;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsElectrum;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsLead;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsNullify;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsRedSteel;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsSilver;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsSterlingSilver;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsWroughtIron;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsZinc;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power.PipePowerBlueSteel;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power.PipePowerBronze;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power.PipePowerCopper;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power.PipePowerElectrum;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power.PipePowerLead;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power.PipePowerRedSteel;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power.PipePowerSilver;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power.PipePowerSterlingSilver;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power.PipePowerWroughtIron;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.structure.PipeStructureLead;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport.PipeItemsBlackSteel;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport.PipeItemsBlueSteel;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport.PipeItemsBronze;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport.PipeItemsCopper;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport.PipeItemsElectrum;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport.PipeItemsFilter;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport.PipeItemsLead;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport.PipeItemsMarker;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport.PipeItemsMarkerExtractor;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport.PipeItemsNullify;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport.PipeItemsRedSteel;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport.PipeItemsSilver;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport.PipeItemsSterlingSilver;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport.PipeItemsWroughtIron;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.transport.PipeItemsZinc;
import ua.pp.shurgent.tfctech.integration.bc.items.PipeFrameBlackSteel;
import ua.pp.shurgent.tfctech.integration.bc.items.PipeFrameBlueSteel;
import ua.pp.shurgent.tfctech.integration.bc.items.PipeFrameBronze;
import ua.pp.shurgent.tfctech.integration.bc.items.PipeFrameCopper;
import ua.pp.shurgent.tfctech.integration.bc.items.PipeFrameElectrum;
import ua.pp.shurgent.tfctech.integration.bc.items.PipeFrameLead;
import ua.pp.shurgent.tfctech.integration.bc.items.PipeFrameRedSteel;
import ua.pp.shurgent.tfctech.integration.bc.items.PipeFrameSilver;
import ua.pp.shurgent.tfctech.integration.bc.items.PipeFrameSteel;
import ua.pp.shurgent.tfctech.integration.bc.items.PipeFrameStirlingSilver;
import ua.pp.shurgent.tfctech.integration.bc.items.PipeFrameWroughtIron;
import ua.pp.shurgent.tfctech.integration.bc.items.PipeFrameZinc;
import ua.pp.shurgent.tfctech.items.tools.ItemModSteelBucket;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftEnergy;
import buildcraft.BuildCraftTransport;
import buildcraft.api.core.IIconProvider;
import buildcraft.core.BCCreativeTab;
import buildcraft.core.BCRegistry;
import buildcraft.transport.BlockGenericPipe;
import buildcraft.transport.Pipe;

public class BCStuff {
	public static IIconProvider pipeIconProvider; // Buildcraft pipe icon provider
	
	public static void initialize() {
		pipeIconProvider = new ModPipeIconProvider();
	}
	
	public static void registerBucketHandlers() {
		ModBucketHandler.INSTANCE.buckets.put(BuildCraftEnergy.blockOil, ModItems.steelBucketOil);
		ModBucketHandler.INSTANCE.buckets.put(BuildCraftEnergy.blockFuel, ModItems.steelBucketFuel);
	}
	
	public static void removeFromCreativeTab() {
		
		if (TFCTech.enableBCCore) {
			BuildCraftCore.stoneGearItem.setCreativeTab(null);
			BuildCraftCore.woodenGearItem.setCreativeTab(null);
			BuildCraftCore.ironGearItem.setCreativeTab(null);
			BuildCraftCore.goldGearItem.setCreativeTab(null);
			BuildCraftCore.diamondGearItem.setCreativeTab(null);
		}
		
		if (TFCTech.enableBCEnergy) {
			BuildCraftEnergy.bucketFuel.setCreativeTab(null);
			BuildCraftEnergy.bucketOil.setCreativeTab(null);
			if (BuildCraftEnergy.bucketRedPlasma != null)
				BuildCraftEnergy.bucketRedPlasma.setCreativeTab(null);
		}
		
		if (TFCTech.enableBCTransport) {
			BuildCraftTransport.pipeItemsClay.setCreativeTab(null);
			BuildCraftTransport.pipeItemsCobblestone.setCreativeTab(null);
			BuildCraftTransport.pipeItemsDaizuli.setCreativeTab(null);
			BuildCraftTransport.pipeItemsDiamond.setCreativeTab(null);
			BuildCraftTransport.pipeItemsEmerald.setCreativeTab(null);
			BuildCraftTransport.pipeItemsEmzuli.setCreativeTab(null);
			BuildCraftTransport.pipeItemsGold.setCreativeTab(null);
			BuildCraftTransport.pipeItemsIron.setCreativeTab(null);
			BuildCraftTransport.pipeItemsLapis.setCreativeTab(null);
			BuildCraftTransport.pipeItemsObsidian.setCreativeTab(null);
			BuildCraftTransport.pipeItemsQuartz.setCreativeTab(null);
			BuildCraftTransport.pipeItemsSandstone.setCreativeTab(null);
			BuildCraftTransport.pipeItemsStone.setCreativeTab(null);
			BuildCraftTransport.pipeItemsVoid.setCreativeTab(null);
			BuildCraftTransport.pipeItemsWood.setCreativeTab(null);
			
			BuildCraftTransport.pipeFluidsClay.setCreativeTab(null);
			BuildCraftTransport.pipeFluidsCobblestone.setCreativeTab(null);
			BuildCraftTransport.pipeFluidsDiamond.setCreativeTab(null);
			BuildCraftTransport.pipeFluidsEmerald.setCreativeTab(null);
			BuildCraftTransport.pipeFluidsIron.setCreativeTab(null);
			BuildCraftTransport.pipeFluidsQuartz.setCreativeTab(null);
			BuildCraftTransport.pipeFluidsSandstone.setCreativeTab(null);
			BuildCraftTransport.pipeFluidsStone.setCreativeTab(null);
			BuildCraftTransport.pipeFluidsVoid.setCreativeTab(null);
			BuildCraftTransport.pipeFluidsWood.setCreativeTab(null);
			BuildCraftTransport.pipeFluidsGold.setCreativeTab(null);
			
			BuildCraftTransport.pipePowerEmerald.setCreativeTab(null);
			BuildCraftTransport.pipePowerIron.setCreativeTab(null);
			BuildCraftTransport.pipePowerSandstone.setCreativeTab(null);
			BuildCraftTransport.pipePowerWood.setCreativeTab(null);
			BuildCraftTransport.pipePowerDiamond.setCreativeTab(null);
			BuildCraftTransport.pipePowerQuartz.setCreativeTab(null);
			BuildCraftTransport.pipePowerGold.setCreativeTab(null);
			BuildCraftTransport.pipePowerCobblestone.setCreativeTab(null);
			BuildCraftTransport.pipePowerStone.setCreativeTab(null);
			
			BuildCraftTransport.pipeStructureCobblestone.setCreativeTab(null);
			
			BuildCraftTransport.pipeItemsStripes.setCreativeTab(null);
		}
	}
	
	public static void registerItems() {
		if (TFCTech.enableBCEnergy) {
			ModItems.steelBucketOil = new ItemModSteelBucket(BuildCraftEnergy.blockOil).setUnlocalizedName("Steel Bucket Oil").setContainerItem(
					ModItems.steelBucketEmpty);
			ModItems.steelBucketFuel = new ItemModSteelBucket(BuildCraftEnergy.blockFuel).setUnlocalizedName("Steel Bucket Fuel").setContainerItem(
					ModItems.steelBucketEmpty);
		}
		
		if (TFCTech.enableBCTransport) {
			ModItems.pipeStructureLead = createPipe(PipeStructureLead.class);
			
			ModItems.pipeItemsLead = createPipe(PipeItemsLead.class);
			ModItems.pipeItemsBlueSteel = createPipe(PipeItemsBlueSteel.class);
			ModItems.pipeItemsMarker = createPipe(PipeItemsMarker.class);
			ModItems.pipeItemsFilter = createPipe(PipeItemsFilter.class);
			ModItems.pipeItemsCopper = createPipe(PipeItemsCopper.class);
			ModItems.pipeItemsRedSteel = createPipe(PipeItemsRedSteel.class);
			ModItems.pipeItemsMarkerExtractor = createPipe(PipeItemsMarkerExtractor.class);
			ModItems.pipeItemsElectrum = createPipe(PipeItemsElectrum.class);
			ModItems.pipeItemsWroughtIron = createPipe(PipeItemsWroughtIron.class);
			ModItems.pipeItemsBlackSteel = createPipe(PipeItemsBlackSteel.class);
			ModItems.pipeItemsSilver = createPipe(PipeItemsSilver.class);
			ModItems.pipeItemsBronze = createPipe(PipeItemsBronze.class);
			ModItems.pipeItemsSterlingSilver = createPipe(PipeItemsSterlingSilver.class);
			ModItems.pipeItemsZinc = createPipe(PipeItemsZinc.class);
			ModItems.pipeItemsNullify = createPipe(PipeItemsNullify.class);
			
			ModItems.pipeFluidsLead = createPipe(PipeFluidsLead.class);
			ModItems.pipeFluidsCopper = createPipe(PipeFluidsCopper.class);
			ModItems.pipeFluidsRedSteel = createPipe(PipeFluidsRedSteel.class);
			ModItems.pipeFluidsSterlingSilver = createPipe(PipeFluidsSterlingSilver.class);
			ModItems.pipeFluidsElectrum = createPipe(PipeFluidsElectrum.class);
			ModItems.pipeFluidsWroughtIron = createPipe(PipeFluidsWroughtIron.class);
			ModItems.pipeFluidsSilver = createPipe(PipeFluidsSilver.class);
			ModItems.pipeFluidsBronze = createPipe(PipeFluidsBronze.class);
			ModItems.pipeFluidsNullify = createPipe(PipeFluidsNullify.class);
			ModItems.pipeFluidsZinc = createPipe(PipeFluidsZinc.class);
			ModItems.pipeFluidsBlueSteel = createPipe(PipeFluidsBlueSteel.class);
			
			ModItems.pipePowerBlueSteel = createPipe(PipePowerBlueSteel.class);
			ModItems.pipePowerElectrum = createPipe(PipePowerElectrum.class);
			ModItems.pipePowerSterlingSilver = createPipe(PipePowerSterlingSilver.class);
			ModItems.pipePowerBronze = createPipe(PipePowerBronze.class);
			ModItems.pipePowerSilver = createPipe(PipePowerSilver.class);
			ModItems.pipePowerLead = createPipe(PipePowerLead.class);
			ModItems.pipePowerCopper = createPipe(PipePowerCopper.class);
			ModItems.pipePowerRedSteel = createPipe(PipePowerRedSteel.class);
			ModItems.pipePowerWroughtIron = createPipe(PipePowerWroughtIron.class);
			
			ModItems.pipeFrameZinc = new PipeFrameZinc("Zinc", 200).setUnlocalizedName("Zinc Pipe Frame");
			ModItems.pipeFrameLead = new PipeFrameLead("Lead", 200).setUnlocalizedName("Lead Pipe Frame");
			ModItems.pipeFrameBlueSteel = new PipeFrameBlueSteel("Blue Steel", 200).setUnlocalizedName("Blue Steel Pipe Frame");
			ModItems.pipeFrameRedSteel = new PipeFrameRedSteel("Red Steel", 200).setUnlocalizedName("Red Steel Pipe Frame");
			ModItems.pipeFrameElectrum = new PipeFrameElectrum("Electrum", 200).setUnlocalizedName("Electrum Pipe Frame");
			ModItems.pipeFrameWroughtIron = new PipeFrameWroughtIron("Wrought Iron", 200).setUnlocalizedName("Wrought Iron Pipe Frame");
			ModItems.pipeFrameSteel = new PipeFrameSteel("Steel", 200).setUnlocalizedName("Steel Pipe Frame");
			ModItems.pipeFrameBlackSteel = new PipeFrameBlackSteel("Black Steel", 200).setUnlocalizedName("Black Steel Pipe Frame");
			ModItems.pipeFrameSterlingSilver = new PipeFrameStirlingSilver("Sterling Silver", 200).setUnlocalizedName("Sterling Silver Pipe Frame");
			ModItems.pipeFrameSilver = new PipeFrameSilver("Silver", 200).setUnlocalizedName("Silver Pipe Frame");
			ModItems.pipeFrameBronze = new PipeFrameBronze("Bronze", 200).setUnlocalizedName("Bronze Pipe Frame");
			ModItems.pipeFrameCopper = new PipeFrameCopper("Copper", 200).setUnlocalizedName("Copper Pipe Frame");
		}
		
	}
	
	private static Item createPipe(Class<? extends Pipe<?>> clas) {
		if (!BCRegistry.INSTANCE.isEnabled("pipes", clas.getSimpleName())) {
			return null;
		}
		
		return BlockGenericPipe.registerPipe(clas, BCCreativeTab.get("pipes")).setUnlocalizedName(clas.getSimpleName());
	}
	
}
