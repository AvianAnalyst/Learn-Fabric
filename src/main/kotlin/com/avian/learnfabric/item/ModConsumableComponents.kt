package com.avian.learnfabric.item

import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.consume.ApplyEffectsConsumeEffect

object ModConsumableComponents {
    val CAULIFLOWER = net.minecraft.component.type.ConsumableComponents.food()
        .consumeEffect(ApplyEffectsConsumeEffect(StatusEffectInstance(StatusEffects.HEALTH_BOOST, 600, 0), .15f))
        .build()
}
