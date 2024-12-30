package com.avian.learnfabric.item.custom

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.StackReference
import net.minecraft.item.ItemStack
import net.minecraft.item.MiningToolItem
import net.minecraft.item.ToolMaterial
import net.minecraft.registry.tag.BlockTags
import net.minecraft.screen.slot.Slot
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.ClickType
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.hit.HitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction


open class HammerItem(
    material: ToolMaterial,
    attackDamage: Float,
    attackSpeed: Float,
    settings: Settings
) : MiningToolItem(material, BlockTags.PICKAXE_MINEABLE, attackDamage, attackSpeed, settings) {

    override fun onClicked(
        stack: ItemStack?,
        otherStack: ItemStack?,
        slot: Slot?,
        clickType: ClickType?,
        player: PlayerEntity?,
        cursorStackReference: StackReference?
    ): Boolean {
        return super.onClicked(stack, otherStack, slot, clickType, player, cursorStackReference)
    }

    companion object {
        fun getBlocksToBeDestroyed(range: Int, initalBlockPos: BlockPos, player: ServerPlayerEntity): List<BlockPos> {
            val positions: MutableList<BlockPos> = ArrayList()
            val hit = player.raycast(20.0, 0f, false)
            if (hit.type == HitResult.Type.BLOCK) {
                val blockHit = hit as BlockHitResult

                if (blockHit.side == Direction.DOWN || blockHit.side == Direction.UP) {
                    for (x in -range..range) {
                        for (y in -range..range) {
                            positions.add(BlockPos(initalBlockPos.x + x, initalBlockPos.y, initalBlockPos.z + y))
                        }
                    }
                }

                if (blockHit.side == Direction.NORTH || blockHit.side == Direction.SOUTH) {
                    for (x in -range..range) {
                        for (y in -range..range) {
                            positions.add(BlockPos(initalBlockPos.x + x, initalBlockPos.y + y, initalBlockPos.z))
                        }
                    }
                }

                if (blockHit.side == Direction.EAST || blockHit.side == Direction.WEST) {
                    for (x in -range..range) {
                        for (y in -range..range) {
                            positions.add(BlockPos(initalBlockPos.x, initalBlockPos.y + y, initalBlockPos.z + x))
                        }
                    }
                }
            }

            return positions
        }
    }

}