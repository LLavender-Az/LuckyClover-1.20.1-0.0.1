package net.lavender.luckyclover.events;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.lavender.luckyclover.LuckyClover;
import net.lavender.luckyclover.common.init.item.LCItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
            Int2ObjectMap<List<VillagerTrades.ItemListing>> sell = event.getTrades();
            Int2ObjectMap<List<VillagerTrades.ItemListing>> buy = event.getTrades();

            // Level 1

            sell.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(LCItems.FOUR_LEAF_CLOVER.get(), 3),
                    new ItemStack(Items.EMERALD, 24),
                    7, 21, 0.02f));

            buy.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(LCItems.FOUR_LEAF_CLOVER.get(), 1),
                    3, 31, 0.02f));

            buy.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 19),
                    new ItemStack(LCItems.FOUR_LEAF_CLOVER.get(), 2),
                    3, 31, 0.02f));

            sell.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(LCItems.LUCK_CHARM.get(), 1),
                    new ItemStack(Items.EMERALD_BLOCK, 4),
                    2, 31, 0.02f));

        }
    }

    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();


        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 12),
                new ItemStack(LCItems.FOUR_LEAF_CLOVER.get(), 1),
                2, 34, 0.2f));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 17),
                new ItemStack(LCItems.FOUR_LEAF_CLOVER.get(), 5),
                1, 65, 0.15f));


    }
}



