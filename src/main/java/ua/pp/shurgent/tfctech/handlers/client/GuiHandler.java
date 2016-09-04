package ua.pp.shurgent.tfctech.handlers.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ua.pp.shurgent.tfctech.gui.GuiInductionSmelter;
import ua.pp.shurgent.tfctech.tileentities.TEInductionSmelter;

public class GuiHandler extends ua.pp.shurgent.tfctech.handlers.GuiHandler {
	@Override
	public Object getClientGuiElement(int Id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te;
		
		try {
			te = world.getTileEntity(x, y, z);
		} catch (Exception e) {
			return null;
		}
		
		switch (Id) {
		case 0:
			return new GuiInductionSmelter(player.inventory, (TEInductionSmelter) te, world, x, y, z);
			
		default:
			return null;
		}
	}
}
