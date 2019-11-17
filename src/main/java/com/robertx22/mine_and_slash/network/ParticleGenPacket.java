package com.robertx22.mine_and_slash.network;

import com.robertx22.mine_and_slash.database.particle_gens.ParticleGen;
import com.robertx22.mine_and_slash.db_lists.ParticleGens;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.interfaces.IColor;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.function.Supplier;

public class ParticleGenPacket implements IMessage {

	private String name;
	private double x;
	private double y;
	private double z;
	private double xVel;
	private double yVel;
	private double zVel;
	private boolean isGenerator;
	private double radius;
	private int amount;
	private Elements.RGB color;

	public ParticleGenPacket() {
	}

	public ParticleGenPacket(boolean isGen, String name, double x, double y, double z, double xVel, double yVel,
			double zVel, double radius, int amount) {
		this.isGenerator = isGen;
		this.name = name;
		this.x = x;
		this.y = y;
		this.z = z;
		this.xVel = xVel;
		this.yVel = yVel;
		this.zVel = zVel;
		this.radius = radius;
		this.amount = amount;
	}

	public static class Handler implements IMessageHandler<ParticleGenPacket, IMessage> {

		@Override
		public IMessage onMessage(final ParticleGenPacket message, MessageContext ctx) {

			Runnable noteThread = new Runnable() {
				@Override
				public void run() {
					try {

						if (message.isGenerator) {

							ParticleGen gen = ParticleGens.All.get(message.name);

							gen.Summon(message.x, message.y, message.z, message.xVel, message.yVel, message.zVel,
									message.radius, message.amount);

						} else {

							EnumParticleTypes particle = EnumParticleTypes.getByName(message.name);
							World world = Minecraft.getMinecraft().world;

							world.spawnParticle(particle, message.x, message.y, message.z, message.xVel, message.yVel,
									message.zVel);
						}
					} catch (Exception e) {

					}
				}
			};
			noteThread.run();

			return null;
		}

	}

	@Override
	public void fromBytes(ByteBuf buf) {
		NBTTagCompound tag = ByteBufUtils.readTag(buf);
		isGenerator = tag.getBoolean("isGen");
		name = tag.getString("name");
		x = tag.getDouble("x");
		y = tag.getDouble("y");
		z = tag.getDouble("z");
		xVel = tag.getDouble("xVel");
		yVel = tag.getDouble("yVel");
		zVel = tag.getDouble("zVel");
		radius = tag.getDouble("radius");
		amount = tag.getInteger("amount");
	}

	@Override
	public void toBytes(ByteBuf buf) {
		NBTTagCompound tag = new NBTTagCompound();
		tag.setBoolean("isGen", isGenerator);
		tag.setString("name", name);
		tag.setDouble("x", x);
		tag.setDouble("y", y);
		tag.setDouble("z", z);
		tag.setDouble("xVel", xVel);
		tag.setDouble("yVel", yVel);
		tag.setDouble("zVel", zVel);
		tag.setDouble("radius", radius);
		tag.setInteger("amount", amount);
		ByteBufUtils.writeTag(buf, tag);

	}

}