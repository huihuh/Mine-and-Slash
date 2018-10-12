package com.robertx22.classes;

import java.util.HashMap;
import java.util.List;

import com.robertx22.stats.StatMod;

import net.minecraft.item.Item;

public abstract class GearItemSlot {

	public abstract String Name();

	public abstract List<Suffix> PossibleSuffixes();

	public abstract List<Prefix> PossiblePrefixes();

	public abstract List<StatMod> PossiblePrimaryStats();

	public abstract List<StatMod> PossibleSecondaryStats();

	public abstract Item DefaultItem();

	public abstract HashMap<Integer, Item> ItemsForRarities();

	public abstract int Weight();

}
