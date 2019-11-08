package com.robertx22.mine_and_slash.uncommon.effectdatas.interfaces;

import net.minecraft.entity.EntityLiving;

public interface IEffect {

	public abstract EntityLiving Source();

	public abstract EntityLiving Target();

	public abstract float Number();

}
