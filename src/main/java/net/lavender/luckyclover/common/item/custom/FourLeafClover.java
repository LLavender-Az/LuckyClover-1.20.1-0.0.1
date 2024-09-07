package net.lavender.luckyclover.common.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;


public class FourLeafClover extends Item {
    public FourLeafClover(Properties properties) {
        super(properties);
    }
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        {
            components.add(Component.literal("Luck (0:15)").withStyle(ChatFormatting.BLUE));
        }
        super.appendHoverText(stack, level, components, flag);
    }

}
