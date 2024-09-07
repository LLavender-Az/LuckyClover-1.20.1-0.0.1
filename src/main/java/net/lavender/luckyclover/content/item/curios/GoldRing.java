package net.lavender.luckyclover.content.item.curios;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.lavender.luckyclover.LuckyClover;
import net.lavender.luckyclover.content.item.common.ItemBaseCurio;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.enchantment.Enchantment;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.UUID;

public class GoldRing extends ItemBaseCurio {
    public GoldRing() {
        super(new Properties().rarity(Rarity.RARE).stacksTo(1));
    }
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = HashMultimap.create();
        attributes.put(Attributes.LUCK, new AttributeModifier(UUID.fromString("6c913e9a-0d6f-4b3b-81b9-4c82f7778b52"), LuckyClover.MOD_ID+":luck_bonus", 2.0, AttributeModifier.Operation.ADDITION));
        attributes.put(Attributes.ARMOR, new AttributeModifier(UUID.fromString("6c913e9a-0d6f-4b3b-81b9-4c82f7778b52"), LuckyClover.MOD_ID+":armor_bonus", 1.0, AttributeModifier.Operation.ADDITION));

        return attributes;
    }
    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true; }
    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }
    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }
    @Override
    public ICurio.SoundInfo getEquipSound(SlotContext slotContext, ItemStack stack) {
        return new ICurio.SoundInfo(SoundEvents.ARMOR_EQUIP_GOLD, 1.0F, 1.0F);
    }
}