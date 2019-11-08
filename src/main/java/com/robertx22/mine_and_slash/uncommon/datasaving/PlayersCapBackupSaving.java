package com.robertx22.mine_and_slash.uncommon.datasaving;

import com.robertx22.mine_and_slash.saveclasses.PlayersCapBackup;
import com.robertx22.mine_and_slash.uncommon.datasaving.base.LoadSave;
import net.minecraft.nbt.NBTTagCompound;

public class PlayersCapBackupSaving {

    private static final String LOC = "mmorpg:players_cap_backup";

    public static PlayersCapBackup Load(NBTTagCompound nbt) {

        if (nbt == null) {
            return null;
        }

        return LoadSave.Load(PlayersCapBackup.class, new PlayersCapBackup(), nbt, LOC);

    }

    public static void Save(NBTTagCompound nbt, PlayersCapBackup gear) {

        if (nbt == null) {
            nbt = new NBTTagCompound();
        }

        if (gear != null) {
            LoadSave.Save(gear, nbt, LOC);
        }

    }
}
