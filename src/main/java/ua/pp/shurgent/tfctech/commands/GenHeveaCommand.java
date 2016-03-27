package ua.pp.shurgent.tfctech.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.gen.feature.WorldGenerator;
import ua.pp.shurgent.tfctech.worldgen.WorldGenHeveaTree;

import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.api.TFCOptions;

public class GenHeveaCommand extends CommandBase {

	@Override
	public String getCommandName() {
		return "genHevea";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] params) {
		EntityPlayerMP player = getCommandSenderAsPlayer(sender);

		if (!TFCOptions.enableDebugMode) {
			TFC_Core.sendInfoMessage(player, new ChatComponentText("Debug Mode Required"));
			return;
		}

		TFC_Core.sendInfoMessage(player, new ChatComponentText("Generating Hevea Tree"));
		WorldGenerator treeGen = new WorldGenHeveaTree();
		if (!treeGen.generate(sender.getEntityWorld(), sender.getEntityWorld().rand, (int) player.posX, (int) player.posY, (int) player.posZ))
			TFC_Core.sendInfoMessage(player, new ChatComponentText("Generation Failed"));
	}

}
