package com.avian.learnfabric.datagen

import com.avian.learnfabric.item.ModItems
import com.avian.learnfabric.util.ModTags
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.item.Items
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.ItemTags
import java.util.concurrent.CompletableFuture

class ModItemTagProvider(
    output: FabricDataOutput?,
    registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>?
) : FabricTagProvider.ItemTagProvider(output, registriesFuture) {
    override fun configure(p0: RegistryWrapper.WrapperLookup?) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
            .add(ModItems.PINK_GARNET)
            .add(ModItems.RAW_PINK_GARNET)
            .add(Items.STICK)
            .add(Items.APPLE)
            .add(Items.COAL)
        getOrCreateTagBuilder(ModTags.Items.PINK_GARNET_TOOL_MATERIALS)
            .add(ModItems.PINK_GARNET)
        getOrCreateTagBuilder(ItemTags.SWORDS)
            .add(ModItems.PINK_GARNET_SWORD)
        getOrCreateTagBuilder(ItemTags.PICKAXES)
            .add(ModItems.PINK_GARNET_PICKAXE)
        getOrCreateTagBuilder(ItemTags.SHOVELS)
            .add(ModItems.PINK_GARNET_SHOVEL)
        getOrCreateTagBuilder(ItemTags.HOES)
            .add(ModItems.PINK_GARNET_HOE)
        getOrCreateTagBuilder(ItemTags.AXES)
            .add(ModItems.PINK_GARNET_AXE)
    }
}