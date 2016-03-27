package ua.pp.shurgent.tfctech.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import ua.pp.shurgent.tfctech.core.ModDetails;

import com.bioxx.tfc.Core.TFCTabs;
import com.bioxx.tfc.Core.Metal.MetalRegistry;
import com.bioxx.tfc.Items.ItemTerra;
import com.bioxx.tfc.api.Metal;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;
import com.bioxx.tfc.api.Interfaces.ISmeltable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGear extends ItemTerra implements ISmeltable {

	private EnumSize size = EnumSize.LARGE;
	private String primaryMetal;
	private short primaryMetalAmount;
	private String secondaryMetal;
	private short secondaryMetalAmount;
	
	public ItemGear(String m, int amt, String m2, int amt2) {
		super();
		setCreativeTab(TFCTabs.TFC_MISC);
		this.setFolder("gears/");
		this.setMetal(m, amt, m2, amt2);
	}

	public ItemGear setMetal(String m, int amt, String m2, int amt2) {
		primaryMetal = m;
		primaryMetalAmount = (short) amt;
		secondaryMetal = m2;
		secondaryMetalAmount = (short) amt2;
		return this;
	}

	@Override
	public void registerIcons(IIconRegister registerer) {
		this.itemIcon = registerer.registerIcon(ModDetails.ModID + ":" + textureFolder + this.getUnlocalizedName().replace("item.", ""));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	@Override
	public EnumSize getSize(ItemStack is) {
		return size;
	}

	@Override
	public EnumWeight getWeight(ItemStack is) {
		return EnumWeight.MEDIUM;
	}

	@Override
	public ItemGear setSize(EnumSize s) {
		size = s;
		return this;
	}

	public void addCreativeItems(List<ItemStack> list) {
		list.add(new ItemStack(this));
	}

	@Override
	public Metal getMetalType(ItemStack is) {
		if (primaryMetal.equals(secondaryMetal)) {
			return getPrimaryMetalType();
		} else {
			return MetalRegistry.instance.getMetalFromString("Unknown");
		}
	}
	
	public Metal getPrimaryMetalType() {
		return MetalRegistry.instance.getMetalFromString(primaryMetal);
	}
	
	public Metal getSecondaryMetalType() {
		return MetalRegistry.instance.getMetalFromString(secondaryMetal);
	}
	
	@Override
	public short getMetalReturnAmount(ItemStack is) {
		return (short)(primaryMetalAmount + secondaryMetalAmount);
	}
	
	public short getPrimaryMetalReturnAmount() {
		return primaryMetalAmount;
	}

	public short getSecondaryMetalReturnAmount() {
		return secondaryMetalAmount;
	}

	@Override
	public boolean isSmeltable(ItemStack is) {
		return primaryMetal.equals(secondaryMetal); //Smeltable only if primary and secondary metals match
	}

	@Override
	public EnumTier getSmeltTier(ItemStack is) {
		return EnumTier.TierI;
	}
}
