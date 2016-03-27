package ua.pp.shurgent.tfctech.core;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.core.ColorManager.Color;
import buildcraft.BuildCraftBuilders;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftFactory;
import buildcraft.BuildCraftRobotics;
import buildcraft.BuildCraftSilicon;
import buildcraft.BuildCraftTransport;
import buildcraft.silicon.ItemRedstoneChipset;

import com.bioxx.tfc.Core.Recipes;
import com.bioxx.tfc.Handlers.TFCFuelHandler;
import com.bioxx.tfc.api.TFCBlocks;
import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Crafting.AnvilManager;
import com.bioxx.tfc.api.Crafting.AnvilRecipe;
import com.bioxx.tfc.api.Crafting.AnvilReq;
import com.bioxx.tfc.api.Crafting.BarrelManager;
import com.bioxx.tfc.api.Crafting.BarrelRecipe;
import com.bioxx.tfc.api.Crafting.CraftingManagerTFC;
import com.bioxx.tfc.api.Crafting.KilnCraftingManager;
import com.bioxx.tfc.api.Crafting.KilnRecipe;
import com.bioxx.tfc.api.Crafting.PlanRecipe;
import com.bioxx.tfc.api.Crafting.QuernManager;
import com.bioxx.tfc.api.Crafting.QuernRecipe;
import com.bioxx.tfc.api.Enums.RuleEnum;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipes
{	
	public static Item[] meltedMetal;
	public static Item[] bronzeGears;
	
	public static boolean anvilRecipesInitialised = false;
	
	public static final int WILDCARD_VALUE = OreDictionary.WILDCARD_VALUE;
	
	private static AnvilManager anvilManager = AnvilManager.getInstance();
	private static BarrelManager barrelManager = BarrelManager.getInstance();
	private static CraftingManagerTFC craftingManager = CraftingManagerTFC.getInstance();
	private static KilnCraftingManager kilnCraftingManager = KilnCraftingManager.getInstance();
	private static QuernManager quernManager = QuernManager.getInstance();
	
	public static void initialise()
	{
		TFCTech.LOG.info("Registering Recipes");
		
		removeVanilaRecipes();
		registerBarrelRecipes();
		registerRecipes();
		registerQuernRecipes();
		
		// == Integration
		removeBCRecipes();
		registerBCRecipes();
		
		registerFurnaceFuel();
		registerFurnaceRecipes();
		TFCTech.LOG.info("Done Registering Recipes");
	}

	private static void registerFurnaceFuel() {
		TFCFuelHandler.registerFuel(ModItems.logHevea, ModOptions.cfgFuelValueHeveaLog);
		TFCFuelHandler.registerFuel(ModItems.rubber, ModOptions.cfgFuelValueRubber);
	}

	private static void registerFurnaceRecipes() {
		
		if (ModOptions.cfgEnableFurnaceClayFiring) {
			addSmelting(TFCItems.ceramicMold);
			addSmelting(TFCItems.spindleHead);
			addSmelting(TFCItems.potteryJug);
			addSmelting(TFCItems.potterySmallVessel);
			addSmelting(TFCItems.potteryBowl);
			addSmelting(TFCBlocks.vessel);
			addSmelting(TFCItems.fireBrick);

			addSmelting(TFCItems.clayMoldAxe);
			addSmelting(TFCItems.clayMoldAxe);
			addSmelting(TFCItems.clayMoldChisel);
			addSmelting(TFCItems.clayMoldHammer);
			addSmelting(TFCItems.clayMoldHoe);
			addSmelting(TFCItems.clayMoldKnife);
			addSmelting(TFCItems.clayMoldMace);
			addSmelting(TFCItems.clayMoldPick);
			addSmelting(TFCItems.clayMoldProPick);
			addSmelting(TFCItems.clayMoldSaw);
			addSmelting(TFCItems.clayMoldScythe);
			addSmelting(TFCItems.clayMoldShovel);
			addSmelting(TFCItems.clayMoldSword);
			addSmelting(TFCItems.clayMoldJavelin);
			
			addSmelting(ModItems.latexBowl);
			addSmelting(ModItems.clayMoldGearPiece);
			addSmelting(ModItems.clayMoldSleeve);
		}
		
		if (ModOptions.cfgEnableFurnaceRubberFiring)
			addSmelting(ModItems.rubberMix, ModItems.rubber, 1);
		
	}
	
	public static void addSmelting(Object input) {
		if (input instanceof Block)
			GameRegistry.addSmelting((Block)input, new ItemStack((Block)input, 1, 1), 0);
		else if (input instanceof Item)
			GameRegistry.addSmelting(new ItemStack((Item)input, 1, 0), new ItemStack((Item)input, 1, 1), 0);
	}
	
	public static void addSmelting(Item in, Item out) {
		addSmelting(in, out, 0);
	}
	
	public static void addSmelting(Item in, Item out, int xp) {
		GameRegistry.addSmelting(in, new ItemStack(out), xp);
	}
	
	private static void registerQuernRecipes() {
		quernManager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.looseRock, 1, 10), new ItemStack(ModItems.chalkPowder, 4))); //Chalk Rock to Chalk Powder
	}

	private static void registerBarrelRecipes() {
		barrelManager.addRecipe(new BarrelRecipe(new ItemStack(ModItems.vulcanizingAgents, 1), new FluidStack(ModFluids.LATEX, 100), new ItemStack(ModItems.rubberMix, 6), new FluidStack(ModFluids.LATEX, 100)).setMinTechLevel(0));
	}

	private static void removeVanilaRecipes() {

		removeRecipe(new ItemStack(Items.comparator));
		removeRecipe(new ItemStack(Blocks.daylight_detector));
		removeRecipe(new ItemStack(Blocks.piston));
		removeRecipe(new ItemStack(Blocks.sticky_piston));
		
		// Remove vanila dye recipes
		/*for (int i = 0; i < 16; i++)
			for (int j = 1; j <= 4; j++)
				removeRecipe(new ItemStack(Items.dye, j, i));*/
	}

	public static void initialiseAnvil()
	{
		// check if the plans/recipes have already been initialised.
		if (ModRecipes.areAnvilRecipesInitialised()) return;
		
		TFCTech.LOG.info("Registering Anvil Recipes");
		
		registerAnvilPlans();
		registerAnvilRecipes();
		anvilRecipesInitialised = true;
		
		TFCTech.LOG.info("Done Registering Anvil Recipes");
	}

    public static boolean areAnvilRecipesInitialised() 
    { 
        return anvilRecipesInitialised;
    } 

	private static void registerAnvilPlans()
	{
		anvilManager.addPlan("groove", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.BENDSECONDFROMLAST, RuleEnum.BENDTHIRDFROMLAST }));
		anvilManager.addPlan("mount", new PlanRecipe(new RuleEnum[] { RuleEnum.BENDLAST, RuleEnum.DRAWSECONDFROMLAST, RuleEnum.DRAWNOTLAST }));
		anvilManager.addPlan("dixie", new PlanRecipe(new RuleEnum[] { RuleEnum.BENDLAST, RuleEnum.BENDSECONDFROMLAST, RuleEnum.BENDTHIRDFROMLAST }));
		
		if (TFCTech.enableBCCore) {
			anvilManager.addPlan("wrench", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.DRAWSECONDFROMLAST, RuleEnum.BENDTHIRDFROMLAST }));
		}
		
		if (TFCTech.enableBCTransport) {
			anvilManager.addPlan("frame", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.BENDNOTLAST, RuleEnum.DRAWNOTLAST }));
		}
	}
	
	private static void registerAnvilRecipes()
	{
		// Double ingots welding recipes
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.aluminumIngot), new ItemStack(ModItems.aluminumIngot), AnvilReq.STONE, new ItemStack(ModItems.aluminumIngot2x, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.electrumIngot), new ItemStack(ModItems.electrumIngot), AnvilReq.COPPER, new ItemStack(ModItems.electrumIngot2x, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.constantanIngot), new ItemStack(ModItems.constantanIngot), AnvilReq.WROUGHTIRON, new ItemStack(ModItems.constantanIngot2x, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.invarIngot), new ItemStack(ModItems.invarIngot), AnvilReq.WROUGHTIRON, new ItemStack(ModItems.invarIngot2x, 1)));
		
		// Gears welding recipes
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.bismuthBronzeRackwheel), new ItemStack(ModItems.tinSleeve), AnvilReq.COPPER, new ItemStack(ModItems.bismuthBronzeGear, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.blackBronzeRackwheel), new ItemStack(ModItems.tinSleeve), AnvilReq.COPPER, new ItemStack(ModItems.blackBronzeGear, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.blueSteelRackwheel), new ItemStack(ModItems.steelSleeve), AnvilReq.BLACKSTEEL, new ItemStack(ModItems.blueSteelGear, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.brassRackwheel), new ItemStack(ModItems.tinSleeve), AnvilReq.COPPER, new ItemStack(ModItems.brassGear, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.bronzeRackwheel), new ItemStack(ModItems.tinSleeve), AnvilReq.COPPER, new ItemStack(ModItems.bronzeGear, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.copperRackwheel), new ItemStack(ModItems.tinSleeve), AnvilReq.STONE, new ItemStack(ModItems.copperGear, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.goldRackwheel), new ItemStack(ModItems.brassSleeve), AnvilReq.COPPER, new ItemStack(ModItems.goldGear, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.wroughtIronRackwheel), new ItemStack(ModItems.brassSleeve), AnvilReq.BRONZE, new ItemStack(ModItems.wroughtIronGear, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.steelRackwheel), new ItemStack(ModItems.brassSleeve), AnvilReq.WROUGHTIRON, new ItemStack(ModItems.steelGear, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.tinRackwheel), new ItemStack(ModItems.tinSleeve), AnvilReq.STONE, new ItemStack(ModItems.tinGear, 1)));
		
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "mount", AnvilReq.WROUGHTIRON, new ItemStack(ModItems.mount, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(ModItems.stripe), null, "groove", AnvilReq.WROUGHTIRON, new ItemStack(ModItems.groove, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronSheet), null, "dixie", AnvilReq.WROUGHTIRON, new ItemStack(ModItems.dixie, 1)));
		
		// == Integration =====================================================
		
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelSheet), null, "bucket", AnvilReq.STEEL, new ItemStack(ModItems.steelBucketEmpty, 1)));
		
		// Buildcraft
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
	
	private static void registerRecipes()
	{
		/**
		 *  Vanila
		 */
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.comparator),
			" R ", "RQR", "SSS",
			'R', Blocks.redstone_torch,
			'Q', ModItems.gemQuartz,
			'S', "stone"
		));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.daylight_detector),
			"GGG", "QQQ", "WWW",
			'G', "paneGlass",
			'Q', ModItems.gemQuartz,
			'W', "plankWood"
		));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.piston),
			"WWW", "CIC", "CRC",
			'W', "plankWood",
			'C', "stoneSmooth",
			'I', TFCItems.wroughtIronIngot,
			'R', "dustRedstone"
		));
			
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.sticky_piston), Blocks.piston, "materialGlue"));
				
		/**
		 *  Nuggets
		 */
		// Tier 1
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.aluminumNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(ModItems.aluminumIngot, 1), "itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.bismuthNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.bismuthIngot, 1), "itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.copperNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.copperIngot, 1), "itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.goldNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.goldIngot, 1), "itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.leadNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.leadIngot, 1), "itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.nickelNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.nickelIngot, 1), "itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.silverNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.silverIngot, 1), "itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.tinNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.tinIngot, 1), "itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.zincNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.zincIngot, 1), "itemChisel"));
		// Tier 2
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.bismuthBronzeNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.bismuthBronzeIngot, 1), "itemChiselNormal"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.blackBronzeNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.blackBronzeIngot, 1), "itemChiselNormal"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.bronzeNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.bronzeIngot, 1), "itemChiselNormal"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.brassNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.brassIngot, 1), "itemChiselNormal"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.electrumNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(ModItems.electrumIngot, 1), "itemChiselNormal"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.constantanNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(ModItems.constantanIngot, 1), "itemChiselNormal"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.sterlingSilverNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.sterlingSilverIngot, 1), "itemChiselNormal"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.roseGoldNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.roseGoldIngot, 1), "itemChiselNormal"));
		// Tier 3
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.wroughtIronNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.wroughtIronIngot, 1), "itemChiselMedium"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.pigIronNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.pigIronIngot, 1), "itemChiselMedium"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.invarNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(ModItems.invarIngot, 1), "itemChiselNormal"));
		// Tier 4
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.steelNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.steelIngot, 1), "itemChiselHard"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.blackSteelNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.blackSteelIngot, 1), "itemChiselHard"));
		// Tier 5
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.platinumNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.platinumIngot, 1), "itemChiselHard"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.redSteelNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.redSteelIngot, 1), "itemChiselHard"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.blueSteelNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.blueSteelIngot, 1), "itemChiselHard"));
		
		//Ingot -> Unshaped
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.aluminumUnshaped, 1, 0),
				Recipes.getStackNoTemp(new ItemStack(ModItems.aluminumIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.electrumUnshaped, 1, 0),
				Recipes.getStackNoTemp(new ItemStack(ModItems.electrumIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.constantanUnshaped, 1, 0),
				Recipes.getStackNoTemp(new ItemStack(ModItems.constantanIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.invarUnshaped, 1, 0),
				Recipes.getStackNoTemp(new ItemStack(ModItems.invarIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1));
		
		//Unshaped -> Ingot
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.aluminumIngot, 1, 0),
				Recipes.getStackNoTemp(new ItemStack(ModItems.aluminumUnshaped, 1)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.electrumIngot, 1, 0),
				Recipes.getStackNoTemp(new ItemStack(ModItems.electrumUnshaped, 1)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.constantanIngot, 1, 0),
				Recipes.getStackNoTemp(new ItemStack(ModItems.constantanUnshaped, 1)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.invarIngot, 1, 0),
				Recipes.getStackNoTemp(new ItemStack(ModItems.invarUnshaped, 1)));
		
		/**
		 *  Rackwheels
		 */
		GameRegistry.addRecipe(new ItemStack(ModItems.bismuthBronzeRackwheel, 1), "##", "##", '#', ModItems.bismuthBronzeGearPiece);
		GameRegistry.addRecipe(new ItemStack(ModItems.blackBronzeRackwheel, 1), "##", "##", '#', ModItems.blackBronzeGearPiece);
		GameRegistry.addRecipe(new ItemStack(ModItems.blueSteelRackwheel, 1), "##", "##", '#', ModItems.blueSteelGearPiece);
		GameRegistry.addRecipe(new ItemStack(ModItems.brassRackwheel, 1), "##", "##", '#', ModItems.brassGearPiece);
		GameRegistry.addRecipe(new ItemStack(ModItems.bronzeRackwheel, 1), "##", "##", '#', ModItems.bronzeGearPiece);
		GameRegistry.addRecipe(new ItemStack(ModItems.copperRackwheel, 1), "##", "##", '#', ModItems.copperGearPiece);
		GameRegistry.addRecipe(new ItemStack(ModItems.goldRackwheel, 1), "##", "##", '#', ModItems.goldGearPiece);
		GameRegistry.addRecipe(new ItemStack(ModItems.wroughtIronRackwheel, 1), "##", "##", '#', ModItems.wroughtIronGearPiece);
		GameRegistry.addRecipe(new ItemStack(ModItems.steelRackwheel, 1), "##", "##", '#', ModItems.steelGearPiece);
		GameRegistry.addRecipe(new ItemStack(ModItems.tinRackwheel, 1), "##", "##", '#', ModItems.tinGearPiece);
		
		/**
		 *  Device components
		 */
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.stripe, 4), new ItemStack(TFCItems.wroughtIronSheet, 1), "itemChiselMedium"));
		
		/**
		 *  Rubber components
		 */
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.vulcanizingAgents, 4),
				"dustGraphite", "dustKaolinite", "dustChalk", "dustSulfur"
		));
		
		/**
		 *  Cooking
		 */
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.dixieBones, 1), new Object[] {
				ModItems.dixie,
				"bucketFreshWater",
				Items.bone,
				Items.bone,
				Items.bone,
				Items.bone
		}));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.bone, 4), new Object[] {
			new ItemStack(ModItems.dixieBones, 1)
			});
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.glue, ModOptions.cfgGlueQtyFromBucket), new Object[] {
			new ItemStack(ModItems.dixieGlue, 1)
			});
		
		/**
		 *  Flora
		 */
		// Hevea Log --> Sycamore lumber
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(TFCItems.singlePlank, 8, 11), new ItemStack(ModItems.logHevea, 1), "itemSaw"));
		
		/**
		 *  Dye Bottles
		 */
		// Base colors
		registerDyeRecipe("black", new ItemStack(TFCItems.dye, 1, 0));
		registerDyeRecipe("blue", new ItemStack(TFCItems.powder, 1, 6));
		registerDyeRecipe("yellow", new ItemStack(TFCItems.powder, 1, 7));
		registerDyeRecipe("green", new ItemStack(TFCItems.powder, 1, 8));
		registerDyeRecipe("white", new ItemStack(TFCItems.dye, 1, 15));
		registerDyeRecipe("red", new ItemStack(TFCItems.powder, 1, 5));
		
		// Color mixes
		registerDyeRecipe("lime", new String[] {"green", "white"});
		registerDyeRecipe("cyan", new String[] {"blue", "green"});
		registerDyeRecipe("gray", new String[] {"black", "white"});
		registerDyeRecipe("orange", new String[] {"red", "yellow"});
		registerDyeRecipe("brown", new String[] {"red", "black"});
		registerDyeRecipe("pink", new String[] {"red", "white"});
		registerDyeRecipe("silver", new String[] {"gray", "white"});
		registerDyeRecipe("silver", new String[] {"black", "white", "white"});
		registerDyeRecipe("light_blue", new String[] {"blue", "white"});
		registerDyeRecipe("purple", new String[] {"red", "blue"});
		registerDyeRecipe("magenta", new String[] {"purple", "pink"});
		registerDyeRecipe("magenta", new String[] {"blue", "red", "pink"});
		registerDyeRecipe("magenta", new String[] {"blue", "red", "red", "white"});
		
		registerPottery();
		registerKilnRecipes();
		registerMolds();
		
	}
	
	private static void registerDyeRecipe(String resultDye, ItemStack input) {
		ItemStack out = new ItemStack(ModItems.dyeBottle, 1, Color.fromName(resultDye).ordinal());
		GameRegistry.addShapelessRecipe(out, new Object[] {
				TFCItems.vodka, // FIXME: Container item dupe. Create glass jar for dyes instead of glass bottle.
				input
		});
	}

	private static void registerDyeRecipe(String resultDye, String[] inputs) {
		ItemStack out = new ItemStack(ModItems.dyeBottle, inputs.length, Color.fromName(resultDye).ordinal());
		Object[] in = new ItemStack[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			in[i] = new ItemStack(ModItems.dyeBottle, 1, Color.fromName(inputs[i]).ordinal()); // FIXME: Bottles dupe
		}
		GameRegistry.addShapelessRecipe(out, in);
	}
	
	private static void registerPottery() {

		craftingManager.addRecipe(new ItemStack(ModItems.clayMoldGearPiece, 1), new Object[] {
			"#    ",
			"# ## ",
			"#### ",
			" ##  ",
			"  ###",
			'#', new ItemStack(TFCItems.flatClay, 1, 1)});
		
		craftingManager.addRecipe(new ItemStack(ModItems.clayMoldSleeve, 1), new Object[] {
			"     ",
			"  #  ",
			" # # ",
			"  #  ",
			"     ",
			'#', new ItemStack(TFCItems.flatClay, 1, 1)});
		
		craftingManager.addRecipe(new ItemStack(ModItems.latexBowl, 2), new Object[] {
			"#####",
			"#####",
			" ### ",
			" ### ",
			"#   #",
			'#', new ItemStack(TFCItems.flatClay, 1, 1)});
		
	}

	private static void registerMolds() {
		
		// == Mold pouring ====================================================
		
		registerMoldPouring(ModItems.clayMoldGearPiece, 2, TFCItems.copperUnshaped);
		registerMoldPouring(ModItems.clayMoldGearPiece, 3, TFCItems.bronzeUnshaped);
		registerMoldPouring(ModItems.clayMoldGearPiece, 4, TFCItems.bismuthBronzeUnshaped);
		registerMoldPouring(ModItems.clayMoldGearPiece, 5, TFCItems.blackBronzeUnshaped);
		registerMoldPouring(ModItems.clayMoldGearPiece, 6, TFCItems.goldUnshaped);
		registerMoldPouring(ModItems.clayMoldGearPiece, 7, TFCItems.tinUnshaped);
		registerMoldPouring(ModItems.clayMoldGearPiece, 8, TFCItems.brassUnshaped);
		registerMoldPouring(ModItems.clayMoldGearPiece, 9, TFCItems.wroughtIronUnshaped);
		registerMoldPouring(ModItems.clayMoldGearPiece, 10, TFCItems.steelUnshaped);
		registerMoldPouring(ModItems.clayMoldGearPiece, 11, TFCItems.blueSteelUnshaped);
		
		registerMoldPouring(ModItems.clayMoldSleeve, 2, TFCItems.brassUnshaped);
		registerMoldPouring(ModItems.clayMoldSleeve, 3, TFCItems.tinUnshaped);
		registerMoldPouring(ModItems.clayMoldSleeve, 4, TFCItems.steelUnshaped);
		
		// == Finished parts ==================================================
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.copperGearPiece), Recipes.getStackNoTemp(new ItemStack(ModItems.clayMoldGearPiece, 1, 2)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bronzeGearPiece), Recipes.getStackNoTemp(new ItemStack(ModItems.clayMoldGearPiece, 1, 3)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bismuthBronzeGearPiece), Recipes.getStackNoTemp(new ItemStack(ModItems.clayMoldGearPiece, 1, 4)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.blackBronzeGearPiece), Recipes.getStackNoTemp(new ItemStack(ModItems.clayMoldGearPiece, 1, 5)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.goldGearPiece), Recipes.getStackNoTemp(new ItemStack(ModItems.clayMoldGearPiece, 1, 6)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tinGearPiece), Recipes.getStackNoTemp(new ItemStack(ModItems.clayMoldGearPiece, 1, 7)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.brassGearPiece), Recipes.getStackNoTemp(new ItemStack(ModItems.clayMoldGearPiece, 1, 8)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.wroughtIronGearPiece), Recipes.getStackNoTemp(new ItemStack(ModItems.clayMoldGearPiece, 1, 9)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.steelGearPiece), Recipes.getStackNoTemp(new ItemStack(ModItems.clayMoldGearPiece, 1, 10)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.blueSteelGearPiece), Recipes.getStackNoTemp(new ItemStack(ModItems.clayMoldGearPiece, 1, 11)));
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.brassSleeve), Recipes.getStackNoTemp(new ItemStack(ModItems.clayMoldSleeve, 1, 2)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tinSleeve), Recipes.getStackNoTemp(new ItemStack(ModItems.clayMoldSleeve, 1, 3)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.steelSleeve), Recipes.getStackNoTemp(new ItemStack(ModItems.clayMoldSleeve, 1, 4)));
		
	}
	
	private static void registerMoldPouring(Item mold, int meta, Item unshaped) {
		
		craftingManager.addRecipe(new ItemStack(mold, 1, meta), new Object[] {"12",
			'1', Recipes.getStackTemp(new ItemStack(unshaped, 1, 1)),
			'2', new ItemStack(mold, 1, 1)});
	}
	
	private static void registerKilnRecipes() {

		kilnCraftingManager.addRecipe(new KilnRecipe(new ItemStack(ModItems.clayMoldGearPiece, 1, 0), 0, new ItemStack(ModItems.clayMoldGearPiece, 1, 1)));
		kilnCraftingManager.addRecipe(new KilnRecipe(new ItemStack(ModItems.clayMoldSleeve, 1, 0), 0, new ItemStack(ModItems.clayMoldSleeve, 1, 1)));

	}
	
	@SuppressWarnings("unchecked")
	public static void removeRecipe(ItemStack resultItem)
	{
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		for (int i = 0; i < recipes.size(); i++)
		{
			if (recipes.get(i) != null)
			{
				ItemStack recipeResult = recipes.get(i).getRecipeOutput();

				if (ItemStack.areItemStacksEqual(resultItem, recipeResult))
					recipes.remove(i--);
			}
		}
	}
	
	/*************************
	 *  INTEGRATION SECTION  *
	 *************************/

	// === Buildcraft =========================================================
	
	private static void removeBCRecipes() {

		// == BC Core =========================================================
		if (TFCTech.enableBCCore) {
			removeRecipe(new ItemStack(BuildCraftCore.stoneGearItem));
			removeRecipe(new ItemStack(BuildCraftCore.woodenGearItem));
			removeRecipe(new ItemStack(BuildCraftCore.ironGearItem));
			removeRecipe(new ItemStack(BuildCraftCore.goldGearItem));
			removeRecipe(new ItemStack(BuildCraftCore.diamondGearItem));
			
			removeRecipe(new ItemStack(BuildCraftCore.wrenchItem));
			removeRecipe(new ItemStack(BuildCraftCore.paintbrushItem));
			removeRecipe(new ItemStack(BuildCraftCore.markerBlock));
			removeRecipe(new ItemStack(BuildCraftCore.pathMarkerBlock));

			removeRecipe(new ItemStack(BuildCraftCore.engineBlock, 1, 0));
			removeRecipe(new ItemStack(BuildCraftCore.engineBlock, 1, 1));
			removeRecipe(new ItemStack(BuildCraftCore.engineBlock, 1, 2));
			
			/*
			for (int i = 0; i < 16; i++) {
				ItemStack outputStack = new ItemStack(BuildCraftCore.paintbrushItem);
				NBTUtils.getItemData(outputStack).setByte("color", (byte) i);
				removeRecipe(outputStack);
			}
			*/
		}

		// == BC Builders =====================================================
		if (TFCTech.enableBCBuilders) {
			removeRecipe(new ItemStack(BuildCraftBuilders.quarryBlock));
			removeRecipe(new ItemStack(BuildCraftBuilders.fillerBlock));
			removeRecipe(new ItemStack(BuildCraftBuilders.libraryBlock));
			removeRecipe(new ItemStack(BuildCraftBuilders.constructionMarkerBlock));
			removeRecipe(new ItemStack(BuildCraftBuilders.blueprintItem));
			removeRecipe(new ItemStack(BuildCraftBuilders.builderBlock));
			removeRecipe(new ItemStack(BuildCraftBuilders.architectBlock));
		}

		// == BC Energy =======================================================
		if (TFCTech.enableBCEnergy) {
			// Nothing to remove yet
		}

		// == BC Factory ======================================================
		if (TFCTech.enableBCFactory) {
			removeRecipe(new ItemStack(BuildCraftFactory.miningWellBlock));
			removeRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock));
			removeRecipe(new ItemStack(BuildCraftFactory.pumpBlock));
			removeRecipe(new ItemStack(BuildCraftFactory.floodGateBlock));
			removeRecipe(new ItemStack(BuildCraftFactory.tankBlock));
			removeRecipe(new ItemStack(BuildCraftFactory.refineryBlock));
			removeRecipe(new ItemStack(BuildCraftFactory.hopperBlock));
		}

		// == BC Robotics =====================================================
		if (TFCTech.enableBCRobotics) {
			removeRecipe(new ItemStack(BuildCraftRobotics.requesterBlock));
			removeRecipe(new ItemStack(BuildCraftRobotics.zonePlanBlock));
			removeRecipe(new ItemStack(BuildCraftRobotics.robotItem));
			removeRecipe(new ItemStack(BuildCraftRobotics.robotStationItem));
		}

		// == BC Silicon ======================================================
		if (TFCTech.enableBCSilicon) {
			
			removeRecipe(new ItemStack(BuildCraftSilicon.laserBlock));
			removeRecipe(new ItemStack(BuildCraftSilicon.packagerBlock));
			for (int i = 0; i <= 5; i++) {
				removeRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, i));
			}
			
		}

		// == BC Transport ======================================================
		if (TFCTech.enableBCTransport) {
			removeRecipe(new ItemStack(BuildCraftTransport.powerAdapterItem, 4));
			removeRecipe(new ItemStack(BuildCraftTransport.filteredBufferBlock));
			
			removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsWood, 8));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsCobblestone, 8));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsClay, 8));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsStone, 8));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsIron, 8));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsGold, 8));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsDiamond, 8));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsEmerald, 8));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsVoid, 8));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsSandstone, 8));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsObsidian, 8));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsDaizuli, 8));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsLapis, 8));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsQuartz, 8));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsEmzuli, 8));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsStripes, 8));
			
			removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsWood));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsCobblestone));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsClay));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsStone));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsIron));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsGold));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsEmerald));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsDiamond));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsVoid));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsSandstone));
			removeRecipe(new ItemStack(BuildCraftTransport.pipeFluidsQuartz));

			removeRecipe(new ItemStack(BuildCraftTransport.pipeStructureCobblestone, 8));
			removeRecipe(new ItemStack(BuildCraftTransport.plugItem, 4));

			removeRecipe(new ItemStack(BuildCraftTransport.pipePowerCobblestone));
			removeRecipe(new ItemStack(BuildCraftTransport.pipePowerStone));
			removeRecipe(new ItemStack(BuildCraftTransport.pipePowerSandstone));
			removeRecipe(new ItemStack(BuildCraftTransport.pipePowerWood));
			removeRecipe(new ItemStack(BuildCraftTransport.pipePowerIron));
			removeRecipe(new ItemStack(BuildCraftTransport.pipePowerQuartz));
			removeRecipe(new ItemStack(BuildCraftTransport.pipePowerGold));
			removeRecipe(new ItemStack(BuildCraftTransport.pipePowerDiamond));
			removeRecipe(new ItemStack(BuildCraftTransport.pipePowerEmerald));
			
			for (int i = 0; i <= 16; i++) {
				removeRecipe(new ItemStack(BuildCraftTransport.pipeItemsVoid, 8, i));
			}
		}

	}

	private static void registerBCRecipes() {

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
			
			for (Item gear : bronzeGears) {
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
	
}