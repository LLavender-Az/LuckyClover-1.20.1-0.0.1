package net.lavender.luckyclover.common.datagen.world.features;


import net.lavender.luckyclover.LuckyClover;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;


public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_CLOVER = registerKey("add_clover");
    public static final ResourceKey<BiomeModifier> ADD_CLOVER_JUNGLE = registerKey("add_clover_jungle");
    public static final ResourceKey<BiomeModifier> ADD_CLOVER_SWAMP = registerKey("add_clover_swamp");


    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_CLOVER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CLOVER_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_CLOVER_JUNGLE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CLOVER_PLACED_JUNGLE_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_CLOVER_SWAMP, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SWAMP),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CLOVER_PLACED_SWAMP_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));



    }
    private static ResourceKey<BiomeModifier> registerKey (String name){
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(LuckyClover.MOD_ID, name));
    }
}