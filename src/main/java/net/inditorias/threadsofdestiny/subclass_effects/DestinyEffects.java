package net.inditorias.threadsofdestiny.subclass_effects;

import net.inditorias.threadsofdestiny.ThreadsOfDestiny;
import net.inditorias.threadsofdestiny.lib.SubclassColors;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DestinyEffects {

    public static final StatusEffect SOLAR_CURE = new SolarCure(StatusEffectCategory.BENEFICIAL, SubclassColors.SOLAR_COLOR);

    private static void registerEffect(String name, StatusEffect effect){
        Registry.register(Registries.STATUS_EFFECT, Identifier.of(ThreadsOfDestiny.MOD_ID,name),effect);
    }

    public static void registerEffects(){
        ThreadsOfDestiny.LOGGER.info("Registering Effects for " + ThreadsOfDestiny.MOD_ID);
        registerEffect("solar_cure",SOLAR_CURE);
    }
}
