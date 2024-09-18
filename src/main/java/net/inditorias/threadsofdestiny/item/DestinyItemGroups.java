package net.inditorias.threadsofdestiny.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.inditorias.threadsofdestiny.ThreadsOfDestiny;
import net.inditorias.threadsofdestiny.block.DestinyBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DestinyItemGroups {
    public static final ItemGroup DESTINY_ITEM_GROUP = Registry.register(
              Registries.ITEM_GROUP
            , Identifier.of(ThreadsOfDestiny.MOD_ID, "destiny_items")
            , FabricItemGroup.builder().icon(() -> new ItemStack(DestinyItems.GLIMMER_NUGGET))
                    .displayName(Text.translatable("itemgroup.destiny.primaryitemgroup"))
                    .entries((displayContext, entries) -> {
                        entries.add(DestinyItems.GLIMMER_NUGGET);
                        entries.add(DestinyItems.GLIMMER_INGOT);
                        entries.add(DestinyBlocks.GLIMMER_BLOCK);
                    }).build());

    public static void registerDestinyItemGroups(){
        ThreadsOfDestiny.LOGGER.info("Registering Item Groups for " + ThreadsOfDestiny.MOD_ID);
    }
}
