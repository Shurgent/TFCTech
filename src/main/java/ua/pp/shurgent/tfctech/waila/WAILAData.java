package ua.pp.shurgent.tfctech.waila;

import java.util.List;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import ua.pp.shurgent.tfctech.core.ModBlocks;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.tileentities.TELatexExtractor;
import ua.pp.shurgent.tfctech.tileentities.TEModOre;
import ua.pp.shurgent.tfctech.tileentities.TEWireDrawBench;

import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.api.TFCOptions;

public class WAILAData implements IWailaDataProvider {
	
	@Override
	public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
		// Block block = accessor.getBlock();
		TileEntity tileEntity = accessor.getTileEntity();
		if (tileEntity instanceof TEModOre)
			return oreStack(accessor, config);
		if (tileEntity instanceof TEWireDrawBench)
			return wireStack(accessor, config);
		return null;
	}
	
	private ItemStack oreStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
		int meta = accessor.getMetadata();
		TEModOre te = (TEModOre) accessor.getTileEntity();
		ItemStack itemstack = null;
		
		if (accessor.getBlock() == ModBlocks.ore) {
			if (config.getConfig("tfc.oreQuality"))
				itemstack = new ItemStack(ModItems.oreChunk, 1, getOreGrade(te, meta)); // Shows specific quality ore.
			else
				itemstack = new ItemStack(ModItems.oreChunk, 1, meta); // All normal quality ores.
				
			return itemstack;
		}
		
		return null;
	}
	
	private int getOreGrade(TEModOre te, int ore) {
		if (te != null) {
			int grade = te.extraData & 7;
			if (grade == 1)
				ore = 1;
			else if (grade == 2)
				ore = 2;
		}
		return ore;
	}
	
	private ItemStack wireStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
		TEWireDrawBench te = (TEWireDrawBench) accessor.getTileEntity();
		te = te.getMainTileEntity();
		
		if (accessor.getBlock() == ModBlocks.wireDrawBench && te != null) {
			if (te.getInput() != null)
				return te.getInput();
			if (te.getOutput() != null)
				return te.getOutput();
		}
		
		return null;
	}
	
	@Override
	public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		TileEntity tileEntity = accessor.getTileEntity();
		
		if (tileEntity instanceof TEModOre)
			currenttip = oreHead(itemStack, currenttip, accessor, config);
		
		return currenttip;
	}
	
	private List<String> oreHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return currenttip;
	}
	
	@Override
	public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		TileEntity tileEntity = accessor.getTileEntity();
		if (tileEntity instanceof TEModOre)
			currenttip = oreBody(itemStack, currenttip, accessor, config);
		if (tileEntity instanceof TELatexExtractor)
			currenttip = latexExtractorBody(itemStack, currenttip, accessor, config);
		if (tileEntity instanceof TEWireDrawBench)
			currenttip = wireDrawBenchBody(itemStack, currenttip, accessor, config);
		return currenttip;
	}
	
	private List<String> oreBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		int meta = accessor.getMetadata();
		
		if (accessor.getBlock() == ModBlocks.ore) {
			switch (meta) {
			case 0:
			case 1:
			case 2:
				currenttip.add(StatCollector.translateToLocal("gui.metal.Aluminum"));
				return currenttip;
			}
			
			if (config.getConfig("tfc.oreQuality")) {
				TEModOre te = (TEModOre) accessor.getTileEntity();
				
				int ore = getOreGrade(te, meta);
				
				int units = ore == 0 ? TFCOptions.normalOreUnits : ore == 1 ? TFCOptions.richOreUnits : ore == 2 ? TFCOptions.poorOreUnits : 0;
				if (units > 0)
					currenttip.add(TFC_Core.translate("gui.units") + " : " + units);
			}
			
		}
		return currenttip;
	}
	
	private List<String> latexExtractorBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		TELatexExtractor te = (TELatexExtractor) accessor.getTileEntity();
		
		if (te.isBowlInstalled()) {
			
			int latexAmt = te.getLatexAmount();
			
			if (latexAmt > 0) {
				currenttip.add(TFC_Core.translate("gui.latexAmt") + " : " + latexAmt + " mB / 200 mB");
			}
			if (latexAmt >= 200 && te.isFlowing()) {
				currenttip.add("\247c" + TFC_Core.translate("gui.loosingLatex"));
			}
		}
		return currenttip;
	}
	
	private List<String> wireDrawBenchBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		TEWireDrawBench te = (TEWireDrawBench) accessor.getTileEntity();
		te = te.getMainTileEntity();
		
		if (te.progress != 0) {
			currenttip.add(TFC_Core.translate("gui.wireDrawBench.progress") + " : " + te.progress + "%");
		}
		
		if (te.isLubricated) {
			currenttip.add("\247e" + TFC_Core.translate("gui.wireDrawBench.lubricated"));
		}
		
		return currenttip;
	}
	
	@Override
	public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return currenttip;
	}
	
	@Override
	public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x, int y, int z) {
		if (te != null)
			te.writeToNBT(tag);
		return tag;
	}
	
	public static void callbackRegister(IWailaRegistrar reg) {
		reg.addConfig("TerraFirmaCraft", "tfc.oreQuality");
		
		reg.registerStackProvider(new WAILAData(), TEModOre.class);
		reg.registerStackProvider(new WAILAData(), TEWireDrawBench.class);
		reg.registerHeadProvider(new WAILAData(), TEModOre.class);
		reg.registerBodyProvider(new WAILAData(), TEModOre.class);
		
		reg.registerBodyProvider(new WAILAData(), TELatexExtractor.class);
		reg.registerBodyProvider(new WAILAData(), TEWireDrawBench.class);
		
	}
}
