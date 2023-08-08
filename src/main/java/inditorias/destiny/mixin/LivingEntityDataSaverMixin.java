package inditorias.destiny.mixin;


import inditorias.destiny.DestinyMod;
import inditorias.destiny.lib.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class LivingEntityDataSaverMixin implements IEntityDataSaver{
    private NbtCompound persistentData;

    @Override
    public NbtCompound getPersistentData() {
        if(this.persistentData == null){
            this.persistentData = new NbtCompound();
        }
        return persistentData;
    }

    @Inject(method="writeNbt", at = @At("HEAD"))
    protected void injectWriteMethod(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cir){
        if(persistentData != null){
            nbt.put(DestinyMod.MOD_ID+".data", persistentData);
        }
    }

    @Inject(method = "readNbt", at=@At("HEAD"))
    protected void injectReadMethod(NbtCompound nbt, CallbackInfo ci){
        if(nbt.contains(DestinyMod.MOD_ID+".data", 10)){
            persistentData = nbt.getCompound(DestinyMod.MOD_ID+".data");
        }
    }
}
