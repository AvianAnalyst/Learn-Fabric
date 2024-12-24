package com.avian.learnfabric.component

import com.avian.learnfabric.Learnfabric.MOD_ID
import net.minecraft.component.ComponentType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import org.slf4j.LoggerFactory
import java.util.function.UnaryOperator

object ModDataComponentTypes {

    val COORDINATES: ComponentType<BlockPos> = register("coordinates") { builder -> builder.codec(BlockPos.CODEC) }

    private fun <T> register(name: String, builderOperator: UnaryOperator<ComponentType.Builder<T>>): ComponentType<T> {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(MOD_ID, name), builderOperator.apply(ComponentType.builder()).build())
    }

    private val logger = LoggerFactory.getLogger("learn-fabric components")
    fun initialize() {
        logger.info("Registering data component types for $MOD_ID")
    }

}