package ua.pp.shurgent.tfctech.core;

import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.api.crafting.DrawplateReq;
import ua.pp.shurgent.tfctech.api.crafting.WireDrawBenchManager;
import ua.pp.shurgent.tfctech.api.crafting.WireDrawBenchRecipe;
import ua.pp.shurgent.tfctech.integration.bc.TFCTechBCRecipes;
import ua.pp.shurgent.tfctech.integration.ie.TFCTechIERecipes;

import com.bioxx.tfc.Core.Recipes;
import com.bioxx.tfc.Handlers.TFCFuelHandler;
import com.bioxx.tfc.api.TFCBlocks;
import com.bioxx.tfc.api.TFCFluids;
import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Constant.Global;
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

public class ModRecipes {
	public static final int WILDCARD_VALUE = OreDictionary.WILDCARD_VALUE;
	
	private static BarrelManager barrelManager = BarrelManager.getInstance();
	private static CraftingManagerTFC craftingManager = CraftingManagerTFC.getInstance();
	private static KilnCraftingManager kilnManager = KilnCraftingManager.getInstance();
	private static QuernManager quernManager = QuernManager.getInstance();
	
	public static void initialise() {
		TFCTech.LOG.info("Registering Recipes");
		
		removeVanilaRecipes();
		registerBarrelRecipes();
		registerRecipes();
		registerQuernRecipes();
		registerWireDrawBenchRecipes();
		
		// == Integration
		if (TFCTech.enableBCCore)
			TFCTechBCRecipes.removeBCRecipes();
		if (TFCTech.enableIE)
			TFCTechIERecipes.removeIERecipes();
		
		if (TFCTech.enableBCCore)
			TFCTechBCRecipes.registerBCRecipes();
		if (TFCTech.enableIE)
			TFCTechIERecipes.registerIERecipes(craftingManager, kilnManager, barrelManager);
		
		registerFurnaceFuel();
		registerFurnaceRecipes();
		TFCTech.LOG.info("Done Registering Recipes");
	}
	
	private static void registerWireDrawBenchRecipes() {
		
		WireDrawBenchManager manager = WireDrawBenchManager.getInstance();
		
		manager.addDrawplate(ModItems.ironDrawplate, DrawplateReq.WROUGHTIRON);
		manager.addDrawplate(ModItems.steelDrawplate, DrawplateReq.STEEL);
		manager.addDrawplate(ModItems.blackSteelDrawplate, DrawplateReq.BLACKSTEEL);
		
		registerWireRecipesWithStages(manager, ModItems.unfinishedTinWire, ModItems.tinWire, DrawplateReq.WROUGHTIRON, false, "Tin");
		registerWireRecipesWithStages(manager, ModItems.unfinishedAluminumWire, ModItems.aluminumWire, DrawplateReq.WROUGHTIRON, false, "Aluminum");
		registerWireRecipesWithStages(manager, ModItems.unfinishedCopperWire, ModItems.copperWire, DrawplateReq.WROUGHTIRON, false, "Copper");
		registerWireRecipesWithStages(manager, ModItems.unfinishedElectrumWire, ModItems.electrumWire, DrawplateReq.WROUGHTIRON, false, "Electrum");
		registerWireRecipesWithStages(manager, ModItems.unfinishedGoldWire, ModItems.goldWire, DrawplateReq.WROUGHTIRON, false, "Gold");
		registerWireRecipesWithStages(manager, ModItems.unfinishedIronWire, ModItems.ironWire, DrawplateReq.STEEL, true, "Wrought Iron");
		registerWireRecipesWithStages(manager, ModItems.unfinishedSteelWire, ModItems.steelWire, DrawplateReq.BLACKSTEEL, true, "Steel");
		registerWireRecipesWithStages(manager, ModItems.unfinishedRedAlloyWire, ModItems.redAlloyWire, DrawplateReq.WROUGHTIRON, false, "Red Alloy");
		
	}
	
	private static void registerWireRecipesWithStages(WireDrawBenchManager manager, Item input, Item output, DrawplateReq req, boolean oil, String metal) {
		
		manager.addRecipe(new WireDrawBenchRecipe(new ItemStack(input, 1, 0), new ItemStack(input, 1, 1), req, oil));
		manager.addRecipe(new WireDrawBenchRecipe(new ItemStack(input, 1, 1), new ItemStack(input, 1, 2), req, oil));
		manager.addRecipe(new WireDrawBenchRecipe(new ItemStack(input, 1, 2), new ItemStack(output), req, oil));
		
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
			GameRegistry.addSmelting((Block) input, new ItemStack((Block) input, 1, 1), 0);
		else if (input instanceof Item)
			GameRegistry.addSmelting(new ItemStack((Item) input, 1, 0), new ItemStack((Item) input, 1, 1), 0);
	}
	
	public static void addSmelting(Item in, Item out) {
		addSmelting(in, out, 0);
	}
	
	public static void addSmelting(Item in, Item out, int xp) {
		GameRegistry.addSmelting(in, new ItemStack(out), xp);
	}
	
	private static void registerQuernRecipes() {
		quernManager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.looseRock, 1, 10), new ItemStack(ModItems.chalkPowder, 4))); // Chalk Rock to Chalk Powder
	}
	
	private static void registerBarrelRecipes() {
		barrelManager.addRecipe(new BarrelRecipe(new ItemStack(ModItems.vulcanizingAgents, 1), new FluidStack(ModFluids.LATEX, 100), new ItemStack(
				ModItems.rubberMix, 6), new FluidStack(ModFluids.LATEX, 100)).setMinTechLevel(0));
	}
	
	private static void removeVanilaRecipes() {
		
		removeRecipe(new ItemStack(Items.comparator));
		removeRecipe(new ItemStack(Blocks.daylight_detector));
		removeRecipe(new ItemStack(Blocks.piston));
		removeRecipe(new ItemStack(Blocks.sticky_piston));
		
		// Remove vanila dye recipes
		for (int i = 0; i < 16; i++)
			for (int j = 1; j <= 4; j++)
				removeRecipe(new ItemStack(Items.dye, j, i));
	}
	
	public static void initialiseAnvil(World world) {
		AnvilManager anvilManager = AnvilManager.getInstance();
		AnvilManager.world = world;
		
		TFCTech.LOG.info("Registering Anvil Recipes");
		
		registerAnvilPlans(anvilManager);
		registerAnvilRecipes(anvilManager);
		
		TFCTech.LOG.info("Done Registering Anvil Recipes");
	}
	
	public static boolean areAnvilRecipesInitialised() {
		Map<String, PlanRecipe> map = AnvilManager.getInstance().getPlans();
		return map.containsKey("groove");
	}
	
	private static void registerAnvilPlans(AnvilManager anvilManager) {
		anvilManager.addPlan("groove", new PlanRecipe(new RuleEnum[] {
				RuleEnum.HITLAST,
				RuleEnum.BENDSECONDFROMLAST,
				RuleEnum.BENDTHIRDFROMLAST
		}));
		anvilManager.addPlan("mount", new PlanRecipe(new RuleEnum[] {
				RuleEnum.BENDLAST,
				RuleEnum.DRAWSECONDFROMLAST,
				RuleEnum.DRAWNOTLAST
		}));
		anvilManager.addPlan("dixie", new PlanRecipe(new RuleEnum[] {
				RuleEnum.BENDLAST,
				RuleEnum.BENDSECONDFROMLAST,
				RuleEnum.BENDTHIRDFROMLAST
		}));
		anvilManager.addPlan("wire", new PlanRecipe(new RuleEnum[] {
				RuleEnum.DRAWLAST,
				RuleEnum.DRAWNOTLAST,
				RuleEnum.ANY
		}));
		anvilManager.addPlan("drawplate", new PlanRecipe(new RuleEnum[] {
				RuleEnum.PUNCHLAST,
				RuleEnum.PUNCHSECONDFROMLAST,
				RuleEnum.HITANY
		}));
		anvilManager.addPlan("tongs", new PlanRecipe(new RuleEnum[] {
				RuleEnum.HITLAST,
				RuleEnum.DRAWSECONDFROMLAST,
				RuleEnum.BENDTHIRDFROMLAST
		}));
		anvilManager.addPlan("oilcan", new PlanRecipe(new RuleEnum[] {
				RuleEnum.BENDLAST,
				RuleEnum.BENDSECONDFROMLAST,
				RuleEnum.BENDTHIRDFROMLAST
		}));
		
		if (TFCTech.enableBCCore) {
			anvilManager.addPlan("wrench", new PlanRecipe(new RuleEnum[] {
					RuleEnum.HITLAST,
					RuleEnum.DRAWSECONDFROMLAST,
					RuleEnum.BENDTHIRDFROMLAST
			}));
		}
		
		if (TFCTech.enableBCTransport) {
			anvilManager.addPlan("frame", new PlanRecipe(new RuleEnum[] {
					RuleEnum.HITLAST,
					RuleEnum.BENDNOTLAST,
					RuleEnum.DRAWNOTLAST
			}));
		}
	}
	
	private static void registerAnvilRecipes(AnvilManager anvilManager) {
		// Double ingots welding recipes
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.aluminumIngot), new ItemStack(ModItems.aluminumIngot), AnvilReq.STONE, new ItemStack(
				ModItems.aluminumIngot2x, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.electrumIngot), new ItemStack(ModItems.electrumIngot), AnvilReq.COPPER,
				new ItemStack(ModItems.electrumIngot2x, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.constantanIngot), new ItemStack(ModItems.constantanIngot), AnvilReq.WROUGHTIRON,
				new ItemStack(ModItems.constantanIngot2x, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.invarIngot), new ItemStack(ModItems.invarIngot), AnvilReq.WROUGHTIRON, new ItemStack(
				ModItems.invarIngot2x, 1)));
		
		// Gears welding recipes
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.bismuthBronzeRackwheel), new ItemStack(ModItems.tinSleeve), AnvilReq.COPPER,
				new ItemStack(ModItems.bismuthBronzeGear, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.blackBronzeRackwheel), new ItemStack(ModItems.tinSleeve), AnvilReq.COPPER,
				new ItemStack(ModItems.blackBronzeGear, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.blueSteelRackwheel), new ItemStack(ModItems.steelSleeve), AnvilReq.BLACKSTEEL,
				new ItemStack(ModItems.blueSteelGear, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.brassRackwheel), new ItemStack(ModItems.tinSleeve), AnvilReq.COPPER, new ItemStack(
				ModItems.brassGear, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.bronzeRackwheel), new ItemStack(ModItems.tinSleeve), AnvilReq.COPPER, new ItemStack(
				ModItems.bronzeGear, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.copperRackwheel), new ItemStack(ModItems.tinSleeve), AnvilReq.STONE, new ItemStack(
				ModItems.copperGear, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.goldRackwheel), new ItemStack(ModItems.brassSleeve), AnvilReq.COPPER, new ItemStack(
				ModItems.goldGear, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.wroughtIronRackwheel), new ItemStack(ModItems.brassSleeve), AnvilReq.BRONZE,
				new ItemStack(ModItems.wroughtIronGear, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.steelRackwheel), new ItemStack(ModItems.brassSleeve), AnvilReq.WROUGHTIRON,
				new ItemStack(ModItems.steelGear, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.tinRackwheel), new ItemStack(ModItems.tinSleeve), AnvilReq.STONE, new ItemStack(
				ModItems.tinGear, 1)));
		
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "mount", AnvilReq.WROUGHTIRON, new ItemStack(ModItems.mount, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(ModItems.ironStripe), null, "groove", AnvilReq.WROUGHTIRON, new ItemStack(ModItems.groove, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronSheet), null, "dixie", AnvilReq.WROUGHTIRON, new ItemStack(ModItems.dixie, 1)));
		
		// Sheets
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(ModItems.aluminumIngot2x), null, "sheet", AnvilReq.COPPER,
				new ItemStack(ModItems.aluminumSheet, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(ModItems.electrumIngot2x), null, "sheet", AnvilReq.COPPER,
				new ItemStack(ModItems.electrumSheet, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(ModItems.constantanIngot2x), null, "sheet", AnvilReq.WROUGHTIRON, new ItemStack(
				ModItems.constantanSheet, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(ModItems.invarIngot2x), null, "sheet", AnvilReq.STEEL, new ItemStack(ModItems.invarSheet, 1)));
		
		// Double Sheets welding recipes
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.aluminumSheet), new ItemStack(ModItems.aluminumSheet), AnvilReq.COPPER,
				new ItemStack(ModItems.aluminumSheet2x, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.electrumSheet), new ItemStack(ModItems.electrumSheet), AnvilReq.COPPER,
				new ItemStack(ModItems.electrumSheet2x, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.constantanSheet), new ItemStack(ModItems.constantanSheet), AnvilReq.WROUGHTIRON,
				new ItemStack(ModItems.constantanSheet2x, 1)));
		anvilManager.addWeldRecipe(new AnvilRecipe(new ItemStack(ModItems.invarSheet), new ItemStack(ModItems.invarSheet), AnvilReq.STEEL, new ItemStack(
				ModItems.invarSheet2x, 1)));
		
		// Unfinished wires forging
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(ModItems.tinStripe), null, "wire", AnvilReq.STONE, new ItemStack(ModItems.unfinishedTinWire, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(ModItems.copperStripe), null, "wire", AnvilReq.COPPER, new ItemStack(ModItems.unfinishedCopperWire, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(ModItems.goldStripe), null, "wire", AnvilReq.COPPER, new ItemStack(ModItems.unfinishedGoldWire, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(ModItems.aluminumStripe), null, "wire", AnvilReq.COPPER, new ItemStack(ModItems.unfinishedAluminumWire, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(ModItems.electrumStripe), null, "wire", AnvilReq.COPPER, new ItemStack(ModItems.unfinishedElectrumWire, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(ModItems.ironStripe), null, "wire", AnvilReq.WROUGHTIRON, new ItemStack(ModItems.unfinishedIronWire, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(ModItems.steelStripe), null, "wire", AnvilReq.STEEL, new ItemStack(ModItems.unfinishedSteelWire, 1)));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(ModItems.redAlloyIngot), null, "wire", AnvilReq.WROUGHTIRON, new ItemStack(ModItems.unfinishedRedAlloyWire, 2)));
		
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "tongs", AnvilReq.WROUGHTIRON, new ItemStack(ModItems.tongs, 1)).addRecipeSkill(Global.SKILL_TOOLSMITH));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "drawplate", AnvilReq.WROUGHTIRON, new ItemStack(ModItems.ironDrawplate, 1)).addRecipeSkill(Global.SKILL_TOOLSMITH));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "drawplate", AnvilReq.STEEL, new ItemStack(ModItems.steelDrawplate, 1)).addRecipeSkill(Global.SKILL_TOOLSMITH));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "drawplate", AnvilReq.BLACKSTEEL, new ItemStack(ModItems.blackSteelDrawplate, 1)).addRecipeSkill(Global.SKILL_TOOLSMITH));
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.brassSheet), null, "oilcan", AnvilReq.BRONZE, new ItemStack(ModItems.oilcan, 1)));
		
		// == Integration =====================================================
		
		anvilManager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelSheet), null, "bucket", AnvilReq.STEEL, new ItemStack(ModItems.steelBucketEmpty, 1)));
		
		// Buildcraft
		if (TFCTech.enableBCCore)
			TFCTechBCRecipes.registerAnvilRecipes(anvilManager);
	}
	
	private static void registerRecipes() {
		/**
		 * Vanila
		 */
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.comparator),
				" R ", "RQR", "SSS",
				'R', Blocks.redstone_torch,
				'Q', "gemQuartz",
				'S', "stone"
		));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.daylight_detector),
				"GGG", "QQQ", "WWW",
				'G', "paneGlass",
				'Q', "gemQuartz",
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
		 * Nuggets
		 */
		// Tier 1
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.aluminumNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(
				ModItems.aluminumIngot, 1), "itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.bismuthNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(
				TFCItems.bismuthIngot, 1), "itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.copperNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.copperIngot,
				1), "itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.goldNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.goldIngot, 1),
				"itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.leadNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.leadIngot, 1),
				"itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.nickelNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.nickelIngot,
				1), "itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.silverNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.silverIngot,
				1), "itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.tinNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.tinIngot, 1),
				"itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.zincNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.zincIngot, 1),
				"itemChisel"));
		// Tier 2
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.bismuthBronzeNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(
				TFCItems.bismuthBronzeIngot, 1), "itemChiselNormal"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.blackBronzeNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(
				TFCItems.blackBronzeIngot, 1), "itemChiselNormal"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.bronzeNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(TFCItems.bronzeIngot,
				1), "itemChiselNormal"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.brassNugget, ModOptions.cfgNuggetsFromIngot),
				new ItemStack(TFCItems.brassIngot, 1), "itemChiselNormal"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.electrumNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(
				ModItems.electrumIngot, 1), "itemChiselNormal"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.constantanNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(
				ModItems.constantanIngot, 1), "itemChiselNormal"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.sterlingSilverNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(
				TFCItems.sterlingSilverIngot, 1), "itemChiselNormal"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.roseGoldNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(
				TFCItems.roseGoldIngot, 1), "itemChiselNormal"));
		// Tier 3
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.wroughtIronNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(
				TFCItems.wroughtIronIngot, 1), "itemChiselMedium"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.pigIronNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(
				TFCItems.pigIronIngot, 1), "itemChiselMedium"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.invarNugget, ModOptions.cfgNuggetsFromIngot),
				new ItemStack(ModItems.invarIngot, 1), "itemChiselNormal"));
		// Tier 4
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.steelNugget, ModOptions.cfgNuggetsFromIngot),
				new ItemStack(TFCItems.steelIngot, 1), "itemChiselHard"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.blackSteelNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(
				TFCItems.blackSteelIngot, 1), "itemChiselHard"));
		// Tier 5
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.platinumNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(
				TFCItems.platinumIngot, 1), "itemChiselNormal"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.redSteelNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(
				TFCItems.redSteelIngot, 1), "itemChiselHard"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.blueSteelNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(
				TFCItems.blueSteelIngot, 1), "itemChiselHard"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.redAlloyNugget, ModOptions.cfgNuggetsFromIngot), new ItemStack(
				ModItems.redAlloyIngot, 1), "itemChiselNormal"));
		
		// Ingot -> Unshaped
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.aluminumUnshaped, 1, 0), Recipes.getStackNoTemp(new ItemStack(ModItems.aluminumIngot, 1)),
				new ItemStack(TFCItems.ceramicMold, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.electrumUnshaped, 1, 0), Recipes.getStackNoTemp(new ItemStack(ModItems.electrumIngot, 1)),
				new ItemStack(TFCItems.ceramicMold, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.constantanUnshaped, 1, 0), Recipes.getStackNoTemp(new ItemStack(ModItems.constantanIngot, 1)),
				new ItemStack(TFCItems.ceramicMold, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.invarUnshaped, 1, 0), Recipes.getStackNoTemp(new ItemStack(ModItems.invarIngot, 1)),
				new ItemStack(TFCItems.ceramicMold, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.redAlloyUnshaped, 1, 0), Recipes.getStackNoTemp(new ItemStack(ModItems.redAlloyIngot, 1)),
				new ItemStack(TFCItems.ceramicMold, 1, 1));
		
		// Unshaped -> Ingot
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.aluminumIngot, 1, 0), Recipes.getStackNoTemp(new ItemStack(ModItems.aluminumUnshaped, 1)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.electrumIngot, 1, 0), Recipes.getStackNoTemp(new ItemStack(ModItems.electrumUnshaped, 1)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.constantanIngot, 1, 0), Recipes.getStackNoTemp(new ItemStack(ModItems.constantanUnshaped, 1)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.invarIngot, 1, 0), Recipes.getStackNoTemp(new ItemStack(ModItems.invarUnshaped, 1)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.redAlloyIngot, 1, 0), Recipes.getStackNoTemp(new ItemStack(ModItems.redAlloyUnshaped, 1)));
		
		/**
		 * Rackwheels
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
		 * Stripes
		 */
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.tinStripe, 4), new ItemStack(TFCItems.tinSheet, 1), "itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.aluminumStripe, 4), new ItemStack(ModItems.aluminumSheet, 1), "itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.copperStripe, 4), new ItemStack(TFCItems.copperSheet, 1), "itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.goldStripe, 4), new ItemStack(TFCItems.goldSheet, 1), "itemChisel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.electrumStripe, 4), new ItemStack(ModItems.electrumSheet, 1), "itemChiselNormal"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.ironStripe, 4), new ItemStack(TFCItems.wroughtIronSheet, 1), ModOptions.cfgIronStripeReqSteelChisel ? "itemChiselMedium" : "itemChiselNormal"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.steelStripe, 4), new ItemStack(TFCItems.steelSheet, 1), "itemChiselHard"));
		
		/**
		 * Dust mixes
		 */
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.vulcanizingAgents, 4),
				"dustGraphite", "dustKaolinite", "dustChalk", "dustSulfur"
		));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.redAlloyMix, 2),
				"dustRedstone", "dustPlatinum"
		));
		
		/**
		 * Cooking
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
		 * Flora
		 */
		// Hevea Log --> Sycamore lumber
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(TFCItems.singlePlank, 8, 11), new ItemStack(ModItems.logHevea, 1), "itemSaw"));
		
		/**
		 * Lime Paint
		 */
		// Base colors
		registerPaintRecipe("black", new ItemStack(TFCItems.dye, 1, 0));
		registerPaintRecipe("blue", new ItemStack(TFCItems.powder, 1, 6));
		registerPaintRecipe("yellow", new ItemStack(TFCItems.powder, 1, 7));
		registerPaintRecipe("green", new ItemStack(TFCItems.powder, 1, 8));
		registerPaintRecipe("white", new ItemStack(TFCItems.dye, 1, 15));
		registerPaintRecipe("red", new ItemStack(TFCItems.powder, 1, 5));
		
		// Color mixes
		registerPaintRecipe("lime", new String[] {
				"green",
				"white"
		});
		registerPaintRecipe("cyan", new String[] {
				"blue",
				"green"
		});
		registerPaintRecipe("gray", new String[] {
				"black",
				"white"
		});
		registerPaintRecipe("orange", new String[] {
				"red",
				"yellow"
		});
		registerPaintRecipe("brown", new String[] {
				"red",
				"black"
		});
		registerPaintRecipe("pink", new String[] {
				"red",
				"white"
		});
		registerPaintRecipe("silver", new String[] {
				"gray",
				"white"
		});
		registerPaintRecipe("silver", new String[] {
				"black",
				"white",
				"white"
		});
		registerPaintRecipe("light_blue", new String[] {
				"blue",
				"white"
		});
		registerPaintRecipe("purple", new String[] {
				"red",
				"blue"
		});
		registerPaintRecipe("magenta", new String[] {
				"purple",
				"pink"
		});
		registerPaintRecipe("magenta", new String[] {
				"blue",
				"red",
				"pink"
		});
		registerPaintRecipe("magenta", new String[] {
				"blue",
				"red",
				"red",
				"white"
		});
		
		/**
		 * Devices
		 */
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.winch),
				"L L",
				" W ",
				"L L",
				'L', "woodLumber",
				'W', "plankWood"
		));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.leatherBelt), "LLL", 'L', "materialLeather"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.wireDrawBench),
				"XBR",
				"WWW",
				"L L",
				'X', ModItems.winch,
				'B',ModItems.leatherBelt,
				'R', ModItems.tongs,
				'L', "woodLumber",
				'W', "plankWood"
		));
		// Circuit Board
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.circuits, 1, 0),
				"PPP",
				"GDG",
				"PPP",
				'P', "materialPaper",
				'G', "materialGlue",
				'D', "dyeGreen"
		));
		// Frequency Generator Circuit
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.circuits, 1, 1),
				"RQT",
				"WBW",
				'R', Items.repeater,
				'Q', "gemQuartz",
				'T', Blocks.redstone_torch,
				'W', ModItems.copperWire,
				'B', new ItemStack(ModItems.circuits, 1, 0)
		));
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.inductor),
				" W ",
				"W W",
				" W ",
				'W', ModItems.copperWire
		);
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.inductionSmelter),
				"OCO",
				"OFO",
				"PIS",
				'O', ModItems.inductor,
				'C', TFCBlocks.crucible,
				'F', new ItemStack(ModItems.circuits, 1, 1),
				'I', TFCItems.copperIngot,
				'P', "platePlatinum",
				'S', "plateSteel"
		));
		
		registerPottery();
		registerKilnRecipes();
		registerMolds();
		
	}
	
	private static void registerPaintRecipe(String resultDye, ItemStack input) {
		ItemStack out = new ItemStack(ModItems.limePaint, 8, ModUtils.getColorIndex(resultDye));
		BarrelManager.getInstance().addRecipe(
				new BarrelRecipe(input, new FluidStack(TFCFluids.LIMEWATER, 100), out, new FluidStack(TFCFluids.LIMEWATER, 100)).setMinTechLevel(0));
	}
	
	private static void registerPaintRecipe(String resultDye, String[] inputs) {
		ItemStack out = new ItemStack(ModItems.limePaint, inputs.length, ModUtils.getColorIndex(resultDye));
		Object[] in = new ItemStack[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			in[i] = new ItemStack(ModItems.limePaint, 1, ModUtils.getColorIndex(inputs[i]));
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
				'#',
				new ItemStack(TFCItems.flatClay, 1, 1)
		});
		
		craftingManager.addRecipe(new ItemStack(ModItems.clayMoldSleeve, 1), new Object[] {
				"     ",
				"  #  ",
				" # # ",
				"  #  ",
				"     ",
				'#',
				new ItemStack(TFCItems.flatClay, 1, 1)
		});
		
		craftingManager.addRecipe(new ItemStack(ModItems.latexBowl, 2), new Object[] {
				"#####",
				"#####",
				" ### ",
				" ### ",
				"#   #",
				'#',
				new ItemStack(TFCItems.flatClay, 1, 1)
		});
		
		craftingManager.addRecipe(new ItemStack(ModItems.potteryCeramicPlate, 3), new Object[] {
				"     ",
				"#####",
				"     ",
				"#####",
				"     ",
				'#',
				new ItemStack(TFCItems.flatClay, 1, 1)
		});
		
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
		GameRegistry
				.addShapelessRecipe(new ItemStack(ModItems.bismuthBronzeGearPiece), Recipes.getStackNoTemp(new ItemStack(ModItems.clayMoldGearPiece, 1, 4)));
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
		
		craftingManager.addRecipe(new ItemStack(mold, 1, meta), new Object[] {
				"12",
				'1',
				Recipes.getStackTemp(new ItemStack(unshaped, 1, 1)),
				'2',
				new ItemStack(mold, 1, 1)
		});
	}
	
	private static void registerKilnRecipes() {
		
		kilnManager.addRecipe(new KilnRecipe(new ItemStack(ModItems.latexBowl, 1, 0), 0, new ItemStack(ModItems.latexBowl, 1, 1)));
		kilnManager.addRecipe(new KilnRecipe(new ItemStack(ModItems.clayMoldGearPiece, 1, 0), 0, new ItemStack(ModItems.clayMoldGearPiece, 1, 1)));
		kilnManager.addRecipe(new KilnRecipe(new ItemStack(ModItems.clayMoldSleeve, 1, 0), 0, new ItemStack(ModItems.clayMoldSleeve, 1, 1)));
		kilnManager.addRecipe(new KilnRecipe(new ItemStack(ModItems.potteryCeramicPlate, 1, 0), 0, new ItemStack(ModItems.potteryCeramicPlate, 1, 1)));
		
	}
	
	@SuppressWarnings("unchecked")
	public static void removeRecipe(ItemStack resultItem) {
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		for (int i = 0; i < recipes.size(); i++) {
			if (recipes.get(i) != null) {
				ItemStack recipeResult = recipes.get(i).getRecipeOutput();
				
				if (ItemStack.areItemStacksEqual(resultItem, recipeResult))
					recipes.remove(i--);
			}
		}
	}
	
}