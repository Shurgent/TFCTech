package ua.pp.shurgent.tfctech.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import ua.pp.shurgent.tfctech.core.ModDetails;

import com.bioxx.tfc.api.TFCOptions;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;

public class ItemModOreSmall extends ItemModOre {

	public ItemModOreSmall() {
		super();
		this.setWeight(EnumWeight.HEAVY);
		this.setSize(EnumSize.TINY);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item item, CreativeTabs tabs, List list) {
		list.add(new ItemStack(this, 1, 0)); // Bauxite
	}

	@Override
	public void registerIcons(IIconRegister registerer) {
		metaIcons = new IIcon[1];
		metaIcons[0] = registerer.registerIcon(ModDetails.ModID + ":" + textureFolder + metaNames[0] + " Small Ore");
	}

	@Override
	public short getMetalReturnAmount(ItemStack is) {
		int dam = is.getItemDamage();
		switch (dam) {
		case 0:
			return (short) TFCOptions.smallOreUnits;
		}
		return 0;
	}
}
