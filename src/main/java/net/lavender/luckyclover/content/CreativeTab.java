package net.lavender.luckyclover.content;

import net.lavender.luckyclover.LuckyClover;
import net.lavender.luckyclover.content.block.ModBlocks;
import net.lavender.luckyclover.content.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LuckyClover.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LUCKY_CLOVER_CREATIVE_TAB = CREATIVE_MODE_TABS.register("luckyclover_creative_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FOUR_LEAF_CLOVER.get()))
                    .title(Component.literal("Lucky Clover!"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModBlocks.OAK_SIDING.get());
                        pOutput.accept(ModBlocks.SPRUCE_SIDING.get());
                        pOutput.accept(ModBlocks.DARK_OAK_SIDING.get());
                        pOutput.accept(ModBlocks.CLOVER_SACK.get());
                        pOutput.accept(ModBlocks.GOLDEN_CLOVER_SACK.get());
                        pOutput.accept(ModBlocks.DREAM_CATCHER.get());
                        pOutput.accept(ModBlocks.CLOVER.get());
                        pOutput.accept(ModItems.THREE_LEAF_CLOVER.get());
                        pOutput.accept(ModItems.FOUR_LEAF_CLOVER.get());
                        pOutput.accept(ModItems.GOLDEN_FOUR_LEAF_CLOVER.get());
                        pOutput.accept(ModItems.LUCKY_HORSESHOE.get());
                        pOutput.accept(ModItems.GOLD_RING.get());
                        pOutput.accept(ModItems.GOLDEN_PENDANT.get());
                        pOutput.accept(ModItems.HAM.get());
                        pOutput.accept(ModItems.SMOKED_HAM.get());
                        pOutput.accept(ModItems.FRIED_EGG.get());
                        pOutput.accept(ModItems.GREEN_EGG.get());
                        pOutput.accept(ModItems.GLOW_BERRY_ICE_CREAM.get());
                        pOutput.accept(ModItems.GREEN_EGGS_AND_HAM.get());
                        pOutput.accept(ModItems.EMPTY_CAN.get());
                        pOutput.accept(ModItems.ADHMOR_SODA.get());
                        pOutput.accept(ModItems.FRUIT_JUICE.get());
                        pOutput.accept(ModItems.GLOW_BERRY_JUICE.get());
                        pOutput.accept(ModItems.CLOVER_BREW.get());
                        pOutput.accept(ModItems.CLOVER_SHAKE.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
