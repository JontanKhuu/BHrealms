package com.jk.BHrealms.Entity.Client;

import com.jk.BHrealms.Entity.Custom.GladArmorItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class GladArmorRenderer extends GeoArmorRenderer<GladArmorItem> {

     public GladArmorRenderer() {
        super(new GladArmorModel());
    }
}
