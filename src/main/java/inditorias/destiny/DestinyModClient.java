package inditorias.destiny;

import inditorias.destiny.network.DestinyPackets;
import net.fabricmc.api.ClientModInitializer;

public class DestinyModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        DestinyPackets.registerS2CPackets();
    }
}
