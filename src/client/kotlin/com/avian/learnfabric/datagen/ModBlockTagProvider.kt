package com.avian.learnfabric.datagen

import com.avian.learnfabric.block.ModBlocks
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
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.PINK_GARNET_ORE)
            .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)
    }
}