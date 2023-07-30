package inditorias.destiny.subclass_effects;

import inditorias.destiny.config.DestinyConfig;
import inditorias.destiny.registries.DestinyEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.Vec3d;

public class StasisFreeze extends StatusEffect {
    private float damageTaken;
    private Vec3d position;
    private float yaw;

    public StasisFreeze(StatusEffectCategory category, int color) {
        super(category, color);
    }
    public void addDamage(float damage){
        damageTaken += damage;
    }
    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        damageTaken = 0;
        position = entity.getPos();
        yaw = entity.getHeadYaw();
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(damageTaken > DestinyConfig.getShatterTrigger()){
            StatusEffectInstance freeze = entity.getStatusEffect(DestinyEffects.STASIS_FREEZE);
            entity.removeStatusEffect(DestinyEffects.STASIS_FREEZE);
            entity.addStatusEffect(new StatusEffectInstance(DestinyEffects.STASIS_SHATTER, 1, 1, freeze.isAmbient(), freeze.shouldShowParticles(), freeze.shouldShowIcon()));
            return;
        }
        entity.setVelocity(0,Math.min(entity.getVelocity().getY(),0),0);
        entity.setPos(position.getX(), entity.getY(), position.getZ());
        entity.setHeadYaw(yaw);
    }
}
