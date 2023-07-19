package com.jk.BHrealms.customitems;

import com.jk.BHrealms.classes.ClassProvider;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class AdvancedItem extends Item {

    public AdvancedItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (hand == InteractionHand.MAIN_HAND) {
            player.getCapability(ClassProvider.CLASSES).ifPresent(playerClass -> {
                playerClass.setPlayerClass();
                player.sendSystemMessage(Component.literal(playerClass.getPlayerClass()));

            });
        }
        return super.use(level, player, hand);
    }


}
