package com.elkite.warborn.domain.entities.gear.drifter

import com.elkite.warborn.domain.entities.gear.Gear
import com.elkite.warborn.domain.entities.gear.GearStats
import com.elkite.warborn.domain.entities.gear.spell.Spell

data class Drifter(
    override val gameId: String,
    override val name: String,
    override val gearStats: GearStats,
    val spell: Spell,
    val passive: Spell,
    val strBonus: String,
    val dexBonus: String,
    val intBonus: String,

) : Gear(
    gameId, name, gearStats
)