package net.lavender.luckyclover.data.logic.util;

import net.minecraftforge.common.ForgeConfigSpec;

public class Configuration
{
	public static ForgeConfigSpec COMMON_CONFIG;
	public static ForgeConfigSpec CLIENT_CONFIG;

	public static final String CATEGORY_WORLD = "world";
	public static ForgeConfigSpec.BooleanValue GENERATE_LC_CHEST_LOOT;

	// CLIENT
	public static final String CATEGORY_CLIENT = "client";

	public static ForgeConfigSpec.BooleanValue NOURISHED_HUNGER_OVERLAY;
	public static ForgeConfigSpec.BooleanValue COMFORT_HEALTH_OVERLAY;
	public static ForgeConfigSpec.BooleanValue FOOD_EFFECT_TOOLTIP;

	static {
		ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

		COMMON_CONFIG = COMMON_BUILDER.build();

		COMMON_BUILDER.comment("World generation").push(CATEGORY_WORLD);
		GENERATE_LC_CHEST_LOOT = COMMON_BUILDER.comment("Spawn clovers and charms in chests across the world?")
				.define("generateLCChestLoot", true);

		ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

		CLIENT_BUILDER.comment("Client settings").push(CATEGORY_CLIENT);
		NOURISHED_HUNGER_OVERLAY = CLIENT_BUILDER.comment("Should the hunger bar have a gilded overlay when the player has the Nourishment effect?")
				.define("nourishmentHungerOverlay", true);
		COMFORT_HEALTH_OVERLAY = CLIENT_BUILDER.comment("Should the health bar have a silver sheen when the player has the Comfort effect?")
				.define("comfortHealthOverlay", true);
		FOOD_EFFECT_TOOLTIP = CLIENT_BUILDER.comment("Should meal and drink tooltips display which effects they provide?")
				.define("foodEffectTooltip", true);
		CLIENT_BUILDER.pop();

		CLIENT_CONFIG = CLIENT_BUILDER.build();
	}
}