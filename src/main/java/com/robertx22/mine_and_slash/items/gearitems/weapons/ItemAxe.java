package com.robertx22.mine_and_slash.items.gearitems.weapons;

import com.robertx22.mine_and_slash.db_lists.Rarities;
import com.robertx22.mine_and_slash.items.gearitems.bases.BaseWeaponItem;
import com.robertx22.mine_and_slash.items.gearitems.bases.IWeapon;
import com.robertx22.mine_and_slash.items.gearitems.bases.WeaponMechanic;
import com.robertx22.mine_and_slash.items.gearitems.weapon_mechanics.AxeWeaponMechanic;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.Rarity;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;

public class ItemAxe extends BaseWeaponItem implements IWeapon {
    public static HashMap<Integer, Item> Items = new HashMap<Integer, Item>();

    public ItemAxe(int rar) {
        super(rar);
    }

    @Override
    public String locNameForLangFile() {
        Rarity rar = Rarities.Items.get(rarity);
        return rar.textFormatColor() + "Axe";
    }

    @Override
    public WeaponMechanic mechanic() {
        return new AxeWeaponMechanic();
    }


}
