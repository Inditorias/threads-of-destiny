package inditorias.destiny.subclass_effects;

import inditorias.destiny.config.DestinyConfig;
import inditorias.destiny.lib.DestinyExplode;
import inditorias.destiny.lib.EffectData;
import inditorias.destiny.lib.IEntityDataSaver;
import inditorias.destiny.registries.DestinyDamageSoures;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ArcJolt extends StatusEffect {
    public ArcJolt(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        EffectData.setJoltDamage((IEntityDataSaver) entity, 0);
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(EffectData.getJoltDamage((IEntityDataSaver) entity) > DestinyConfig.getJoltTrigger()){
            joltExplode(entity.getWorld(), entity.getPos());
            EffectData.setJoltDamage((IEntityDataSaver) entity, 0);
        }
    }

    public static void joltExplode(World world, Vec3d pos){
        DestinyExplode.ExplodeDamage(world, pos, DestinyConfig.getJoltRange(), DestinyConfig.getJoltDamage(), DestinyConfig.getJoltDamage(), DestinyDamageSoures.arcDamage);
    }
}
