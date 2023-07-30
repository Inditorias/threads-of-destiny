package inditorias.destiny.subclass_effects;

import inditorias.destiny.config.DestinyConfig;
import inditorias.destiny.lib.DestinyExplode;
import inditorias.destiny.registries.DestinyDamageSoures;
import inditorias.destiny.registries.DestinyEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class VoidVolatile extends StatusEffect {
    private float damageTaken;
    public VoidVolatile(StatusEffectCategory category, int color) {
        super(category, color);
    }
    public void addDamage(float damage){
        damageTaken += damage;
    }
    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        damageTaken = 0;
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return damageTaken > DestinyConfig.getVolatileTrigger();
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        DestinyExplode.ExplodeDamage(entity.getWorld(), entity.getPos(), DestinyConfig.getVolatileRange(), DestinyConfig.getVolatileMinDamage(),DestinyConfig.getVolatileMaxDamage(), DestinyDamageSoures.voidDamage);
        entity.removeStatusEffect(DestinyEffects.VOID_VOLATILE);
    }

    public static void explodeVolatile(World world, Vec3d pos){
        DestinyExplode.ExplodeDamage(world, pos, DestinyConfig.getVolatileRange(), DestinyConfig.getVolatileMinDamage(),DestinyConfig.getVolatileMaxDamage(), DestinyDamageSoures.voidDamage);
    }
}
