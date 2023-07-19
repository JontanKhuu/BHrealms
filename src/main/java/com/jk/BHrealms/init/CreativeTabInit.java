package com.jk.BHrealms.init;

import com.jk.BHrealms.BHrealms;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = BHrealms.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BHrealms.MODID);

    public static final List<Supplier<? extends ItemLike>> EXAMPLE_TAB_ITEMS = new ArrayList<>();


    public static final RegistryObject<CreativeModeTab> BH_REALMS = TABS.register("bhrealms_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.bhrealms_tab"))
                    //.icon( () -> new ItemStack(ItemInit.EXAMPLE_BLOCK_ITEM.get()))
                    .icon(ItemInit.GLAD_HELMET.get()::getDefaultInstance)
                    .displayItems((displayParams, output) ->
                            EXAMPLE_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get()))
                    )
                    .build()
    );

    public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike) {
        EXAMPLE_TAB_ITEMS.add(itemLike);
        return itemLike;
    }
    /*@SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ItemInit.EXAMPLE_BLOCK_ITEM);
            event.getEntries().putAfter(Items.ACACIA_LOG.getDefaultInstance(), ItemInit.EXAMPLE_BLOCK_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }*/
}