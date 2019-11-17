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
import com.robertx22.mine_and_slash.database.gearitemslots.weapons.Bow;
import com.robertx22.mine_and_slash.database.gearitemslots.weapons.Hammer;
import com.robertx22.mine_and_slash.database.gearitemslots.weapons.Sword;

public class thermalfoundation {
	private static final Logger LOGGER = LogManager.getLogger();

	private static final List<String> BOW = ImmutableList.of("", "tool.bow_constantan", "tool.bow_copper",
			"tool.bow_nickel", "tool.bow_tin", "tool.bow_iron", "tool.bow_gold", "tool.bow_aluminum", "tool.bow_bronze",
			"tool.bow_electrum", "tool.bow_lead");

	private static final List<String> HAMMER = ImmutableList.of("tool.hammer_constantan", "tool.hammer_copper",
			"tool.hammer_nickel", "tool.hammer_tin", "tool.hammer_iron", "tool.hammer_gold", "tool.hammer_aluminum",
			"tool.hammer_bronze", "tool.hammer_electrum", "tool.hammer_lead");

	private static final List<String> SWORD = ImmutableList.of("tool.sword_bronze", "tool.sword_copper",
			"tool.sword_constantan", "tool.sword_lead", "tool.sword_tin", "tool.sword_electrum", "tool.sword_nickel",
			"tool.sword_aluminum");

	private static final List<String> Helmet = ImmutableList.of("armor.helmet_lead", "armor.helmet_tin",
			"armor.helmet_copper", "armor.helmet_constantan", "armor.helmet_aluminum", "armor.helmet_nickel",
			"armor.helmet_bronze", "armor.helmet_electrum");

	private static final List<String> Chestplate = ImmutableList.of("armor.plate_lead", "armor.plate_tin",
			"armor.plate_copper", "armor.plate_constantan", "armor.plate_aluminum", "armor.plate_nickel",
			"armor.plate_bronze", "armor.plate_electrum");

	private static final List<String> Leggings = ImmutableList.of("armor.legs_lead", "armor.legs_tin",
			"armor.legs_copper", "armor.legs_constantan", "armor.legs_aluminum", "armor.legs_nickel",
			"armor.legs_bronze", "armor.legs_electrum");

	private static final List<String> Boots = ImmutableList.of("armor.boots_lead", "armor.boots_tin",
			"armor.boots_copper", "armor.boots_constantan", "armor.boots_aluminum", "armor.boots_nickel",
			"armor.boots_bronze", "armor.boots_electrum");

	public thermalfoundation() {
		String modID = "thermalfoundation:";

		MineAndSlashAPI.addCompatibleItem(modID + "tool.bow_silver", new ConfigItem().setType(Bow.INSTANCE).setMaxRarity(1)
				.setSalvagable(false).setAlwaysNormal().setMinLevel(20).setMaxLevel(30));
		for (String b : BOW) {
			MineAndSlashAPI.addCompatibleItem(modID + b, new ConfigItem().setType(Bow.INSTANCE).setMaxRarity(2)
					.setSalvagable(false).setAlwaysNormal().setMinLevel(30).setMaxLevel(50));
		}
		MineAndSlashAPI.addCompatibleItem(modID + "tool.bow_diamond",
				new ConfigItem().setType(Bow.INSTANCE).setSalvagable(false).setMinLevel(50));
		MineAndSlashAPI.addCompatibleItem(modID + "tool.bow_platinum",
				new ConfigItem().setType(Bow.INSTANCE).setSalvagable(false).setMinLevel(50));
		MineAndSlashAPI.addCompatibleItem(modID + "tool.bow_invar",
				new ConfigItem().setType(Bow.INSTANCE).setSalvagable(false).setMinLevel(50));
		LOGGER.debug("Registered Bows");
		MineAndSlashAPI.addCompatibleItem(modID + "tool.hammer_silver", new ConfigItem().setType(Hammer.INSTANCE)
				.setMaxRarity(1).setSalvagable(false).setAlwaysNormal().setMaxLevel(20));
		for (String h : HAMMER) {
			MineAndSlashAPI.addCompatibleItem(modID + h, new ConfigItem().setType(Hammer.INSTANCE).setMaxRarity(2)
					.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		}
		MineAndSlashAPI.addCompatibleItem(modID + "tool.hammer_diamond",
				new ConfigItem().setType(Hammer.INSTANCE).setSalvagable(false).setMinLevel(50));
		MineAndSlashAPI.addCompatibleItem(modID + "tool.hammer_platinum",
				new ConfigItem().setType(Hammer.INSTANCE).setSalvagable(false).setMinLevel(50));
		MineAndSlashAPI.addCompatibleItem(modID + "tool.hammer_invar",
				new ConfigItem().setType(Hammer.INSTANCE).setSalvagable(false).setMinLevel(50));
		LOGGER.debug("Registered Hammers");
		MineAndSlashAPI.addCompatibleItem(modID + "tool.sword_silver", new ConfigItem().setType(Sword.INSTANCE)
				.setMaxRarity(1).setSalvagable(false).setAlwaysNormal().setMaxLevel(20));
		for (String s : SWORD) {
			MineAndSlashAPI.addCompatibleItem(modID + s, new ConfigItem().setType(Sword.INSTANCE).setMaxRarity(2)
					.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		}
		MineAndSlashAPI.addCompatibleItem(modID + "tool.sword_platinum",
				new ConfigItem().setType(Sword.INSTANCE).setSalvagable(false).setMinLevel(50));
		MineAndSlashAPI.addCompatibleItem(modID + "tool.sword_invar",
				new ConfigItem().setType(Sword.INSTANCE).setSalvagable(false).setMinLevel(50));
		LOGGER.debug("Registered Swords");
		MineAndSlashAPI.addCompatibleItem(modID + "armor.helmet_silver", new ConfigItem().setType(PlateHelmet.INSTANCE)
				.setMaxRarity(1).setSalvagable(false).setAlwaysNormal().setMaxLevel(20));
		for (String ah : Helmet) {
			MineAndSlashAPI.addCompatibleItem(modID + ah, new ConfigItem().setType(PlateHelmet.INSTANCE).setMaxRarity(2)
					.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		}
		MineAndSlashAPI.addCompatibleItem(modID + "armor.helmet_platinum",
				new ConfigItem().setType(PlateHelmet.INSTANCE).setSalvagable(false).setMinLevel(50));
		MineAndSlashAPI.addCompatibleItem(modID + "armor.helmet_invar",
				new ConfigItem().setType(PlateHelmet.INSTANCE).setSalvagable(false).setMinLevel(50));
		LOGGER.debug("Registered Helmet");
		MineAndSlashAPI.addCompatibleItem(modID + "armor.plate_silver", new ConfigItem().setType(PlateChest.INSTANCE)
				.setMaxRarity(1).setSalvagable(false).setAlwaysNormal().setMaxLevel(20));
		for (String c : Chestplate) {
			MineAndSlashAPI.addCompatibleItem(modID + c, new ConfigItem().setType(PlateChest.INSTANCE).setMaxRarity(2)
					.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		}
		MineAndSlashAPI.addCompatibleItem(modID + "armor.plate_platinum",
				new ConfigItem().setType(PlateChest.INSTANCE).setSalvagable(false).setMinLevel(50));
		MineAndSlashAPI.addCompatibleItem(modID + "armor.plate_invar",
				new ConfigItem().setType(PlateChest.INSTANCE).setSalvagable(false).setMinLevel(50));
		LOGGER.debug("Registered Chestplate");
		MineAndSlashAPI.addCompatibleItem(modID + "armor.legs_silver", new ConfigItem().setType(PlatePants.INSTANCE)
				.setMaxRarity(1).setSalvagable(false).setAlwaysNormal().setMaxLevel(20));
		for (String l : Leggings) {
			MineAndSlashAPI.addCompatibleItem(modID + l, new ConfigItem().setType(PlatePants.INSTANCE).setMaxRarity(2)
					.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		}
		MineAndSlashAPI.addCompatibleItem(modID + "armor.legs_platinum",
				new ConfigItem().setType(PlatePants.INSTANCE).setSalvagable(false).setMinLevel(50));
		MineAndSlashAPI.addCompatibleItem(modID + "armor.legs_invar",
				new ConfigItem().setType(PlatePants.INSTANCE).setSalvagable(false).setMinLevel(50));
		LOGGER.debug("Registered Leggings");
		MineAndSlashAPI.addCompatibleItem(modID + "armor.boots_silver", new ConfigItem().setType(PlateBoots.INSTANCE)
				.setMaxRarity(1).setSalvagable(false).setAlwaysNormal().setMaxLevel(20));
		for (String ab : Boots) {
			MineAndSlashAPI.addCompatibleItem(modID + ab, new ConfigItem().setType(PlateBoots.INSTANCE).setMaxRarity(2)
					.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		}
		MineAndSlashAPI.addCompatibleItem(modID + "armor.boots_platinum",
				new ConfigItem().setType(PlateBoots.INSTANCE).setSalvagable(false).setMinLevel(50));
		MineAndSlashAPI.addCompatibleItem(modID + "armor.boots_invar",
				new ConfigItem().setType(PlateBoots.INSTANCE).setSalvagable(false).setMinLevel(50));
		LOGGER.debug("Registered Boots");
	}
}
