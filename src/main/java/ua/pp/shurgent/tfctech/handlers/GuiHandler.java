package ua.pp.shurgent.tfctech.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ua.pp.shurgent.tfctech.containers.ContainerInductionSmelter;
import ua.pp.shurgent.tfctech.tileentities.TEInductionSmelter;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int Id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te;
		
		try {
			te = world.getTileEntity(x, y, z);
		} catch (Exception e) {
			return null;
		}
		
		switch (Id) {
		case 0:
			return new ContainerInductionSmelter(player.inventory, (TEInductionSmelter) te, world, x, y, z);
			
		default:
			return null;
		}
	}
	
	@Override
	public Object getClientGuiElement(int Id, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
}
