package ua.pp.shurgent.tfctech.core;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import ua.pp.shurgent.tfctech.TFCTech;

public class ModFluids {

	public static Fluid LATEX;

	public static void initialize() {
		LATEX = new Fluid("latex").setDensity(2000).setViscosity(20000);

		FluidRegistry.registerFluid(LATEX);
	}

	public static void registerFluidContainers() {
		
		FluidContainerRegistry.registerFluidContainer(new FluidStack(LATEX, FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ModItems.steelBucketLatex),
				new ItemStack(ModItems.steelBucketEmpty));
		FluidContainerRegistry.registerFluidContainer(new FluidStack(LATEX, 200), new ItemStack(ModItems.latexBowl, 1, 2),
				new ItemStack(ModItems.latexBowl, 1, 1));
		
		if (TFCTech.enableBCEnergy) {
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("oil", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(
					ModItems.steelBucketOil), new ItemStack(ModItems.steelBucketEmpty));
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("fuel", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(
					ModItems.steelBucketFuel), new ItemStack(ModItems.steelBucketEmpty));
		}
	}

}
