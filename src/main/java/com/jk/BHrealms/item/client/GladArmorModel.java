package com.jk.BHrealms.item.client;

import com.jk.BHrealms.BHrealms;
import com.jk.BHrealms.item.custom.GladArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GladArmorModel extends GeoModel<GladArmorItem> {
    @Override
    public ResourceLocation getModelResource(GladArmorItem animatable) {
        return new ResourceLocation(BHrealms.MODID, "geo/glad_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GladArmorItem animatable) {
        return new ResourceLocation(BHrealms.MODID, "textures/armor/glad_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GladArmorItem animatable) {
        return new ResourceLocation(BHrealms.MODID, "animations/glad_armor.animation.json");
    }
}
