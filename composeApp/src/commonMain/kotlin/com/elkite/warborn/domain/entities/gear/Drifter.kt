package com.elkite.warborn.domain.entities.gear

import com.elkite.warborn.domain.entities.spell.Spell

data class Drifter(
    val gameId: String,
    val name: String,
    val spell: Spell,
    val passive: Spell
)