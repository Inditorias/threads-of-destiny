package inditorias.destiny.subclass_effects;

import inditorias.destiny.config.DestinyConfig;
import inditorias.destiny.lib.EffectData;
import inditorias.destiny.lib.IEntityDataSaver;
import inditorias.destiny.registries.DestinyEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.Vec3d;

public class StasisFreeze extends StatusEffect {


    public StasisFreeze(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        EffectData.setFreezeDamage((IEntityDataSaver) entity, 0);
        EffectData.setFreezePos((IEntityDataSaver)entity, entity.getPos());
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(EffectData.getFreezeDamage((IEntityDataSaver) entity) > DestinyConfig.getShatterTrigger()){
            StatusEffectInstance freeze = entity.getStatusEffect(DestinyEffects.STASIS_FREEZE);
            if(freeze == null)return;
            entity.removeStatusEffect(DestinyEffects.STASIS_FREEZE);
            entity.addStatusEffect(new StatusEffectInstance(DestinyEffects.STASIS_SHATTER, 1, 1, freeze.isAmbient(), freeze.shouldShowParticles(), freeze.shouldShowIcon()));
            return;
        }
        //TODO: sync
        entity.setVelocity(0,Math.min(entity.getVelocity().getY(),0),0);
        Vec3d position = EffectData.getFreezePos((IEntityDataSaver) entity);
        entity.setPos(position.getX(), entity.getY(), position.getZ());
    }
}
