package com.avian.learnfabric.block.custom

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.util.ActionResult
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import javax.accessibility.AccessibleAction.CLICK


class PinkGarnetLampBlock(settings: Settings?) : Block(settings) {


    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hit: BlockHitResult
    ): ActionResult {
        if (world.isClient.not()) {
            world.setBlockState(pos, state.cycle(CLICKED))
        }
        return ActionResult.SUCCESS
    }
    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(CLICKED)
    }

    companion object {
        val CLICKED: BooleanProperty = BooleanProperty.of("clicked")
    }
    init {
        defaultState = defaultState.with(CLICKED, false)
    }
}

