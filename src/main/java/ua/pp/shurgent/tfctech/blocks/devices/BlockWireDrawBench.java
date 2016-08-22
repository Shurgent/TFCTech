package ua.pp.shurgent.tfctech.blocks.devices;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ua.pp.shurgent.tfctech.api.crafting.WireDrawBenchManager;
import ua.pp.shurgent.tfctech.core.ModBlocks;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.tileentities.TEWireDrawBench;

import com.bioxx.tfc.Blocks.BlockTerraContainer;
import com.bioxx.tfc.api.TFCBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWireDrawBench extends BlockTerraContainer {
	
	public static final int BLOCKMAP[][] = {
			{
					0,
					1
			},
			{
					-1,
					0
			},
			{
					0,
					-1
			},
			{
					1,
					0
			}
	};
	
	public BlockWireDrawBench() {
		super(Material.wood);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float sideX, float sideY, float sideZ) {
		
		if (world.isRemote) {
			world.markBlockForUpdate(x, y, z);
			return true;
		} else {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te instanceof TEWireDrawBench) {
				
				TEWireDrawBench tewd = (TEWireDrawBench) te;
				boolean footBlock = false;
				if (!tewd.isHeadBlock) {
					tewd = tewd.getMainTileEntity();
					footBlock = true;
				}
				
				if (!tewd.isFinished()) {
					
					if (!tewd.canDraw() && footBlock) {
						if (player.isSneaking() && tewd.getDrawplate() != null) {
							ItemStack is = tewd.takeDrawplate();
							if (is != null) {
								EntityItem entityitem;
								entityitem = new EntityItem(world, player.posX, player.posY, player.posZ, is);
								world.spawnEntityInWorld(entityitem);
							}
						} else {
							tewd.putDrawplate(player.getCurrentEquippedItem());
							tewd.putWire(player.getCurrentEquippedItem());
						}
					} else if (player.isSneaking() && !footBlock && !tewd.isWorking() && tewd.recipe != null) {
						if (tewd.progress < 100) {
							tewd.setIsDrawing(true);
							tewd.setWorking();
						}
					}
					
				} else if (!player.isSneaking() && !footBlock) {
					
					ItemStack is = tewd.takeOutput();
					if (is != null) {
						EntityItem entityitem;
						entityitem = new EntityItem(world, player.posX, player.posY, player.posZ, is);
						world.spawnEntityInWorld(entityitem);
					}
					
				}
				
			}
			if (player.isSneaking()) {
				return true;
			}
		}
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
		return true;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	public static int getDirectionFromMetadata(int i) {
		return i & 3;
	}
	
	public static boolean isDrawingBlock(int i) {
		return (i & 8) != 0;
	}
	
	public String getItemNameIS(ItemStack itemstack) {
		return "WireDrawBench";
	}
	
	@Override
	public int getRenderType() {
		return ModBlocks.wireDrawBenchRenderId;
	}
	
	@Override
	public Item getItemDropped(int i, Random random, int j) {
		if (!isDrawingBlock(i))
			return ModItems.wireDrawBench;
		else
			return null;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack is) {
		int dir = MathHelper.floor_double(entityliving.rotationYaw * 4F / 360F + 0.5D) & 3;
		int[] offset = BLOCKMAP[dir];
		
		world.setBlockMetadataWithNotify(x, y, z, dir, 3);
		
		if (world.getBlock(x, y, z) == this) {
			world.setBlock(x + offset[0], y, z + offset[1], this, dir + 8, 3);
			
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TEWireDrawBench) {
				TEWireDrawBench tewd = (TEWireDrawBench) te;
				tewd.rotation = (byte) dir;
			}
			
			te = world.getTileEntity(x + offset[0], y, z + offset[1]);
			if (te != null && te instanceof TEWireDrawBench) {
				TEWireDrawBench tewd = (TEWireDrawBench) te;
				tewd.rotation = (byte) dir;
				tewd.isHeadBlock = false;
			}
		}
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess ba, int x, int y, int z) {
		int meta = ba.getBlockMetadata(x, y, z);
		if (BlockWireDrawBench.isDrawingBlock(meta))
			setBlockBounds(0.05f, 0, 0.05f, 0.95f, 0.6f, 0.95f);
		else
			setBlockBounds(0.05f, 0, 0.05f, 0.95f, 0.8f, 0.95f);
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		if (BlockWireDrawBench.isDrawingBlock(meta))
			return AxisAlignedBB.getBoundingBox(x + 0.05f, y, z + 0.05f, x + 0.95f, y + 0.6f, z + 0.95f);
		return AxisAlignedBB.getBoundingBox(x + 0.05f, y, z + 0.05f, x + 0.95f, y + 0.8f, z + 0.95f);
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		int dir = getDirectionFromMetadata(world.getBlockMetadata(x, y, z));
		int[] offset = BLOCKMAP[dir];
		
		boolean stay = canPlace(world, x, y, z) && canPlace(world, x + offset[0], y, z + offset[1]);
		
		return stay;
	}
	
	public boolean canPlace(World world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		boolean stay = canStay(world, x, y, z) && (world.isAirBlock(x, y, z) || block.getMaterial().isReplaceable());
		return stay;
	}
	
	public boolean canStay(World world, int x, int y, int z) {
		return world.getBlock(x, y - 1, z).isNormalCube();
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		int meta = world.getBlockMetadata(x, y, z);
		int dir = getDirectionFromMetadata(meta);
		
		if (isDrawingBlock(meta)) {
			if (world.getBlock(x - BLOCKMAP[dir][0], y, z - BLOCKMAP[dir][1]) != this || !canStay(world, x, y, z))
				world.setBlockToAir(x, y, z);
		} else if (world.getBlock(x + BLOCKMAP[dir][0], y, z + BLOCKMAP[dir][1]) != this || !canStay(world, x, y, z)) {
			world.setBlockToAir(x, y, z);
			if (!world.isRemote)
				dropBlockAsItem(world, x, y, z, meta, 0);
		}
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TEWireDrawBench();
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegisterer) {
		WireDrawBenchManager.getInstance().registerIcons(iconRegisterer);
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		return new ItemStack(ModItems.wireDrawBench);
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		return TFCBlocks.planks.getIcon(side, 11); // Sycamore texture for block destroy particles
	}
	
}
