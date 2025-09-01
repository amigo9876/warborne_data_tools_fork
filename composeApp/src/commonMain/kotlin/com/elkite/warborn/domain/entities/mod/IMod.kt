package com.elkite.warborn.domain.entities.mod

import com.elkite.warborn.domain.entities.common.Rarity
import kotlinx.serialization.Serializable

interface IMod {
    val name: String
    val iconName: String
    val description: String
    val arguments: List<Pair<String, String>>
    val rarity: Rarity
    val type: ModType
    val slot: ModSlot
}

interface IWeaponMod : IMod {
    override val type: ModType
        get() = ModType.WEAPON
}

interface IArmorMod : IMod {
    override val type: ModType
        get() = ModType.ARMOR
}

@Serializable
enum class ModSlot {
    UNIVERSAL,
    HEAD,
    CHEST,
    BOOTS,
    SWORD,
    AXE,
    MACE,
    GUN,
    SPEAR,
    DAGGER,
    NATURE,
    BOW,
    FIRE,
    ICE,
    CURSE,
    HOLY
}

@Serializable
enum class ModType {
    ARMOR,
    WEAPON,
}