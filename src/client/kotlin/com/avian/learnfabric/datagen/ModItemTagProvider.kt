package com.avian.learnfabric.datagen

import com.avian.learnfabric.item.ModItems
import com.avian.learnfabric.util.ModTags
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.item.Items
import net.minecraft.registry.RegistryWrapper
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
    }
}