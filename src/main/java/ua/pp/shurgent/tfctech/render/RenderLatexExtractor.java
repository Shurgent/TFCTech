package ua.pp.shurgent.tfctech.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.FluidStack;

import org.lwjgl.opengl.GL11;

import ua.pp.shurgent.tfctech.core.ModBlocks;
import ua.pp.shurgent.tfctech.core.ModFluids;
import ua.pp.shurgent.tfctech.tileentities.TELatexExtractor;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderLatexExtractor implements ISimpleBlockRenderingHandler {

	private static final float MIN_X = 0F;
	private static final float MAX_X = 1F;
	private static final float MIN_Y = 0F;
	@SuppressWarnings("unused")
	private static final float MAX_Y = 1F;
	private static final float MIN_Z = 0F;
	private static final float MAX_Z = 1F;

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		TELatexExtractor te = (TELatexExtractor) world.getTileEntity(x, y, z);
		Block latexBlock = ModBlocks.latex;
		float p = 0.0625f;
		
		renderer.renderAllFaces = true;
		GL11.glPushMatrix();

		if (te.getLatexAmount() > 0 && te.isBowlInstalled()) {
			FluidStack fs = new FluidStack(ModFluids.LATEX, te.getLatexAmount());

			int color = fs.getFluid().getColor(fs);
			float f = (color >> 16 & 255) / 255.0F;
			float f1 = (color >> 8 & 255) / 255.0F;
			float f2 = (color & 255) / 255.0F;
			float h = 4*p * (fs.amount / 200f);
			
			IIcon still = fs.getFluid().getStillIcon();
			
			setRotatedRenderBounds(renderer, te.rotation, MIN_X+5*p, MIN_Y+p, MIN_Z+7*p, MAX_X-5*p, MIN_Y+p+h, MAX_Z-3*p);
			renderer.setOverrideBlockTexture(still);
			renderer.renderStandardBlockWithColorMultiplier(latexBlock, x, y, z, f, f1, f2);
			renderer.clearOverrideBlockTexture();
			
		}
		
		rotate(renderer, 0);
		renderer.renderAllFaces = false;
		GL11.glPopMatrix();
		
		return true;
	}

	private void rotate(RenderBlocks renderer, int i) {
		renderer.uvRotateEast = i;
		renderer.uvRotateWest = i;
		renderer.uvRotateNorth = i;
		renderer.uvRotateSouth = i;
	}

	private void setRotatedRenderBounds(RenderBlocks renderer, byte rotation, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
		switch (rotation) {
		case 0:
			renderer.setRenderBounds(minX, minY, minZ, maxX, maxY, maxZ);
			break;
		case 1:
			renderer.setRenderBounds(MAX_Z - maxZ, minY, minX, MAX_Z - minZ, maxY, maxX);
			break;
		case 2:
			renderer.setRenderBounds(minX, minY, MAX_Z - maxZ, maxX, maxY, MAX_Z - minZ);
			break;
		case 3:
			renderer.setRenderBounds(minZ, minY, minX, maxZ, maxY, maxX);
			break;
		default:
			break;
		}
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return 0;
	}

}
