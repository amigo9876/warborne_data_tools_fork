package com.elkite.warborn.domain.entities.old.drifter

import com.elkite.warborn.domain.entities.old.Gear
import com.elkite.warborn.domain.entities.old.GearStats
import com.elkite.warborn.domain.entities.old.spell.Spell
import com.elkite.warborn.presentation.widgets.patch_balance.Balance

data class Drifter(
    override val gameId: String,
    override val name: String,
    override val balance: Balance,
    val spell: Spell,
    val passive: Spell,
    val strBonus: String,
    val dexBonus: String,
    val intBonus: String,
    val supportBonus: String,
    val supportMalus: String,
    val supportBonusValue: String,
    val supportMalusValue: String,
    val links: List<Link> = emptyList(),
    val gearStats: GearStats,
    val drifterStats: DrifterStats
    ) : Gear(
    gameId, name, balance
)