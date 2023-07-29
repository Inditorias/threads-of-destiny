package inditorias.destiny.registries;


import inditorias.destiny.DestinyMod;
import inditorias.destiny.subclass_effects.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DestinyEffects {
    public static final StatusEffect SOLAR_RESTORATION = new SolarRestoration(StatusEffectCategory.BENEFICIAL, SubclassColors.SOLAR_COLOR);
    public static final StatusEffect SOLAR_CURE = new SolarCure(StatusEffectCategory.BENEFICIAL, SubclassColors.SOLAR_COLOR);
    public static final StatusEffect SOLAR_RADIANT= new SolarRadiant(StatusEffectCategory.BENEFICIAL, SubclassColors.SOLAR_COLOR);
    public static final StatusEffect SOLAR_SCORCH= new SolarScorch(StatusEffectCategory.HARMFUL, SubclassColors.SOLAR_COLOR);
    public static final StatusEffect SOLAR_IGNITION= new SolarIgnition(StatusEffectCategory.HARMFUL, SubclassColors.SOLAR_COLOR);
    public static final StatusEffect ARC_AMPLIFIED = new ArcAmplified(StatusEffectCategory.BENEFICIAL, SubclassColors.ARC_COLOR);
    public static final StatusEffect ARC_BLIND = new ArcBlind(StatusEffectCategory.HARMFUL, SubclassColors.ARC_COLOR);
    public static final StatusEffect ARC_JOLT= new ArcJolt(StatusEffectCategory.HARMFUL, SubclassColors.ARC_COLOR);
    public static final StatusEffect ARC_SPEEDBOOST= new ArcSpeedboost(StatusEffectCategory.BENEFICIAL, SubclassColors.ARC_COLOR);
    public static final StatusEffect STASIS_FREEZE= new StasisFreeze(StatusEffectCategory.HARMFUL, SubclassColors.STASIS_COLOR);
    public static final StatusEffect STASIS_SHARD_OVERSHIELD= new StasisShardOvershield(StatusEffectCategory.BENEFICIAL, SubclassColors.STASIS_COLOR);
    public static final StatusEffect STASIS_SHATTER= new StasisShatter(StatusEffectCategory.HARMFUL, SubclassColors.STASIS_COLOR);
    public static final StatusEffect STASIS_SLOW= new StasisSlow(StatusEffectCategory.HARMFUL, SubclassColors.STASIS_COLOR);
    public static final StatusEffect STRAND_SEVER= new StrandSever(StatusEffectCategory.HARMFUL, SubclassColors.STRAND_COLOR);
    public static final StatusEffect STRAND_SUSPEND= new StrandSuspend(StatusEffectCategory.HARMFUL, SubclassColors.STRAND_COLOR);
    public static final StatusEffect STRAND_UNRAVEL= new StrandUnravel(StatusEffectCategory.HARMFUL, SubclassColors.STRAND_COLOR);
    public static final StatusEffect STRAND_UNRAVELING_ROUNDS= new StrandUnravelingRounds(StatusEffectCategory.BENEFICIAL, SubclassColors.STRAND_COLOR);
    public static final StatusEffect STRAND_WOVEN_MAIL= new StrandWovenMail(StatusEffectCategory.BENEFICIAL, SubclassColors.STRAND_COLOR);
    public static final StatusEffect VOID_DEVOUR= new VoidDevour(StatusEffectCategory.BENEFICIAL, SubclassColors.VOID_COLOR);
    public static final StatusEffect VOID_OVERSHIELD= new VoidOvershield(StatusEffectCategory.BENEFICIAL, SubclassColors.VOID_COLOR);
    public static final StatusEffect VOID_SUPPRESSED= new VoidSuppressed(StatusEffectCategory.HARMFUL, SubclassColors.VOID_COLOR);
    public static final StatusEffect VOID_VOLATILE= new VoidVolatile(StatusEffectCategory.HARMFUL, SubclassColors.VOID_COLOR);
    public static final StatusEffect VOID_VOLATILE_ROUNDS= new VoidVolatileRounds(StatusEffectCategory.BENEFICIAL, SubclassColors.VOID_COLOR);
    public static final StatusEffect VOID_WEAKEN= new VoidWeaken(StatusEffectCategory.HARMFUL, SubclassColors.VOID_COLOR);
    public static final StatusEffect VOID_INVISIBILITY = new VoidInvisibility(StatusEffectCategory.BENEFICIAL, SubclassColors.VOID_COLOR);


    public static void registerEffects(){
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"solar_restoration"), SOLAR_RESTORATION);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"solar_cure"), SOLAR_CURE);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"solar_radiant"), SOLAR_RADIANT);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"solar_scorch"), SOLAR_SCORCH);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"solar_ignition"), SOLAR_IGNITION);

        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"arc_amplified"), ARC_AMPLIFIED);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"arc_speedboost"), ARC_SPEEDBOOST);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"arc_jolt"), ARC_JOLT);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"arc_blind"), ARC_BLIND);

        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"stasis_slow"), STASIS_SLOW);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"stasis_freeze"), STASIS_FREEZE);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"stasis_shatter"), STASIS_SHATTER);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"stasis_shard_overshield"), STASIS_SHARD_OVERSHIELD);

        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"strand_sever"), STRAND_SEVER);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"strand_suspend"), STRAND_SUSPEND);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"strand_unravel"), STRAND_UNRAVEL);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"strand_unraveling_rounds"), STRAND_UNRAVELING_ROUNDS);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"strand_woven_mail"), STRAND_WOVEN_MAIL);

        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"void_devour"), VOID_DEVOUR);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"void_invisibility"), VOID_INVISIBILITY);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"void_overshield"), VOID_OVERSHIELD);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"void_suppressed"), VOID_SUPPRESSED);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"void_volatile"), VOID_VOLATILE);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"void_volatile_rounds"), VOID_VOLATILE_ROUNDS);
        Registry.register(Registries.STATUS_EFFECT,new Identifier(DestinyMod.MOD_ID,"void_weaken"), VOID_WEAKEN);
    }
}
