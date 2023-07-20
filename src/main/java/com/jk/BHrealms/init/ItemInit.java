package com.jk.BHrealms.init;

import com.jk.BHrealms.BHrealms;
import com.jk.BHrealms.customitems.AdvancedItem;
import com.jk.BHrealms.item.ModArmorMaterials;
import com.jk.BHrealms.item.custom.AnimatedItem;
import com.jk.BHrealms.item.custom.GladArmorItem;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
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



    public static final RegistryObject<ArmorItem> ZOMBIE_HELMET = addToTab(ITEM.register("zombie_helmet",
            () -> new ArmorItem(
                    ArmorMaterialInit.ZOMBIE,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .setNoRepair())
    ));

    public static final RegistryObject<Item> GLAD_HELMET = addToTab(ITEM.register("glad_helmet",
            () -> new GladArmorItem(ModArmorMaterials.GLAD, ArmorItem.Type.HELMET, new Item.Properties())));

    public static final RegistryObject<Item> GLAD_CHESTPLATE = addToTab(ITEM.register("glad_chestplate",
            () -> new GladArmorItem(ModArmorMaterials.GLAD, ArmorItem.Type.CHESTPLATE, new Item.Properties())));

    public static final RegistryObject<Item> GLAD_LEGGINGS = addToTab(ITEM.register("glad_leggings",
            () -> new GladArmorItem(ModArmorMaterials.GLAD, ArmorItem.Type.LEGGINGS, new Item.Properties())));

    public static final RegistryObject<Item> GLAD_BOOTS = addToTab(ITEM.register("glad_boots",
            () -> new GladArmorItem(ModArmorMaterials.GLAD, ArmorItem.Type.BOOTS, new Item.Properties())));

    public static final RegistryObject<Item> EXAMPLE_ITEM = addToTab(ITEM.register("example_item",
            () -> new AdvancedItem(new Item.Properties())));

    public static final RegistryObject<Item> CHAINSWORD= addToTab((ITEM.register("chainsword",
            () -> new AnimatedItem(new Item.Properties()))));

    public static final RegistryObject<Item> EXAMPLE = addToTab(ITEM.register("example",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .alwaysEat()
                            .build())
                    .fireResistant()
                    .stacksTo(32)
                    )

    ));
    public static final RegistryObject<Item> STEROIDS = addToTab(ITEM.register("steroids",
            () -> new Item(new Item.Properties()
                    .stacksTo(16)
                    .food(new FoodProperties.Builder()
                            .effect(() -> new MobEffectInstance(
                                    MobEffects.DAMAGE_BOOST,
                                    9600,
                                    1),
                                    1f
                            )
                            .effect(() -> new MobEffectInstance(
                                            MobEffects.MOVEMENT_SPEED,
                                            9600,
                                            1),
                                    1f
                            )
                            .build())
                    .rarity(Rarity.UNCOMMON)
            )
    ));
}
