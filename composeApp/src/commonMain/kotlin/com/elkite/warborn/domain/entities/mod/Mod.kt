package com.elkite.warborn.domain.entities.mod

import com.elkite.warborn.domain.entities.common.Rarity
import kotlinx.serialization.Serializable

@Serializable
data class  WeaponMod(
    override val name: String,
    override val iconName: String,
    override val description: String,
    override val arguments: List<Pair<String, String>>,
    override val rarity: Rarity,
    override val slot: ModSlot,
) : IMod {
    override val type: ModType = ModType.WEAPON
}

@Serializable
data class ArmorMod(
    override val name: String,
    override val iconName: String,
    override val description: String,
    override val arguments: List<Pair<String, String>>,
    override val rarity: Rarity,
    override val slot: ModSlot,
) : IMod {
    override val type: ModType = ModType.ARMOR
}

