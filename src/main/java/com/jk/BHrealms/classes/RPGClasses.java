package com.jk.BHrealms.classes;

import net.minecraft.nbt.CompoundTag;

public class RPGClasses {
    private int playerClass;
    private int strengthStat;
    private int tauntValue;

    public int getPlayerClass() {
        return playerClass;
    }
    public int getStrengthStat() {return strengthStat;}
    public int getTauntValue() {return tauntValue;}

    public void setPlayerClass(int i) {this.playerClass = i;}
    public void setStrengthStat(int stat) {this.strengthStat = stat;}
    public void setTauntValue(int stat) {this.tauntValue = stat;}

    public void copyFrom(RPGClasses source) {
        this.playerClass = source.playerClass;
        this.strengthStat = source.strengthStat;
        this.tauntValue = source.tauntValue;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("playerClass", playerClass);
        nbt.putInt("strength", strengthStat);
        nbt.putInt("tauntValue", tauntValue);
    }

    public void loadNBTData(CompoundTag nbt) {
        playerClass = nbt.getInt("playerClass");
        strengthStat = nbt.getInt("strength");
        tauntValue = nbt.getInt("tauntValue");
    }



}
