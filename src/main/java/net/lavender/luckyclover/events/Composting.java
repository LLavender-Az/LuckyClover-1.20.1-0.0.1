package net.lavender.luckyclover.events;

import net.lavender.luckyclover.common.init.item.LCItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class Composting {

    public static void addCompostValues(FMLCommonSetupEvent event) {
       registerCompostable(LCItems.FOUR_LEAF_CLOVER.get().asItem(), 1f);
    }

    public static void registerCompostable(Item item, float chance) {
        ComposterBlock.COMPOSTABLES.put(item, chance);
    }
}