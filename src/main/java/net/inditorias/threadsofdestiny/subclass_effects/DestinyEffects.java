package net.inditorias.threadsofdestiny.subclass_effects;

import net.inditorias.threadsofdestiny.ThreadsOfDestiny;
import net.inditorias.threadsofdestiny.lib.SubclassColors;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DestinyEffects {

    public static final StatusEffect SOLAR_RESTORATION = new SolarRestoration(StatusEffectCategory.BENEFICIAL, SubclassColors.SOLAR_COLOR);
    public static final StatusEffect SOLAR_CURE = new SolarCure(StatusEffectCategory.BENEFICIAL, SubclassColors.SOLAR_COLOR);
//    public static final StatusEffect SOLAR_RADIANT= new SolarRadiant(StatusEffectCategory.BENEFICIAL, SubclassColors.SOLAR_COLOR);
//    public static final StatusEffect SOLAR_SCORCH= new SolarScorch(StatusEffectCategory.HARMFUL, SubclassColors.SOLAR_COLOR);
//    public static final StatusEffect SOLAR_IGNITION= new SolarIgnition(StatusEffectCategory.HARMFUL, SubclassColors.SOLAR_COLOR);
//    public static final StatusEffect ARC_AMPLIFIED = new ArcAmplified(StatusEffectCategory.BENEFICIAL, SubclassColors.ARC_COLOR);
//    public static final StatusEffect ARC_BLIND = new ArcBlind(StatusEffectCategory.HARMFUL, SubclassColors.ARC_COLOR);
//    public static final StatusEffect ARC_JOLT= new ArcJolt(StatusEffectCategory.HARMFUL, SubclassColors.ARC_COLOR);
//    public static final StatusEffect ARC_SPEEDBOOST= new ArcSpeedboost(StatusEffectCategory.BENEFICIAL, SubclassColors.ARC_COLOR);
//    public static final StatusEffect STASIS_FREEZE= new StasisFreeze(StatusEffectCategory.HARMFUL, SubclassColors.STASIS_COLOR);
//    public static final StatusEffect STASIS_SHARD_OVERSHIELD= new StasisShardOvershield(StatusEffectCategory.BENEFICIAL, SubclassColors.STASIS_COLOR);
//    public static final StatusEffect STASIS_SHATTER= new StasisShatter(StatusEffectCategory.HARMFUL, SubclassColors.STASIS_COLOR);
//    public static final StatusEffect STASIS_SLOW= new StasisSlow(StatusEffectCategory.HARMFUL, SubclassColors.STASIS_COLOR);
//    public static final StatusEffect STRAND_SEVER= new StrandSever(StatusEffectCategory.HARMFUL, SubclassColors.STRAND_COLOR);
//    public static final StatusEffect STRAND_SUSPEND= new StrandSuspend(StatusEffectCategory.HARMFUL, SubclassColors.STRAND_COLOR);
//    public static final StatusEffect STRAND_UNRAVEL= new StrandUnravel(StatusEffectCategory.HARMFUL, SubclassColors.STRAND_COLOR);
//    public static final StatusEffect STRAND_UNRAVELING_ROUNDS= new StrandUnravelingRounds(StatusEffectCategory.BENEFICIAL, SubclassColors.STRAND_COLOR);
//    public static final StatusEffect STRAND_WOVEN_MAIL= new StrandWovenMail(StatusEffectCategory.BENEFICIAL, SubclassColors.STRAND_COLOR);
//    public static final StatusEffect VOID_DEVOUR= new VoidDevour(StatusEffectCategory.BENEFICIAL, SubclassColors.VOID_COLOR);
//    public static final StatusEffect VOID_OVERSHIELD= new VoidOvershield(StatusEffectCategory.BENEFICIAL, SubclassColors.VOID_COLOR);
//    public static final StatusEffect VOID_SUPPRESSED= new VoidSuppressed(StatusEffectCategory.HARMFUL, SubclassColors.VOID_COLOR);
//    public static final StatusEffect VOID_VOLATILE= new VoidVolatile(StatusEffectCategory.HARMFUL, SubclassColors.VOID_COLOR);
//    public static final StatusEffect VOID_VOLATILE_ROUNDS= new VoidVolatileRounds(StatusEffectCategory.BENEFICIAL, SubclassColors.VOID_COLOR);
//    public static final StatusEffect VOID_WEAKEN= new VoidWeaken(StatusEffectCategory.HARMFUL, SubclassColors.VOID_COLOR);
//    public static final StatusEffect VOID_INVISIBILITY = new VoidInvisibility(StatusEffectCategory.BENEFICIAL, SubclassColors.VOID_COLOR);


    private static void registerEffect(String name, StatusEffect effect){
        Registry.register(Registries.STATUS_EFFECT, Identifier.of(ThreadsOfDestiny.MOD_ID,name),effect);
    }

    public static void registerEffects(){
        ThreadsOfDestiny.LOGGER.info("Registering Effects for " + ThreadsOfDestiny.MOD_ID);
        registerEffect("solar_cure",SOLAR_CURE);
        registerEffect("solar_restoration",SOLAR_RESTORATION);
        //registerEffect("solar_radiant",SOLAR_RADIANT);
        //registerEffect("solar_scorch",SOLAR_SCORCH);
        //registerEffect("solar_ignition",SOLAR_IGNITION);
        //registerEffect("arc_amplified",ARC_AMPLIFIED);
        //registerEffect("arc_blind",ARC_BLIND);
        //registerEffect("arc_jolt",ARC_JOLT);
        //registerEffect("arc_speedboost",ARC_SPEEDBOOST);
        //registerEffect("stasis_freeze",STASIS_FREEZE);
        //registerEffect("stasis_shard_overshield",STASIS_SHARD_OVERSHIELD);
        //registerEffect("stasis_shatter",STASIS_SHATTER=);
        //registerEffect("stasis_slow",STASIS_SLOW);
        //registerEffect("strand_sever",STRAND_SEVER);
        //registerEffect("strand_suspend",STRAND_SUSPEND);
        //registerEffect("strand_unravel",STRAND_UNRAVEL);
        //registerEffect("strand_unraveling_rounds",STRAND_UNRAVELING_ROUNDS);
        //registerEffect("strand_woven_mail",STRAND_WOVEN_MAIL);
        //registerEffect("void_devour",VOID_DEVOUR);
        //registerEffect("void_overshield",VOID_OVERSHIELD);
        //registerEffect("void_supress",VOID_SUPPRESSED);
        //registerEffect("void_volatile",VOID_VOLATILE);
        //registerEffect("void_volatile_rounds",VOID_VOLATILE_ROUNDS);
        //registerEffect("void_weaken",VOID_WEAKEN);
        //registerEffect("void_invisibility",VOID_INVISIBILITY);
    }
}
