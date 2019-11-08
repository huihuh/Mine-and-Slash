package com.robertx22.mine_and_slash.uncommon.datasaving;

import com.robertx22.mine_and_slash.saveclasses.item_classes.GearItemData;
import com.robertx22.mine_and_slash.uncommon.datasaving.base.LoadSave;

import info.loenwind.autosave.Reader;
import info.loenwind.autosave.Writer;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Gear {

    private static final String LOC = "GEAR_ITEM_DATA";

    public static GearItemData Load(ItemStack stack) {

    	if (stack == null) {
    	    return null;
    	}
    	if (!stack.hasTagCompound()) {
    	    return null;
    	}

    	GearItemData data = null;
    	if (stack.getTagCompound().hasKey(LOC)) {
    	    NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag(LOC);
    	    data = new GearItemData();
    	    Reader.read(nbt, data);
    	}

    	return data;

        }

        public static void Save(ItemStack stack, GearItemData gear) {

    	if (stack == null) {
    	    return;
    	}
    	if (!stack.hasTagCompound()) {
    	    stack.setTagCompound(new NBTTagCompound());
    	}

    	if (gear != null) {
    	    NBTTagCompound object_nbt = new NBTTagCompound();
    	    Writer.write(object_nbt, gear);
    	    NBTTagCompound new_nbt = stack.getTagCompound();
    	    new_nbt.setTag(LOC, object_nbt);
    	    new_nbt.setInteger("rarity", gear.Rarity);
    	    stack.setTagCompound(new_nbt);

    	}

        }

    
    public static void colorItem(ItemStack stack, GearItemData data) {
        if (stack.getItem() instanceof IDyeableArmorItem) {
            IDyeableArmorItem dye = (IDyeableArmorItem) stack.getItem();
            dye.setColor(stack, data.getRarity().colorInt());
        }
    }

}
