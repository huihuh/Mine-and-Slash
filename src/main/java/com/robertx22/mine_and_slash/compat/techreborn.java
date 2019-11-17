package com.robertx22.mine_and_slash.compat;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.ImmutableList;
import com.robertx22.mine_and_slash.api.MineAndSlashAPI;
import com.robertx22.mine_and_slash.config.compatible_items.ConfigItem;
import com.robertx22.mine_and_slash.database.gearitemslots.plate.PlateBoots;
import com.robertx22.mine_and_slash.database.gearitemslots.plate.PlateChest;
import com.robertx22.mine_and_slash.database.gearitemslots.plate.PlateHelmet;
import com.robertx22.mine_and_slash.database.gearitemslots.plate.PlatePants;
import com.robertx22.mine_and_slash.database.gearitemslots.weapons.Sword;

public class techreborn {

	private static final Logger LOGGER = LogManager.getLogger();

	private static final List<String> SWORD = ImmutableList.of("bronzesword", "sapphiresword", "rubysword",
			"peridotsword");

	private static final List<String> Helmet = ImmutableList.of("peridothelmet", "rubyhelmet", "bronzehelmet");

	private static final List<String> Chestplate = ImmutableList.of("peridotchestplate", "rubychestplate",
			"bronzechestplate");

	private static final List<String> Leggings = ImmutableList.of("peridotleggings", "rubyleggings", "bronzeleggings");

	private static final List<String> Boots = ImmutableList.of("peridotboots", "rubyboots", "bronzeboots");

	public techreborn() {
		String modID = "techreborn:";

		MineAndSlashAPI.addCompatibleItem(modID + "nanosaber",
				new ConfigItem().setType(Sword.INSTANCE).setSalvagable(false).setMinLevel(85));
		for (String s : SWORD) {
			MineAndSlashAPI.addCompatibleItem(modID + s, new ConfigItem().setType(Sword.INSTANCE).setMaxRarity(2)
					.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		}
		LOGGER.debug("Registered Swords");
		for (String h : Helmet) {
			MineAndSlashAPI.addCompatibleItem(modID + h, new ConfigItem().setType(PlateHelmet.INSTANCE).setMaxRarity(2)
					.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		}
		MineAndSlashAPI.addCompatibleItem(modID + "sapphirehelmet",
				new ConfigItem().setType(PlateHelmet.INSTANCE).setSalvagable(false).setMinLevel(55));
		LOGGER.debug("Registered Helmet");
		for (String c : Chestplate) {
			MineAndSlashAPI.addCompatibleItem(modID + c, new ConfigItem().setType(PlateChest.INSTANCE).setMaxRarity(2)
					.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		}
		MineAndSlashAPI.addCompatibleItem(modID + "sapphirechestplate",
				new ConfigItem().setType(PlateChest.INSTANCE).setSalvagable(false).setMinLevel(55));
		LOGGER.debug("Registered Chestplate");
		for (String l : Leggings) {
			MineAndSlashAPI.addCompatibleItem(modID + l, new ConfigItem().setType(PlatePants.INSTANCE).setMaxRarity(2)
					.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		}
		MineAndSlashAPI.addCompatibleItem(modID + "sapphireleggings",
				new ConfigItem().setType(PlatePants.INSTANCE).setSalvagable(false).setMinLevel(55));
		LOGGER.debug("Registered Leggings");
		for (String b : Boots) {
			MineAndSlashAPI.addCompatibleItem(modID + b, new ConfigItem().setType(PlateBoots.INSTANCE).setMaxRarity(2)
					.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		}
		MineAndSlashAPI.addCompatibleItem(modID + "sapphireboots",
				new ConfigItem().setType(PlateBoots.INSTANCE).setSalvagable(false).setMinLevel(55));
		LOGGER.debug("Registered Boots");
	}
}
