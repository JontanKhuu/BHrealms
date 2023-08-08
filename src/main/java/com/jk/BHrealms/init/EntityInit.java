package com.jk.BHrealms.init;

import com.jk.BHrealms.BHrealms;
import com.jk.BHrealms.entity.FlailZombie;
import com.jk.BHrealms.entity.ZombieHead;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BHrealms.MODID);



    public static final RegistryObject<EntityType<FlailZombie>> FLAIL_ZOMBIE = ENTITIES.register("flail_zombie",
            () -> EntityType.Builder.<FlailZombie>of(FlailZombie::new, MobCategory.MONSTER)
                    .sized(1.0f, 1.0f)
                    .build(new ResourceLocation(BHrealms.MODID, "flail_zombie").toString()));

    public static final RegistryObject<EntityType<ZombieHead>> ZOMBIE_HEAD = ENTITIES.register("zombie_head",
            () -> EntityType.Builder.<ZombieHead>of(ZombieHead::new, MobCategory.MONSTER)
                    .sized(1.0f, 1.0f)
                    .build(new ResourceLocation(BHrealms.MODID, "zombie_head").toString()));

}
