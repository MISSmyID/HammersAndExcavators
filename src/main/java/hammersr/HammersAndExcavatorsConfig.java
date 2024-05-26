package hammersr;

import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.util.ConfigUpdater;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class HammersAndExcavatorsConfig {
	public static ConfigUpdater updater = ConfigUpdater.fromProperties(new String[0]);
	private static final Toml properties = new Toml("Hammers And Excavators Toml Config");
	public static TomlConfigHandler cfg;
	private static int BlockIDs = 3100;
	private static int ItemIDs = 30000;

	public HammersAndExcavatorsConfig(){}

	static{
		properties.addCategory("HammersAndExcavators").addEntry("cfgVersion",5);
		properties.addCategory("Block IDs");
		properties.addEntry("Block IDs.startingID", 3100);
		properties.addCategory("Item IDs");
		properties.addEntry("Item IDs.startingID", 30000);

		List blockFields = (List) Arrays.stream(HammersAndExcavators.class.getDeclaredFields()).filter((F) -> {
			return Block.class.isAssignableFrom(F.getType());
		}).collect(Collectors.toList());

		for (Object field : blockFields) {
			Field blockField = (Field) field;
			properties.addEntry("Block IDs." + blockField.getName(), BlockIDs++);
		}

		List itemFields = (List) Arrays.stream(HammersAndExcavators.class.getDeclaredFields()).filter((F) -> {
			return Item.class.isAssignableFrom(F.getType());
		}).collect(Collectors.toList());

		for (Object field : itemFields) {
			Field itemField = (Field) field;
			properties.addEntry("Item IDs." + itemField.getName(), ItemIDs++);
		}

		cfg = new TomlConfigHandler(updater, "hammersr", properties);
	}
}
