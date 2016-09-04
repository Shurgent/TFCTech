package ua.pp.shurgent.tfctech.core;

import java.io.File;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import ua.pp.shurgent.tfctech.handlers.ServerTickHandler;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsBlueSteel;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsBronze;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsCopper;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsElectrum;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsLead;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsNullify;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsRedSteel;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsSilver;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsSterlingSilver;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsWroughtIron;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.fluids.PipeFluidsZinc;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power.PipePowerBlueSteel;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power.PipePowerBronze;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power.PipePowerCopper;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power.PipePowerElectrum;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power.PipePowerLead;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power.PipePowerRedSteel;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power.PipePowerSilver;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power.PipePowerSterlingSilver;
import ua.pp.shurgent.tfctech.integration.bc.blocks.pipes.power.PipePowerWroughtIron;
import ua.pp.shurgent.tfctech.tileentities.TEInductionSmelter;
import ua.pp.shurgent.tfctech.tileentities.TELatexExtractor;
import ua.pp.shurgent.tfctech.tileentities.TEModOre;
import ua.pp.shurgent.tfctech.tileentities.TEWireDrawBench;
import buildcraft.transport.PipeTransportFluids;
import buildcraft.transport.PipeTransportPower;
import buildcraft.transport.pipes.PipeFluidsClay;
import buildcraft.transport.pipes.PipeFluidsCobblestone;
import buildcraft.transport.pipes.PipeFluidsDiamond;
import buildcraft.transport.pipes.PipeFluidsEmerald;
import buildcraft.transport.pipes.PipeFluidsGold;
import buildcraft.transport.pipes.PipeFluidsIron;
import buildcraft.transport.pipes.PipeFluidsQuartz;
import buildcraft.transport.pipes.PipeFluidsSandstone;
import buildcraft.transport.pipes.PipeFluidsStone;
import buildcraft.transport.pipes.PipeFluidsVoid;
import buildcraft.transport.pipes.PipeFluidsWood;
import buildcraft.transport.pipes.PipePowerCobblestone;
import buildcraft.transport.pipes.PipePowerDiamond;
import buildcraft.transport.pipes.PipePowerEmerald;
import buildcraft.transport.pipes.PipePowerGold;
import buildcraft.transport.pipes.PipePowerIron;
import buildcraft.transport.pipes.PipePowerQuartz;
import buildcraft.transport.pipes.PipePowerSandstone;
import buildcraft.transport.pipes.PipePowerStone;
import buildcraft.transport.pipes.PipePowerWood;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModCommonProxy {
	public String getCurrentLanguage() {
		return null;
	}

	public World getCurrentWorld() {
		return MinecraftServer.getServer().getEntityWorld();
	}

	public boolean getGraphicsLevel() {
		return false;
	}

	public File getMinecraftDirectory() {
		return FMLCommonHandler.instance().getMinecraftServerInstance().getFile("");
	}

	public boolean isRemote() {
		return false;
	}

	public void loadOptions() {
		// Load our settings from the Options file
		ModOptions.loadSettings();
	}

	public void onClientLogin() {
	}

	public void registerFluidIcons() {
	}

	public void registerGuiHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(ua.pp.shurgent.tfctech.TFCTech.instance, new ua.pp.shurgent.tfctech.handlers.GuiHandler());
	}

	public void registerHandlers() {
	}

	public void registerKeys() {
	}

	public void registerKeyBindingHandler() {
	}

	public void registerRenderInformation() {
		// NOOP on server
	}

	public void registerPipeRenderer() {
		// NOOP on server
	}
	
	public void registerSoundHandler() {
	}

	public void registerTickHandler() {
		FMLCommonHandler.instance().bus().register(new ServerTickHandler());
	}

	public void registerPowerPipeCapacities()
	{
		PipeTransportPower.powerCapacities.put(PipePowerBlueSteel.class, PipeTransportPower.powerCapacities.get(PipePowerDiamond.class));
		PipeTransportPower.powerCapacities.put(PipePowerElectrum.class, PipeTransportPower.powerCapacities.get(PipePowerGold.class));
		PipeTransportPower.powerCapacities.put(PipePowerSterlingSilver.class, PipeTransportPower.powerCapacities.get(PipePowerQuartz.class));
		PipeTransportPower.powerCapacities.put(PipePowerBronze.class, PipeTransportPower.powerCapacities.get(PipePowerStone.class));
		PipeTransportPower.powerCapacities.put(PipePowerSilver.class, PipeTransportPower.powerCapacities.get(PipePowerSandstone.class));
		PipeTransportPower.powerCapacities.put(PipePowerLead.class, PipeTransportPower.powerCapacities.get(PipePowerCobblestone.class));
		PipeTransportPower.powerCapacities.put(PipePowerCopper.class, PipeTransportPower.powerCapacities.get(PipePowerWood.class));
		PipeTransportPower.powerCapacities.put(PipePowerRedSteel.class, PipeTransportPower.powerCapacities.get(PipePowerEmerald.class));
		PipeTransportPower.powerCapacities.put(PipePowerWroughtIron.class, PipeTransportPower.powerCapacities.get(PipePowerIron.class));

		PipeTransportPower.powerCapacities.put(PipePowerLead.class, PipeTransportPower.powerCapacities.get(PipePowerCobblestone.class));
		PipeTransportPower.powerResistances.put(PipePowerBlueSteel.class, PipeTransportPower.powerResistances.get(PipePowerDiamond.class));
		PipeTransportPower.powerResistances.put(PipePowerElectrum.class, PipeTransportPower.powerResistances.get(PipePowerGold.class));
		PipeTransportPower.powerResistances.put(PipePowerSterlingSilver.class, PipeTransportPower.powerResistances.get(PipePowerQuartz.class));
		PipeTransportPower.powerResistances.put(PipePowerBronze.class, PipeTransportPower.powerResistances.get(PipePowerStone.class));
		PipeTransportPower.powerResistances.put(PipePowerSilver.class, PipeTransportPower.powerResistances.get(PipePowerSandstone.class));
		PipeTransportPower.powerResistances.put(PipePowerLead.class, PipeTransportPower.powerResistances.get(PipePowerCobblestone.class));
		PipeTransportPower.powerResistances.put(PipePowerCopper.class, PipeTransportPower.powerResistances.get(PipePowerWood.class));
		PipeTransportPower.powerResistances.put(PipePowerRedSteel.class, PipeTransportPower.powerResistances.get(PipePowerRedSteel.class));
		PipeTransportPower.powerResistances.put(PipePowerWroughtIron.class, PipeTransportPower.powerResistances.get(PipePowerIron.class));
	}

	public void registerFluidPipeCapacities()
	{
		PipeTransportFluids.fluidCapacities.put(PipeFluidsLead.class, PipeTransportFluids.fluidCapacities.get(PipeFluidsCobblestone.class));
		PipeTransportFluids.fluidCapacities.put(PipeFluidsCopper.class, PipeTransportFluids.fluidCapacities.get(PipeFluidsWood.class));
		PipeTransportFluids.fluidCapacities.put(PipeFluidsRedSteel.class, PipeTransportFluids.fluidCapacities.get(PipeFluidsEmerald.class));
		PipeTransportFluids.fluidCapacities.put(PipeFluidsSterlingSilver.class, PipeTransportFluids.fluidCapacities.get(PipeFluidsQuartz.class));
		PipeTransportFluids.fluidCapacities.put(PipeFluidsElectrum.class, PipeTransportFluids.fluidCapacities.get(PipeFluidsGold.class));
		PipeTransportFluids.fluidCapacities.put(PipeFluidsWroughtIron.class, PipeTransportFluids.fluidCapacities.get(PipeFluidsIron.class));
		PipeTransportFluids.fluidCapacities.put(PipeFluidsSilver.class, PipeTransportFluids.fluidCapacities.get(PipeFluidsSandstone.class));
		PipeTransportFluids.fluidCapacities.put(PipeFluidsBronze.class, PipeTransportFluids.fluidCapacities.get(PipeFluidsStone.class));
		PipeTransportFluids.fluidCapacities.put(PipeFluidsNullify.class, PipeTransportFluids.fluidCapacities.get(PipeFluidsVoid.class));
		PipeTransportFluids.fluidCapacities.put(PipeFluidsZinc.class, PipeTransportFluids.fluidCapacities.get(PipeFluidsClay.class));
		PipeTransportFluids.fluidCapacities.put(PipeFluidsBlueSteel.class, PipeTransportFluids.fluidCapacities.get(PipeFluidsDiamond.class));
	}

	public void registerTileEntities(boolean flag) {
		// non TESR registers
		GameRegistry.registerTileEntity(TEModOre.class, "modOre");
		if (flag) {
			// TESR registers
			GameRegistry.registerTileEntity(TELatexExtractor.class, "LatexExtractor");
			GameRegistry.registerTileEntity(TEWireDrawBench.class, "WireDrawBench");
			GameRegistry.registerTileEntity(TEInductionSmelter.class, "InductionSmelter");
		}
	}

	public void registerToolClasses() {
	}

	public void registerWailaClasses() {
		FMLInterModComms.sendMessage("Waila", "register", "ua.pp.shurgent.tfctech.waila.WAILAData.callbackRegister");
	}

	public void uploadKeyBindingsToGame() {
	}
	
}
