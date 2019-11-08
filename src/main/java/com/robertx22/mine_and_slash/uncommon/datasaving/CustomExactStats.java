package com.robertx22.mine_and_slash.uncommon.datasaving;

import com.robertx22.mine_and_slash.saveclasses.CustomExactStatsData;
import com.robertx22.mine_and_slash.uncommon.datasaving.base.LoadSave;
import net.minecraft.nbt.NBTTagCompound;

public class CustomExactStats {

    public static final String LOC = "mmorpg:custom_exact_stats_data";

    public static CustomExactStatsData Load(NBTTagCompound nbt) {

        if (nbt == null) {
            return null;
        }

        return LoadSave.Load(CustomExactStatsData.class, new CustomExactStatsData(), nbt, LOC);

    }

    public static NBTTagCompound Save(NBTTagCompound nbt, CustomExactStatsData gear) {

        if (nbt == null) {
            return new NBTTagCompound();
        }

        if (gear != null) {
            return LoadSave.Save(gear, nbt, LOC);
        }

        return new NBTTagCompound();
    }
}
