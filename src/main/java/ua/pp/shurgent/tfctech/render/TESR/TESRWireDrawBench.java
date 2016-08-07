package ua.pp.shurgent.tfctech.render.TESR;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import ua.pp.shurgent.tfctech.render.models.ModelWireDrawBench;
import ua.pp.shurgent.tfctech.tileentities.TEWireDrawBench;

import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.Render.TESR.TESRBase;

public class TESRWireDrawBench extends TESRBase {
	
	public void renderTileEntityWireDrawBenchAt(TEWireDrawBench te, double d, double d1, double d2, float f) {
		
		if (te.getWorldObj() != null) {
			
			if (te.getModel() == null) {
				te.setModel(new ModelWireDrawBench());
			}
			
			GL11.glPushMatrix(); // start
			GL11.glTranslatef((float) d + 0.0F, (float) d1 + 0.0F, (float) d2 + 0.0F); // size
			
			TFC_Core.bindTexture(te.getResource()); // texture
			
			ModelWireDrawBench model = te.getModel();
			
			model.rotation = te.rotation;
			model.isHeadBlock = te.isHeadBlock;
			
			model.isDrawplateInstalled = te.getDrawplate() != null;
			model.isWireInstalled = te.getInput() != null || te.getOutput() != null;
			model.setDrawplateMetal(te.drawplateMetal);
			
			model.progress = model.isWireInstalled && !te.isFinished() ? te.progress : 100;
			
			model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			
			GL11.glPopMatrix(); // end
		}
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f) {
		this.renderTileEntityWireDrawBenchAt((TEWireDrawBench) tileentity, d0, d1, d2, f);
	}
	
}
