package io.github.mortuusars.sootychimneys.block;

import io.github.mortuusars.sootychimneys.core.ChimneySmokeProperties;
import io.github.mortuusars.sootychimneys.core.ISootyChimney;
import io.github.mortuusars.sootychimneys.setup.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"deprecation", "NullableProblems"})
public class StoneBrickChimneyBlock extends ChimneyBlock implements ISootyChimney {
    private static final VoxelShape  _shape = Shapes.or(
            Block.box(4,0,4, 12,11,12),
            Block.box(3, 11, 3, 13, 16, 13));

    public StoneBrickChimneyBlock(ChimneySmokeProperties smokeProperties, BlockBehaviour.Properties properties) {
        super(smokeProperties, properties);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return _shape;
    }

    @Override
    public Block getCleanVariant() {
        return ModBlocks.STONE_BRICK_CHIMNEY.get();
    }

    @Override
    public Block getDirtyVariant() {
        return ModBlocks.DIRTY_STONE_BRICK_CHIMNEY.get();
    }
}
