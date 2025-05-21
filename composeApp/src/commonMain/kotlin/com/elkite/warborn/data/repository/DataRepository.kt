package com.elkite.warborn.data.repository

import com.elkite.warborn.data.network.httpClient
import com.elkite.warborn.domain.entities.gear.GearLevel
import com.elkite.warborn.domain.entities.gear.GearStats
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.drifter.Link
import com.elkite.warborn.domain.entities.gear.mods.Mod
import com.elkite.warborn.domain.entities.gear.mods.ModSlot
import com.elkite.warborn.domain.entities.gear.mods.ModType
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.domain.entities.gear.spell.SpellType
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object DataRepository {

    private const val url = "https://elkite.github.io/warborne_data/data.json"

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

    suspend fun getMods(): List<Mod> {
        val body = httpClient.get(url).bodyAsText()
        return parseMods(body)
    }

    suspend fun getLastUpdateData(): String {
        val body = httpClient.get(url).bodyAsText()
        val jsonElement = Json.parseToJsonElement(body)

        val data = jsonElement.jsonObject["data"]?.jsonObject ?: return ""
        val lastUpdate = data["lastDataUpdate"]?.jsonPrimitive?.content ?: return ""
        return lastUpdate
    }


    private fun parseJsonToSpells(json: String): List<Spell> {
        val result = mutableListOf<Spell>()
        val jsonElement = Json.parseToJsonElement(json)
        val data = jsonElement.jsonObject["data"]?.jsonObject ?: return result

        val weaponSection = data["weapon"]?.jsonObject.orEmpty()
        val armorSection = data["armor"]?.jsonObject.orEmpty()

        // --- Weapon: map keys to WeaponType enums ---
        for ((weaponKey, spellsJsonArray) in weaponSection) {

            val gearStats = when {
                "sword" in weaponKey -> GearStats.STR
                "mace" in weaponKey -> GearStats.STR
                "axe" in weaponKey -> GearStats.STR
                "gun" in weaponKey -> GearStats.STR
                "bow" in weaponKey -> GearStats.AGI
                "spear" in weaponKey -> GearStats.AGI
                "dagger" in weaponKey -> GearStats.AGI
                "nature" in weaponKey -> GearStats.AGI
                "fire" in weaponKey -> GearStats.INT
                "frost" in weaponKey -> GearStats.INT
                "holy" in weaponKey -> GearStats.INT
                "curse" in weaponKey -> GearStats.INT
                else -> {
                    println("Unknown armor type: $weaponKey")
                    continue
                }
            }


            for (entry in spellsJsonArray.jsonArray) {
                parseSpell(entry.jsonObject, GearType.valueOf(weaponKey.uppercase()), gearStats)?.let { result.add(it) }
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

            val gearStats = when {
                armorKey.contains("strength") -> GearStats.STR
                armorKey.contains("intelligence") -> GearStats.INT
                armorKey.contains("dexterity") -> GearStats.AGI
                else -> {
                    println("Unknown gear level: $armorKey")
                    continue
                }
            }

            for (entry in spellsJsonArray.jsonArray) {
                parseSpell(entry.jsonObject, gearType, gearStats)?.let { result.add(it) }
            }
        }

        return result
    }

    private fun parseSpell(json: JsonObject, gearType: GearType, gearStats: GearStats): Spell? {
        return try {
            val id = json["gameId"]?.jsonPrimitive?.content ?: return null
            val name = json["skillName"]?.jsonPrimitive?.content ?: return null
            val cooldown = json["cooldown"]?.jsonPrimitive?.content ?: return null
            val range = json["castingRange"]?.jsonPrimitive?.content ?: return null
            val manaCost = json["manaCost"]?.jsonPrimitive?.content ?: return null
            val desc = json["description"]?.jsonPrimitive?.content ?: return null
            val gearName = json["gearName"]?.jsonPrimitive?.content ?: return null

            val typeStr = json["type"]?.jsonPrimitive?.content
                ?.uppercase() ?: return null
            val type = SpellType.valueOf(typeStr)

            val unlockStr = json["unlock"]?.jsonPrimitive?.content
                ?.uppercase() ?: return null
            val gearLevel = when (json["unlock"]?.jsonPrimitive?.content) {
                "0" -> GearLevel.TIER_0
                "1" -> GearLevel.TIER_I
                "2" -> GearLevel.TIER_II
                "3" -> GearLevel.TIER_III
                "4" -> GearLevel.TIER_IV
                "5" -> GearLevel.TIER_V
                "6" -> GearLevel.TIER_VI
                "7" -> GearLevel.TIER_VII
                "8" -> GearLevel.TIER_VIII
                "9" -> GearLevel.TIER_IX
                "10" -> GearLevel.TIER_X
                "11" -> GearLevel.TIER_X_
                else -> {
                    println("Unknown gear level: $unlockStr")
                    return null
                }
            }

            Spell(
                gameId = id,
                name = name,
                description = desc,
                type = type,
                castingRange = range,
                cooldown = cooldown,
                manaCost = manaCost,
                requiredGearLevel = gearLevel,
                associatedGearType = gearType,
                gearName = gearName,
                gearStats = gearStats
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
        val linksSection = data["links"]?.jsonArray.orEmpty()

        // Parse links
        val links = linksSection.mapNotNull { linkJson ->
            try {
                val obj = linkJson.jsonObject
                val linkName = obj["linkName"]?.jsonPrimitive?.content ?: return@mapNotNull null
                val linkBonus = obj["linkBonus"]?.jsonPrimitive?.content ?: return@mapNotNull null
                val driftersNeeded = obj["driftersNeeded"]?.jsonPrimitive?.content?.toIntOrNull() ?: return@mapNotNull null
                val driftersId = obj["drifters"]?.jsonArray?.mapNotNull { drifterObj ->
                    drifterObj.jsonObject["drifterId"]?.jsonPrimitive?.content
                } ?: emptyList()

                Link(linkName, linkBonus, driftersNeeded, driftersId)
            } catch (e: Exception) {
                println("Error parsing link: ${e.message}")
                null
            }
        }

        // Parse drifters
        for ((drifterKey, drifterJson) in drifterSection) {
            try {
                val obj = drifterJson.jsonObject
                val gameId = obj["gameId"]?.jsonPrimitive?.content ?: continue
                val name = obj["name"]?.jsonPrimitive?.content ?: continue
                val strBonus = obj["strBonus"]?.jsonPrimitive?.content ?: continue
                val dexBonus = obj["dexBonus"]?.jsonPrimitive?.content ?: continue
                val intBonus = obj["intBonus"]?.jsonPrimitive?.content ?: continue
                val supportBonus = obj["supportBonus"]?.jsonPrimitive?.content ?: continue
                val supportMalus = obj["supportMalus"]?.jsonPrimitive?.content ?: continue
                val spells = obj["spells"]?.jsonArray ?: continue
                if (spells.size < 2) continue

                val gearStats = when {
                    drifterKey.contains("str") -> GearStats.STR
                    drifterKey.contains("int") -> GearStats.INT
                    drifterKey.contains("dex") -> GearStats.AGI
                    else -> {
                        println("Unknown gear level: $drifterKey")
                        continue
                    }
                }
                val activeSpell = parseSpell(spells[0].jsonObject, GearType.DRIFTER, gearStats) ?: continue
                val passiveSpell = parseSpell(spells[1].jsonObject, GearType.DRIFTER, gearStats) ?: continue

                val matchedLinks = links.filter { link -> gameId in link.driftersId }

                drifters.add(
                    Drifter(
                        gameId = gameId,
                        name = name,
                        gearStats = gearStats,
                        spell = activeSpell,
                        passive = passiveSpell,
                        strBonus = strBonus,
                        dexBonus = dexBonus,
                        intBonus = intBonus,
                        supportBonus = supportBonus,
                        supportMalus = supportMalus,
                        links = matchedLinks
                    )
                )
            } catch (e: Exception) {
                println("Error parsing drifter: ${e.message}")
            }
        }

        return drifters
    }

    private fun parseMods(json: String): List<Mod> {
        val mods = mutableListOf<Mod>()
        val jsonElement = Json.parseToJsonElement(json)
        val data = jsonElement.jsonObject["data"]?.jsonObject ?: return mods
        val modsSection = data["mods"]?.jsonObject ?: return mods

        for ((category, categoryData) in modsSection) {
            val modType = when (category) {
                "armor" -> ModType.ARMOR
                "weapon" -> ModType.WEAPON
                else -> continue
            }

            val modsArray = categoryData.jsonObject["mods"]?.jsonArray ?: continue
            for (modJson in modsArray) {
                try {
                    val obj = modJson.jsonObject
                    val iconName = obj["iconName"]?.jsonPrimitive?.content ?: continue
                    val name = obj["name"]?.jsonPrimitive?.content ?: continue
                    val description = obj["description"]?.jsonPrimitive?.content ?: continue
                    val rarity = obj["rarity"]?.jsonPrimitive?.content ?: continue
                    val slot = obj["slot"]?.jsonPrimitive?.content?.uppercase() ?: continue
                    val arguments = obj["arguments"]?.jsonArray?.mapNotNull { arg ->
                        val argObj = arg.jsonObject
                        val argName = argObj["argumentName"]?.jsonPrimitive?.content ?: return@mapNotNull null
                        val argRange = argObj["argumentRange"]?.jsonPrimitive?.content ?: return@mapNotNull null
                        argName to argRange
                    } ?: emptyList()

                    mods.add(
                        Mod(
                            gameId = iconName,
                            name = name,
                            description = description,
                            arguments = arguments,
                            rarity = rarity,
                            type = modType,
                            slot = ModSlot.valueOf(slot.uppercase())
                        )
                    )
                } catch (e: Exception) {
                    println("Error parsing mod: ${e.message}")
                }
            }
        }

        return mods
    }
}