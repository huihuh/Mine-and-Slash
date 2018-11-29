package com.robertx22.unique_items.boots;

import java.util.Arrays;
import java.util.List;

import com.robertx22.database.stat_mods.flat.elemental.transfers.ThunderToNatureTransferFlat;
import com.robertx22.database.stat_mods.flat.resources.HealthFlat;
import com.robertx22.database.stat_mods.flat.resources.HealthRegenFlat;
import com.robertx22.database.stat_mods.percent.HealthPercent;
import com.robertx22.database.stat_mods.percent.much_less.CrippleDodgePercent;
import com.robertx22.stats.StatMod;
import com.robertx22.unique_items.bases.BaseUniqueBoots;

public class BootsNature extends BaseUniqueBoots {

    public BootsNature() {

    }

    @Override
    public int Tier() {
	return 7;
    }

    @Override
    public String name() {
	return "Tree Trunks";
    }

    @Override
    public String GUID() {
	return "bootsnature0";
    }

    @Override
    public List<StatMod> uniqueStats() {
	return Arrays.asList(new HealthFlat(), new HealthPercent(), new HealthRegenFlat(),
		new ThunderToNatureTransferFlat(), new CrippleDodgePercent());
    }

    @Override
    public String description() {
	return "Nothing shall break my roots!";
    }

}
