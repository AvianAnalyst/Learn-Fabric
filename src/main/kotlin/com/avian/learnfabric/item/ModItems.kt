package com.avian.learnfabric.item

import com.avian.learnfabric.Learnfabric.MOD_ID
import com.avian.learnfabric.item.custom.ChiselItem
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.item.Items
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object ModItems {
    private val logger: Logger = LoggerFactory.getLogger("learn-fabric")
    private fun register(id: String): Item {
        val itemID = Identifier.of(Learnfabric.MOD_ID, id)
        val key = RegistryKey.of(RegistryKeys.ITEM, itemID)
        val settings = Item.Settings().registryKey(key)
        val registeredItem = Registry.register(Registries.ITEM, key, Item(settings))
        logger.info("Registered item $itemID")

        return registeredItem

    }

    fun initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register { entries ->
            entries.add(PINK_GARNET)
            entries.add(RAW_PINK_GARNET)
        }
    }
    val PINK_GARNET = register("pink_garnet")


    val RAW_PINK_GARNET = register("raw_pink_garnet")
}