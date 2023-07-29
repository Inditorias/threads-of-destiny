package inditorias.destiny.subclass_effects;

import inditorias.destiny.config.DestinyConfig;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class SolarRadiant extends StatusEffect {

    public static float ModifyDamage(float incomingDamage){
        return incomingDamage * DestinyConfig.getSolarRadiantMultiplier();
    }

    public SolarRadiant(StatusEffectCategory category, int color) {
        super(category, color);
    }

}
