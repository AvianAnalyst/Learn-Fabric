package com.avian.learnfabric.item.custom

import com.avian.learnfabric.Learnfabric
import com.avian.learnfabric.block.ModBlocks
import com.avian.learnfabric.component.ModDataComponentTypes
import net.minecraft.block.Blocks
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsageContext
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.util.ActionResult


class ChiselItem(settings: Settings) : Item(settings) {
    val CHISEL_MAP = mapOf(
        Blocks.STONE to Blocks.STONE_BRICKS,
        Blocks.END_STONE to Blocks.END_STONE_BRICKS,
        Blocks.OAK_LOG to ModBlocks.PINK_GARNET_BLOCK,
        Blocks.GOLD_BLOCK to Blocks.NETHERITE_BLOCK
    )

    override fun useOnBlock(context: ItemUsageContext): ActionResult {
        val world = context.world
        val clickedBlock = world.getBlockState(context.blockPos).block

        if (CHISEL_MAP.containsKey(clickedBlock)) {
            if (world.isClient().not()) {
                world.setBlockState(context.blockPos, CHISEL_MAP[clickedBlock]?.defaultState)
                context.stack.damage(
                    1,
                    world as ServerWorld,
                    context.player as ServerPlayerEntity
                ) { item ->
                    (context.player as ServerPlayerEntity).sendEquipmentBreakStatus(
                        item,
                        EquipmentSlot.MAINHAND
                    )
                }
                world.playSound(null, context.blockPos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS)
                context.stack.set(ModDataComponentTypes.COORDINATES, context.blockPos)
            }
        }

        return super.useOnBlock(context)
    }

    override fun appendTooltip(
        stack: ItemStack,
        context: TooltipContext,
        tooltip: MutableList<Text>,
        type: TooltipType
    ) {
        if (Learnfabric.shiftChecker.checkShift()) {
            tooltip.add(Text.translatable("tooltip.learn-fabric.chisel.shift"))
        } else {
            tooltip.add(Text.translatable("tooltip.learn-fabric.chisel"))
        }
        if (stack.get(ModDataComponentTypes.COORDINATES) != null) {
            tooltip.add(Text.literal("Last block changed at ${stack.get(ModDataComponentTypes.COORDINATES)}"))
        }
        super.appendTooltip(stack, context, tooltip, type)
    }
}