package com.jk.BHrealms.init;

import com.jk.BHrealms.BHrealms;
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

    public static final RegistryObject<SwordItem> ZomWep1 = addToTab(ITEM.register("zomwep_sword"), () -> new SwordItem(
                    null
            ,5
            , 1.6f
            , new Item.Properties()
    ));



    public static final RegistryObject<ArmorItem> ZOMBIE_HELMET = ITEM.register("zombie_helmet",
            () -> new ArmorItem(
                    ArmorMaterialInit.ZOMBIE,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .setNoRepair())
    );
}
