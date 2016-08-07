package ua.pp.shurgent.tfctech.integration.bc.items;

import ua.pp.shurgent.tfctech.items.ItemModMetalItem;
import buildcraft.core.BCCreativeTab;

public class PipeFrameLead extends ItemModMetalItem {

	public PipeFrameLead(String m, int amt) {
		super(m, amt, "frames");
		setCreativeTab(BCCreativeTab.get("pipes"));
	}

}
