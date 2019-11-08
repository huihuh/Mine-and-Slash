package com.robertx22.mine_and_slash.database.gearitemslots.bases.armor;

import com.robertx22.mine_and_slash.database.gearitemslots.bases.BaseArmor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public abstract class BasePants extends BaseArmor {

    @Override
    public String resourceID() {
        return "pants";
    }

    @Override
    public boolean isGearOfThisType(Item item) {
        return item instanceof ItemArmor && ((ItemArmor) item).getEquipmentSlot()
                .equals(EntityEquipmentSlot.LEGS);

    }
}