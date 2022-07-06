package com.Tadpolling.indirection_block_mod.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class IndirectionModCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;


    static {
        BUILDER.push("Configs for Tutorial Mod");
        //Configs Go here
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}