package hammersr;

import hammersr.Items.HAEItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryRepairable;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.RecipeBuilder;


public class HAERecipes {
	private static final String MOD_ID;

	static {
		MOD_ID = HammersAndExcavators.MOD_ID;
	}

	private static int repairStackRecipeId = 0;
	public static void addRepairableRecipe(Item inItem, Item repairMaterial){
		Registries.RECIPES.addCustomRecipe("minecraft:workbench/repair_stackable_recipe_" + repairStackRecipeId, new RecipeEntryRepairable(inItem, repairMaterial));
		++repairStackRecipeId;
	}
	public static void initRecipes() {
		//repairKits
		RecipeBuilder.Shaped(MOD_ID).setShape(" / ", "# #", "###").addInput('/', Item.stick).addInput('#', Block.planksOak).create("repairkitEmpty", new ItemStack(HAEItems.repairkitEmpty, 1));
		RecipeBuilder.Shapeless(MOD_ID).addInput(HAEItems.repairkitEmpty).addInput(Item.ingotIron).addInput(Item.ingotIron).create("repairkitIron", new ItemStack(HAEItems.repairkitIron, 1));
		RecipeBuilder.Shapeless(MOD_ID).addInput(HAEItems.repairkitEmpty).addInput(Item.ingotGold).addInput(Item.ingotGold).create("repairkitGold", new ItemStack(HAEItems.repairkitGold, 1));
		RecipeBuilder.Shapeless(MOD_ID).addInput(HAEItems.repairkitEmpty).addInput(Item.ingotSteel).addInput(Item.ingotSteel).create("repairkitSteel", new ItemStack(HAEItems.repairkitSteel, 1));
		RecipeBuilder.Shapeless(MOD_ID).addInput(HAEItems.repairkitEmpty).addInput(Item.diamond).addInput(Item.diamond).create("repairkitDiamond", new ItemStack(HAEItems.repairkitDiamond, 1));

		//Blocks
		RecipeBuilder.Shaped(MOD_ID).setShape("BIB", "IOI", "BIB").addInput('B',Item.diamond).addInput('O',Block.blockSteel).addInput('I',Item.ingotSteel).create("DiamondSteelBlock",new ItemStack(HAEItems.diamondSteelBlock, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape("LPL", "PCP", "LPL").addInput('L',Block.logOak).addInput('C',Item.coal).addInput('P',Block.planksOak).create("HardenedLog",new ItemStack(HAEItems.HardenedLog, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape("SCS", "CSC", "SCS").addInput('S',Block.stonePolished).addInput('C',Block.cobbleStone).create("HardenedCobble",new ItemStack(HAEItems.HardenedCobble, 1));
		//Hammers
		RecipeBuilder.Shaped(MOD_ID).setShape("BOB", "OSO", " S ").addInput('B', HAEItems.HardenedLog).addInput('O', Block.planksOak).addInput('S',Item.stick).create("WoodenHammer", new ItemStack(HAEItems.hammerWooden, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape("BOB", "OSO", " S ").addInput('B', HAEItems.HardenedLog).addInput('O', Block.planksOakPainted.withDisabledNeighborNotifyOnMetadataChange()).addInput('S',Item.stick).create("PWoodenHammer", new ItemStack(HAEItems.hammerWooden, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape("BOB", "OSO", " S ").addInput('B', HAEItems.HardenedCobble).addInput('O', Block.stone).addInput('S',Item.stick).create("StoneHammer", new ItemStack(HAEItems.hammerStone, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape("BOB", "OSO", " S ").addInput('B',Block.blockIron).addInput('O', Item.ingotIron).addInput('S',Item.stick).create("IronHammer", new ItemStack(HAEItems.hammerIron, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape("BOB", "OSO", " S ").addInput('B',Block.blockGold).addInput('O', Item.ingotGold).addInput('S',Item.stick).create("GoldHammer", new ItemStack(HAEItems.hammerGold, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape("BOB", "OSO", " S ").addInput('B',Block.blockSteel).addInput('O', Item.ingotSteel).addInput('S',Item.stick).create("SteelHammer", new ItemStack(HAEItems.hammerSteel, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape("BOB", "OSO", " S ").addInput('B', HAEItems.diamondSteelBlock).addInput('O', Item.diamond).addInput('S',Item.stick).create("DiamondHammer", new ItemStack(HAEItems.hammerDiamond, 1));

		//Repair
		addRepairableRecipe(HAEItems.hammerIron, HAEItems.repairkitIron);
		addRepairableRecipe(HAEItems.hammerGold, HAEItems.repairkitGold);
		addRepairableRecipe(HAEItems.hammerSteel, HAEItems.repairkitSteel);
		addRepairableRecipe(HAEItems.hammerDiamond, HAEItems.repairkitDiamond);

		addRepairableRecipe(HAEItems.excavatorIron, HAEItems.repairkitIron);
		addRepairableRecipe(HAEItems.excavatorGold, HAEItems.repairkitGold);
		addRepairableRecipe(HAEItems.excavatorSteel, HAEItems.repairkitSteel);
		addRepairableRecipe(HAEItems.excavatorDiamond, HAEItems.repairkitDiamond);

		//excavators
		RecipeBuilder.Shaped(MOD_ID).setShape(" O ", "BSB", " S ").addInput('B', HAEItems.HardenedLog).addInput('O', Block.planksOak).addInput('S',Item.stick).create("excavatorWooden", new ItemStack(HAEItems.excavatorWooden, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape(" O ", "BSB", " S ").addInput('B', HAEItems.HardenedLog).addInput('O', Block.planksOakPainted).addInput('S',Item.stick).create("PexcavatorWooden", new ItemStack(HAEItems.excavatorWooden, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape(" O ", "BSB", " S ").addInput('B', HAEItems.HardenedCobble).addInput('O', Block.cobbleStone).addInput('S',Item.stick).create("excavatorStone", new ItemStack(HAEItems.excavatorStone, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape(" O ", "BSB", " S ").addInput('B',Block.blockIron).addInput('O', Item.ingotIron).addInput('S',Item.stick).create("excavatorIron", new ItemStack(HAEItems.excavatorIron, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape(" O ", "BSB", " S ").addInput('B',Block.blockGold).addInput('O', Item.ingotGold).addInput('S',Item.stick).create("excavatorGold", new ItemStack(HAEItems.excavatorGold, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape(" O ", "BSB", " S ").addInput('B',Block.blockSteel).addInput('O', Item.ingotSteel).addInput('S',Item.stick).create("excavatorSteel", new ItemStack(HAEItems.excavatorSteel, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape(" O ", "BSB", " S ").addInput('B', HAEItems.diamondSteelBlock).addInput('O', Item.diamond).addInput('S',Item.stick).create("excavatorDiamond", new ItemStack(HAEItems.excavatorDiamond, 1));

	}
}
