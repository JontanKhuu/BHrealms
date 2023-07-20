package com.jk.BHrealms.item.client;

import com.jk.BHrealms.item.custom.GladArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;


public class GladArmorRenderer extends GeoArmorRenderer<GladArmorItem> {

    public GladArmorRenderer() {
        super(new GladArmorModel());
    }
}
