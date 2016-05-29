package ua.pp.shurgent.tfctech.api.crafting;

import java.util.ArrayList;
import java.util.List;

public class WireDrawingBenchManager {
	
	private static final WireDrawingBenchManager INSTANCE = new WireDrawingBenchManager();
	
	public static final WireDrawingBenchManager getInstance() {
		return INSTANCE;
	}
	
	private List<WireDrawingBenchRecipe> recipes;
	
	public WireDrawingBenchManager() {
		recipes = new ArrayList<WireDrawingBenchRecipe>();
	}
	
	public void addRecipe(WireDrawingBenchRecipe recipe) {
		recipes.add(recipe);
	}
	
	public void clearRecipes() {
		recipes.clear();
	}
	
	public WireDrawingBenchRecipe findMatchingRecipe(WireDrawingBenchRecipe recipe) {
		for (int k = 0; k < recipes.size(); k++) {
			WireDrawingBenchRecipe irecipe = recipes.get(k);
			if (irecipe != null && irecipe.matches(recipe))
				return irecipe;
		}
		
		return null;
	}
	
	public List<WireDrawingBenchRecipe> getRecipeList() {
		return recipes;
	}
}
