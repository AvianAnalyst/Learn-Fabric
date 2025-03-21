package com.avian.learnfabric.item

import com.avian.learnfabric.Learnfabric
import com.avian.learnfabric.util.ModTags
import net.minecraft.item.equipment.ArmorMaterial
import net.minecraft.item.equipment.EquipmentAsset
import net.minecraft.item.equipment.EquipmentType
import net.minecraft.registry.RegistryKey
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Identifier
import net.minecraft.util.Util
import java.util.*


object ModArmorMaterials {
    val PINK_GARNET_ARMOR_MATERIAL_KEY = RegistryKey.of<EquipmentAsset>(
        RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")),
        Identifier.of(Learnfabric.MOD_ID, "pink_garnet")
    )

    val PINK_GARNET_ARMOR_MATERIAL: ArmorMaterial = ArmorMaterial(
        500, Util.make(
            EnumMap<EquipmentType, Int>(
                EquipmentType::class.java
            )
        ) { map: EnumMap<EquipmentType, Int> ->
            map[EquipmentType.BOOTS] = 2
            map[EquipmentType.LEGGINGS] = 4
            map[EquipmentType.CHESTPLATE] = 6
            map[EquipmentType.HELMET] = 2
            map[EquipmentType.BODY] = 4
        }, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0f, 0f, ModTags.Items.PINK_GARNET_REPAIR,
        PINK_GARNET_ARMOR_MATERIAL_KEY
    )
}