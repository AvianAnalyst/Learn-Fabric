package com.avian.learnfabric

import com.avian.learnfabric.item.ModItemGroups
import com.avian.learnfabric.item.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory


object Learnfabric : ModInitializer {
	val MOD_ID = "learn-fabric"
    private val logger = LoggerFactory.getLogger("learn-fabric")

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("Hello Fabric world!")
		ModItemGroups.initialize()
		ModItems.initialize()
		ModBlocks.initialize()
	}
}