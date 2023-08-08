package com.jk.BHrealms.event;


import com.jk.BHrealms.BHrealms;
import com.jk.BHrealms.entity.FlailZombie;
import com.jk.BHrealms.entity.ZombieHead;
import com.jk.BHrealms.init.EntityInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BHrealms.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventsForEntities {

    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.FLAIL_ZOMBIE.get(), FlailZombie.createAttributes().build());
        event.put(EntityInit.ZOMBIE_HEAD.get(), ZombieHead.createAttributes().build());
    }
}
