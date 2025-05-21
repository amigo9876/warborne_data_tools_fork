package com.elkite.warborn.domain.entities.gear

import kotlinx.serialization.Serializable

@Serializable
enum class GearMainCategory {
    DRIFTER,
    WEAPON,
    ARMOR,
    MOD
}

@Serializable
enum class GearType {
    HEAD,
    CHEST,
    BOOTS,
    SWORD,
    GUN,
    AXE,
    MACE,
    BOW,
    SPEAR,
    NATURE,
    DAGGER,
    FIRE,
    FROST,
    CURSE,
    HOLY,
    WEAPON,
    DRIFTER,
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
    DRIFTER,
    MOD_WEAPON,
    MOD_HEAD,
    MOD_CHEST,
    MOD_BOOTS,
}