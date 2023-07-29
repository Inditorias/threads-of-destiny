package inditorias.destiny.subclass_effects;

import inditorias.destiny.registries.DestinyEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

public class SolarScorch extends StatusEffect {
    final public static float SCORCH_DAMAGE = 0.0195f;
    final public static float SCORCH_BASE = 0.3f;
    final public static float SCORCH_DAMAGE_TIME = 0.56f;
    final public static float SCORCH_FALL_TIME = 4.5f;
    final public static float SCORCH_REMOVE_PER_TIME = 5.67f;
    final public static float SCORCH_REMOVE_TIME = 0.56f;
    protected boolean fixed;
    public static int SCORCH_DURATION(int amplifier){
        return (int) ((SCORCH_FALL_TIME*20) + ((amplifier/SCORCH_REMOVE_PER_TIME)*SCORCH_REMOVE_TIME*20));
    }

    public static int AMPLIFICATION_LEVEL(int duration){
        //assumes the SCORCH_FALL_TIME has gone by
        return (int) ((duration*SCORCH_REMOVE_PER_TIME)/(20*SCORCH_REMOVE_TIME));
    }
    public SolarScorch(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        StatusEffectInstance scorchEffect = entity.getStatusEffect(DestinyEffects.SOLAR_SCORCH);
        if(amplifier >= 100){
            entity.setStatusEffect(new StatusEffectInstance(DestinyEffects.SOLAR_IGNITION, 1, 1, scorchEffect.isAmbient(), scorchEffect.shouldShowParticles(), scorchEffect.shouldShowIcon()), null);
            entity.removeStatusEffect(DestinyEffects.SOLAR_SCORCH);
            return;
        }

        //Amplifier and Duration need to be syncedish. Scorch falls off such that duration < amplifier

        int duration = scorchEffect.getDuration();
        if(!fixed){
            duration = SCORCH_DURATION(amplifier);
        }
        //Check to see if its time to damage
        if(duration % (int)(SCORCH_DAMAGE_TIME * 20) == 0){
            entity.damage(entity.getDamageSources().onFire(), SCORCH_BASE + (SCORCH_DAMAGE * amplifier));
        }

        if(amplifier > AMPLIFICATION_LEVEL(duration)) {
            amplifier = AMPLIFICATION_LEVEL(duration);
            duration = duration-1;
            fixed = false;
        }
        if(!fixed){
            StatusEffectInstance updateScorchEffect = new StatusEffectInstance(
                    scorchEffect.getEffectType(),
                    duration,
                    amplifier,
                    scorchEffect.isAmbient(),
                    scorchEffect.shouldShowParticles(),
                    scorchEffect.shouldShowIcon()
            );
            entity.setStatusEffect(updateScorchEffect, entity);
            ((SolarScorch) (entity.getStatusEffect(DestinyEffects.SOLAR_SCORCH).getEffectType())).fixed = true;
        }

    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        fixed = false;
        super.onApplied(entity, attributes, amplifier);
    }
}
