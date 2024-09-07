package net.lavender.luckyclover;

import net.minecraftforge.common.ForgeConfigSpec;

public class Configuration
{
	public static ForgeConfigSpec COMMON_CONFIG;

	public static final String CATEGORY_WORLD = "world";
	public static ForgeConfigSpec.BooleanValue GENERATE_LC_CHEST_LOOT;



	static {
		ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

		COMMON_BUILDER.comment("World generation").push(CATEGORY_WORLD);
		GENERATE_LC_CHEST_LOOT = COMMON_BUILDER.comment("Do you want to add Clovers to chests :3?")
				.define("generateLCChestLoot", true);
		COMMON_BUILDER.pop();
		

		COMMON_CONFIG = COMMON_BUILDER.build();
	}
}