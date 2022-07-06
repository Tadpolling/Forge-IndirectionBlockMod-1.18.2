package com.Tadpolling.indirection_block_mod.block.entity;

//import com.Tadpolling.indirection_block_mod.config.TutorialModServerConfigs;
import com.Tadpolling.indirection_block_mod.config.IndirectionModServerConfigs;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;


public class IndirectionBlockEntity  extends BlockEntity {
    protected static final int RADIUS_OF_EFFECT= IndirectionModServerConfigs.MOB_INDIRECT_BLOCK_RANGE.get();
    protected static final int RANGE_OF_Y_FOR_MOVEMENT=2;
    public IndirectionBlockEntity(BlockPos pPos, BlockState pState) {

        super(ModBlockEntities.MOB_REPPLLENT_BLOCK_ENTITY.get(), pPos, pState);
    }
    public static void tick(Level level, BlockPos pBlockPos, BlockState state, IndirectionBlockEntity blockEntity) {
        if (!level.isClientSide())
        {
            AABB Radius=new AABB(pBlockPos.getX()-RADIUS_OF_EFFECT,pBlockPos.getY()-RADIUS_OF_EFFECT,pBlockPos.getZ()-RADIUS_OF_EFFECT,
                    pBlockPos.getX()+RADIUS_OF_EFFECT,pBlockPos.getY()+RADIUS_OF_EFFECT,pBlockPos.getZ()+RADIUS_OF_EFFECT );

            List<Monster> mobList=level.getEntitiesOfClass(Monster.class,Radius);
            mobList.forEach((mob)->{
                //mob.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,2,1,
                //       false,true,false));
                Vec3 mobPos=mob.getPosition(0);
                //double newY=(mobPos.y< pBlockPos.getY()&&pBlockPos.getY()-mobPos.y<RANGE_OF_Y_FOR_MOVEMENT)? pBlockPos.getY()-mobPos.y:0;
                double newY=mobPos.y< pBlockPos.getY()?pBlockPos.getY()-mobPos.y:0;
                mob.move(MoverType.SELF, new Vec3(mobPos.x-pBlockPos.getX(),newY,mobPos.z-pBlockPos.getZ()));


            });


        }
    }

}