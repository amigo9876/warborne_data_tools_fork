package com.elkite.warborn.domain.entities.mod

import com.elkite.warborn.domain.entities.common.Rarity
import kotlinx.serialization.Serializable

@Serializable
data class HeadMod(
    override val name: String,
    override val iconName: String,
    override val description: String,
    override val arguments: List<Pair<String, String>>,
    override val rarity: Rarity,
    override val slot: ModSlot = ModSlot.HEAD,
): IArmorMod

@Serializable
data class ChestMod(
    override val name: String,
    override val iconName: String,
    override val description: String,
    override val arguments: List<Pair<String, String>>,
    override val rarity: Rarity,
    override val slot: ModSlot = ModSlot.CHEST,
): IArmorMod

@Serializable
data class BootsMod(
    override val name: String,
    override val iconName: String,
    override val description: String,
    override val arguments: List<Pair<String, String>>,
    override val rarity: Rarity,
    override val slot: ModSlot = ModSlot.BOOTS,
): IArmorMod

@Serializable
data class WeaponMod(
    override val name: String,
    override val iconName: String,
    override val description: String,
    override val arguments: List<Pair<String, String>>,
    override val rarity: Rarity,
    override val slot: ModSlot,
): IWeaponMod

@Serializable
data class UniversalArmorMod(
    override val name: String,
    override val iconName: String,
    override val description: String,
    override val arguments: List<Pair<String, String>>,
    override val rarity: Rarity,
    override val slot: ModSlot = ModSlot.UNIVERSAL,
): IArmorMod

@Serializable
data class UniversalWeaponMod(
    override val name: String,
    override val iconName: String,
    override val description: String,
    override val arguments: List<Pair<String, String>>,
    override val rarity: Rarity,
    override val slot: ModSlot = ModSlot.UNIVERSAL,
): IWeaponMod

