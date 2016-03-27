package ua.pp.shurgent.tfctech.blocks.devices;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import ua.pp.shurgent.tfctech.blocks.flora.BlockModHeveaNatural;
import ua.pp.shurgent.tfctech.core.ModBlocks;
import ua.pp.shurgent.tfctech.core.ModDetails;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.core.ModOptions;
import ua.pp.shurgent.tfctech.items.ItemMount;
import ua.pp.shurgent.tfctech.items.pottery.ItemModPotteryLatexBowl;
import ua.pp.shurgent.tfctech.tileentities.TELatexExtractor;

import com.bioxx.tfc.Blocks.BlockTerraContainer;
import com.bioxx.tfc.Items.Tools.ItemKnife;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLatexExtractor extends BlockTerraContainer {

	public BlockLatexExtractor() {
		super(Material.wood);
		this.setCreativeTab(null);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) {
		ItemStack is = entityplayer.getCurrentEquippedItem();

		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TELatexExtractor) {
			TELatexExtractor le = (TELatexExtractor) te;

			if (is == null && le.isBowlInstalled()) {
				le.grabBowl(entityplayer);
				return true;
			}

			if (is != null && is.getItem() instanceof ItemMount && !le.isMountInstalled() && is.stackSize > 0) {
				le.setMount(is);
				return true;
			}

			if (is != null && is.getItem() instanceof ItemModPotteryLatexBowl && !le.isBowlInstalled() && le.isMountInstalled() && is.stackSize > 0) {
				le.setBowl(is);
				return true;
			}

			if (is != null && is.getItem() instanceof ItemKnife && !le.isFlowing() && is.stackSize > 0) {
				le.scratchTrunk(entityplayer, is);
				return true;
			}

		}

		return false;
	}

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		return null;
	}

	@Override
	public boolean canBeReplacedByLeaves(IBlockAccess w, int x, int y, int z) {
		return false;
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
	public int getRenderType() {
		return ModBlocks.latexExtractorRenderId;
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegisterer) {
		String texPath = ModDetails.ModID + ":" + "devices/Latex Extractor";
		this.blockIcon = iconRegisterer.registerIcon(texPath);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess access, int x, int y, int z, int side) {
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int var2) {
		return new TELatexExtractor();
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess access, int x, int y, int z) {
		int dir = access.getBlockMetadata(x, y, z);
		if (dir == 0)
			this.setBlockBounds(0.0F, 0F, 0.95F, 1F, 1F, 1F);
		else if (dir == 1)
			this.setBlockBounds(0.0F, 0F, 0.0F, 0.05F, 1F, 1F);
		else if (dir == 2)
			this.setBlockBounds(0.0F, 0F, 0.00F, 1F, 1F, 0.05F);
		else if (dir == 3)
			this.setBlockBounds(0.95F, 0F, 0.0F, 1F, 1F, 1F);
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		int dir = world.getBlockMetadata(x, y, z);
		if (dir == 0)
			return AxisAlignedBB.getBoundingBox(x + 0.0F, y + 0F, z + 0.95F, x + 1F, y + 1F, z + 1F);
		else if (dir == 1)
			return AxisAlignedBB.getBoundingBox(x + 0.0F, y + 0F, z + 0.0F, x + 0.05F, y + 1F, z + 1F);
		else if (dir == 2)
			return AxisAlignedBB.getBoundingBox(x + 0.0F, y + 0F, z + 0.00F, x + 1F, y + 1F, z + 0.05F);
		else if (dir == 3)
			return AxisAlignedBB.getBoundingBox(x + 0.95F, y + 0F, z + 0.0F, x + 1F, y + 1F, z + 1F);

		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1, z + 1);
	}

	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB bb, @SuppressWarnings("rawtypes") List list, Entity entity) {
		this.setBlockBoundsBasedOnState(world, x, y, z);
		super.addCollisionBoxesToList(world, x, y, z, bb, list, entity);
	}
	
	@Override
	public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z) {
		if (!world.isRemote) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te instanceof TELatexExtractor) {
				TELatexExtractor le = (TELatexExtractor) te;
				spawnDrops(le, world, x, y, z);
			}
		}
		return world.setBlockToAir(x, y, z);
	}

	private void spawnDrops(TELatexExtractor te, World world, int x, int y, int z) {
		if (!world.isRemote) {
			EntityItem groove = new EntityItem(world, x, y, z, new ItemStack(ModItems.groove, 1));
			spawnEntityItem(world, groove, x, y, z);

			if (te.isMountInstalled()) {
				EntityItem mount = new EntityItem(world, x, y, z, new ItemStack(ModItems.mount, 1));
				spawnEntityItem(world, mount, x, y, z);
			}

			if (te.isBowlInstalled()) {
				ItemStack bowl = new ItemStack(ModItems.latexBowl, 1);
				int dmg = ((ItemModPotteryLatexBowl) bowl.getItem()).getDamageFromUnits(te.getLatexAmount());
				bowl.setItemDamage(dmg);
				EntityItem bowlent = new EntityItem(world, x, y, z, bowl);
				spawnEntityItem(world, bowlent, x, y, z);
			}
		}
	}

	private void spawnEntityItem(World world, EntityItem e, int x, int y, int z) {
		if (!world.isRemote) {
			float plusX = world.rand.nextFloat() * 0.8F + 0.1F;
			float plusY = world.rand.nextFloat() * 0.8F + 0.1F;
			float plusZ = world.rand.nextFloat() * 0.8F + 0.1F;

			e.setPosition(x + plusX, y + plusY, z + plusZ);

			float force = 0.03F;
			e.motionX = (float) world.rand.nextGaussian() * force;
			e.motionY = (float) world.rand.nextGaussian() * force + 0.2F;
			e.motionZ = (float) world.rand.nextGaussian() * force;

			world.spawnEntityInWorld(e);
		}
	}

	@Override
	public void harvestBlock(World world, EntityPlayer entityplayer, int x, int y, int z, int meta) {
		// don't drop here, we dropped in removedByPlayer instead
	}

	// this method should end up being used when the block is dropped by an explosion
	// note that the block can still sometimes be destroyed and this won't be called
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {

		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TELatexExtractor) {

			TELatexExtractor le = (TELatexExtractor) te;
			ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
			ret.add(new ItemStack(ModItems.groove, 1));

			if (le.isMountInstalled())
				ret.add(new ItemStack(ModItems.mount, 1));

			if (le.isBowlInstalled()) {
				ItemStack bowl = new ItemStack(ModItems.latexBowl, 1);
				int dmg = ((ItemModPotteryLatexBowl) bowl.getItem()).getDamageFromUnits(le.getLatexAmount());
				bowl.setItemDamage(dmg);
				ret.add(bowl);
			}

			return ret;
		}

		return null;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		int dir = world.getBlockMetadata(x, y, z);

		if (dir == 0) {
			if (!world.getBlock(x, y, z + 1).isSideSolid(world, x, y, z + 1, ForgeDirection.NORTH))
				removedByPlayer(world, null, x, y, z);
		} else if (dir == 1) {
			if (!world.getBlock(x - 1, y, z).isSideSolid(world, x - 1, y, z, ForgeDirection.EAST))
				removedByPlayer(world, null, x, y, z);
		} else if (dir == 2) {
			if (!world.getBlock(x, y, z - 1).isSideSolid(world, x, y, z - 1, ForgeDirection.SOUTH))
				removedByPlayer(world, null, x, y, z);
		} else if (dir == 3) {
			if (!world.getBlock(x + 1, y, z).isSideSolid(world, x + 1, y, z, ForgeDirection.WEST))
				removedByPlayer(world, null, x, y, z);
		}
	}

	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
		if (side == 4)
			return 3;
		if (side == 5)
			return 1;
		if (side == 2)
			return 0;
		if (side == 3)
			return 2;
		return 5;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te instanceof TELatexExtractor) {
			TELatexExtractor le = (TELatexExtractor) te;

			if (le != null) {
				world.markBlockForUpdate(x, y, z);
				le.rotation = (byte) world.getBlockMetadata(x, y, z);
			}
		}
	}

	@Override
	public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side) {
		if (this.canPlaceBlockAt(world, x, y, z)) {
			
			ChunkCoordinates pos = getTrunkBlockPosBySide(world, x, y, z, side);
			if (pos != null && world.getBlock(pos.posX, pos.posY, pos.posZ) instanceof BlockModHeveaNatural && !isExtractorPresent(world, pos.posX, pos.posY, pos.posZ))
				return true;
			
		}
		return false;
	}

	public boolean isTreeDead(World world, int x, int y, int z, int rotation) {
		ChunkCoordinates pos = getTrunkBlockPosByRotation(world, x, y, z, rotation);
		if (pos == null || !ModOptions.cfgHeveaDamage || !(world.getBlock(pos.posX, pos.posY, pos.posZ) instanceof BlockModHeveaNatural))
			return false;
		
		return world.getBlock(pos.posX, pos.posY, pos.posZ) == ModBlocks.logHeveaNaturalDead;
	}
	
	private boolean isExtractorPresent(World world, int x, int y, int z) {

		int scanY = y;
		while (world.getBlock(x, scanY, z) instanceof BlockModHeveaNatural)
			scanY--;

		scanY++;

		while (world.getBlock(x, scanY, z) instanceof BlockModHeveaNatural) {
			if (world.getBlock(x - 1, scanY, z) == ModBlocks.latexExtractor || world.getBlock(x + 1, scanY, z) == ModBlocks.latexExtractor
					|| world.getBlock(x, scanY, z + 1) == ModBlocks.latexExtractor || world.getBlock(x, scanY, z - 1) == ModBlocks.latexExtractor)
				return true;
			scanY++;
		}

		return false;
	}

	public ChunkCoordinates getTrunkBlockPosBySide(World world, int x, int y, int z, int side) {
		ChunkCoordinates ret = new ChunkCoordinates(x, y, z);
		
		switch (side) {
		case 5:
			ret.set(x - 1, y, z);
			return ret;
		case 4:
			ret.set(x + 1, y, z);
			return ret;
		case 2:
			ret.set(x, y, z + 1);
			return ret;
		case 3:
			ret.set(x, y, z - 1);
			return ret;
		}
		
		return null;
	}
	
	public ChunkCoordinates getTrunkBlockPosByRotation(World world, int x, int y, int z, int rotation) {
		ChunkCoordinates ret = new ChunkCoordinates(x, y, z);
		
		switch (rotation) {
		case 1:
			ret.set(x - 1, y, z);
			return ret;
		case 3:
			ret.set(x + 1, y, z);
			return ret;
		case 0:
			ret.set(x, y, z + 1);
			return ret;
		case 2:
			ret.set(x, y, z - 1);
			return ret;
		}
		
		return null;
	}
}
