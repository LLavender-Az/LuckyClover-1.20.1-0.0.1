package net.lavender.luckyclover.datagen.world.features;

import net.lavender.luckyclover.LuckyClover;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> CLOVER_PLACED_KEY = registerKey("clover_placed");
    public static final ResourceKey<PlacedFeature> CLOVER_PLACED_JUNGLE_KEY = registerKey("clover_jungle_placed");
    public static final ResourceKey<PlacedFeature> CLOVER_PLACED_SWAMP_KEY = registerKey("clover_swamp_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeature = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, CLOVER_PLACED_KEY, configuredFeature.getOrThrow(ModConfiguredFeatures.CLOVER_KEY),
                List.of(RarityFilter.onAverageOnceEvery(13), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, CLOVER_PLACED_JUNGLE_KEY, configuredFeature.getOrThrow(ModConfiguredFeatures.CLOVER_KEY_JUNGLE),
                List.of(RarityFilter.onAverageOnceEvery(14), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, CLOVER_PLACED_SWAMP_KEY, configuredFeature.getOrThrow(ModConfiguredFeatures.CLOVER_SWAMP_KEY),
                List.of(RarityFilter.onAverageOnceEvery(17), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));



    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(LuckyClover.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}