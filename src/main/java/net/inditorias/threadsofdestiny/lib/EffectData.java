package net.inditorias.threadsofdestiny.lib;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;

public class EffectData {

    public static final String FREEZE_POS_X = "freeze_pos_x";
    public static final String FREEZE_POS_Y = "freeze_pos_y";
    public static final String FREEZE_POS_Z = "freeze_pos_z";
    public static final String SUSPEND_POS_X = "suspend_pos_x";
    public static final String SUSPEND_POS_Y = "suspend_pos_y";
    public static final String SUSPEND_POS_Z = "suspend_pos_z";
    public static final String FREEZE_DAMAGE = "freeze_damage";
    public static final String UNRAVEL_DAMAGE = "unravel_damage";
    public static final String VOLATILE_DAMAGE = "volatile_damage";
    public static final String JOLT_DAMAGE = "jolt_damage";
    public static final String AMPLIFIED_RUNNING = "amplified_running";

    public static float addJoltDamage(IEntityDataSaver entity, float amount){
        return setJoltDamage(entity, getJoltDamage(entity) + amount);
    }
    public static float getJoltDamage(IEntityDataSaver entity){
        NbtCompound nbt = entity.getPersistentData();
        return nbt.getFloat(JOLT_DAMAGE);
    }
    public static float setJoltDamage(IEntityDataSaver entity, float amount){
        NbtCompound nbt = entity.getPersistentData();
        nbt.putFloat(JOLT_DAMAGE, amount);
        return amount;
    }

}
