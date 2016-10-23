package ua.pp.shurgent.tfctech.blocks.devices;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.api.Helper;
import ua.pp.shurgent.tfctech.api.Sides;
import ua.pp.shurgent.tfctech.core.ModBlocks;
import ua.pp.shurgent.tfctech.core.ModDetails;
import ua.pp.shurgent.tfctech.tileentities.TEInductionSmelter;

import com.bioxx.tfc.Blocks.BlockTerraContainer;
import com.bioxx.tfc.Core.Metal.MetalPair;
import com.bioxx.tfc.api.TFCBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockInductionSmelter extends BlockTerraContainer {
	
	public BlockInductionSmelter() {
		super(Material.iron);
		this.setCreativeTab(TFCTech.TFCTECH);
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.875f, 1.0f);
		this.setTickRandomly(true);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister registerer) {
		this.blockIcon = registerer.registerIcon(ModDetails.ModID + ":" + "devices/" + getUnlocalizedName().substring(5));
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		return TFCBlocks.crucible.getIcon(2, 0); // Crucible side texture for block destroy particles
	}
	
	@Override
	public String getItemIconName() {
		return this.blockIcon.getIconName();
	}
	
	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		
		int meta = world.getBlockMetadata(x, y, z);
		if (meta < 8)
			return 0;
		return 10;
		
	}
	
	@Override
	public int tickRate(World world) {
		return 20;
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		super.updateTick(world, x, y, z, rand);
		TEInductionSmelter te = (TEInductionSmelter) world.getTileEntity(x, y, z);
		if (te != null) {
			int meta = world.getBlockMetadata(x, y, z);
			if (meta < 8 && te.isMetalLiquid()) {
				world.setBlockMetadataWithNotify(x, y, z, meta + 8, 3);
			} else if (meta >= 8 && !te.isMetalLiquid()) {
				world.setBlockMetadataWithNotify(x, y, z, meta - 8, 3);
			}
		}
	}
	
	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta < 8)
			return;
		
		double pX;
		double pY = (double) y + 0.75D;
		double pZ;
		
		if (rand.nextInt(5) == 0) {
			pX = (double) x + 0.1875D + rand.nextDouble() * 0.625D;
			pZ = (double) z + 0.1875D + rand.nextDouble() * 0.625D;
			
			world.spawnParticle("lava", pX, pY, pZ, 0.0D, 6.0D + rand.nextDouble() * 6.0D, 0.0D);
		}
		
		pX = (double) x + 0.1875D + rand.nextDouble() * 0.625D;
		pZ = (double) z + 0.1875D + rand.nextDouble() * 0.625D;
		world.spawnParticle("smoke", pX, pY, pZ, 0.0D, 0.0D, 0.0D);
		
	}
	
	@Override
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
		if (!world.isRemote && (TEInductionSmelter) world.getTileEntity(i, j, k) != null) {
			entityplayer.openGui(TFCTech.instance, 0, world, i, j, k);
		}
		return true;
	}
	
	@Override
	public void breakBlock(World world, int i, int j, int k, Block block, int par6) {
		if (world.getTileEntity(i, j, k) instanceof TEInductionSmelter) {
			TEInductionSmelter te = (TEInductionSmelter) world.getTileEntity(i, j, k);
			
			ItemStack is = new ItemStack(Item.getItemFromBlock(block), 1);
			NBTTagCompound nbt = writeSmelterToNBT(te);
			is.setTagCompound(nbt);
			EntityItem ei = new EntityItem(world, i, j, k, is);
			world.spawnEntityInWorld(ei);
			
			for (int s = 0; s < te.getSizeInventory(); ++s) {
				te.setInventorySlotContents(s, null);
			}
		}
		super.breakBlock(world, i, j, k, block, par6);
	}
	
	@Override
	protected void dropBlockAsItem(World world, int x, int y, int z, ItemStack is) {
	}
	
	public NBTTagCompound writeSmelterToNBT(TEInductionSmelter te) {
		NBTTagCompound nbt = new NBTTagCompound();
		
		nbt.setInteger("temp", te.temperature);
		nbt.setInteger("minTemp", te.minTemp);
		nbt.setInteger("maxTemp", te.maxTemp);
		te.getEnergyStorage().writeToNBT(nbt);
		
		NBTTagList nbttaglist = new NBTTagList();
		Iterator<MetalPair> iter = te.metals.values().iterator();
		while (iter.hasNext()) {
			MetalPair m = (MetalPair) iter.next();
			if (m != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setInteger("ID", Item.getIdFromItem(m.type.ingot));
				nbttagcompound1.setFloat("AmountF", m.amount);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbt.setTag("Metals", nbttaglist);
		
		nbttaglist = new NBTTagList();
		for (int i = 0; i < te.storage.length; i++) {
			if (te.storage[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				te.storage[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		
		nbt.setTag("Items", nbttaglist);
		
		return nbt;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase player, ItemStack is) {
		super.onBlockPlacedBy(world, i, j, k, player, is);
		
		int l = MathHelper.floor_double(player.rotationYaw * 4F / 360F + 0.5D) & 3;
		world.setBlockMetadataWithNotify(i, j, k, l, 0x2);
		
		TEInductionSmelter te = (TEInductionSmelter) world.getTileEntity(i, j, k);
		if (te != null)
			te.rotation = (byte) l;
		
		if (te != null && is.hasTagCompound()) {
			te.readFromItemNBT(is.getTagCompound());
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess par1iBlockAccess, int par2, int par3, int par4, int par5) {
		return true;
	}
	
	@Override
	public int getRenderType() {
		return ModBlocks.inductionSmelterRenderId;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TEInductionSmelter();
	}
	
	@Override
	public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
		if (side == ForgeDirection.DOWN) // Down side solid
			return true;
		
		if (Helper.rotatedSide(world.getBlockMetadata(x, y, z), Sides.BACK).equals(side)) // Back side solid
			return true;
		
		return false;
	}
}
