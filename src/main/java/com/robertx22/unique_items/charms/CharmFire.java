package com.robertx22.unique_items.charms;

import java.util.Arrays;
import java.util.List;

import com.robertx22.database.stat_mods.flat.CriticalHitFlat;
import com.robertx22.database.stat_mods.flat.elemental.pene.FirePeneFlat;
import com.robertx22.database.stat_mods.flat.elemental.spell_dmg.SpellFireDamageFlat;
import com.robertx22.database.stat_mods.percent.ManaRegenPercent;
import com.robertx22.database.stat_mods.percent.much_less.CrippleDodgePercent;
import com.robertx22.stats.StatMod;
import com.robertx22.unique_items.bases.BaseUniqueCharm;

public class CharmFire extends BaseUniqueCharm {

    public CharmFire() {

    }

    @Override
    public int Tier() {
	return 12;
    }

    @Override
    public String name() {
	return "Heavenly Fire Charm";
    }

    @Override
    public String GUID() {
	return "charmfire0";
    }

    @Override
    public List<StatMod> uniqueStats() {
	return Arrays.asList(new SpellFireDamageFlat(), new ManaRegenPercent(), new FirePeneFlat(),
		new CriticalHitFlat(), new CrippleDodgePercent());
    }

    @Override
    public String description() {
	return "Bath in flames, thrive!";
    }

}
