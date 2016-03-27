package ua.pp.shurgent.tfctech.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import ua.pp.shurgent.tfctech.blocks.flora.BlockModHeveaNatural;
import ua.pp.shurgent.tfctech.core.ModBlocks;
import ua.pp.shurgent.tfctech.core.ModSounds;

import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.Items.Tools.ItemHammer;
import com.bioxx.tfc.api.Enums.EnumItemReach;
import com.bioxx.tfc.api.Enums.EnumSize;

public class ItemGroove extends ItemModMetalItem {

	public ItemGroove(String m, int amt) {
		super(m, amt, "devices");
	}

	@Override
	public boolean onItemUse(ItemStack is, EntityPlayer ep, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!canUse(world, x, y, z)) {
			if (ep != null && ep.worldObj.isRemote)
				TFC_Core.sendInfoMessage(ep, new ChatComponentTranslation("gui.groove.heveaOnly"));
			return false;
		}

		ItemStack hammer = findHammer(ep);
		if (hammer == null) {
			if (ep != null && ep.worldObj.isRemote)
				TFC_Core.sendInfoMessage(ep, new ChatComponentTranslation("gui.groove.hammer"));
			return false;
		}

		int meta;
		int posX, posY, posZ;

		switch (side) {
		case 4:
			meta = 3; posX = x - 1; posY = y; posZ = z; 
			break;
		case 5:
			meta = 1; posX = x + 1; posY = y; posZ = z;
			break;
		case 2:
			meta = 0; posX = x; posY = y; posZ = z - 1;
			break;
		case 3:
			meta = 2; posX = x; posY = y; posZ = z + 1;
			break;
		default:
			if (ep != null && ep.worldObj.isRemote)
				TFC_Core.sendInfoMessage(ep, new ChatComponentTranslation("gui.groove.cantPlace"));
			return false;
		}

		if (!ModBlocks.latexExtractor.canPlaceBlockOnSide(world, posX, posY, posZ, side)) {
			if (ep != null && ep.worldObj.isRemote)
				TFC_Core.sendInfoMessage(ep, new ChatComponentTranslation("gui.groove.cantPlace"));
			return false;
		}
		
		world.setBlock(posX, posY, posZ, ModBlocks.latexExtractor, meta, 0x2);
		ModBlocks.latexExtractor.onBlockPlacedBy(world, posX, posY, posZ, ep, is);
		
		hammer.damageItem(1, ep);
		ep.inventory.mainInventory[ep.inventory.currentItem].stackSize--;
		
		ep.worldObj.playSoundEffect(x, y, z, ModSounds.GROOVEFIT, 1.0F, 1.0F + (ep.worldObj.rand.nextFloat()/4));
		
		return true;
	};

	@Override
	public EnumItemReach getReach(ItemStack is) {
		return EnumItemReach.SHORT;
	}

	@Override
	public EnumSize getSize(ItemStack is) {
		return EnumSize.VERYSMALL;
	}

	@Override
	public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
		if (TFC_Core.showShiftInformation()) {
			arraylist.add(StatCollector.translateToLocal("gui.Help"));
			arraylist.add(StatCollector.translateToLocal("gui.groove.usage0"));
			arraylist.add(StatCollector.translateToLocal("gui.groove.usage1"));
			arraylist.add(StatCollector.translateToLocal("gui.groove.usage2"));
		} else {
			arraylist.add(StatCollector.translateToLocal("gui.ShowHelp"));
		}
	}

	private boolean canUse(World world, int x, int y, int z) {
		return world.getBlock(x, y, z) instanceof BlockModHeveaNatural;
	}

	private ItemStack findHammer(EntityPlayer ep) {
		ItemStack curItem;
		for (int i = 0; i < 9; i++) {
			curItem = ep.inventory.mainInventory[i];
			if (curItem != null && curItem.getItem() instanceof ItemHammer) {
				return curItem;
			}
		}
		return null;
	}
}
