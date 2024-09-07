package net.lavender.luckyclover.content.fluid;

import net.lavender.luckyclover.data.logic.util.FluidType;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModFluids {
    public static DeferredRegister<net.minecraftforge.fluids.FluidType> FLUID_TYPES;
    public static DeferredRegister<Fluid> FLUIDS;

    public static RegistryObject<net.minecraftforge.fluids.FluidType> CLOVER_BREW_TYPE;
    public static RegistryObject<FlowingFluid> CLOVER_BREW;
    public static RegistryObject<FlowingFluid> FLOWING_CLOVER_BREW;
    public static ForgeFlowingFluid.Properties CLOVER_BREW_PROPERTIES;
    public static RegistryObject<net.minecraftforge.fluids.FluidType> GLOW_BERRY_JUICE_TYPE;
    public static RegistryObject<FlowingFluid> GLOW_BERRY_JUICE;
    public static RegistryObject<FlowingFluid> FLOWING_GLOW_BERRY_JUICE;
    public static ForgeFlowingFluid.Properties GLOW_BERRY_JUICE_PROPERTIES;



    static {

        FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, "luckyclover");
        FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, "luckyclover");

        /*
         * Drinks
         */
        CLOVER_BREW_TYPE = FLUID_TYPES.register("clover_brew_type", () -> new FluidType(-4864189));CLOVER_BREW = FLUIDS.register("clover_brew", () -> new ForgeFlowingFluid.Source(CLOVER_BREW_PROPERTIES));FLOWING_CLOVER_BREW = FLUIDS.register("flowing_clover_brew", () -> new ForgeFlowingFluid.Flowing(CLOVER_BREW_PROPERTIES));CLOVER_BREW_PROPERTIES = new ForgeFlowingFluid.Properties(CLOVER_BREW_TYPE, CLOVER_BREW, FLOWING_CLOVER_BREW);
        GLOW_BERRY_JUICE_TYPE = FLUID_TYPES.register("glow_berry_juice_type", () -> new FluidType(-22784));GLOW_BERRY_JUICE = FLUIDS.register("glow_berry_juice", () -> new ForgeFlowingFluid.Source(GLOW_BERRY_JUICE_PROPERTIES));FLOWING_GLOW_BERRY_JUICE = FLUIDS.register("flowing_glow_berry_juice", () -> new ForgeFlowingFluid.Flowing(GLOW_BERRY_JUICE_PROPERTIES));GLOW_BERRY_JUICE_PROPERTIES = new ForgeFlowingFluid.Properties(GLOW_BERRY_JUICE_TYPE, GLOW_BERRY_JUICE, FLOWING_GLOW_BERRY_JUICE);

    }
}