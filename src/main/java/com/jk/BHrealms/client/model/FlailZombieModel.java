package com.jk.BHrealms.client.model;

import com.jk.BHrealms.BHrealms;
import com.jk.BHrealms.entity.FlailZombie;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class FlailZombieModel extends GeoModel<FlailZombie> {

    @Override
    public ResourceLocation getModelResource(FlailZombie animatable) {
        return new ResourceLocation(BHrealms.MODID, "geo/flailzombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FlailZombie animatable) {
        return new ResourceLocation(BHrealms.MODID, "textures/entity/flail_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FlailZombie animatable) {
        return new ResourceLocation(BHrealms.MODID, "animations/zombieflail.animation.json");
    }


    /*@Override
    public void setCustomAnimations(FlailZombie animatable, long instanceId, AnimationState<FlailZombie>animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.headPitch() * Mth.DEG_TO_RAD);
        }
    }*/
}
