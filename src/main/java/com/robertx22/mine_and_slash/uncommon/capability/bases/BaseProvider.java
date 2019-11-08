package com.robertx22.mine_and_slash.uncommon.capability.bases;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;

public abstract class BaseProvider<TYPE> implements ICapabilitySerializable<NBTTagCompound> {

    public abstract TYPE defaultImpl();

    public abstract Capability<TYPE> dataInstance();

    TYPE impl = defaultImpl();
    private final LazyOptional<TYPE> cap = LazyOptional.of(() -> impl);

    @Override
    public NBTTagCompound serializeNBT() {
        return (NBTTagCompound) dataInstance().getStorage()
                .writeNBT(dataInstance(), impl, null);

    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        dataInstance().getStorage().readNBT(dataInstance(), impl, null, nbt);

    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if (cap == dataInstance()) {
            return this.cap.cast();
        }
        return LazyOptional.empty();
    }
}