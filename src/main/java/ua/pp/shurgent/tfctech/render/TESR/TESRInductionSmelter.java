package ua.pp.shurgent.tfctech.render.TESR;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import ua.pp.shurgent.tfctech.core.ModDetails;
import ua.pp.shurgent.tfctech.render.models.ModelInductionSmelter;
import ua.pp.shurgent.tfctech.tileentities.TEInductionSmelter;

import com.bioxx.tfc.Reference;
import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.Render.TESR.TESRBase;

public class TESRInductionSmelter extends TESRBase {
	
	private static final ResourceLocation MELTED_METAL = new ResourceLocation(ModDetails.ModID, "textures/blocks/liquids/MeltedMetal.png");
	TEInductionSmelter teis = new TEInductionSmelter();
	
	public void renderTileEntityInductionSmelterAt(TEInductionSmelter te, double d, double d1, double d2, float f) {
		if (te.getWorldObj() != null) {
			if (te.getModel() == null) {
				te.setModel(new ModelInductionSmelter());
			}
			
			GL11.glPushMatrix(); // start
			GL11.glTranslatef((float) d + 0.0F, (float) d1 + 0.0F, (float) d2 + 0.0F); // size
			
			TFC_Core.bindTexture(te.getResource()); // texture
			
			ModelInductionSmelter model = te.getModel();
			
			model.rotation = te.rotation;
			
			model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			renderMetal(te);
			
			GL11.glPopMatrix(); // end
		}
	}
	
	private void renderMetal(TEInductionSmelter te) {
		Tessellator t = Tessellator.instance;
		if (te != null && te.currentAlloy != null && te.currentAlloy.outputAmount > 0) {
			float pos = te.currentAlloy.outputAmount / 3000F * 0.6875F + 0.125F;
			
			if (te.isMetalLiquid()) {
				RenderHelper.disableStandardItemLighting();
				OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);
				t.setBrightness(15728880);
				TFC_Core.bindTexture(MELTED_METAL);
				renderMetalAtPosition(t, pos, te.textureAnimationFrame);
				RenderHelper.enableStandardItemLighting();
			} else {
				TFC_Core.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/blocks/metal/" + te.currentAlloy.outputType.name + ".png"));
				renderMetalAtPosition(t, pos, (byte) -1);
			}
			
		}
	}
	
	private void renderMetalAtPosition(Tessellator t, float pos, byte frame) {
		t.startDrawingQuads();
		
		double d0 = frame == -1 ? 0D : 0.05D * frame;
		double d1 = frame == -1 ? 1D : 0.05D * frame + 0.05D;
		
		t.addVertexWithUV(0.1875D, pos, 0.1875D, 0, d0);
		t.addVertexWithUV(0.1875D, pos, 0.8125D, 0, d1);
		t.addVertexWithUV(0.8125D, pos, 0.8125D, 1, d1);
		t.addVertexWithUV(0.8125D, pos, 0.1875D, 1, d0);
		
		t.draw();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double d0, double d1, double d2, float f) {
		this.renderTileEntityInductionSmelterAt((TEInductionSmelter) te, d0, d1, d2, f);
	}
	
}
