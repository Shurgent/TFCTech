package ua.pp.shurgent.tfctech.items;

import net.minecraft.item.ItemStack;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.core.ModOptions;

import com.bioxx.tfc.api.HeatIndex;
import com.bioxx.tfc.api.HeatRaw;
import com.bioxx.tfc.api.HeatRegistry;
import com.bioxx.tfc.api.TFCItems;

public class ItemHeat {

	public static void setupItemHeat() {

		HeatRegistry manager = HeatRegistry.getInstance();

		HeatRaw aluminumRaw = new HeatRaw(0.25, 660);
		HeatRaw electrumRaw = new HeatRaw(0.5, 1012);
		HeatRaw constantanRaw = new HeatRaw(0.45, 1260);
		HeatRaw invarRaw = new HeatRaw(0.48, 1425);
		
		// TFC HeatRaw
		HeatRaw bismuthRaw = new HeatRaw(0.14, 270);
		HeatRaw bismuthBronzeRaw = new HeatRaw(0.35, 985);
		HeatRaw blackBronzeRaw = new HeatRaw(0.35, 1070);
		HeatRaw blackSteelRaw = new HeatRaw(0.35, 1485);
		HeatRaw blueSteelRaw = new HeatRaw(0.35, 1540);
		HeatRaw brassRaw = new HeatRaw(0.35, 930);
		HeatRaw bronzeRaw = new HeatRaw(0.35, 950);
		HeatRaw copperRaw = new HeatRaw(0.35, 1080);
		HeatRaw goldRaw = new HeatRaw(0.6, 1060);
		HeatRaw ironRaw = new HeatRaw(0.35, 1535);
		HeatRaw leadRaw = new HeatRaw(0.22, 328);
		HeatRaw nickelRaw = new HeatRaw(0.48, 1453);
		HeatRaw pigIronRaw = new HeatRaw(0.35, 1500);
		HeatRaw platinumRaw = new HeatRaw(0.35, 1730);
		HeatRaw redSteelRaw = new HeatRaw(0.35, 1540);
		HeatRaw roseGoldRaw = new HeatRaw(0.35, 960);
		HeatRaw silverRaw = new HeatRaw(0.48, 961);
		HeatRaw steelRaw = new HeatRaw(0.35, 1540);
		HeatRaw sterlingSilverRaw = new HeatRaw(0.35, 900);
		HeatRaw tinRaw = new HeatRaw(0.14, 230);
		HeatRaw zincRaw = new HeatRaw(0.21, 420);

		// Aluminum
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.aluminumIngot,1), aluminumRaw, new ItemStack(ModItems.aluminumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.aluminumIngot2x,1), aluminumRaw, new ItemStack(ModItems.aluminumUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.aluminumUnshaped,1), aluminumRaw, new ItemStack(ModItems.aluminumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.aluminumDust,1), aluminumRaw, new ItemStack(ModItems.aluminumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.aluminumNugget,1), aluminumRaw, new ItemStack(ModItems.aluminumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.aluminumPlate,1), aluminumRaw, new ItemStack(ModItems.aluminumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.aluminumPlate2x,1), aluminumRaw, new ItemStack(ModItems.aluminumUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.oreChunk, 1, 0), aluminumRaw, new ItemStack(ModItems.aluminumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.oreChunk, 1, 1), aluminumRaw, new ItemStack(ModItems.aluminumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.oreChunk, 1, 2), aluminumRaw, new ItemStack(ModItems.aluminumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.bauxiteDust,1), aluminumRaw, new ItemStack(ModItems.aluminumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.aluminumSheet,1), aluminumRaw, new ItemStack(ModItems.aluminumUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.aluminumSheet2x,1), aluminumRaw, new ItemStack(ModItems.aluminumUnshaped,4,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.aluminumStripe,1), aluminumRaw, new ItemStack(ModItems.aluminumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.aluminumWire,1), aluminumRaw, new ItemStack(ModItems.aluminumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedAluminumWire,1,0), aluminumRaw, new ItemStack(ModItems.aluminumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedAluminumWire,1,1), aluminumRaw, new ItemStack(ModItems.aluminumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedAluminumWire,1,2), aluminumRaw, new ItemStack(ModItems.aluminumUnshaped,1)));
	
		//Electrum
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.electrumIngot,1), electrumRaw, new ItemStack(ModItems.electrumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.electrumIngot2x,1), electrumRaw, new ItemStack(ModItems.electrumUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.electrumUnshaped,1), electrumRaw, new ItemStack(ModItems.electrumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.electrumDust,1), electrumRaw, new ItemStack(ModItems.electrumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.electrumNugget,1), electrumRaw, new ItemStack(ModItems.electrumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.electrumPlate,1), electrumRaw, new ItemStack(ModItems.electrumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.electrumPlate2x,1), electrumRaw, new ItemStack(ModItems.electrumUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.pipeFrameElectrum,1), electrumRaw, new ItemStack(ModItems.electrumUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.electrumSheet,1), electrumRaw, new ItemStack(ModItems.electrumUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.electrumSheet2x,1), electrumRaw, new ItemStack(ModItems.electrumUnshaped,4,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.electrumStripe,1), electrumRaw, new ItemStack(ModItems.electrumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.electrumWire,1), electrumRaw, new ItemStack(ModItems.electrumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedElectrumWire,1,0), electrumRaw, new ItemStack(ModItems.electrumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedElectrumWire,1,1), electrumRaw, new ItemStack(ModItems.electrumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedElectrumWire,1,2), electrumRaw, new ItemStack(ModItems.electrumUnshaped,1)));
		
		//Constantan
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.constantanIngot,1), constantanRaw, new ItemStack(ModItems.constantanUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.constantanIngot2x,1), constantanRaw, new ItemStack(ModItems.constantanUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.constantanUnshaped,1), constantanRaw, new ItemStack(ModItems.constantanUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.constantanDust,1), constantanRaw, new ItemStack(ModItems.constantanUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.constantanNugget,1), constantanRaw, new ItemStack(ModItems.constantanUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.constantanPlate,1), constantanRaw, new ItemStack(ModItems.constantanUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.constantanPlate2x,1), constantanRaw, new ItemStack(ModItems.constantanUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.constantanSheet,1), constantanRaw, new ItemStack(ModItems.constantanUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.constantanSheet2x,1), constantanRaw, new ItemStack(ModItems.constantanUnshaped,4,0)));
		
		//Invar
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.invarIngot,1), invarRaw, new ItemStack(ModItems.invarUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.invarIngot2x,1), invarRaw, new ItemStack(ModItems.invarUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.invarUnshaped,1), invarRaw, new ItemStack(ModItems.invarUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.invarDust,1), invarRaw, new ItemStack(ModItems.invarUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.invarNugget,1), invarRaw, new ItemStack(ModItems.invarUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.invarPlate,1), invarRaw, new ItemStack(ModItems.invarUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.invarPlate2x,1), invarRaw, new ItemStack(ModItems.invarUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.invarSheet,1), invarRaw, new ItemStack(ModItems.invarUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.invarSheet2x,1), invarRaw, new ItemStack(ModItems.invarUnshaped,4,0)));
		
		//Bismuth
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.bismuthDust,1), bismuthRaw, new ItemStack(TFCItems.bismuthUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.bismuthNugget,1), bismuthRaw, new ItemStack(TFCItems.bismuthUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.bismuthPlate,1), bismuthRaw, new ItemStack(TFCItems.bismuthUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.bismuthPlate2x,1), bismuthRaw, new ItemStack(TFCItems.bismuthUnshaped,2,0)));
		
		//Bismuth Bronze
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.bismuthBronzeDust,1), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.bismuthBronzeNugget,1), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.bismuthBronzePlate,1), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.bismuthBronzePlate2x,1), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.bismuthBronzeGearPiece,1), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.bismuthBronzeRackwheel,1), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped,4,0)));
		
		//Black Bronze
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.blackBronzeDust,1), blackBronzeRaw, new ItemStack(TFCItems.blackBronzeUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.blackBronzeNugget,1), blackBronzeRaw, new ItemStack(TFCItems.blackBronzeUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.blackBronzePlate,1), blackBronzeRaw, new ItemStack(TFCItems.blackBronzeUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.blackBronzePlate2x,1), blackBronzeRaw, new ItemStack(TFCItems.blackBronzeUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.blackBronzeGearPiece,1), blackBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.blackBronzeRackwheel,1), blackBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped,4,0)));
		
		//Black Steel
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.blackSteelDust,1), blackSteelRaw, new ItemStack(TFCItems.blackSteelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.blackSteelNugget,1), blackSteelRaw, new ItemStack(TFCItems.blackSteelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.blackSteelPlate,1), blackSteelRaw, new ItemStack(TFCItems.blackSteelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.blackSteelPlate2x,1), blackSteelRaw, new ItemStack(TFCItems.blackSteelUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.pipeFrameBlackSteel,1), blackSteelRaw, new ItemStack(TFCItems.blackSteelUnshaped,2,0)));
		
		//Blue Steel
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.blueSteelDust,1), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.blueSteelNugget,1), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.blueSteelPlate,1), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.blueSteelPlate2x,1), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.blueSteelGearPiece,1), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.blueSteelRackwheel,1), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped,4,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.pipeFrameBlueSteel,1), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped,2,0)));
		
		//Brass
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.brassDust,1), brassRaw, new ItemStack(TFCItems.brassUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.brassNugget,1), brassRaw, new ItemStack(TFCItems.brassUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.brassPlate,1), brassRaw, new ItemStack(TFCItems.brassUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.brassPlate2x,1), brassRaw, new ItemStack(TFCItems.brassUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.brassGearPiece,1), brassRaw, new ItemStack(TFCItems.brassUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.brassRackwheel,1), brassRaw, new ItemStack(TFCItems.brassUnshaped,4,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.brassSleeve,1), brassRaw, new ItemStack(TFCItems.brassUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.oilcan,1), brassRaw, new ItemStack(TFCItems.brassUnshaped,2,0)));
		
		//Bronze
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.bronzeDust,1), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.bronzeNugget,1), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.bronzePlate,1), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.bronzePlate2x,1), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.bronzeGearPiece,1), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.bronzeRackwheel,1), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped,4,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.pipeFrameBronze,1), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped,2,0)));
		
		//Copper
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.copperDust,1), copperRaw, new ItemStack(TFCItems.copperUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.copperNugget,1), copperRaw, new ItemStack(TFCItems.copperUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.copperPlate,1), copperRaw, new ItemStack(TFCItems.copperUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.copperPlate2x,1), copperRaw, new ItemStack(TFCItems.copperUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.copperGearPiece,1), copperRaw, new ItemStack(TFCItems.copperUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.copperRackwheel,1), copperRaw, new ItemStack(TFCItems.copperUnshaped,4,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.pipeFrameCopper,1), copperRaw, new ItemStack(TFCItems.copperUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.copperStripe,1), copperRaw, new ItemStack(TFCItems.copperUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.copperWire,1), copperRaw, new ItemStack(TFCItems.copperUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedCopperWire,1,0), copperRaw, new ItemStack(TFCItems.copperUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedCopperWire,1,2), copperRaw, new ItemStack(TFCItems.copperUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedCopperWire,1,3), copperRaw, new ItemStack(TFCItems.copperUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.inductor,1), copperRaw, new ItemStack(TFCItems.copperUnshaped,2,0)));
		
		//Gold
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.goldDust,1), goldRaw, new ItemStack(TFCItems.goldUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.goldNugget,1), goldRaw, new ItemStack(TFCItems.goldUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.goldPlate,1), goldRaw, new ItemStack(TFCItems.goldUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.goldPlate2x,1), goldRaw, new ItemStack(TFCItems.goldUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.goldGearPiece,1), goldRaw, new ItemStack(TFCItems.goldUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.goldRackwheel,1), goldRaw, new ItemStack(TFCItems.goldUnshaped,4,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.goldStripe,1), goldRaw, new ItemStack(TFCItems.goldUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.goldWire,1), goldRaw, new ItemStack(TFCItems.goldUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedGoldWire,1,0), goldRaw, new ItemStack(TFCItems.goldUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedGoldWire,1,1), goldRaw, new ItemStack(TFCItems.goldUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedGoldWire,1,3), goldRaw, new ItemStack(TFCItems.goldUnshaped,1)));
		
		//Wrought Iron
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.wroughtIronDust,1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.wroughtIronNugget,1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.wroughtIronPlate,1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.wroughtIronPlate2x,1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.wroughtIronGearPiece,1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.wroughtIronRackwheel,1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped,4,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.mount,1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.groove,1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.ironStripe,1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.pipeFrameWroughtIron,1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.dixie,1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.ironWire,1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedIronWire,1,0), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedIronWire,1,1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedIronWire,1,2), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped,1)));
		
		//Lead
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.leadDust,1), leadRaw, new ItemStack(TFCItems.leadUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.leadNugget,1), leadRaw, new ItemStack(TFCItems.leadUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.leadPlate,1), leadRaw, new ItemStack(TFCItems.leadUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.leadPlate2x,1), leadRaw, new ItemStack(TFCItems.leadUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.pipeFrameLead,1), leadRaw, new ItemStack(TFCItems.leadUnshaped,2,0)));
		
		//Nickel
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.nickelDust,1), nickelRaw, new ItemStack(TFCItems.nickelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.nickelNugget,1), nickelRaw, new ItemStack(TFCItems.nickelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.nickelPlate,1), nickelRaw, new ItemStack(TFCItems.nickelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.nickelPlate2x,1), nickelRaw, new ItemStack(TFCItems.nickelUnshaped,2,0)));
		
		//Pig Iron
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.pigIronDust,1), pigIronRaw, new ItemStack(TFCItems.pigIronUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.pigIronNugget,1), pigIronRaw, new ItemStack(TFCItems.pigIronUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.pigIronPlate,1), pigIronRaw, new ItemStack(TFCItems.pigIronUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.pigIronPlate2x,1), pigIronRaw, new ItemStack(TFCItems.pigIronUnshaped,2,0)));
		
		//Platinum
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.platinumDust,1), platinumRaw, new ItemStack(TFCItems.platinumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.platinumNugget,1), platinumRaw, new ItemStack(TFCItems.platinumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.platinumPlate,1), platinumRaw, new ItemStack(TFCItems.platinumUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.platinumPlate2x,1), platinumRaw, new ItemStack(TFCItems.platinumUnshaped,2,0)));
		
		//Red Steel
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.redSteelDust,1), redSteelRaw, new ItemStack(TFCItems.redSteelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.redSteelNugget,1), redSteelRaw, new ItemStack(TFCItems.redSteelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.redSteelPlate,1), redSteelRaw, new ItemStack(TFCItems.redSteelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.redSteelPlate2x,1), redSteelRaw, new ItemStack(TFCItems.redSteelUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.pipeFrameRedSteel,1), redSteelRaw, new ItemStack(TFCItems.redSteelUnshaped,2,0)));

		//Rose Gold
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.roseGoldDust,1), roseGoldRaw, new ItemStack(TFCItems.roseGoldUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.roseGoldNugget,1), roseGoldRaw, new ItemStack(TFCItems.roseGoldUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.roseGoldPlate,1), roseGoldRaw, new ItemStack(TFCItems.roseGoldUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.roseGoldPlate2x,1), roseGoldRaw, new ItemStack(TFCItems.roseGoldUnshaped,2,0)));
		
		//Silver
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.silverDust,1), silverRaw, new ItemStack(TFCItems.silverUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.silverNugget,1), silverRaw, new ItemStack(TFCItems.silverUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.silverPlate,1), silverRaw, new ItemStack(TFCItems.silverUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.silverPlate2x,1), silverRaw, new ItemStack(TFCItems.silverUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.pipeFrameSilver,1), silverRaw, new ItemStack(TFCItems.silverUnshaped,2,0)));
		
		//Steel
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.steelDust,1), steelRaw, new ItemStack(TFCItems.steelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.steelNugget,1), steelRaw, new ItemStack(TFCItems.steelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.steelPlate,1), steelRaw, new ItemStack(TFCItems.steelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.steelPlate2x,1), steelRaw, new ItemStack(TFCItems.steelUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.steelGearPiece,1), steelRaw, new ItemStack(TFCItems.steelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.steelRackwheel,1), steelRaw, new ItemStack(TFCItems.steelUnshaped,4,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.steelSleeve,1), steelRaw, new ItemStack(TFCItems.steelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.pipeFrameSteel,1), steelRaw, new ItemStack(TFCItems.steelUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.steelStripe,1), steelRaw, new ItemStack(TFCItems.steelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.steelWire,1), steelRaw, new ItemStack(TFCItems.steelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedSteelWire,1,0), steelRaw, new ItemStack(TFCItems.steelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedSteelWire,1,1), steelRaw, new ItemStack(TFCItems.steelUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedSteelWire,1,2), steelRaw, new ItemStack(TFCItems.steelUnshaped,1)));
		
		//Sterling Silver
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.sterlingSilverDust,1), sterlingSilverRaw, new ItemStack(TFCItems.sterlingSilverUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.sterlingSilverNugget,1), sterlingSilverRaw, new ItemStack(TFCItems.sterlingSilverUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.sterlingSilverPlate,1), sterlingSilverRaw, new ItemStack(TFCItems.sterlingSilverUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.sterlingSilverPlate2x,1), sterlingSilverRaw, new ItemStack(TFCItems.sterlingSilverUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.pipeFrameSterlingSilver,1), sterlingSilverRaw, new ItemStack(TFCItems.sterlingSilverUnshaped,2,0)));
		
		//Tin
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.tinDust,1), tinRaw, new ItemStack(TFCItems.tinUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.tinNugget,1), tinRaw, new ItemStack(TFCItems.tinUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.tinPlate,1), tinRaw, new ItemStack(TFCItems.tinUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.tinPlate2x,1), tinRaw, new ItemStack(TFCItems.tinUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.tinGearPiece,1), tinRaw, new ItemStack(TFCItems.tinUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.tinRackwheel,1), tinRaw, new ItemStack(TFCItems.tinUnshaped,4,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.tinSleeve,1), tinRaw, new ItemStack(TFCItems.tinUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.tinStripe,1), tinRaw, new ItemStack(TFCItems.tinUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.tinWire,1), tinRaw, new ItemStack(TFCItems.tinUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedTinWire,1,0), tinRaw, new ItemStack(TFCItems.tinUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedTinWire,1,1), tinRaw, new ItemStack(TFCItems.tinUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.unfinishedTinWire,1,2), tinRaw, new ItemStack(TFCItems.tinUnshaped,1)));
		
		//Zinc
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.zincDust,1), zincRaw, new ItemStack(TFCItems.zincUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.zincNugget,1), zincRaw, new ItemStack(TFCItems.zincUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.zincPlate,1), zincRaw, new ItemStack(TFCItems.zincUnshaped,1)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.zincPlate2x,1), zincRaw, new ItemStack(TFCItems.zincUnshaped,2,0)));
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.pipeFrameZinc,1), zincRaw, new ItemStack(TFCItems.zincUnshaped,2,0)));
		
		//Rubber
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.rubberMix,1), 1, 600, new ItemStack(ModItems.rubber,1)));
		
		//Glue
		manager.addIndex(new HeatIndex(new ItemStack(ModItems.dixieBones,1), ModOptions.cfgGlueBoilingSpeed, 400, new ItemStack(ModItems.dixieGlue,1)));
	}

}
