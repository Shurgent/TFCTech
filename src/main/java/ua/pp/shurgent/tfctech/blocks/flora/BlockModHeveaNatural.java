package ua.pp.shurgent.tfctech.blocks.flora;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import ua.pp.shurgent.tfctech.Globals;
import ua.pp.shurgent.tfctech.core.ModDetails;
import ua.pp.shurgent.tfctech.core.ModItems;

import com.bioxx.tfc.Blocks.Flora.BlockLogNatural;
import com.bioxx.tfc.api.TFCItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModHeveaNatural extends BlockLogNatural {

	private int searchDist = 10;
	private static int damage;
	private static int logs;
	private boolean isStone;
	private int treeDamage = 0;

	public BlockModHeveaNatural(int dmg) {
		this.treeDamage = dmg;
		this.woodNames = new String[1];
		System.arraycopy(Globals.WOOD_ALL, 0, woodNames, 0, 1);
		this.sideIcons = new IIcon[5];
		this.innerIcons = new IIcon[5];
		this.rotatedSideIcons = new IIcon[5];
	}

	public void setTreeDamage(int dmg) {
		this.treeDamage = dmg;
	}
	
	public int getTreeDamage() {
		return this.treeDamage;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if (side == 0 || side == 1)
			return innerIcons[treeDamage];
		return sideIcons[treeDamage];
	}

	@Override
	public void registerBlockIcons(IIconRegister reg) {
		for (int i = 0; i < 5; i++) {
			sideIcons[i] = reg.registerIcon(ModDetails.ModID + ":" + "wood/trees/Hevea Log " + i);
			innerIcons[i] = reg.registerIcon(ModDetails.ModID + ":" + "wood/trees/Hevea Log Top " + i);
			rotatedSideIcons[i] = reg.registerIcon(ModDetails.ModID + ":" + "wood/trees/Hevea Log Side " + i);
		}
	}

	@Override
	public Item getItemDropped(int i, Random random, int j) {
		return ModItems.logHevea;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		boolean check = false;
		for (int h = -2; h <= 2; h++) {
			for (int g = -2; g <= 2; g++) {
				for (int f = -2; f <= 2; f++) {
					if (world.getBlock(x + h, y + g, z + f) == this)
						check = true;
				}
			}
		}
		if (!check) {
			world.setBlockToAir(x, y, z);
			dropBlockAsItem(world, x, y, z, new ItemStack(ModItems.logHevea, 1, 0));
		}
	}

	private boolean checkOut(World world, int x, int y, int z) {
		return world.getBlock(x, y, z) == this;
	}

	@Override
	public void harvestBlock(World world, EntityPlayer entityplayer, int x, int y, int z, int meta) {
		// we need to make sure the player has the correct tool out
		boolean isAxe = false;
		boolean isHammer = false;
		ItemStack equip = entityplayer.getCurrentEquippedItem();
		if (!world.isRemote) {
			if (equip != null) {
				int[] equipIDs = OreDictionary.getOreIDs(equip);
				for (int id : equipIDs) {
					String name = OreDictionary.getOreName(id);
					if (name.startsWith("itemAxe")) {
						isAxe = true;
						if (name.startsWith("itemAxeStone")) {
							isStone = true;
							break;
						}
					} else if (name.startsWith("itemHammer")) {
						isHammer = true;
						break;
					}
				}

				if (isAxe) {
					damage = -1;
					processTree(world, x, y, z, meta, equip);

					if (damage + equip.getItemDamage() > equip.getMaxDamage()) {
						int ind = entityplayer.inventory.currentItem;
						entityplayer.inventory.setInventorySlotContents(ind, null);
						world.setBlock(x, y, z, this, meta, 0x2);
					} else
						equip.damageItem(damage, entityplayer);

					int smallStack = logs % 16;
					dropBlockAsItem(world, x, y, z, new ItemStack(ModItems.logHevea, smallStack, 0));
					logs -= smallStack;

					// In theory this section should never be triggered since the full stacks are dropped higher up the tree, but keeping it here just in case.
					while (logs > 0) {
						dropBlockAsItem(world, x, y, z, new ItemStack(ModItems.logHevea, 16, 0));
						logs -= 16;
					}

				} else if (isHammer) {
					EntityItem item = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(TFCItems.stick, 1 + world.rand.nextInt(3)));
					world.spawnEntityInWorld(item);
				}
			} else
				world.setBlock(x, y, z, this, meta, 0x2);
		}
	}

	@Override
	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion ex) {
		processTree(world, x, y, z, world.getBlockMetadata(x, y, z), null);
	}

	@Deprecated
	private void processTree(World world, int x, int y, int z, int meta, ItemStack is) {
		boolean[][][] checkArray = new boolean[searchDist * 2 + 1][256][searchDist * 2 + 1];
		scanLogs(world, x, y, z, checkArray, (byte) 0, (byte) 0, (byte) 0, is);
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int side, EntityPlayer entityplayer) {
		int meta = world.getBlockMetadata(x, y, z);
		harvestBlock(world, entityplayer, x, y, z, meta);
	}

	private void scanLogs(World world, int i, int j, int k, boolean[][][] checkArray, byte x, byte y, byte z, ItemStack stack) {
		if (y >= 0 && j + y < 256) {
			int offsetX = 0;
			int offsetY = 0;
			int offsetZ = 0;
			checkArray[x + searchDist][y][z + searchDist] = true;

			for (offsetX = -3; offsetX <= 3; offsetX++) {
				for (offsetZ = -3; offsetZ <= 3; offsetZ++) {
					for (offsetY = 0; offsetY <= 2; offsetY++) {
						if (Math.abs(x + offsetX) <= searchDist && j + y + offsetY < 256 && Math.abs(z + offsetZ) <= searchDist) {
							if (checkOut(world, i + x + offsetX, j + y + offsetY, k + z + offsetZ) && !(offsetX == 0 && offsetY == 0 && offsetZ == 0)
									&& !checkArray[x + offsetX + searchDist][y + offsetY][z + offsetZ + searchDist])
								scanLogs(world, i, j, k, checkArray, (byte) (x + offsetX), (byte) (y + offsetY), (byte) (z + offsetZ), stack);
						}
					}
				}
			}

			damage++;
			if (stack != null) {
				if (damage + stack.getItemDamage() <= stack.getMaxDamage()) {
					world.setBlock(i + x, j + y, k + z, Blocks.air, 0, 0x2);
					if (!isStone || world.rand.nextInt(10) != 0)
						logs++;
					if (logs >= 16) {
						dropBlockAsItem(world, i + x, j + y, k + z, new ItemStack(ModItems.logHevea, 16, 0));
						logs -= 16;
					}
					notifyLeaves(world, i + x, j + y, k + z);
				}
			} else {
				world.setBlockToAir(i, j, k);
				logs++;
				if (logs >= 16) {
					dropBlockAsItem(world, i, j, k, new ItemStack(ModItems.logHevea, 16, 0));
					logs -= 16;
				}
				notifyLeaves(world, i + x, j + y, k + z);
			}
		}
	}

	private void notifyLeaves(World world, int x, int y, int z) {
		world.notifyBlockOfNeighborChange(x + 1, y, z, Blocks.air);
		world.notifyBlockOfNeighborChange(x - 1, y, z, Blocks.air);
		world.notifyBlockOfNeighborChange(x, y, z + 1, Blocks.air);
		world.notifyBlockOfNeighborChange(x, y, z - 1, Blocks.air);
		world.notifyBlockOfNeighborChange(x, y + 1, z, Blocks.air);
		world.notifyBlockOfNeighborChange(x, y - 1, z, Blocks.air);
	}
}
