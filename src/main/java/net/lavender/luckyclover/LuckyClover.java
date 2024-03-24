package net.lavender.luckyclover;

import com.mojang.logging.LogUtils;
import net.lavender.luckyclover.common.init.block.BlockInit;
import net.lavender.luckyclover.common.init.item.LCItems;
import net.lavender.luckyclover.common.datagen.loot.ModLootModifiers;
import net.lavender.luckyclover.events.Composting;
import net.lavender.luckyclover.events.ModBrewingRecipeSetup;
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
import net.minecraftforge.fml.common.Mod;
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

        ModCreativeTab.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        LCItems.ITEMS.register(modEventBus);
        BlockInit.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(Composting::addCompostValues);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

        BrewingRecipeRegistry.addRecipe(new ModBrewingRecipeSetup(Potions.THICK,
                LCItems.GOLDEN_CLOVER.get(), Potions.LUCK));


        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockInit.CLOVER_PLANT.getId(), BlockInit.POTTED_CLOVER);
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
