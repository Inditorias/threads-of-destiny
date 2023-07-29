package inditorias.destiny.mixin;

import inditorias.destiny.registries.DestinyDamageSoures;
import inditorias.destiny.registries.DestinyDamageTypes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DamageSources.class)
public abstract class DamageSourceMixin {
    @Shadow public abstract DamageSource create(RegistryKey<DamageType> key);

    @Inject(method = "<init>", at = @At(value = "TAIL"))
    private void createDestinyDamageSources(DynamicRegistryManager registryManager, CallbackInfo ci){
        DestinyDamageSoures.voidDamage = create(DestinyDamageTypes.VOID_DAMAGE);
        DestinyDamageSoures.strandDamage = create(DestinyDamageTypes.STRAND_DAMAGE);
        DestinyDamageSoures.stasisDamage = create(DestinyDamageTypes.STASIS_DAMAGE);
        DestinyDamageSoures.solarDamage = create(DestinyDamageTypes.SOLAR_DAMAGE);
        DestinyDamageSoures.arcDamage = create(DestinyDamageTypes.ARC_DAMAGE);
        DestinyDamageSoures.kineticDamage = create(DestinyDamageTypes.KINETIC_DAMAGE);
    }
}
