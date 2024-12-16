package com.avian.learnfabric

import com.avian.learnfabric.datagen.*
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

object LearnfabricDataGenerator : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        val pack = fabricDataGenerator.createPack()
        pack.addProvider(::ModBlockTagProvider)
        pack.addProvider(::ModItemTagProvider)
        pack.addProvider(::ModLootTableProvider)
        pack.addProvider(::ModModelProvider)
        pack.addProvider(::ModRecipeProvider)
    }
}