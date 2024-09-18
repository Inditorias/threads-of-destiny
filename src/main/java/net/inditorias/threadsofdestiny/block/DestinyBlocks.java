package net.inditorias.threadsofdestiny.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.inditorias.threadsofdestiny.ThreadsOfDestiny;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class DestinyBlocks {

    public static final Block GLIMMER_BLOCK = registerBlock("glimmer_block",
            new ExperienceDroppingBlock(UniformIntProvider.create(12,21),AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.5F,0.4F).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name,block);
        return Registry.register(
                Registries.BLOCK,
                Identifier.of(ThreadsOfDestiny.MOD_ID, name),
                block
        );
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(ThreadsOfDestiny.MOD_ID, name),new BlockItem(block, new Item.Settings()));
    }

    public static void registerDestinyBlocks(){
        ThreadsOfDestiny.LOGGER.info("Registering Blocks for " + ThreadsOfDestiny.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(GLIMMER_BLOCK);
        });
    }
}
