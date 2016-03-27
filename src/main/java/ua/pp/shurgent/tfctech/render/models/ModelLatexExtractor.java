package ua.pp.shurgent.tfctech.render.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

public class ModelLatexExtractor extends ModelBase {

	ModelRenderer TexturePane;
	ModelRenderer TexturePaneL;

	ModelRenderer grooveright;
	ModelRenderer grooveleft;

	ModelRenderer latexhoriz;
	ModelRenderer latexcorner;
	ModelRenderer latexvert;
	ModelRenderer latexlevel;

	ModelRenderer mounttrunkfront;
	ModelRenderer mounttrunkrear;
	ModelRenderer mounttrunkleft;
	ModelRenderer mounttrunkright;

	ModelRenderer mountrear;
	ModelRenderer mountfront;
	ModelRenderer mountleft;
	ModelRenderer mountright;

	ModelRenderer bowlUF;
	ModelRenderer bowlUB;
	ModelRenderer bowlUL;
	ModelRenderer bowlUR;
	ModelRenderer bowlDF;
	ModelRenderer bowlDB;
	ModelRenderer bowlDL;
	ModelRenderer bowlDR;
	ModelRenderer bowlD;

	public boolean showMount = false;
	public boolean showLatex = false;
	public boolean showScratches = false;
	public boolean showBowl = false;
	public byte rotation = 0;
	public float latexLevel = 0; // 0 - empty; 1 - full

	public ModelLatexExtractor() {
		textureWidth = 64;
		textureHeight = 64;

		TexturePane = new ModelRenderer(this, 0, 16);
		TexturePane.addBox(0F, 0F, 0F, 16, 16, 0);
		TexturePane.setRotationPoint(-8F, 8F, 7.9F);
		TexturePane.setTextureSize(64, 64);
		TexturePane.mirror = true;
		setRotation(TexturePane, 0F, 0F, 0F);

		TexturePaneL = new ModelRenderer(this, 0, 0);
		TexturePaneL.addBox(0F, 0F, 0F, 16, 16, 0);
		TexturePaneL.setRotationPoint(-8F, 8F, 7.9F);
		TexturePaneL.setTextureSize(64, 64);
		TexturePaneL.mirror = true;
		setRotation(TexturePaneL, 0F, 0F, 0F);

		grooveright = new ModelRenderer(this, 33, 0);
		grooveright.addBox(0F, 0F, -3F, 2, 0, 3);
		grooveright.setRotationPoint(0.5F, 16F, 8F);
		grooveright.setTextureSize(64, 64);
		grooveright.mirror = true;
		setRotationDegrees(grooveright, 15F, 15F, -45F);
		grooveleft = new ModelRenderer(this, 33, 0);
		grooveleft.addBox(0F, 0F, -3F, 2, 0, 3);
		grooveleft.setRotationPoint(0.5F, 16F, 8F);
		grooveleft.setTextureSize(64, 64);
		grooveleft.mirror = true;
		setRotationDegrees(grooveleft, -15F, 15F, -135F);

		latexhoriz = new ModelRenderer(this, 42, 0);
		latexhoriz.addBox(0F, 0F, -3.5F, 1, 1, 4);
		latexhoriz.setRotationPoint(0.5F, 15.9F, 8F);
		latexhoriz.setTextureSize(64, 64);
		latexhoriz.mirror = true;
		setRotationDegrees(latexhoriz, -15F, 15F, -135F);
		latexcorner = new ModelRenderer(this, 53, 0);
		latexcorner.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		latexcorner.setRotationPoint(0.5F, 16.6F, 4.6F);
		latexcorner.setTextureSize(64, 64);
		latexcorner.mirror = true;
		setRotationDegrees(latexcorner, -40F, -40F, 28F);
		latexvert = new ModelRenderer(this, 53, 0);
		latexvert.addBox(-0.5F, -0.5F, -0.5F, 1, 7, 1);
		latexvert.setRotationPoint(0.5F, 17.2F, 4.5F);
		latexvert.setTextureSize(64, 64);
		latexvert.mirror = true;
		setRotationDegrees(latexvert, 0F, 45F, 0F);

		latexlevel = new ModelRenderer(this, 40, 57);
		latexlevel.addBox(-3F, 3F, -3F, 6, 1, 6);
		latexlevel.setRotationPoint(0F, 19F, 2F);
		latexlevel.setTextureSize(64, 64);
		latexlevel.mirror = true;
		setRotation(latexlevel, 0F, 0F, 0F);

		mounttrunkfront = new ModelRenderer(this, 0, 55);
		mounttrunkfront.addBox(-9F, 0F, 0F, 18, 1, 1);
		mounttrunkfront.setRotationPoint(0F, 19F, 7F);
		mounttrunkfront.setTextureSize(64, 64);
		mounttrunkfront.mirror = true;
		setRotation(mounttrunkfront, 0F, 0F, 0F);
		mounttrunkrear = new ModelRenderer(this, 0, 55);
		mounttrunkrear.addBox(-9F, 0F, 17F, 18, 1, 1);
		mounttrunkrear.setRotationPoint(0F, 19F, 7F);
		mounttrunkrear.setTextureSize(64, 64);
		mounttrunkrear.mirror = true;
		setRotation(mounttrunkrear, 0F, 0F, 0F);
		mounttrunkleft = new ModelRenderer(this, 0, 37);
		mounttrunkleft.addBox(-9F, 0F, 1F, 1, 1, 16);
		mounttrunkleft.setRotationPoint(0F, 19F, 7F);
		mounttrunkleft.setTextureSize(64, 64);
		mounttrunkleft.mirror = true;
		setRotation(mounttrunkleft, 0F, 0F, 0F);
		mounttrunkright = new ModelRenderer(this, 0, 37);
		mounttrunkright.addBox(8F, 0F, 1F, 1, 1, 16);
		mounttrunkright.setRotationPoint(0F, 19F, 7F);
		mounttrunkright.setTextureSize(64, 64);
		mounttrunkright.mirror = true;
		setRotation(mounttrunkright, 0F, 0F, 0F);
		mountrear = new ModelRenderer(this, 0, 58);
		mountrear.addBox(-5F, 0F, 0F, 10, 1, 1);
		mountrear.setRotationPoint(0F, 20F, 6F);
		mountrear.setTextureSize(64, 64);
		mountrear.mirror = true;
		setRotation(mountrear, 0F, 0F, 0F);
		mountfront = new ModelRenderer(this, 0, 58);
		mountfront.addBox(-5F, 0F, 0F, 10, 1, 1);
		mountfront.setRotationPoint(0F, 20F, -3F);
		mountfront.setTextureSize(64, 64);
		mountfront.mirror = true;
		setRotation(mountfront, 0F, 0F, 0F);
		mountleft = new ModelRenderer(this, 35, 37);
		mountleft.addBox(-5F, 0F, -9F, 1, 1, 8);
		mountleft.setRotationPoint(0F, 20F, 7F);
		mountleft.setTextureSize(64, 64);
		mountleft.mirror = true;
		setRotation(mountleft, 0F, 0F, 0F);
		mountright = new ModelRenderer(this, 35, 37);
		mountright.addBox(4F, 0F, -9F, 1, 1, 8);
		mountright.setRotationPoint(0F, 20F, 7F);
		mountright.setTextureSize(64, 64);
		mountright.mirror = true;
		setRotation(mountright, 0F, 0F, 0F);

		bowlUF = new ModelRenderer(this, 33, 10);
		bowlUF.addBox(-5F, 0F, -5F, 10, 1, 1);
		bowlUF.setRotationPoint(0F, 19F, 2F);
		bowlUF.setTextureSize(64, 64);
		bowlUF.mirror = true;
		setRotation(bowlUF, 0F, 0F, 0F);
		bowlUB = new ModelRenderer(this, 33, 10);
		bowlUB.addBox(-5F, 0F, 4F, 10, 1, 1);
		bowlUB.setRotationPoint(0F, 19F, 2F);
		bowlUB.setTextureSize(64, 64);
		bowlUB.mirror = true;
		setRotation(bowlUB, 0F, 0F, 0F);
		bowlUL = new ModelRenderer(this, 33, 13);
		bowlUL.addBox(-5F, 0F, -4F, 1, 1, 8);
		bowlUL.setRotationPoint(0F, 19F, 2F);
		bowlUL.setTextureSize(64, 64);
		bowlUL.mirror = true;
		setRotation(bowlUL, 0F, 0F, 0F);
		bowlUR = new ModelRenderer(this, 33, 13);
		bowlUR.addBox(4F, 0F, -4F, 1, 1, 8);
		bowlUR.setRotationPoint(0F, 19F, 2F);
		bowlUR.setTextureSize(64, 64);
		bowlUR.mirror = true;
		setRotation(bowlUR, 0F, 0F, 0F);
		bowlDF = new ModelRenderer(this, 33, 23);
		bowlDF.addBox(-4F, 0F, -4F, 8, 4, 1);
		bowlDF.setRotationPoint(0F, 19F, 2F);
		bowlDF.setTextureSize(64, 64);
		bowlDF.mirror = true;
		setRotation(bowlDF, 0F, 0F, 0F);
		bowlDB = new ModelRenderer(this, 33, 23);
		bowlDB.addBox(-4F, 0F, 3F, 8, 4, 1);
		bowlDB.setRotationPoint(0F, 19F, 2F);
		bowlDB.setTextureSize(64, 64);
		bowlDB.mirror = true;
		setRotation(bowlDB, 0F, 0F, 0F);
		bowlDL = new ModelRenderer(this, 40, 47);
		bowlDL.addBox(-4F, 0F, -3F, 1, 4, 6);
		bowlDL.setRotationPoint(0F, 19F, 2F);
		bowlDL.setTextureSize(64, 64);
		bowlDL.mirror = true;
		setRotation(bowlDL, 0F, 0F, 0F);
		bowlDR = new ModelRenderer(this, 40, 47);
		bowlDR.addBox(3F, 0F, -3F, 1, 4, 6);
		bowlDR.setRotationPoint(0F, 19F, 2F);
		bowlDR.setTextureSize(64, 64);
		bowlDR.mirror = true;
		setRotation(bowlDR, 0F, 0F, 0F);
		bowlD = new ModelRenderer(this, 33, 29);
		bowlD.addBox(-3F, 4F, -3F, 6, 1, 6);
		bowlD.setRotationPoint(0F, 19F, 2F);
		bowlD.setTextureSize(64, 64);
		bowlD.mirror = true;
		setRotation(bowlD, 0F, 0F, 0F);
	}

	/**
	 * Sets the rotation on a model where the provided params are in radians
	 * 
	 * @param model
	 *            The model
	 * @param x
	 *            The x angle
	 * @param y
	 *            The y angle
	 * @param z
	 *            The z angle
	 */
	protected void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	/**
	 * Sets the rotation on a model where the provided params are in degrees
	 * 
	 * @param model
	 *            The model
	 * @param x
	 *            The x angle
	 * @param y
	 *            The y angle
	 * @param z
	 *            The z angle
	 */
	protected void setRotationDegrees(ModelRenderer model, float x, float y, float z) {
		this.setRotation(model, (float) Math.toRadians(x), (float) Math.toRadians(y), (float) Math.toRadians(z));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		GL11.glPushMatrix();
		GL11.glRotatef(this.rotation * -90F, 0, 1, 0);
		switch (this.rotation) {
		case 0:
			GL11.glTranslatef(0.5f, 1.5f, 0.5f);
			break;
		case 1:
			GL11.glTranslatef(0.5f, 1.5f, -0.5f);
			break;
		case 2:
			GL11.glTranslatef(-0.5f, 1.5f, -0.5f);
			break;
		case 3:
			GL11.glTranslatef(-0.5f, 1.5f, 0.5f);
			break;
		default:
			break;
		}

		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

		this.grooveleft.render(f5);
		this.grooveright.render(f5);

		if (showScratches) {
			if (showLatex)
				this.TexturePaneL.render(f5);
			else
				this.TexturePane.render(f5);
		}

		if (showMount) {
			this.mountfront.render(f5);
			this.mountleft.render(f5);
			this.mountright.render(f5);
			this.mountrear.render(f5);
			this.mounttrunkfront.render(f5);
			this.mounttrunkleft.render(f5);
			this.mounttrunkright.render(f5);
			this.mounttrunkrear.render(f5);
		}

		if (showBowl) {
			this.bowlD.render(f5);
			this.bowlDB.render(f5);
			this.bowlDF.render(f5);
			this.bowlDL.render(f5);
			this.bowlDR.render(f5);
			this.bowlUB.render(f5);
			this.bowlUF.render(f5);
			this.bowlUL.render(f5);
			this.bowlUR.render(f5);
		}

		if (showLatex && showBowl) {
			this.latexhoriz.render(f5);
			this.latexcorner.render(f5);
			this.latexvert.render(f5);
		}

		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	@Override
	public void setRotationAngles(float f0, float f1, float f2, float f3, float f4, float f5, Entity ent) {
		super.setRotationAngles(f0, f1, f2, f3, f4, f5, ent);
	}
}
