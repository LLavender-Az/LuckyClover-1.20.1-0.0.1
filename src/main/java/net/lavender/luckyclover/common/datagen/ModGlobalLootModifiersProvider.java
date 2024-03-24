package net.lavender.luckyclover.common.datagen;

import net.lavender.luckyclover.LuckyClover;
import net.lavender.luckyclover.common.datagen.loot.AddChanceModifer;
import net.lavender.luckyclover.common.datagen.loot.AddGoldenClover;
import net.lavender.luckyclover.common.init.item.LCItems;
import net.lavender.luckyclover.common.datagen.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, LuckyClover.MOD_ID);
    }

    @Override
    protected void start() {

       add("luck_charm_from_bastion_treasure", new AddChanceModifer(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/bastion_treasure")).build()}, LCItems.LUCK_CHARM.get()));

        add("clover_from_pillager_outpost", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/pillager_outpost")).build()}, LCItems.FOUR_LEAF_CLOVER.get()));

        add("clover_from_woodland_mansion", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/woodland_mansion")).build()}, LCItems.FOUR_LEAF_CLOVER.get()));

        add("clover_from_simple_dungeon", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build()}, LCItems.FOUR_LEAF_CLOVER.get()));

        add("golden_clover_from_simple_dungeon", new AddGoldenClover(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build()}, LCItems.GOLDEN_CLOVER.get()));

        add("golden_clover_from_mineshaft", new AddGoldenClover(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build()}, LCItems.GOLDEN_CLOVER.get()));

        add("golden_clover_from_bastion_other", new AddGoldenClover(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/bastion_other")).build()}, LCItems.GOLDEN_CLOVER.get()));

        add("golden_clover_from_bastion_hoglin_stable", new AddGoldenClover(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/bastion_hoglin_stable")).build()}, LCItems.GOLDEN_CLOVER.get()));

        add("golden_clover_from_desert_pyramid", new AddGoldenClover(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/desert_pyramid")).build()}, LCItems.GOLDEN_CLOVER.get()));

        add("golden_clover_from_igloo_chest", new AddGoldenClover(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/igloo_chest")).build()}, LCItems.GOLDEN_CLOVER.get()));

        add("golden_clover_from_ruined_portal", new AddGoldenClover(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ruined_portal")).build()}, LCItems.GOLDEN_CLOVER.get()));

        add("golden_clover_from_ruined_portal", new AddGoldenClover(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/stronghold_corridor")).build()}, LCItems.GOLDEN_CLOVER.get()));

        add("golden_clover_from_underwater_ruin_big", new AddGoldenClover(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/underwater_ruin_big")).build()}, LCItems.GOLDEN_CLOVER.get()));

        add("golden_clover_from_woodland_mansion", new AddGoldenClover(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/woodland_mansion")).build()}, LCItems.GOLDEN_CLOVER.get()));



    }
}
