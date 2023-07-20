package com.jk.BHrealms.item.client;

import com.jk.BHrealms.item.custom.AnimatedItem;;
import software.bernie.geckolib.renderer.GeoItemRenderer;
public class AnimatedItemRenderer extends GeoItemRenderer<AnimatedItem> {
    public AnimatedItemRenderer() {
        super(new AnimatedItemModel());
    }
}
