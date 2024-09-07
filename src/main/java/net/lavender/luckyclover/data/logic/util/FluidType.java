package net.lavender.luckyclover.data.logic.util;

import java.util.function.Consumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;

public class FluidType extends net.minecraftforge.fluids.FluidType {
    public static final ResourceLocation FLUID_STILL_TEXTURE = new ResourceLocation("block/water_still");
    public static final ResourceLocation FLUID_FLOWING_TEXTURE = new ResourceLocation("block/water_flow");
    private final int tintColor;

    public FluidType(int tintColor) {
        super(Properties.create().sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
        this.tintColor = tintColor;
    }

    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            public ResourceLocation getStillTexture() {
                return FluidType.FLUID_STILL_TEXTURE;
            }

            public ResourceLocation getFlowingTexture() {
                return FluidType.FLUID_FLOWING_TEXTURE;
            }

            public int getTintColor() {
                return FluidType.this.tintColor;
            }
        });
    }
}