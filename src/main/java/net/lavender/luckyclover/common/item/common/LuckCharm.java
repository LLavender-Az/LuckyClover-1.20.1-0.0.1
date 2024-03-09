package net.lavender.luckyclover.common.item.common;

import net.minecraft.ChatFormatting;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.lavender.luckyclover.common.effect.LuckCharmProcedure;

import javax.annotation.Nullable;
import java.util.List;

public class LuckCharm extends Item {
    public LuckCharm(Properties pProperties) {
        super(pProperties);
    }
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
         {
            components.add(Component.literal("You Feel Lucky Just Holding This...").withStyle(ChatFormatting.DARK_GRAY));
        }
        super.appendHoverText(stack, level, components, flag);
    }
    @Override
    public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, world, entity, slot, selected);
        if (selected)
            LuckCharmProcedure.execute(entity);
    }
}
