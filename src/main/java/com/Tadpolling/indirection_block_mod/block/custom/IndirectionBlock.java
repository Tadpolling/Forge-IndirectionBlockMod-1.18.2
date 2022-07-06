package com.Tadpolling.indirection_block_mod.block.custom;

import com.Tadpolling.indirection_block_mod.block.entity.IndirectionBlockEntity;
import com.Tadpolling.indirection_block_mod.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;


public class IndirectionBlock extends BaseEntityBlock {

    public IndirectionBlock(Properties properties) {
        super(properties);
        // properties.randomTicks();

    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
        return new IndirectionBlockEntity(pBlockPos,pBlockState);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        // return type == ModBlockEntities.MOB_REPPLLENT_BLOCK_ENTITY.get()? MobRepellentBlockEntity::tick : null;
        return createTickerHelper(type,ModBlockEntities.MOB_REPPLLENT_BLOCK_ENTITY.get(),
                IndirectionBlockEntity::tick);
    }
}
