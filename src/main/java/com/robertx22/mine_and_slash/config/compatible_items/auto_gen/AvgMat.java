package com.robertx22.mine_and_slash.config.compatible_items.auto_gen;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class AvgMat {

    public static class ArmorValues {

        public float dur = 0;
        public float ench = 0;
        public float tough = 0;
        public float reduct = 0;

        public float getSum() {
            return dur + ench + tough + reduct;
        }

        public float getBreakpoint(ArmorValues best) {
            return getSum() / best.getSum();
        }

    }

    private static void add(HashSet<ArmorMaterial> list, ArmorMaterial mat) {

        if (mat.getClass().isEnum() || !list.stream()
                .anyMatch(x -> x.getClass().equals(mat.getClass()))) {
            list.add(mat);

        }
    }

    public static ArmorValues getValues(ArmorMaterial mat) {

        ArmorValues val = new ArmorValues();
        EntityEquipmentSlot slot = EntityEquipmentSlot.CHEST;
        val.reduct = mat.getDamageReductionAmount(slot);
        val.tough = mat.getDurability(slot);
        val.ench = mat.getEnchantability();
        val.dur = mat.getDurability(slot);
        return val;
    }

    public static ArmorValues GetAvgArmorValues() {
        ArmorValues val = new ArmorValues();

        HashSet<ArmorMaterial> mats = new HashSet<>();

        ForgeRegistries.ITEMS.getValues()
                .stream()
                .filter(x -> x instanceof ItemArmor)
                .forEach(x -> add(mats, ((ItemArmor) x).getArmorMaterial()));

        List<ArmorValues> all = mats.stream()
                .map(x -> getValues(x))
                .collect(Collectors.toList());

        val.dur = (float) (all.stream().mapToDouble(x -> x.dur).sum() / mats.size());
        val.ench = (float) (all.stream().mapToDouble(x -> x.ench).sum() / mats.size());
        val.tough = (float) (all.stream().mapToDouble(x -> x.tough).sum() / mats.size());
        val.reduct = (float) (all.stream()
                .mapToDouble(x -> x.reduct)
                .sum() / mats.size());

        return val;

    }

}
