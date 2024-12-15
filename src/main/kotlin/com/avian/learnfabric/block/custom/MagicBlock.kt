package com.avian.learnfabric.block.custom

import com.avian.learnfabric.item.ModItems
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.entity.Entity
import net.minecraft.entity.ItemEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class MagicBlock(settings: Settings) : Block(settings) {
    override fun onUse(
        state: BlockState?,
        world: World?,
        pos: BlockPos?,
        player: PlayerEntity?,
        hit: BlockHitResult?
    ): ActionResult {
        world?.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1.0f, 1.0f)
        return ActionResult.SUCCESS
    }

    override fun onSteppedOn(world: World?, pos: BlockPos?, state: BlockState?, item: Entity?) {
        if (item is ItemEntity) {
            if (item.stack.item == ModItems.RAW_PINK_GARNET) {
                item.stack = ItemStack(Items.DIAMOND, item.stack.count)
            }
        }
        super.onSteppedOn(world, pos, state, item)
    }

    override fun appendTooltip(
        stack: ItemStack?,
        context: Item.TooltipContext?,
        tooltip: MutableList<Text>?,
        options: TooltipType?
    ) {
        tooltip?.add(Text.translatable("itemgroup.learn-fabric.magic_block.tooltip"))
        super.appendTooltip(stack, context, tooltip, options)
    }
}