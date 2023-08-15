package inditorias.destiny.subclass_effects;

import inditorias.destiny.config.DestinyConfig;
import inditorias.destiny.registries.DestinyEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.UUID;

public class ArcSpeedboost extends StatusEffect {
    public static final UUID ARC_SPEEDBOOST_UUID = UUID.fromString("627157e2-7028-49f9-ad03-d8925d608ae7");
    public static final String ARC_SPEEDBOOST_MOVEMENT_ID = "arc_speedboost_movement";

    public ArcSpeedboost(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        EntityAttributeInstance entityAttributeInstance = entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
        if (entityAttributeInstance == null) {
            return;
        }
        EntityAttributeModifier ARC_AMPLIFIED_MODIFIER_MOVEMENT =
                new EntityAttributeModifier(ARC_SPEEDBOOST_UUID, ARC_SPEEDBOOST_MOVEMENT_ID, DestinyConfig.getAmplifiedMovementModifier(), EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        if(entityAttributeInstance.hasModifier(ARC_AMPLIFIED_MODIFIER_MOVEMENT)){
            entityAttributeInstance.removeModifier(ARC_SPEEDBOOST_UUID);
        }
        super.onRemoved(entity, attributes, amplifier);
    }
    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        setAttributeInstances(entity);
        if(entity.isSprinting()){
            StatusEffectInstance speedboostInstance = entity.getStatusEffect(DestinyEffects.ARC_SPEEDBOOST);
            if(speedboostInstance != null){
                entity.setStatusEffect(new StatusEffectInstance(speedboostInstance.getEffectType(), (int)(DestinyConfig.getSpeedboostFalloff() * 20), 0,
                        speedboostInstance.isAmbient(), speedboostInstance.shouldShowParticles(), speedboostInstance.shouldShowIcon()), null);
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    private void setAttributeInstances(LivingEntity entity){
        EntityAttributeInstance entityAttributeInstance = entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
        if (entityAttributeInstance == null) {
            return;
        }
        EntityAttributeModifier ARC_SPEEDBOOST_MODIFIER_MOVEMENT =
                new EntityAttributeModifier(ARC_SPEEDBOOST_UUID, ARC_SPEEDBOOST_MOVEMENT_ID, DestinyConfig.getSpeedboostMovementModifier(), EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        if(entityAttributeInstance.hasModifier(ARC_SPEEDBOOST_MODIFIER_MOVEMENT)){
            return;
        }
        entityAttributeInstance.addTemporaryModifier(ARC_SPEEDBOOST_MODIFIER_MOVEMENT);
    }
}
