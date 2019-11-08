package com.robertx22.mine_and_slash.world_gen.processors;

import com.google.common.collect.ImmutableMap;
import com.robertx22.mine_and_slash.database.world_providers.BirchForestIWP;
import com.robertx22.mine_and_slash.database.world_providers.IWP;
import com.robertx22.mine_and_slash.db_lists.initializers.WorldProviders;
import com.robertx22.mine_and_slash.db_lists.registry.SlashRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraftforge.common.WorldWorkerManager.IWorker;

import javax.annotation.Nullable;

public class BiomeProcessor extends StructureProcessor {

    public BiomeProcessor(IWP iwp) {
        this.iwp = iwp;
    }

    public BiomeProcessor(Biome biome) {

        this.iwp = WorldProviders.byBiome(biome);

    }

    public BiomeProcessor(Dynamic<?> dynamic) {
        iwp = SlashRegistry.WorldProviders()
                .get(dynamic.get("iwp").asString(new BirchForestIWP(null, null).GUID()));
    }

    IWP iwp;

    @Nullable
    @Override
    public Template.BlockInfo process(IWorker iWorldReader, BlockPos blockPos,
                                      Template.BlockInfo blockInfo,
                                      Template.BlockInfo blockInfo1,
                                      PlacementSettings placementSettings) {

        Block block = blockInfo1.blockState.getBlock();

        if (iwp.biomeTheme().blocksReplaceMap.containsKey(block)) {

            IBlockState newstate = iwp.biomeTheme().blocksReplaceMap.get(block)
                    .getBlockToReplaceWith(block)
                    .getDefaultState();

            for (IProperty prop : blockInfo1.blockState.getProperties()) {
                if (newstate.has(prop)) {
                    newstate = newstate.with(prop, blockInfo.blockState.get(prop));
                }
            }

            return new Template.BlockInfo(blockInfo1.pos, newstate, blockInfo1.tileentityData);

        }

        return blockInfo1;

    }

    @Override
    protected IStructureProcessorType getType() {
        return IStructureProcessorType.RULE;
    }

    @Override
    protected <T> Dynamic<T> serialize0(DynamicOps<T> dynamicOps) {
        return new Dynamic(dynamicOps, dynamicOps.createMap(ImmutableMap.of(dynamicOps.createString("iwp"), dynamicOps
                .createString(this.iwp.GUID()))));
    }

}
