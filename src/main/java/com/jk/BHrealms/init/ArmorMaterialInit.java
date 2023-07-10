package com.jk.BHrealms.init;

import com.jk.BHrealms.init.tiers.ModArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorMaterialInit {
    public static final ModArmorMaterial ZOMBIE = new ModArmorMaterial(
            new int[] {256,451,381,321},
            new int[] { 2, 4, 3, 1},
            20,
            SoundEvents.ARMOR_EQUIP_CHAIN,
            () -> Ingredient.of(ItemInit.ZOMBIE_HELMET::get),
            "zombie",
            0.1f,
            0.2f
    );
}