package com.jk.BHrealms.Entity.Client;

import com.jk.BHrealms.BHrealms;
import com.jk.BHrealms.Entity.Custom.GladArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GladArmorModel extends GeoModel<GladArmorItem> {

    @Override
    public ResourceLocation getModelResource(GladArmorItem animatable) {
        return new ResourceLocation(BHrealms.MODID,"geo/glad_helm.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GladArmorItem animatable) {
        return new ResourceLocation(BHrealms.MODID,"textures/models/armor/glad_helm_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GladArmorItem animatable) {
        return new ResourceLocation(BHrealms.MODID, "animations/Glad_Helm.animation.json");
    }
}
