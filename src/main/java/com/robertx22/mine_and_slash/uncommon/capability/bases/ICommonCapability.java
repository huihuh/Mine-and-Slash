package com.robertx22.mine_and_slash.uncommon.capability.bases;

import net.minecraft.nbt.NBTTagCompound;

public interface ICommonCapability {

    NBTTagCompound getNBT();

    void setNBT(NBTTagCompound value);
}
