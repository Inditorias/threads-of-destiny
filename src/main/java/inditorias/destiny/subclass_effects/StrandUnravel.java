package inditorias.destiny.subclass_effects;

import inditorias.destiny.config.DestinyConfig;
import inditorias.destiny.lib.DestinyExplode;
import inditorias.destiny.lib.EffectData;
import inditorias.destiny.lib.IEntityDataSaver;
import inditorias.destiny.registries.DestinyDamageSoures;
import inditorias.destiny.registries.DestinyEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class StrandUnravel extends StatusEffect {

    public StrandUnravel(StatusEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        EffectData.setUnravelDamage((IEntityDataSaver) entity, 0);
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(EffectData.getUnravelDamage((IEntityDataSaver) entity) > DestinyConfig.getUnravelTrigger()) {
            unravelExplode(entity.getWorld(), entity.getPos());
            entity.removeStatusEffect(DestinyEffects.STRAND_UNRAVEL);
            entity.addStatusEffect(new StatusEffectInstance(DestinyEffects.STRAND_UNRAVEL, (int) (DestinyConfig.getUnravelDuration() * 20)));
        }
    }

    public static void unravelExplode(World world, Vec3d pos){
        DestinyExplode.ExplodeDamage(world, pos, DestinyConfig.getUnravelRange(), DestinyConfig.getUnravelMinDamage(), DestinyConfig.getUnravelMaxDamage(), DestinyDamageSoures.strandDamage);
        DestinyExplode.ExplodeEffect(world, pos, DestinyConfig.getUnravelRange(), new StatusEffectInstance(DestinyEffects.STRAND_UNRAVEL, (int) (DestinyConfig.getUnravelDuration() * 20)));
    }
}
