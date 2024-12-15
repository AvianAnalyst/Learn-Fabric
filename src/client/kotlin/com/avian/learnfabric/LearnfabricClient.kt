package com.avian.learnfabric

import com.avian.learnfabric.util.ClientShiftChecker
import net.fabricmc.api.ClientModInitializer

object LearnfabricClient : ClientModInitializer {
    override fun onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        Learnfabric.shiftChecker = ClientShiftChecker()
    }
}