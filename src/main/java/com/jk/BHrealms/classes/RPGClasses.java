package com.jk.BHrealms.classes;

import net.minecraft.nbt.CompoundTag;

public class RPGClasses {
    private String playerClass;

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass() {
        this.playerClass = "archer";
    }

    public void copyFrom(RPGClasses source) {
        this.playerClass = source.playerClass;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putString("class", playerClass);
    }

    public void loadNBTData(CompoundTag nbt) {
        playerClass = nbt.getString("class");
    }



}
