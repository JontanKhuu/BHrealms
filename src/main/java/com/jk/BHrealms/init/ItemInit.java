package com.jk.BHrealms.init;

import com.jk.BHrealms.BHrealms;
import com.jk.BHrealms.Entity.Custom.GladArmorItem;
import com.jk.BHrealms.Entity.Custom.ModArmorMaterials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import static com.jk.BHrealms.init.CreativeTabInit.addToTab;
public class ItemInit {
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, BHrealms.MODID);

    public static final RegistryObject<SwordItem> ZomWep1 = addToTab(ITEM.register("zomwep_sword", () -> new SwordItem(
            TierInit.ZOMBIE,
            5,
            1.6f,
            new Item.Properties()
    )));
    public static final RegistryObject<ArmorItem> ZOMBIE_HELMET = ITEM.register("zombie_helmet",
            () -> new ArmorItem(
                    ArmorMaterialInit.ZOMBIE,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .setNoRepair())
    );

    public static final RegistryObject<Item> GLAD_HELMET = ITEM.register("glad_helmet",
    () -> new GladArmorItem(ModArmorMaterials.GLAD, ArmorItem.Type.HELMET, new Item.Properties()));
 /*   public static final RegistryObject<Item> GLAD_CHESTPLATE = ITEM.register("glad_chestplate",
            () -> new GladArmorItem(ModArmorMaterials.GLAD, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GLAD_LEGGINGS = ITEM.register("glad_leggings",
            () -> new GladArmorItem(ModArmorMaterials.GLAD, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GLAD_BOOTS = ITEM.register("glad_boots",
            () -> new GladArmorItem(ModArmorMaterials.GLAD, ArmorItem.Type.BOOTS, new Item.Properties())); */
}
