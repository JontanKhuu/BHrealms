package com.jk.BHrealms.client.renderer;

import com.jk.BHrealms.BHrealms;
import com.jk.BHrealms.client.model.FlailZombieModel;
import com.jk.BHrealms.entity.FlailZombie;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FlailZombieRenderer extends GeoEntityRenderer<FlailZombie> {


    public FlailZombieRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FlailZombieModel());
    }

    @Override
    public ResourceLocation getTextureLocation(FlailZombie animatable) {
        return new ResourceLocation(BHrealms.MODID, "textures/entity/flail_zombie.png");
    }



        //if (entity.isInPowderSnow) {
         //   return texture0;
       // }


}
