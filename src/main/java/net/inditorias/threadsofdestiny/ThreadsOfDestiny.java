package net.inditorias.threadsofdestiny;

import net.fabricmc.api.ModInitializer;

import net.inditorias.threadsofdestiny.block.DestinyBlocks;
import net.inditorias.threadsofdestiny.item.DestinyItemGroups;
import net.inditorias.threadsofdestiny.item.DestinyItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadsOfDestiny implements ModInitializer {
	public static final String MOD_ID = "destiny";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		DestinyItemGroups.registerDestinyItemGroups();

		DestinyItems.registerDestinyItems();
		DestinyBlocks.registerDestinyBlocks();
	}
}