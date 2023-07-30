package inditorias.destiny.subclass_effects;

import inditorias.destiny.config.DestinyConfig;
import inditorias.destiny.config.DestinyExplosionBehavior;
import inditorias.destiny.lib.DestinyExplode;
import inditorias.destiny.registries.DestinyDamageSoures;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SolarIgnition extends InstantStatusEffect {
    public SolarIgnition(StatusEffectCategory category, int color) {
        super(category, color);
    }

    private void ignite(LivingEntity entity){
        entity.getWorld().createExplosion(
                entity,
                DestinyDamageSoures.solarDamage,
                new DestinyExplosionBehavior(),
                entity.getX(), entity.getY()+1, entity.getZ(),
                DestinyConfig.getIgnitionRadius(),
                true,
                World.ExplosionSourceType.MOB);
        DestinyExplode.ExplodeDamage(entity.getWorld(), entity.getPos(), DestinyConfig.getIgnitionDamageRange(), DestinyConfig.getIgnitionMinDamage(), DestinyConfig.getIgnitionMaxDamage(), DestinyDamageSoures.solarDamage);
        DestinyExplode.SetFireRandomly(entity.getWorld(), entity.getBlockPos(), DestinyConfig.getIgnitionFireRange(), DestinyConfig.getIgnitionFireChance());
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        ignite(entity);
    }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        ignite(target);
    }
}
