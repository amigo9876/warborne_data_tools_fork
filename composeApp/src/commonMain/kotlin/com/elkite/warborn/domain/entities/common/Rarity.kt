package com.elkite.warborn.domain.entities.common

import kotlinx.serialization.Serializable

@Serializable
enum class Rarity {
    common,
    uncommon,
    rare,
    epic,
    legendary
}