package com.jk.BHrealms.client.model;

import com.jk.BHrealms.BHrealms;
import com.jk.BHrealms.entity.ZombieHead;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ZombieHeadModel extends GeoModel<ZombieHead> {
    @Override
    public ResourceLocation getModelResource(ZombieHead animatable) {
        return new ResourceLocation(BHrealms.MODID, "geo/zombiehead.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ZombieHead animatable) {
        return new ResourceLocation(BHrealms.MODID, "textures/entity/zombiehead.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ZombieHead animatable) {
        return new ResourceLocation(BHrealms.MODID, "animations/zombiehead.animation.json");
    }
}
