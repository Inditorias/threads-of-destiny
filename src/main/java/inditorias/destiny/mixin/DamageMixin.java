package inditorias.destiny.mixin;

import inditorias.destiny.registries.DestinyEffects;
import inditorias.destiny.subclass_effects.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(LivingEntity.class)
public abstract class DamageMixin {

    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);
    @Shadow public abstract StatusEffectInstance getStatusEffect(StatusEffect effect);


    @Inject(method="damage", at = @At(value = "TAIL"))
    private void recordDamage(DamageSource source, float amount, @NotNull CallbackInfoReturnable<Boolean> cir){
        if(cir.getReturnValue()){
            if(hasStatusEffect(DestinyEffects.STASIS_FREEZE)){
                ((StasisFreeze) getStatusEffect(DestinyEffects.STASIS_FREEZE).getEffectType()).addDamage(amount);
            }
            if(hasStatusEffect(DestinyEffects.ARC_JOLT)){
                ((ArcJolt) getStatusEffect(DestinyEffects.ARC_JOLT).getEffectType()).addDamage(amount);
            }
            if(hasStatusEffect(DestinyEffects.STRAND_UNRAVEL)){
                ((StrandUnravel) getStatusEffect(DestinyEffects.STRAND_UNRAVEL).getEffectType()).addDamage(amount);
            }
            if(hasStatusEffect(DestinyEffects.VOID_VOLATILE)){
                ((VoidVolatile) getStatusEffect(DestinyEffects.VOID_VOLATILE).getEffectType()).addDamage(amount);
            }
        }
    }

    @Inject(method = "onDeath", at = @At(value = "TAIL"))
    private void VolatileDeath(DamageSource damageSource, CallbackInfo ci){
        if(damageSource == null)return;
        if(hasStatusEffect(DestinyEffects.VOID_VOLATILE)){
            VoidVolatile.explodeVolatile(MinecraftClient.getInstance().world, damageSource.getPosition());
        }
        if(hasStatusEffect(DestinyEffects.STASIS_FREEZE)){
            StasisShatter.shatter(MinecraftClient.getInstance().world, damageSource.getPosition());
        }
    }


//    @ModifyVariable(method="damage", at = @At(value = "HEAD"))
//    private float adjustOutgoingDamage(DamageSource source, float amount){
//        if(source.getAttacker() != null && source.getAttacker() instanceof LivingEntity) {
//            if (((LivingEntity) source.getAttacker()).hasStatusEffect(DestinyEffects.SOLAR_RADIANT)) {
//                amount = SolarRadiant.ModifyDamage(amount);
//            }
//            if (((LivingEntity) source.getAttacker()).hasStatusEffect(DestinyEffects.STRAND_SEVER)) {
//                amount = StrandSever.ModifyDamage(amount);
//            }
//            if (hasStatusEffect(DestinyEffects.VOID_WEAKEN)) {
//                amount = VoidWeaken.ModifyDamage(amount);
//            }
//
//        }
//        return amount;
//    }
}
