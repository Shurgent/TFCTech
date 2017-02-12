package ua.pp.shurgent.tfctech.core;


public class ModDetails {
	public static final String ModID = "tfctech";
	public static final String ModName = "TFCTech";

	public static final int VersionMajor = 0;
	public static final int VersionMinor = 2;
	public static final int VersionRevision = 10;
	public static final String VersionSuffix = "-A15";

	public static final String ModVersion = VersionMajor + "." + VersionMinor + "." + VersionRevision + VersionSuffix;
	public static final String ModDependencies =
								"required-after:Forge@[10.13.4.1558,);"
								+ "required-after:terrafirmacraft@[0.79.26,);"
								+ "after:BuildCraft|Core;"
								+ "after:BuildCraft|Builders;"
								+ "after:BuildCraft|Energy;"
								+ "after:BuildCraft|Factory;"
								+ "after:BuildCraft|Silicon;"
								+ "after:BuildCraft|Transport;"
								+ "after:BuildCraft|Robotics;"
								+ "after:BuildCraft|Compat;"
								+ "after:LogisticsPipes;"
								+ "after:Railcraft;"
								+ "after:ImmersiveEngineering;"
								+ "after:OpenComputers;"
								+ "after:BiblioCraft";
	public static final String ModChannel = "TFCTech";
	public static final String SERVER_PROXY_CLASS = "ua.pp.shurgent.tfctech.core.ModCommonProxy";
	public static final String CLIENT_PROXY_CLASS = "ua.pp.shurgent.tfctech.core.ModClientProxy";

	public static final String AssetPath = "/assets/" + ModID + "/";
	public static final String AssetPathGui = "textures/gui/";

	public static final String ConfigFilePath = "/config/";
	public static final String ConfigFileName = "TFCTech.cfg";

	public static final int GuiOffset = 10000;

	public static final String MODID_NEI = "NotEnoughItems";
	public static final String MODID_TFC = "terrafirmacraft";
	public static final String MODID_WAILA = "Waila";

	public static final String MODNAME_NEI = "Not Enough Items";
	public static final String MODNAME_TFC = "TerraFirmaCraft";
	public static final String MODNAME_WAILA = "Waila";
}
