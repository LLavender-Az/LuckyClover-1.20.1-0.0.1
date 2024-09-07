package net.lavender.luckyclover;

import com.mojang.logging.LogUtils;
import net.lavender.luckyclover.content.CreativeTab;
import net.lavender.luckyclover.content.block.ModBlocks;
import net.lavender.luckyclover.content.fluid.ModFluids;
import net.lavender.luckyclover.content.item.ModItems;
import net.lavender.luckyclover.data.logic.ModBiomeFeatures;
import net.lavender.luckyclover.data.logic.ModBiomeModifiers;
import net.lavender.luckyclover.data.logic.ModPlacementModifiers;
import net.lavender.luckyclover.data.logic.loot.ModLootModifiers;
import net.lavender.luckyclover.content.data_values.CompostingValues;
import net.lavender.luckyclover.data.logic.ModBrewingRecipeSetup;
import net.lavender.luckyclover.data.logic.util.Configuration;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LuckyClover.MOD_ID)
public class LuckyClover {
    public static final String MOD_ID = "luckyclover";
    public static final Logger LOGGER = LogUtils.getLogger();

    public LuckyClover() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        CreativeTab.register(modEventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Configuration.COMMON_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Configuration.CLIENT_CONFIG);
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModFluids.FLUIDS.register(modEventBus);
        ModFluids.FLUID_TYPES.register(modEventBus);
        ModPlacementModifiers.PLACEMENT_MODIFIERS.register(modEventBus);
        ModBiomeFeatures.FEATURES.register(modEventBus);
        ModBiomeModifiers.BIOME_MODIFIER_SERIALIZERS.register(modEventBus);
        ModLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(CompostingValues::addCompostValues);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        BrewingRecipeRegistry.addRecipe(new ModBrewingRecipeSetup(Potions.THICK,
                ModItems.GOLDEN_FOUR_LEAF_CLOVER.get(), Potions.LUCK));

        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CLOVER.getId(), ModBlocks.POTTED_CLOVER);
        });

    }


    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {

        }
    }



    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
