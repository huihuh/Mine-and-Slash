package com.robertx22.mine_and_slash.world_gen.biome_color_schemes;

import com.robertx22.mine_and_slash.world_gen.biome_color_schemes.bases.BlockWeight;

import net.minecraft.init.Blocks;

import com.robertx22.mine_and_slash.world_gen.biome_color_schemes.bases.BiomeColorTheme;

import java.util.Arrays;
import java.util.List;

public class DesertTheme extends BiomeColorTheme {

    @Override
    public List<BlockWeight> OAK_LOG() {
        return Arrays.asList(new BlockWeight(Blocks.SANDSTONE));
    }

    @Override
    public List<BlockWeight> OAK_PLANKS() {
        return Arrays.asList(new BlockWeight(Blocks.SANDSTONE));
    }

    @Override
    public List<BlockWeight> OAK_STAIRS() {
        return Arrays.asList(new BlockWeight(Blocks.SANDSTONE_STAIRS));
    }

    @Override
    public List<BlockWeight> OAK_SLABS() {
        return Arrays.asList(new BlockWeight(Blocks.RED_SANDSTONE_STAIRS));
    }

    @Override
    public List<BlockWeight> OAK_FENCE() {
        return Arrays.asList(new BlockWeight(Blocks.COBBLESTONE_WALL));
    }

}