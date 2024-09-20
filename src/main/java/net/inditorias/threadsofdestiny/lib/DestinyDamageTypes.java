package net.inditorias.threadsofdestiny.lib;

import net.inditorias.threadsofdestiny.ThreadsOfDestiny;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class DestinyDamageTypes {

    public static final RegistryKey<DamageType> VOID_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(ThreadsOfDestiny.MOD_ID, "void"));
    public static final RegistryKey<DamageType> ARC_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(ThreadsOfDestiny.MOD_ID, "arc"));
    public static final RegistryKey<DamageType> STASIS_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(ThreadsOfDestiny.MOD_ID, "stasis"));
    public static final RegistryKey<DamageType> STRAND_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(ThreadsOfDestiny.MOD_ID, "strand"));
    public static final RegistryKey<DamageType> SOLAR_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(ThreadsOfDestiny.MOD_ID, "solar"));
    public static final RegistryKey<DamageType> KINETIC_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(ThreadsOfDestiny.MOD_ID, "kinetic"));
}
