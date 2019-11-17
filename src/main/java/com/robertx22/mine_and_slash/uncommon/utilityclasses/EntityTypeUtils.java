package com.robertx22.mine_and_slash.uncommon.utilityclasses;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.INpc;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.init.Items;

public class EntityTypeUtils {

    public enum EntityType {
        MOB(Items.SPAWN_EGG),
        PLAYER(null),
        ANIMAL(Items.WHEAT),
        NPC(Items.EMERALD),
        OTHER(null);

        EntityType(Item item) {
            this.itemDenotingType = item;
        }

        public Item itemDenotingType;

        public boolean showsItem() {
            return itemDenotingType != null;
        }

    }

    public static EntityType getType(Entity entity) {

        if (isMob(entity)) {
            return EntityType.MOB;
        } else if (isAnimal(entity)) {
            return EntityType.ANIMAL;
        } else if (isNPC(entity)) {
            return EntityType.NPC;
        } else if (entity instanceof EntityPlayer) {
            return EntityType.PLAYER;
        } else {
            return EntityType.OTHER;
        }

    }

    public static boolean isMob(Entity en) {

        return en instanceof IMob;

    }

    public static boolean isAnimal(Entity en) {

        return en instanceof IAnimals;

    }

    /**
     * has to be checked first because inpc extends ianimals
     *
     * @param en
     * @return
     */
    public static boolean isNPC(Entity en) {

        return en instanceof INpc;

    }
}
