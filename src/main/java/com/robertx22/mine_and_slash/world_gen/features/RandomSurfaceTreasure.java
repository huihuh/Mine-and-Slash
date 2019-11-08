package com.robertx22.mine_and_slash.world_gen.features;

import com.robertx22.mine_and_slash.database.world_providers.IWP;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.WorldUtils;
import com.robertx22.mine_and_slash.world_gen.processors.BiomeProcessor;
import com.robertx22.mine_and_slash.world_gen.processors.ChestProcessor;
import com.robertx22.mine_and_slash.world_gen.types.FeatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;
import java.util.function.Function;

public class RandomSurfaceTreasure extends Feature<NoFeatureConfig> {

    public RandomSurfaceTreasure(
            Function<Dynamic<?>, ? extends NoFeatureConfig> dynamic) {
        super(dynamic);
    }

    @Override
    public boolean place(IWorld iworld,
                         ChunkGenerator<? extends GenerationSettings> generator,
                         Random rand, BlockPos pos, NoFeatureConfig config) {

        IWP iwp = WorldUtils.getIWP(iworld);

        if (iwp != null) {

            FeatureType type = iwp.randomSmallTreasure();
            ResourceLocation res = type.structureResourceLocation;
            pos = type.modifyPos(pos);

            if (res != null) {

                TemplateManager templatemanager = ((WorldServer) iworld.getWorld()).getSaveHandler()
                        .getStructureTemplateManager();

                PlacementSettings placement = new PlacementSettings();
                placement.addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK);
                placement.addProcessor(new BiomeProcessor(iwp));
                placement.addProcessor(new ChestProcessor());

                Template template = templatemanager.getTemplate(res);

                if (type.canSpawn(iworld, pos, template)) {
                    template.addBlocksToWorld(iworld, pos, placement);

                } else {
                    return false;
                }

                return true;
            }
        }

        return false;

    }
}

