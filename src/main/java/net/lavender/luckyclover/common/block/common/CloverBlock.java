package net.lavender.luckyclover.common.block.common;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
 public class CloverBlock extends FlowerBlock implements SuspiciousEffectHolder {
   public static final float AABB_OFFSET = 3.0F;
 public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final VoxelShape SHAPE = Block.box(5.5, 0, 5.5, 10.5, 8, 10.5);
    public CloverBlock(MobEffect suspiciousStewEffect, int effectDuration, BlockBehaviour.Properties pProperties) {
        super(suspiciousStewEffect, effectDuration, pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP));
    }
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Vec3 vec3 = pState.getOffset(pLevel, pPos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }
    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return false;
    }
    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 60;
    }
    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 100;
    }
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        Direction direction = pState.getValue(FACING);
        double d0 = (double)pPos.getX() + 0.55D - (double)(pRandom.nextFloat() * 0.2F);
        double d1 = (double)pPos.getY() + 0.55D - (double)(pRandom.nextFloat() * 0.1F);
        double d2 = (double)pPos.getZ() + 0.55D - (double)(pRandom.nextFloat() * 0.2F);
        double d3 = (double)(0.6F - (pRandom.nextFloat() + pRandom.nextFloat()) * 0.6F);
        if (pRandom.nextInt(6) == 0) {
            pLevel.addParticle(ParticleTypes.END_ROD,
                    d0 + (double)direction.getStepX() * d3, d1 + (double)direction.getStepY() * d3,
                    d2 + (double)direction.getStepZ() * d3, pRandom.nextGaussian() * 0.040D,
                    pRandom.nextGaussian() * 0.040D, pRandom.nextGaussian() * 0.040D); //nextGaussian controls speed
        }
    }
    public boolean isPathfindable(BlockState p_154341_, BlockGetter p_154342_, BlockPos p_154343_, PathComputationType p_154344_) {
        return true;
    }
     protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
         pBuilder.add(FACING);
     }
 }
