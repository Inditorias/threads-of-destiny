package net.inditorias.threadsofdestiny.mixin;

import net.inditorias.threadsofdestiny.lib.EffectData;
import net.inditorias.threadsofdestiny.lib.IEntityDataSaver;
import net.inditorias.threadsofdestiny.subclass_effects.DestinyEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class DamageRecordMixin {

    @Shadow public abstract boolean hasStatusEffect(RegistryEntry<StatusEffect> effect);

    @Inject(method="damage", at = @At(value = "TAIL"))
    private void recordDamage(DamageSource source, float amount, @NotNull CallbackInfoReturnable<Boolean> cir){
        if(cir.getReturnValue()){
            if(this.hasStatusEffect(DestinyEffects.ARC_JOLT_REGISTRY)){
                EffectData.addJoltDamage((IEntityDataSaver) this, amount);
            }
        }
    }

}