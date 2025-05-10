package com.elkite.warborn.data.repository

import com.elkite.warborn.data.network.httpClient
import com.elkite.warborn.domain.entities.gear.Drifter
import com.elkite.warborn.domain.entities.gear.GearLevel
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.spell.Spell
import com.elkite.warborn.domain.entities.spell.SpellType
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object DataRepository {

    const val url = "https://elkite.github.io/warborne_data/data.json"

    suspend fun getData() : List<Spell> {
        val body = httpClient.get(url).bodyAsText()

        val spells = parseJsonToSpells(body)

        return spells
    }

    suspend fun getDrifters(): List<Drifter> {
        val body = httpClient.get(url).bodyAsText()

        val drifters = parseDrifters(body)

        return drifters
    }


    private fun parseJsonToSpells(json: String): List<Spell> {
        val result = mutableListOf<Spell>()
        val jsonElement = Json.parseToJsonElement(json)
        val data = jsonElement.jsonObject["data"]?.jsonObject ?: return result

        val weaponSection = data["weapon"]?.jsonObject.orEmpty()
        val armorSection = data["armor"]?.jsonObject.orEmpty()

        // --- Weapon: map keys to WeaponType enums ---
        for ((weaponKey, spellsJsonArray) in weaponSection) {


            for (entry in spellsJsonArray.jsonArray) {
                parseSpell(entry.jsonObject, GearType.valueOf(weaponKey.uppercase()))?.let { result.add(it) }
            }
        }

        // --- Armor: map keys to HEAD, CHEST, BOOTS ---
        for ((armorKey, spellsJsonArray) in armorSection) {
            val gearType = when {
                armorKey.startsWith("head_") -> GearType.HEAD
                armorKey.startsWith("chest_") -> GearType.CHEST
                armorKey.startsWith("boots_") -> GearType.BOOTS
                else -> {
                    println("Unknown armor type: $armorKey")
                    continue
                }
            }

            for (entry in spellsJsonArray.jsonArray) {
                parseSpell(entry.jsonObject, gearType)?.let { result.add(it) }
            }
        }

        return result
    }

    private fun parseSpell(json: JsonObject, gearType: GearType): Spell? {
        return try {
            val id = json["gameId"]?.jsonPrimitive?.content ?: return null
            val name = json["skillName"]?.jsonPrimitive?.content ?: return null
            val cooldown = json["cooldown"]?.jsonPrimitive?.content ?: return null
            val range = json["castingRange"]?.jsonPrimitive?.content ?: return null
            val manaCost = json["manaCost"]?.jsonPrimitive?.content ?: return null
            val desc = json["description"]?.jsonPrimitive?.content ?: return null
            val gearName = json["gearName"]?.jsonPrimitive?.content?.let {
                it.ifEmpty {
                    null
                }
            }

            val typeStr = json["type"]?.jsonPrimitive?.content
                ?.uppercase() ?: return null
            val type = SpellType.valueOf(typeStr)

            val unlockStr = json["unlock"]?.jsonPrimitive?.content
                ?.uppercase() ?: return null
            val gearLevel = GearLevel.valueOf(unlockStr)

            Spell(
                id = id,
                name = name,
                description = desc,
                type = type,
                castingRange = range,
                cooldown = cooldown,
                manaCost = manaCost,
                requiredGearLevel = gearLevel,
                associatedGearType = gearType,
                gearName = gearName,
            )
        } catch (e: Exception) {
            println("Error parsing spell: ${e.message}")
            null
        }
    }

    private fun parseDrifters(json: String): List<Drifter> {
        val drifters = mutableListOf<Drifter>()
        val jsonElement = Json.parseToJsonElement(json)
        val data = jsonElement.jsonObject["data"]?.jsonObject ?: return emptyList()
        val drifterSection = data["drifters"]?.jsonObject.orEmpty()

        for ((_, drifterJson) in drifterSection) {
            try {
                val obj = drifterJson.jsonObject
                val gameId = obj["gameid"]?.jsonPrimitive?.content ?: continue
                val name = obj["name"]?.jsonPrimitive?.content ?: continue
                val spells = obj["spells"]?.jsonArray ?: continue
                if (spells.size < 2) continue

                val activeSpell = parseSpell(spells[0].jsonObject, GearType.DRIFTER) ?: continue
                val passiveSpell = parseSpell(spells[1].jsonObject, GearType.DRIFTER) ?: continue

                drifters.add(Drifter(gameId, name, activeSpell, passiveSpell))
            } catch (e: Exception) {
                println("Error parsing drifter: ${e.message}")
            }
        }

        return drifters
    }

}