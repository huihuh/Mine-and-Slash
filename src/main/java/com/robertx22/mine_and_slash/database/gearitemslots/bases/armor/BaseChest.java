package com.robertx22.mine_and_slash.database.gearitemslots.bases.armor;

import com.robertx22.mine_and_slash.database.gearitemslots.bases.BaseArmor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public abstract class BaseChest extends BaseArmor {

    @Override
    public String resourceID() {
        return "chest";
    }

    @Override
    public boolean isGearOfThisType(Item item) {
        return item instanceof ItemArmor && ((ItemArmor) item).getEquipmentSlot()
                .equals(EntityEquipmentSlot.CHEST);
    }

}
