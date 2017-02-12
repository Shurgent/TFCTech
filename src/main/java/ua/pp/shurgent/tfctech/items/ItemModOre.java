package ua.pp.shurgent.tfctech.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import ua.pp.shurgent.tfctech.Globals;
import ua.pp.shurgent.tfctech.core.ModDetails;
import ua.pp.shurgent.tfctech.core.ModOptions;

import com.bioxx.tfc.Items.ItemOre;
import com.bioxx.tfc.api.Metal;
import com.bioxx.tfc.api.TFCOptions;

public class ItemModOre extends ItemOre {

	public ItemModOre() {
		super();
		metaNames = new String[] { "Bauxite", "Rich Bauxite", "Poor Bauxite" };
	}

	@Override
	public void registerIcons(IIconRegister registerer)
	{
		metaIcons = new IIcon[metaNames.length];
		for(int i = 0; i < metaNames.length; i++)
		{
			metaIcons[i] = registerer.registerIcon(ModDetails.ModID + ":" + textureFolder + metaNames[i] + " Ore");
		}
	}

	@Override
	public Metal getMetalType(ItemStack is) {
		int dam = is.getItemDamage();
		switch (dam) {
		case 0: // Bauxite
		case 1: // Rich Bauxite
		case 2: // Poor Bauxite
			return ModOptions.cfgEnableHeatingBauxite ? Globals.ALUMINUM : null;
		}
		return null;
	}

	@Override
	public short getMetalReturnAmount(ItemStack is) {
		int dam = is.getItemDamage();
		switch (dam) {
		case 0:
			return (short) TFCOptions.normalOreUnits;
		case 1:
			return (short) TFCOptions.richOreUnits;
		case 2:
			return (short) TFCOptions.poorOreUnits;
		}
		return 0;
	}

	@Override
	public boolean isSmeltable(ItemStack is) {
		switch (is.getItemDamage()) {
		case 0:
		case 1:
		case 2:
			return ModOptions.cfgEnableHeatingBauxite;
		default:
			return false;
		}
	}

	@Override
	public EnumTier getSmeltTier(ItemStack is) {
		int dam = is.getItemDamage();
		switch (dam) {
		case 0:
		case 1:
		case 2:
			return EnumTier.TierI;
		}
		return EnumTier.TierX;
	}

}
