package com.jk.BHrealms.item.custom;

import com.jk.BHrealms.item.client.AnimatedExcaliburRenderer;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.RenderUtils;

import java.util.function.Consumer;

public class AnimatedExcaliburItem extends SwordItem implements GeoItem {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public AnimatedExcaliburItem(Tier p_43269_, int p_43270_, float p_43271_, Item.Properties p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
    }
    private PlayState predicate(AnimationState animationState) {
        //    animationState.getController().setAnimation(RawAnimation.begin().then("", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, "controller", 0, this::predicate));
    }



    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object itemStack) {
        return RenderUtils.getCurrentTick();
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private AnimatedExcaliburRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if(this.renderer == null) {
                    renderer = new AnimatedExcaliburRenderer();
                }
                return this.renderer;
            }
        });
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {//currently its homing and its broken change to aiming
        if (!level.isClientSide()) {
            AABB testingAABB = new AABB(player.getX() - 7, player.getY() - 2, player.getZ() - 7, player.getX() + 7, player.getY() + 2, player.getZ() + 7);
            Entity entity = level.getNearestEntity(LivingEntity.class, TargetingConditions.forCombat(), player, 7, 7 , 7, testingAABB );
            player.getLookAngle();

            if (entity != null) {
                EntityType.LIGHTNING_BOLT.spawn((ServerLevel) level, entity.getOnPos(), MobSpawnType.COMMAND);
            }
        }
        return super.use(level, player, interactionHand);
    }
}