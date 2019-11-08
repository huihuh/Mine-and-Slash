package com.robertx22.mine_and_slash.config;

import net.minecraftforge.common.config.Config;
import scala.Double;

public class StatConfig {

	@Config.Name("Physical Damage")
	@Config.LangKey("mmorpg.stat.physical_damage")
	public float physical_damage = 3;

	@Config.Name("Physical Damage Per Level")
	@Config.LangKey("mmorpg.stat.physical_damage_per_level")
	public float physical_damage_per_level = 0.3F;

	@Config.Name("Mana")
	@Config.LangKey("mmorpg.stat.mana")
	public float mana = 50;

	@Config.Name("Mana Per Level")
	@Config.LangKey("mmorpg.stat.mana_per_level")
	public float mana_per_level = 0.3F;

	@Config.Name("Energy")
	@Config.LangKey("mmorpg.stat.energy")
	public float energy = 100;

	@Config.Name("Energy Per Level")
	@Config.LangKey("mmorpg.stat.energy_per_level")
	public float energy_per_level = 0.3F;

	@Config.Name("Mana Regen")
	@Config.LangKey("mmorpg.stat.mana_regen")
	public float mana_regen = 2;

	@Config.Name("Mana Regen Per Level")
	@Config.LangKey("mmorpg.stat.mana_regen_per_level")
	public float mana_regen_per_level = 0;

	@Config.Name("Health Regen")
	@Config.LangKey("mmorpg.stat.health_regen")
	public float health_regen = 5;

	@Config.Name("Health Regen Per Level")
	@Config.LangKey("mmorpg.stat.health_regen_per_level")
	public float health_regen_per_level = 1;

	@Config.Name("Armor")
	@Config.LangKey("mmorpg.stat.armor")
	public float armor = 10;

	@Config.Name("Armor Per Level")
	@Config.LangKey("mmorpg.stat.armor_per_level")
	public float armor_per_level = 4;

	@Config.Name("Health")
	@Config.LangKey("mmorpg.stat.health")
	public float health = 100;

	@Config.Name("Health Per Level")
	@Config.LangKey("mmorpg.stat.health_per_level")
	public float health_per_level = 10;

	@Config.Name("Critical Hit")
	@Config.LangKey("mmorpg.stat.critical_hit")
	public float critical_hit = 0;

	@Config.Name("Critical Hit Per Level")
	@Config.LangKey("mmorpg.stat.critical_hit_per_level")
	public float critical_hit_per_level = 0;

	@Config.Name("Energy Regen")
	@Config.LangKey("mmorpg.stat.energy_regen")
	public float energy_regen = 5;

	@Config.Name("Energy Regen Per Level")
	@Config.LangKey("mmorpg.stat.energy_regen_per_level")
	public float energy_regen_per_level = 0;

	@Config.Name("Critical Damage")
	@Config.LangKey("mmorpg.stat.critical_damage")
	public float critical_damage = 0;

	@Config.Name("Critical Damage Per Level")
	@Config.LangKey("mmorpg.stat.critical_damage_per_level")
	public float critical_damage_per_level = 0;

	@Config.Name("Sword Energy Cost")
	@Config.LangKey("mmorpg.stat.sword_energy_cost")
	public float sword_energy_cost = 3;

	@Config.Name("Axe Energy Cost")
	@Config.LangKey("mmorpg.stat.axe_energy_cost")
	public float axe_energy_cost = 8.5F;

	@Config.Name("Bow Energy Cost")
	@Config.LangKey("mmorpg.stat.bow_energy_cost")
	public float bow_energy_cost = 9;

	@Config.Name("Hammer Energy Cost")
	@Config.LangKey("mmorpg.stat.hammer_energy_cost")
	public float hammer_energy_cost = 10;

	@Config.Name("Staff Energy Cost")
	@Config.LangKey("mmorpg.stat.staff_energy_cost")
	public float staff_energy_cost = 9;
	
	@Config.Name("Ticks To Regen")
	@Config.LangKey("mmorpg.stat.ticks_regen")
	public int ticks_regen = 100;
	
	@Config.Name("Magic Shield")
	@Config.LangKey("mmorpg.stat.magic_shield")
	public double magic_shield = 0D;
	
	@Config.Name("Magic Shield Per Level")
	@Config.LangKey("mmorpg.stat.magic_shield_per_level")
	public double magic_shield_per_level = 0D;
	
	@Config.Name("Magic Shield Regen")
	@Config.LangKey("mmorpg.stat.magic_shield_regen")
	public double magic_shield_regen = 3D;
	
	@Config.Name("Magic Shield Regen Per Level")
	@Config.LangKey("mmorpg.stat.magic_shield_regen_per_level")
	public double magic_shield_regen_per_level = 1D;
	
	@Config.Name("Spell Damage")
	@Config.LangKey("mmorpg.stat.spell_damage")
	public float spell_damage = 3F;
	
	@Config.Name("Spell Damage Per Level")
	@Config.LangKey("mmorpg.stat.spell_damage_per_level")
	public float spell_damage_per_level = 0.25F;
	
}