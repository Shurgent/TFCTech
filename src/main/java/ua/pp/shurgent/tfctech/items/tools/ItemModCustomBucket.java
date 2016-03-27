package ua.pp.shurgent.tfctech.items.tools;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import ua.pp.shurgent.tfctech.core.ModBlocks;
import ua.pp.shurgent.tfctech.core.ModDetails;
import ua.pp.shurgent.tfctech.core.ModItems;
import buildcraft.BuildCraftEnergy;

import com.bioxx.tfc.Items.ItemTerra;
import com.bioxx.tfc.api.Enums.EnumItemReach;
import com.bioxx.tfc.api.Enums.EnumSize;

import cpw.mods.fml.common.eventhandler.Event;

public class ItemModCustomBucket extends ItemTerra {
 
	private Block bucketContents;

	public ItemModCustomBucket(Block fluid) {
		super();
		this.bucketContents = fluid;
		this.setFolder("tools/");
		this.setSize(EnumSize.MEDIUM);
	}

	public ItemModCustomBucket(Block fluid, Item container) {
		this(fluid);
		this.setContainerItem(container);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		boolean isEmpty = this.bucketContents == Blocks.air;
		MovingObjectPosition mop = this.getMovingObjectPositionFromPlayer(world, player, isEmpty);

		if (mop == null) {
			return is;
		} else {
			if (mop.typeOfHit == MovingObjectType.BLOCK) {
				int x = mop.blockX;
				int y = mop.blockY;
				int z = mop.blockZ;

				if (!world.canMineBlock(player, x, y, z))
					return is;

				if (isEmpty) {
					if (!player.canPlayerEdit(x, y, z, mop.sideHit, is))
						return is;

					FillBucketEvent event = new FillBucketEvent(player, is, world, mop);
					if (MinecraftForge.EVENT_BUS.post(event) || event.isCanceled())
						return is;

					if (event.getResult() == Event.Result.ALLOW)
						return event.result;

					if (world.getBlock(x, y, z).equals(ModBlocks.latex)) {
						world.setBlockToAir(x, y, z);
						if (player.capabilities.isCreativeMode)
							return is;
						return new ItemStack(ModItems.steelBucketLatex);
					} else if (world.getBlock(x, y, z).equals(BuildCraftEnergy.blockOil)) {
						world.setBlockToAir(x, y, z);
						if (player.capabilities.isCreativeMode)
							return is;
						return new ItemStack(ModItems.steelBucketOil);
					} else if (world.getBlock(x, y, z).equals(BuildCraftEnergy.blockFuel)) {
						world.setBlockToAir(x, y, z);
						if (player.capabilities.isCreativeMode)
							return is;
						return new ItemStack(ModItems.steelBucketFuel);
					}

				} else {
					return new ItemStack(ModItems.steelBucketEmpty);
				}
			}
			return is;
		}
	}

	@Override
	public void registerIcons(IIconRegister registerer) {
		if (this.iconString != null)
			this.itemIcon = registerer.registerIcon(ModDetails.ModID + ":" + this.textureFolder + this.getIconString());
		else
			this.itemIcon = registerer.registerIcon(ModDetails.ModID + ":" + this.textureFolder + this.getUnlocalizedName().replace("item.", ""));
	}

	@Override
	public boolean canStack() {
		return false;
	}

	@Override
	public EnumItemReach getReach(ItemStack is) {
		return EnumItemReach.SHORT;
	}
}
