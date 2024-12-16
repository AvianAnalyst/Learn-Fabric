package com.avian.learnfabric.item

import com.avian.learnfabric.Learnfabric
import com.avian.learnfabric.block.ModBlocks
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

    val CUSTOM_FUELS: ItemGroup = Registry.register(
        Registries.ITEM_GROUP,
        Identifier.of(Learnfabric.MOD_ID, "custom_fuels"),
        FabricItemGroup.builder()
            .icon { ItemStack(ModItems.STARLIGHT_ASHES) }
            .displayName(Text.translatable("itemgroup.learn-fabric.custom_fuels"))
            .entries { displayContext, entries ->
                entries.add(ModItems.STARLIGHT_ASHES)
            }
            .build()
    )

    val CUSTOM_FOODS: ItemGroup = Registry.register(
        Registries.ITEM_GROUP,
        Identifier.of(Learnfabric.MOD_ID, "custom_foods"),
        FabricItemGroup.builder()
            .icon { ItemStack(ModItems.CAULIFLOWER) }
            .displayName(Text.translatable("itemgroup.learn-fabric.custom_foods"))
            .entries { displayContext, entries ->
                entries.add(ModItems.CAULIFLOWER)
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
                entries.add(ModBlocks.MAGIC_BLOCK)

                entries.add(ModBlocks.PINK_GARNET_DOOR)
                entries.add(ModBlocks.PINK_GARNET_SLAB)
                entries.add(ModBlocks.PINK_GARNET_WALL)
                entries.add(ModBlocks.PINK_GARNET_STAIRS)
                entries.add(ModBlocks.PINK_GARNET_TRAP_DOOR)
                entries.add(ModBlocks.PINK_GARNET_PRESSURE_PLATE)
                entries.add(ModBlocks.PINK_GARNET_FENCE)
                entries.add(ModBlocks.PINK_GARNET_FENCE_GATE)
                entries.add(ModBlocks.PINK_GARNET_BUTTON)
            }
            .build()
    )

    fun initialize() {}
}