package ua.pp.shurgent.tfctech.integration.bc;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import ua.pp.shurgent.tfctech.core.ModDetails;
import buildcraft.api.core.IIconProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModPipeIconProvider implements IIconProvider {
	
	public enum TYPE {
		
		// TFCTech pipe <========================= // Buildcraft pipe
		PipeStructureLead("pipeStructureLead"), // PipeStructureCobblestone("pipeStructureCobblestone"),
		//
		PipeItemsLead("pipeItemsLead"), // PipeItemsCobbleStone("pipeItemsCobblestone"),
		//
		PipeItemsBlueSteel_Item("pipeItemsBlueSteel_item"), // PipeItemsDiamond_Item("pipeItemsDiamond_item"),
		PipeItemsBlueSteel_Center("pipeItemsBlueSteel_center"), // PipeItemsDiamond_Center("pipeItemsDiamond_center"),
		PipeItemsBlueSteel_Down("pipeItemsBlueSteel_down"), // PipeItemsDiamond_Down("pipeItemsDiamond_down"),
		PipeItemsBlueSteel_Up("pipeItemsBlueSteel_up"), // PipeItemsDiamond_Up("pipeItemsDiamond_up"),
		PipeItemsBlueSteel_North("pipeItemsBlueSteel_north"), // PipeItemsDiamond_North("pipeItemsDiamond_north"),
		PipeItemsBlueSteel_South("pipeItemsBlueSteel_south"), // PipeItemsDiamond_South("pipeItemsDiamond_south"),
		PipeItemsBlueSteel_West("pipeItemsBlueSteel_west"), // PipeItemsDiamond_West("pipeItemsDiamond_west", "pipeItemsDiamond_west_cb"),
		PipeItemsBlueSteel_East("pipeItemsBlueSteel_east"), // PipeItemsDiamond_East("pipeItemsDiamond_east"),
		//
		PipeItemsMarker_Black("pipeItemsMarker_black"), // PipeItemsLapis_Black("pipeItemsLapis_black"),
		PipeItemsMarker_Red("pipeItemsMarker_red"), // PipeItemsLapis_Red("pipeItemsLapis_red"),
		PipeItemsMarker_Green("pipeItemsMarker_green"), // PipeItemsLapis_Green("pipeItemsLapis_green"),
		PipeItemsMarker_Brown("pipeItemsMarker_brown"), // PipeItemsLapis_Brown("pipeItemsLapis_brown"),
		PipeItemsMarker_Blue("pipeItemsMarker_blue"), // PipeItemsLapis_Blue("pipeItemsLapis_blue"),
		PipeItemsMarker_Purple("pipeItemsMarker_purple"), // PipeItemsLapis_Purple("pipeItemsLapis_purple"),
		PipeItemsMarker_Cyan("pipeItemsMarker_cyan"), // PipeItemsLapis_Cyan("pipeItemsLapis_cyan"),
		PipeItemsMarker_LightGray("pipeItemsMarker_lightgray"), // PipeItemsLapis_LightGray("pipeItemsLapis_lightgray"),
		PipeItemsMarker_Gray("pipeItemsMarker_gray"), // PipeItemsLapis_Gray("pipeItemsLapis_gray"),
		PipeItemsMarker_Pink("pipeItemsMarker_pink"), // PipeItemsLapis_Pink("pipeItemsLapis_pink"),
		PipeItemsMarker_Lime("pipeItemsMarker_lime"), // PipeItemsLapis_Lime("pipeItemsLapis_lime"),
		PipeItemsMarker_Yellow("pipeItemsMarker_yellow"), // PipeItemsLapis_Yellow("pipeItemsLapis_yellow"),
		PipeItemsMarker_LightBlue("pipeItemsMarker_lightblue"), // PipeItemsLapis_LightBlue("pipeItemsLapis_lightblue"),
		PipeItemsMarker_Magenta("pipeItemsMarker_magenta"), // PipeItemsLapis_Magenta("pipeItemsLapis_magenta"),
		PipeItemsMarker_Orange("pipeItemsMarker_orange"), // PipeItemsLapis_Orange("pipeItemsLapis_orange"),
		PipeItemsMarker_White("pipeItemsMarker_white"), // PipeItemsLapis_White("pipeItemsLapis_white"),
		//
		PipeItemsFilter_Black("pipeItemsFilter_black"), // PipeItemsDaizuli_Black("pipeItemsDaizuli_black"),
		PipeItemsFilter_Red("pipeItemsFilter_red"), // PipeItemsDaizuli_Red("pipeItemsDaizuli_red"),
		PipeItemsFilter_Green("pipeItemsFilter_green"), // PipeItemsDaizuli_Green("pipeItemsDaizuli_green"),
		PipeItemsFilter_Brown("pipeItemsFilter_brown"), // PipeItemsDaizuli_Brown("pipeItemsDaizuli_brown"),
		PipeItemsFilter_Blue("pipeItemsFilter_blue"), // PipeItemsDaizuli_Blue("pipeItemsDaizuli_blue"),
		PipeItemsFilter_Purple("pipeItemsFilter_purple"), // PipeItemsDaizuli_Purple("pipeItemsDaizuli_purple"),
		PipeItemsFilter_Cyan("pipeItemsFilter_cyan"), // PipeItemsDaizuli_Cyan("pipeItemsDaizuli_cyan"),
		PipeItemsFilter_LightGray("pipeItemsFilter_lightgray"), // PipeItemsDaizuli_LightGray("pipeItemsDaizuli_lightgray"),
		PipeItemsFilter_Gray("pipeItemsFilter_gray"), // PipeItemsDaizuli_Gray("pipeItemsDaizuli_gray"),
		PipeItemsFilter_Pink("pipeItemsFilter_pink"), // PipeItemsDaizuli_Pink("pipeItemsDaizuli_pink"),
		PipeItemsFilter_Lime("pipeItemsFilter_lime"), // PipeItemsDaizuli_Lime("pipeItemsDaizuli_lime"),
		PipeItemsFilter_Yellow("pipeItemsFilter_yellow"), // PipeItemsDaizuli_Yellow("pipeItemsDaizuli_yellow"),
		PipeItemsFilter_LightBlue("pipeItemsFilter_lightblue"), // PipeItemsDaizuli_LightBlue("pipeItemsDaizuli_lightblue"),
		PipeItemsFilter_Magenta("pipeItemsFilter_magenta"), // PipeItemsDaizuli_Magenta("pipeItemsDaizuli_magenta"),
		PipeItemsFilter_Orange("pipeItemsFilter_orange"), // PipeItemsDaizuli_Orange("pipeItemsDaizuli_orange"),
		PipeItemsFilter_White("pipeItemsFilter_white"), // PipeItemsDaizuli_White("pipeItemsDaizuli_white"),
		PipeAllFilter_Solid("pipeAllFilter_solid"), // PipeAllDaizuli_Solid("pipeAllDaizuli_solid"),
		//
		PipeItemsCopper_Standard("pipeItemsCopper_standard"), // PipeItemsWood_Standard("pipeItemsWood_standard"),
		PipeAllCopper_Solid("pipeAllCopper_solid"), // PipeAllWood_Solid("pipeAllWood_solid"),
		//
		PipeItemsRedSteel_Standard("pipeItemsRedSteel_standard"), // PipeItemsEmerald_Standard("pipeItemsEmerald_standard"),
		PipeAllRedSteel_Solid("pipeAllRedSteel_solid"), // PipeAllEmerald_Solid("pipeAllEmerald_solid"),
		//
		PipeItemsMarkerExtractor_Standard("pipeItemsMarkerExtractor_standard"), // PipeItemsEmzuli_Standard("pipeItemsEmzuli_standard"),
		PipeAllMarkerExtractor_Solid("pipeAllMarkerExtractor_solid"), // PipeAllEmzuli_Solid("pipeAllEmzuli_solid"),
		//
		PipeItemsElectrum("pipeItemsElectrum"), // PipeItemsGold("pipeItemsGold"),
		//
		PipeItemsWroughtIron_Standard("pipeItemsWroughtIron_standard"), // PipeItemsIron_Standard("pipeItemsIron_standard"),
		PipeAllWroughtIron_Solid("pipeAllWroughtIron_solid"), // PipeAllIron_Solid("pipeAllIron_solid"),
		//
		PipeItemsBlackSteel("pipeItemsBlackSteel"), // PipeItemsObsidian("pipeItemsObsidian"),
		PipeItemsSilver("pipeItemsSilver"), // PipeItemsSandstone("pipeItemsSandstone"),
		PipeItemsBronze("pipeItemsBronze"), // PipeItemsStone("pipeItemsStone"),
		PipeItemsSterlingSilver("pipeItemsSterlingSilver"), // PipeItemsQuartz("pipeItemsQuartz"),
		PipeItemsZinc("pipeItemsZinc"), // PipeItemsClay("pipeItemsClay"),
		PipeItemsNullify("pipeItemsNullify"), // PipeItemsVoid("pipeItemsVoid"),
		//
		PipeFluidsLead("pipeFluidsLead"), // PipeFluidsCobblestone("pipeFluidsCobblestone"),
		PipeFluidsCopper_Standard("pipeFluidsCopper_standard"), // PipeFluidsWood_Standard("pipeFluidsWood_standard"),
		PipeFluidsRedSteel_Standard("pipeFluidsRedSteel_standard"), // PipeFluidsEmerald_Standard("pipeFluidsEmerald_standard"),
		PipeFluidsSterlingSilver("pipeFluidsSterlingSilver"), // PipeFluidsQuartz("pipeFluidsQuartz"),
		PipeFluidsElectrum("pipeFluidsElectrum"), // PipeFluidsGold("pipeFluidsGold"),
		PipeFluidsWroughtIron_Standard("pipeFluidsWroughtIron_standard"), // PipeFluidsIron_Standard("pipeFluidsIron_standard"),
		PipeFluidsSilver("pipeFluidsSilver"), // PipeFluidsSandstone("pipeFluidsSandstone"),
		PipeFluidsBronze("pipeFluidsBronze"), // PipeFluidsStone("pipeFluidsStone"),
		PipeFluidsNullify("pipeFluidsNullify"), // PipeFluidsVoid("pipeFluidsVoid"),
		PipeFluidsZinc("pipeFluidsZinc"), // PipeFluidsClay("pipeFluidsClay"),
		//
		PipeFluidsBlueSteel_Item("pipeFluidsBlueSteel_item"), // PipeFluidsDiamond_Item("pipeFluidsDiamond_item"),
		PipeFluidsBlueSteel_Center("pipeFluidsBlueSteel_center"), // PipeFluidsDiamond_Center("pipeFluidsDiamond_center"),
		PipeFluidsBlueSteel_Down("pipeFluidsBlueSteel_down"), // PipeFluidsDiamond_Down("pipeFluidsDiamond_down"),
		PipeFluidsBlueSteel_Up("pipeFluidsBlueSteel_up"), // PipeFluidsDiamond_Up("pipeFluidsDiamond_up"),
		PipeFluidsBlueSteel_North("pipeFluidsBlueSteel_north"), // PipeFluidsDiamond_North("pipeFluidsDiamond_north"),
		PipeFluidsBlueSteel_South("pipeFluidsBlueSteel_south"), // PipeFluidsDiamond_South("pipeFluidsDiamond_south"),
		PipeFluidsBlueSteel_West("pipeFluidsBlueSteel_west"), // PipeFluidsDiamond_West("pipeFluidsDiamond_west", "pipeFluidsDiamond_west_cb"),
		PipeFluidsBlueSteel_East("pipeFluidsBlueSteel_east"), // PipeFluidsDiamond_East("pipeFluidsDiamond_east"),
		//
		PipePowerBlueSteel("pipePowerBlueSteel"), // PipePowerDiamond("pipePowerDiamond"),
		PipePowerElectrum("pipePowerElectrum"), // PipePowerGold("pipePowerGold"),
		PipePowerSterlingSilver("pipePowerSterlingSilver"), // PipePowerQuartz("pipePowerQuartz"),
		PipePowerBronze("pipePowerBronze"), // PipePowerStone("pipePowerStone"),
		PipePowerSilver("pipePowerSilver"), // PipePowerSandstone("pipePowerSandstone"),
		PipePowerLead("pipePowerLead"), // PipePowerCobblestone("pipePowerCobblestone"),
		PipePowerCopper_Standard("pipePowerCopper_standard"), // PipePowerWood_Standard("pipePowerWood_standard"),
		PipePowerRedSteel_Standard("pipePowerRedSteel_standard"), // PipePowerEmerald_Standard("pipePowerEmerald_standard"),
		//
		PipePowerWroughtIronM2("pipePowerWroughtIronM2"), // PipePowerIronM2("pipePowerIronM2"),
		PipePowerWroughtIronM4("pipePowerWroughtIronM4"), // PipePowerIronM4("pipePowerIronM4"),
		PipePowerWroughtIronM8("pipePowerWroughtIronM8"), // PipePowerIronM8("pipePowerIronM8"),
		PipePowerWroughtIronM16("pipePowerWroughtIronM16"), // PipePowerIronM16("pipePowerIronM16"),
		PipePowerWroughtIronM32("pipePowerWroughtIronM32"), // PipePowerIronM32("pipePowerIronM32"),
		PipePowerWroughtIronM64("pipePowerWroughtIronM64"), // PipePowerIronM64("pipePowerIronM64"),
		PipePowerWroughtIronM128("pipePowerWroughtIronM128"); // PipePowerIronM128("pipePowerIronM128"),
		
		public static final TYPE[] VALUES = values();
		private final String iconTag;
		private IIcon icon;
		
		TYPE(String iconTag) {
			this.iconTag = iconTag;
		}
		
		private void registerIcon(IIconRegister iconRegister) {
			icon = iconRegister.registerIcon(ModDetails.ModID + ":pipes/" + iconTag);
		}
		
		public IIcon getIcon() {
			return icon;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int pipeIconIndex) {
		if (pipeIconIndex == -1) {
			return null;
		}
		return TYPE.VALUES[pipeIconIndex].icon;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		for (TYPE type : TYPE.VALUES) {
			type.registerIcon(iconRegister);
		}
	}
}
