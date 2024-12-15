package com.avian.learnfabric.util

import com.avian.learnfabric.ChecksShift
import net.minecraft.client.gui.screen.Screen

class ClientShiftChecker : ChecksShift {
    override fun checkShift(): Boolean {
        return Screen.hasShiftDown()
    }
}