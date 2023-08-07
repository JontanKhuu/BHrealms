package com.jk.BHrealms.entity;

import com.jk.BHrealms.classes.ClassProvider;
import com.jk.BHrealms.init.EntityInit;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.tslat.smartbrainlib.api.SmartBrainOwner;
import net.tslat.smartbrainlib.api.core.BrainActivityGroup;
import net.tslat.smartbrainlib.api.core.SmartBrainProvider;
import net.tslat.smartbrainlib.api.core.behaviour.FirstApplicableBehaviour;
import net.tslat.smartbrainlib.api.core.behaviour.OneRandomBehaviour;
import net.tslat.smartbrainlib.api.core.behaviour.custom.attack.AnimatableMeleeAttack;
import net.tslat.smartbrainlib.api.core.behaviour.custom.look.LookAtTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.misc.Idle;
import net.tslat.smartbrainlib.api.core.behaviour.custom.move.MoveToWalkTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.path.SetRandomWalkTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.path.SetWalkTargetToAttackTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.InvalidateAttackTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.SetPlayerLookTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.SetRandomLookTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.TargetOrRetaliate;
import net.tslat.smartbrainlib.api.core.sensor.ExtendedSensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.HurtBySensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.NearbyLivingEntitySensor;
import net.tslat.smartbrainlib.util.BrainUtils;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//extends Monster, LivingEntity, etc;
//Minecart would be extends Entity
//could also extend Pig
public class FlailZombie extends Monster implements SmartBrainOwner<FlailZombie>, GeoEntity {
    public static final EntityDataAccessor<Boolean> TAUNTED = SynchedEntityData.defineId(FlailZombie.class, EntityDataSerializers.BOOLEAN);
    //Player player = this.level().getNearestPlayer(this, 3);
    int x = 1;
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    protected List<Player> nearbyPlayers = new ArrayList<>();

    public FlailZombie(EntityType<? extends FlailZombie> entityType, Level level) {
        super(entityType, level);
        this.setMaxUpStep(1.25f);

    }

    public FlailZombie(Level level, double x, double y, double z) {
        this(EntityInit.FLAIL_ZOMBIE.get(), level);
        setPos(x,y,z);

    }

    public FlailZombie(Level level, BlockPos position) {
        this(level, position.getX(), position.getY(), position.getZ());

    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        getEntityData().define(TAUNTED, false);
    }

    public boolean isTaunted() {
        return getEntityData().get(TAUNTED);
    }


    @Override
    protected final void registerGoals() {}
    // Let's make sure we're definitely not using any goals

    @Override
    protected Brain.Provider<?> brainProvider() {
        return new SmartBrainProvider<>(this);
    }

    @Override
    public List<ExtendedSensor<FlailZombie>> getSensors() {
        return ObjectArrayList.of(
                new NearbyLivingEntitySensor<FlailZombie>().setRadius(20).setPredicate((target, entity) -> target instanceof Villager || target instanceof Player),// This tracks nearby entities
                new HurtBySensor<>()// This tracks the last damage source and attacker

        );
    }

    protected Player getPlayerWithHighestTauntData() {
        final int[] maxTaunt = {0};
        final Player[] finalplayer = new Player[1];
        for (Player player :  this.nearbyPlayers) {
            player.getCapability(ClassProvider.CLASSES).ifPresent(playerClass -> {
                if (playerClass.getTauntValue() >= maxTaunt[0]) {
                    maxTaunt[0] = playerClass.getTauntValue();
                    finalplayer[0] = player;
                }
            });
        }


        return finalplayer[0];
    }



       //add player
    public void addPlayer(Player player)  {
           this.nearbyPlayers.add(player);
        }


    public List<Player> entitiesToPlayer (List<Entity> entitiesList) {
        List<Player> players = new ArrayList<>();
        for (Entity e : entitiesList) {
            if (e instanceof Player player) {
                players.add(player);
            }
        }
        return players;
    }

protected void tauntedBehavior() {
    //add condition CanBeTaunted() so it cant be taunted continously or make a cooldown for player;

    this.x++;

    LivingEntity entity1 = getPlayerWithHighestTauntData();

    BrainUtils.setTargetOfEntity(this, entity1);
    System.out.println(BrainUtils.getTargetOfEntity(this).getName().getString() + this.x); //returns the target of entity

    BrainUtils.setForgettableMemory(this, MemoryModuleType.ATTACK_TARGET, BrainUtils.getTargetOfEntity(this) ,100); //MemoryType and the third parameter is the required Type of Memory


    if (this.x % 100 == 0) { //after the countdown since isTaunted() which is 100 ticks in this case, it resets
        AABB testingAABB = new AABB(this.getX() - 20, this.getY() - 2, this.getZ() - 20, this.getX() + 20, this.getY() + 2, this.getZ() + 20);
        List<Entity> nearbyEntities = new ArrayList<>();
        List<Player> nearbyPlayersTEMP = new ArrayList<>();
        nearbyEntities = this.level().getEntities(this, testingAABB );

        nearbyPlayersTEMP = entitiesToPlayer(nearbyEntities);

        if (nearbyPlayersTEMP.size() > 0) {
            int rnd = new Random().nextInt(nearbyPlayersTEMP.size());
            Player entity = nearbyPlayersTEMP.get(rnd);
            BrainUtils.setTargetOfEntity(this, entity);
            System.out.println(BrainUtils.getTargetOfEntity(this));
            System.out.println("Target Null");
            this.nearbyPlayers.clear();
            getEntityData().set(TAUNTED, false);
        }

        else {
            BrainUtils.setTargetOfEntity(this, this.level().getNearestPlayer(this, 10));
            System.out.println("Target Null to Nearest");
            getEntityData().set(TAUNTED, false);
        }
    }//end of checking 100 ticks has passed since isTaunted()
} //end of isTaunted





//This function for taunt does not work properly unless there are players in range
    @Override
    protected void customServerAiStep() {
        tickBrain(this);

        if (BrainUtils.getTargetOfEntity(this) != null) {
            if (isTaunted()) { //add condition CanBeTaunted() so it cant be taunted continously or make a cooldown for player;
                    tauntedBehavior();
               } //end of isTaunted

        }//End of Checking if Target is null
    else {
        BrainUtils.setTargetOfEntity(this, this.level().getNearestPlayer(this, 10) );
    }// sets a target if target is null

}





    @Override
    public BrainActivityGroup<FlailZombie> getCoreTasks() { // These are the tasks that run all the time (usually)
        return BrainActivityGroup.coreTasks(
                new TargetOrRetaliate<>(),
                new LookAtTarget<>(),                      // Have the entity turn to face and look at its current look target
                new MoveToWalkTarget<>()

        );           // Walk towards the current walk target
    }

    @Override
    public BrainActivityGroup<FlailZombie> getIdleTasks() { // These are the tasks that run when the mob isn't doing anything else (usually)
        return BrainActivityGroup.idleTasks(
                new FirstApplicableBehaviour<FlailZombie>(      // Run only one of the below behaviours, trying each one in order. Include the generic type because JavaC is silly
                        new TargetOrRetaliate<>().attackablePredicate(entity -> entity instanceof Villager),//.useMemory(MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER),            // Set the attack target and walk target based on nearby entities
                        new SetPlayerLookTarget<>() ,      // Set the look target for the nearest player
                        new SetRandomLookTarget<>(),        // Set a random look target
                new OneRandomBehaviour<>(                 // Run a random task from the below options
                        new SetRandomWalkTarget<>().setRadius(30),          // Set a random walk target to a nearby position
                        new Idle<>().runFor(entity -> entity.getRandom().nextInt(30, 60)) // Do nothing for 1.5->3 seconds
                )));

    }

    @Override
    public BrainActivityGroup<FlailZombie> getFightTasks() { // These are the tasks that handle fighting
        return BrainActivityGroup.fightTasks(
                new InvalidateAttackTarget<>(), // Cancel fighting if the target is no longer valid
                new SetWalkTargetToAttackTarget<>(),     // Set the walk target to the attack target,
                new AnimatableMeleeAttack<>(0)
        ); // Melee attack the target if close enough
    }





    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 10).add(Attributes.MOVEMENT_SPEED, 0.25f).add(Attributes.FOLLOW_RANGE, 30.0D).add(Attributes.ATTACK_DAMAGE, 10);
    }

    public static boolean canSpawn(EntityType<FlailZombie> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
        return Monster.checkMonsterSpawnRules(entityType, level, spawnType, position, random);
        //can also do Monster.checkMonsterSpawnRules(entityType, level, spawnType, position, random) && level.getLevelData().isRaining() && position.getY() > 40 etc
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
            controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if (tAnimationState.isMoving()) {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("attack", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }



        tAnimationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    /*@Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "legs_controller", 0, state -> {
            if (state.isMoving())
                return state.setAndContinue(isSprinting() ? RUN_BOTTOM_HALF : WALK_BOTTOM_HALF);

            return PlayState.STOP;
        }));
        controllers.add(new AnimationController<>(this, "arms_controller", 3, state -> {
            if (ATTACK_STATE.is(this, CHARGE_STATE))
                return state.setAndContinue(CHARGE);

            if (this.swinging)
                return state.setAndContinue(getSwingAnimation());

            if (state.isMoving()) {
                return state.setAndContinue(isSprinting() ? RUN_TOP_HALF : WALK_TOP_HALF);
            }
            else {
                return state.setAndContinue(isEnraged() ? ENRAGED_IDLE : DefaultAnimations.IDLE);
            }
        }).triggerableAnim("enrage", ENRAGE).triggerableAnim("belly_drum", BELLY_DRUM).triggerableAnim("charge_up", CHARGE_UP));
    }*/

}

