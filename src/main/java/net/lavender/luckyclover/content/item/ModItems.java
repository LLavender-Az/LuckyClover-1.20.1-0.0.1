package net.lavender.luckyclover.content.item;

import net.lavender.luckyclover.LuckyClover;
import net.lavender.luckyclover.content.data_values.FoodValues;
import net.lavender.luckyclover.content.item.common.ConsumableItem;
import net.lavender.luckyclover.content.item.common.DrinkableItem;
import net.lavender.luckyclover.content.item.common.SodaCanItem;
import net.lavender.luckyclover.content.item.curios.GoldRing;
import net.lavender.luckyclover.content.item.curios.GoldenPendant;
import net.lavender.luckyclover.content.item.curios.LuckyHorseshoe;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LuckyClover.MOD_ID);

    public static Item.Properties basicItem() {
        return new Item.Properties();
    }
    public static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties().food(food);
    }
    public static Item.Properties drinkItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
    }
    public static Item.Properties bowlItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.BOWL).stacksTo(16);
    }

    public static final RegistryObject<Item> LUCKY_HORSESHOE;
    public static final RegistryObject<Item> GOLD_RING;
    public static final RegistryObject<Item> GOLDEN_PENDANT;
    public static final RegistryObject<Item> THREE_LEAF_CLOVER;
    public static final RegistryObject<Item> FOUR_LEAF_CLOVER;
    public static final RegistryObject<Item> GOLDEN_FOUR_LEAF_CLOVER;
    public static final RegistryObject<Item> HAM;
    public static final RegistryObject<Item> SMOKED_HAM;
    public static final RegistryObject<Item> FRIED_EGG;
    public static final RegistryObject<Item> GREEN_EGG;
    public static final RegistryObject<Item> GLOW_BERRY_ICE_CREAM;
    public static final RegistryObject<Item> GREEN_EGGS_AND_HAM;
    public static final RegistryObject<Item> EMPTY_CAN;
    public static final RegistryObject<Item> ADHMOR_SODA;
    public static final RegistryObject<Item> FRUIT_JUICE;
    public static final RegistryObject<Item> GLOW_BERRY_JUICE;
    public static final RegistryObject<Item> CLOVER_BREW;
    public static final RegistryObject<Item> CLOVER_SHAKE;

    static {

        LUCKY_HORSESHOE = ITEMS.register("lucky_horseshoe", LuckyHorseshoe::new);
        GOLD_RING = ITEMS.register("gold_ring", GoldRing::new);
        GOLDEN_PENDANT = ITEMS.register("golden_pendant", GoldenPendant::new);
        THREE_LEAF_CLOVER = ITEMS.register("three_leaf_clover", () -> new ConsumableItem(foodItem(FoodValues.THREE_LEAF_CLOVER)));
        FOUR_LEAF_CLOVER = ITEMS.register("four_leaf_clover", () -> new ConsumableItem(foodItem(FoodValues.FOUR_LEAF_CLOVER).rarity(Rarity.UNCOMMON), true));
        GOLDEN_FOUR_LEAF_CLOVER = ITEMS.register("golden_four_leaf_clover", () -> new ConsumableItem(foodItem(FoodValues.GOLDEN_FOUR_LEAF_CLOVER).rarity(Rarity.RARE), true));
        HAM = ITEMS.register("ham", () -> new ConsumableItem(foodItem(FoodValues.HAM)));
        SMOKED_HAM = ITEMS.register("smoked_ham", () -> new ConsumableItem(foodItem(FoodValues.SMOKED_HAM)));
        FRIED_EGG = ITEMS.register("fried_egg", () -> new ConsumableItem(bowlItem(FoodValues.FRIED_EGG)));
        GREEN_EGG = ITEMS.register("green_egg", () -> new ConsumableItem(bowlItem(FoodValues.GREEN_EGG)));
        GLOW_BERRY_ICE_CREAM = ITEMS.register("glow_berry_ice_cream", () -> new ConsumableItem(bowlItem(FoodValues.GLOWBERRY_ICE_CREAM), true));
        GREEN_EGGS_AND_HAM = ITEMS.register("green_eggs_and_ham", () -> new ConsumableItem(bowlItem(FoodValues.GREEN_EGGS_AND_HAM), true));
        ADHMOR_SODA = ITEMS.register("adhmor_soda", () -> new SodaCanItem(drinkItem(FoodValues.ADHMOR_SODA), true));
        FRUIT_JUICE = ITEMS.register("fruit_juice", () -> new SodaCanItem(drinkItem(FoodValues.FRUIT_JUICE), true));
        GLOW_BERRY_JUICE = ITEMS.register("glow_berry_juice", () -> new DrinkableItem(drinkItem(FoodValues.GLOWBERRY_JUICE), true));
        CLOVER_BREW = ITEMS.register("clover_brew", () -> new DrinkableItem(drinkItem(FoodValues.CLOVER_BREW), true));
        CLOVER_SHAKE = ITEMS.register("clover_shake", () -> new DrinkableItem(drinkItem(FoodValues.CLOVER_SHAKE), true));

        EMPTY_CAN = ITEMS.register("empty_can", () -> new Item(basicItem()));


    }
}


