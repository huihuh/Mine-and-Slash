package com.robertx22.customitems.gearitems.bases;

import java.util.Set;

import com.google.common.collect.Sets;
import com.robertx22.uncommon.capability.EntityData.UnitData;
import com.robertx22.uncommon.datasaving.Load;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.util.EnumHelper;

public abstract class BaseWeaponItem extends ItemTool implements IGearItem, IWeapon {

    static ItemSword.ToolMaterial Mat = EnumHelper.addToolMaterial("swordmat", 0, 900, 1F, 1F, 10);

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet();

    public abstract String Name();

    public BaseWeaponItem() {
	super(Mat, EFFECTIVE_ON);
	this.setMaxStackSize(1);
	this.setMaxDamage(BaseArmorItem.MAX_GEAR_DURABILITY);

    }

    public static boolean checkDurability(EntityLivingBase attacker, ItemStack stack) {

	if (stack.getItemDamage() > stack.getMaxDamage() - 20) {
	    attacker.sendMessage(new TextComponentString("Weapon has too low durability to be used."));
	    return false;

	}
	return true;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {

	if (checkDurability(attacker, stack)) {

	    stack.damageItem(1, attacker);

	    UnitData sourceUnit = Load.Unit(attacker);

	    if (sourceUnit.tryUseWeapon(attacker, this.mechanic(), stack)) {
		sourceUnit.attackWithWeapon(attacker, target, stack);
		return true;
	    }
	}

	return false;
    }

}
