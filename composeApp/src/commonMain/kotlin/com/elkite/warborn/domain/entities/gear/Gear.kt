package com.elkite.warborn.domain.entities.gear

import kotlinx.serialization.Serializable

@Serializable
open class Gear(
    open val gameId: String,
    open val name: String,
    open val gearStats: GearStats,
)