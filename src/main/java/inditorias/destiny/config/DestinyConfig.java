package inditorias.destiny.config;

import inditorias.destiny.DestinyMod;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = DestinyMod.MOD_ID)
public class DestinyConfig implements ConfigData {



    @ConfigEntry.Gui.CollapsibleObject
    ArcConfig arcConfig = new ArcConfig();
    @ConfigEntry.Gui.CollapsibleObject
    SolarConfig solarConfig = new SolarConfig();
    @ConfigEntry.Gui.CollapsibleObject
    StasisConfig stasisConfig = new StasisConfig();
    @ConfigEntry.Gui.CollapsibleObject
    StrandConfig strandConfig = new StrandConfig();
    @ConfigEntry.Gui.CollapsibleObject
    VoidConfig voidConfig = new VoidConfig();


    public static class ArcConfig{
        static float JOLT_TRIGGER = 12f;
        static float JOLT_DAMAGE = 17f;
        static float JOLT_RANGE = 8f;
        static float SPEEDBOOST_MOVEMENT_MODIFIER = 1.125f;
        static float SPEEDBOOST_JUMP_MODIFIER = 1.25f;
        static float SPEEDBOOST_FALLOFF = 2f;
        static float AMPLIFIED_MOVEMENT_MODIFIER = 1.116f;
        static float AMPLIFIED_JUMP_MODIFIER = 1.125f;
        static float SPEEDBOOST_WARMUP = 2.5f;
    }
    static class SolarConfig{
        static float SOLAR_CURE_AMOUNT = 6f;
        static float RESTORATION_I = 4f;
        static float RESTORATION_II = 6.5f;
        static float SCORCH_DAMAGE = 0.0195f;
        static float SCORCH_BASE = 0.3f;
        static float SCORCH_DAMAGE_TIME = 0.56f;
        static float SCORCH_FALL_TIME = 4.5f;
        static float SCORCH_REMOVE_PER_TIME = 5.67f;
        static float SCORCH_REMOVE_TIME = 0.56f;
        static float RADIANT_MULTIPLIER = 0.25f;
        static float IGNITION_RADIUS = 3f;
        static float IGNITION_DAMAGE_MAX = 25f;
        static float IGNITION_DAMAGE_MIN = 6f;
        static float IGNITION_DAMAGE_RANGE = 5f;
        static float IGNITION_FIRE_RANGE = 5f;
        static float IGNITION_FIRE_CHANCE = 0.1f;
    }
    static class VoidConfig{
        static float VOLATILE_DAMAGE_MAX = 16f;
        static float VOLATILE_DAMAGE_MIN = 16f;
        static float VOLATILE_TRIGGER = 19f;
        static float VOLATILE_RANGE = 7f;
        static float VOLATILE_DURATION = 6f;
    }
    static class StasisConfig{
        static float SHATTER_MAX_DAMAGE = 20f;
        static float SHATTER_MIN_DAMAGE = 20f;
        static float SHATTER_TRIGGER = 20f;
        static float SHATTER_RANGE = 3f;

    }
    static class StrandConfig{
        static float UNRAVEL_DURATION = 9f;
        static float UNRAVEL_DAMAGE_MAX = 2.9f;
        static float UNRAVEL_DAMAGE_MIN = 2.9f;
        static float UNRAVEL_TRIGGER = 4;
        static float UNRAVEL_RANGE = 2f;
        static float SUSPEND_HEIGHT = 4f;
        static float SUSPEND_MAX_VELOCITY = 0.01f;
        static float SUSPEND_LIFT = 1.8f;
        static float WOVEN_MAIL_REDUCTION = 0.6f;
    }
    public static float getSolarCureAmount(){return SolarConfig.SOLAR_CURE_AMOUNT;}
    public static float getSolarScorchDamage(){return SolarConfig.SCORCH_DAMAGE;}
    public static float getSolarScorchBase(){return SolarConfig.SCORCH_BASE;}
    public static float getSolarScorchDamageTime(){return SolarConfig.SCORCH_DAMAGE_TIME;}
    public static float getSolarScorchFallTime(){return SolarConfig.SCORCH_FALL_TIME;}
    public static float getSolarScorchRemovePerTime(){return SolarConfig.SCORCH_REMOVE_PER_TIME;}
    public static float getSolarScorchRemoveTime(){return SolarConfig.SCORCH_REMOVE_TIME;}
    public static float getSolarRestorationI(){return SolarConfig.RESTORATION_I;}
    public static float getSolarRestorationII(){return SolarConfig.RESTORATION_II;}
    public static float getSolarRadiantMultiplier(){return 1 + SolarConfig.RADIANT_MULTIPLIER;}
    public static float getIgnitionRadius(){return SolarConfig.IGNITION_RADIUS;}
    public static float getIgnitionMaxDamage(){return SolarConfig.IGNITION_DAMAGE_MAX;}
    public static float getIgnitionMinDamage(){return SolarConfig.IGNITION_DAMAGE_MIN;}
    public static float getIgnitionDamageRange(){return SolarConfig.IGNITION_DAMAGE_RANGE;}
    public static float getIgnitionFireRange() { return SolarConfig.IGNITION_FIRE_RANGE;}
    public static float getIgnitionFireChance(){return SolarConfig.IGNITION_FIRE_CHANCE;}

    public static float getJoltTrigger(){return ArcConfig.JOLT_TRIGGER;}
    public static float getJoltDamage(){return ArcConfig.JOLT_DAMAGE;}
    public static float getJoltRange(){return ArcConfig.JOLT_RANGE;}
    public static float getSpeedboostMovementModifier(){return ArcConfig.SPEEDBOOST_MOVEMENT_MODIFIER;}
    public static float getSpeedboostJumpModifier(){return ArcConfig.SPEEDBOOST_JUMP_MODIFIER;}
    public static float getSpeedboostFalloff(){return ArcConfig.SPEEDBOOST_FALLOFF;}
    public static float getSpeedboostWarmup(){return ArcConfig.SPEEDBOOST_WARMUP;}
    public static float getAmplifiedMovementModifier(){return ArcConfig.AMPLIFIED_MOVEMENT_MODIFIER;}
    public static float getAmplifiedJumpModifier(){return ArcConfig.AMPLIFIED_JUMP_MODIFIER;}

    public static float getShatterTrigger() {return StasisConfig.SHATTER_TRIGGER; }
    public static float getShatterMaxDamage() {return StasisConfig.SHATTER_MAX_DAMAGE; }
    public static float getShatterMinDamage() {return StasisConfig.SHATTER_MIN_DAMAGE; }
    public static float getShatterRange() {return StasisConfig.SHATTER_RANGE; }

    public static float getVolatileTrigger() {return VoidConfig.VOLATILE_TRIGGER; }
    public static float getVolatileMaxDamage() {return VoidConfig.VOLATILE_DAMAGE_MAX; }
    public static float getVolatileMinDamage() {return VoidConfig.VOLATILE_DAMAGE_MIN; }
    public static float getVolatileRange() {return VoidConfig.VOLATILE_RANGE; }
    public static float getVolatileDuration(){return VoidConfig.VOLATILE_DURATION;}

    public static float getUnravelTrigger() {return StrandConfig.UNRAVEL_TRIGGER; }
    public static float getUnravelMaxDamage() {return StrandConfig.UNRAVEL_DAMAGE_MAX; }
    public static float getUnravelMinDamage() {return StrandConfig.UNRAVEL_DAMAGE_MIN; }
    public static float getUnravelRange() {return StrandConfig.UNRAVEL_RANGE; }
    public static float getUnravelDuration(){return StrandConfig.UNRAVEL_DURATION;}
    public static float getStrandSuspendHeight(){return StrandConfig.SUSPEND_HEIGHT;}
    public static float getStrandSuspendMaxVelocity(){return StrandConfig.SUSPEND_MAX_VELOCITY;}
    public static float getStrandSuspendLift(){return StrandConfig.SUSPEND_LIFT;}
    public static float getWovenMailReduction() {
        return Math.max(Math.min(1,StrandConfig.WOVEN_MAIL_REDUCTION), 0);
    }
}
