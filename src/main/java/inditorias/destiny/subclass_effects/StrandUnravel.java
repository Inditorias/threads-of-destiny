package inditorias.destiny.subclass_effects;

import inditorias.destiny.config.DestinyConfig;
import inditorias.destiny.lib.DestinyExplode;
import inditorias.destiny.registries.DestinyDamageSoures;
import inditorias.destiny.registries.DestinyEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

public class StrandUnravel extends StatusEffect {
    private float damageTaken;
    public StrandUnravel(StatusEffectCategory category, int color) {
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
        return damageTaken > DestinyConfig.getUnravelTrigger();
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        DestinyExplode.ExplodeDamage(entity.getWorld(), entity.getPos(), DestinyConfig.getUnravelRange(), DestinyConfig.getUnravelMinDamage(),DestinyConfig.getUnravelMaxDamage(), DestinyDamageSoures.strandDamage);
        DestinyExplode.ExplodeEffect(entity.getWorld(), entity.getPos(), DestinyConfig.getUnravelRange(), new StatusEffectInstance(DestinyEffects.STRAND_UNRAVEL, (int)(DestinyConfig.getUnravelDuration()*20)));
        entity.removeStatusEffect(DestinyEffects.STRAND_UNRAVEL);
        entity.addStatusEffect(new StatusEffectInstance(DestinyEffects.STRAND_UNRAVEL, (int)(DestinyConfig.getUnravelDuration()*20)));
    }
}
