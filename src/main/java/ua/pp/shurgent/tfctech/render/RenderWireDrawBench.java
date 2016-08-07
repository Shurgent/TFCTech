package ua.pp.shurgent.tfctech.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import ua.pp.shurgent.tfctech.api.crafting.WireDrawBenchManager;
import ua.pp.shurgent.tfctech.api.interfaces.IDrawable;
import ua.pp.shurgent.tfctech.tileentities.TEWireDrawBench;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderWireDrawBench implements ISimpleBlockRenderingHandler {
	
	private static final float P = 0.0625f; 
	private static final float MIN_X = 9 * P;
	private static final float MAX_X = 10 * P;
	private static final float MIN_Y = 8 * P;
	private static final float MAX_Y = 9 * P;
	private static final float MIN_Z = 23 * P;
	private static final float MAX_Z = 31 * P;
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te == null || !(te instanceof TEWireDrawBench))
			return false;
		
		TEWireDrawBench tewd = (TEWireDrawBench) world.getTileEntity(x, y, z);
		if (tewd == null || !tewd.isHeadBlock)
			return false;
		
		tewd = tewd.getMainTileEntity();
		
		renderer.renderAllFaces = true;
		GL11.glPushMatrix();
		
		if (tewd.recipe != null) {
			
			Item wire = tewd.recipe.getInItem().getItem();
			String metal = ((IDrawable) wire).getWireMetalName();
			IIcon ico = WireDrawBenchManager.getInstance().getWireIcon(metal);
			
			byte progr = tewd.progress;
			float offZ;
			float offY = 0F;
			
			if (progr > 99 || tewd.isFinished()) {
				offZ = 8F * P;
				offY = 1F * P;
			}
			else {
				offZ = 7F * P * (progr / 99f);
			}
			
			setRotatedRenderBounds(renderer, tewd.rotation, MIN_X, MIN_Y - offY, MIN_Z - offZ, MAX_X, MAX_Y - offY, MAX_Z - offZ);
			renderer.setOverrideBlockTexture(ico);
			//rotate(renderer, tewd.rotation);
			//renderer.renderStandardBlockWithColorMultiplier(Blocks.iron_block, x, y, z, 255, 255, 255);
			renderer.renderStandardBlock(Blocks.iron_block, x, y, z);
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
			renderer.setRenderBounds(MAX_Z - maxZ - 1F + P, minY, minX, MAX_Z - minZ - 1F + P, maxY, maxX);
			break;
		case 2:
			renderer.setRenderBounds(1F - maxX, minY, MAX_Z - maxZ - 1F + P, 1F - minX, maxY, MAX_Z - minZ - 1F + P);
			break;
		case 3:
			renderer.setRenderBounds(minZ, minY, 1F - maxX, maxZ, maxY, 1F - minX);
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
