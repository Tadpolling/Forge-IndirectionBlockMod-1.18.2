package com.Tadpolling.indirection_block_mod;

import com.Tadpolling.indirection_block_mod.block.ModBlocks;
import com.Tadpolling.indirection_block_mod.block.entity.ModBlockEntities;
import com.Tadpolling.indirection_block_mod.config.IndirectionModClientConfigs;
import com.Tadpolling.indirection_block_mod.config.IndirectionModCommonConfigs;
import com.Tadpolling.indirection_block_mod.config.IndirectionModServerConfigs;
import com.Tadpolling.indirection_block_mod.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(IndirectionBlockMod.MOD_ID)
public class IndirectionBlockMod
{
    public static final String MOD_ID="indirection_block_mod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public IndirectionBlockMod()
    {
        IEventBus modEventBus= FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        //Loading Our Configs
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, IndirectionModClientConfigs.SPEC,"tutorialmod-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, IndirectionModCommonConfigs.SPEC,"tutorialmod-common.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, IndirectionModServerConfigs.SPEC,"tutorialmod-server.toml");

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

}
