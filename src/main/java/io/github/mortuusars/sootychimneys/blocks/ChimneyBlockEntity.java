package io.github.mortuusars.sootychimneys.blocks;

import com.mojang.logging.LogUtils;
import io.github.mortuusars.sootychimneys.config.CommonConfig;
import io.github.mortuusars.sootychimneys.setup.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.slf4j.Logger;

public class ChimneyBlockEntity extends BlockEntity {
    public ChimneyBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.CHIMNEY_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
    }

    public static <T extends BlockEntity> void particleTick(Level level, BlockPos blockPos, BlockState blockState, T t) {
        if (level.getRandom().nextDouble(0.0001d, 1.0d) < CommonConfig.SMOKE_STRENGTH.get()
                && blockState.getBlock() instanceof ChimneyBlock chimney)
            chimney.emitParticles(level, blockPos, blockState);
    }
}
