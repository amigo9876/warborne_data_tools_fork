package com.elkite.warborn.domain.entities.gear.mods

import com.elkite.warborn.domain.entities.gear.Gear
import com.elkite.warborn.presentation.widgets.patch_balance.Balance

data class Mod(
    override val gameId: String,
    override val name: String,
    override val balance: Balance,
    val description: String,
    val arguments: List<Pair<String, String>>,
    val rarity: String,
    val type: ModType,
    val slot: ModSlot,
) : Gear(
    gameId,
    name,
    balance
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