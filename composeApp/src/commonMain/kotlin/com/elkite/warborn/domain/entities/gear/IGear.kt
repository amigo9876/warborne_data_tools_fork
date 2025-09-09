package com.elkite.warborn.domain.entities.gear

import com.elkite.warborn.domain.entities.common.Category
import com.elkite.warborn.domain.entities.common.Rarity
import com.elkite.warborn.domain.entities.spells.ISpell
import com.elkite.warborn.domain.entities.spells.SpellType
import com.elkite.warborn.domain.entities.spells.TierUnlock
import kotlinx.serialization.Serializable

interface IGear : ISpell {
    override val spellId: String
    override val spellName: String
    override val description: String
    override val type: SpellType
    override val manaCost: String
    override val cooldown: String
    override val castingRange: String
    override val tierUnlock: TierUnlock

    val gearName: String
    val gearStats: GearStats
    val gearSlot: GearSlot
    val rarity: Rarity
    val category: Category
}

@Serializable
data class GearStats(
    val bonusDamage: String? = null,
    val hp: String? = null,
    val tenacity: String? = null,
    val mpRecovery: String? = null,
    val ms: String? = null,
    val attackSpeed: String? = null,
    val armor: String? = null,
    val magicResist: String? = null,
    val attackPower: String? = null,
)

@Serializable
enum class GearSlot {
    HEAD,
    CHEST,
    BOOTS,
    WEAPON,
    CONSUMABLE,
    MODS,
    DRIFTER
}

@Serializable
enum class ArmorSlot {
    HEAD,
    CHEST,
    BOOTS,
}