package inditorias.destiny.mixin;

import inditorias.destiny.config.DestinyConfig;
import inditorias.destiny.lib.EffectData;
import inditorias.destiny.lib.IEntityDataSaver;
import inditorias.destiny.registries.DestinyEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(LivingEntity.class)
public abstract class DamageRecordMixin {

    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);


    @Shadow public abstract boolean removeStatusEffect(StatusEffect type);

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

    @Inject(method="damage", at = @At(value = "TAIL"))
    private void recordDamage(DamageSource source, float amount, @NotNull CallbackInfoReturnable<Boolean> cir){
        if(cir.getReturnValue()){
            if(hasStatusEffect(DestinyEffects.STASIS_FREEZE)){
                EffectData.addFreezeDamage((IEntityDataSaver) this, amount);
            }
            if(hasStatusEffect(DestinyEffects.ARC_JOLT)){
                EffectData.addJoltDamage((IEntityDataSaver) this, amount);
            }
            if(hasStatusEffect(DestinyEffects.STRAND_UNRAVEL)){
                float damage = amount + EffectData.getUnravelDamage((IEntityDataSaver) this);
                removeStatusEffect(DestinyEffects.STRAND_UNRAVEL);
                addStatusEffect(new StatusEffectInstance(DestinyEffects.STRAND_UNRAVEL, (int)(DestinyConfig.getUnravelDuration()*20), 1));
                EffectData.setUnravelDamage((IEntityDataSaver) this, damage);
            }
            if(hasStatusEffect(DestinyEffects.VOID_VOLATILE)){
                EffectData.addVolatileDamage((IEntityDataSaver) this, amount);
            }
        }
    }

}
