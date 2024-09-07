package net.lavender.luckyclover.common;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodValues {
    public static final int BRIEF_DURATION = 600;    // 30 seconds
    public static final int SHORT_DURATION = 1200;    // 1 minute
    public static final int MEDIUM_DURATION = 3600;    // 3 minutes
    public static final int LONG_DURATION = 6000;    // 5 minutes

    public static final FoodProperties FOUR_LEAF_CLOVER = new FoodProperties.Builder().nutrition(0).alwaysEat().fast()
            .saturationMod(0.2F).effect(() -> new MobEffectInstance(MobEffects.LUCK, 300, 0), 1.0F).build();

    public static final FoodProperties GOLDEN_CLOVER = new FoodProperties.Builder().alwaysEat().fast()
            .nutrition(2).saturationMod(1F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 600, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 900, 0), 1.0F)
            .build();


}
