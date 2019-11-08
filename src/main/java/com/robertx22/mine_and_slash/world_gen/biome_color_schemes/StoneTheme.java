package com.robertx22.mine_and_slash.world_gen.biome_color_schemes;

import com.robertx22.mine_and_slash.world_gen.biome_color_schemes.bases.BiomeColorTheme;
import com.robertx22.mine_and_slash.world_gen.biome_color_schemes.bases.BlockWeight;

import net.minecraft.init.Blocks;

import java.util.Arrays;
import java.util.List;

public class StoneTheme extends BiomeColorTheme {

    @Override
    public List<BlockWeight> OAK_LOG() {
        return Arrays.asList(new BlockWeight(Blocks.STONEBRICK));
    }

    @Override
    public List<BlockWeight> OAK_PLANKS() {
        return Arrays.asList(new BlockWeight(Blocks.STONEBRICK));
    }

    @Override
    public List<BlockWeight> OAK_STAIRS() {
        return Arrays.asList(new BlockWeight(Blocks.STONE_BRICK_STAIRS));
    }

    @Override
    public List<BlockWeight> OAK_SLABS() {
        return Arrays.asList(new BlockWeight(Blocks.STONE_SLAB2));
    }

    @Override
    public List<BlockWeight> OAK_FENCE() {
        return Arrays.asList(new BlockWeight(Blocks.COBBLESTONE_WALL));
    }

}
