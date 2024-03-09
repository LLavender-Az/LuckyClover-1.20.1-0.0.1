package net.lavender.luckyclover.datagen;

import net.lavender.luckyclover.LuckyClover;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, LuckyClover.MOD_ID);
    }

    @Override
    protected void start() {

       add("luck_charm_from_bastion_treasure", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/bastion_treasure")).build()}, ItemInit.LUCK_CHARM.get()));

        add("clover_from_pillager_outpost", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/pillager_outpost")).build()}, ItemInit.FOUR_LEAF_CLOVER.get()));

        add("clover_from_woodland_mansion", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/woodland_mansion")).build()}, ItemInit.FOUR_LEAF_CLOVER.get()));

        add("clover_from_simple_dungeon", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build()}, ItemInit.FOUR_LEAF_CLOVER.get()));


    }
}
