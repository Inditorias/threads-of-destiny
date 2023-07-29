package inditorias.destiny;

import inditorias.destiny.registries.DestinyEffects;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DestinyMod implements ModInitializer {
	public static final String MOD_ID = "destiny";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		DestinyEffects.registerEffects();
	}
}