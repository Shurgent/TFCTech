package ua.pp.shurgent.tfctech.core;

import org.apache.commons.lang3.text.WordUtils;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import ua.pp.shurgent.tfctech.TFCTech;

import com.bioxx.tfc.Items.ItemDyeCustom;
import com.bioxx.tfc.api.TFCItems;

public class ModOreDictionary {

	public static void initialise()
	{
		TFCTech.LOG.info("Registering Ore Dictionary");
		
		registerOreDict();
		
		TFCTech.LOG.info("Done Registering Ore Dictionary");
	}
	
	public static void registerOreDict() {
		
		final int WILD = OreDictionary.WILDCARD_VALUE;

		// Ores
		OreDictionary.registerOre("oreNormalBauxite", new ItemStack(ModItems.oreChunk, 1, 0));
		OreDictionary.registerOre("oreSmallBauxite", new ItemStack(ModItems.smallOreChunk, 1, 0));
		OreDictionary.registerOre("oreRichBauxite", new ItemStack(ModItems.oreChunk, 1, 1));
		OreDictionary.registerOre("orePoorBauxite", new ItemStack(ModItems.oreChunk, 1, 2));
		
		// Dust
		OreDictionary.registerOre("dustAluminum", new ItemStack(ModItems.aluminumDust, 1, WILD));
		OreDictionary.registerOre("dustBauxite", new ItemStack(ModItems.bauxiteDust, 1, WILD));
		OreDictionary.registerOre("dustElectrum", new ItemStack(ModItems.electrumDust, 1, WILD));
		OreDictionary.registerOre("dustConstantan", new ItemStack(ModItems.constantanDust, 1, WILD));
		OreDictionary.registerOre("dustCupronickel", new ItemStack(ModItems.constantanDust, 1, WILD));
		OreDictionary.registerOre("dustInvar", new ItemStack(ModItems.invarDust, 1, WILD));
		OreDictionary.registerOre("dustBismuth", new ItemStack(ModItems.bismuthDust, 1, WILD));
		OreDictionary.registerOre("dustBismuthBronze", new ItemStack(ModItems.bismuthBronzeDust, 1, WILD));
		OreDictionary.registerOre("dustBlackBronze", new ItemStack(ModItems.blackBronzeDust, 1, WILD));
		OreDictionary.registerOre("dustBronze", new ItemStack(ModItems.bronzeDust, 1, WILD));
		OreDictionary.registerOre("dustBrass", new ItemStack(ModItems.brassDust, 1, WILD));
		OreDictionary.registerOre("dustBlackSteel", new ItemStack(ModItems.blackSteelDust, 1, WILD));
		OreDictionary.registerOre("dustSteel", new ItemStack(ModItems.steelDust, 1, WILD));
		OreDictionary.registerOre("dustCopper", new ItemStack(ModItems.copperDust, 1, WILD));
		OreDictionary.registerOre("dustGold", new ItemStack(ModItems.goldDust, 1, WILD));
		OreDictionary.registerOre("dustRoseGold", new ItemStack(ModItems.roseGoldDust, 1, WILD));
		OreDictionary.registerOre("dustWroughtIron", new ItemStack(ModItems.wroughtIronDust, 1, WILD));
		OreDictionary.registerOre("dustIron", new ItemStack(ModItems.wroughtIronDust, 1, WILD));
		OreDictionary.registerOre("dustPigIron", new ItemStack(ModItems.pigIronDust, 1, WILD));
		OreDictionary.registerOre("dustLead", new ItemStack(ModItems.leadDust, 1, WILD));
		OreDictionary.registerOre("dustNickel", new ItemStack(ModItems.nickelDust, 1, WILD));
		OreDictionary.registerOre("dustPlatinum", new ItemStack(ModItems.platinumDust, 1, WILD));
		OreDictionary.registerOre("dustSilver", new ItemStack(ModItems.silverDust, 1, WILD));
		OreDictionary.registerOre("dustSterlingSilver", new ItemStack(ModItems.sterlingSilverDust, 1, WILD));
		OreDictionary.registerOre("dustTin", new ItemStack(ModItems.tinDust, 1, WILD));
		OreDictionary.registerOre("dustZinc", new ItemStack(ModItems.zincDust, 1, WILD));
		OreDictionary.registerOre("dustBlueSteel", new ItemStack(ModItems.blueSteelDust, 1, WILD));
		OreDictionary.registerOre("dustRedSteel", new ItemStack(ModItems.redSteelDust, 1, WILD));
		OreDictionary.registerOre("dustRedAlloy", new ItemStack(ModItems.redAlloyDust, 1, WILD));
		
		// Nuggets
		OreDictionary.registerOre("nuggetAluminum", new ItemStack(ModItems.aluminumNugget, 1, WILD));
		OreDictionary.registerOre("nuggetElectrum", new ItemStack(ModItems.electrumNugget, 1, WILD));
		OreDictionary.registerOre("nuggetConstantan", new ItemStack(ModItems.constantanNugget, 1, WILD));
		OreDictionary.registerOre("nuggetCupronickel", new ItemStack(ModItems.constantanNugget, 1, WILD));
		OreDictionary.registerOre("nuggetInvar", new ItemStack(ModItems.invarNugget, 1, WILD));
		OreDictionary.registerOre("nuggetBismuth", new ItemStack(ModItems.bismuthNugget, 1, WILD));
		OreDictionary.registerOre("nuggetBismuthBronze", new ItemStack(ModItems.bismuthBronzeNugget, 1, WILD));
		OreDictionary.registerOre("nuggetBlackBronze", new ItemStack(ModItems.blackBronzeNugget, 1, WILD));
		OreDictionary.registerOre("nuggetBronze", new ItemStack(ModItems.bronzeNugget, 1, WILD));
		OreDictionary.registerOre("nuggetBrass", new ItemStack(ModItems.brassNugget, 1, WILD));
		OreDictionary.registerOre("nuggetBlackSteel", new ItemStack(ModItems.blackSteelNugget, 1, WILD));
		OreDictionary.registerOre("nuggetSteel", new ItemStack(ModItems.steelNugget, 1, WILD));
		OreDictionary.registerOre("nuggetCopper", new ItemStack(ModItems.copperNugget, 1, WILD));
		OreDictionary.registerOre("nuggetGold", new ItemStack(ModItems.goldNugget, 1, WILD));
		OreDictionary.registerOre("nuggetRoseGold", new ItemStack(ModItems.roseGoldNugget, 1, WILD));
		OreDictionary.registerOre("nuggetWroughtIron", new ItemStack(ModItems.wroughtIronNugget, 1, WILD));
		OreDictionary.registerOre("nuggetIron", new ItemStack(ModItems.wroughtIronNugget, 1, WILD));
		OreDictionary.registerOre("nuggetPigIron", new ItemStack(ModItems.pigIronNugget, 1, WILD));
		OreDictionary.registerOre("nuggetLead", new ItemStack(ModItems.leadNugget, 1, WILD));
		OreDictionary.registerOre("nuggetNickel", new ItemStack(ModItems.nickelNugget, 1, WILD));
		OreDictionary.registerOre("nuggetPlatinum", new ItemStack(ModItems.platinumNugget, 1, WILD));
		OreDictionary.registerOre("nuggetSilver", new ItemStack(ModItems.silverNugget, 1, WILD));
		OreDictionary.registerOre("nuggetSterlingSilver", new ItemStack(ModItems.sterlingSilverNugget, 1, WILD));
		OreDictionary.registerOre("nuggetTin", new ItemStack(ModItems.tinNugget, 1, WILD));
		OreDictionary.registerOre("nuggetZinc", new ItemStack(ModItems.zincNugget, 1, WILD));
		OreDictionary.registerOre("nuggetBlueSteel", new ItemStack(ModItems.blueSteelNugget, 1, WILD));
		OreDictionary.registerOre("nuggetRedSteel", new ItemStack(ModItems.redSteelNugget, 1, WILD));
		OreDictionary.registerOre("nuggetRedAlloy", new ItemStack(ModItems.redAlloyNugget, 1, WILD));
		
		// Ingots
		OreDictionary.registerOre("ingotAluminum", new ItemStack(ModItems.aluminumIngot, 1, WILD));
		OreDictionary.registerOre("ingotElectrum", new ItemStack(ModItems.electrumIngot, 1, WILD));
		OreDictionary.registerOre("ingotConstantan", new ItemStack(ModItems.constantanIngot, 1, WILD));
		OreDictionary.registerOre("ingotCupronickel", new ItemStack(ModItems.constantanIngot, 1, WILD));
		OreDictionary.registerOre("ingotInvar", new ItemStack(ModItems.invarIngot, 1, WILD));
		OreDictionary.registerOre("ingotRedAlloy", new ItemStack(ModItems.redAlloyIngot, 1, WILD));
		
		// Plates
		OreDictionary.registerOre("plateAluminum", new ItemStack(ModItems.aluminumPlate, 1, WILD));
		OreDictionary.registerOre("plateElectrum", new ItemStack(ModItems.electrumPlate, 1, WILD));
		OreDictionary.registerOre("plateConstantan", new ItemStack(ModItems.constantanPlate, 1, WILD));
		OreDictionary.registerOre("plateCupronickel", new ItemStack(ModItems.constantanPlate, 1, WILD));
		OreDictionary.registerOre("plateInvar", new ItemStack(ModItems.invarPlate, 1, WILD));
		OreDictionary.registerOre("plateBismuth", new ItemStack(ModItems.bismuthPlate, 1, WILD));
		OreDictionary.registerOre("plateBismuthBronze", new ItemStack(ModItems.bismuthBronzePlate, 1, WILD));
		OreDictionary.registerOre("plateBlackBronze", new ItemStack(ModItems.blackBronzePlate, 1, WILD));
		OreDictionary.registerOre("plateBronze", new ItemStack(ModItems.bronzePlate, 1, WILD));
		OreDictionary.registerOre("plateBrass", new ItemStack(ModItems.brassPlate, 1, WILD));
		OreDictionary.registerOre("plateBlackSteel", new ItemStack(ModItems.blackSteelPlate, 1, WILD));
		OreDictionary.registerOre("plateSteel", new ItemStack(ModItems.steelPlate, 1, WILD));
		OreDictionary.registerOre("plateCopper", new ItemStack(ModItems.copperPlate, 1, WILD));
		OreDictionary.registerOre("plateGold", new ItemStack(ModItems.goldPlate, 1, WILD));
		OreDictionary.registerOre("plateRoseGold", new ItemStack(ModItems.roseGoldPlate, 1, WILD));
		OreDictionary.registerOre("plateWroughtIron", new ItemStack(ModItems.wroughtIronPlate, 1, WILD));
		OreDictionary.registerOre("plateIron", new ItemStack(ModItems.wroughtIronPlate, 1, WILD));
		OreDictionary.registerOre("platePigIron", new ItemStack(ModItems.pigIronPlate, 1, WILD));
		OreDictionary.registerOre("plateLead", new ItemStack(ModItems.leadPlate, 1, WILD));
		OreDictionary.registerOre("plateNickel", new ItemStack(ModItems.nickelPlate, 1, WILD));
		OreDictionary.registerOre("platePlatinum", new ItemStack(ModItems.platinumPlate, 1, WILD));
		OreDictionary.registerOre("plateSilver", new ItemStack(ModItems.silverPlate, 1, WILD));
		OreDictionary.registerOre("plateSterlingSilver", new ItemStack(ModItems.sterlingSilverPlate, 1, WILD));
		OreDictionary.registerOre("plateTin", new ItemStack(ModItems.tinPlate, 1, WILD));
		OreDictionary.registerOre("plateZinc", new ItemStack(ModItems.zincPlate, 1, WILD));
		OreDictionary.registerOre("plateBlueSteel", new ItemStack(ModItems.blueSteelPlate, 1, WILD));
		OreDictionary.registerOre("plateRedSteel", new ItemStack(ModItems.redSteelPlate, 1, WILD));
		
		// Dense plates
		OreDictionary.registerOre("plateDenseAluminum", new ItemStack(ModItems.aluminumPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseElectrum", new ItemStack(ModItems.electrumPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseConstantan", new ItemStack(ModItems.constantanPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseCupronickel", new ItemStack(ModItems.constantanPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseInvar", new ItemStack(ModItems.invarPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseBismuth", new ItemStack(ModItems.bismuthPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseBismuthBronze", new ItemStack(ModItems.bismuthBronzePlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseBlackBronze", new ItemStack(ModItems.blackBronzePlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseBronze", new ItemStack(ModItems.bronzePlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseBrass", new ItemStack(ModItems.brassPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseBlackSteel", new ItemStack(ModItems.blackSteelPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseSteel", new ItemStack(ModItems.steelPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseCopper", new ItemStack(ModItems.copperPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseGold", new ItemStack(ModItems.goldPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseRoseGold", new ItemStack(ModItems.roseGoldPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseWroughtIron", new ItemStack(ModItems.wroughtIronPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseIron", new ItemStack(ModItems.wroughtIronPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDensePigIron", new ItemStack(ModItems.pigIronPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseLead", new ItemStack(ModItems.leadPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseNickel", new ItemStack(ModItems.nickelPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDensePlatinum", new ItemStack(ModItems.platinumPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseSilver", new ItemStack(ModItems.silverPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseSterlingSilver", new ItemStack(ModItems.sterlingSilverPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseTin", new ItemStack(ModItems.tinPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseZinc", new ItemStack(ModItems.zincPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseBlueSteel", new ItemStack(ModItems.blueSteelPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDenseRedSteel", new ItemStack(ModItems.redSteelPlate2x, 1, WILD));
		
		OreDictionary.registerOre("plateDoubleAluminum", new ItemStack(ModItems.aluminumPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleElectrum", new ItemStack(ModItems.electrumPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleConstantan", new ItemStack(ModItems.constantanPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleCupronickel", new ItemStack(ModItems.constantanPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleInvar", new ItemStack(ModItems.invarPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleBismuth", new ItemStack(ModItems.bismuthPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleBismuthBronze", new ItemStack(ModItems.bismuthBronzePlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleBlackBronze", new ItemStack(ModItems.blackBronzePlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleBronze", new ItemStack(ModItems.bronzePlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleBrass", new ItemStack(ModItems.brassPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleBlackSteel", new ItemStack(ModItems.blackSteelPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleSteel", new ItemStack(ModItems.steelPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleCopper", new ItemStack(ModItems.copperPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleGold", new ItemStack(ModItems.goldPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleRoseGold", new ItemStack(ModItems.roseGoldPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleWroughtIron", new ItemStack(ModItems.wroughtIronPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleIron", new ItemStack(ModItems.wroughtIronPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoublePigIron", new ItemStack(ModItems.pigIronPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleLead", new ItemStack(ModItems.leadPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleNickel", new ItemStack(ModItems.nickelPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoublePlatinum", new ItemStack(ModItems.platinumPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleSilver", new ItemStack(ModItems.silverPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleSterlingSilver", new ItemStack(ModItems.sterlingSilverPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleTin", new ItemStack(ModItems.tinPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleZinc", new ItemStack(ModItems.zincPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleBlueSteel", new ItemStack(ModItems.blueSteelPlate2x, 1, WILD));
		OreDictionary.registerOre("plateDoubleRedSteel", new ItemStack(ModItems.redSteelPlate2x, 1, WILD));
		
		/**
		 * Chisel hardness
		 */
		String n;
		// HARD
		n = "itemChiselHard";
		OreDictionary.registerOre(n, new ItemStack(TFCItems.blueSteelChisel, 1, WILD));
		OreDictionary.registerOre(n, new ItemStack(TFCItems.redSteelChisel, 1, WILD));
		
		// MEDIUM
		n = "itemChiselMedium";
		OreDictionary.registerOre(n, new ItemStack(TFCItems.blueSteelChisel, 1, WILD));
		OreDictionary.registerOre(n, new ItemStack(TFCItems.redSteelChisel, 1, WILD));
		OreDictionary.registerOre(n, new ItemStack(TFCItems.blackSteelChisel, 1, WILD));
		OreDictionary.registerOre(n, new ItemStack(TFCItems.steelChisel, 1, WILD));
		
		// NORMAL
		n = "itemChiselNormal";
		OreDictionary.registerOre(n, new ItemStack(TFCItems.blueSteelChisel, 1, WILD));
		OreDictionary.registerOre(n, new ItemStack(TFCItems.redSteelChisel, 1, WILD));
		OreDictionary.registerOre(n, new ItemStack(TFCItems.blackSteelChisel, 1, WILD));
		OreDictionary.registerOre(n, new ItemStack(TFCItems.steelChisel, 1, WILD));
		OreDictionary.registerOre(n, new ItemStack(TFCItems.wroughtIronChisel, 1, WILD));
		
		// == INTEGRATION =====================================================
		
		/**
		 * Gears
		 */
		OreDictionary.registerOre("gearBismuthBronze", new ItemStack(ModItems.bismuthBronzeGear, 1, WILD));
		OreDictionary.registerOre("gearBlackBronze", new ItemStack(ModItems.blackBronzeGear, 1, WILD));
		OreDictionary.registerOre("gearBlueSteel", new ItemStack(ModItems.blueSteelGear, 1, WILD));
		OreDictionary.registerOre("gearBrass", new ItemStack(ModItems.brassGear, 1, WILD));
		OreDictionary.registerOre("gearBronze", new ItemStack(ModItems.bronzeGear, 1, WILD));
		OreDictionary.registerOre("gearCopper", new ItemStack(ModItems.copperGear, 1, WILD));
		OreDictionary.registerOre("gearGold", new ItemStack(ModItems.goldGear, 1, WILD));
		OreDictionary.registerOre("gearWroughtIron", new ItemStack(ModItems.wroughtIronGear, 1, WILD));
		OreDictionary.registerOre("gearSteel", new ItemStack(ModItems.steelGear, 1, WILD));
		OreDictionary.registerOre("gearTin", new ItemStack(ModItems.tinGear, 1, WILD));
		
		OreDictionary.registerOre("gearAnyBronze", new ItemStack(ModItems.bronzeGear, 1, WILD));
		OreDictionary.registerOre("gearAnyBronze", new ItemStack(ModItems.bismuthBronzeGear, 1, WILD));
		OreDictionary.registerOre("gearAnyBronze", new ItemStack(ModItems.blackBronzeGear, 1, WILD));
		OreDictionary.registerOre("gearIron", new ItemStack(ModItems.wroughtIronGear, 1, WILD));
		
		OreDictionary.registerOre("gemQuartz", new ItemStack(ModItems.gemQuartz, 1, WILD));
		OreDictionary.registerOre("dustChalk", new ItemStack(ModItems.chalkPowder, 1, WILD));
		OreDictionary.registerOre("itemRubber", new ItemStack(ModItems.rubber, 1, WILD));
		OreDictionary.registerOre("materialRubber", new ItemStack(ModItems.rubber, 1, WILD));
		OreDictionary.registerOre("materialGlue", new ItemStack(ModItems.glue, 1, WILD));
		OreDictionary.registerOre("materialPaper", new ItemStack(Items.paper, 1, WILD)); // Add Vanilla paper to OreDictionary as material
		
		for (int i = 0; i < ItemDyeCustom.DYE_COLOR_NAMES.length; i++) {
			OreDictionary.registerOre("dye" + WordUtils.capitalize(ItemDyeCustom.DYE_COLOR_NAMES[i]), new ItemStack(ModItems.limePaint, 1, i));
		}
		
		OreDictionary.registerOre("plateCeramic", new ItemStack(ModItems.potteryCeramicPlate, 1, 1));
	}
	
}
