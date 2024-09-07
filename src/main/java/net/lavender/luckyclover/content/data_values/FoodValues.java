package net.lavender.luckyclover.content.data_values;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodValues {

    public static final int BRIEF_DURATION = 600;    // 30 seconds
    public static final int SHORT_DURATION = 1200;    // 1 minute
    public static final int MEDIUM_DURATION = 3600;    // 3 minutes
    public static final int LONG_DURATION = 6000;    // 5 minutes

    public static final FoodProperties THREE_LEAF_CLOVER = new FoodProperties.Builder().alwaysEat().build();

    public static final FoodProperties FOUR_LEAF_CLOVER = new FoodProperties.Builder().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 400, 0), 1.0F).build();

    public static final FoodProperties GOLDEN_FOUR_LEAF_CLOVER = new FoodProperties.Builder().alwaysEat()
            .nutrition(2).saturationMod(1F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 900, 0), 1.0F)
            .build();

    public static final FoodProperties HAM = new FoodProperties.Builder().meat()
            .nutrition(5).saturationMod(0.3F).build();

    public static final FoodProperties SMOKED_HAM = new FoodProperties.Builder().meat()
            .nutrition(10).saturationMod(0.8F).build();

    public static final FoodProperties FRIED_EGG = new FoodProperties.Builder().meat()
            .nutrition(4).saturationMod(0.4F).build();

    public static final FoodProperties GREEN_EGG = new FoodProperties.Builder().meat()
            .nutrition(4).saturationMod(0.4F).build();

    public static final FoodProperties GLOWBERRY_ICE_CREAM = new FoodProperties.Builder()
            .nutrition(8).saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 200, 0), 1.0F)
            .build();

    public static final FoodProperties GREEN_EGGS_AND_HAM = new FoodProperties.Builder()
            .nutrition(14).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 900, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 0), 1.0F)
            .build();

    public static final FoodProperties ADHMOR_SODA = new FoodProperties.Builder().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 400, 0), 1.0F)
            .build();

    public static final FoodProperties FRUIT_JUICE = new FoodProperties.Builder().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 200, 0), 1.0F)
            .build();

    public static final FoodProperties GLOWBERRY_JUICE = new FoodProperties.Builder().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 200, 0), 1.0F)
            .build();

    public static final FoodProperties CLOVER_BREW = new FoodProperties.Builder().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 1800, 0), 1.0F)
            .build();

    public static final FoodProperties CLOVER_SHAKE = new FoodProperties.Builder().alwaysEat()
            .nutrition(6).saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 900, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 1800, 0), 1.0F)
            .build();
}
