package ua.pp.shurgent.tfctech.blocks.terrain;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import ua.pp.shurgent.tfctech.Globals;
import ua.pp.shurgent.tfctech.core.ModDetails;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.tileentities.TEModOre;

import com.bioxx.tfc.Blocks.Terrain.BlockOre;
import com.bioxx.tfc.Core.TFC_Core;

public class BlockModOre extends BlockOre {

	public String[] blockNames = Globals.ORE_METAL;

	public BlockModOre(Material mat) {
		super(mat);

	}

	@Override
	public int damageDropped(int dmg) {
		return dmg;
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		return 1;
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		if (meta >= icons.length)
			return icons[0];
		return icons[meta];
	}

	protected IIcon[] icons = new IIcon[blockNames.length];

	@Override
	public void registerBlockIcons(IIconRegister iconRegisterer) {
		for (int i = 0; i < blockNames.length; i++)
			icons[i] = iconRegisterer.registerIcon(ModDetails.ModID + ":" + "ores/" + blockNames[i] + " Ore");
	}

	@Override
	public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z) {
		if (!world.isRemote) {
			boolean dropOres = false;
			boolean hasHammer = false;
			int meta = world.getBlockMetadata(x, y, z);
			ItemStack itemstack = null;
			if (player != null) {
				TFC_Core.addPlayerExhaustion(player, 0.001f);
				player.addStat(StatList.mineBlockStatArray[getIdFromBlock(this)], 1);
				dropOres = player.canHarvestBlock(this);
				ItemStack heldItem = player.getCurrentEquippedItem();
				if (heldItem != null) {
					int[] itemIDs = OreDictionary.getOreIDs(heldItem);
					for (int id : itemIDs) {
						String name = OreDictionary.getOreName(id);
						if (name.startsWith("itemHammer")) {
							hasHammer = true;
							break;
						}
					}
				}
			}

			if (player == null || dropOres) {
				TEModOre te = (TEModOre) world.getTileEntity(x, y, z);
				int ore = getOreGrade(te, meta);
				itemstack = new ItemStack(ModItems.oreChunk, 1, damageDropped(ore));
			} else if (hasHammer)
				itemstack = new ItemStack(ModItems.smallOreChunk, 1, meta);

			if (itemstack != null)
				dropBlockAsItem(world, x, y, z, itemstack);
		}
		return world.setBlockToAir(x, y, z);
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		TEModOre te = (TEModOre) world.getTileEntity(x, y, z);
		int ore = getOreGrade(te, metadata);

		int count = quantityDropped(metadata, fortune, world.rand);
		for (int i = 0; i < count; i++) {
			ItemStack itemstack = new ItemStack(ModItems.oreChunk, 1, damageDropped(ore));
			ret.add(itemstack);
		}
		return ret;
	}

	public static Item getDroppedItem(int meta) {
		return ModItems.smallOreChunk;
	}

	@Override
	public void onBlockExploded(World world, int x, int y, int z, Explosion exp) {
		if (!world.isRemote) {
			TEModOre te = (TEModOre) world.getTileEntity(x, y, z);
			ItemStack itemstack;
			int meta = world.getBlockMetadata(x, y, z);
			int ore = getOreGrade(te, meta);

			itemstack = new ItemStack(ModItems.oreChunk, 1, ore);

			dropBlockAsItem(world, x, y, z, itemstack);
			onBlockDestroyedByExplosion(world, x, y, z, exp);
		}
	}

	public int getOreGrade(TEModOre te, int ore) {
		if (te != null) {
			int grade = te.extraData & 7;
			if (grade == 1)
				ore = 1;
			else if (grade == 2)
				ore = 2;
		}
		return ore;
	}

	@Override
	public TileEntity createTileEntity(World w, int meta) {
		return new TEModOre();
	}

}
