package net.lavender.luckyclover.data.logic.loot;

import com.mojang.serialization.Codec;
import net.lavender.luckyclover.LuckyClover;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, LuckyClover.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM;
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_CHANCE_ITEM;
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_LOOT_TABLE;

    static {
        ADD_ITEM = LOOT_MODIFIER_SERIALIZERS.register("add_item", AddItemModifier.CODEC);
        ADD_CHANCE_ITEM = LOOT_MODIFIER_SERIALIZERS.register("add_chance_item", AddChanceModifer.CODEC);
        ADD_LOOT_TABLE = LOOT_MODIFIER_SERIALIZERS.register("add_loot_table", AddLootTableModifier.CODEC);
    }
}