package net.inditorias.threadsofdestiny;

import net.fabricmc.api.ClientModInitializer;
import net.inditorias.threadsofdestiny.network.DestinyPackets;

public class ThreadsOfDestinyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        DestinyPackets.registerS2CPackets();
    }
}
