package ua.pp.shurgent.tfctech.integration.bc;

import ua.pp.shurgent.tfctech.TFCTech;

import com.bioxx.tfc.api.Crafting.AnvilManager;

public class TFCTechBCRecipes {
	
	// === Buildcraft =========================================================
	
	public static void removeBCRecipes() {

		// == BC Core =========================================================
		if (TFCTech.enableBCCore) {
			TFCTechBCCore.removeRecipes();
		}

		// == BC Builders =====================================================
		if (TFCTech.enableBCBuilders) {
			TFCTechBCBuilders.removeRecipes();
		}

		// == BC Energy =======================================================
		//if (TFCTech.enableBCEnergy) {
			// Nothing to remove yet
		//}

		// == BC Factory ======================================================
		if (TFCTech.enableBCFactory) {
			TFCTechBCFactory.removeRecipes();
		}

		// == BC Robotics =====================================================
		if (TFCTech.enableBCRobotics) {
			TFCTechBCRobotics.removeRecipes();
		}

		// == BC Silicon ======================================================
		if (TFCTech.enableBCSilicon) {
			TFCTechBCSilicon.removeRecipes();
		}

		// == BC Transport ======================================================
		if (TFCTech.enableBCTransport) {
			TFCTechBCTransport.removeRecipes();
		}

	}

	public static void registerBCRecipes() {

		// == BC Core =========================================================
		if (TFCTech.enableBCCore) {
			TFCTechBCCore.registerRecipes();
		}

		// == BC Builders =====================================================
		if (TFCTech.enableBCBuilders) {
			TFCTechBCBuilders.registerRecipes();
		}

		// == BC Energy =======================================================
		//if (TFCTech.enableBCEnergy) {
			
		//}

		// == BC Factory ======================================================
		if (TFCTech.enableBCFactory) {
			TFCTechBCFactory.registerRecipes();
		}

		// == BC Robotics =====================================================
		if (TFCTech.enableBCRobotics) {
			TFCTechBCRobotics.registerRecipes();
		}

		// == BC Silicon ======================================================
		if (TFCTech.enableBCSilicon) {
			TFCTechBCSilicon.registerRecipes();
		}

		// == BC Transport ======================================================
		if (TFCTech.enableBCTransport) {
			TFCTechBCTransport.registerRecipes();
		}
	}
	
	public static void registerAnvilRecipes(AnvilManager anvilManager) {
		
		if (TFCTech.enableBCCore) {
			TFCTechBCCore.registerAnvilRecipes(anvilManager);
		}
		if (TFCTech.enableBCTransport) {
			TFCTechBCTransport.registerAnvilRecipes(anvilManager);
		}

	}
	
}
