package inditorias.destiny.mixin;

import inditorias.destiny.config.DestinyConfig;
import inditorias.destiny.registries.DestinyEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class JumpVelocityMixin {

    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

    @Inject(method = "getJumpBoostVelocityModifier", at = @At("RETURN"), cancellable = true)
    public void ModifyJump(CallbackInfoReturnable<Float> cir){
        float jumpMod = cir.getReturnValue();
        if(this.hasStatusEffect(DestinyEffects.ARC_AMPLIFIED)){
            jumpMod = DestinyConfig.getAmplifiedJumpModifier();
        }
        if(this.hasStatusEffect(DestinyEffects.ARC_SPEEDBOOST)){
            jumpMod = DestinyConfig.getSpeedboostJumpModifier();
        }
        cir.setReturnValue(jumpMod);
    }
}
