package inditorias.destiny.subclass_effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class VoidWeaken extends StatusEffect {
    public VoidWeaken(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public static float ModifyDamage(float amount, int amplifier) {
        return amount * 1.15f * amplifier;
    }
}
