package com.robertx22.database.stat_mods.percent.much_less;

import com.robertx22.database.stat_types.offense.CriticalDamage;
import com.robertx22.stats.Stat;
import com.robertx22.stats.StatMod;
import com.robertx22.uncommon.enumclasses.StatTypes;

public class CrippleCriticalDamagePercent extends StatMod {

    public CrippleCriticalDamagePercent() {
    }

    @Override
    public String GUID() {
	return "CrippleCriticalDamagePercent";

    }

    @Override
    public int Min() {
	return -30;
    }

    @Override
    public int Max() {
	return -60;
    }

    @Override
    public StatTypes Type() {
	return StatTypes.Percent;
    }

    @Override
    public Stat GetBaseStat() {
	return new CriticalDamage();
    }

}