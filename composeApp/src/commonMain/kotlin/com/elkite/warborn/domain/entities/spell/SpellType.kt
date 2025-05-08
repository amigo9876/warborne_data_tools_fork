package com.elkite.warborn.domain.entities.spell

import kotlinx.serialization.Serializable

@Serializable
enum class SpellType {
    SKILL,
    PASSIVE,
    BASIC_ATTACK,
    COMMON_SKILL
}