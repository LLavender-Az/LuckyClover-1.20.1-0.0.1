package net.lavender.luckyclover.content.data_values;

import net.lavender.luckyclover.content.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CompostingValues {

    public static void addCompostValues(FMLCommonSetupEvent event) {
       registerCompostable(ModItems.FOUR_LEAF_CLOVER.get().asItem(), 1.0F);
       registerCompostable(ModItems.THREE_LEAF_CLOVER.get().asItem(), 0.50F);

    }

    public static void registerCompostable(Item item, float chance) {
        ComposterBlock.COMPOSTABLES.put(item, chance);
    }
}