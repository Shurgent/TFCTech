package ua.pp.shurgent.tfctech.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.core.ModDetails;

import com.bioxx.tfc.Items.ItemTerra;
import com.bioxx.tfc.api.Enums.EnumSize;

public class ItemCraftComponent extends ItemTerra {

	public ItemCraftComponent() {
		super();
		this.setFolder("integration/");
		this.setCreativeTab(TFCTech.TFCTECH);
		this.setSize(EnumSize.LARGE);
	}
	
	public ItemCraftComponent(EnumSize size) {
		this();
		this.setSize(size);
	}
	
	public ItemCraftComponent(EnumSize size, String[] meta) {
		this(size);
		this.setMetaNames(meta);
	}
	
	@Override
	public void registerIcons(IIconRegister registerer)
	{
		if(this.metaNames == null)
		{
			if(this.iconString != null)
				this.itemIcon = registerer.registerIcon(ModDetails.ModID + ":" + this.textureFolder + this.getIconString());
			else
				this.itemIcon = registerer.registerIcon(ModDetails.ModID + ":" + this.textureFolder + this.getUnlocalizedName().replace("item.", ""));
		}
		else
		{
			metaIcons = new IIcon[metaNames.length];
			for(int i = 0; i < metaNames.length; i++)
			{
				metaIcons[i] = registerer.registerIcon(ModDetails.ModID + ":" + this.textureFolder + metaNames[i]);
			}
			
			//This will prevent NullPointerException errors with other mods like NEI
			this.itemIcon = metaIcons[0];
		}
	}

}
