package com.elkite.warborn.domain.entities.drifter

import com.elkite.warborn.domain.entities.common.Category
import com.elkite.warborn.domain.entities.spells.PassiveSpell
import com.elkite.warborn.domain.entities.spells.SkillSpell
import kotlinx.serialization.Serializable

@Serializable
data class Drifter(
    val gameId: String,
    val name: String,
    val passive: PassiveSpell,
    val spell: SkillSpell,
    val links: List<Link>,
    val stats: DrifterStats,
    val baseStats: BaseStats,
    val statsMultiplier: DrifterMainStatsMultiplier,
    val bonus: SupportStationBonus,
    val category: Category,
)

@Serializable
data class BaseStats(
    val str: String,
    val dex: String,
    val int: String,
)

@Serializable
data class Link(
    val name: String,
    val description: String,
    val driftersNeeded: Int,
    val driftersId: List<String>,
)

@Serializable
data class SupportStationBonus(
    val supportBonus: String,
    val supportMalus: String,
    val supportBonusValue: String,
    val supportMalusValue: String,
)

@Serializable
data class DrifterStats(
    val maxHpBonus: String,
    val maxMpBonus: String,
    val attackSpeedBonus: String,
    val castingSpeedBonus: String,
    val skillCooldownRateBonus: String,
    val physicalDamageBonus: String,
    val magicDamageBonus: String,
    val healingBonus: String,
    val damageBonusPvE: String,
    val criticalRate: String,
    val tenacityPenetration: String,
    val armor: String,
    val magicResistance: String,
    val block: String,
    val controlResistance: String
)

@Serializable
data class DrifterMainStatsMultiplier(
    val strBonus: String,
    val dexBonus: String,
    val intBonus: String,
)