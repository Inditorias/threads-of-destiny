package inditorias.destiny.registries;

import inditorias.destiny.DestinyMod;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public interface DestinyDamageTypes {
    public static final RegistryKey<DamageType> VOID_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(DestinyMod.MOD_ID, "void"));
    public static final RegistryKey<DamageType> ARC_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(DestinyMod.MOD_ID, "arc"));
    public static final RegistryKey<DamageType> STASIS_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(DestinyMod.MOD_ID, "stasis"));
    public static final RegistryKey<DamageType> STRAND_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(DestinyMod.MOD_ID, "strand"));
    public static final RegistryKey<DamageType> SOLAR_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(DestinyMod.MOD_ID, "solar"));
    public static final RegistryKey<DamageType> KINETIC_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(DestinyMod.MOD_ID, "kinetic"));

}
