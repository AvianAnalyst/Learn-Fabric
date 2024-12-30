package com.avian.learnfabric.util

import com.avian.learnfabric.item.custom.HammerItem
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class HammerUsageEvent : PlayerBlockBreakEvents.Before {
    val HARVESTED_BLOCKS = HashSet<BlockPos>();

    override fun beforeBlockBreak(
        world: World,
        player: PlayerEntity,
        pos: BlockPos,
        state: BlockState,
        blockEntity: BlockEntity?
    ): Boolean {
        val mainHandItem = player.mainHandStack.item;

        if (mainHandItem is HammerItem && player is ServerPlayerEntity) {
            if (HARVESTED_BLOCKS.contains(pos)) {
                return true;
            }

            for (position in HammerItem.getBlocksToBeDestroyed(1, pos, player)) {
                if (pos == position || !mainHandItem.isCorrectForDrops(
                        player.mainHandStack,
                        world.getBlockState(position)
                    )
                ) {
                    continue;
                }

                HARVESTED_BLOCKS.add(position);
                player.interactionManager.tryBreakBlock(position);
                HARVESTED_BLOCKS.remove(position);
            }
        }
        return true;
    }
}
