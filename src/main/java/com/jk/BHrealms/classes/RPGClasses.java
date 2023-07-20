package com.jk.BHrealms.classes;

import net.minecraft.nbt.CompoundTag;

public class RPGClasses {
    private int playerClass;

    public int getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass() {
        this.playerClass = 1;
    }

    public void copyFrom(RPGClasses source) {
        this.playerClass = source.playerClass;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("class", playerClass);
    }

    public void loadNBTData(CompoundTag nbt) {
        playerClass = nbt.getInt("class");
    }



}
