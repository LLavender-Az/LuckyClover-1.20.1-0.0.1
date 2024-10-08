package net.lavender.luckyclover.common.item.common;

import java.util.Map;
import java.util.Properties;


import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio.DropRule;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public abstract class ItemBaseCurio extends Item implements ICurioItem {
	public ItemBaseCurio(Properties props) {
		super(props);
	}

	@Override
	public void onEquip(SlotContext context, ItemStack prevStack, ItemStack stack) {
		// Insert existential void here
	}

	@Override
	public void onUnequip(SlotContext context, ItemStack newStack, ItemStack stack) {
		// Insert existential void here
	}

	@Override
	public void curioTick(SlotContext context, ItemStack stack) {
		// Insert existential void here
	}

	@Override
	public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) {
		// Insert existential void here
	}

	@Override
	public boolean canEquipFromUse(SlotContext context, ItemStack stack) {
		return true;
	}

	@Override
	public boolean canUnequip(SlotContext context, ItemStack stack) {
		return true;
	}

	@Override
	public DropRule getDropRule(SlotContext slotContext, DamageSource source, int lootingLevel, boolean recentlyHit, ItemStack stack) {
		return DropRule.DEFAULT;
	}
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		Map<Enchantment, Integer> list = EnchantmentHelper.getEnchantments(book);

		if (list.size() == 1 && list.containsKey(Enchantments.BINDING_CURSE))
			return true;
		else
			return super.isBookEnchantable(stack, book);
	}

}