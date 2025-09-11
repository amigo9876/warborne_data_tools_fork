package com.elkite.warborn.data.repository

import com.elkite.warborn.domain.entities.common.Rarity
import com.elkite.warborn.domain.entities.consumable.Consumable
import com.elkite.warborn.domain.entities.consumable.ConsumableCategory
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object ConsumableParser {
    fun parseConsumables(json: String, key: String, consumableCategory: ConsumableCategory): List<Consumable> {
        val jsonObject =  Json.parseToJsonElement(json).jsonObject
        val consumablesArray = jsonObject[key]?.jsonArray ?: return emptyList()

        println("parseConsumables: ${consumableCategory.name}")
        return consumablesArray.mapNotNull { jsonElement ->
            try {
                val consumableObject = jsonElement.jsonObject
                val rarity = consumableObject.jsonObject["rarity"]?.jsonPrimitive?.content ?: "common"

                Consumable(
                    gameId = consumableObject["gameId"]?.jsonPrimitive?.content ?: return@mapNotNull null,
                    name = consumableObject["name"]?.jsonPrimitive?.content ?: return@mapNotNull null,
                    description = consumableObject["description"]?.jsonPrimitive?.content ?: "",
                    rarity = when (rarity.lowercase()) {
                        "common" -> Rarity.common
                        "uncommon" -> Rarity.uncommon
                        "rare" -> Rarity.rare
                        "epic" -> Rarity.epic
                        "legendary" -> Rarity.legendary
                        else -> Rarity.common
                    },
                    category = consumableCategory
                )
            } catch (e: Exception) {
                null
            }
        }
    }
}