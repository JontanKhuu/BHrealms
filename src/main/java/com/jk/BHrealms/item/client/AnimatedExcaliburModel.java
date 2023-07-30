package com.jk.BHrealms.item.client;

import com.jk.BHrealms.BHrealms;
import com.jk.BHrealms.item.custom.AnimatedExcaliburItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedExcaliburModel extends GeoModel<AnimatedExcaliburItem> {
    //excalibur
    @Override
    public ResourceLocation getModelResource(AnimatedExcaliburItem animatable) {
        return new ResourceLocation(BHrealms.MODID, "geo/excalibur.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedExcaliburItem animatable) {
        return new ResourceLocation(BHrealms.MODID, "textures/item/excalibur_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedExcaliburItem animatable) {
        return new ResourceLocation(BHrealms.MODID, "animations/excalibur.animation.json");
    }
}