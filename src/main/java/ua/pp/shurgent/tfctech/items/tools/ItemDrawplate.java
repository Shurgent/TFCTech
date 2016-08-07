package ua.pp.shurgent.tfctech.items.tools;

import net.minecraft.item.ItemStack;

import com.bioxx.tfc.api.Metal;
import com.bioxx.tfc.api.Crafting.AnvilManager;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;

public class ItemDrawplate extends ItemTFCTechForgedItem {
	
	private Metal metal;
	
	public ItemDrawplate(Metal m) {
		this.metal = m;
		setNoRepair();
	}
	
	@Override
	public Metal getMetalType(ItemStack is) {
		return this.metal;
	}
	
	@Override
	public boolean canStack() {
		return false;
	}
	
	@Override
	public EnumSize getSize(ItemStack is) {
		return EnumSize.LARGE;
	}
	
	@Override
	public EnumWeight getWeight(ItemStack is) {
		return EnumWeight.MEDIUM;
	}
	
	@Override
	public int getMaxDamage(ItemStack stack) {
		return (int) (getMaxDamage() + (getMaxDamage() * AnvilManager.getDurabilityBuff(stack)));
	}
	
}
