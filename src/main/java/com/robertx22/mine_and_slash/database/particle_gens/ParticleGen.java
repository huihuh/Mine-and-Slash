package com.robertx22.mine_and_slash.database.particle_gens;

import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import java.util.Random;

public abstract class ParticleGen {

	public Random rand = new Random();

    public abstract void Summon(double x, double y, double z, double xVel, double yVel, double zVel, double radius,
	    int amount);

    public abstract String Name();
}
