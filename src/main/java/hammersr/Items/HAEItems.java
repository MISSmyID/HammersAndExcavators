package hammersr.Items;

import hammersr.HammersAndExcavators;
import hammersr.HammersAndExcavatorsConfig;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.material.ToolMaterial;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.ItemHelper;

public class HAEItems {
	public static Item hammerWooden;
	public static Item hammerStone;
	public static Item hammerIron;
	public static Item hammerGold;
	public static Item hammerSteel;
	public static Item hammerDiamond;
	public static Item excavatorWooden;
	public static Item excavatorStone;
	public static Item excavatorIron;
	public static Item excavatorGold;
	public static Item excavatorSteel;
	public static Item excavatorDiamond;
	public static Item repairkitIron;
	public static Item repairkitSteel;
	public static Item repairkitGold;
	public static Item repairkitDiamond;
	public static Item repairkitEmpty;
	public static Block diamondSteelBlock;
	public static Block HardenedCobble;
	public static Block HardenedLog;
	private static int blockID(String blockName) {
		return HammersAndExcavatorsConfig.cfg.getInt("Block IDs." + blockName);
	}
	private static int itemID(String blockName) {
		return HammersAndExcavatorsConfig.cfg.getInt("Item IDs." + blockName);
	}
	private static final String MOD_ID;

	static {
		MOD_ID = HammersAndExcavators.MOD_ID;
	}

	public static BlockBuilder standardBlockBuilder = new BlockBuilder(MOD_ID);

	public static void initItems(){
		repairkitEmpty = ItemHelper.createItem(MOD_ID, new Item("EmptyRepairKit",itemID("repairkitEmpty")),"EmptyRepairKit.png").setMaxStackSize(8);
		repairkitIron = ItemHelper.createItem(MOD_ID, new Item("IronRepairKit",itemID("repairkitIron")),"IronRepairKit.png").setMaxStackSize(8);
		repairkitSteel = ItemHelper.createItem(MOD_ID, new Item("SteelRepairKit",itemID("repairkitSteel")),"SteelRepairKit.png").setMaxStackSize(8);
		repairkitGold = ItemHelper.createItem(MOD_ID, new Item("GoldRepairKit",itemID("repairkitGold")),"GoldRepairKit.png").setMaxStackSize(8);
		repairkitDiamond = ItemHelper.createItem(MOD_ID, new Item("DiamondRepairKit",itemID("repairkitDiamond")),"DiamondRepairKit.png").setMaxStackSize(8);

		hammerWooden = ItemHelper.createItem(MOD_ID,new HammerItem("WoodenHammer",itemID("hammerWooden"), ToolMaterial.wood),"wooden_hammer.png");
		hammerStone = ItemHelper.createItem(MOD_ID,new HammerItem("StoneHammer",itemID("hammerStone"), ToolMaterial.stone),"stone_hammer.png");
		hammerIron = ItemHelper.createItem(MOD_ID,new HammerItem("IronHammer",itemID("hammerIron"), ToolMaterial.iron),"iron_hammer.png");
		hammerGold = ItemHelper.createItem(MOD_ID,new HammerItem("GoldHammer",itemID("hammerGold"), ToolMaterial.gold),"golden_hammer.png");
		hammerSteel = ItemHelper.createItem(MOD_ID,new HammerItem("SteelHammer",itemID("hammerSteel"), ToolMaterial.steel),"steel_hammer.png");
		hammerDiamond = ItemHelper.createItem(MOD_ID,new HammerItem("DiamondHammer",itemID("hammerDiamond"), ToolMaterial.diamond),"diamond_hammer.png");

		excavatorWooden = ItemHelper.createItem(MOD_ID,new ExcavatorItem("WoodenExcavator",itemID("excavatorWooden"), ToolMaterial.wood),"wooden_excavator.png");
		excavatorStone = ItemHelper.createItem(MOD_ID,new ExcavatorItem("StoneExcavator",itemID("excavatorStone"), ToolMaterial.stone),"stone_excavator.png");
		excavatorIron = ItemHelper.createItem(MOD_ID,new ExcavatorItem("IronExcavator",itemID("excavatorIron"), ToolMaterial.iron),"iron_excavator.png");
		excavatorGold = ItemHelper.createItem(MOD_ID,new ExcavatorItem("GoldExcavator",itemID("excavatorGold"), ToolMaterial.gold),"golden_excavator.png");
		excavatorSteel = ItemHelper.createItem(MOD_ID,new ExcavatorItem("SteelExcavator",itemID("excavatorSteel"), ToolMaterial.steel),"steel_excavator.png");
		excavatorDiamond = ItemHelper.createItem(MOD_ID,new ExcavatorItem("DiamondExcavator",itemID("excavatorDiamond"), ToolMaterial.diamond),"diamond_excavator.png");

		diamondSteelBlock = standardBlockBuilder.setTextures("diamondSteelBlock.png").build(new Block("diamondSteelBlock",blockID("diamondSteelBlock"), Material.metal));
		HardenedCobble = standardBlockBuilder.setTextures("HardenedCobbleStone.png").build(new Block("HardenedCobble",blockID("HardenedCobble"), Material.stone));
		HardenedLog = standardBlockBuilder.setSideTextures("HardenedLogSides.png").setTopBottomTexture("HardenedLogTopBottom.png").build(new Block("HardenedLog",blockID("HardenedLog"), Material.woodWet));
		/*
		repairkitEmpty = new ItemBuilder(MOD_ID).setIcon("hammersr:item/EmptyRepairKit").build(new Item("EmptyRepairKit",itemID("repairkitEmpty"))).setMaxStackSize(8);
		repairkitIron = new ItemBuilder(MOD_ID).setIcon("hammersr:item/IronRepairKit").build(new Item("IronRepairKit",itemID("repairkitIron"))).setMaxStackSize(8);
		repairkitSteel = new ItemBuilder(MOD_ID).setIcon("hammersr:item/SteelRepairKit").build(new Item("SteelRepairKit",itemID("repairkitSteel"))).setMaxStackSize(8);
		repairkitGold = new ItemBuilder(MOD_ID).setIcon("hammersr:item/GoldRepairKit").build(new Item("GoldRepairKit",itemID("repairkitGold"))).setMaxStackSize(8);
		repairkitDiamond = new ItemBuilder(MOD_ID).setIcon("hammersr:item/DiamondRepairKit").build(new Item("DiamondRepairKit",itemID("repairkitDiamond"))).setMaxStackSize(8);

		hammerWooden = new ItemBuilder(MOD_ID).setIcon("hammersr:item/wooden_hammer").build(new HammerItem("WoodenHammer",itemID("hammerWooden"),ToolMaterial.wood));
		hammerStone = new ItemBuilder(MOD_ID).setIcon("hammersr:item/stone_hammer").build(new HammerItem("StoneHammer",itemID("hammerStone"),ToolMaterial.stone));
		hammerIron = new ItemBuilder(MOD_ID).setIcon("hammersr:item/iron_hammer").build(new HammerItem("IronHammer",itemID("hammerIron"),ToolMaterial.iron));
		hammerGold = new ItemBuilder(MOD_ID).setIcon("hammersr:item/golden_hammer").build(new HammerItem("GoldHammer",itemID("hammerGold"),ToolMaterial.gold));
		hammerSteel  = new ItemBuilder(MOD_ID).setIcon("hammersr:item/steel_hammer").build(new HammerItem("SteelHammer",itemID("hammerSteel"),ToolMaterial.steel));
		hammerDiamond = new ItemBuilder(MOD_ID).setIcon("hammersr:item/diamond_hammer").build(new HammerItem("DiamondHammer",itemID("hammerDiamond"),ToolMaterial.diamond));

		excavatorWooden = new ItemBuilder(MOD_ID).setIcon("hammersr:item/wooden_excavator").build(new ExcavatorItem("WoodenExcavator",itemID("excavatorWooden"),ToolMaterial.wood));
		excavatorStone = new ItemBuilder(MOD_ID).setIcon("hammersr:item/stone_excavator").build(new ExcavatorItem("StoneExcavator",itemID("excavatorStone"),ToolMaterial.stone));
		excavatorIron = new ItemBuilder(MOD_ID).setIcon("hammersr:item/iron_excavator").build(new ExcavatorItem("IronExcavator",itemID("excavatorIron"),ToolMaterial.iron));
		excavatorGold = new ItemBuilder(MOD_ID).setIcon("hammersr:item/golden_excavator").build(new ExcavatorItem("GoldExcavator",itemID("excavatorGold"),ToolMaterial.gold));
		excavatorSteel = new ItemBuilder(MOD_ID).setIcon("hammersr:item/steel_excavator").build(new ExcavatorItem("SteelExcavator",itemID("excavatorSteel"),ToolMaterial.steel));
		excavatorDiamond = new ItemBuilder(MOD_ID).setIcon("hammersr:item/diamond_excavator").build(new ExcavatorItem("DiamondExcavator",itemID("excavatorDiamond"),ToolMaterial.diamond));

		diamondSteelBlock= standardBlockBuilder.setTextures("hammersr:block/diamondSteelBlock").build(new Block("diamondSteelBlock",blockID("diamondSteelBlock"), Material.metal));
		HardenedCobble = standardBlockBuilder.setTextures("hammersr:block/HardenedCobbleStone").build(new Block("HardenedCobble",blockID("HardenedCobble"), Material.stone));
		HardenedLog = standardBlockBuilder.setSideTextures("hammersr:block/HardenedLogSides").setTopBottomTexture("hammersr:block/HardenedLogTopBottom").build(new Block("HardenedLog",blockID("HardenedLog"), Material.woodWet));
*/
	}
}
