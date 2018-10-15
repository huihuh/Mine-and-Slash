package com.robertx22.baubles.common.network;

import com.robertx22.mmorpg.Ref;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler
{
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Ref.MODID.toLowerCase());

	
	public static void init()
	{
		INSTANCE.registerMessage(PacketOpenBaublesInventory.class, PacketOpenBaublesInventory.class, 0, Side.SERVER);
		INSTANCE.registerMessage(PacketOpenNormalInventory.class, PacketOpenNormalInventory.class, 1, Side.SERVER);
		INSTANCE.registerMessage(PacketSync.Handler.class, PacketSync.class, 2, Side.CLIENT);
	}
}