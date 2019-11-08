package com.robertx22.mine_and_slash.a_libraries.dmg_number_particle;

import com.robertx22.mine_and_slash.network.DmgNumPacket;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.world.World;

public class OnDisplayDamage {

    private static Minecraft mc = Minecraft.getMinecraft();

    public static void displayParticle(DmgNumPacket data) {

        mc = Minecraft.getMinecraft();

        World world = mc.player.world;
        double motionX = world.rand.nextGaussian() * 0.02;
        double motionY = 0.5f;
        double motionZ = world.rand.nextGaussian() * 0.02;
        Particle damageIndicator = new DamageParticle(data.element, data.string, world, data.x, data.y + data.height,
        		data.z, motionX, motionY, motionZ);

        Minecraft.getMinecraft().effectRenderer.addEffect(damageIndicator);
    }

}
