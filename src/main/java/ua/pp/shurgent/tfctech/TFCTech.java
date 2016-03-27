package ua.pp.shurgent.tfctech;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ua.pp.shurgent.tfctech.commands.GenHeveaCommand;
import ua.pp.shurgent.tfctech.core.ModBlocks;
import ua.pp.shurgent.tfctech.core.ModCommonProxy;
import ua.pp.shurgent.tfctech.core.ModDetails;
import ua.pp.shurgent.tfctech.core.ModFluids;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.core.ModOptions;
import ua.pp.shurgent.tfctech.core.ModOreDictionary;
import ua.pp.shurgent.tfctech.core.ModPipeIconProvider;
import ua.pp.shurgent.tfctech.core.ModRecipes;
import ua.pp.shurgent.tfctech.core.player.ModPlayerTracker;
import ua.pp.shurgent.tfctech.handlers.ChunkEventHandler;
import ua.pp.shurgent.tfctech.handlers.CraftingHandler;
import ua.pp.shurgent.tfctech.handlers.ModBucketHandler;
import ua.pp.shurgent.tfctech.handlers.TFCTechEventListener;
import ua.pp.shurgent.tfctech.items.ItemHeat;
import ua.pp.shurgent.tfctech.worldgen.WorldGenBauxiteRocks;
import ua.pp.shurgent.tfctech.worldgen.WorldGenHevea;
import buildcraft.BuildCraftEnergy;
import buildcraft.api.core.IIconProvider;

import com.bioxx.tfc.TerraFirmaCraft;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModDetails.ModID, name = ModDetails.ModName, version = ModDetails.ModVersion, useMetadata = false, dependencies = ModDetails.ModDependencies)
public class TFCTech {
	@Instance(ModDetails.ModID)
	public static TFCTech instance;
	public static final Logger LOG = LogManager.getLogger(ModDetails.ModName);
	public static ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
	
	public static boolean enableBCCore; // BuildCraft
	public static boolean enableBCBuilders;
	public static boolean enableBCEnergy;
	public static boolean enableBCFactory;
	public static boolean enableBCSilicon;
	public static boolean enableBCTransport;
	public static boolean enableBCRobotics;
	public static boolean enableBCCompat;
	public static boolean enableLP; // LogisticsPipes
	public static boolean enableRC; // Railcraft
	public static boolean enableIE; // ImmersiveEngineering
	public static boolean enableOC; // OpenComputers
	public static boolean enableBiblioCraft; // BiblioCraft
	
	public IIconProvider pipeIconProvider = new ModPipeIconProvider(); // Buildcraft pipe icon provider
	
	public static final CreativeTabs TFCTECH = new CreativeTabs("TFCTechTab") {
		
		@Override
		public Item getTabIconItem() {
			return ModItems.blueSteelGear;
		}
		
	};
	
	@SidedProxy(clientSide = ModDetails.CLIENT_PROXY_CLASS, serverSide = ModDetails.SERVER_PROXY_CLASS)
	public static ModCommonProxy proxy;

	public File getMinecraftDirectory() {
		return proxy.getMinecraftDirectory();
	}

	@EventHandler
	public void preInitialize(FMLPreInitializationEvent e) {
		instance = this;

		enableBCCore = checkMod("BuildCraft|Core");
		enableBCBuilders = checkMod("BuildCraft|Builders");
		enableBCEnergy = checkMod("BuildCraft|Energy");
		enableBCFactory = checkMod("BuildCraft|Factory");
		enableBCSilicon = checkMod("BuildCraft|Silicon");
		enableBCTransport = checkMod("BuildCraft|Transport");
		enableBCRobotics = checkMod("BuildCraft|Robotics");
		enableBCCompat = checkMod("BuildCraft|Compat");
		enableLP = checkMod("LogisticsPipes");
		enableRC = checkMod("Railcraft");
		enableIE = checkMod("ImmersiveEngineering");
		enableOC = checkMod("OpenComputers");
		enableBiblioCraft = checkMod("BiblioCraft");

		// Load our settings
		proxy.loadOptions();
		
		if (enableBCTransport)
			proxy.registerPipeRenderer();
		
		proxy.registerTickHandler();

		ModFluids.initialize();
		ModBlocks.initialise();

		// Register pipe capacities
		if (enableBCTransport) {
			proxy.registerPowerPipeCapacities();
			proxy.registerFluidPipeCapacities();
		}
		
		// Register Key Bindings(Client only)
		proxy.registerKeys();
		// Register KeyBinding Handler (Client only)
		proxy.registerKeyBindingHandler();
		// Register Handler (Client only)
		proxy.registerHandlers();
		// Register Tile Entities
		proxy.registerTileEntities(true);
		// Register Sound Handler (Client only)
		proxy.registerSoundHandler();

		ModItems.initialise();
		ItemHeat.setupItemHeat();

		// Register Gui Handler
		proxy.registerGuiHandler();

		GameRegistry.registerWorldGenerator(new WorldGenHevea(), 4);
		GameRegistry.registerWorldGenerator(new WorldGenBauxiteRocks(), 5);
	}

	@EventHandler
	public void initialize(FMLInitializationEvent e) {
		// Register packets in the TFC PacketPipeline
		TerraFirmaCraft.PACKET_PIPELINE.registerPacket(com.bioxx.tfc.Handlers.Network.InitClientWorldPacket.class);

		// Register the player tracker
		FMLCommonHandler.instance().bus().register(new ModPlayerTracker());

		// Register the tool classes
		proxy.registerToolClasses();

		// Register Crafting Handler
		FMLCommonHandler.instance().bus().register(new CraftingHandler());

		// Register the Chunk Load/Save Handler
		MinecraftForge.EVENT_BUS.register(new ChunkEventHandler());
		
		// Register Event Listener
		MinecraftForge.EVENT_BUS.register(new TFCTechEventListener());
		FMLCommonHandler.instance().bus().register(new  TFCTechEventListener());

		// Bucket Handler
		ModBucketHandler.INSTANCE.buckets.put(ModBlocks.latex, ModItems.steelBucketLatex);
		if (TFCTech.enableBCEnergy) {
			ModBucketHandler.INSTANCE.buckets.put(BuildCraftEnergy.blockOil, ModItems.steelBucketOil);
			ModBucketHandler.INSTANCE.buckets.put(BuildCraftEnergy.blockFuel, ModItems.steelBucketFuel);
		}
		MinecraftForge.EVENT_BUS.register(ModBucketHandler.INSTANCE);
		
		// Register all the render stuff for the client
		proxy.registerRenderInformation();

		ModOreDictionary.initialise();
		ModRecipes.initialise();

		// Register WAILA classes
		proxy.registerWailaClasses();
		
		proxy.hideNEIItems();
		ModFluids.registerFluidContainers();
	}

	@EventHandler
	public void postInitialize(FMLPostInitializationEvent e) {
		ModOptions.reloadOres();
	}

	private boolean checkMod(String modID) {
		boolean result = Loader.isModLoaded(modID);
		if (result) {
			TFCTech.LOG.info("Found mod [" + modID + "]");
		}
		return result;
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent evt)
	{
		evt.registerServerCommand(new GenHeveaCommand());
	}
	
}