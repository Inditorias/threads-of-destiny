package inditorias.destiny.lib;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.ArrayList;

public class DestinyExplode {
    public static void ExplodeDamage(World world, Vec3d source, float range, float minDamage, float maxDamage, DamageSource damageSource){
        try {
            ArrayList<LivingEntity> entities = new ArrayList<>(world.getEntitiesByClass(LivingEntity.class,
                    new Box(source.getX() + range, source.getY() + range, source.getZ() + range, source.getX() - range, source.getY() - range, source.getZ() - range), Entity::isLiving));
            for (LivingEntity e : entities) {
                if (e.getPos().distanceTo(source) > range) continue;
                e.damage(damageSource, (float) (minDamage + ((e.getPos().distanceTo(source) - range) / range * (maxDamage - minDamage))));
            }
        }catch (Exception ignored){

        }
    }

    public static void SetFireRandomly(World world, BlockPos source, float range, float chance){
        if(world.isClient())return;
        final Random random = Random.create();
        int i, j, k;
        for(i = (int)(-range); i < range; i++){
            for(j = (int)(-range); j < range; j++){
                for(k = (int)(-range); k < range; k++){
                    BlockPos blockPos3 = new BlockPos(i+source.getX(), j+source.getY(), k+source.getZ());
                    if (random.nextFloat() > chance || !world.getBlockState(blockPos3).isAir() || !world.getBlockState(blockPos3.down()).isOpaqueFullCube(world, blockPos3.down())) continue;
                    world.setBlockState(blockPos3, Blocks.FIRE.getDefaultState());
                }
            }
        }
    }

    public static void ExplodeEffect(World world, Vec3d source, float range, StatusEffectInstance effectInstance){
        ArrayList<LivingEntity> entities = new ArrayList<>(world.getEntitiesByClass(LivingEntity.class,
                new Box(source.getX() + range, source.getY() + range, source.getZ() + range, source.getX() - range, source.getY() - range, source.getZ() - range), Entity::isLiving));
        for(LivingEntity e : entities){
            if(e.getPos().distanceTo(source) > range)continue;
            e.addStatusEffect(effectInstance);
        }
    }
}
