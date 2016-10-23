package ua.pp.shurgent.tfctech.api.crafting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import ua.pp.shurgent.tfctech.core.ModDetails;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WireDrawBenchManager {
	
	private static final WireDrawBenchManager INSTANCE = new WireDrawBenchManager();
	
	public static final WireDrawBenchManager getInstance() {
		return INSTANCE;
	}
	
	private Map<Item, Integer> drawplates;
	private List<WireDrawBenchRecipe> recipes;
	private Map<String, IIcon> wireIcons;
	
	public WireDrawBenchManager() {
		drawplates = new HashMap<Item, Integer>();
		recipes = new ArrayList<WireDrawBenchRecipe>();
		wireIcons = new HashMap<String, IIcon>();
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister registerer) {
		String[] names = new String[] {
				"Tin",
				"Copper",
				"Gold",
				"Aluminum",
				"Electrum",
				"Wrought Iron",
				"Steel",
				"Red Alloy"
		};
		String prefix = ModDetails.ModID + ":metal/";
		for (String metal : names)
			addWireIcon(registerer, metal, prefix + metal);
	}
	
	public void addDrawplate(Item item, DrawplateReq req) {
		this.addDrawplate(item, req.Tier);
	}
	
	public void addDrawplate(Item item, int tier) {
		drawplates.put(item, tier);
	}
	
	public void clearDrawplates() {
		drawplates.clear();
	}
	
	public void addRecipe(WireDrawBenchRecipe recipe) {
		recipes.add(recipe);
	}
	
	public void clearRecipes() {
		recipes.clear();
	}
	
	public WireDrawBenchRecipe findMatchingRecipe(WireDrawBenchRecipe recipe) {
		for (int k = 0; k < recipes.size(); k++) {
			WireDrawBenchRecipe irecipe = recipes.get(k);
			if (irecipe != null && irecipe.matches(recipe))
				return irecipe;
		}
		
		return null;
	}
	
	public WireDrawBenchRecipe findMatchingRecipe(ItemStack item) {
		for (Object recipe : recipes) {
			WireDrawBenchRecipe lr = (WireDrawBenchRecipe) recipe;
			if (item != null && lr.matches(item))
				return lr;
		}
		return null;
	}
	
	public WireDrawBenchRecipe findMatchingResult(ItemStack item) {
		for (Object recipe : recipes) {
			WireDrawBenchRecipe lr = (WireDrawBenchRecipe) recipe;
			if (item != null && lr.resultMatches(item))
				return lr;
		}
		return null;
	}
	
	public boolean hasPotentialRecipes(ItemStack item) {
		return findPotentialRecipes(item) != null;
	}
	
	public WireDrawBenchRecipe findPotentialRecipes(ItemStack item) {
		for (Object recipe : recipes) {
			WireDrawBenchRecipe lr = (WireDrawBenchRecipe) recipe;
			if (item != null && lr.partiallyMatches(item))
				return lr;
		}
		return null;
	}
	
	public List<WireDrawBenchRecipe> getRecipeList() {
		return recipes;
	}
	
	public int getDrawplateTier(ItemStack drawplate) {
		if (drawplate != null) {
			Item item = drawplate.getItem();
			if (item != null) {
				WireDrawBenchManager manager = WireDrawBenchManager.getInstance();
				Integer result = manager.drawplates.get(item);
				if (result != null)
					return result.intValue();
			}
		}
		return 0;
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getWireIcon(String metal) {
		if (wireIcons.containsKey(metal))
			return wireIcons.get(metal);
		else
			return null;
	}
	
	@SideOnly(Side.CLIENT)
	public void addWireIcon(String metal, IIcon icon) {
		if (wireIcons.containsKey(metal))
			wireIcons.remove(metal);
		wireIcons.put(metal, icon);
	}
	
	@SideOnly(Side.CLIENT)
	public void addWireIcon(IIconRegister registerer, String metal, String iconName) {
		addWireIcon(metal, registerer.registerIcon(iconName));
	}
	
	@SideOnly(Side.CLIENT)
	public void clearWireIcons() {
		wireIcons.clear();
	}
}
