package com.jk.BHrealms;

import com.jk.BHrealms.init.BlockInit;
import com.jk.BHrealms.init.CreativeTabInit;
import com.jk.BHrealms.init.ItemInit;
import com.jk.BHrealms.networking.ModNetworking;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
@Mod(BHrealms.MODID)
public class BHrealms {
    public static final String MODID = "bhrealms";

    public BHrealms(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEM.register(bus);
        BlockInit.BLOCKS.register(bus);
        CreativeTabInit.TABS.register(bus);
        ModNetworking.register();
    }
}
