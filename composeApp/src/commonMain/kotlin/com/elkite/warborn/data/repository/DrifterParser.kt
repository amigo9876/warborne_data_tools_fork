package com.elkite.warborn.data.repository

import com.elkite.warborn.domain.entities.common.Category
import com.elkite.warborn.domain.entities.drifter.Drifter
import com.elkite.warborn.domain.entities.drifter.DrifterMainStatsMultiplier
import com.elkite.warborn.domain.entities.drifter.DrifterStats
import com.elkite.warborn.domain.entities.drifter.Link
import com.elkite.warborn.domain.entities.drifter.SupportStationBonus
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object DrifterParser {
    fun parseDrifters(links: List<Link>, json: String, category: Category): List<Drifter> {
        val drifters = mutableListOf<Drifter>()
        try {
            val jsonElement = Json.parseToJsonElement(json)
            val drifterSection = jsonElement.jsonObject["drifters"]?.jsonObject ?: run {
                println("No drifters section found")
                return emptyList()
            }


            for ((key, drifterJson) in drifterSection) {
                try {
                    val obj = drifterJson.jsonObject
                    val gameId = obj["gameId"]?.jsonPrimitive?.content
                    if (gameId == null) {
                        println("Missing gameId for drifter: $key")
                        continue
                    }
                    val name = obj["name"]?.jsonPrimitive?.content
                    if (name == null) {
                        println("Missing name for drifter: $gameId")
                        continue
                    }


                    val strBonus = obj["strBonus"]?.jsonPrimitive?.content ?: ""
                    val dexBonus = obj["dexBonus"]?.jsonPrimitive?.content ?: ""
                    val intBonus = obj["intBonus"]?.jsonPrimitive?.content ?: ""

                    val activeSpell = SpellAndGearParser.parseSkillSpellDrifter(obj["skill"]!!.jsonObject)
                    val passiveSpell = SpellAndGearParser.parsePassiveSpell(obj["passive"]!!.jsonObject)

                    val matchedLinks = links.filter { link -> gameId in link.driftersId }

                    drifters.add(
                        Drifter(
                            gameId = gameId,
                            name = name,
                            spell = activeSpell,
                            passive = passiveSpell,
                            statsMultiplier = DrifterMainStatsMultiplier(
                                strBonus = strBonus,
                                dexBonus = dexBonus,
                                intBonus = intBonus
                            ),
                            bonus = parseSupportBonus(obj),
                            links = matchedLinks,
                            stats = parseDrifterStats(obj),
                            category = category
                        )
                    )
                } catch (e: Exception) {
                    println("Error parsing drifter $key: ${e.message}")
                    e.printStackTrace()
                }
            }
        } catch (e: Exception) {
            println("Error in parseDrifters(): ${e.message}")
            e.printStackTrace()
        }

        return drifters
    }

    private fun parseSupportBonus(json: JsonObject): SupportStationBonus {
        val obj = json["supportStationBonus"]?.jsonObject ?: return SupportStationBonus(
            supportBonus = "",
            supportMalus = "",
            supportBonusValue = "",
            supportMalusValue = ""
        )
        return SupportStationBonus(
            supportBonus = obj["supportBonus"]?.jsonPrimitive?.content ?: "",
            supportMalus = obj["supportMalus"]?.jsonPrimitive?.content ?: "",
            supportBonusValue = obj["supportBonusValue"]?.jsonPrimitive?.content ?: "",
            supportMalusValue = obj["supportMalusValue"]?.jsonPrimitive?.content ?: ""
        )
    }

    private fun parseDrifterStats(json: JsonObject): DrifterStats {
        val obj = json["stats"]?.jsonObject ?: return DrifterStats(
            maxHpBonus = "",
            maxMpBonus = "",
            attackSpeedBonus = "",
            castingSpeedBonus = "",
            skillCooldownRateBonus = "",
            physicalDamageBonus = "",
            magicDamageBonus = "",
            healingBonus = "",
            damageBonusPvE = "",
            criticalRate = "",
            tenacityPenetration = "",
            armor = "",
            magicResistance = "",
            block = "",
            controlResistance = ""
        )
        return DrifterStats(
            maxHpBonus = obj["Max HP Bonus"]?.jsonPrimitive?.content ?: "",
            maxMpBonus = obj["Max MP Bonus"]?.jsonPrimitive?.content ?: "",
            attackSpeedBonus = obj["Attack Speed Bonus"]?.jsonPrimitive?.content ?: "",
            castingSpeedBonus = obj["Casting Speed Bonus"]?.jsonPrimitive?.content ?: "",
            skillCooldownRateBonus = obj["Skill Cooldown Rate Bonus"]?.jsonPrimitive?.content ?: "",
            physicalDamageBonus = obj["Physical Damage Bonus"]?.jsonPrimitive?.content ?: "",
            magicDamageBonus = obj["Magic Damage Bonus"]?.jsonPrimitive?.content ?: "",
            healingBonus = obj["Healing Bonus"]?.jsonPrimitive?.content ?: "",
            damageBonusPvE = obj["Damage Bonus (PvE)"]?.jsonPrimitive?.content ?: "",
            criticalRate = obj["Critical Rate"]?.jsonPrimitive?.content ?: "",
            tenacityPenetration = obj["Tenacity Penetration"]?.jsonPrimitive?.content ?: "",
            armor = obj["Armor"]?.jsonPrimitive?.content ?: "",
            magicResistance = obj["Magic Resistance"]?.jsonPrimitive?.content ?: "",
            block = obj["Block"]?.jsonPrimitive?.content ?: "",
            controlResistance = obj["Control Resistance"]?.jsonPrimitive?.content ?: ""
        )
    }

}