package com.jk.BHrealms;

import com.jk.BHrealms.Init.BlockInit;
import com.jk.BHrealms.Init.ItemInit;
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
    }
}
