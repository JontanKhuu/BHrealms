package com.jk.BHrealms.item.client;

import com.jk.BHrealms.BHrealms;
import com.jk.BHrealms.item.custom.AnimatedItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedItemModel extends GeoModel<AnimatedItem> {
    @Override
    public ResourceLocation getModelResource(AnimatedItem animatable) {
        return new ResourceLocation(BHrealms.MODID, "geo/chainsword.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedItem animatable) {
        return new ResourceLocation(BHrealms.MODID, "textures/item/chainsword_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedItem animatable) {
        return new ResourceLocation(BHrealms.MODID, "animations/chainsword.animation.json");
    }
}
