package ua.pp.shurgent.tfctech.core;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import ua.pp.shurgent.tfctech.Globals;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.integration.bc.BCStuff;
import ua.pp.shurgent.tfctech.items.ItemCraftComponent;
import ua.pp.shurgent.tfctech.items.ItemDixie;
import ua.pp.shurgent.tfctech.items.ItemDust;
import ua.pp.shurgent.tfctech.items.ItemGear;
import ua.pp.shurgent.tfctech.items.ItemGearPiece;
import ua.pp.shurgent.tfctech.items.ItemGroove;
import ua.pp.shurgent.tfctech.items.ItemHeveaLog;
import ua.pp.shurgent.tfctech.items.ItemLimePaint;
import ua.pp.shurgent.tfctech.items.ItemModIngot;
import ua.pp.shurgent.tfctech.items.ItemModMeltedMetal;
import ua.pp.shurgent.tfctech.items.ItemModMetalItem;
import ua.pp.shurgent.tfctech.items.ItemModMetalSheet;
import ua.pp.shurgent.tfctech.items.ItemModMetalSheet2x;
import ua.pp.shurgent.tfctech.items.ItemModOre;
import ua.pp.shurgent.tfctech.items.ItemModOreSmall;
import ua.pp.shurgent.tfctech.items.ItemMount;
import ua.pp.shurgent.tfctech.items.ItemNugget;
import ua.pp.shurgent.tfctech.items.ItemPlate;
import ua.pp.shurgent.tfctech.items.ItemRackwheel;
import ua.pp.shurgent.tfctech.items.ItemSleeve;
import ua.pp.shurgent.tfctech.items.ItemStripe;
import ua.pp.shurgent.tfctech.items.ItemUnfinishedWire;
import ua.pp.shurgent.tfctech.items.ItemBlocks.ItemWireDrawBench;
import ua.pp.shurgent.tfctech.items.pottery.ItemModPotteryBase;
import ua.pp.shurgent.tfctech.items.pottery.ItemModPotteryLatexBowl;
import ua.pp.shurgent.tfctech.items.pottery.ItemModPotteryMold;
import ua.pp.shurgent.tfctech.items.tools.ItemDrawplate;
import ua.pp.shurgent.tfctech.items.tools.ItemModSteelBucket;
import ua.pp.shurgent.tfctech.items.tools.ItemOilCan;

import com.bioxx.tfc.Core.TFCTabs;
import com.bioxx.tfc.Core.Metal.Alloy;
import com.bioxx.tfc.Core.Metal.AlloyManager;
import com.bioxx.tfc.Core.Metal.MetalRegistry;
import com.bioxx.tfc.api.Metal;
import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Constant.Global;
import com.bioxx.tfc.api.Enums.EnumSize;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

	// Dust
	public static Item aluminumDust;
	public static Item bauxiteDust;
	public static Item electrumDust;
	public static Item constantanDust;
	public static Item invarDust;
	public static Item bismuthDust;
	public static Item bismuthBronzeDust;
	public static Item blackBronzeDust;
	public static Item blackSteelDust;
	public static Item blueSteelDust;
	public static Item brassDust;
	public static Item bronzeDust;
	public static Item copperDust;
	public static Item goldDust;
	public static Item wroughtIronDust;
	public static Item leadDust;
	public static Item nickelDust;
	public static Item pigIronDust;
	public static Item platinumDust;
	public static Item redSteelDust;
	public static Item roseGoldDust;
	public static Item silverDust;
	public static Item steelDust;
	public static Item sterlingSilverDust;
	public static Item tinDust;
	public static Item zincDust;

	// Nuggets
	public static Item aluminumNugget;
	public static Item electrumNugget;
	public static Item constantanNugget;
	public static Item invarNugget;
	public static Item bismuthNugget;
	public static Item bismuthBronzeNugget;
	public static Item blackBronzeNugget;
	public static Item blackSteelNugget;
	public static Item blueSteelNugget;
	public static Item brassNugget;
	public static Item bronzeNugget;
	public static Item copperNugget;
	public static Item goldNugget;
	public static Item wroughtIronNugget;
	public static Item leadNugget;
	public static Item nickelNugget;
	public static Item pigIronNugget;
	public static Item platinumNugget;
	public static Item redSteelNugget;
	public static Item roseGoldNugget;
	public static Item silverNugget;
	public static Item steelNugget;
	public static Item sterlingSilverNugget;
	public static Item tinNugget;
	public static Item zincNugget;

	// Ingots
	public static Item aluminumIngot;
	public static Item aluminumIngot2x;
	public static Item aluminumUnshaped;
	
	public static Item electrumIngot;
	public static Item electrumIngot2x;
	public static Item electrumUnshaped;

	public static Item constantanIngot;
	public static Item constantanIngot2x;
	public static Item constantanUnshaped;

	public static Item invarIngot;
	public static Item invarIngot2x;
	public static Item invarUnshaped;

	// Ore
	public static Item oreChunk;
	public static Item smallOreChunk;

	// Plates
	public static Item aluminumPlate;
	public static Item electrumPlate;
	public static Item constantanPlate;
	public static Item invarPlate;
	public static Item bismuthPlate;
	public static Item bismuthBronzePlate;
	public static Item blackBronzePlate;
	public static Item blackSteelPlate;
	public static Item blueSteelPlate;
	public static Item brassPlate;
	public static Item bronzePlate;
	public static Item copperPlate;
	public static Item goldPlate;
	public static Item wroughtIronPlate;
	public static Item leadPlate;
	public static Item nickelPlate;
	public static Item pigIronPlate;
	public static Item platinumPlate;
	public static Item redSteelPlate;
	public static Item roseGoldPlate;
	public static Item silverPlate;
	public static Item steelPlate;
	public static Item sterlingSilverPlate;
	public static Item tinPlate;
	public static Item zincPlate;

	public static Item aluminumPlate2x;
	public static Item electrumPlate2x;
	public static Item constantanPlate2x;
	public static Item invarPlate2x;
	public static Item bismuthPlate2x;
	public static Item bismuthBronzePlate2x;
	public static Item blackBronzePlate2x;
	public static Item blackSteelPlate2x;
	public static Item blueSteelPlate2x;
	public static Item brassPlate2x;
	public static Item bronzePlate2x;
	public static Item copperPlate2x;
	public static Item goldPlate2x;
	public static Item wroughtIronPlate2x;
	public static Item leadPlate2x;
	public static Item nickelPlate2x;
	public static Item pigIronPlate2x;
	public static Item platinumPlate2x;
	public static Item redSteelPlate2x;
	public static Item roseGoldPlate2x;
	public static Item silverPlate2x;
	public static Item steelPlate2x;
	public static Item sterlingSilverPlate2x;
	public static Item tinPlate2x;
	public static Item zincPlate2x;
	
	// Sheets
	public static Item aluminumSheet;
	public static Item aluminumSheet2x;
	public static Item electrumSheet;
	public static Item electrumSheet2x;
	public static Item constantanSheet;
	public static Item constantanSheet2x;
	public static Item invarSheet;
	public static Item invarSheet2x;
	
	// Stripes
	public static Item tinStripe;
	public static Item aluminumStripe;
	public static Item copperStripe;
	public static Item goldStripe;
	public static Item electrumStripe;
	public static Item ironStripe;
	public static Item steelStripe;
	
	// Device components
	public static Item groove;
	public static Item mount;
	
	// Rubber
	public static Item chalkPowder;
	public static Item vulcanizingAgents;
	public static Item rubberMix;
	public static Item rubber;
	
	// Dyes
	public static Item limePaint;
	
	// === Pottery ==============================
	
	// Molds
	public static Item clayMoldGearPiece;
	public static Item clayMoldSleeve;
	
	// Crafting parts
	public static Item potteryInsulatorPart;
	public static Item potteryCeramicPlate;
	
	// Tools
	public static Item latexBowl;
	
	//===========================================
	
	// === Gears ================================
	
	public static Item bismuthBronzeGearPiece;
	public static Item blackBronzeGearPiece;
	public static Item blueSteelGearPiece;
	public static Item brassGearPiece;
	public static Item bronzeGearPiece;
	public static Item copperGearPiece;
	public static Item goldGearPiece;
	public static Item wroughtIronGearPiece;
	public static Item steelGearPiece;
	public static Item tinGearPiece;
	
	public static Item bismuthBronzeRackwheel;
	public static Item blackBronzeRackwheel;
	public static Item blueSteelRackwheel;
	public static Item brassRackwheel;
	public static Item bronzeRackwheel;
	public static Item copperRackwheel;
	public static Item goldRackwheel;
	public static Item wroughtIronRackwheel;
	public static Item steelRackwheel;
	public static Item tinRackwheel;
	
	public static Item bismuthBronzeGear;
	public static Item blackBronzeGear;
	public static Item blueSteelGear;
	public static Item brassGear;
	public static Item bronzeGear;
	public static Item copperGear;
	public static Item goldGear;
	public static Item wroughtIronGear;
	public static Item steelGear;
	public static Item tinGear;
	
	public static Item[] bronzeGears;
	
	public static Item brassSleeve;
	public static Item tinSleeve;
	public static Item steelSleeve;

	//===========================================
	
	// === Flora ================================
	
	public static Item logHevea;
	
	//===========================================
	
	// === Integration ==========================
	
	public static Item drillHead;
	public static Item gemQuartz;
	
	public static Item steelBucketEmpty;
	public static Item steelBucketOil;
	public static Item steelBucketFuel;
	public static Item steelBucketLatex;
	
	// Pipes
	public static Item pipeStructureLead;

	public static Item pipeItemsLead;
	public static Item pipeItemsBlueSteel;
	public static Item pipeItemsMarker;
	public static Item pipeItemsFilter;
	public static Item pipeItemsCopper;
	public static Item pipeItemsRedSteel;
	public static Item pipeItemsMarkerExtractor;
	public static Item pipeItemsElectrum;
	public static Item pipeItemsWroughtIron;
	public static Item pipeItemsBlackSteel;
	public static Item pipeItemsSilver;
	public static Item pipeItemsBronze;
	public static Item pipeItemsSterlingSilver;
	public static Item pipeItemsZinc;
	public static Item pipeItemsNullify;

	public static Item pipeFluidsLead;
	public static Item pipeFluidsCopper;
	public static Item pipeFluidsRedSteel;
	public static Item pipeFluidsSterlingSilver;
	public static Item pipeFluidsElectrum;
	public static Item pipeFluidsWroughtIron;
	public static Item pipeFluidsSilver;
	public static Item pipeFluidsBronze;
	public static Item pipeFluidsNullify;
	public static Item pipeFluidsZinc;
	public static Item pipeFluidsBlueSteel;
	
	public static Item pipePowerBlueSteel;
	public static Item pipePowerElectrum;
	public static Item pipePowerSterlingSilver;
	public static Item pipePowerBronze;
	public static Item pipePowerSilver;
	public static Item pipePowerLead;
	public static Item pipePowerCopper;
	public static Item pipePowerRedSteel;
	public static Item pipePowerWroughtIron;
	
	public static Item pipeFrameZinc;
	public static Item pipeFrameLead;
	public static Item pipeFrameBlueSteel;
	public static Item pipeFrameRedSteel;
	public static Item pipeFrameElectrum;
	public static Item pipeFrameWroughtIron;
	public static Item pipeFrameSteel;
	public static Item pipeFrameBlackSteel;
	public static Item pipeFrameSterlingSilver;
	public static Item pipeFrameSilver;
	public static Item pipeFrameBronze;
	public static Item pipeFrameCopper;
	
	public static Item capacitorElectrode;
	public static Item mlccBlock;
	public static Item capacitorBaseLV;
	public static Item capacitorBaseMV;
	public static Item capacitorBaseHV;
	//===========================================
	
	// === Wires ================================
	public static Item tinWire;
	public static Item copperWire;
	public static Item goldWire;
	public static Item aluminumWire;
	public static Item electrumWire;
	public static Item ironWire;
	public static Item steelWire;
	
	public static Item unfinishedTinWire;
	public static Item unfinishedCopperWire;
	public static Item unfinishedGoldWire;
	public static Item unfinishedAluminumWire;
	public static Item unfinishedElectrumWire;
	public static Item unfinishedIronWire;
	public static Item unfinishedSteelWire;
	
	public static Item ironDrawplate;
	public static Item steelDrawplate;
	public static Item blackSteelDrawplate;
	
	public static Item oilcan;
	public static Item tongs;
	public static Item leatherBelt;
	public static Item winch;
	public static Item wireDrawBench;
	//===========================================
	
	// === Other ================================
	
	public static Item dixie;
	public static Item dixieBones;
	public static Item dixieGlue;
	public static Item glue;
	
	//===========================================
	
	public static void initialise() {
		TFCTech.LOG.info("Registering Items");

		setup();
		registerItems();
		registerMetals();
		
		if (TFCTech.enableBCCore)
			BCStuff.removeFromCreativeTab();

		TFCTech.LOG.info("Done Registering Items");
	}

	private static void setup() {
		
		// Dust
		aluminumDust = new ItemDust("Aluminum", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Aluminum Dust");
		bauxiteDust = new ItemDust("Aluminum", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Bauxite Dust");
		electrumDust = new ItemDust("Electrum", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Electrum Dust");
		constantanDust = new ItemDust("Constantan", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Constantan Dust");
		invarDust = new ItemDust("Invar", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Invar Dust");
		bismuthDust = new ItemDust("Bismuth", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Bismuth Dust");
		bismuthBronzeDust = new ItemDust("Bismuth Bronze", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Bismuth Bronze Dust");
		blackBronzeDust = new ItemDust("Black Bronze", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Black Bronze Dust");
		blackSteelDust = new ItemDust("Black Steel", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Black Steel Dust");
		blueSteelDust = new ItemDust("Blue Steel", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Blue Steel Dust");
		brassDust = new ItemDust("Brass", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Brass Dust");
		bronzeDust = new ItemDust("Bronze", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Bronze Dust");
		copperDust = new ItemDust("Copper", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Copper Dust");
		goldDust = new ItemDust("Gold", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Gold Dust");
		wroughtIronDust = new ItemDust("Wrought Iron", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Wrought Iron Dust");
		leadDust = new ItemDust("Lead", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Lead Dust");
		nickelDust = new ItemDust("Nickel", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Nickel Dust");
		pigIronDust = new ItemDust("Pig Iron", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Pig Iron Dust");
		platinumDust = new ItemDust("Platinum", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Platinum Dust");
		redSteelDust = new ItemDust("Red Steel", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Red Steel Dust");
		roseGoldDust = new ItemDust("Rose Gold", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Rose Gold Dust");
		silverDust = new ItemDust("Silver", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Silver Dust");
		steelDust = new ItemDust("Steel", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Steel Dust");
		sterlingSilverDust = new ItemDust("Sterling Silver", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Sterling Silver Dust");
		tinDust = new ItemDust("Tin", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Tin Dust");
		zincDust = new ItemDust("Zinc", ModOptions.cfgDustMetalAmount).setUnlocalizedName("Zinc Dust");

		// Nuggets
		aluminumNugget = new ItemNugget("Aluminum", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Aluminum Nugget");
		electrumNugget = new ItemNugget("Electrum", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Electrum Nugget");
		constantanNugget = new ItemNugget("Constantan", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Constantan Nugget");
		invarNugget = new ItemNugget("Invar", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Invar Nugget");
		bismuthNugget = new ItemNugget("Bismuth", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Bismuth Nugget");
		bismuthBronzeNugget = new ItemNugget("Bismuth Bronze", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Bismuth Bronze Nugget");
		blackBronzeNugget = new ItemNugget("Black Bronze", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Black Bronze Nugget");
		blackSteelNugget = new ItemNugget("Black Steel", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Black Steel Nugget");
		blueSteelNugget = new ItemNugget("Blue Steel", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Blue Steel Nugget");
		brassNugget = new ItemNugget("Brass", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Brass Nugget");
		bronzeNugget = new ItemNugget("Bronze", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Bronze Nugget");
		copperNugget = new ItemNugget("Copper", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Copper Nugget");
		goldNugget = new ItemNugget("Gold", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Gold Nugget");
		wroughtIronNugget = new ItemNugget("Wrought Iron", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Wrought Iron Nugget");
		leadNugget = new ItemNugget("Lead", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Lead Nugget");
		nickelNugget = new ItemNugget("Nickel", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Nickel Nugget");
		pigIronNugget = new ItemNugget("Pig Iron", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Pig Iron Nugget");
		platinumNugget = new ItemNugget("Platinum", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Platinum Nugget");
		redSteelNugget = new ItemNugget("Red Steel", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Red Steel Nugget");
		roseGoldNugget = new ItemNugget("Rose Gold", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Rose Gold Nugget");
		silverNugget = new ItemNugget("Silver", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Silver Nugget");
		steelNugget = new ItemNugget("Steel", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Steel Nugget");
		sterlingSilverNugget = new ItemNugget("Sterling Silver", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Sterling Silver Nugget");
		tinNugget = new ItemNugget("Tin", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Tin Nugget");
		zincNugget = new ItemNugget("Zinc", ModOptions.cfgNuggetMetalAmount).setUnlocalizedName("Zinc Nugget");

		// Ore
		oreChunk = new ItemModOre().setFolder("ore/").setUnlocalizedName("Ore");
		smallOreChunk = new ItemModOreSmall().setUnlocalizedName("Small Ore");
		gemQuartz = new ItemCraftComponent(EnumSize.TINY).setUnlocalizedName("Quartz");
		
		// Ingots
		aluminumIngot = new ItemModIngot("Aluminum", 100).setUnlocalizedName("Aluminum Ingot");
		aluminumIngot2x = new ItemModIngot("Aluminum", 200).setUnlocalizedName("Aluminum Double Ingot");
		aluminumUnshaped = new ItemModMeltedMetal().setUnlocalizedName("Aluminum Unshaped");
		electrumIngot = new ItemModIngot("Electrum", 100).setUnlocalizedName("Electrum Ingot");
		electrumIngot2x = new ItemModIngot("Electrum", 200).setUnlocalizedName("Electrum Double Ingot");
		electrumUnshaped = new ItemModMeltedMetal().setUnlocalizedName("Electrum Unshaped");
		constantanIngot = new ItemModIngot("Constantan", 100).setUnlocalizedName("Constantan Ingot");
		constantanIngot2x = new ItemModIngot("Constantan", 200).setUnlocalizedName("Constantan Double Ingot");
		constantanUnshaped = new ItemModMeltedMetal().setUnlocalizedName("Constantan Unshaped");
		invarIngot = new ItemModIngot("Invar", 100).setUnlocalizedName("Invar Ingot");
		invarIngot2x = new ItemModIngot("Invar", 200).setUnlocalizedName("Invar Double Ingot");
		invarUnshaped = new ItemModMeltedMetal().setUnlocalizedName("Invar Unshaped");

		// Plates
		aluminumPlate = new ItemPlate("Aluminum", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Aluminum Plate");
		electrumPlate = new ItemPlate("Electrum", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Electrum Plate");
		constantanPlate = new ItemPlate("Constantan", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Constantan Plate");
		invarPlate = new ItemPlate("Invar", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Invar Plate");
		bismuthPlate = new ItemPlate("Bismuth", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Bismuth Plate");
		bismuthBronzePlate = new ItemPlate("Bismuth Bronze", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Bismuth Bronze Plate");
		blackBronzePlate = new ItemPlate("Black Bronze", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Black Bronze Plate");
		blackSteelPlate = new ItemPlate("Black Steel", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Black Steel Plate");
		blueSteelPlate = new ItemPlate("Blue Steel", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Blue Steel Plate");
		brassPlate = new ItemPlate("Brass", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Brass Plate");
		bronzePlate = new ItemPlate("Bronze", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Bronze Plate");
		copperPlate = new ItemPlate("Copper", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Copper Plate");
		goldPlate = new ItemPlate("Gold", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Gold Plate");
		wroughtIronPlate = new ItemPlate("Wrought Iron", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Wrought Iron Plate");
		leadPlate = new ItemPlate("Lead", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Lead Plate");
		nickelPlate = new ItemPlate("Nickel", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Nickel Plate");
		pigIronPlate = new ItemPlate("Pig Iron", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Pig Iron Plate");
		platinumPlate = new ItemPlate("Platinum", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Platinum Plate");
		redSteelPlate = new ItemPlate("Red Steel", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Red Steel Plate");
		roseGoldPlate = new ItemPlate("Rose Gold", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Rose Gold Plate");
		silverPlate = new ItemPlate("Silver", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Silver Plate");
		steelPlate = new ItemPlate("Steel", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Steel Plate");
		sterlingSilverPlate = new ItemPlate("Sterling Silver", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Sterling Silver Plate");
		tinPlate = new ItemPlate("Tin", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Tin Plate");
		zincPlate = new ItemPlate("Zinc", ModOptions.cfgPlateMetalAmount).setUnlocalizedName("Zinc Plate");

		// Dense plates
		aluminumPlate2x = new ItemPlate("Aluminum", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Aluminum Plate");
		electrumPlate2x = new ItemPlate("Electrum", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Electrum Plate");
		constantanPlate2x = new ItemPlate("Constantan", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Constantan Plate");
		invarPlate2x = new ItemPlate("Invar", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Invar Plate");
		bismuthPlate2x = new ItemPlate("Bismuth", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Bismuth Plate");
		bismuthBronzePlate2x = new ItemPlate("Bismuth Bronze", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Bismuth Bronze Plate");
		blackBronzePlate2x = new ItemPlate("Black Bronze", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Black Bronze Plate");
		blackSteelPlate2x = new ItemPlate("Black Steel", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Black Steel Plate");
		blueSteelPlate2x = new ItemPlate("Blue Steel", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Blue Steel Plate");
		brassPlate2x = new ItemPlate("Brass", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Brass Plate");
		bronzePlate2x = new ItemPlate("Bronze", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Bronze Plate");
		copperPlate2x = new ItemPlate("Copper", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Copper Plate");
		goldPlate2x = new ItemPlate("Gold", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Gold Plate");
		wroughtIronPlate2x = new ItemPlate("Wrought Iron", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Wrought Iron Plate");
		leadPlate2x = new ItemPlate("Lead", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Lead Plate");
		nickelPlate2x = new ItemPlate("Nickel", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Nickel Plate");
		pigIronPlate2x = new ItemPlate("Pig Iron", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Pig Iron Plate");
		platinumPlate2x = new ItemPlate("Platinum", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Platinum Plate");
		redSteelPlate2x = new ItemPlate("Red Steel", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Red Steel Plate");
		roseGoldPlate2x = new ItemPlate("Rose Gold", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Rose Gold Plate");
		silverPlate2x = new ItemPlate("Silver", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Silver Plate");
		steelPlate2x = new ItemPlate("Steel", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Steel Plate");
		sterlingSilverPlate2x = new ItemPlate("Sterling Silver", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Sterling Silver Plate");
		tinPlate2x = new ItemPlate("Tin", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Tin Plate");
		zincPlate2x = new ItemPlate("Zinc", ModOptions.cfgPlate2xMetalAmount).setUnlocalizedName("Dense Zinc Plate");
		
		// == Sheets
		String[] names = {"Aluminum", "Electrum", "Constantan", "Invar"};
		
		int i = 0;
		aluminumSheet = new ItemModMetalSheet(names[i]).setUnlocalizedName(names[i] + " Sheet"); i++;
		electrumSheet = new ItemModMetalSheet(names[i]).setUnlocalizedName(names[i] + " Sheet"); i++;
		constantanSheet = new ItemModMetalSheet(names[i]).setUnlocalizedName(names[i] + " Sheet"); i++;
		invarSheet = new ItemModMetalSheet(names[i]).setUnlocalizedName(names[i] + " Sheet"); i++;
		
		i = 0;
		aluminumSheet2x = new ItemModMetalSheet2x(names[i]).setUnlocalizedName(names[i] + " Double Sheet"); i++;
		electrumSheet2x = new ItemModMetalSheet2x(names[i]).setUnlocalizedName(names[i] + " Double Sheet"); i++;
		constantanSheet2x = new ItemModMetalSheet2x(names[i]).setUnlocalizedName(names[i] + " Double Sheet"); i++;
		invarSheet2x = new ItemModMetalSheet2x(names[i]).setUnlocalizedName(names[i] + " Double Sheet"); i++;
		
		// == Gears
		bismuthBronzeGearPiece = new ItemGearPiece("Bismuth Bronze", 100).setUnlocalizedName("Bismuth Bronze Gear Piece");
		blackBronzeGearPiece = new ItemGearPiece("Black Bronze", 100).setUnlocalizedName("Black Bronze Gear Piece");
		blueSteelGearPiece = new ItemGearPiece("Blue Steel", 100).setUnlocalizedName("Blue Steel Gear Piece");
		brassGearPiece = new ItemGearPiece("Brass", 100).setUnlocalizedName("Brass Gear Piece");
		bronzeGearPiece = new ItemGearPiece("Bronze", 100).setUnlocalizedName("Bronze Gear Piece");
		copperGearPiece = new ItemGearPiece("Copper", 100).setUnlocalizedName("Copper Gear Piece");
		goldGearPiece = new ItemGearPiece("Gold", 100).setUnlocalizedName("Gold Gear Piece");
		wroughtIronGearPiece = new ItemGearPiece("Wrought Iron", 100).setUnlocalizedName("Wrought Iron Gear Piece");
		steelGearPiece = new ItemGearPiece("Steel", 100).setUnlocalizedName("Steel Gear Piece");
		tinGearPiece = new ItemGearPiece("Tin", 100).setUnlocalizedName("Tin Gear Piece");
		
		bismuthBronzeRackwheel = new ItemRackwheel("Bismuth Bronze", 400).setUnlocalizedName("Bismuth Bronze Rackwheel");
		blackBronzeRackwheel = new ItemRackwheel("Black Bronze", 400).setUnlocalizedName("Black Bronze Rackwheel");
		blueSteelRackwheel = new ItemRackwheel("Blue Steel", 400).setUnlocalizedName("Blue Steel Rackwheel");
		brassRackwheel = new ItemRackwheel("Brass", 400).setUnlocalizedName("Brass Rackwheel");
		bronzeRackwheel = new ItemRackwheel("Bronze", 400).setUnlocalizedName("Bronze Rackwheel");
		copperRackwheel = new ItemRackwheel("Copper", 400).setUnlocalizedName("Copper Rackwheel");
		goldRackwheel = new ItemRackwheel("Gold", 400).setUnlocalizedName("Gold Rackwheel");
		wroughtIronRackwheel = new ItemRackwheel("Wrought Iron", 400).setUnlocalizedName("Wrought Iron Rackwheel");
		steelRackwheel = new ItemRackwheel("Steel", 400).setUnlocalizedName("Steel Rackwheel");
		tinRackwheel = new ItemRackwheel("Tin", 400).setUnlocalizedName("Tin Rackwheel");
		
		bismuthBronzeGear = new ItemGear("Bismuth Bronze", 400, "Tin", 100).setUnlocalizedName("Bismuth Bronze Gear");
		blackBronzeGear = new ItemGear("Black Bronze", 400, "Tin", 100).setUnlocalizedName("Black Bronze Gear");
		blueSteelGear = new ItemGear("Blue Steel", 400, "Steel", 100).setUnlocalizedName("Blue Steel Gear");
		brassGear = new ItemGear("Brass", 400, "Tin", 100).setUnlocalizedName("Brass Gear");
		bronzeGear = new ItemGear("Bronze", 400, "Tin", 100).setUnlocalizedName("Bronze Gear");
		copperGear = new ItemGear("Copper", 400, "Tin", 100).setUnlocalizedName("Copper Gear");
		goldGear = new ItemGear("Gold", 400, "Brass", 100).setUnlocalizedName("Gold Gear");
		wroughtIronGear = new ItemGear("Wrought Iron", 400, "Brass", 100).setUnlocalizedName("Wrought Iron Gear");
		steelGear = new ItemGear("Steel", 400, "Brass", 100).setUnlocalizedName("Steel Gear");
		tinGear = new ItemGear("Tin", 400, "Tin", 100).setUnlocalizedName("Tin Gear");
		
		// == Sleeve
		brassSleeve = new ItemSleeve("Brass", 100).setUnlocalizedName("Brass Sleeve");
		steelSleeve = new ItemSleeve("Steel", 100).setUnlocalizedName("Steel Sleeve");
		tinSleeve = new ItemSleeve("Tin", 100).setUnlocalizedName("Tin Sleeve");
		
		// == Pottery
		clayMoldGearPiece = new ItemModPotteryMold(new String[]{"Clay Mold Gear Piece","Ceramic Mold Gear Piece",
				"Ceramic Mold Gear Piece Copper", //2
				"Ceramic Mold Gear Piece Bronze", //3
				"Ceramic Mold Gear Piece Bismuth Bronze", //4
				"Ceramic Mold Gear Piece Black Bronze", //5
				"Ceramic Mold Gear Piece Gold", //6
				"Ceramic Mold Gear Piece Tin", //7
				"Ceramic Mold Gear Piece Brass", //8
				"Ceramic Mold Gear Piece Wrought Iron", //9
				"Ceramic Mold Gear Piece Steel", //10
				"Ceramic Mold Gear Piece Blue Steel" //11
			}).setUnlocalizedName("Gear Piece Mold");
		
		clayMoldSleeve = new ItemModPotteryMold(new String[]{"Clay Mold Sleeve","Ceramic Mold Sleeve",
				"Ceramic Mold Sleeve Brass", //2
				"Ceramic Mold Sleeve Tin", //3
				"Ceramic Mold Sleeve Steel" //4
			}).setUnlocalizedName("Sleeve Mold");
		
		latexBowl = new ItemModPotteryLatexBowl().setUnlocalizedName("Latex Bowl");
		
		// == Stripes
		tinStripe = new ItemStripe("Tin", 50).setUnlocalizedName("Tin Stripe");
		aluminumStripe = new ItemStripe("Aluminum", 50).setUnlocalizedName("Aluminum Stripe");
		copperStripe = new ItemStripe("Copper", 50).setUnlocalizedName("Copper Stripe");
		goldStripe = new ItemStripe("Gold", 50).setUnlocalizedName("Gold Stripe");
		electrumStripe = new ItemStripe("Electrum", 50).setUnlocalizedName("Electrum Stripe");
		ironStripe = new ItemStripe("Wrought Iron", 50).setUnlocalizedName("Wrought Iron Stripe");
		steelStripe = new ItemStripe("Steel", 50).setUnlocalizedName("Steel Stripe");
		
		// == Device components
		groove = new ItemGroove("Wrought Iron", 50).setUnlocalizedName("Groove");
		mount = new ItemMount("Wrought Iron", 100).setUnlocalizedName("Bowl Mount");
		tongs = new ItemModMetalItem("Wrought Iron", 100, "devices").setUnlocalizedName("Tongs");
		leatherBelt = new ItemCraftComponent(EnumSize.SMALL).setFolder("devices/").setUnlocalizedName("Leather Belt");
		winch = new ItemCraftComponent(EnumSize.LARGE).setFolder("devices/").setUnlocalizedName("Winch");
		
		// == Devices
		wireDrawBench = new ItemWireDrawBench().setUnlocalizedName("Wire Draw Bench");
		
		// == Flora
		logHevea = new ItemHeveaLog().setUnlocalizedName("Log");
		Globals.LOGS.add(logHevea);
		
		// == Rubber
		chalkPowder = new ItemCraftComponent(EnumSize.TINY).setUnlocalizedName("Chalk Powder");
		vulcanizingAgents = new ItemCraftComponent(EnumSize.TINY).setUnlocalizedName("Vulcanizing Agents");
		rubberMix = new ItemCraftComponent(EnumSize.TINY).setUnlocalizedName("Rubber Mix");
		rubber = new ItemCraftComponent(EnumSize.TINY).setUnlocalizedName("Rubber");
		
		// == Cooking
		dixie = new ItemDixie("Wrought Iron", 100).setUnlocalizedName("Dixie");
		dixieBones = new ItemCraftComponent().setUnlocalizedName("Dixie Bones").setContainerItem(dixie);
		dixieGlue = new ItemCraftComponent().setUnlocalizedName("Dixie Glue").setContainerItem(dixie);
		glue = new ItemCraftComponent(EnumSize.TINY).setUnlocalizedName("Glue");
		
		// == Lime Paint
		limePaint = new ItemLimePaint().setUnlocalizedName("Lime Paint");
		
		// == Wire drawing
		names = new String[] {"Tin", "Copper", "Gold", "Aluminum", "Electrum", "Wrought Iron", "Steel"};
		String folder = "wires";
		String suffix = " Wire";
		
		i = 0;
		tinWire = new ItemModMetalItem(names[i], 50, folder).setUnlocalizedName(names[i] + suffix); i++;
		copperWire = new ItemModMetalItem(names[i], 50, folder).setUnlocalizedName(names[i] + suffix); i++;
		goldWire = new ItemModMetalItem(names[i], 50, folder).setUnlocalizedName(names[i] + suffix); i++;
		aluminumWire = new ItemModMetalItem(names[i], 50, folder).setUnlocalizedName(names[i] + suffix); i++;
		electrumWire = new ItemModMetalItem(names[i], 50, folder).setUnlocalizedName(names[i] + suffix); i++;
		ironWire = new ItemModMetalItem(names[i], 50, folder).setUnlocalizedName(names[i] + suffix); i++;
		steelWire = new ItemModMetalItem(names[i], 50, folder).setUnlocalizedName(names[i] + suffix); i++;
		
		i = 0;
		String prefix = "Unfinished ";
		unfinishedTinWire = new ItemUnfinishedWire(names[i], 50).setUnlocalizedName(prefix + names[i] + suffix); i++;
		unfinishedCopperWire = new ItemUnfinishedWire(names[i], 50).setUnlocalizedName(prefix + names[i] + suffix); i++;
		unfinishedGoldWire = new ItemUnfinishedWire(names[i], 50).setUnlocalizedName(prefix + names[i] + suffix); i++;
		unfinishedAluminumWire = new ItemUnfinishedWire(names[i], 50).setUnlocalizedName(prefix + names[i] + suffix); i++;
		unfinishedElectrumWire = new ItemUnfinishedWire(names[i], 50).setUnlocalizedName(prefix + names[i] + suffix); i++;
		unfinishedIronWire = new ItemUnfinishedWire(names[i], 50).setUnlocalizedName(prefix + names[i] + suffix); i++;
		unfinishedSteelWire = new ItemUnfinishedWire(names[i], 50).setUnlocalizedName(prefix + names[i] + suffix); i++;
		
		ironDrawplate = new ItemDrawplate(Global.WROUGHTIRON).setUnlocalizedName("Wrought Iron Drawplate").setMaxDamage(TFCItems.wroughtIronUses);
		steelDrawplate = new ItemDrawplate(Global.STEEL).setUnlocalizedName("Steel Drawplate").setMaxDamage(TFCItems.steelUses);
		blackSteelDrawplate = new ItemDrawplate(Global.BLACKSTEEL).setUnlocalizedName("Black Steel Drawplate").setMaxDamage(TFCItems.blackSteelUses);
		
		oilcan = new ItemOilCan().setUnlocalizedName("Oil Can");
		
		// == INTEGRATION =====================================================
		
		if (TFCTech.enableBCBuilders) {
			drillHead = new ItemCraftComponent().setUnlocalizedName("Drill Head");
		}
		
		if (TFCTech.enableIE) {
			potteryInsulatorPart = new ItemModPotteryBase().setMetaNames(new String[]
					{ "Clay Insulator Part", "Ceramic Insulator Part" }).setUnlocalizedName("Insulator Part").setCreativeTab(TFCTabs.TFC_POTTERY);
			potteryCeramicPlate = new ItemModPotteryBase().setMetaNames(new String[]
					{ "Clay Plate", "Ceramic Plate" }).setUnlocalizedName("Ceramic Plate").setCreativeTab(TFCTabs.TFC_POTTERY);
			capacitorElectrode = new ItemCraftComponent().setUnlocalizedName("Capacitor Electrode");
			mlccBlock = new ItemCraftComponent().setUnlocalizedName("MLCC Block");
			capacitorBaseLV = new ItemCraftComponent().setUnlocalizedName("LV Capacitor Base");
			capacitorBaseMV = new ItemCraftComponent().setUnlocalizedName("MV Capacitor Base");
			capacitorBaseHV = new ItemCraftComponent().setUnlocalizedName("HV Capacitor Base");
		}
		
		steelBucketEmpty = new ItemModSteelBucket(Blocks.air).setUnlocalizedName("Steel Bucket Empty");
		steelBucketLatex = new ItemModSteelBucket(ModBlocks.latex).setUnlocalizedName("Steel Bucket Latex").setContainerItem(steelBucketEmpty);
		
		if (TFCTech.enableBCCore)
			BCStuff.registerItems();
		
	}

	private static void registerItems() {

		// Dust
		GameRegistry.registerItem(aluminumDust, aluminumDust.getUnlocalizedName());
		GameRegistry.registerItem(bauxiteDust, bauxiteDust.getUnlocalizedName());
		GameRegistry.registerItem(constantanDust, constantanDust.getUnlocalizedName());
		GameRegistry.registerItem(electrumDust, electrumDust.getUnlocalizedName());
		GameRegistry.registerItem(invarDust, invarDust.getUnlocalizedName());
		GameRegistry.registerItem(bismuthDust, bismuthDust.getUnlocalizedName());
		GameRegistry.registerItem(bismuthBronzeDust, bismuthBronzeDust.getUnlocalizedName());
		GameRegistry.registerItem(blackBronzeDust, blackBronzeDust.getUnlocalizedName());
		GameRegistry.registerItem(blackSteelDust, blackSteelDust.getUnlocalizedName());
		GameRegistry.registerItem(blueSteelDust, blueSteelDust.getUnlocalizedName());
		GameRegistry.registerItem(brassDust, brassDust.getUnlocalizedName());
		GameRegistry.registerItem(bronzeDust, bronzeDust.getUnlocalizedName());
		GameRegistry.registerItem(copperDust, copperDust.getUnlocalizedName());
		GameRegistry.registerItem(goldDust, goldDust.getUnlocalizedName());
		GameRegistry.registerItem(wroughtIronDust, wroughtIronDust.getUnlocalizedName());
		GameRegistry.registerItem(leadDust, leadDust.getUnlocalizedName());
		GameRegistry.registerItem(nickelDust, nickelDust.getUnlocalizedName());
		GameRegistry.registerItem(pigIronDust, pigIronDust.getUnlocalizedName());
		GameRegistry.registerItem(platinumDust, platinumDust.getUnlocalizedName());
		GameRegistry.registerItem(redSteelDust, redSteelDust.getUnlocalizedName());
		GameRegistry.registerItem(roseGoldDust, roseGoldDust.getUnlocalizedName());
		GameRegistry.registerItem(silverDust, silverDust.getUnlocalizedName());
		GameRegistry.registerItem(steelDust, steelDust.getUnlocalizedName());
		GameRegistry.registerItem(sterlingSilverDust, sterlingSilverDust.getUnlocalizedName());
		GameRegistry.registerItem(tinDust, tinDust.getUnlocalizedName());
		GameRegistry.registerItem(zincDust, zincDust.getUnlocalizedName());

		// Nuggets
		GameRegistry.registerItem(aluminumNugget, aluminumNugget.getUnlocalizedName());
		GameRegistry.registerItem(constantanNugget, constantanNugget.getUnlocalizedName());
		GameRegistry.registerItem(electrumNugget, electrumNugget.getUnlocalizedName());
		GameRegistry.registerItem(invarNugget, invarNugget.getUnlocalizedName());
		GameRegistry.registerItem(bismuthNugget, bismuthNugget.getUnlocalizedName());
		GameRegistry.registerItem(bismuthBronzeNugget, bismuthBronzeNugget.getUnlocalizedName());
		GameRegistry.registerItem(blackBronzeNugget, blackBronzeNugget.getUnlocalizedName());
		GameRegistry.registerItem(blackSteelNugget, blackSteelNugget.getUnlocalizedName());
		GameRegistry.registerItem(blueSteelNugget, blueSteelNugget.getUnlocalizedName());
		GameRegistry.registerItem(brassNugget, brassNugget.getUnlocalizedName());
		GameRegistry.registerItem(bronzeNugget, bronzeNugget.getUnlocalizedName());
		GameRegistry.registerItem(copperNugget, copperNugget.getUnlocalizedName());
		GameRegistry.registerItem(goldNugget, goldNugget.getUnlocalizedName());
		GameRegistry.registerItem(wroughtIronNugget, wroughtIronNugget.getUnlocalizedName());
		GameRegistry.registerItem(leadNugget, leadNugget.getUnlocalizedName());
		GameRegistry.registerItem(nickelNugget, nickelNugget.getUnlocalizedName());
		GameRegistry.registerItem(pigIronNugget, pigIronNugget.getUnlocalizedName());
		GameRegistry.registerItem(platinumNugget, platinumNugget.getUnlocalizedName());
		GameRegistry.registerItem(redSteelNugget, redSteelNugget.getUnlocalizedName());
		GameRegistry.registerItem(roseGoldNugget, roseGoldNugget.getUnlocalizedName());
		GameRegistry.registerItem(silverNugget, silverNugget.getUnlocalizedName());
		GameRegistry.registerItem(steelNugget, steelNugget.getUnlocalizedName());
		GameRegistry.registerItem(sterlingSilverNugget, sterlingSilverNugget.getUnlocalizedName());
		GameRegistry.registerItem(tinNugget, tinNugget.getUnlocalizedName());
		GameRegistry.registerItem(zincNugget, zincNugget.getUnlocalizedName());

		// Ingots
		GameRegistry.registerItem(aluminumIngot, aluminumIngot.getUnlocalizedName());
		GameRegistry.registerItem(aluminumIngot2x, aluminumIngot2x.getUnlocalizedName());
		GameRegistry.registerItem(aluminumUnshaped, aluminumUnshaped.getUnlocalizedName());
		GameRegistry.registerItem(electrumIngot, electrumIngot.getUnlocalizedName());
		GameRegistry.registerItem(electrumIngot2x, electrumIngot2x.getUnlocalizedName());
		GameRegistry.registerItem(electrumUnshaped, electrumUnshaped.getUnlocalizedName());
		GameRegistry.registerItem(constantanIngot, constantanIngot.getUnlocalizedName());
		GameRegistry.registerItem(constantanIngot2x, constantanIngot2x.getUnlocalizedName());
		GameRegistry.registerItem(constantanUnshaped, constantanUnshaped.getUnlocalizedName());
		GameRegistry.registerItem(invarIngot, invarIngot.getUnlocalizedName());
		GameRegistry.registerItem(invarIngot2x, invarIngot2x.getUnlocalizedName());
		GameRegistry.registerItem(invarUnshaped, invarUnshaped.getUnlocalizedName());
		Globals.INGOTS.add(aluminumIngot);
		Globals.INGOTS.add(electrumIngot);
		Globals.INGOTS.add(constantanIngot);
		Globals.INGOTS.add(invarIngot);

		// Ores
		GameRegistry.registerItem(oreChunk, oreChunk.getUnlocalizedName());
		GameRegistry.registerItem(smallOreChunk, smallOreChunk.getUnlocalizedName());
		
		// Plates
		GameRegistry.registerItem(aluminumPlate, aluminumPlate.getUnlocalizedName());
		GameRegistry.registerItem(constantanPlate, constantanPlate.getUnlocalizedName());
		GameRegistry.registerItem(electrumPlate, electrumPlate.getUnlocalizedName());
		GameRegistry.registerItem(invarPlate, invarPlate.getUnlocalizedName());
		GameRegistry.registerItem(bismuthPlate, bismuthPlate.getUnlocalizedName());
		GameRegistry.registerItem(bismuthBronzePlate, bismuthBronzePlate.getUnlocalizedName());
		GameRegistry.registerItem(blackBronzePlate, blackBronzePlate.getUnlocalizedName());
		GameRegistry.registerItem(blackSteelPlate, blackSteelPlate.getUnlocalizedName());
		GameRegistry.registerItem(blueSteelPlate, blueSteelPlate.getUnlocalizedName());
		GameRegistry.registerItem(brassPlate, brassPlate.getUnlocalizedName());
		GameRegistry.registerItem(bronzePlate, bronzePlate.getUnlocalizedName());
		GameRegistry.registerItem(copperPlate, copperPlate.getUnlocalizedName());
		GameRegistry.registerItem(goldPlate, goldPlate.getUnlocalizedName());
		GameRegistry.registerItem(wroughtIronPlate, wroughtIronPlate.getUnlocalizedName());
		GameRegistry.registerItem(leadPlate, leadPlate.getUnlocalizedName());
		GameRegistry.registerItem(nickelPlate, nickelPlate.getUnlocalizedName());
		GameRegistry.registerItem(pigIronPlate, pigIronPlate.getUnlocalizedName());
		GameRegistry.registerItem(platinumPlate, platinumPlate.getUnlocalizedName());
		GameRegistry.registerItem(redSteelPlate, redSteelPlate.getUnlocalizedName());
		GameRegistry.registerItem(roseGoldPlate, roseGoldPlate.getUnlocalizedName());
		GameRegistry.registerItem(silverPlate, silverPlate.getUnlocalizedName());
		GameRegistry.registerItem(steelPlate, steelPlate.getUnlocalizedName());
		GameRegistry.registerItem(sterlingSilverPlate, sterlingSilverPlate.getUnlocalizedName());
		GameRegistry.registerItem(tinPlate, tinPlate.getUnlocalizedName());
		GameRegistry.registerItem(zincPlate, zincPlate.getUnlocalizedName());

		// Dense plates
		GameRegistry.registerItem(aluminumPlate2x, aluminumPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(constantanPlate2x, constantanPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(electrumPlate2x, electrumPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(invarPlate2x, invarPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(bismuthPlate2x, bismuthPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(bismuthBronzePlate2x, bismuthBronzePlate2x.getUnlocalizedName());
		GameRegistry.registerItem(blackBronzePlate2x, blackBronzePlate2x.getUnlocalizedName());
		GameRegistry.registerItem(blackSteelPlate2x, blackSteelPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(blueSteelPlate2x, blueSteelPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(brassPlate2x, brassPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(bronzePlate2x, bronzePlate2x.getUnlocalizedName());
		GameRegistry.registerItem(copperPlate2x, copperPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(goldPlate2x, goldPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(wroughtIronPlate2x, wroughtIronPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(leadPlate2x, leadPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(nickelPlate2x, nickelPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(pigIronPlate2x, pigIronPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(platinumPlate2x, platinumPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(redSteelPlate2x, redSteelPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(roseGoldPlate2x, roseGoldPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(silverPlate2x, silverPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(steelPlate2x, steelPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(sterlingSilverPlate2x, sterlingSilverPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(tinPlate2x, tinPlate2x.getUnlocalizedName());
		GameRegistry.registerItem(zincPlate2x, zincPlate2x.getUnlocalizedName());
		
		// Sheets
		GameRegistry.registerItem(aluminumSheet, aluminumSheet.getUnlocalizedName());
		GameRegistry.registerItem(electrumSheet, electrumSheet.getUnlocalizedName());
		GameRegistry.registerItem(constantanSheet, constantanSheet.getUnlocalizedName());
		GameRegistry.registerItem(invarSheet, invarSheet.getUnlocalizedName());
		GameRegistry.registerItem(aluminumSheet2x, aluminumSheet2x.getUnlocalizedName());
		GameRegistry.registerItem(electrumSheet2x, electrumSheet2x.getUnlocalizedName());
		GameRegistry.registerItem(constantanSheet2x, constantanSheet2x.getUnlocalizedName());
		GameRegistry.registerItem(invarSheet2x, invarSheet2x.getUnlocalizedName());
		
		// Flora
		GameRegistry.registerItem(logHevea, logHevea.getUnlocalizedName());
		
		// Tools
		GameRegistry.registerItem(latexBowl, latexBowl.getUnlocalizedName());
		
		// Rubber
		GameRegistry.registerItem(chalkPowder, chalkPowder.getUnlocalizedName());
		GameRegistry.registerItem(vulcanizingAgents, vulcanizingAgents.getUnlocalizedName());
		GameRegistry.registerItem(rubberMix, rubberMix.getUnlocalizedName());
		GameRegistry.registerItem(rubber, rubber.getUnlocalizedName());
		
		// Cooking
		GameRegistry.registerItem(dixie, dixie.getUnlocalizedName());
		GameRegistry.registerItem(dixieBones, dixieBones.getUnlocalizedName());
		GameRegistry.registerItem(dixieGlue, dixieGlue.getUnlocalizedName());
		GameRegistry.registerItem(glue, glue.getUnlocalizedName());
		
		// Dyes
		GameRegistry.registerItem(limePaint, limePaint.getUnlocalizedName());
		
		// Stripes
		GameRegistry.registerItem(tinStripe, tinStripe.getUnlocalizedName());
		GameRegistry.registerItem(aluminumStripe, aluminumStripe.getUnlocalizedName());
		GameRegistry.registerItem(copperStripe, copperStripe.getUnlocalizedName());
		GameRegistry.registerItem(goldStripe, goldStripe.getUnlocalizedName());
		GameRegistry.registerItem(electrumStripe, electrumStripe.getUnlocalizedName());
		GameRegistry.registerItem(ironStripe, ironStripe.getUnlocalizedName());
		GameRegistry.registerItem(steelStripe, steelStripe.getUnlocalizedName());
		
		// Device components
		GameRegistry.registerItem(groove, groove.getUnlocalizedName());
		GameRegistry.registerItem(mount, mount.getUnlocalizedName());
		GameRegistry.registerItem(winch, winch.getUnlocalizedName());
		GameRegistry.registerItem(leatherBelt, leatherBelt.getUnlocalizedName());
		GameRegistry.registerItem(tongs, tongs.getUnlocalizedName());
		
		// Devices
		GameRegistry.registerItem(wireDrawBench, wireDrawBench.getUnlocalizedName());
		
		// Wire drawing
		GameRegistry.registerItem(tinWire, tinWire.getUnlocalizedName());
		GameRegistry.registerItem(copperWire, copperWire.getUnlocalizedName());
		GameRegistry.registerItem(goldWire, goldWire.getUnlocalizedName());
		GameRegistry.registerItem(aluminumWire, aluminumWire.getUnlocalizedName());
		GameRegistry.registerItem(electrumWire, electrumWire.getUnlocalizedName());
		GameRegistry.registerItem(ironWire, ironWire.getUnlocalizedName());
		GameRegistry.registerItem(steelWire, steelWire.getUnlocalizedName());
		
		GameRegistry.registerItem(unfinishedTinWire, unfinishedTinWire.getUnlocalizedName());
		GameRegistry.registerItem(unfinishedCopperWire, unfinishedCopperWire.getUnlocalizedName());
		GameRegistry.registerItem(unfinishedGoldWire, unfinishedGoldWire.getUnlocalizedName());
		GameRegistry.registerItem(unfinishedAluminumWire, unfinishedAluminumWire.getUnlocalizedName());
		GameRegistry.registerItem(unfinishedElectrumWire, unfinishedElectrumWire.getUnlocalizedName());
		GameRegistry.registerItem(unfinishedIronWire, unfinishedIronWire.getUnlocalizedName());
		GameRegistry.registerItem(unfinishedSteelWire, unfinishedSteelWire.getUnlocalizedName());
		
		GameRegistry.registerItem(ironDrawplate, ironDrawplate.getUnlocalizedName());
		GameRegistry.registerItem(steelDrawplate, steelDrawplate.getUnlocalizedName());
		GameRegistry.registerItem(blackSteelDrawplate, blackSteelDrawplate.getUnlocalizedName());

		GameRegistry.registerItem(oilcan, oilcan.getUnlocalizedName());

		// == Integration =====================================================
		
		GameRegistry.registerItem(clayMoldGearPiece, clayMoldGearPiece.getUnlocalizedName());
		GameRegistry.registerItem(clayMoldSleeve, clayMoldSleeve.getUnlocalizedName());
		
		// == Gears
		GameRegistry.registerItem(bismuthBronzeGearPiece, bismuthBronzeGearPiece.getUnlocalizedName());
		GameRegistry.registerItem(blackBronzeGearPiece, blackBronzeGearPiece.getUnlocalizedName());
		GameRegistry.registerItem(blueSteelGearPiece, blueSteelGearPiece.getUnlocalizedName());
		GameRegistry.registerItem(brassGearPiece, brassGearPiece.getUnlocalizedName());
		GameRegistry.registerItem(bronzeGearPiece, bronzeGearPiece.getUnlocalizedName());
		GameRegistry.registerItem(copperGearPiece, copperGearPiece.getUnlocalizedName());
		GameRegistry.registerItem(goldGearPiece, goldGearPiece.getUnlocalizedName());
		GameRegistry.registerItem(wroughtIronGearPiece, wroughtIronGearPiece.getUnlocalizedName());
		GameRegistry.registerItem(steelGearPiece, steelGearPiece.getUnlocalizedName());
		GameRegistry.registerItem(tinGearPiece, tinGearPiece.getUnlocalizedName());
		
		GameRegistry.registerItem(bismuthBronzeRackwheel, bismuthBronzeRackwheel.getUnlocalizedName());
		GameRegistry.registerItem(blackBronzeRackwheel, blackBronzeRackwheel.getUnlocalizedName());
		GameRegistry.registerItem(blueSteelRackwheel, blueSteelRackwheel.getUnlocalizedName());
		GameRegistry.registerItem(brassRackwheel, brassRackwheel.getUnlocalizedName());
		GameRegistry.registerItem(bronzeRackwheel, bronzeRackwheel.getUnlocalizedName());
		GameRegistry.registerItem(copperRackwheel, copperRackwheel.getUnlocalizedName());
		GameRegistry.registerItem(goldRackwheel, goldRackwheel.getUnlocalizedName());
		GameRegistry.registerItem(wroughtIronRackwheel, wroughtIronRackwheel.getUnlocalizedName());
		GameRegistry.registerItem(steelRackwheel, steelRackwheel.getUnlocalizedName());
		GameRegistry.registerItem(tinRackwheel, tinRackwheel.getUnlocalizedName());
		
		GameRegistry.registerItem(bismuthBronzeGear, bismuthBronzeGear.getUnlocalizedName());
		GameRegistry.registerItem(blackBronzeGear, blackBronzeGear.getUnlocalizedName());
		GameRegistry.registerItem(blueSteelGear, blueSteelGear.getUnlocalizedName());
		GameRegistry.registerItem(brassGear, brassGear.getUnlocalizedName());
		GameRegistry.registerItem(bronzeGear, bronzeGear.getUnlocalizedName());
		GameRegistry.registerItem(copperGear, copperGear.getUnlocalizedName());
		GameRegistry.registerItem(goldGear, goldGear.getUnlocalizedName());
		GameRegistry.registerItem(wroughtIronGear, wroughtIronGear.getUnlocalizedName());
		GameRegistry.registerItem(steelGear, steelGear.getUnlocalizedName());
		GameRegistry.registerItem(tinGear, tinGear.getUnlocalizedName());
		
		// == Sleeve
		GameRegistry.registerItem(brassSleeve, brassSleeve.getUnlocalizedName());
		GameRegistry.registerItem(steelSleeve, steelSleeve.getUnlocalizedName());
		GameRegistry.registerItem(tinSleeve, tinSleeve.getUnlocalizedName());
		
		bronzeGears = new Item[] {bismuthBronzeGear, blackBronzeGear, bronzeGear};
		
		GameRegistry.registerItem(gemQuartz, gemQuartz.getUnlocalizedName());
		GameRegistry.registerItem(steelBucketEmpty, steelBucketEmpty.getUnlocalizedName());
		GameRegistry.registerItem(steelBucketLatex, steelBucketLatex.getUnlocalizedName());
		
		if (TFCTech.enableBCEnergy) {
			GameRegistry.registerItem(steelBucketOil, steelBucketOil.getUnlocalizedName());
			GameRegistry.registerItem(steelBucketFuel, steelBucketFuel.getUnlocalizedName());
		}
		
		if (TFCTech.enableBCBuilders) {
			GameRegistry.registerItem(drillHead, drillHead.getUnlocalizedName());
		}
		
		if (TFCTech.enableBCTransport) {
			GameRegistry.registerItem(pipeFrameZinc, pipeFrameZinc.getUnlocalizedName());
			GameRegistry.registerItem(pipeFrameLead, pipeFrameLead.getUnlocalizedName());
			GameRegistry.registerItem(pipeFrameBlueSteel, pipeFrameBlueSteel.getUnlocalizedName());
			GameRegistry.registerItem(pipeFrameRedSteel, pipeFrameRedSteel.getUnlocalizedName());
			GameRegistry.registerItem(pipeFrameElectrum, pipeFrameElectrum.getUnlocalizedName());
			GameRegistry.registerItem(pipeFrameWroughtIron, pipeFrameWroughtIron.getUnlocalizedName());
			GameRegistry.registerItem(pipeFrameSteel, pipeFrameSteel.getUnlocalizedName());
			GameRegistry.registerItem(pipeFrameBlackSteel, pipeFrameBlackSteel.getUnlocalizedName());
			GameRegistry.registerItem(pipeFrameSterlingSilver, pipeFrameSterlingSilver.getUnlocalizedName());
			GameRegistry.registerItem(pipeFrameSilver, pipeFrameSilver.getUnlocalizedName());
			GameRegistry.registerItem(pipeFrameBronze, pipeFrameBronze.getUnlocalizedName());
			GameRegistry.registerItem(pipeFrameCopper, pipeFrameCopper.getUnlocalizedName());
		}
		
		if (TFCTech.enableIE) {
			GameRegistry.registerItem(potteryInsulatorPart, potteryInsulatorPart.getUnlocalizedName());
			GameRegistry.registerItem(potteryCeramicPlate, potteryCeramicPlate.getUnlocalizedName());
			GameRegistry.registerItem(capacitorElectrode, capacitorElectrode.getUnlocalizedName());
			GameRegistry.registerItem(mlccBlock, mlccBlock.getUnlocalizedName());
			GameRegistry.registerItem(capacitorBaseLV, capacitorBaseLV.getUnlocalizedName());
			GameRegistry.registerItem(capacitorBaseMV, capacitorBaseMV.getUnlocalizedName());
			GameRegistry.registerItem(capacitorBaseHV, capacitorBaseHV.getUnlocalizedName());
		}
		
		// ====================================================================
		
	}

	private static void registerMetals() {

		//Aluminum
		Globals.ALUMINUM = new Metal("Aluminum", ModItems.aluminumUnshaped, ModItems.aluminumIngot);
		MetalRegistry.instance.addMetal(Globals.ALUMINUM, Alloy.EnumTier.TierI);
		
		//Electrum
		Globals.ELECTRUM = new Metal("Electrum", ModItems.electrumUnshaped, ModItems.electrumIngot);
		MetalRegistry.instance.addMetal(Globals.ELECTRUM, Alloy.EnumTier.TierI);
		
		//Constantan
		Globals.CONSTANTAN = new Metal("Constantan", ModItems.constantanUnshaped, ModItems.constantanIngot);
		MetalRegistry.instance.addMetal(Globals.CONSTANTAN, Alloy.EnumTier.TierI);
		
		//Invar
		Globals.INVAR = new Metal("Invar", ModItems.invarUnshaped, ModItems.invarIngot);
		MetalRegistry.instance.addMetal(Globals.INVAR, Alloy.EnumTier.TierIII);
		
		Alloy electrum = new Alloy(Globals.ELECTRUM, Alloy.EnumTier.TierI);
		electrum.addIngred(Global.GOLD, 37.00f, 63.00f);
		electrum.addIngred(Global.SILVER, 37.00f, 63.00f);
		AlloyManager.INSTANCE.addAlloy(electrum);

		Alloy constantan = new Alloy(Globals.CONSTANTAN, Alloy.EnumTier.TierI);
		constantan.addIngred(Global.COPPER, 55.00f, 65.00f);
		constantan.addIngred(Global.NICKEL, 35.00f, 45.00f);
		AlloyManager.INSTANCE.addAlloy(constantan);

		Alloy invar = new Alloy(Globals.INVAR, Alloy.EnumTier.TierIII);
		invar.addIngred(Global.WROUGHTIRON, 60.00f, 70.00f);
		invar.addIngred(Global.NICKEL, 30.00f, 40.00f);
		AlloyManager.INSTANCE.addAlloy(invar);
		
	}
	
}
