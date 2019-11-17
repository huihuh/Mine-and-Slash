package com.robertx22.mine_and_slash.compat;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.ImmutableList;
import com.robertx22.mine_and_slash.api.MineAndSlashAPI;
import com.robertx22.mine_and_slash.config.compatible_items.ConfigItem;
import com.robertx22.mine_and_slash.database.gearitemslots.cloth.ClothBoots;
import com.robertx22.mine_and_slash.database.gearitemslots.cloth.ClothChest;
import com.robertx22.mine_and_slash.database.gearitemslots.cloth.ClothHelmet;
import com.robertx22.mine_and_slash.database.gearitemslots.cloth.ClothPants;
import com.robertx22.mine_and_slash.database.gearitemslots.plate.PlateBoots;
import com.robertx22.mine_and_slash.database.gearitemslots.plate.PlateChest;
import com.robertx22.mine_and_slash.database.gearitemslots.plate.PlateHelmet;
import com.robertx22.mine_and_slash.database.gearitemslots.plate.PlatePants;
import com.robertx22.mine_and_slash.database.gearitemslots.weapons.Bow;
import com.robertx22.mine_and_slash.database.gearitemslots.weapons.Sword;

public class Vanilla {

	private static final Logger LOGGER = LogManager.getLogger();

	public Vanilla() {

		MineAndSlashAPI.addCompatibleItem("minecraft:bow",
				new ConfigItem().setType(Bow.INSTANCE).setSalvagable(false).setMinLevel(5));
		LOGGER.debug("Registered Bow");
		MineAndSlashAPI.addCompatibleItem("minecraft:wooden_sword", new ConfigItem().setType(Sword.INSTANCE)
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem("minecraft:stone_sword", new ConfigItem().setType(Sword.INSTANCE).setMaxRarity(1)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(20));

		MineAndSlashAPI.addCompatibleItem("minecraft:iron_sword", new ConfigItem().setType(Sword.INSTANCE).setMaxRarity(2)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem("minecraft:golden_sword", new ConfigItem().setType(Sword.INSTANCE)
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem("minecraft:diamond_sword",
				new ConfigItem().setType(Sword.INSTANCE).setSalvagable(false).setMinLevel(50));
		LOGGER.debug("Registered Swords");
		MineAndSlashAPI.addCompatibleItem("minecraft:leather_helmet", new ConfigItem().setType(ClothHelmet.INSTANCE)
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem("minecraft:chainmail_helmet",
				new ConfigItem().setType(PlateHelmet.INSTANCE).setMinLevel(40));
		MineAndSlashAPI.addCompatibleItem("minecraft:iron_helmet", new ConfigItem().setType(PlateHelmet.INSTANCE)
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem("minecraft:golden_helmet", new ConfigItem().setType(PlateHelmet.INSTANCE)
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem("minecraft:diamond_helmet",
				new ConfigItem().setType(PlateHelmet.INSTANCE).setSalvagable(false).setMinLevel(50));
		LOGGER.debug("Registered Helmet");
		MineAndSlashAPI.addCompatibleItem("minecraft:leather_chestplate", new ConfigItem().setType(ClothChest.INSTANCE)
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem("minecraft:chainmail_chestplate",
				new ConfigItem().setType(PlateChest.INSTANCE).setMinLevel(40));
		MineAndSlashAPI.addCompatibleItem("minecraft:iron_chestplate", new ConfigItem().setType(PlateChest.INSTANCE)
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem("minecraft:golden_chestplate", new ConfigItem().setType(PlateChest.INSTANCE)
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem("minecraft:diamond_chestplate",
				new ConfigItem().setType(PlateChest.INSTANCE).setSalvagable(false).setMinLevel(50));
		LOGGER.debug("Registered Chestplate");
		MineAndSlashAPI.addCompatibleItem("minecraft:leather_leggings", new ConfigItem().setType(ClothPants.INSTANCE)
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem("minecraft:chainmail_leggings",
				new ConfigItem().setType(PlatePants.INSTANCE).setMinLevel(40));
		MineAndSlashAPI.addCompatibleItem("minecraft:iron_leggings", new ConfigItem().setType(PlatePants.INSTANCE)
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem("minecraft:golden_leggings", new ConfigItem().setType(PlatePants.INSTANCE)
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem("minecraft:diamond_leggings",
				new ConfigItem().setType(PlatePants.INSTANCE).setSalvagable(false).setMinLevel(50));
		LOGGER.debug("Registered Leggings");
		MineAndSlashAPI.addCompatibleItem("minecraft:leather_boots", new ConfigItem().setType(ClothBoots.INSTANCE)
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem("minecraft:chainmail_boots",
				new ConfigItem().setType(PlateBoots.INSTANCE).setMinLevel(40));
		MineAndSlashAPI.addCompatibleItem("minecraft:iron_boots", new ConfigItem().setType(PlateBoots.INSTANCE)
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem("minecraft:golden_boots", new ConfigItem().setType(PlateBoots.INSTANCE)
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem("minecraft:diamond_boots",
				new ConfigItem().setType(PlateBoots.INSTANCE).setSalvagable(false).setMinLevel(50));
		LOGGER.debug("Registered Boots");
	}
}
