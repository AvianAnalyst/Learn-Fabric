package com.avian.learnfabric.item

import com.avian.learnfabric.Learnfabric
import com.avian.learnfabric.ModBlocks
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

object ModItemGroups {
    val logger = LoggerFactory.getLogger("learn-fabric")


    val PINK_GARNET_ITEMS_GROUP: ItemGroup = Registry.register(
        Registries.ITEM_GROUP,
        Identifier.of(Learnfabric.MOD_ID, "pink_garnet_items"),
        FabricItemGroup.builder()
            .icon { ItemStack(ModItems.PINK_GARNET) }
            .displayName(Text.translatable("itemgroup.learn-fabric.pink_garnet_items"))
            .entries { displayContext, entries ->
                entries.add(ModItems.PINK_GARNET)
                entries.add(ModItems.RAW_PINK_GARNET)
            }
            .build()
    )

    val CUSTOM_TOOLS: ItemGroup = Registry.register(
        Registries.ITEM_GROUP,
        Identifier.of(Learnfabric.MOD_ID, "custom_tools"),
        FabricItemGroup.builder()
            .icon { ItemStack(ModItems.CHISEL) }
            .displayName(Text.translatable("itemgroup.learn-fabric.custom_tools"))
            .entries { displayContext, entries ->
                entries.add(ModItems.CHISEL)
            }
            .build()
    )

    val PINK_GARNET_BLOCKS_GROUP: ItemGroup = Registry.register(
        Registries.ITEM_GROUP,
        Identifier.of(Learnfabric.MOD_ID, "pink_garnet_blocks"),
        FabricItemGroup.builder()
            .icon { ItemStack(ModBlocks.PINK_GARNET_BLOCK) }
            .displayName(Text.translatable("itemgroup.learn-fabric.pink_garnet_blocks"))
            .entries { displayContext, entries ->
                entries.add(ModBlocks.PINK_GARNET_BLOCK)
                entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK)

                entries.add(ModBlocks.PINK_GARNET_ORE)
                entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)
            }
            .build()
    )

    fun initialize() {}
}