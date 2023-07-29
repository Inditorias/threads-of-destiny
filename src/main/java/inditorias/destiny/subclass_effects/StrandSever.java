package inditorias.destiny.subclass_effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class StrandSever extends StatusEffect {
    public StrandSever(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public static float ModifyDamage(float amount) {
        return amount * 0.67f;
    }
}
