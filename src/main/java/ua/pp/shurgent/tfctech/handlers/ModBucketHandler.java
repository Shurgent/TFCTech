package ua.pp.shurgent.tfctech.handlers;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.blocks.liquids.BlockLatex;
import ua.pp.shurgent.tfctech.core.ModItems;
import buildcraft.core.lib.block.BlockBuildCraftFluid;

import com.bioxx.tfc.Items.Tools.ItemCustomBucket;
import com.bioxx.tfc.Items.Tools.ItemSteelBucket;
import com.bioxx.tfc.api.TFCItems;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ModBucketHandler {

	public static ModBucketHandler INSTANCE = new ModBucketHandler();
	public Map<Block, Item> buckets = new HashMap<Block, Item>();

	private ModBucketHandler() {
	}

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onBucketFill(FillBucketEvent event) {

		if (!isValidBucket(event.current.getItem())) {
			return;
		}

		World world = event.world;
		int blockX = event.target.blockX;
		int blockY = event.target.blockY;
		int blockZ = event.target.blockZ;
		Block block = world.getBlock(blockX, blockY, blockZ);
		int blockMeta = world.getBlockMetadata(blockX, blockY, blockZ);

		if (isTFCEmptyBucket(event.current.getItem())) {
			if (isBlockModFluid(block)) {
				event.result = event.current;
				event.setResult(Result.DENY);
				event.setCanceled(true);
				return;
			}
		}

		ItemStack result = fillCustomBucket(event.world, event.target, block, blockMeta, event.current);

		if (result == null) {
			return;
		}

		event.result = result;
		event.setResult(Result.ALLOW);
	}

	private ItemStack fillCustomBucket(World world, MovingObjectPosition pos, Block block, int blockMeta, ItemStack curBucket) {

		Item bucket = buckets.get(block);

		if (bucket != null && isSteelEmptyBucket(curBucket.getItem()) && blockMeta == 0) {
			world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			return new ItemStack(bucket);
		} else
			return null;

	}

	private boolean isTFCEmptyBucket(Item bucket) {
		return bucket.equals(TFCItems.blueSteelBucketEmpty) || bucket.equals(TFCItems.redSteelBucketEmpty) || bucket.equals(TFCItems.woodenBucketEmpty);
	}

	private boolean isValidBucket(Item bucket) {
		return bucket instanceof ItemCustomBucket || bucket instanceof ItemSteelBucket;
	}

	private boolean isSteelEmptyBucket(Item bucket) {
		return bucket.equals(ModItems.steelBucketEmpty);
	}

	private boolean isBlockModFluid(Block block) {
		if (block instanceof BlockLatex)
			return true;
		if (TFCTech.enableBCCore && block instanceof BlockBuildCraftFluid)
			return true;
		return false;
	}
}