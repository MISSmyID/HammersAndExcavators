package hammersr;

import hammersr.Items.HAEItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;


public class HammersAndExcavators implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
    public static final String MOD_ID = "hammersr";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
    public void onInitialize() {
        LOGGER.info("HammersAndExcavators initialized.");
    }


	@Override
	public void beforeGameStart() {
		HAEItems.initItems();
	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {
		HAERecipes.initRecipes();
	}

}
