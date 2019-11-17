package com.robertx22.mine_and_slash.mmorpg.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.function.Supplier;

public interface IProxy {

	EntityPlayer getPlayerEntityFromContext(MessageContext parContext);

	String translate(String str);

}