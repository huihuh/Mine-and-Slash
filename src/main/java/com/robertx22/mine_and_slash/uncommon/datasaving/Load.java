package com.robertx22.mine_and_slash.uncommon.datasaving;

import com.robertx22.mine_and_slash.uncommon.capability.*;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap.UnitData;
import com.robertx22.mine_and_slash.uncommon.capability.MapCap.IMapData;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nonnull;

public class Load {

    public static UnitData Unit(ICapabilityProvider provider) {
	if (provider != null) {
	    return provider.getCapability(EntityCap.Data, null);
	}
	return null;
    }

    public static IMapData World(ICapabilityProvider provider) {

	if (provider != null) {
	    return provider.getCapability(MapCap.Data, null);

	}
	return null;
    }
}