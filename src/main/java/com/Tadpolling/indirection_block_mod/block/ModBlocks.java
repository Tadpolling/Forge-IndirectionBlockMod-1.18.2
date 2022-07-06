package com.Tadpolling.indirection_block_mod.block;

import com.Tadpolling.indirection_block_mod.IndirectionBlockMod;
import com.Tadpolling.indirection_block_mod.block.custom.IndirectionBlock;
import com.Tadpolling.indirection_block_mod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, IndirectionBlockMod.MOD_ID);

    public static final RegistryObject<Block> INDIRECTION_BLOCK=registerBlock("indirection_block", ()->new IndirectionBlock(BlockBehaviour.Properties.of(Material.METAL)
            .instabreak().lightLevel(
                    (pState)->{
                        return 14;
                    }
            ).sound(SoundType.STONE)),CreativeModeTab.TAB_MISC);

    //  public static final RegistryObject<Block> MOB_REPELLENT_BLOCK = registerBlock("mob_repellent_block", ()->mo)

    /*
                    "mob_repellent_block", new TorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((p_50886_) -> {
                    return 14;
            }).sound(SoundType.WOOD), ParticleTypes.FLAME));*/
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
}