package com.elkite.warborn.domain.entities.gear.mods

import com.elkite.warborn.domain.entities.gear.Gear

data class Mod(
    override val gameId: String,
    override val name: String,
    val description: String,
    val arguments: List<Pair<String, String>>,
    val rarity: String,
    val type: ModType,
    val slot: ModSlot,
) : Gear(
    gameId,
    name,
)

enum class ModType {
    ARMOR,
    WEAPON,
}

enum class ModSlot {
    ALL,
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