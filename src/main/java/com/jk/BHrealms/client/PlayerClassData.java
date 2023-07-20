package com.jk.BHrealms.client;

public class PlayerClassData {
    private static int playerClass;

    public static void set(int playerClass) {
        PlayerClassData.playerClass = playerClass;
    }

    public static int getPlayerClass() {
        return playerClass;
    }
}
