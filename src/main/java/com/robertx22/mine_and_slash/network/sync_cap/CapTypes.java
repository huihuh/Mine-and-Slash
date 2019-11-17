package com.robertx22.mine_and_slash.network.sync_cap;

import com.robertx22.mine_and_slash.uncommon.capability.bases.ICommonCapability;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;

import net.minecraft.entity.player.EntityPlayer;

public enum CapTypes {

    ENTITY_DATA {
        @Override
        public ICommonCapability getCap(EntityPlayer player) {
            return Load.Unit(player);
        }
    },
    MAP_DATA {
        @Override
        public ICommonCapability getCap(EntityPlayer player) {
            return Load.mapData(player);
        }
    },
    PROFESSIONS {
        @Override
        public ICommonCapability getCap(EntityPlayer player) {
            return Load.professions(player);
        }
    },
    TALENTS {
        @Override
        public ICommonCapability getCap(EntityPlayer player) {
            return Load.talents(player);
        }
    },
    STAT_POINTS {
        @Override
        public ICommonCapability getCap(EntityPlayer player) {
            return Load.statPoints(player);
        }
    };

    CapTypes() {

    }

	public abstract ICommonCapability getCap(EntityPlayer player);

}
