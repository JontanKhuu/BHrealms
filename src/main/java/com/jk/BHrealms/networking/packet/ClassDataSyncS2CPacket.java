package com.jk.BHrealms.networking.packet;

import com.jk.BHrealms.classes.RPGClasses;
import com.jk.BHrealms.client.PlayerClassData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ClassDataSyncS2CPacket {

    private final int playerClass;

    public ClassDataSyncS2CPacket(RPGClasses playerClass) {
        this.playerClass = playerClass.getPlayerClass();
    }
    public ClassDataSyncS2CPacket(FriendlyByteBuf buf) {
        this.playerClass = buf.readInt();
    }
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(playerClass);
    }
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
    NetworkEvent.Context context = supplier.get();
    context.enqueueWork(() -> {
        //HERE WE ARE ON CLIENT
        PlayerClassData.set(playerClass);



        });

        return true;
    }

}
