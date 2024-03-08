package net.lavender.luckyclover;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.lavender.luckyclover.common.item.ItemInit;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;

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
                    new ItemStack(Items.EMERALD, 17),
                    new ItemStack(ItemInit.FOUR_LEAF_CLOVER.get(), 1),
                    3, 31, 0.02f));

        }
    }
}

    //    if (event.getType() == VillagerProfession.LIBRARIAN) {
     //       Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
       //     ItemStack enchantedBook = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(Enchantments.THORNS, 2));

            // Level 1
         //   trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
          //          new ItemStack(Items.EMERALD, 32),
            //        enchantedBook,
            //        2, 8, 0.02f));
      //  }
   // }
// }



  //  @SubscribeEvent
  //  public static void addCustomWanderingTrades(WandererTradesEvent event) {
     //   List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
    //    List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

     //   genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
     //           new ItemStack(Items.EMERALD, 12),
      //          new ItemStack(ModItems.SAPPHIRE_BOOTS.get(), 1),
       //         3, 2, 0.2f));

      //  rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
        //        new ItemStack(Items.EMERALD, 24),
       //         new ItemStack(ModItems.METAL_DETECTOR.get(), 1),
        //        2, 12, 0.15f))