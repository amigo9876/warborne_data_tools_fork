package com.elkite.warborn.domain.entities.gear

import com.elkite.warborn.domain.entities.common.Category
import com.elkite.warborn.domain.entities.common.Rarity
import com.elkite.warborn.domain.entities.data.WeaponType
import com.elkite.warborn.domain.entities.spells.BasicSpell
import com.elkite.warborn.domain.entities.spells.CommonSpell
import com.elkite.warborn.domain.entities.spells.PassiveSpell
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
    val weaponType: WeaponType,
    val passiveSpell: PassiveSpell,
    val basicSpells: List<BasicSpell>,
    val commonSpells: List<CommonSpell>,
    val activeBasicSpell: BasicSpell? = null,
    val activeCommonSpell: CommonSpell? = null,
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