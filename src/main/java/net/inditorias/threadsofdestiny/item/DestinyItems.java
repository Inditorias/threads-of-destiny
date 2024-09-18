package net.inditorias.threadsofdestiny.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.inditorias.threadsofdestiny.ThreadsOfDestiny;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DestinyItems {
    public static final Item GLIMMER_NUGGET = registerItem("glimmer_nugget", new Item(new Item.Settings()));
    public static final Item GLIMMER_INGOT = registerItem("glimmer_ingot", new Item(new Item.Settings()));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(ThreadsOfDestiny.MOD_ID, name), item);
    }

    public static void registerDestinyItems(){
        ThreadsOfDestiny.LOGGER.info("Registering Items for " + ThreadsOfDestiny.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(GLIMMER_NUGGET);
            entries.add(GLIMMER_INGOT);
        });
    }
}
