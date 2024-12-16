package com.avian.learnfabric.block

import com.avian.learnfabric.Learnfabric.MOD_ID
import com.avian.learnfabric.block.custom.MagicBlock
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.*
import net.minecraft.item.ItemGroups
import net.minecraft.item.Items
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.math.intprovider.UniformIntProvider
import org.slf4j.LoggerFactory

object ModBlocks {
    val logger = LoggerFactory.getLogger("learn-fabric")
    private fun registerBlock(
        name: String,
        factory: (AbstractBlock.Settings) -> Block,
        settingsBuilder: AbstractBlock.Settings.() -> Unit = {}
    ): Block {
        val settings = AbstractBlock.Settings.create().apply(settingsBuilder)
        val block = Blocks.register(
            RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, name)), { factory(settings) }, settings
        )
        Items.register(block)
        logger.info("registering $name")
        return block
    }

    fun initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { entries ->
            entries.add(PINK_GARNET_BLOCK)
            entries.add(RAW_PINK_GARNET_BLOCK)
            entries.add(MAGIC_BLOCK)
        }
    }

    val PINK_GARNET_BLOCK = registerBlock("pink_garnet_block", ::Block) {
        strength(4f)
        sounds(BlockSoundGroup.AMETHYST_BLOCK)
        requiresTool()
    }

    val RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block", ::Block) {
        strength(3F)
        requiresTool()
    }

    val PINK_GARNET_ORE = registerBlock("pink_garnet_ore", ::PinkGarnetOre) {
        strength(3.0F)
        requiresTool()
    }
    val PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore", ::PinkGarnetDeepslateOre) {
        strength(4F)
        requiresTool()
        sounds(BlockSoundGroup.DEEPSLATE)
    }
    val MAGIC_BLOCK = registerBlock("magic_block", ::MagicBlock) {
        strength(1f)
        requiresTool()
    }
    val PINK_GARNET_STAIRS = registerBlock("pink_garnet_stairs", ::PinkGarnetStairs) {
        strength(2f)
        requiresTool()
    }
    val PINK_GARNET_SLAB = registerBlock("pink_garnet_slab", ::SlabBlock) {
        strength(2f)
        requiresTool()
    }

    val PINK_GARNET_BUTTON = registerBlock("pink_garnet_button", ::PinkGarnetButton) {
        strength(2f)
        requiresTool()
        noCollision()
    }
    val PINK_GARNET_PRESSURE_PLATE = registerBlock("pink_garnet_pressure_plate", ::PinkGarnetPressurePlate) {
        strength(2f)
        requiresTool()
    }

    val PINK_GARNET_FENCE = registerBlock("pink_garnet_fence", ::FenceBlock) {
        strength(2f)
        requiresTool()
    }
    val PINK_GARNET_FENCE_GATE = registerBlock("pink_garnet_fence_gate", ::PinkGarnetFenceGate) {
        strength(2f)
        requiresTool()
    }
    val PINK_GARNET_WALL = registerBlock("pink_garnet_wall", ::WallBlock) {
        strength(2f)
        requiresTool()
    }


    val PINK_GARNET_DOOR = registerBlock("pink_garnet_door", ::PinkGarnetDoor) {
        strength(2f)
        requiresTool()
        nonOpaque()
    }
    val PINK_GARNET_TRAP_DOOR = registerBlock("pink_garnet_trap_door", ::PinkGarnetTrapDoor) {
        strength(2f)
        requiresTool()
        nonOpaque()
    }
}

class PinkGarnetOre(settings: Settings) : ExperienceDroppingBlock(UniformIntProvider.create(2, 5), settings)
class PinkGarnetDeepslateOre(settings: Settings) : ExperienceDroppingBlock(UniformIntProvider.create(3, 6), settings)
class PinkGarnetStairs(settings: Settings) : StairsBlock(ModBlocks.PINK_GARNET_BLOCK.defaultState, settings)
class PinkGarnetButton(settings: Settings) : ButtonBlock(BlockSetType.IRON, 2, settings)
class PinkGarnetPressurePlate(settings: Settings) : PressurePlateBlock(BlockSetType.IRON, settings)
class PinkGarnetFenceGate(settings: Settings) : FenceGateBlock(WoodType.ACACIA, settings)
class PinkGarnetDoor(settings: Settings) : DoorBlock(BlockSetType.IRON, settings)
class PinkGarnetTrapDoor(settings: Settings) : TrapdoorBlock(BlockSetType.IRON, settings)

