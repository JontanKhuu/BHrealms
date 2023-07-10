package com.jk.BHrealms.init;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class TierInit {
    public static final ForgeTier ZOMBIE = new ForgeTier(
            4,
            589,
            0.5f,
            5,
            20,
            TagInit.NEEDS_ZOMBIE_TOOL,
            () -> Ingredient.of(ItemInit.ZOMBIE_HELMET::get)
            //() -> Ingredient.of(Items.NETHERITE_INGOT)
    );
}
