package ua.pp.shurgent.tfctech.core;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.oredict.OreDictionary;
import ua.pp.shurgent.tfctech.TFCTech;

import com.bioxx.tfc.Items.ItemDyeCustom;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ModUtils {
	
	public static void checkUpdate(EntityPlayer player) {
		// TODO Add option in config to check only releases or alpha/beta builds too.
		try {
			JsonObject object = new JsonParser().parse(getSite("https://raw.githubusercontent.com/Shurgent/TFCTech/master/tfctech-latest.json", "utf8"))
					.getAsJsonObject();
			String ver = object.get("version").getAsString();
			
			if (!ver.equals(ModDetails.ModVersion)) {
				
				player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.WHITE + "New TFCTech version " + ver + " is available."));
				player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.WHITE + "You can download it at:"));
				
				IChatComponent component = IChatComponent.Serializer.func_150699_a("{\n" + "\"text\":\"CurseForge\",\n" + "\"color\":\"yellow\",\n"
						+ "\"hoverEvent\":{\n" + "\"action\":\"show_text\",\n" + "\"value\":{\n"
						+ "\"text\":\"Click this button for download latest version\",\n" + "\"color\":\"yellow\"\n" + "}\n" + "},\n" + "\"clickEvent\":{\n"
						+ "\"action\":\"open_url\",\n" + "\"value\":\"" + "http://minecraft.curseforge.com/projects/tfctech-addon/" + "\"\n" + "}\n" + "}");
				player.addChatComponentMessage(component);
				
				/*
				 * player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.WHITE + "or")); component =
				 * IChatComponent.Serializer.func_150699_a("{\n" + "\"text\":\"Project Site\",\n" + "\"color\":\"yellow\",\n" + "\"hoverEvent\":{\n" +
				 * "\"action\":\"show_text\",\n" + "\"value\":{\n" + "\"text\":\"Click this button for download latest version\",\n" + "\"color\":\"yellow\"\n"
				 * + "}\n" + "},\n" + "\"clickEvent\":{\n" + "\"action\":\"open_url\",\n" + "\"value\":\"" + "http://shurgent.pp.ua/tfctech/tfctech-latest/" +
				 * "\"\n" + "}\n" + "}"); player.addChatComponentMessage(component);
				 */
				
				JsonArray cl = object.get("changelog").getAsJsonArray();
				player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.AQUA + "Changelog:"));
				for (int i = 0; i < cl.size(); i++) {
					player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.WHITE + " * " + cl.get(i).getAsString()));
				}
				
			} else {
				TFCTech.LOG.info("TFCTech Addon version is up to date.");
			}
		} catch (Exception e) {
			player.addChatComponentMessage(new ChatComponentTranslation("[TFCTech] Failed to check for update."));
		}
	}
	
	public static String getSite(String url, String enc) throws Exception {
		
		StringBuffer stringBuffer = new StringBuffer();
		
		if (url.length() < 8 || !(url.substring(0, 7).equalsIgnoreCase("http://") || url.substring(0, 8).equalsIgnoreCase("https://")))
			url = "http://" + url;
		
		URL urlObj = new URL(url);
		InputStream inputStream = urlObj.openStream();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, enc));
		String str = br.readLine();
		while (str != null) {
			stringBuffer.append(str);
			str = br.readLine();
		}
		
		inputStream.close();
		return stringBuffer.toString();
	}
	
	public static boolean areItemStacksEqual(ItemStack input, ItemStack target) {
		return input == target || OreDictionary.itemMatches(target, input, false);
	}
	
	public static int getColorIndex(String colorName) {
		for (int i = 0; i < ItemDyeCustom.DYE_COLOR_NAMES.length; i++) {
			if (ItemDyeCustom.DYE_COLOR_NAMES[i].matches(colorName))
				return i;
		}
		return -1;
	}
	
}
