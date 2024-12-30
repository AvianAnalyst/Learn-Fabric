package com.avian.learnfabric.util

import com.avian.learnfabric.Learnfabric.MOD_ID
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier

object ModTags {
    object Blocks {
        val NEEDS_PINK_GARNET_TOOL = createTag("needs_pink_garnet_tool")
        val INCORRECT_FOR_PINK_GARNET_TOOL = createTag("incorrect_for_pink_garnet_tool")
        private fun createTag(name: String): TagKey<Block> {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, name))
        }
    }

    object Items {
        val HAMMERS: TagKey<Item> = createTag("hammers")
        val PINK_GARNET_TOOL_MATERIALS = createTag("pink_garnet_tool_materials")
        val TRANSFORMABLE_ITEMS = createTag("transformable_items")
        private fun createTag(name: String): TagKey<Item> {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, name))
        }
    }
}