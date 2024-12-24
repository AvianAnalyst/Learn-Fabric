package com.avian.learnfabric.datagen

import com.avian.learnfabric.block.ModBlocks
import com.avian.learnfabric.block.custom.MagicBlock
import com.avian.learnfabric.util.ModTags
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.BlockTags
import java.util.concurrent.CompletableFuture

class ModBlockTagProvider(
    output: FabricDataOutput?, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>?
) : FabricTagProvider.BlockTagProvider(output, registriesFuture) {
    override fun configure(p0: RegistryWrapper.WrapperLookup?) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(ModBlocks.PINK_GARNET_BLOCK)
            .add(ModBlocks.RAW_PINK_GARNET_BLOCK)
            .add(ModBlocks.PINK_GARNET_ORE)
            .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)
            .add(ModBlocks.MAGIC_BLOCK)
            .add(ModBlocks.PINK_GARNET_DOOR)
            .add(ModBlocks.PINK_GARNET_SLAB)
            .add(ModBlocks.PINK_GARNET_WALL)
            .add(ModBlocks.PINK_GARNET_STAIRS)
            .add(ModBlocks.PINK_GARNET_TRAP_DOOR)
            .add(ModBlocks.PINK_GARNET_PRESSURE_PLATE)
            .add(ModBlocks.PINK_GARNET_FENCE)
            .add(ModBlocks.PINK_GARNET_FENCE_GATE)
            .add(ModBlocks.PINK_GARNET_BUTTON)
            .add(ModBlocks.PINK_GARNET_LAMP)
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.PINK_GARNET_ORE)
            .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.MAGIC_BLOCK)
        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.PINK_GARNET_FENCE)
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.PINK_GARNET_FENCE)
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.PINK_GARNET_WALL)
        getOrCreateTagBuilder(BlockTags.DOORS).add(ModBlocks.PINK_GARNET_DOOR)
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_PINK_GARNET_TOOL)
            .add(ModBlocks.MAGIC_BLOCK)
            .addTag(BlockTags.NEEDS_IRON_TOOL)
    }
}