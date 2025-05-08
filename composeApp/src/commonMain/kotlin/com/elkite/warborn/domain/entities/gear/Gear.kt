package com.elkite.warborn.domain.entities.gear

import com.elkite.warborn.domain.entities.spell.Spell

open class Gear(
    open val id: String,
    open val name: String,
    open val type: GearType,
    open val spell: Spell,
)

data class Weapon(
    override val id: String,
    override val name: String,
    override val spell: Spell,
    override val type: GearType,
    val passive: Spell,
    val basicAttack: Spell?,
    val commonSkill: Spell?,
) : Gear(
    id = id,
    name = name,
    type = type,
    spell = spell
)

data class Head(
    override val id: String,
    override val name: String,
    override val spell: Spell,
) : Gear(
    id = id,
    name = name,
    type = GearType.HEAD,
    spell = spell
)

data class Chest(
    override val id: String,
    override val name: String,
    override val spell: Spell,
) : Gear(
    id = id,
    name = name,
    type = GearType.CHEST,
    spell = spell
)

data class Boots(
    override val id: String,
    override val name: String,
    override val spell: Spell,
) : Gear(
    id = id,
    name = name,
    type = GearType.BOOTS,
    spell = spell
)