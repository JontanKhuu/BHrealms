package com.jk.BHrealms.networking.packet;

import com.jk.BHrealms.classes.ClassProvider;
import com.jk.BHrealms.networking.ModNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ExampleC2SPacket {
    public ExampleC2SPacket() {}
    public ExampleC2SPacket(FriendlyByteBuf buf) {}
    public void toBytes(FriendlyByteBuf buf) {}
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
    NetworkEvent.Context context = supplier.get();
    context.enqueueWork(() -> {
        //HERE WE ARE ON SERVER
        ServerPlayer player = context.getSender();
        ServerLevel level = player.serverLevel().getLevel();
        //EntityType.COW.spawn(level, (ItemStack) null, null, player.blockPosition(), MobSpawnType.COMMAND, true, false);
        player.getCapability(ClassProvider.CLASSES).ifPresent(playerClass -> {
            if (playerClass.getPlayerClass() == 1) {
                player.sendSystemMessage(Component.literal("Class: Archer" ));
            }
            else { player.sendSystemMessage(Component.literal("No Class"));}
            ModNetworking.sendToPlayer(new ClassDataSyncS2CPacket(playerClass), player);
        });

    });
        return true;
    }

}
