package ua.pp.shurgent.tfctech.integration.bc.items;

import ua.pp.shurgent.tfctech.items.ItemModMetalItem;
import buildcraft.core.BCCreativeTab;

public class PipeFrameWroughtIron extends ItemModMetalItem {

	public PipeFrameWroughtIron(String m, int amt) {
		super(m, amt, "frames");
		setCreativeTab(BCCreativeTab.get("pipes"));
	}

}
