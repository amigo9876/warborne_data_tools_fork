package com.elkite.warborn.domain.entities.gear

import kotlinx.serialization.Serializable

@Serializable
enum class GearType {
    HEAD,
    CHEST,
    BOOTS,
    SWORD,
    GUN,
    AXE,
    MACE,
    WEAPON
}

@Serializable
enum class LoadoutType {
    HEAD,
    CHEST,
    BOOTS,
    WEAPON,
    PASSIVE,
    BASIC_ATTACK,
    COMMON_SKILL,
}