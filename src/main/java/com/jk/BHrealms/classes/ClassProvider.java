package com.kevin.bhrealms.classes;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ClassProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<RPGClasses> CLASSES = CapabilityManager.get(new CapabilityToken<RPGClasses>() {

    });

    private RPGClasses playerClass = null;
    private final LazyOptional<RPGClasses> optional = LazyOptional.of(this::createRPGClasses);

    private RPGClasses createRPGClasses() {
        if (this.playerClass == null) {
            this.playerClass = new  RPGClasses();
        }
        return this.playerClass;
    }




    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == CLASSES) {
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createRPGClasses().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
    createRPGClasses().loadNBTData(nbt);
    }
}
