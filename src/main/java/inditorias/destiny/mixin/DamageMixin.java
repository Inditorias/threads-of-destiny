package inditorias.destiny.mixin;

import inditorias.destiny.config.DestinyConfig;
import inditorias.destiny.lib.EffectData;
import inditorias.destiny.lib.IEntityDataSaver;
import inditorias.destiny.registries.DestinyEffects;
import inditorias.destiny.subclass_effects.ArcJolt;
import inditorias.destiny.subclass_effects.StasisShatter;
import inditorias.destiny.subclass_effects.StrandUnravel;
import inditorias.destiny.subclass_effects.VoidVolatile;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
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


    @Shadow public abstract boolean removeStatusEffect(StatusEffect type);

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

    @Shadow public abstract boolean damage(DamageSource source, float amount);

    @Shadow protected abstract void applyMovementEffects(BlockPos pos);

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

    @Inject(method = "onDeath", at = @At(value = "TAIL"))
    private void VolatileDeath(DamageSource damageSource, CallbackInfo ci){
        if(damageSource == null)return;
        World world = null;
        if(damageSource.getSource() != null){
            if(!damageSource.getSource().getWorld().isClient()){
                world = damageSource.getSource().getWorld();
            }else if(damageSource.getAttacker() != null){
                if(!damageSource.getAttacker().getWorld().isClient()){
                    world = damageSource.getAttacker().getWorld();
                }
            }
        }
        if(world == null)return;
        if(hasStatusEffect(DestinyEffects.VOID_VOLATILE)){
            VoidVolatile.explodeVolatile(world, damageSource.getPosition());
        }
        if(hasStatusEffect(DestinyEffects.STASIS_FREEZE)){
            StasisShatter.shatter(world, damageSource.getPosition());
        }
        if(hasStatusEffect(DestinyEffects.ARC_JOLT)){
            ArcJolt.joltExplode(world, damageSource.getPosition());
        }
        if(hasStatusEffect(DestinyEffects.STRAND_UNRAVEL)){
            StrandUnravel.unravelExplode(world, damageSource.getPosition());
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
