package net.inditorias.threadsofdestiny.subclass_effects;

import net.inditorias.threadsofdestiny.config.DestinyConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SolarIgnition extends InstantStatusEffect {
    public SolarIgnition(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getEntityWorld().isClient) {
            entity.getEntityWorld().createExplosion(null, entity.getX(), entity.getY(), entity.getZ(), DestinyConfig.getSolarIgnitionPower(), true, World.ExplosionSourceType.MOB);
            //TODO: change entity to be the entity that applied the ignition (removes self damage)
            //TODO: change createExplosion to make custom particle effects and sounds
            //TODO: Add aditional logic to spread scorch when fragments begin implementation
            //TODO: Disable destroying blocks
            //TODO: Change create fire logic to use gamerule/fragment
        }
        return true;
    }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        this.applyUpdateEffect(target, amplifier);
    }
}
