package ua.pp.shurgent.tfctech.items.tools;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;
import ua.pp.shurgent.tfctech.Globals;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.blocks.devices.BlockWireDrawBench;
import ua.pp.shurgent.tfctech.core.ModDetails;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.tileentities.TEWireDrawBench;

import com.bioxx.tfc.Items.ItemTerra;
import com.bioxx.tfc.api.Metal;
import com.bioxx.tfc.api.TFCFluids;
import com.bioxx.tfc.api.Constant.Global;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;
import com.bioxx.tfc.api.Interfaces.ISmeltable;

public class ItemOilCan extends ItemTerra implements ISmeltable, IFluidContainerItem {
	
	public ItemOilCan() {
		super();
		setCreativeTab(TFCTech.TFCTECH);
		this.textureFolder = "tools/";
	}
	
	public static ItemStack getFullCan() {
		ItemStack is = new ItemStack(ModItems.oilcan);
		FluidStack fs = new FluidStack(TFCFluids.OLIVEOIL, Globals.OIL_CAN_CAPACITY);
		is.setTagCompound(fs.writeToNBT(new NBTTagCompound()));
		return is;
	}
	
	@Override
	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		
		FluidStack fs = getFluid(is);
		
		if (fs == null)
			return false;
		if (fs.amount < 10)
			return false;
		
		Block block = world.getBlock(x, y, z);
		if (block instanceof BlockWireDrawBench) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te instanceof TEWireDrawBench) {
				TEWireDrawBench tewd = (TEWireDrawBench) te;
				if (!tewd.isHeadBlock) {
					tewd = tewd.getMainTileEntity();
					
					if (!tewd.isDrawing() && !tewd.isFinished() && tewd.getDrawplate() != null && !tewd.isLubricated) {
						((ItemOilCan) is.getItem()).drain(is, 10, true);
						tewd.isLubricated = true;
						tewd.updateWireDrawBench();
					}
					
					return true;
				}
			}
		}
		
		return false;
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
	public int getDisplayDamage(ItemStack is) {
		FluidStack fs = FluidStack.loadFluidStackFromNBT(is.getTagCompound());
		int amt = fs != null ? fs.amount : 0;
		return getMaxDamage(is) - amt;
	}
	
	@Override
	public boolean isDamaged(ItemStack is) {
		return is.hasTagCompound();
	}
	
	@Override
	public int getMaxDamage(ItemStack is) {
		return Globals.OIL_CAN_CAPACITY;
	}
	
	@Override
	public EnumSize getSize(ItemStack is) {
		return EnumSize.SMALL;
	}
	
	@Override
	public EnumWeight getWeight(ItemStack is) {
		return EnumWeight.LIGHT;
	}
	
	@Override
	public int getItemStackLimit(ItemStack is) {
		return 1;
	}
	
	@Override
	public FluidStack getFluid(ItemStack container) {
		if (container != null && container.getItem() == ModItems.oilcan)
			return FluidStack.loadFluidStackFromNBT(container.getTagCompound());
		return null;
	}
	
	@Override
	public int getCapacity(ItemStack container) {
		return Globals.OIL_CAN_CAPACITY;
	}
	
	@Override
	public int fill(ItemStack container, FluidStack resource, boolean doFill) {
		
		FluidStack fs = getFluid(container);
		int inAmt = 0;
		
		if (fs != null) {
			
			int max = getCapacity(container) - fs.amount;
			if (max > 0 && fs.isFluidEqual(resource)) {
				inAmt = Math.min(max, resource.amount);
				if (doFill) {
					fs.amount += inAmt;
					if (container.getTagCompound() == null)
						container.setTagCompound(new NBTTagCompound());
					fs.writeToNBT(container.getTagCompound());
				}
			}
			
		} else {
			
			inAmt = Math.min(getCapacity(container), resource.amount);
			if (doFill) {
				fs = resource.copy();
				fs.amount = inAmt;
				if (container.getTagCompound() == null)
					container.setTagCompound(new NBTTagCompound());
				fs.writeToNBT(container.getTagCompound());
			}
			
		}
		
		return inAmt;
	}
	
	@Override
	public FluidStack drain(ItemStack container, int maxDrain, boolean doDrain) {
		
		FluidStack fs = getFluid(container);
		if (fs == null)
			return null;
		FluidStack fsOut = fs.copy();
		
		fsOut.amount = Math.min(maxDrain, fs.amount);
		
		if (doDrain) {
			if (fs.amount - fsOut.amount <= 0) {
				container.stackTagCompound = null;
			} else {
				fs.amount -= fsOut.amount;
				if (container.getTagCompound() == null)
					container.setTagCompound(new NBTTagCompound());
				fs.writeToNBT(container.getTagCompound());
			}
		}
		
		return fsOut;
	}
	
	@Override
	public Metal getMetalType(ItemStack is) {
		return Global.BRASS;
	}
	
	@Override
	public short getMetalReturnAmount(ItemStack is) {
		return 200; // 1 x Metal Sheet
	}
	
	@Override
	public boolean isSmeltable(ItemStack is) {
		FluidStack fs = FluidStack.loadFluidStackFromNBT(is.getTagCompound());
		return fs == null || fs.amount == 0;
	}
	
	@Override
	public EnumTier getSmeltTier(ItemStack is) {
		return EnumTier.TierI;
	}
	
	@SuppressWarnings({
			"rawtypes",
			"unchecked"
	})
	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List arraylist, boolean flag) {
		super.addInformation(is, player, arraylist, flag);
		if (is.hasTagCompound()) {
			FluidStack fs = FluidStack.loadFluidStackFromNBT(is.getTagCompound());
			if (fs != null && fs.getFluid() == TFCFluids.OLIVEOIL)
				arraylist.add(StatCollector.translateToLocal("gui.qty") + ": " + fs.amount + " mB / " + Globals.OIL_CAN_CAPACITY + " mB");
		}
	}
}
