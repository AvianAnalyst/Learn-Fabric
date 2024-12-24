package com.avian.learnfabric

import com.avian.learnfabric.block.ModBlocks
import com.avian.learnfabric.component.ModDataComponentTypes
import com.avian.learnfabric.item.ModItemGroups
import com.avian.learnfabric.item.ModItems
import com.avian.learnfabric.util.ShiftChecker
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.registry.FuelRegistryEvents
import org.slf4j.LoggerFactory


object Learnfabric : ModInitializer {
    val MOD_ID = "learn-fabric"
    private val logger = LoggerFactory.getLogger("learn-fabric")
    var shiftChecker: ChecksShift = ShiftChecker()

    override fun onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        logger.info("Hello Fabric world!")
        ModItemGroups.initialize()
        ModItems.initialize()
        ModBlocks.initialize()
        ModDataComponentTypes.initialize()

        FuelRegistryEvents.BUILD.register { builder, context ->
            builder.add(ModItems.STARLIGHT_ASHES, 600)
        }
    }
}