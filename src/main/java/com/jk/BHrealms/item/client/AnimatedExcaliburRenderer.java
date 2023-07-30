package com.jk.BHrealms.item.client;

import com.jk.BHrealms.item.custom.AnimatedExcaliburItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AnimatedExcaliburRenderer extends GeoItemRenderer<AnimatedExcaliburItem> {
    public AnimatedExcaliburRenderer() {
        super(new AnimatedExcaliburModel());
    }
}
