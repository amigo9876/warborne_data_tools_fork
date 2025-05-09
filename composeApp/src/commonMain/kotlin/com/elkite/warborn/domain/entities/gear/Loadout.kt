package com.elkite.warborn.domain.entities.gear

import com.elkite.warborn.domain.entities.spell.Spell

data class Loadout(
    val head: Spell? = null,
    val chest: Spell? = null,
    val boots: Spell? = null,
    val weapon: Spell? = null,
    val passive: Spell? = null,
    val commonSkill: Spell? = null,
    val basicAttack: Spell? = null,
)