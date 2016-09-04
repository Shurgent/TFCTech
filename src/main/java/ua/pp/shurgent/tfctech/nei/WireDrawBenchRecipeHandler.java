package ua.pp.shurgent.tfctech.nei;

import static codechicken.lib.gui.GuiDraw.changeTexture;
import static codechicken.lib.gui.GuiDraw.drawTexturedModalRect;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import ua.pp.shurgent.tfctech.api.crafting.DrawplateReq;
import ua.pp.shurgent.tfctech.api.crafting.WireDrawBenchManager;
import ua.pp.shurgent.tfctech.api.crafting.WireDrawBenchRecipe;
import ua.pp.shurgent.tfctech.core.ModDetails;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.core.ModUtils;
import ua.pp.shurgent.tfctech.items.tools.ItemDrawplate;
import ua.pp.shurgent.tfctech.items.tools.ItemOilCan;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class WireDrawBenchRecipeHandler extends TemplateRecipeHandler {
	
	private static final String OID = "wiredrawbench";
	private static List<WireDrawBenchRecipe> recipeList;
	
	@Override
	public String getRecipeName() {
		return StatCollector.translateToLocal("item.Wire Draw Bench.name");
	}
	
	@Override
	public String getGuiTexture() {
		return new ResourceLocation(ModDetails.ModID, "textures/gui/WireDrawBenchRecipe.png").toString();
	}
	
	@Override
	public String getOverlayIdentifier() {
		return OID;
	}
	
	@Override
	public void loadCraftingRecipes(String outputId, Object... results) {
		if (outputId.equals(OID) && getClass() == WireDrawBenchRecipeHandler.class) {
			for (WireDrawBenchRecipe recipe : recipeList)
				arecipes.add(new CachedWireDrawBenchRecipe(recipe));
		} else
			super.loadCraftingRecipes(outputId, results);
	}
	
	@Override
	public void loadCraftingRecipes(ItemStack result) {
		for (WireDrawBenchRecipe recipe : recipeList)
			if (ModUtils.areItemStacksEqual(result, recipe.getCraftingResult()))
				arecipes.add(new CachedWireDrawBenchRecipe(recipe));
	}
	
	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		
		if (ingredient.getItem() instanceof ItemOilCan) {
			for (WireDrawBenchRecipe recipe : recipeList) {
				if (recipe.oilRequired)
					arecipes.add(new CachedWireDrawBenchRecipe(recipe));
			}
		} else if (ingredient.getItem() instanceof ItemDrawplate) {
			for (WireDrawBenchRecipe recipe : recipeList) {
				if (DrawplateReq.getReqFromInt(recipe.getDrawplateReq()).matches(DrawplateReq.getReqFromItem((ItemDrawplate) ingredient.getItem())))
					arecipes.add(new CachedWireDrawBenchRecipe(recipe));
			}
		} else {
			for (WireDrawBenchRecipe recipe : recipeList) {
				if (recipe.getInput().getItem().equals(ingredient.getItem()) && recipe.getInput().getItemDamage() == ingredient.getItemDamage())
					arecipes.add(new CachedWireDrawBenchRecipe(recipe));
			}
		}
		
	}
	
	@Override
	public TemplateRecipeHandler newInstance() {
		if (recipeList == null) {
			recipeList = WireDrawBenchManager.getInstance().getRecipeList();
		}
		return super.newInstance();
	}
	
	@Override
	public int recipiesPerPage() {
		return 1;
	}
	
	@Override
	public void drawBackground(int recipe) {
		GL11.glColor4f(1, 1, 1, 1);
		changeTexture(getGuiTexture());
		drawTexturedModalRect(-5, 16, 0, 0, 176, 104);
	}
	
	@Override
	public void drawExtras(int recipe) {
		super.drawExtras(recipe);
		CachedRecipe cr = arecipes.get(recipe);
		if (cr instanceof CachedWireDrawBenchRecipe) {
			FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
			String s = ((CachedWireDrawBenchRecipe) cr).drawplateReq;
			fontrenderer.drawString(s, 83 - fontrenderer.getStringWidth(s) / 2, 0, 0x820093);
		}
	}
	
	public class CachedWireDrawBenchRecipe extends CachedRecipe {
		PositionedStack in;
		PositionedStack oil;
		final PositionedStack out;
		public final String drawplateReq;
		
		public CachedWireDrawBenchRecipe(WireDrawBenchRecipe recipe) {
			this(recipe.getDrawplateReq(), recipe.getCraftingResult(), recipe.getInput(), recipe.isOilRequired());
		}
		
		public CachedWireDrawBenchRecipe(int drawplateReq, ItemStack out, ItemStack in, boolean oilReq) {
			StringBuilder sb = new StringBuilder();
			for (DrawplateReq a : DrawplateReq.RULES) {
				if (a.Tier != drawplateReq)
					continue;
				sb.append(a.Name).append(" drawplate or better");
				break;
			}
			this.drawplateReq = sb.toString();
			if (in != null)
				this.in = new PositionedStack(in, 110, 36);
			if (oilReq)
				this.oil = new PositionedStack(new ItemStack(ModItems.oilcan), 134, 36);
			this.out = new PositionedStack(out, 30, 36);
		}
		
		@Override
		public List<PositionedStack> getIngredients() {
			ArrayList<PositionedStack> stacks = new ArrayList<PositionedStack>();
			if (in != null)
				stacks.add(in);
			if (oil != null)
				stacks.add(oil);
			return stacks;
		}
		
		@Override
		public PositionedStack getResult() {
			return out;
		}
	}
}
