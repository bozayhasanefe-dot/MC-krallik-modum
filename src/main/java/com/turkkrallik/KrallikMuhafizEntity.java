package com.turkkrallik;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class KrallikMuhafizEntity extends PathAwareEntity {

    public KrallikMuhafizEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    // Askerimizin Canı, Hasarı ve Hızı
    public static DefaultAttributeContainer.Builder createMuhafizAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0D) // Normal oyuncudan 2 kat daha canlı!
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0D); // Sağlam kılıç darbesi
    }

    // Askerimizin Yapay Zekası ve Hedefleri
    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2D, false)); // Yakın dövüş saldırısı
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.8D)); // Krallık etrafında devriye gezme
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));

        // Düşmanları ve Yaratıkları Otomatik Avlama
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, HostileEntity.class, true)); // Bütün canavarlara saldırma!
    }
}