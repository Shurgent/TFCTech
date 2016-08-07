package ua.pp.shurgent.tfctech.render.models;

import java.util.HashMap;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

/**
 * ModelWireDrawBench - Shurgent Created using Tabula 4.1.1
 */
public class ModelWireDrawBench extends ModelBase {
	
	public static final float P = 0.0625F;
	public static HashMap<String, ModelRenderer> Drawplates = new HashMap<String, ModelRenderer>();
	
	public ModelRenderer Leg1;
	public ModelRenderer Leg2;
	public ModelRenderer Leg3;
	public ModelRenderer Leg4;
	public ModelRenderer Tabletop;
	public ModelRenderer Stiffener1;
	public ModelRenderer Stiffener2;
	public ModelRenderer Support1;
	public ModelRenderer Support2;
	public ModelRenderer Stop1;
	public ModelRenderer Stop2;
	
	public ModelRenderer Barrel;
	public ModelRenderer Shaft;
	public ModelRenderer Holder;
	public ModelRenderer Handle1;
	public ModelRenderer Handle2;
	
	public ModelRenderer Belt;
	public ModelRenderer Belt0;
	public ModelRenderer Belt1;
	public ModelRenderer Belt2;
	public ModelRenderer Belt3;
	public ModelRenderer Ring1;
	public ModelRenderer Ring2;
	public ModelRenderer Ring3;
	public ModelRenderer Ring4;
	public ModelRenderer Tongs1;
	public ModelRenderer Tongs2;
	public ModelRenderer Tongs3;
	
	public byte progress;
	
	public boolean isDrawplateInstalled = false;
	public String drawplateMetal;
	public boolean isWireInstalled = false;
	
	public byte rotation = 0;
	public boolean isHeadBlock = true;
	
	public ModelWireDrawBench() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		
		// Static parts
		this.Leg1 = new ModelRenderer(this, 0, 0);
		this.Leg1.setRotationPoint(-6.0F, 18.0F, -6.0F);
		this.Leg1.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
		this.Leg2 = new ModelRenderer(this, 0, 0);
		this.Leg2.setRotationPoint(1.0F, 18.0F, -6.0F);
		this.Leg2.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
		this.Leg3 = new ModelRenderer(this, 0, 0);
		this.Leg3.setRotationPoint(1.0F, 18.0F, 20.0F);
		this.Leg3.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
		this.Leg4 = new ModelRenderer(this, 0, 0);
		this.Leg4.setRotationPoint(-6.0F, 18.0F, 20.0F);
		this.Leg4.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
		this.Tabletop = new ModelRenderer(this, 0, 0);
		this.Tabletop.setRotationPoint(-7.0F, 17.0F, -7.0F);
		this.Tabletop.addBox(0.0F, 0.0F, 0.0F, 11, 1, 30, 0.0F);
		this.Stiffener1 = new ModelRenderer(this, 0, 0);
		this.Stiffener1.setRotationPoint(-6.0F, 19.0F, -4.0F);
		this.Stiffener1.addBox(0.0F, 0.0F, 0.0F, 9, 2, 1, 0.0F);
		this.Stiffener2 = new ModelRenderer(this, 0, 0);
		this.Stiffener2.setRotationPoint(-6.0F, 19.0F, 19.0F);
		this.Stiffener2.addBox(0.0F, 0.0F, 0.0F, 9, 2, 1, 0.0F);
		this.Support1 = new ModelRenderer(this, 0, 0);
		this.Support1.setRotationPoint(1.0F, 13.0F, -5.0F);
		this.Support1.addBox(0.0F, 0.0F, 0.0F, 1, 4, 3, 0.0F);
		this.Support2 = new ModelRenderer(this, 0, 0);
		this.Support2.setRotationPoint(-5.0F, 13.0F, -5.0F);
		this.Support2.addBox(0.0F, 0.0F, 0.0F, 1, 4, 3, 0.0F);
		this.Stop1 = new ModelRenderer(this, 0, 0);
		this.Stop1.setRotationPoint(-5.0F, 14.0F, 14.0F);
		this.Stop1.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
		this.Stop2 = new ModelRenderer(this, 0, 0);
		this.Stop2.setRotationPoint(0.0F, 14.0F, 14.0F);
		this.Stop2.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
		
		// Winch parts
		this.Barrel = new ModelRenderer(this, 83, 14);
		this.Barrel.setRotationPoint(-4.0F, 14.466666221618652F, -3.5F);
		this.Barrel.addBox(0.0F, -1.0F, -1.0F, 5, 2, 2, 0.0F);
		this.Shaft = new ModelRenderer(this, 0, 0);
		this.Shaft.setRotationPoint(-4.0F, 14.5F, -3.5F);
		this.Shaft.addBox(-2.0F, -0.5F, -0.5F, 13, 1, 1, 0.0F);
		this.Holder = new ModelRenderer(this, 0, 0);
		this.Holder.setRotationPoint(4.5F, 14.5F, -3.5F);
		this.Holder.addBox(0.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
		this.Handle1 = new ModelRenderer(this, 0, 0);
		this.Handle1.setRotationPoint(5.0F, 14.5F, -3.5F);
		this.Handle1.addBox(0.0F, -6.5F, -0.5F, 1, 13, 1, 0.0F);
		this.setRotateAngle(Handle1, 0.7853981852531433F, -0.0F, 0.0F);
		this.Handle2 = new ModelRenderer(this, 0, 0);
		this.Handle2.setRotationPoint(5.0F, 14.5F, -3.5F);
		this.Handle2.addBox(0.0F, -0.5F, -6.5F, 1, 1, 13, 0.0F);
		this.setRotateAngle(Handle2, 0.7853981852531433F, -0.0F, 0.0F);
		
		// Belt
		this.Belt = new ModelRenderer(this, 100, 0);
		this.Belt.setRotationPoint(-3.0F, 15.0F, 5.0F);
		this.Belt.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
		this.Belt0 = new ModelRenderer(this, 83, 0);
		this.Belt0.setRotationPoint(-3.0F, 15.0F, -3.0F);
		this.Belt0.addBox(0.0F, 0.0F, 0.0F, 3, 1, 2, 0.0F);
		this.Belt1 = new ModelRenderer(this, 83, 3);
		this.Belt1.setRotationPoint(-3.0F, 15.0F, -1.0F);
		this.Belt1.addBox(0.0F, 0.0F, 0.0F, 3, 1, 2, 0.0F);
		this.Belt2 = new ModelRenderer(this, 83, 6);
		this.Belt2.setRotationPoint(-3.0F, 15.0F, 1.0F);
		this.Belt2.addBox(0.0F, 0.0F, 0.0F, 3, 1, 2, 0.0F);
		this.Belt3 = new ModelRenderer(this, 83, 9);
		this.Belt3.setRotationPoint(-3.0F, 15.0F, 3.0F);
		this.Belt3.addBox(0.0F, 0.0F, 0.0F, 3, 1, 2, 0.0F);
		
		// Tongs
		this.Ring1 = new ModelRenderer(this, 83, 20);
		this.Ring1.setRotationPoint(-2.0F, 15.0F, 11.0F);
		this.Ring1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.Ring2 = new ModelRenderer(this, 83, 26);
		this.Ring2.setRotationPoint(0.0F, 15.0F, 8.0F);
		this.Ring2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
		this.Ring3 = new ModelRenderer(this, 83, 26);
		this.Ring3.setRotationPoint(-4.0F, 15.0F, 8.0F);
		this.Ring3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
		this.Ring4 = new ModelRenderer(this, 83, 8);
		this.Ring4.setRotationPoint(-3.0F, 15.0F, 8.0F);
		this.Ring4.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		this.Tongs1 = new ModelRenderer(this, 100, 14);
		this.Tongs1.setRotationPoint(-1.5F, 15.0F, 13.0F);
		this.Tongs1.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
		this.Tongs2 = new ModelRenderer(this, 100, 18);
		this.Tongs2.setRotationPoint(-3.0F, 15.0F, 10.0F);
		this.Tongs2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
		this.Tongs3 = new ModelRenderer(this, 110, 18);
		this.Tongs3.setRotationPoint(-1.0F, 15.0F, 10.0F);
		this.Tongs3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
		
		// Drawplates
		Drawplates.put("Wrought Iron", getDrawplateModel(23));
		Drawplates.put("Steel", getDrawplateModel(26));
		Drawplates.put("Black Steel", getDrawplateModel(29));
		
	}
	
	private ModelRenderer getDrawplateModel(int offsetY) {
		ModelRenderer result = new ModelRenderer(this, 95, offsetY);
		result.setRotationPoint(-5.0F, 14.5F, 16.0F);
		result.addBox(0.0F, 0.0F, 0.0F, 7, 2, 1, 0.0F);
		return result;
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		
		if (!this.isHeadBlock)
			return;
		
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
		
		this.Leg1.render(f5);
		this.Leg2.render(f5);
		this.Leg3.render(f5);
		this.Leg4.render(f5);
		this.Tabletop.render(f5);
		this.Stiffener1.render(f5);
		this.Stiffener2.render(f5);
		this.Support1.render(f5);
		this.Support2.render(f5);
		this.Stop1.render(f5);
		this.Stop2.render(f5);
		
		float angle = -360 / 100 * this.progress;
		setRotateAngleInDegrees(this.Barrel, angle, 0, 0);
		setRotateAngleInDegrees(this.Shaft, angle, 0, 0);
		setRotateAngleInDegrees(this.Holder, angle, 0, 0);
		setRotateAngleInDegrees(this.Handle1, angle, 0, 0);
		setRotateAngleInDegrees(this.Handle2, angle, 0, 0);
		
		this.Barrel.render(f5);
		this.Shaft.render(f5);
		this.Holder.render(f5);
		this.Handle1.render(f5);
		this.Handle2.render(f5);
		
		setBeltOffset(this.Ring1, 99); 
		setBeltOffset(this.Ring2, 99); 
		setBeltOffset(this.Ring3, 99); 
		setBeltOffset(this.Ring4, 99); 
		setBeltOffset(this.Tongs1, 99); 
		setBeltOffset(this.Tongs2, 99); 
		setBeltOffset(this.Tongs3, 99); 
		setBeltOffset(this.Belt, 99); 
		setBeltOffset(this.Belt0, 15);
		setBeltOffset(this.Belt1, 45);
		setBeltOffset(this.Belt2, 75);
		setBeltOffset(this.Belt3, 90);
		
		if (this.progress > 99) {
			
			setBeltFall(this.Ring1, false); 
			setBeltFall(this.Ring2, false); 
			setBeltFall(this.Ring3, false); 
			setBeltFall(this.Ring4, false); 
			setBeltFall(this.Tongs1, false); 
			setBeltFall(this.Tongs2, false); 
			setBeltFall(this.Tongs3, false); 
			setBeltFall(this.Belt, true); 
			
		} else {
			
			this.Ring1.offsetY = 0;
			this.Ring2.offsetY = 0;
			this.Ring3.offsetY = 0;
			this.Ring4.offsetY = 0;
			this.Tongs1.offsetY = 0;
			this.Tongs2.offsetY = 0;
			this.Tongs3.offsetY = 0;
			setRotateAngleInDegrees(this.Belt, 0, 0, 0);
			
		}
		
		this.Belt.render(f5);
		this.Belt0.render(f5);
		this.Belt1.render(f5);
		this.Belt2.render(f5);
		this.Belt3.render(f5);
		this.Ring1.render(f5);
		this.Ring2.render(f5);
		this.Ring3.render(f5);
		this.Ring4.render(f5);
		this.Tongs1.render(f5);
		this.Tongs2.render(f5);
		this.Tongs3.render(f5);
		
		if (isDrawplateInstalled) {
			ModelRenderer drawplate = Drawplates.get(this.drawplateMetal);
			drawplate.render(f5);
		}
		
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	
	public void setBeltOffset(ModelRenderer modelRenderer, int maxProgress) {
		float off = 7F * P / 99F * Math.min(this.progress, maxProgress);
		modelRenderer.offsetZ = -off;
	}
	
	public void setBeltFall(ModelRenderer modelRenderer, boolean belt) {
		if (belt) {
			setRotateAngleInDegrees(modelRenderer, -15, 0, 0);
		} else {
			modelRenderer.offsetZ = -8F * P;
			modelRenderer.offsetY = P;
		}
	}
	
	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	public void setRotateAngleInDegrees(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = (float) (x * Math.PI / 180);
		modelRenderer.rotateAngleY = (float) (y * Math.PI / 180);
		modelRenderer.rotateAngleZ = (float) (z * Math.PI / 180);
	}
	
	public void setDrawplateMetal(String metal) {
		this.drawplateMetal = metal != null ? metal : "";
	}
	
}
