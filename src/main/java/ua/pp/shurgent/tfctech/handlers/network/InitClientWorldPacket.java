package ua.pp.shurgent.tfctech.handlers.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import ua.pp.shurgent.tfctech.core.ModRecipes;

import com.bioxx.tfc.Handlers.Network.AbstractPacket;

public class InitClientWorldPacket extends AbstractPacket
{
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) 
	{
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) 
	{
	}

	@Override
	public void handleClientSide(EntityPlayer player) 
	{
		ModRecipes.initialiseAnvil(player.worldObj); 
	}

	@Override
	public void handleServerSide(EntityPlayer player) 
	{
	}
}
