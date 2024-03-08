package net.lavender.luckyclover;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.lavender.luckyclover.common.item.ItemInit;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;

import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = LuckyClover.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.CLERIC) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // Level 1

            //buying

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 19),
                    new ItemStack(ItemInit.FOUR_LEAF_CLOVER.get(), 2),
                    3, 31, 0.02f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ItemInit.FOUR_LEAF_CLOVER.get(), 3),
                    new ItemStack(Items.EMERALD, 24),
                    7, 21, 0.02f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ItemInit.FOUR_LEAF_CLOVER.get(), 1),
                    3, 31, 0.02f));

        }
    }

    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 12),
                new ItemStack(ItemInit.FOUR_LEAF_CLOVER.get(), 1),
                2, 34, 0.2f));
        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 24),
                new ItemStack(ItemInit.FOUR_LEAF_CLOVER.get(), 5),
                1, 65, 0.15f));
    }
}


