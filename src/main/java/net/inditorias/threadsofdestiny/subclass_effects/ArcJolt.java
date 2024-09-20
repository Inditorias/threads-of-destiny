package net.inditorias.threadsofdestiny.subclass_effects;

import net.inditorias.threadsofdestiny.config.DestinyConfig;
import net.inditorias.threadsofdestiny.lib.EffectData;
import net.inditorias.threadsofdestiny.lib.IEntityDataSaver;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class ArcJolt extends StatusEffect {
    public ArcJolt(StatusEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public void onApplied(LivingEntity entity, int amplifier){
        EffectData.setJoltDamage((IEntityDataSaver) entity, 0);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier){
        return true;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier){
        if (EffectData.getJoltDamage((IEntityDataSaver) entity) > DestinyConfig.getJoltTrigger()){
            //TODO: Jolt Explosion
            EffectData.setJoltDamage((IEntityDataSaver) entity,0);
        }
        return true;
    }
}
