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
        static float IGNITION_RADIUS = 5f;
        static float IGNITION_DAMAGE_MAX = 25f;
        static float IGNITION_DAMAGE_MIN = 12f;
        static float IGNITION_DAMAGE_RANGE = 5f;
    }
    static class VoidConfig{

    }
    static class StasisConfig{

    }
    static class StrandConfig{

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
}
