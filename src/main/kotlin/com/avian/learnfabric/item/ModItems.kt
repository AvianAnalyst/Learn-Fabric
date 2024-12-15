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

    private fun register(
        name: String, factory: (Item.Settings) -> Item, settingsBuilder: Item.Settings.() -> Unit = {}
    ): Item {
        val settings = Item.Settings().apply(settingsBuilder)
        logger.info("Registered item $name")
        return Items.register(
            RegistryKey.of(
                RegistryKeys.ITEM, Identifier.of(MOD_ID, name)
            ), { factory(settings) }, settings
        )
    }

    fun initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register { entries ->
            entries.add(CHISEL)
        }
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register { entries ->
            entries.add(PINK_GARNET)
            entries.add(RAW_PINK_GARNET)
        }
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register { entries ->
            entries.add(CAULIFLOWER)
        }
    }

    val PINK_GARNET = register("pink_garnet", ::Item)
    val RAW_PINK_GARNET = register("raw_pink_garnet", ::Item)

    val CHISEL = register("chisel", ::ChiselItem) {
        maxDamage(32)
    }

    val CAULIFLOWER = register("cauliflower", ::Item) {
        food(ModFoodComponents.CAULIFLOWER, ModConsumableComponents.CAULIFLOWER)
    }
}