package com.robertx22.network;

import com.robertx22.mmorpg.Main;
import com.robertx22.mmorpg.ModConfig;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessagePackage implements IMessage {

    public String text;
    public String type;

    public enum MessageTypes {
	NoEnergy, NoMana
    }

    public MessagePackage() {
    }

    public MessagePackage(String name, MessageTypes type) {

	this.text = name;
	this.type = type.name();

    }

    @Override
    public void fromBytes(ByteBuf buf) {
	NBTTagCompound tag = ByteBufUtils.readTag(buf);
	text = tag.getString("text");
	type = tag.getString("type");

    }

    @Override
    public void toBytes(ByteBuf buf) {
	NBTTagCompound tag = new NBTTagCompound();
	tag.setString("text", text);
	tag.setString("type", type);

	ByteBufUtils.writeTag(buf, tag);

    }

    public static class Handler implements IMessageHandler<MessagePackage, IMessage> {

	@Override
	public IMessage onMessage(final MessagePackage message, MessageContext ctx) {

	    Runnable noteThread = new Runnable() {
		@Override
		public void run() {
		    try {

			MessageTypes type = MessageTypes.valueOf(message.type);

			if (type.equals(MessageTypes.NoEnergy) || type.equals(MessageTypes.NoMana)) {

			    if (ModConfig.Client.SHOW_LOW_ENERGY_MANA_WARNING) {

				Main.proxy.getPlayerEntityFromContext(ctx)
					.sendMessage(new TextComponentString(message.text));
			    }

			}

		    } catch (Exception e) {

		    }
		}
	    };
	    noteThread.run();

	    return null;
	}

    }

}