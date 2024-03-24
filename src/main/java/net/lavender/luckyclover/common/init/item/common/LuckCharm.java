package net.lavender.luckyclover.common.init.item.common;

import net.minecraft.ChatFormatting;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.lavender.luckyclover.procedures.LuckCharmProcedure;

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
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        LuckCharmProcedure.execute(entity);
        return ar;
    }
}