package com.robertx22.mine_and_slash.uncommon.utilityclasses;

import com.robertx22.mine_and_slash.mmorpg.MMORPG;
import com.robertx22.mine_and_slash.network.NoEnergyPacket;
import com.robertx22.mine_and_slash.network.MessagePackage;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;

public class AttackUtils {

    public static void NoEnergyMessage(Entity entity) {

	if (entity instanceof EntityPlayerMP) {

	    MMORPG.Network.sendTo(new MessagePackage("not_enough_energy", MessagePackage.MessageTypes.NoEnergy),
			    (EntityPlayerMP) entity);

	}
    }
}
