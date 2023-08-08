package inditorias.destiny.subclass_effects;

import inditorias.destiny.config.DestinyConfig;
import inditorias.destiny.lib.DestinyExplode;
import inditorias.destiny.registries.DestinyDamageSoures;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class StasisShatter extends InstantStatusEffect {
    public StasisShatter(StatusEffectCategory category, int color) {
        super(category, color);
    }
    public static void shatter(World world, Vec3d pos){
        DestinyExplode.ExplodeDamage(world, pos, DestinyConfig.getShatterRange(), DestinyConfig.getShatterMinDamage(), DestinyConfig.getShatterMaxDamage(), DestinyDamageSoures.stasisDamage);
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        shatter(entity.getWorld(), entity.getPos());
    }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        shatter(target.getWorld(), target.getPos());
    }
}
