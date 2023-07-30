package inditorias.destiny.subclass_effects;

import inditorias.destiny.config.DestinyConfig;
import inditorias.destiny.lib.DestinyExplode;
import inditorias.destiny.registries.DestinyDamageSoures;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class ArcJolt extends StatusEffect {
    private float damageTaken;
    public ArcJolt(StatusEffectCategory category, int color) {
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
        return damageTaken > DestinyConfig.getJoltTrigger();
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        DestinyExplode.ExplodeDamage(entity.getWorld(), entity.getPos(), DestinyConfig.getJoltRange(), DestinyConfig.getJoltDamage(),DestinyConfig.getJoltDamage(), DestinyDamageSoures.arcDamage);
        damageTaken = 0;
    }
}
