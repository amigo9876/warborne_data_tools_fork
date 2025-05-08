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
    MACE

}