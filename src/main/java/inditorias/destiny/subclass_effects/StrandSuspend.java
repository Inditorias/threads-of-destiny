package inditorias.destiny.subclass_effects;

import inditorias.destiny.config.DestinyConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;

public class StrandSuspend extends StatusEffect {
    private Vec3d position;
    public StrandSuspend(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        position = entity.getPos();
        entity.setPos(position.getX(), position.getY() + DestinyConfig.getStrandSuspendHeight(), position.getZ());
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        double x = entity.getVelocity().getX();
        double y = 0;
        double maxY = position.getY() + DestinyConfig.getStrandSuspendHeight();
        double z = entity.getVelocity().getZ();
        float maxVel = DestinyConfig.getStrandSuspendMaxVelocity();
        if(Math.abs(x) > maxVel){
            x /= 2;
        }
        if(Math.abs(z) > maxVel){
            z /= 2;
        }
        if(maxY > entity.getPos().getY()){
            y = DestinyConfig.getStrandSuspendLift();
        }
        entity.setVelocity(x,y,z);
        entity.setPos(entity.getPos().getX(), Math.min(entity.getPos().getY(), maxY), entity.getPos().getZ());
    }


}
