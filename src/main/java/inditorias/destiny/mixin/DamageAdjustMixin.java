package inditorias.destiny.mixin;

import inditorias.destiny.registries.DestinyEffects;
import inditorias.destiny.subclass_effects.SolarRadiant;
import inditorias.destiny.subclass_effects.StrandSever;
import inditorias.destiny.subclass_effects.StrandWovenMail;
import inditorias.destiny.subclass_effects.VoidWeaken;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LivingEntity.class)
public abstract class DamageAdjustMixin {
    @Shadow
    public abstract boolean hasStatusEffect(StatusEffect effect);
    @Shadow public abstract StatusEffectInstance getStatusEffect(StatusEffect effect);
    @Unique
    private DamageSource destiny$damageSource;

    @ModifyVariable(method = "damage", at = @At("HEAD"), argsOnly = true)
    private DamageSource captureSource(DamageSource source) {
        destiny$damageSource = source;
        return source;
    }

    @ModifyVariable(method = "damage", at = @At("HEAD"), argsOnly = true)
    private float modifyDamageAmount(float amount) {
        if(destiny$damageSource.getAttacker() != null && destiny$damageSource.getAttacker() instanceof LivingEntity) {
            if (((LivingEntity) destiny$damageSource.getAttacker()).hasStatusEffect(DestinyEffects.SOLAR_RADIANT)) {
                amount = SolarRadiant.ModifyDamage(amount);
            }
            if (((LivingEntity) destiny$damageSource.getAttacker()).hasStatusEffect(DestinyEffects.STRAND_SEVER)) {
                amount = StrandSever.ModifyDamage(amount);
            }
            if (hasStatusEffect(DestinyEffects.VOID_WEAKEN)) {
                amount = VoidWeaken.ModifyDamage(amount, getStatusEffect(DestinyEffects.VOID_WEAKEN).getAmplifier());
            }
            if (hasStatusEffect(DestinyEffects.STRAND_WOVEN_MAIL)) {
                amount = StrandWovenMail.ModifyDamage(amount);
            }
        }
        return amount;
    }
}
