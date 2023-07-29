package inditorias.destiny.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LivingEntity.class)
public abstract class DamageMixin {

    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

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
