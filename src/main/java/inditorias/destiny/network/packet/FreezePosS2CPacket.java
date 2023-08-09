package inditorias.destiny.network.packet;

import inditorias.destiny.lib.EffectData;
import inditorias.destiny.lib.IEntityDataSaver;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public class FreezePosS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender){
        ((IEntityDataSaver)client.player).getPersistentData().putFloat(EffectData.FREEZE_POS_X, buf.readFloat());
        ((IEntityDataSaver)client.player).getPersistentData().putFloat(EffectData.FREEZE_POS_Y, buf.readFloat());
        ((IEntityDataSaver)client.player).getPersistentData().putFloat(EffectData.FREEZE_POS_Z, buf.readFloat());
    }
}
