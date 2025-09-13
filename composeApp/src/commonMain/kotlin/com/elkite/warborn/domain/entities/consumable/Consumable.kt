package com.elkite.warborn.domain.entities.consumable

import com.elkite.warborn.domain.entities.common.Rarity
import com.elkite.warborn.domain.entities.gear.GearSlot
import kotlinx.serialization.Serializable

@Serializable
data class Consumable(
    val gameId: String,
    val name: String,
    val iconName: String,
    val description: String,
    val rarity: Rarity,
    val category: ConsumableCategory,
    val gearSlot: GearSlot = GearSlot.CONSUMABLE
)

enum class ConsumableCategory {
    FOOD,
    POTION,
    POISON,
    UTILITY
}