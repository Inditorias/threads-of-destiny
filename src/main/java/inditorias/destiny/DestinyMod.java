package inditorias.destiny;

import inditorias.destiny.config.DestinyConfig;
import inditorias.destiny.network.DestinyPackets;
import inditorias.destiny.registries.DestinyEffects;
import inditorias.destiny.registries.DestinyEnchantments;
import inditorias.destiny.registries.DestinyKeybinds;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DestinyMod implements ModInitializer {
	public static final String MOD_ID = "destiny";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		AutoConfig.register(DestinyConfig.class, GsonConfigSerializer::new);
		DestinyEffects.registerEffects();
		DestinyKeybinds.registerKeybinds();
		DestinyEnchantments.registerEnchantments();
		DestinyPackets.registerC2SPackets();
	}
}