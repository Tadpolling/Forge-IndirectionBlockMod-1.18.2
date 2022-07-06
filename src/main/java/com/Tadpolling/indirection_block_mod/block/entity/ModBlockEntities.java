package com.Tadpolling.indirection_block_mod.block.entity;

import com.Tadpolling.indirection_block_mod.IndirectionBlockMod;
import com.Tadpolling.indirection_block_mod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES=
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, IndirectionBlockMod.MOD_ID);
    //BlockEntityType.Builder.of()
    public static final RegistryObject<BlockEntityType<IndirectionBlockEntity>> MOB_REPPLLENT_BLOCK_ENTITY=
            BLOCK_ENTITIES.register("mob_repellent_block_entity",()->
                    BlockEntityType.Builder.of(IndirectionBlockEntity::new,
                            ModBlocks.INDIRECTION_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus)
    {
        BLOCK_ENTITIES.register(eventBus);
    }

}