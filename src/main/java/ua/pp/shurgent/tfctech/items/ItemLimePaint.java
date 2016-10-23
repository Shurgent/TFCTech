package ua.pp.shurgent.tfctech.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import ua.pp.shurgent.tfctech.core.ModDetails;

import com.bioxx.tfc.Items.ItemDyeCustom;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLimePaint extends ItemDyeCustom {

	@SideOnly(Side.CLIENT)
	protected IIcon[] icons;

	public ItemLimePaint() {
		this.textureFolder = "dyes/";
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Gets an icon index based on an item's damage value
	 */
	public IIcon getIconFromDamage(int dmg) {
		int j = MathHelper.clamp_int(dmg, 0, 15);
		return this.icons[j];
	}

	/**
	 * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
	 * different names based on their damage or NBT.
	 */
	@Override
	public String getUnlocalizedName(ItemStack is)
	{
		int i = MathHelper.clamp_int(is.getItemDamage(), 0, 15);
		return super.getUnlocalizedName() + "." + DYE_COLOR_NAMES[i];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister registerer) {
		this.icons = new IIcon[DYE_COLOR_NAMES.length];
		String col;
		for (int i = 0; i < DYE_COLOR_NAMES.length; ++i) {
			col = "_" + DYE_COLOR_NAMES[i];
			if (this.iconString != null)
				this.icons[i] = registerer.registerIcon(ModDetails.ModID + ":" + this.textureFolder + this.getIconString() + col);
			else
				this.icons[i] = registerer.registerIcon(ModDetails.ModID + ":" + this.textureFolder + this.getUnlocalizedName().replace("item.", "") + col);
		}
	}

	@Override
	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		return false;
	}
}
