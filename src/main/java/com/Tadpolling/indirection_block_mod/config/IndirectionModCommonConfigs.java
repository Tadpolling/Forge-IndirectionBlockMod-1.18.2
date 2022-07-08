package com.Tadpolling.indirection_block_mod.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class IndirectionModCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec.ConfigValue<Integer> MOB_INDIRECT_BLOCK_RANGE;
    public static final ForgeConfigSpec SPEC;


    static {
        BUILDER.push("Configs for Tutorial Mod");
        //Configs Go here
        MOB_INDIRECT_BLOCK_RANGE = BUILDER.comment("Range the Indirection BLock Pushes Hostile Mobs Away")
                .defineInRange("Indirection Block Range", 8, 1, 64);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}