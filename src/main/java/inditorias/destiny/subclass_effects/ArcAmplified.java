package inditorias.destiny.subclass_effects;

import inditorias.destiny.config.DestinyConfig;
import inditorias.destiny.lib.EffectData;
import inditorias.destiny.lib.IEntityDataSaver;
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

public class ArcAmplified extends StatusEffect {
    public static final UUID ARC_AMPLIFIED_UUID = UUID.fromString("c5d53a58-182a-4596-8086-3dd872e6605e");
    public static final String ARC_AMPLIFIED_MOVEMENT_ID = "arc_amplified_movement";

    public ArcAmplified(StatusEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        EffectData.resetAmplifiedTicksRunning((IEntityDataSaver) entity);
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        EntityAttributeInstance entityAttributeInstance = entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
        if (entityAttributeInstance == null) {
            return;
        }
        EntityAttributeModifier ARC_AMPLIFIED_MODIFIER_MOVEMENT =
                new EntityAttributeModifier(ARC_AMPLIFIED_UUID, ARC_AMPLIFIED_MOVEMENT_ID, DestinyConfig.getAmplifiedMovementModifier(), EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        if(entityAttributeInstance.hasModifier(ARC_AMPLIFIED_MODIFIER_MOVEMENT)){
            entityAttributeInstance.removeModifier(ARC_AMPLIFIED_UUID);
        }
        super.onRemoved(entity, attributes, amplifier);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(!entity.hasStatusEffect(DestinyEffects.ARC_SPEEDBOOST)){
            setAttributeInstances(entity);
        }
        if(entity.isSprinting()){
            EffectData.incrementAmplifiedTicksRunning((IEntityDataSaver) entity);
        }else{
            EffectData.resetAmplifiedTicksRunning((IEntityDataSaver) entity);
        }
        if(!entity.hasStatusEffect(DestinyEffects.ARC_SPEEDBOOST) && EffectData.getAmplifiedTicksRunning((IEntityDataSaver) entity) > (DestinyConfig.getSpeedboostWarmup() * 20)){
            StatusEffectInstance amplifiedInstance = entity.getStatusEffect(DestinyEffects.ARC_AMPLIFIED);
            if(amplifiedInstance != null){
                entity.setStatusEffect(new StatusEffectInstance(DestinyEffects.ARC_SPEEDBOOST, (int)(DestinyConfig.getSpeedboostFalloff() * 20), 0,
                        amplifiedInstance.isAmbient(), amplifiedInstance.shouldShowParticles(), amplifiedInstance.shouldShowIcon()), null);
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    private void setAttributeInstances(LivingEntity entity){
        EntityAttributeInstance entityAttributeInstance = entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
        if (entityAttributeInstance == null) {
            return;
        }
        EntityAttributeModifier ARC_AMPLIFIED_MODIFIER_MOVEMENT =
                new EntityAttributeModifier(ARC_AMPLIFIED_UUID, ARC_AMPLIFIED_MOVEMENT_ID, DestinyConfig.getAmplifiedMovementModifier(), EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        if(entityAttributeInstance.hasModifier(ARC_AMPLIFIED_MODIFIER_MOVEMENT)){
            return;
        }
        entityAttributeInstance.addTemporaryModifier(ARC_AMPLIFIED_MODIFIER_MOVEMENT);
    }
}
