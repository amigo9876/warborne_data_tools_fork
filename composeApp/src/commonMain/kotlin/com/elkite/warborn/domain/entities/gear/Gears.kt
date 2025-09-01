package com.elkite.warborn.domain.entities.gear

import com.elkite.warborn.domain.entities.common.Category
import com.elkite.warborn.domain.entities.common.Rarity
import com.elkite.warborn.domain.entities.spells.SpellType
import com.elkite.warborn.domain.entities.spells.TierUnlock
import kotlinx.serialization.Serializable

@Serializable
data class WeaponGear(
    override val spellId: String,
    override val spellName: String,
    override val description: String,
    override val type: SpellType = SpellType.skill,
    override val manaCost: String,
    override val cooldown: String,
    override val castingRange: String,
    override val tierUnlock: TierUnlock,

    override val gearName: String,
    override val gearStats: GearStats,
    override val rarity: Rarity,
    override val category: Category,
    override val gearSlot: GearSlot = GearSlot.WEAPON,
) : IGear

@Serializable
data class HeadGear(
    override val spellId: String,
    override val spellName: String,
    override val description: String,
    override val type: SpellType = SpellType.passive,
    override val manaCost: String,
    override val cooldown: String,
    override val castingRange: String,
    override val tierUnlock: TierUnlock,

    override val gearName: String,
    override val gearStats: GearStats,
    override val rarity: Rarity,
    override val category: Category,
    override val gearSlot: GearSlot = GearSlot.HEAD,
) : IGear

@Serializable
data class ChestGear(
    override val spellId: String,
    override val spellName: String,
    override val description: String,
    override val type: SpellType = SpellType.skill,
    override val manaCost: String,
    override val cooldown: String,
    override val castingRange: String,
    override val tierUnlock: TierUnlock,

    override val gearName: String,
    override val gearStats: GearStats,
    override val rarity: Rarity,
    override val category: Category,
    override val gearSlot: GearSlot = GearSlot.CHEST,
) : IGear

@Serializable
data class BootsGear(
    override val spellId: String,
    override val spellName: String,
    override val description: String,
    override val type: SpellType = SpellType.skill,
    override val manaCost: String,
    override val cooldown: String,
    override val castingRange: String,
    override val tierUnlock: TierUnlock,

    override val gearName: String,
    override val gearStats: GearStats,
    override val rarity: Rarity,
    override val category: Category,
    override val gearSlot: GearSlot = GearSlot.BOOTS,
) : IGear