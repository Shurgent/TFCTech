package ua.pp.shurgent.tfctech.api.crafting;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.bioxx.tfc.api.Constant.Global;

public class WireDrawBenchRecipe {
	
	public ItemStack inItemStack;
	public ItemStack outItemStack;
	public int drawplateReq;
	public boolean oilRequired;
	public int craftingXP = 1;
	public List<String> skillsList = new ArrayList<String>();
	
	/**
	 * @param inIS - Input ItemStack
	 * @param outIS - Output ItemStack
	 * @param req - Drawplate requirement
	 * @param oil - Is oiling required
	 */
	public WireDrawBenchRecipe(ItemStack inIS, ItemStack outIS, DrawplateReq req, boolean oil) {
		this.inItemStack = inIS;
		this.outItemStack = outIS;
		this.drawplateReq = req.Tier;
		this.oilRequired = oil;
		skillsList.add(Global.SKILL_GENERAL_SMITHING);
	}
	
	/**
	 * @param inIS - Input ItemStack
	 * @param req - Drawplate requirement
	 * @param oil - Is oiling required
	 */
	public WireDrawBenchRecipe(ItemStack inIS, DrawplateReq req, boolean oil) {
		this(inIS, req.Tier, oil);
	}
	
	/**
	 * @param inIS - Input ItemStack
	 * @param req - Drawplate tier required
	 * @param oil - Is oiling required
	 */
	public WireDrawBenchRecipe(ItemStack inIS, int req, boolean oil) {
		this.inItemStack = inIS;
		this.drawplateReq = req;
		this.oilRequired = oil;
	}
	
	/**
	 * @param xp - Experience amount (default 1)
	 * @return - WireDrawingBenchRecipe
	 */
	public WireDrawBenchRecipe setCraftingXP(int xp) {
		this.craftingXP = xp;
		return this;
	}
	
	public Boolean matches(WireDrawBenchRecipe recipe) {
		if (areItemStacksEqual(inItemStack, recipe.inItemStack) && DrawplateReq.matches(drawplateReq, recipe.drawplateReq)) {
			return !this.oilRequired || recipe.oilRequired;
		}
		return false;
	}
	
	public Boolean matches(ItemStack item) {
		boolean iStack = inItemStack != null && item != null && item.stackSize == inItemStack.stackSize;
		
		boolean itemsEqual = OreDictionary.itemMatches(inItemStack, item, false);
		
		return iStack && itemsEqual;
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
