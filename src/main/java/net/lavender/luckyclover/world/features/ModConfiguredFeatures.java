package net.lavender.luckyclover.world.features;


import net.lavender.luckyclover.LuckyClover;
import net.lavender.luckyclover.common.block.BlockInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> CLOVER_KEY = registerKey("clover");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CLOVER_UNDERGROUND_KEY = registerKey("clover_underground");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CLOVER_SWAMP_KEY = registerKey("clover_swamp");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {


        //Flowers
        register(context, CLOVER_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(56,0,2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.CLOVER_PLANT.get())))));

        register(context, CLOVER_UNDERGROUND_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32,0,2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.CLOVER_PLANT.get())))));

        register(context, CLOVER_SWAMP_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32,0,2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.CLOVER_PLANT.get())))));


    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(LuckyClover.MOD_ID, name));
    }
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}