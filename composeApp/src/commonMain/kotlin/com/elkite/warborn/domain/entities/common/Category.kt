package com.elkite.warborn.domain.entities.common

import kotlinx.serialization.Serializable

@Serializable
enum class Category(val naming: String) {
    STR("Strength"),
    AGI("Agility"),
    INT("Intelligence"),
}