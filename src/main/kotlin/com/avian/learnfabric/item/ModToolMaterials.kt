package com.avian.learnfabric.item

import com.avian.learnfabric.util.ModTags
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.ItemTags
import net.minecraft.registry.tag.TagKey

data object ModToolMaterials {
    val PINK_GARNET = ToolMaterial(ModTags.Blocks.INCORRECT_FOR_PINK_GARNET_TOOL, 1200, 5f, 4f, 22, ModTags.Items.PINK_GARNET_TOOL_MATERIALS)
}