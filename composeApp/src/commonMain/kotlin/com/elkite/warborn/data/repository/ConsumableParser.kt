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
        val jsonObject = Json.parseToJsonElement(json).jsonObject

        val consumablesArray = jsonObject[key]?.jsonArray ?: return emptyList()

        return consumablesArray.mapNotNull { jsonElement ->
            try {
                val consumableObject = jsonElement.jsonObject

                val rarity = consumableObject["rarity"]?.jsonPrimitive?.content ?: "common"

                Consumable(
                    gameId = consumableObject["id"]?.jsonPrimitive?.content ?: return@mapNotNull null,
                    name = consumableObject["name"]?.jsonPrimitive?.content ?: return@mapNotNull null,
                    iconName = consumableObject["iconName"]?.jsonPrimitive?.content ?: "",
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
                println("Error parsing consumable: ${e.message}")
                null
            }
        }
    }
}