package com.avian.learnfabric

import com.avian.learnfabric.Learnfabric.MOD_ID
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.AbstractBlock.Settings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.ExperienceDroppingBlock
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
        }
    }

    val PINK_GARNET_BLOCK = registerBlock("pink_garnet_block", ::Block) {
        strength(1f)
        sounds(BlockSoundGroup.AMETHYST_BLOCK)
    }

    val RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block", ::Block) {
        strength(5.0F, 6.0F)
        requiresTool()
    }

    val PINK_GARNET_ORE = registerBlock("pink_garnet_ore", ::PinkGarnetOre) {
        strength(3.0F)
        requiresTool()
    }
    val PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore", ::PinkGarnetDeepslateOre) {
        strength(5.0F)
        requiresTool()
        sounds(BlockSoundGroup.DEEPSLATE)
    }
}

class PinkGarnetOre (settings: Settings): ExperienceDroppingBlock(UniformIntProvider.create(2, 3), settings)
class PinkGarnetDeepslateOre (settings: Settings): ExperienceDroppingBlock(UniformIntProvider.create(3, 5), settings)
