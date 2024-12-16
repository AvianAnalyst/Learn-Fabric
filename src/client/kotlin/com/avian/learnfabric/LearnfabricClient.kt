package com.avian.learnfabric

import com.avian.learnfabric.block.ModBlocks
import com.avian.learnfabric.util.ClientShiftChecker
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer

object LearnfabricClient : ClientModInitializer {
    override fun onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        Learnfabric.shiftChecker = ClientShiftChecker()
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_TRAP_DOOR, RenderLayer.getCutout());
    }
}