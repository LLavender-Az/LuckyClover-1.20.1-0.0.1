package net.lavender.luckyclover.integration;

import javax.annotation.ParametersAreNonnullByDefault;

import net.lavender.luckyclover.content.item.ModItems;
import net.minecraft.MethodsReturnNonnullByDefault;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.lavender.luckyclover.data.logic.util.TextUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@JeiPlugin
public class JEIPlugin implements IModPlugin {
    private static final ResourceLocation ID = new ResourceLocation("luckyclover", "jei_plugin");

    public void registerRecipes(IRecipeRegistration registration) {

        registration.addIngredientInfo(new ItemStack((ItemLike) ModItems.GOLDEN_PENDANT.get()), VanillaTypes.ITEM_STACK, new Component[]{TextUtils.getTranslation("jei.info.luck_charm", new Object[0])});

    }

    public ResourceLocation getPluginUid() {
        return ID;
    }
}
