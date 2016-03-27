package ua.pp.shurgent.tfctech.render.TESR;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import ua.pp.shurgent.tfctech.render.models.ModelLatexExtractor;
import ua.pp.shurgent.tfctech.tileentities.TELatexExtractor;

import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.Render.TESR.TESRBase;

public class TESRLatexExtractor extends TESRBase {

	public void renderTileEntityLatexExtractorAt(TELatexExtractor te, double d, double d1, double d2, float f) {
		if (te.getWorldObj() != null) {
			if (te.getModel() == null) {
				te.setModel(new ModelLatexExtractor());
			}

			GL11.glPushMatrix(); // start
			GL11.glTranslatef((float) d + 0.0F, (float) d1 + 0.0F, (float) d2 + 0.0F); // size

			TFC_Core.bindTexture(te.getResource()); // texture

			ModelLatexExtractor model = te.getModel();
			
			model.showMount = te.isMountInstalled();
			model.showBowl = te.isBowlInstalled();
			model.showScratches = te.isTrunkScratched();
			model.showLatex = te.isFlowing();
			model.rotation = te.rotation;
			model.latexLevel = te.getLatexAmount();
			
			model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

			GL11.glPopMatrix(); // end
		}
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double d0, double d1, double d2, float f) {
		this.renderTileEntityLatexExtractorAt((TELatexExtractor) te, d0, d1, d2, f);
	}

}
