package ua.pp.shurgent.tfctech.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import ua.pp.shurgent.tfctech.api.interfaces.IDrawable;
import ua.pp.shurgent.tfctech.core.ModDetails;

import com.bioxx.tfc.api.Enums.EnumSize;

public class ItemUnfinishedWire extends ItemModMetalItem implements IDrawable {
	
	public ItemUnfinishedWire(String m, int amt) {
		super(m, amt, "wires");
		this.hasSubtypes = true;
		this.setSize(EnumSize.SMALL);
	}
	
	@Override
	public void registerIcons(IIconRegister registerer) {
		this.itemIcon = registerer.registerIcon(ModDetails.ModID
				+ ":"
				+ textureFolder
				+ this.getUnlocalizedName().replace("item.", "").replace("Unfinished ", "").replace("Stage1 ", "").replace("Stage2 ", "")
						.replace("Stage3 ", ""));
	}
	
	@Override
	public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
		if (is.getItemDamage() == 0)
			arraylist.add(StatCollector.translateToLocal("gui.wire.stage1"));
		else if (is.getItemDamage() == 1)
			arraylist.add(StatCollector.translateToLocal("gui.wire.stage2"));
		else
			arraylist.add(StatCollector.translateToLocal("gui.wire.stage3"));
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack itemstack) {
		return new StringBuilder().append(super.getItemStackDisplayName(itemstack)).toString();
	}
	
	@Override
	public String getWireMetalName() {
		return getMetalType(null).name;
	}
	
	@Override
	public int getWireMetalTier() {
		return getSmeltTier(null).tier;
	}
	
}
