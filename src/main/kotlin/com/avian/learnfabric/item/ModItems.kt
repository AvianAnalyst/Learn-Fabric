package com.avian.learnfabric.item

import com.avian.learnfabric.Learnfabric.MOD_ID
import com.avian.learnfabric.item.custom.ChiselItem
import com.avian.learnfabric.item.custom.HammerItem
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.*
import net.minecraft.item.equipment.EquipmentType
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
            entries.add(FOOTBALL)
        }
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register { entries ->
            entries.add(PINK_GARNET)
            entries.add(RAW_PINK_GARNET)
            entries.add(STARLIGHT_ASHES)
        }
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register { entries ->
            entries.add(CAULIFLOWER)
        }
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register { entries ->
            entries.add(PINK_GARNET_HELMET)
            entries.add(PINK_GARNET_CHESTPLATE)
            entries.add(PINK_GARNET_LEGGINGS)
            entries.add(PINK_GARNET_BOOTS)
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

    val STARLIGHT_ASHES = register("starlight_ashes", ::Item)
    val PINK_GARNET_SWORD = register("pink_garnet_sword", ::PinkGarnetSword)
    val PINK_GARNET_PICKAXE = register("pink_garnet_pickaxe", ::PinkGarnetPickaxe)
    val PINK_GARNET_SHOVEL = register("pink_garnet_shovel", ::PinkGarnetShovel)
    val PINK_GARNET_AXE = register("pink_garnet_axe", ::PinkGarnetAxe)
    val PINK_GARNET_HOE = register("pink_garnet_hoe", ::PinkGarnetHoe)
    val PINK_GARNET_HAMMER = register("pink_garnet_hammer", ::PinkGarnetHammer)
    val FOOTBALL = register("footie", ::Item)
    val PINK_GARNET_HELMET = register("pink_garnet_helmet", ::PinkGarnetHelm) {
        maxDamage(EquipmentType.HELMET.getMaxDamage(15))
    }
    val PINK_GARNET_CHESTPLATE = register("pink_garnet_chestplate", ::PinkGarnetChest) {
        maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(15))
    }
    val PINK_GARNET_LEGGINGS = register("pink_garnet_leggings", ::PinkGarnetLegs) {
        maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(15))
    }
    val PINK_GARNET_BOOTS = register("pink_garnet_boots", ::PinkGarnetBoots) {
        maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(15))
    }
}

class PinkGarnetHelm(settings: Settings) :
    ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.HELMET, settings)

class PinkGarnetChest(settings: Settings) :
    ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.CHESTPLATE, settings)

class PinkGarnetLegs(settings: Settings) :
    ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.LEGGINGS, settings)

class PinkGarnetBoots(settings: Settings) :
    ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.BOOTS, settings)

class PinkGarnetSword(settings: Settings) : SwordItem(ModToolMaterials.PINK_GARNET, 3f, -2.4f, settings)
class PinkGarnetPickaxe(settings: Settings) : PickaxeItem(ModToolMaterials.PINK_GARNET, 1f, -2.8f, settings)
class PinkGarnetShovel(settings: Settings) : ShovelItem(ModToolMaterials.PINK_GARNET, 1.5f, -3f, settings)
class PinkGarnetAxe(settings: Settings) : AxeItem(ModToolMaterials.PINK_GARNET, 6f, -3.2f, settings)
class PinkGarnetHoe(settings: Settings) : HoeItem(ModToolMaterials.PINK_GARNET, 0f, -3f, settings)
class PinkGarnetHammer(settings: Settings) : HammerItem(ModToolMaterials.PINK_GARNET, 7f, -3.4f, settings)
