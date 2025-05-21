package com.elkite.warborn.domain.entities.gear.drifter

import com.elkite.warborn.domain.entities.gear.Gear
import com.elkite.warborn.domain.entities.gear.GearStats
import com.elkite.warborn.domain.entities.gear.spell.Spell

data class Drifter(
    override val gameId: String,
    override val name: String,
    val spell: Spell,
    val passive: Spell,
    val strBonus: String,
    val dexBonus: String,
    val intBonus: String,
    val supportBonus: String,
    val supportMalus: String,
    val links: List<Link> = emptyList(),
    val gearStats: GearStats,
    ) : Gear(
    gameId, name,
)