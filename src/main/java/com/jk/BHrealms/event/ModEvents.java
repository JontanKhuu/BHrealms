package com.jk.BHrealms.event;

import com.jk.BHrealms.BHrealms;
import com.jk.BHrealms.classes.ClassProvider;
import com.jk.BHrealms.classes.RPGClasses;
import com.jk.BHrealms.networking.ModNetworking;
import com.jk.BHrealms.networking.packet.ClassDataSyncS2CPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BHrealms.MODID)
public class ModEvents {
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            if (!event.getObject().getCapability(ClassProvider.CLASSES).isPresent()) {
                event.addCapability(new ResourceLocation(BHrealms.MODID, "properties"), new ClassProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if  (event.isWasDeath()) {
            event.getOriginal().reviveCaps();
            event.getOriginal().getCapability(ClassProvider.CLASSES).ifPresent(oldStore -> {
                event.getEntity().getCapability(ClassProvider.CLASSES).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);

                });
            });
            event.getOriginal().invalidateCaps();

        }
    }
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(RPGClasses.class);
    }

@SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        if (!event.getLevel().isClientSide()) {
            if (event.getEntity() instanceof ServerPlayer player) {
                player.getCapability(ClassProvider.CLASSES).ifPresent(playerClass -> {
                    ModNetworking.sendToPlayer(new ClassDataSyncS2CPacket(playerClass), player);
                });
            }
        }
}




}
