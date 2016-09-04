package ua.pp.shurgent.tfctech.render.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

/**
 * ModelInductionSmelter - Shurgent Created using Tabula 4.1.1
 */
public class ModelInductionSmelter extends ModelBase {
	public ModelRenderer wall1;
	public ModelRenderer wall2;
	public ModelRenderer wall3;
	public ModelRenderer wall4;
	public ModelRenderer wall5;
	public ModelRenderer back;
	public ModelRenderer ind1f;
	public ModelRenderer ind2f;
	public ModelRenderer ind3f;
	public ModelRenderer ind4f;
	public ModelRenderer ind1r;
	public ModelRenderer ind2r;
	public ModelRenderer ind3r;
	public ModelRenderer ind4r;
	public ModelRenderer ind1l;
	public ModelRenderer ind2l;
	public ModelRenderer ind3l;
	public ModelRenderer ind4l;
	public ModelRenderer ind1bl;
	public ModelRenderer ind2bl;
	public ModelRenderer ind3bl;
	public ModelRenderer ind4bl;
	public ModelRenderer ind1br;
	public ModelRenderer ind2br;
	public ModelRenderer ind3br;
	public ModelRenderer ind4br;
	
	public byte rotation = 0;
	
	public ModelInductionSmelter() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.wall3 = new ModelRenderer(this, 64, 16);
		this.wall3.setRotationPoint(0.0F, 10.0F, 0.0F);
		this.wall3.addBox(-7.0F, 0.0F, 5.0F, 14, 12, 2, 0.0F);
		this.ind2bl = new ModelRenderer(this, 64, 32);
		this.ind2bl.setRotationPoint(0.0F, 15.0F, 0.0F);
		this.ind2bl.addBox(-7.0F, 0.0F, 7.0F, 2, 1, 1, 0.0F);
		this.wall4 = new ModelRenderer(this, 100, 0);
		this.wall4.setRotationPoint(-7.0F, 10.0F, -5.0F);
		this.wall4.addBox(0.0F, 0.0F, 0.0F, 2, 12, 10, 0.0F);
		this.ind4l = new ModelRenderer(this, 32, 32);
		this.ind4l.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.ind4l.addBox(-8.0F, 0.0F, -7.0F, 1, 1, 15, 0.0F);
		this.back = new ModelRenderer(this, 32, 16);
		this.back.setRotationPoint(0.0F, 11.0F, 0.0F);
		this.back.addBox(-5.0F, 0.0F, 7.0F, 10, 10, 1, 0.0F);
		this.ind1br = new ModelRenderer(this, 64, 32);
		this.ind1br.setRotationPoint(0.0F, 13.0F, 0.0F);
		this.ind1br.addBox(5.0F, 0.0F, 7.0F, 2, 1, 1, 0.0F);
		this.ind2r = new ModelRenderer(this, 32, 32);
		this.ind2r.setRotationPoint(0.0F, 15.0F, 0.0F);
		this.ind2r.addBox(7.0F, 0.0F, -7.0F, 1, 1, 15, 0.0F);
		this.ind3bl = new ModelRenderer(this, 64, 32);
		this.ind3bl.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.ind3bl.addBox(-7.0F, 0.0F, 7.0F, 2, 1, 1, 0.0F);
		this.ind3br = new ModelRenderer(this, 64, 32);
		this.ind3br.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.ind3br.addBox(5.0F, 0.0F, 7.0F, 2, 1, 1, 0.0F);
		this.wall5 = new ModelRenderer(this, 100, 0);
		this.wall5.mirror = true;
		this.wall5.setRotationPoint(5.0F, 10.0F, -5.0F);
		this.wall5.addBox(0.0F, 0.0F, 0.0F, 2, 12, 10, 0.0F);
		this.ind1r = new ModelRenderer(this, 32, 32);
		this.ind1r.setRotationPoint(0.0F, 13.0F, 0.0F);
		this.ind1r.addBox(7.0F, 0.0F, -7.0F, 1, 1, 15, 0.0F);
		this.ind2f = new ModelRenderer(this, 0, 32);
		this.ind2f.setRotationPoint(0.0F, 15.0F, 0.0F);
		this.ind2f.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 1, 0.0F);
		this.wall1 = new ModelRenderer(this, 0, 0);
		this.wall1.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.wall1.addBox(-7.0F, 0.0F, -7.0F, 14, 2, 14, 0.0F);
		this.ind4br = new ModelRenderer(this, 64, 32);
		this.ind4br.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.ind4br.addBox(5.0F, 0.0F, 7.0F, 2, 1, 1, 0.0F);
		this.ind1bl = new ModelRenderer(this, 64, 32);
		this.ind1bl.setRotationPoint(0.0F, 13.0F, 0.0F);
		this.ind1bl.addBox(-7.0F, 0.0F, 7.0F, 2, 1, 1, 0.0F);
		this.ind4r = new ModelRenderer(this, 32, 32);
		this.ind4r.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.ind4r.addBox(7.0F, 0.0F, -7.0F, 1, 1, 15, 0.0F);
		this.ind2l = new ModelRenderer(this, 32, 32);
		this.ind2l.setRotationPoint(0.0F, 15.0F, 0.0F);
		this.ind2l.addBox(-8.0F, 0.0F, -7.0F, 1, 1, 15, 0.0F);
		this.ind3l = new ModelRenderer(this, 32, 32);
		this.ind3l.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.ind3l.addBox(-8.0F, 0.0F, -7.0F, 1, 1, 15, 0.0F);
		this.ind4f = new ModelRenderer(this, 0, 32);
		this.ind4f.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.ind4f.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 1, 0.0F);
		this.ind1l = new ModelRenderer(this, 32, 32);
		this.ind1l.setRotationPoint(0.0F, 13.0F, 0.0F);
		this.ind1l.addBox(-8.0F, 0.0F, -7.0F, 1, 1, 15, 0.0F);
		this.wall2 = new ModelRenderer(this, 64, 0);
		this.wall2.setRotationPoint(0.0F, 10.0F, 0.0F);
		this.wall2.addBox(-7.0F, 0.0F, -7.0F, 14, 12, 2, 0.0F);
		this.ind1f = new ModelRenderer(this, 0, 32);
		this.ind1f.setRotationPoint(0.0F, 13.0F, 0.0F);
		this.ind1f.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 1, 0.0F);
		this.ind2br = new ModelRenderer(this, 64, 32);
		this.ind2br.setRotationPoint(0.0F, 15.0F, 0.0F);
		this.ind2br.addBox(5.0F, 0.0F, 7.0F, 2, 1, 1, 0.0F);
		this.ind3r = new ModelRenderer(this, 32, 32);
		this.ind3r.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.ind3r.addBox(7.0F, 0.0F, -7.0F, 1, 1, 15, 0.0F);
		this.ind4bl = new ModelRenderer(this, 64, 32);
		this.ind4bl.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.ind4bl.addBox(-7.0F, 0.0F, 7.0F, 2, 1, 1, 0.0F);
		this.ind3f = new ModelRenderer(this, 0, 32);
		this.ind3f.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.ind3f.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 1, 0.0F);
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
		
		this.wall3.render(f5);
		this.ind2bl.render(f5);
		this.wall4.render(f5);
		this.ind4l.render(f5);
		this.back.render(f5);
		this.ind1br.render(f5);
		this.ind2r.render(f5);
		this.ind3bl.render(f5);
		this.ind3br.render(f5);
		this.wall5.render(f5);
		this.ind1r.render(f5);
		this.ind2f.render(f5);
		this.wall1.render(f5);
		this.ind4br.render(f5);
		this.ind1bl.render(f5);
		this.ind4r.render(f5);
		this.ind2l.render(f5);
		this.ind3l.render(f5);
		this.ind4f.render(f5);
		this.ind1l.render(f5);
		this.wall2.render(f5);
		this.ind1f.render(f5);
		this.ind2br.render(f5);
		this.ind3r.render(f5);
		this.ind4bl.render(f5);
		this.ind3f.render(f5);
		
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
	}
	
	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float f0, float f1, float f2, float f3, float f4, float f5, Entity ent) {
		super.setRotationAngles(f0, f1, f2, f3, f4, f5, ent);
	}
}
