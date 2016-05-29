package ua.pp.shurgent.tfctech.api.crafting;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.bioxx.tfc.api.Constant.Global;

public class WireDrawingBenchRecipe {
	
	public ItemStack inItemStack;
	public ItemStack outItemStack;
	public int drawplateReq;
	public boolean oilRequired;
	public int craftingXP = 1;
	public List<String> skillsList = new ArrayList<String>();
	
	public WireDrawingBenchRecipe(ItemStack inIS, ItemStack outIS, DrawplateReq req, boolean oil) {
		this.inItemStack = inIS;
		this.outItemStack = outIS;
		this.drawplateReq = req.Tier;
		this.oilRequired = oil;
		skillsList.add(Global.SKILL_GENERAL_SMITHING);
	}
	
	public WireDrawingBenchRecipe setCraftingXP(int xp) {
		this.craftingXP = xp;
		return this;
	}
	
	public Boolean matches(WireDrawingBenchRecipe recipe) {
		if (areItemStacksEqual(inItemStack, recipe.inItemStack) && DrawplateReq.matches(drawplateReq, recipe.drawplateReq)) {
			return !this.oilRequired || recipe.oilRequired;
		}
		return false;
	}
	
	public Boolean resultMatches(ItemStack item) {
		boolean iStack = outItemStack != null && item != null && item.stackSize == outItemStack.stackSize;
		
		boolean itemsEqual = OreDictionary.itemMatches(outItemStack, item, false);
		
		return iStack && itemsEqual;
	}
	
	public Boolean partiallyMatches(ItemStack item) {
		boolean iStack = inItemStack != null && item != null;
		
		boolean itemsEqual = OreDictionary.itemMatches(inItemStack, item, false);
		
		return iStack && itemsEqual;
	}
	
	public ItemStack getInItem() {
		return inItemStack;
	}
	
	public String getRecipeName() {
		String s = "";
		if (this.outItemStack != null)
			s = outItemStack.getDisplayName();
		return s;
	}
	
	public ItemStack getResult(ItemStack inIS) {
		ItemStack is = null;
		if (outItemStack != null) {
			is = outItemStack.copy();
			return is;
		}
		return is;
	}
	
	/**
	 * Returns an Item that is the result of this recipe
	 */
	public ItemStack getCraftingResult() {
		return outItemStack;
	}
	
	public ItemStack getOutItemStack() {
		return outItemStack;
	}
	
	private boolean areItemStacksEqual(ItemStack is1, ItemStack is2) {
		if (is1 != null && is2 != null) {
			if (is1.getItem() != is2.getItem())
				return false;
			
			if (is1.getItemDamage() != 32767 && is1.getItemDamage() != is2.getItemDamage())
				return false;
		} else if (is1 == null && is2 != null || is1 != null && is2 == null) // XOR, if both are null return true
			return false;
		
		return true;
	}
	
	public ItemStack getInput() {
		return inItemStack;
	}
	
	public boolean isOilRequired() {
		return oilRequired;
	}
	
	public int getDrawplateReq() {
		return drawplateReq;
	}
	
	public int getCraftingXP() {
		return craftingXP;
	}
	
	public List<String> getSkillsList() {
		return skillsList;
	}
}
