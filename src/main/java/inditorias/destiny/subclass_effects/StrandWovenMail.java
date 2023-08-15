package inditorias.destiny.subclass_effects;

import inditorias.destiny.config.DestinyConfig;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class StrandWovenMail extends StatusEffect {
    public StrandWovenMail(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public static float ModifyDamage(float amount) {
        return amount * (1.0f - DestinyConfig.getWovenMailReduction());
    }
}
