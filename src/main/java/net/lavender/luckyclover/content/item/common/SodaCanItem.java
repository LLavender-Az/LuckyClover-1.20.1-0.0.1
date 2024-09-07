package net.lavender.luckyclover.content.item.common;

import net.lavender.luckyclover.content.item.ModItems;
import net.lavender.luckyclover.data.logic.util.Configuration;
import net.lavender.luckyclover.data.logic.util.TextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Properties;

public class SodaCanItem extends Item {

   public final boolean hasFoodEffectTooltip;
   public final boolean hasCustomTooltip;

   public SodaCanItem(Item.Properties pProperties) {
      super(pProperties);
      this.hasFoodEffectTooltip = false;
      this.hasCustomTooltip = false;

   }
   public SodaCanItem(Properties properties, boolean hasFoodEffectTooltip) {
      super(properties);
      this.hasFoodEffectTooltip = hasFoodEffectTooltip;
      this.hasCustomTooltip = false;

   }
   public SodaCanItem(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
      super(properties);
      this.hasFoodEffectTooltip = hasFoodEffectTooltip;
      this.hasCustomTooltip = hasCustomTooltip;

   }
   @Override
   public int getUseDuration(ItemStack stack) {
      return 32;
   }
   @Override
   public UseAnim getUseAnimation(ItemStack stack) {
      return UseAnim.DRINK;
   }
   @Override
   public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
      return new ItemStack(ModItems.EMPTY_CAN.get());
   }

   public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
      if (!level.isClientSide) {
         this.affectConsumer(stack, level, consumer);
      }

      ItemStack containerStack = new ItemStack(ModItems.EMPTY_CAN.get());

      if (stack.isEdible()) {
         super.finishUsingItem(stack, level, consumer);
      } else {
         Player player = consumer instanceof Player ? (Player) consumer : null;
         if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer) player, stack);
         }
         if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
               stack.shrink(1);
            }
         }
      }

      if (stack.isEmpty()) {
         return containerStack;
      } else {
         if (consumer instanceof Player player && !((Player) consumer).getAbilities().instabuild) {
            if (!player.getInventory().add(containerStack)) {
               player.drop(containerStack, false);
            }
         }
         return stack;
      }
   }
   public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
   }

   @Override
   public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
      if (Configuration.FOOD_EFFECT_TOOLTIP.get()) {
         if (this.hasCustomTooltip) {
            MutableComponent textEmpty = TextUtils.getTranslation("tooltip." + this);
            tooltip.add(textEmpty.withStyle(ChatFormatting.BLUE));
         }
         if (this.hasFoodEffectTooltip) {
            TextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
         }
      }
   }

   @Override
   public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
      ItemStack heldStack = player.getItemInHand(hand);
      if (heldStack.isEdible()) {
         if (player.canEat(heldStack.getFoodProperties(player).canAlwaysEat())) {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(heldStack);
         } else {
            return InteractionResultHolder.fail(heldStack);
         }
      }
      return ItemUtils.startUsingInstantly(level, player, hand);
   }
}
