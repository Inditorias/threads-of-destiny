package inditorias.destiny.mixin;

import inditorias.destiny.registries.DestinyEffects;
import inditorias.destiny.subclass_effects.ArcJolt;
import inditorias.destiny.subclass_effects.StasisShatter;
import inditorias.destiny.subclass_effects.StrandUnravel;
import inditorias.destiny.subclass_effects.VoidVolatile;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(LivingEntity.class)
public abstract class DeathExplosionMixin {

    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);
    @Inject(method = "onDeath", at = @At(value = "HEAD"))
    private void ExplosiveDeath(DamageSource damageSource, CallbackInfo ci){
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
}
