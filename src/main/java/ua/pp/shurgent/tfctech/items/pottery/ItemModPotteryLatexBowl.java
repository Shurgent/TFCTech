package ua.pp.shurgent.tfctech.items.pottery;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;
import ua.pp.shurgent.tfctech.Globals;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.core.ModDetails;
import ua.pp.shurgent.tfctech.core.ModFluids;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.integration.bc.handlers.LiquidContainerHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemModPotteryLatexBowl extends ItemModPotteryBase implements IFluidContainerItem {

	public ItemModPotteryLatexBowl() {
		super();
		setMetaNames(new String[] { "Clay Latex Bowl", "Ceramic Latex Bowl" });
		metaIcons = new IIcon[6];
		this.setMaxDamage(Globals.LATEX_BOWL_CAPACITY + 1);
	}

	@Override
	public boolean onItemUse(ItemStack is, EntityPlayer ep, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (is != null && is.getItem() instanceof ItemModPotteryLatexBowl && is.getItemDamage() > 0) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null) {
				
				if (TFCTech.enableBCFactory) {
					if (LiquidContainerHandler.handleLatexBowlUse(is, te))
						return true;
				}
				
			}
		}
		return super.onItemUse(is, ep, world, x, y, z, side, hitX, hitY, hitZ);
	}

	@Override
	public boolean isDamageable() {
		return this.getMaxDamage() > 0;
	}

	@Override
	public void addItemInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
		if (is.getItemDamage() >= 2) {
			int units = getUnitsFromDamage(is.getItemDamage());
			arraylist.add(StatCollector.translateToLocal("gui.qty") + ": " + units + " mB / " + getMaxUnits() + " mB");
		}
	}

	public int getUnitsFromDamage(int damage) {
		return damage > 1 ? getMaxUnits() - (damage - 2) : 0;
	}

	public int getDamageFromUnits(int units) {
		return units > 0 ? getMaxDamage() - (units - 1) : 1;
	}

	public int getMaxUnits() {
		return getMaxDamage() - 1;
	}

	@Override
	public boolean isDamaged(ItemStack stack) {
		return stack.getItemDamage() >= 2;
	}

	@Override
	public void registerIcons(IIconRegister registerer) {
		super.registerIcons(registerer);
		metaIcons[0] = this.clayIcon;
		metaIcons[1] = this.ceramicIcon;
		for (int i = 2; i < 6; i++) {
			metaIcons[i] = registerer.registerIcon(ModDetails.ModID + ":" + textureFolder + metaNames[1] + (i - 1));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack is) {
		if (is != null) {
			int damage = is.getItemDamage() >= 1 ? 1 : 0;
			return getUnlocalizedName() + "." + metaNames[damage];
		}
		return super.getUnlocalizedName(is);
	}

	@Override
	public IIcon getIconFromDamage(int damage) {
		if (damage < 2)
			return metaIcons[damage];
		int i = getUnitsFromDamage(damage) / (getMaxUnits() / 4);
		return metaIcons[i + 1];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tabs, List list) {
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
		list.add(new ItemStack(item, 1, 2));
	}

	@Override
	public FluidStack getFluid(ItemStack container) {
		if (container != null && container.getItem() == ModItems.latexBowl)
			return new FluidStack(ModFluids.LATEX, getUnitsFromDamage(container.getItemDamage()));
		return null;
	}

	@Override
	public int getCapacity(ItemStack container) {
		return Globals.LATEX_BOWL_CAPACITY;
	}

	@Override
	public int fill(ItemStack container, FluidStack resource, boolean doFill) {
		if (container != null && container.stackSize == 1 && container.getItem() == ModItems.latexBowl && resource != null
				&& resource.getFluid() == ModFluids.LATEX) {
			int amount = getUnitsFromDamage(container.getItemDamage());
			int free = Globals.LATEX_BOWL_CAPACITY - amount;
			int filled = 0;
			if (free < 1)
				return 0;
			if (resource.amount <= free) {
				filled = resource.amount;
				amount += filled;
				resource.amount = 0;
				container.setItemDamage(getDamageFromUnits(amount));
				return filled;
			} else {
				resource.amount -= free;
				if (resource.amount < 1)
					resource = null;
				container.setItemDamage(2); // Full bowl
				return free;
			}
		}
		return 0;
	}

	@Override
	public FluidStack drain(ItemStack container, int maxDrain, boolean doDrain) {
		if (container != null && container.stackSize == 1 && container.getItem() == ModItems.latexBowl) {
			int amt = getUnitsFromDamage(container.getItemDamage());
			if (amt < 1)
				return null;
			int filled = amt < maxDrain ? amt : maxDrain;
			container.setItemDamage(getDamageFromUnits(amt - filled));
			return new FluidStack(ModFluids.LATEX, filled);
		}
		return null;
	}

	@Override
	public boolean canStack() {
		return false;
	}
}
