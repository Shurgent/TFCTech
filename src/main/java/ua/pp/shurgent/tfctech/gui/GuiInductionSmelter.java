package ua.pp.shurgent.tfctech.gui;

import java.util.Arrays;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import ua.pp.shurgent.tfctech.containers.ContainerInductionSmelter;
import ua.pp.shurgent.tfctech.core.ModDetails;
import ua.pp.shurgent.tfctech.tileentities.TEInductionSmelter;

import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.GUI.GuiContainerTFC;

public class GuiInductionSmelter extends GuiContainerTFC {
	
	public static ResourceLocation texture = new ResourceLocation(ModDetails.ModID, ModDetails.AssetPathGui + "gui_inductionSmelter.png");
	private TEInductionSmelter smelterTE;
	
	public GuiInductionSmelter(InventoryPlayer inventoryplayer, TEInductionSmelter te, World world, int x, int y, int z) {
		super(new ContainerInductionSmelter(inventoryplayer, te, world, x, y, z), 176, 166);
		smelterTE = te;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
		super.initGui();
		buttonList.clear();
		buttonList.add(new GuiButtonThermostat(0, guiLeft + 139, guiTop + 84, 30, 11, 177, 108));
		buttonList.add(new GuiButtonThermostat(1, guiLeft + 139, guiTop + 96, 30, 11, 177, 119));
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		this.drawGui(texture);
	}
	
	@Override
	protected void drawForeground(int guiLeft, int guiTop) {
		int scale = 0;
		
		scale = smelterTE.getTemperatureScaled(46);
		drawTexturedModalRect(guiLeft + 153, guiTop + 78 - scale, 185, 0, 15, 6);
		
		scale = smelterTE.getOutCountScaled(100);
		drawTexturedModalRect(guiLeft + 129, guiTop + 106 - scale, 177, 6, 8, scale);
		
		scale = smelterTE.getThermostatScaled(41);
		drawTexturedModalRect(guiLeft + 142, guiTop + 78 - scale, 201, 0, 9, 8);
		
		scale = smelterTE.getEnergyScaled(48);
		drawTexturedModalRect(guiLeft + 7, guiTop + 158 - scale, 186, 56 - scale, 12, scale);
		
		if (smelterTE.heating)
			drawTexturedModalRect(guiLeft + 22, guiTop + 142, 186, 58, 14, 14);
		
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		
		this.fontRendererObj.drawString("t = " + smelterTE.temperature, 62, 150, 0x000000);
		
		if (smelterTE.currentAlloy != null) {
			if (smelterTE.currentAlloy.outputAmount == 0) {
				this.fontRendererObj.drawString(EnumChatFormatting.UNDERLINE + TFC_Core.translate("gui.empty"), 7, 7, 0x000000);
				return;
			} else if (smelterTE.currentAlloy.outputType != null) {
				this.fontRendererObj.drawString(
						EnumChatFormatting.UNDERLINE + TFC_Core.translate("gui.metal." + smelterTE.currentAlloy.outputType.name.replace(" ", "")), 7, 7,
						0x000000);
			} else {
				this.fontRendererObj.drawString(EnumChatFormatting.UNDERLINE + TFC_Core.translate("gui.metal.Unknown"), 7, 7, 0x000000);
			}
			
			for (int c = 0; c < smelterTE.currentAlloy.alloyIngred.size(); c++) {
				double m = smelterTE.currentAlloy.alloyIngred.get(c).metal;
				m = Math.round(m * 100d) / 100d;
				if (smelterTE.currentAlloy.alloyIngred.get(c).metalType != null) {
					this.fontRendererObj.drawString(
							EnumChatFormatting.DARK_GRAY
									+ TFC_Core.translate("gui.metal." + smelterTE.currentAlloy.alloyIngred.get(c).metalType.name.replace(" ", "")) + ": "
									+ EnumChatFormatting.DARK_GREEN + m + "%", 7, 18 + 10 * (c), 0x000000);
				}
			}
		}
	}
	
	@Override
	public void drawScreen(int mx, int my, float f) {
		super.drawScreen(mx, my, f);
		if (smelterTE.currentAlloy != null) {
			int w = (this.width - this.xSize) / 2;
			int h = (this.height - this.ySize) / 2;
			
			// Metal amount tooltip
			if (mx >= 129 + w && my >= 6 + h && mx <= 137 + w && my <= 106 + h) {
				String[] text = {
					String.format("%2.0f", smelterTE.currentAlloy.outputAmount)
				};
				List<String> temp = Arrays.asList(text);
				drawHoveringText(temp, mx, my, fontRendererObj);
			}
			
			// Energy tooltip
			if (mx >= 7 + w && my >= 111 + h && mx <= 19 + w && my <= 159 + h) {
				String[] text = {
					String.format("%d RF", smelterTE.energy)
				};
				List<String> temp = Arrays.asList(text);
				drawHoveringText(temp, mx, my, fontRendererObj);
			}
			
			// Thermostat tooltip
			if (mx >= 142 + w && my >= 31 + h && mx <= 151 + w && my <= 83 + h) {
				String[] text = {
						TFC_Core.translate("gui.inductionSmelter.thermostat"),
						String.format("%d - %d", smelterTE.minTemp, smelterTE.maxTemp)
				};
				List<String> temp = Arrays.asList(text);
				drawHoveringText(temp, mx, my, fontRendererObj);
			}
			
			// Thermostat buttons tooltip
			if (mx >= 139 + w && my >= 84 + h && mx <= 169 + w && my <= 107 + h) {
				String[] text = {
						TFC_Core.translate("gui.inductionSmelter.thermostatSettings")
				};
				List<String> temp = Arrays.asList(text);
				drawHoveringText(temp, mx, my, fontRendererObj);
			}
			
		}
	}
	
	@Override
	protected void actionPerformed(GuiButton guibutton) {
		
		if (guibutton.id == 0) {
			this.smelterTE.incTemp();
		} else if (guibutton.id == 1) {
			this.smelterTE.decTemp();
		}
		
	}
	
	public class GuiButtonThermostat extends GuiButton {
		
		private int u, v;
		
		public GuiButtonThermostat(int id, int xPos, int yPos, int xSize, int ySize, int u, int v) {
			super(id, xPos, yPos, xSize, ySize, "");
			this.u = u;
			this.v = v;
		}
		
		@Override
		public void drawButton(Minecraft minecraft, int xPos, int yPos) {
			if (this.visible) {
				bindTexture(texture);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				this.field_146123_n = xPos >= this.xPosition && yPos >= this.yPosition && xPos < this.xPosition + this.width
						&& yPos < this.yPosition + this.height;
				int k = this.getHoverState(this.field_146123_n) - 1;
				this.drawTexturedModalRect(this.xPosition, this.yPosition, u + 30 * k, v, this.width, this.height);
				this.mouseDragged(minecraft, xPos, yPos);
			}
		}
	}
}
