package net.lavender.luckyclover;

import net.lavender.luckyclover.common.block.LCBlocks;
import net.lavender.luckyclover.common.item.LCItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LuckyClover.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LUCKYCLOVER_CREATIVE_TAB = CREATIVE_MODE_TABS.register("luckyclover_creative_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(LCItems.FOUR_LEAF_CLOVER.get()))
                    .title(Component.literal("Lucky Clover!"))
                    .displayItems((pParameters, pOutput) -> {


                        pOutput.accept(LCBlocks.CLOVER_SACK.get());

                        pOutput.accept(LCBlocks.CLOVER_PLANT.get());
                        pOutput.accept(LCItems.FOUR_LEAF_CLOVER.get());
                        pOutput.accept(LCItems.GOLDEN_CLOVER.get());

                        pOutput.accept(LCItems.LUCK_CHARM.get());
                        pOutput.accept(LCItems.LUCKY_HORSESHOE.get());
                        pOutput.accept(LCItems.CITRINE_RING.get());



                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
