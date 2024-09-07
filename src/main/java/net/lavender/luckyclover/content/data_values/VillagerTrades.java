package net.lavender.luckyclover.content.data_values;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.lavender.luckyclover.LuckyClover;
import net.lavender.luckyclover.content.item.ModItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;

import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = LuckyClover.MOD_ID)
public class VillagerTrades {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.CLERIC) {
            Int2ObjectMap<List<net.minecraft.world.entity.npc.VillagerTrades.ItemListing>> sell = event.getTrades();
            Int2ObjectMap<List<net.minecraft.world.entity.npc.VillagerTrades.ItemListing>> buy = event.getTrades();


            // Level 1

            sell.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.FOUR_LEAF_CLOVER.get(), 12),
                    new ItemStack(Items.EMERALD, 24),
                    7, 16, 0.02f));

            buy.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ModItems.FOUR_LEAF_CLOVER.get(), 1),
                    3, 14, 0.02f));


            buy.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 17),
                    new ItemStack(ModItems.FOUR_LEAF_CLOVER.get(), 7),
                    3, 15, 0.02f));

            sell.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.GOLDEN_PENDANT.get(), 1),
                    new ItemStack(Items.EMERALD_BLOCK, 4),
                    2, 31, 0.02f));

            sell.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.GOLDEN_PENDANT.get(), 1),
                    new ItemStack(Items.DIAMOND_BLOCK,3),
                    1, 31, 0.02f));

            sell.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.LUCKY_HORSESHOE.get(), 1),
                    new ItemStack(Items.EMERALD, 4),
                    4, 21, 0.02f));

            sell.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.LUCKY_HORSESHOE.get(), 1),
                    new ItemStack(Items.DIAMOND, 1),
                    3, 22, 0.02f));


        }
    }

    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<net.minecraft.world.entity.npc.VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<net.minecraft.world.entity.npc.VillagerTrades.ItemListing> rareTrades = event.getRareTrades();


        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 12),
                new ItemStack(ModItems.FOUR_LEAF_CLOVER.get(), 1),
                2, 21, 0.2f));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 17),
                new ItemStack(ModItems.FOUR_LEAF_CLOVER.get(), 5),
                2, 24, 0.15f));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 21),
                new ItemStack(ModItems.LUCKY_HORSESHOE.get(), 1),
                1, 37, 0.20f));

    }
}



