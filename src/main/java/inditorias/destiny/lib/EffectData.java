package inditorias.destiny.lib;

import inditorias.destiny.network.DestinyPackets;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
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

    public static float addUnravelDamage(IEntityDataSaver entity, float amount){
        NbtCompound nbt = entity.getPersistentData();
        float damage = nbt.getFloat(UNRAVEL_DAMAGE);
        damage += amount;

        nbt.putFloat(UNRAVEL_DAMAGE, damage);

        return damage;
    }
    public static float getUnravelDamage(IEntityDataSaver entity){
        NbtCompound nbt = entity.getPersistentData();
        return nbt.getFloat(UNRAVEL_DAMAGE);
    }
    public static float setUnravelDamage(IEntityDataSaver entity, float amount){
        NbtCompound nbt = entity.getPersistentData();
        nbt.putFloat(UNRAVEL_DAMAGE, amount);
        return amount;
    }



    public static float addFreezeDamage(IEntityDataSaver entity, float amount){
        NbtCompound nbt = entity.getPersistentData();
        float damage = nbt.getFloat(FREEZE_DAMAGE);
        damage += amount;

        nbt.putFloat(FREEZE_DAMAGE, damage);

        return damage;
    }
    public static float getFreezeDamage(IEntityDataSaver entity){
        NbtCompound nbt = entity.getPersistentData();
        return nbt.getFloat(FREEZE_DAMAGE);
    }
    public static float setFreezeDamage(IEntityDataSaver entity, float amount){
        NbtCompound nbt = entity.getPersistentData();
        nbt.putFloat(FREEZE_DAMAGE, amount);
        return amount;
    }

    public static Vec3d getFreezePos(IEntityDataSaver entity){
        NbtCompound nbt = entity.getPersistentData();
        float x = nbt.getFloat(FREEZE_POS_X);
        float y = nbt.getFloat(FREEZE_POS_Y);
        float z = nbt.getFloat(FREEZE_POS_Z);
        return new Vec3d(x, y, z);
    }
    public static Vec3d setFreezePos(IEntityDataSaver entity, Vec3d pos){
        NbtCompound nbt = entity.getPersistentData();
        float x = (float)pos.getX();
        float y = (float)pos.getY();
        float z = (float)pos.getZ();
        nbt.putFloat(FREEZE_POS_X, x);
        nbt.putFloat(FREEZE_POS_Y, y);
        nbt.putFloat(FREEZE_POS_Z, z);
        if(entity instanceof ServerPlayerEntity) syncFreezePos(pos, (ServerPlayerEntity) entity);
        return pos;
    }

    public static Vec3d getSuspendPos(IEntityDataSaver entity){
        NbtCompound nbt = entity.getPersistentData();
        float x = nbt.getFloat(SUSPEND_POS_X);
        float y = nbt.getFloat(SUSPEND_POS_Y);
        float z = nbt.getFloat(SUSPEND_POS_Z);
        return new Vec3d(x, y, z);
    }
    public static Vec3d setSuspendPos(IEntityDataSaver entity, Vec3d pos){
        NbtCompound nbt = entity.getPersistentData();
        float x = (float)pos.getX();
        float y = (float)pos.getY();
        float z = (float)pos.getZ();
        nbt.putFloat(SUSPEND_POS_X, x);
        nbt.putFloat(SUSPEND_POS_Y, y);
        nbt.putFloat(SUSPEND_POS_Z, z);
        if(entity instanceof ServerPlayerEntity) syncSuspendPos(pos, (ServerPlayerEntity) entity);
        return pos;
    }

    public static void syncSuspendPos(Vec3d pos, ServerPlayerEntity player){
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeFloat((float) pos.getX());
        buf.writeFloat((float) pos.getY());
        buf.writeFloat((float) pos.getZ());
        ServerPlayNetworking.send(player, DestinyPackets.SUSPEND_SYNC_ID, buf);
    }
    public static void syncFreezePos(Vec3d pos, ServerPlayerEntity player){
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeFloat((float) pos.getX());
        buf.writeFloat((float) pos.getY());
        buf.writeFloat((float) pos.getZ());
        ServerPlayNetworking.send(player, DestinyPackets.FREEZE_SYNC_ID, buf);
    }



    public static float addVolatileDamage(IEntityDataSaver entity, float amount){
        NbtCompound nbt = entity.getPersistentData();
        float damage = nbt.getFloat(VOLATILE_DAMAGE);
        damage += amount;

        nbt.putFloat(VOLATILE_DAMAGE, damage);

        return damage;
    }
    public static float getVolatileDamage(IEntityDataSaver entity){
        NbtCompound nbt = entity.getPersistentData();
        return nbt.getFloat(VOLATILE_DAMAGE);
    }
    public static float setVolatileDamage(IEntityDataSaver entity, float amount){
        NbtCompound nbt = entity.getPersistentData();
        nbt.putFloat(VOLATILE_DAMAGE, amount);
        return amount;
    }

    public static float addJoltDamage(IEntityDataSaver entity, float amount){
        NbtCompound nbt = entity.getPersistentData();
        float damage = nbt.getFloat(JOLT_DAMAGE);
        damage += amount;

        nbt.putFloat(JOLT_DAMAGE, damage);

        return damage;
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
