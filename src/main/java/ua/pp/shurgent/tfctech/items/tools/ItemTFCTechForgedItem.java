package ua.pp.shurgent.tfctech.items.tools;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.core.ModDetails;

import com.bioxx.tfc.Items.ItemTerra;
import com.bioxx.tfc.Items.Tools.ItemTerraTool;
import com.bioxx.tfc.api.Metal;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;
import com.bioxx.tfc.api.Interfaces.ISmeltable;

public class ItemTFCTechForgedItem extends ItemTerra implements ISmeltable {
	
	private ToolMaterial material;
	
	public ItemTFCTechForgedItem() {
		super();
		this.setMaxDamage(100);
		this.setMaxStackSize(4);
		setCreativeTab(TFCTech.TFCTECH);
		this.setFolder("tools/");
		this.setWeight(EnumWeight.MEDIUM);
		this.setSize(EnumSize.SMALL);
	}
	
	public ItemTFCTechForgedItem(ToolMaterial m) {
		this();
		material = m;
	}
	
	public ToolMaterial getMaterial() {
		return material;
	}
	
	@Override
	public void registerIcons(IIconRegister registerer) {
		this.itemIcon = registerer.registerIcon(ModDetails.ModID + ":" + textureFolder + this.getUnlocalizedName().replace("item.", ""));
	}
	
	@Override
	public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
		ItemTerraTool.addSmithingBonusInformation(is, arraylist);
	}
	
	@Override
	public Metal getMetalType(ItemStack is) {
		return null;
	}
	
	@Override
	public short getMetalReturnAmount(ItemStack is) {
		return 0;
	}
	
	@Override
	public boolean isSmeltable(ItemStack is) {
		return !this.isDamaged(is);
	}

	@Override
	public EnumTier getSmeltTier(ItemStack is) {
		return EnumTier.TierIII;
	}
	
}
