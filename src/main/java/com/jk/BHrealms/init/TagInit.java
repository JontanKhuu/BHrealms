package com.jk.BHrealms.init;

import com.jk.BHrealms.BHrealms;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class TagInit {
    public static final TagKey<Block> NEEDS_ZOMBIE_TOOL= tag("needs_zombie_tool");
    public static final TagKey<Block> NEEDS_EXAMPLE_TOOL= tag("needs_example_tool");

    private static TagKey<Block> tag(String name) {
        return BlockTags.create(new ResourceLocation(BHrealms.MODID, name));
    }
}

