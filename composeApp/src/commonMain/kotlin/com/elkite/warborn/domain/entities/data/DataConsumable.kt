package com.elkite.warborn.domain.entities.data

import com.elkite.warborn.domain.entities.consumable.Consumable

data class DataConsumables(
    val potions: List<Consumable>,
    val food: List<Consumable>,
    val poisons: List<Consumable>,
    val utilities: List<Consumable>
)