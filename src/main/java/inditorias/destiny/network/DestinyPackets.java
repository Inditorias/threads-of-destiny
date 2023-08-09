package inditorias.destiny.network;

import inditorias.destiny.DestinyMod;
import inditorias.destiny.network.packet.FreezePosS2CPacket;
import inditorias.destiny.network.packet.SuspendPosS2CPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;

public class DestinyPackets {
    public static final Identifier SUSPEND_SYNC_ID = new Identifier(DestinyMod.MOD_ID, "suspend_sync");
    public static final Identifier FREEZE_SYNC_ID = new Identifier(DestinyMod.MOD_ID, "freeze_sync");
    public static void registerC2SPackets(){

    }
    public static void registerS2CPackets(){
        ClientPlayNetworking.registerGlobalReceiver(SUSPEND_SYNC_ID, SuspendPosS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(FREEZE_SYNC_ID, FreezePosS2CPacket::receive);
    }
}
