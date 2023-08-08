package com.jk.BHrealms.event;


import com.jk.BHrealms.BHrealms;
import com.jk.BHrealms.client.renderer.FlailZombieRenderer;
import com.jk.BHrealms.client.renderer.ZombieHeadRenderer;
import com.jk.BHrealms.init.EntityInit;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = BHrealms.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventsForEntities {


    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(EntityInit.FLAIL_ZOMBIE.get(), FlailZombieRenderer::new);
        EntityRenderers.register(EntityInit.ZOMBIE_HEAD.get(), ZombieHeadRenderer::new);
    }

}
