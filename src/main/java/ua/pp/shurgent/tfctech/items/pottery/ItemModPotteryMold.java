package ua.pp.shurgent.tfctech.items.pottery;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import ua.pp.shurgent.tfctech.core.ModDetails;

import com.bioxx.tfc.Items.Pottery.ItemPotteryMold;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

//Need to extend ItemPotteryMold to get mold pouring works
public class ItemModPotteryMold extends ItemPotteryMold {

	private int metaCount;

	public ItemModPotteryMold(String[] metaNames) {
		super();
		setMetaNames(metaNames);
		metaCount = this.metaNames.length;
		metaIcons = new IIcon[metaCount];
		this.setMaxDamage((metaCount - 2) * 100 + 1);
	}

	@Override
	public boolean isDamageable() {
		return this.getMaxDamage() > 0;
	}

	@Override
	public void addItemInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
		if (is.getItemDamage() >= metaCount) {
			int units = 100 - ((is.getItemDamage() - 2) / (metaCount - 2));
			arraylist.add(StatCollector.translateToLocal("gui.units") + ": " + units + " / 100");
		}
	}

	@Override
	public boolean isDamaged(ItemStack stack) {
		return stack.getItemDamage() >= metaCount;
	}

	@Override
	public void registerIcons(IIconRegister registerer) {
		this.clayIcon = registerer.registerIcon(ModDetails.ModID + ":" + textureFolder + metaNames[0]);
		this.ceramicIcon = registerer.registerIcon(ModDetails.ModID + ":" + textureFolder + metaNames[1]);

		for (int i = 0; i < metaCount; i++) {
			metaIcons[i] = registerer.registerIcon(ModDetails.ModID + ":" + textureFolder + metaNames[i]);
		}

	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		if (par1ItemStack != null && par1ItemStack.getItemDamage() >= metaCount) {
			int damage = (par1ItemStack.getItemDamage() - 2) % (metaCount - 2) + 2;
			return baseGetUnlocalizedName(par1ItemStack) + "." + metaNames[damage];
		}
		return baseGetUnlocalizedName(par1ItemStack);
	}

	private String baseGetUnlocalizedName(ItemStack itemstack) {
		if (metaNames != null && itemstack.getItemDamage() < metaNames.length)
			return getUnlocalizedName().concat("." + metaNames[itemstack.getItemDamage()]);
		return super.getUnlocalizedName(itemstack);
	}

	@Override
	public IIcon getIconFromDamage(int damage) {
		if (damage > (metaCount - 2)) {
			damage = (damage - 2) % (metaCount - 2) + 2;
		}

		return metaIcons[damage];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tabs, List list) {
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
	}
}
