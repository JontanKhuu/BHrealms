package com.jk.BHrealms.init;

import com.jk.BHrealms.BHrealms;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,BHrealms.MODID);

    public static final List<Supplier<? extends ItemLike>> TAB_ITEMS = new ArrayList<>();
    public static final RegistryObject<CreativeModeTab> ZOM_TAB = TABS.register("zom_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.zom_tab"))
                    .icon(ItemInit.ZomWep1.get()::getDefaultInstance)
                    .displayItems((displayParams,output) -> {
                        output.accept(ItemInit.ZomWep1.get());
                    })
                    .build()
    );
    public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike){
        TAB_ITEMS.add(itemLike);
        return itemLike;
    }
}
