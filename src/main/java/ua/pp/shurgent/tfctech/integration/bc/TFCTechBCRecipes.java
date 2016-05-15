package ua.pp.shurgent.tfctech.integration.bc;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.core.ModOptions;
import ua.pp.shurgent.tfctech.core.ModRecipes;
import buildcraft.BuildCraftBuilders;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftFactory;
import buildcraft.BuildCraftRobotics;
import buildcraft.BuildCraftSilicon;
import buildcraft.BuildCraftTransport;
import buildcraft.silicon.ItemRedstoneChipset;

import com.bioxx.tfc.api.TFCBlocks;
import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Crafting.AnvilManager;
import com.bioxx.tfc.api.Crafting.AnvilRecipe;
import com.bioxx.tfc.api.Crafting.AnvilReq;

import cpw.mods.fml.common.registry.GameRegistry;

public class TFCTechBCRecipes {
	
	// === Buildcraft =========================================================
	
	public static void removeBCRecipes() {

		// == BC Core =========================================================
		if (TFCTech.enableBCCore) {
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

		// == BC Builders =====================================================
		if (TFCTech.enableBCBuilders) {
			ModRecipes.removeRecipe(new ItemStack(BuildCraftBuilders.quarryBlock));
			ModRecipes.removeRecipe(new ItemStack(BuildCraftBuilders.fillerBlock));
			ModRecipes.removeRecipe(new ItemStack(BuildCraftBuilders.libraryBlock));
			ModRecipes.removeRecipe(new ItemStack(BuildCraftBuilders.constructionMarkerBlock));
			ModRecipes.removeRecipe(new ItemStack(BuildCraftBuilders.blueprintItem));
			ModRecipes.removeRecipe(new ItemStack(BuildCraftBuilders.builderBlock));
			ModRecipes.removeRecipe(new ItemStack(BuildCraftBuilders.architectBlock));
		}

		// == BC Energy =======================================================
		if (TFCTech.enableBCEnergy) {
			// Nothing to remove yet
		}

		// == BC Factory ======================================================
		if (TFCTech.enableBCFactory) {
			ModRecipes.removeRecipe(new ItemStack(BuildCraftFactory.miningWellBlock));
			ModRecipes.removeRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock));
			ModRecipes.removeRecipe(new ItemStack(BuildCraftFactory.pumpBlock));
			ModRecipes.removeRecipe(new ItemStack(BuildCraftFactory.floodGateBlock));
			ModRecipes.removeRecipe(new ItemStack(BuildCraftFactory.tankBlock));
			ModRecipes.removeRecipe(new ItemStack(BuildCraftFactory.refineryBlock));
			ModRecipes.removeRecipe(new ItemStack(BuildCraftFactory.hopperBlock));
		}

		// == BC Robotics =====================================================
		if (TFCTech.enableBCRobotics) {
			ModRecipes.removeRecipe(new ItemStack(BuildCraftRobotics.requesterBlock));
			ModRecipes.removeRecipe(new ItemStack(BuildCraftRobotics.zonePlanBlock));
			ModRecipes.removeRecipe(new ItemStack(BuildCraftRobotics.robotItem));
			ModRecipes.removeRecipe(new ItemStack(BuildCraftRobotics.robotStationItem));
		}

		// == BC Silicon ======================================================
		if (TFCTech.enableBCSilicon) {
			
			ModRecipes.removeRecipe(new ItemStack(BuildCraftSilicon.laserBlock));
			ModRecipes.removeRecipe(new ItemStack(BuildCraftSilicon.packagerBlock));
			for (int i = 0; i <= 5; i++) {
				ModRecipes.removeRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, i));
			}
			
		}

		// == BC Transport ======================================================
		if (TFCTech.enableBCTransport) {
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

	}

	public static void registerBCRecipes() {

		// == BC Core =========================================================
		if (TFCTech.enableBCCore) {
			
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

		// == BC Builders =====================================================
		if (TFCTech.enableBCBuilders) {
			
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

		// == BC Energy =======================================================
		//if (TFCTech.enableBCEnergy) {
			
		//}

		// == BC Factory ======================================================
		if (TFCTech.enableBCFactory) {
			
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

		// == BC Robotics =====================================================
		if (TFCTech.enableBCRobotics) {
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

		// == BC Silicon ======================================================
		if (TFCTech.enableBCSilicon) {
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

		// == BC Transport ======================================================
		if (TFCTech.enableBCTransport) {
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
		
		if (TFCTech.enableBCCore) {
			anvilManager.addRecipe(new AnvilRecipe(new ItemStack(ModItems.invarIngot2x), null, "wrench", AnvilReq.BRONZE, new ItemStack(BuildCraftCore.wrenchItem, 1)));
		}
		if (TFCTech.enableBCTransport) {
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
	
}
