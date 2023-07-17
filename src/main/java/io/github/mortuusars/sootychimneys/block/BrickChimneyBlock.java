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
public class BrickChimneyBlock extends ChimneyBlock implements ISootyChimney {
    private static final VoxelShape _shape = Shapes.or(
            Block.box(1d, 0d, 1d, 15d,11d,15d),
            Block.box(0d, 11d, 0d, 16d,16d,16d));

    public BrickChimneyBlock(ChimneySmokeProperties smokeProperties, BlockBehaviour.Properties properties) {
        super(smokeProperties, properties);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return _shape;
    }

    @NotNull
    @Override
    public Block getCleanVariant() {
        return ModBlocks.BRICK_CHIMNEY.get(); //can't return 'this' here because Dirty variant will have wrong clean block, and 'this' breaks scraping with axe
    }

    @NotNull
    @Override
    public Block getDirtyVariant() {
        return ModBlocks.DIRTY_BRICK_CHIMNEY.get();
    }

    @Override
    public float getScrapingDropChance() {
        return 0.75f;
    }
}
