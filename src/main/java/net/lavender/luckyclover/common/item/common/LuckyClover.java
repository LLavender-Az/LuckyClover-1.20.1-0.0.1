package net.lavender.luckyclover.common.item.common;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;


public class LuckyClover extends Item {
    public LuckyClover(Properties properties) {
        super(properties);
    }


    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            components.add(Component.literal("Luck 0:30").withStyle(ChatFormatting.BLUE));
        } else {
            components.add(Component.literal("Luck 0:30").withStyle(ChatFormatting.BLUE));
        }

        super.appendHoverText(stack, level, components, flag);
    }

}