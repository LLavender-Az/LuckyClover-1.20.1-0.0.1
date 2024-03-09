package net.lavender.luckyclover.common.item;

import net.lavender.luckyclover.LuckyClover;
import net.lavender.luckyclover.common.item.common.LuckCharm;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> EDIBLE =
            DeferredRegister.create(ForgeRegistries.ITEMS, LuckyClover.MOD_ID);

// A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

    public static final RegistryObject<Item> FOUR_LEAF_CLOVER = EDIBLE.register("four_leaf_clover", () -> new net.lavender.luckyclover.common.item.common.LuckyClover(props().rarity(Rarity.EPIC)
            .stacksTo(16).food(Edible.FOUR_LEAF_CLOVER)));

    public static final RegistryObject<Item> LUCK_CHARM = EDIBLE.register("luck_charm", () -> new LuckCharm(props().stacksTo(1).rarity(Rarity.EPIC)));



    private static Item.Properties props() {
        return new Item.Properties();
    }

    public static class Edible {
        public static final FoodProperties FOUR_LEAF_CLOVER = new FoodProperties.Builder().nutrition(0).alwaysEat().fast()
                .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.LUCK, 600, 0), 1.0f).build();

    }
}
