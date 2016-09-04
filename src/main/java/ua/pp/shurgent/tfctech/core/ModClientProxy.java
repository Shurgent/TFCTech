package ua.pp.shurgent.tfctech.core;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import ua.pp.shurgent.tfctech.render.RenderInductionSmelter;
import ua.pp.shurgent.tfctech.render.RenderLatexExtractor;
import ua.pp.shurgent.tfctech.render.RenderModOre;
import ua.pp.shurgent.tfctech.render.RenderWireDrawBench;
import ua.pp.shurgent.tfctech.render.TESR.TESRInductionSmelter;
import ua.pp.shurgent.tfctech.render.TESR.TESRLatexExtractor;
import ua.pp.shurgent.tfctech.render.TESR.TESRWireDrawBench;
import ua.pp.shurgent.tfctech.tileentities.TEInductionSmelter;
import ua.pp.shurgent.tfctech.tileentities.TELatexExtractor;
import ua.pp.shurgent.tfctech.tileentities.TEWireDrawBench;
import buildcraft.transport.TransportProxyClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModClientProxy extends ModCommonProxy {
	
	@Override
	public String getCurrentLanguage() {
		return Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode();
	}
	
	@Override
	public World getCurrentWorld() {
		return Minecraft.getMinecraft().theWorld;
	}
	
	@Override
	public boolean getGraphicsLevel() {
		Minecraft.getMinecraft();
		return Minecraft.isFancyGraphicsEnabled();
	}
	
	@Override
	public File getMinecraftDirectory() {
		return Minecraft.getMinecraft().mcDataDir;
	}
	
	@Override
	public boolean isRemote() {
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void loadOptions() {
		// Load our settings from the server
		ModOptions.loadSettings();
	}
	
	@Override
	public void registerGuiHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(ua.pp.shurgent.tfctech.TFCTech.instance, new ua.pp.shurgent.tfctech.handlers.client.GuiHandler());
	}
	
	@Override
	public void registerHandlers() {
	}
	
	@Override
	public void registerKeys() {
		uploadKeyBindingsToGame();
	}
	
	@Override
	public void registerPipeRenderer() {
		super.registerPipeRenderer();
		
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeStructureLead, TransportProxyClient.pipeItemRenderer);
		
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeItemsLead, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeItemsBlueSteel, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeItemsMarker, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeItemsFilter, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeItemsCopper, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeItemsRedSteel, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeItemsMarkerExtractor, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeItemsElectrum, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeItemsWroughtIron, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeItemsBlackSteel, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeItemsSilver, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeItemsBronze, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeItemsSterlingSilver, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeItemsZinc, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeItemsNullify, TransportProxyClient.pipeItemRenderer);
		
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeFluidsLead, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeFluidsCopper, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeFluidsRedSteel, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeFluidsSterlingSilver, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeFluidsElectrum, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeFluidsWroughtIron, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeFluidsSilver, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeFluidsBronze, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeFluidsNullify, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeFluidsZinc, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipeFluidsBlueSteel, TransportProxyClient.pipeItemRenderer);
		
		MinecraftForgeClient.registerItemRenderer(ModItems.pipePowerBlueSteel, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipePowerElectrum, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipePowerSterlingSilver, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipePowerBronze, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipePowerSilver, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipePowerLead, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipePowerCopper, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipePowerRedSteel, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.pipePowerWroughtIron, TransportProxyClient.pipeItemRenderer);
	}
	
	@Override
	public void registerKeyBindingHandler() {
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerRenderInformation() {
		RenderingRegistry.registerBlockHandler(ModBlocks.oreRenderId = RenderingRegistry.getNextAvailableRenderId(), new RenderModOre());
		RenderingRegistry.registerBlockHandler(ModBlocks.latexExtractorRenderId = RenderingRegistry.getNextAvailableRenderId(), new RenderLatexExtractor());
		RenderingRegistry.registerBlockHandler(ModBlocks.wireDrawBenchRenderId = RenderingRegistry.getNextAvailableRenderId(), new RenderWireDrawBench());
		RenderingRegistry.registerBlockHandler(ModBlocks.inductionSmelterRenderId = RenderingRegistry.getNextAvailableRenderId(), new RenderInductionSmelter());
	}
	
	@Override
	public void registerTileEntities(boolean flag) {
		super.registerTileEntities(false);
		
		// TESR registers
		ClientRegistry.registerTileEntity(TELatexExtractor.class, "LatexExtractor", new TESRLatexExtractor());
		ClientRegistry.registerTileEntity(TEWireDrawBench.class, "WireDrawBench", new TESRWireDrawBench());
		ClientRegistry.registerTileEntity(TEInductionSmelter.class, "InductionSmelter", new TESRInductionSmelter());
	}
	
	@Override
	public void uploadKeyBindingsToGame() {
	}
	
	@Override
	public void registerTickHandler() {
		super.registerTickHandler();
	}
	
}
