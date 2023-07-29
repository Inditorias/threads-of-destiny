package inditorias.destiny.subclass_effects;

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
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        float RESTORATION_I = 4f;
        float RESTORATION_II = 6.5f;
        if (entity.getHealth() < entity.getMaxHealth()) {
            if (amplifier < 2) {
                entity.heal(RESTORATION_I/20);
            } else {
                entity.heal(RESTORATION_II/20);
            }
        }
    }
}
