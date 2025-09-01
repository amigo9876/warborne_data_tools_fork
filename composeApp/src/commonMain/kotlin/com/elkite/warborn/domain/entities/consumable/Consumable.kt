package com.elkite.warborn.domain.entities.consumable

import com.elkite.warborn.domain.entities.gear.GearSlot
import kotlinx.serialization.Serializable

@Serializable
data class Consumable(
    val gearSlot: GearSlot = GearSlot.CONSUMABLE
)