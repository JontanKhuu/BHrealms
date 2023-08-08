package com.jk.BHrealms.client.renderer;

import com.jk.BHrealms.BHrealms;
import com.jk.BHrealms.client.model.ZombieHeadModel;
import com.jk.BHrealms.entity.ZombieHead;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ZombieHeadRenderer extends GeoEntityRenderer<ZombieHead> {


    public ZombieHeadRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ZombieHeadModel());
    }

    @Override
    public ResourceLocation getTextureLocation(ZombieHead animatable) {
        return new ResourceLocation(BHrealms.MODID, "textures/entity/zombiehead.png");
    }
}