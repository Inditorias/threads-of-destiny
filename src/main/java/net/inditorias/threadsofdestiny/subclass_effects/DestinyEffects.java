package net.inditorias.threadsofdestiny.subclass_effects;

import net.inditorias.threadsofdestiny.ThreadsOfDestiny;
import net.inditorias.threadsofdestiny.lib.SubclassColors;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class DestinyEffects {

    public static final StatusEffect SOLAR_RESTORATION = new SolarRestoration(StatusEffectCategory.BENEFICIAL, SubclassColors.SOLAR_COLOR);
    public static final StatusEffect SOLAR_CURE = new SolarCure(StatusEffectCategory.BENEFICIAL, SubclassColors.SOLAR_COLOR);
//    public static final StatusEffect SOLAR_RADIANT= new SolarRadiant(StatusEffectCategory.BENEFICIAL, SubclassColors.SOLAR_COLOR);
//    public static final StatusEffect SOLAR_SCORCH= new SolarScorch(StatusEffectCategory.HARMFUL, SubclassColors.SOLAR_COLOR);
    public static final StatusEffect SOLAR_IGNITION= new SolarIgnition(StatusEffectCategory.HARMFUL, SubclassColors.SOLAR_COLOR);
//    public static final StatusEffect ARC_AMPLIFIED = new ArcAmplified(StatusEffectCategory.BENEFICIAL, SubclassColors.ARC_COLOR);
//    public static final StatusEffect ARC_BLIND = new ArcBlind(StatusEffectCategory.HARMFUL, SubclassColors.ARC_COLOR);
    public static final StatusEffect ARC_JOLT= new ArcJolt(StatusEffectCategory.HARMFUL, SubclassColors.ARC_COLOR);
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

    public static final RegistryEntry.Reference<StatusEffect> ARC_JOLT_REGISTRY_ENTRY = registerEffect("arc_jolt",ARC_JOLT);;
    public static final RegistryEntry.Reference<StatusEffect> SOLAR_CURE_REGISTRY_ENTRY = registerEffect("solar_cure",SOLAR_CURE);
    public static final RegistryEntry.Reference<StatusEffect> SOLAR_RESTORATION_REGISTRY_ENTRY = registerEffect("solar_restoration",SOLAR_RESTORATION);
    //public static final RegistryEntry.Reference<StatusEffect> SOLAR_RADIANT_REGISTRY_ENTRY = registerEffect("solar_radiant",SOLAR_RADIANT);
    //public static final RegistryEntry.Reference<StatusEffect> SOLAR_SCORCH_REGISTRY_ENTRY = registerEffect("solar_scorch",SOLAR_SCORCH);
    public static final RegistryEntry.Reference<StatusEffect> SOLAR_IGNITION_REGISTRY_ENTRY = registerEffect("solar_ignition",SOLAR_IGNITION);
    //public static final RegistryEntry.Reference<StatusEffect> ARC_AMPLIFIED_REGISTRY_ENTRY = registerEffect("arc_amplified",ARC_AMPLIFIED);
    //public static final RegistryEntry.Reference<StatusEffect> ARC_BLIND_REGISTRY_ENTRY = registerEffect("arc_blind",ARC_BLIND);
    //public static final RegistryEntry.Reference<StatusEffect> ARC_SPEEDBOOST_REGISTRY_ENTRY = registerEffect("arc_speedboost",ARC_SPEEDBOOST);
    //public static final RegistryEntry.Reference<StatusEffect> STASIS_FREEZE_REGISTRY_ENTRY = registerEffect("stasis_freeze",STASIS_FREEZE);
    //public static final RegistryEntry.Reference<StatusEffect> STASIS_SHARD_OVERSHIELD_REGISTRY_ENTRY = registerEffect("stasis_shard_overshield",STASIS_SHARD_OVERSHIELD);
    //public static final RegistryEntry.Reference<StatusEffect> STASIS_SHATTER_REGISTRY_ENTRY = registerEffect("stasis_shatter",STASIS_SHATTER=);
    //public static final RegistryEntry.Reference<StatusEffect> STASIS_SLOW_REGISTRY_ENTRY = registerEffect("stasis_slow",STASIS_SLOW);
    //public static final RegistryEntry.Reference<StatusEffect> STRAND_SEVER_REGISTRY_ENTRY = registerEffect("strand_sever",STRAND_SEVER);
    //public static final RegistryEntry.Reference<StatusEffect> STRAND_SUSPEND_REGISTRY_ENTRY = registerEffect("strand_suspend",STRAND_SUSPEND);
    //public static final RegistryEntry.Reference<StatusEffect> STRAND_UNRAVEL_REGISTRY_ENTRY = registerEffect("strand_unravel",STRAND_UNRAVEL);
    //public static final RegistryEntry.Reference<StatusEffect> STRAND_UNRAVELING_ROUNDS_REGISTRY_ENTRY = registerEffect("strand_unraveling_rounds",STRAND_UNRAVELING_ROUNDS);
    //public static final RegistryEntry.Reference<StatusEffect> STRAND_WOVEN_MAIL_REGISTRY_ENTRY = registerEffect("strand_woven_mail",STRAND_WOVEN_MAIL);
    //public static final RegistryEntry.Reference<StatusEffect> VOID_DEVOUR_REGISTRY_ENTRY = registerEffect("void_devour",VOID_DEVOUR);
    //public static final RegistryEntry.Reference<StatusEffect> VOID_OVERSHIELD_REGISTRY_ENTRY = registerEffect("void_overshield",VOID_OVERSHIELD);
    //public static final RegistryEntry.Reference<StatusEffect> VOID_SUPPRESSED_REGISTRY_ENTRY = registerEffect("void_supress",VOID_SUPPRESSED);
    //public static final RegistryEntry.Reference<StatusEffect> VOID_VOLATILE_REGISTRY_ENTRY = registerEffect("void_volatile",VOID_VOLATILE);
    //public static final RegistryEntry.Reference<StatusEffect> VOID_VOLATILE_ROUNDS_REGISTRY_ENTRY = registerEffect("void_volatile_rounds",VOID_VOLATILE_ROUNDS);
    //public static final RegistryEntry.Reference<StatusEffect> VOID_WEAKEN_REGISTRY_ENTRY = registerEffect("void_weaken",VOID_WEAKEN);
    //public static final RegistryEntry.Reference<StatusEffect> VOID_INVISIBILITY_REGISTRY_ENTRY = registerEffect("void_invisibility",VOID_INVISIBILITY);

    private static RegistryEntry.Reference<StatusEffect> registerEffect(String name, StatusEffect effect){
        return  Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(ThreadsOfDestiny.MOD_ID,name),effect);
    }

    public static void registerEffects(){
        ThreadsOfDestiny.LOGGER.info("Registering Effects for " + ThreadsOfDestiny.MOD_ID);
    }
}
