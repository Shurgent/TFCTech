package ua.pp.shurgent.tfctech.blocks.devices;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.core.ModDetails;
import ua.pp.shurgent.tfctech.tileentities.TEModuleBase;

import com.bioxx.tfc.Blocks.BlockTerraContainer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModuleBase extends BlockTerraContainer {
	
	public BlockModuleBase() {
		super(Material.iron);
		this.setCreativeTab(TFCTech.TFCTECH);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister registerer) {
		this.blockIcon = registerer.registerIcon(ModDetails.ModID + ":" + "devices/" + getUnlocalizedName().substring(5));
	}
	
	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase player, ItemStack is) {
		super.onBlockPlacedBy(world, i, j, k, player, is);
		
		int l = MathHelper.floor_double(player.rotationYaw * 4F / 360F + 0.5D) & 3;
		world.setBlockMetadataWithNotify(i, j, k, l, 0x2);
		
		TEModuleBase te = (TEModuleBase) world.getTileEntity(i, j, k);
		if (te != null)
			te.rotation = (byte) l;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
		return true;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
}
