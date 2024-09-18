package net.inditorias.threadsofdestiny.subclass_effects;

import net.inditorias.threadsofdestiny.config.DestinyConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class SolarRestoration extends StatusEffect {
    public SolarRestoration(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getHealth() < entity.getMaxHealth()) {
            if (amplifier < 2) {
                entity.heal(DestinyConfig.getSolarRestorationI() /20);
            } else {
                entity.heal(DestinyConfig.getSolarRestorationII()/20);
            }
        }
        return true;
    }
}
