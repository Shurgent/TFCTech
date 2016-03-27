package ua.pp.shurgent.tfctech.tileentities;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import ua.pp.shurgent.tfctech.Globals;
import ua.pp.shurgent.tfctech.TFCTech;
import ua.pp.shurgent.tfctech.blocks.devices.BlockLatexExtractor;
import ua.pp.shurgent.tfctech.blocks.flora.BlockModHeveaNatural;
import ua.pp.shurgent.tfctech.core.ModBlocks;
import ua.pp.shurgent.tfctech.core.ModDetails;
import ua.pp.shurgent.tfctech.core.ModItems;
import ua.pp.shurgent.tfctech.core.ModOptions;
import ua.pp.shurgent.tfctech.core.ModSounds;
import ua.pp.shurgent.tfctech.items.ItemMount;
import ua.pp.shurgent.tfctech.items.pottery.ItemModPotteryLatexBowl;
import ua.pp.shurgent.tfctech.render.models.ModelLatexExtractor;

import com.bioxx.tfc.Core.TFC_Climate;
import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.Core.TFC_Time;
import com.bioxx.tfc.Items.Tools.ItemKnife;
import com.bioxx.tfc.TileEntities.NetworkTileEntity;
import com.bioxx.tfc.api.TFCOptions;
import com.bioxx.tfc.api.Constant.Global;

public class TELatexExtractor extends NetworkTileEntity {

	private static final int MAXAMT = 200;

	public byte rotation;

	private boolean bowlInstalled;
	private boolean mountInstalled;
	private boolean trunkScratched;
	private long drainTimer;
	private long scratchTime;
	private int latexAmt; // How much latex in bowl
	private int latexEst; // Estimated latex amount
	private int latexRemain; // How much latex remain

	private ModelLatexExtractor model;

	public TELatexExtractor() {
		model = new ModelLatexExtractor();

		bowlInstalled = false;
		mountInstalled = false;
		trunkScratched = false;
		drainTimer = 0;
		scratchTime = 0;
		latexAmt = 0;
		latexEst = 0;
		latexRemain = 0;
	}

	@Override
	public void updateEntity() {
		
		//if(!worldObj.isRemote)
		//{
			if (!isFlowing())
				return;
			
			int ticksPerUnit = TFC_Time.DAY_LENGTH / this.latexEst;
			if (TFC_Time.getTotalTicks() < this.drainTimer + ticksPerUnit)
				return;
			
			if (TFC_Time.getTotalTicks() >= this.scratchTime + TFC_Time.DAY_LENGTH) {
				this.drainTimer = 0;
				this.scratchTime = 0;
				this.latexAmt = this.latexAmt + this.latexRemain > Globals.LATEX_BOWL_CAPACITY ? Globals.LATEX_BOWL_CAPACITY : this.latexAmt + this.latexRemain;
				this.latexEst = 0;
				this.latexRemain = 0;
				this.worldObj.func_147479_m(xCoord, yCoord, zCoord);
				this.worldObj.markBlockForUpdate(xCoord, zCoord, zCoord);
				return;
			}
			
			long drainTicks = TFC_Time.getTotalTicks() - this.drainTimer;
			int unitsToDrain = MathHelper.floor_double(drainTicks * this.latexEst / TFC_Time.DAY_LENGTH);
			
			if (unitsToDrain > 0) {
				this.latexAmt += unitsToDrain;
				if (this.latexAmt > Globals.LATEX_BOWL_CAPACITY)
					this.latexAmt = Globals.LATEX_BOWL_CAPACITY;
				this.latexRemain -= unitsToDrain;
				this.drainTimer = TFC_Time.getTotalTicks();
				this.worldObj.func_147479_m(xCoord, yCoord, zCoord);
				this.worldObj.markBlockForUpdate(xCoord, zCoord, zCoord);
			}
		//}		
	}
	
	public void grabBowl(EntityPlayer ep) {
		if (ep != null && ep.getCurrentEquippedItem() == null && bowlInstalled) {
			ItemStack bowl = new ItemStack(ModItems.latexBowl, 1);
			int dmg = ((ItemModPotteryLatexBowl) bowl.getItem()).getDamageFromUnits(latexAmt);
			bowl.setItemDamage(dmg);
			bowlInstalled = false;
			latexAmt = 0;
			this.worldObj.func_147479_m(xCoord, yCoord, zCoord);
			this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			ep.inventory.addItemStackToInventory(bowl);
			this.worldObj.playSoundEffect(xCoord, yCoord, zCoord, ModSounds.BOWLGRAB, 1.0F, 1.0F + (this.worldObj.rand.nextFloat()/4)); 
		}
	}

	public void setBowl(ItemStack is) {
		if (is != null && is.getItem() instanceof ItemModPotteryLatexBowl) {
			latexAmt = ((ItemModPotteryLatexBowl) is.getItem()).getUnitsFromDamage(is.getItemDamage());
			bowlInstalled = true;
			this.worldObj.func_147479_m(xCoord, yCoord, zCoord);
			this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			is.stackSize--;
			this.worldObj.playSoundEffect(xCoord, yCoord, zCoord, ModSounds.BOWLFIT, 1.0F, 1.0F + (this.worldObj.rand.nextFloat()/4));
		}
	}

	public void setMount(ItemStack is) {
		if (is != null && is.getItem() instanceof ItemMount) {
			mountInstalled = true;
			this.worldObj.func_147479_m(xCoord, yCoord, zCoord);
			this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			is.stackSize--;
			this.worldObj.playSoundEffect(xCoord, yCoord, zCoord, ModSounds.MOUNTFIT, 1.0F, 1.0F + (this.worldObj.rand.nextFloat()/4));
		}
	}

	public void scratchTrunk(EntityPlayer ep, ItemStack is) {
		if (is != null && is.getItem() instanceof ItemKnife && isMountInstalled() && isBowlInstalled() && latexAmt < MAXAMT && drainTimer == 0) {

			Block block = worldObj.getBlock(xCoord, yCoord, zCoord);
			if (!(block instanceof BlockLatexExtractor))
				return;
			
			if (((BlockLatexExtractor)block).isTreeDead(worldObj, xCoord, yCoord, zCoord, rotation)) {
				if (ep != null && ep.worldObj.isRemote)
					TFC_Core.sendInfoMessage(ep, new ChatComponentTranslation("gui.latexTapping.treeIsDead"));
				return;
			}
			
			scratchTime = TFC_Time.getTotalTicks();
			drainTimer = TFC_Time.getTotalTicks();
			trunkScratched = true;
			this.worldObj.playSoundEffect(xCoord, yCoord, zCoord, ModSounds.SCRATCH, 1.0F, 1.0F + (this.worldObj.rand.nextFloat()/4));
			
			Random rand = new Random();

			// Amount of latex depends on the climate and agriculture skill
			int skill = (int) (200 * TFC_Core.getSkillStats(ep).getSkillMultiplier(Global.SKILL_AGRICULTURE));
			float ambientTemp = TFC_Climate.getHeightAdjustedTempSpecificDay(worldObj, TFC_Time.getDayOfYearFromTick(drainTimer), xCoord, yCoord, zCoord);
			float rainfall = TFC_Climate.getRainfall(worldObj, xCoord, yCoord, zCoord);

			float tempMult;
			if (ambientTemp < 0)
				tempMult = 0.25f;
			else if (ambientTemp >= 25 && ambientTemp <= 30)
				tempMult = 1.5f; // Comfortable temperature
			else
				tempMult = 0.75f;

			float rainMult;
			if (rainfall < 500)
				rainMult = 0.25f;
			else if (rainfall >= 1500)
				rainMult = 1f; // Abudant rainfall
			else
				rainMult = 0.5f;

			latexEst = (int) ((150 + skill + rand.nextInt(50)) * tempMult * rainMult);
			latexRemain = latexEst;
			
			if(TFCOptions.enableDebugMode && worldObj.isRemote) {
				TFCTech.LOG.info("Player skill (0-200): " + skill + ", Temp multiplier: " + tempMult + ", Rainfall multiplier: " + rainMult);
				TFCTech.LOG.info("Estimated latex amount (150 + skill + random(50) * tempMult * rainMult): " + latexEst);
			}
			
			this.worldObj.func_147479_m(xCoord, yCoord, zCoord);
			this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			is.damageItem(1, ep);
			ChunkCoordinates pos = ((BlockLatexExtractor) ModBlocks.latexExtractor).getTrunkBlockPosByRotation(worldObj, xCoord, yCoord, zCoord, rotation);
			damageTree(worldObj, pos.posX, pos.posY, pos.posZ);
		}
	}

	private void damageTree(World world, int x, int y, int z) {
		if (!ModOptions.cfgHeveaDamage)
			return;
		
		int yStart = -1;
		
		// Search for trunk start
		for (int curY = y; world.getBlock(x, curY, z) instanceof BlockModHeveaNatural; curY--) {
			yStart = curY;
		}
		
		if (yStart < 0)
			return; // Something wrong
		
		Block curBlock = world.getBlock(x, yStart, z);
		Block nextBlock = curBlock;
		int meta = world.getBlockMetadata(x, yStart, z) + 1; // Increase metadata (damage)
		
		if (meta > ModOptions.cfgHeveaMaxDamage) {
			if (curBlock == ModBlocks.logHeveaNatural)
				nextBlock = ModBlocks.logHeveaNatural1;
			else if (curBlock == ModBlocks.logHeveaNatural1)
				nextBlock = ModBlocks.logHeveaNatural2;
			else if (curBlock == ModBlocks.logHeveaNatural2)
				nextBlock = ModBlocks.logHeveaNatural3;
			else if (curBlock == ModBlocks.logHeveaNatural3)
				nextBlock = ModBlocks.logHeveaNaturalDead;
			else
				meta = ModOptions.cfgHeveaMaxDamage; // Something wrong
		}
		
		// Setting new damage value to all trunk blocks
		for (int curY = yStart; world.getBlock(x, curY, z) instanceof BlockModHeveaNatural; curY++) {
			if (curBlock != nextBlock) {
				world.setBlock(x, curY, z, nextBlock, 0, 0x2);
				if (nextBlock == ModBlocks.logHeveaNaturalDead) {
					for (int side = 0; side < 4; side ++)
						world.notifyBlocksOfNeighborChange(x, curY, z, nextBlock, side);
				}
			} else
				world.setBlockMetadataWithNotify(x, curY, z, meta, 0x2);
		}
	}

	public int getLatexAmount() {
		return latexAmt > MAXAMT ? MAXAMT : latexAmt;
	}

	public boolean isFlowing() {
		return drainTimer != 0;
	}

	public boolean isMountInstalled() {
		return mountInstalled;
	}

	public boolean isBowlInstalled() {
		return bowlInstalled;
	}

	public boolean isTrunkScratched() {
		return trunkScratched;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setLong("scratchTime", scratchTime);
		nbt.setLong("drainTimer", drainTimer);
		nbt.setInteger("latexAmt", latexAmt);
		nbt.setInteger("latexEst", latexEst);
		nbt.setInteger("latexRemain", latexRemain);
		nbt.setBoolean("mountInstalled", mountInstalled);
		nbt.setBoolean("bowlInstalled", bowlInstalled);
		nbt.setBoolean("trunkScratched", trunkScratched);
		nbt.setByte("rotation", rotation);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		scratchTime = nbt.getLong("scratchTime");
		drainTimer = nbt.getLong("drainTimer");
		latexAmt = nbt.getInteger("latexAmt");
		latexEst = nbt.getInteger("latexEst");
		latexRemain = nbt.getInteger("latexRemain");
		mountInstalled = nbt.getBoolean("mountInstalled");
		bowlInstalled = nbt.getBoolean("bowlInstalled");
		trunkScratched = nbt.getBoolean("trunkScratched");
		rotation = nbt.getByte("rotation");
	}

	@Override
	public void handleInitPacket(NBTTagCompound nbt) {
		this.scratchTime = nbt.getLong("scratchTime");
		this.drainTimer = nbt.getLong("drainTimer");
		this.latexAmt = nbt.getInteger("latexAmt");
		this.latexEst = nbt.getInteger("latexEst");
		this.latexRemain = nbt.getInteger("latexRemain");
		this.mountInstalled = nbt.getBoolean("mountInstalled");
		this.bowlInstalled = nbt.getBoolean("bowlInstalled");
		this.trunkScratched = nbt.getBoolean("trunkScratched");
		this.rotation = nbt.getByte("rotation");

		this.worldObj.func_147479_m(xCoord, yCoord, zCoord);
	}

	@Override
	public void createInitNBT(NBTTagCompound nbt) {
		nbt.setLong("scratchTime", scratchTime);
		nbt.setLong("drainTimer", drainTimer);
		nbt.setInteger("latexAmt", latexAmt);
		nbt.setInteger("latexEst", latexEst);
		nbt.setInteger("latexRemain", latexRemain);
		nbt.setBoolean("mountInstalled", mountInstalled);
		nbt.setBoolean("bowlInstalled", bowlInstalled);
		nbt.setBoolean("trunkScratched", trunkScratched);
		nbt.setByte("rotation", rotation);
	}

	public ModelLatexExtractor getModel() {
		if (worldObj.isRemote) {
			return model;
		}
		return null;
	}

	public void setModel(ModelLatexExtractor extractorModel) {
		if (worldObj.isRemote) {
			model = extractorModel;
		}
	}

	public ResourceLocation getResource() {
		return new ResourceLocation(ModDetails.ModID, "textures/blocks/devices/LatexExtractorModel.png");
	}

}
