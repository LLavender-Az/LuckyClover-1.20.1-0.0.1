package net.lavender.luckyclover.common.item;

import net.lavender.luckyclover.LuckyClover;
import net.lavender.luckyclover.common.FoodValues;
import net.lavender.luckyclover.common.item.custom.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LCItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LuckyClover.MOD_ID);

    public static Item.Properties basicItem() {
        return new Item.Properties();
    }

    public static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties().food(food);
    }

// A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

    public static final RegistryObject<Item> FOUR_LEAF_CLOVER = ITEMS.register("four_leaf_clover", () -> new
            FourLeafClover(foodItem(FoodValues.FOUR_LEAF_CLOVER).rarity(Rarity.UNCOMMON).stacksTo(16)));

    public static final RegistryObject<Item> GOLDEN_CLOVER = ITEMS.register("golden_clover", () -> new
            GoldenClover(foodItem(FoodValues.GOLDEN_CLOVER).rarity(Rarity.RARE).stacksTo(16)));

    public static final RegistryObject<Item> LUCK_CHARM = ITEMS.register("luck_charm", LuckCharm::new);

    public static final RegistryObject<Item> LUCKY_HORSESHOE = ITEMS.register("lucky_horseshoe", LuckyHorseshoe::new);

    }


