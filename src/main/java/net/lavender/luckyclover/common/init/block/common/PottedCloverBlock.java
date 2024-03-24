package net.lavender.luckyclover.common.init.block.common;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class PottedCloverBlock extends FlowerPotBlock {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public PottedCloverBlock(@Nullable Supplier<FlowerPotBlock> emptyPot, Supplier<? extends Block> pContent, Properties properties) {
        super(emptyPot, pContent, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP));
    }
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        Direction direction = pState.getValue(FACING);
        double d0 = (double)pPos.getX() + 0.60D - (double)(pRandom.nextFloat() * 0.2F);
        double d1 = (double)pPos.getY() + 0.60D - (double)(pRandom.nextFloat() * 0.1F);
        double d2 = (double)pPos.getZ() + 0.60D - (double)(pRandom.nextFloat() * 0.2F);
        double d3 = (double)(0.6F - (pRandom.nextFloat() + pRandom.nextFloat()) * 0.6F);
        if (pRandom.nextInt(6) == 0) {
            pLevel.addParticle(ParticleTypes.END_ROD,
                    d0 + (double)direction.getStepX() * d3, d1 + (double)direction.getStepY() * d3,
                    d2 + (double)direction.getStepZ() * d3, pRandom.nextGaussian() * 0.040D,
                    pRandom.nextGaussian() * 0.040D, pRandom.nextGaussian() * 0.040D); //nextGaussian controls speed
        }
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }
}

