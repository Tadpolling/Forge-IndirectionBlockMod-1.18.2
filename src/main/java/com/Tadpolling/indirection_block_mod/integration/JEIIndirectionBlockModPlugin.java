package com.Tadpolling.indirection_block_mod.integration;

import com.Tadpolling.indirection_block_mod.IndirectionBlockMod;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class JEIIndirectionBlockModPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(IndirectionBlockMod.MOD_ID,"jei_plugin");
    }

}
