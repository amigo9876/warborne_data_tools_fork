package com.elkite.warborn.data.repository

import com.elkite.warborn.domain.entities.common.Category
import com.elkite.warborn.domain.entities.common.Rarity
import com.elkite.warborn.domain.entities.gear.GearStats
import com.elkite.warborn.domain.entities.gear.IGear
import com.elkite.warborn.domain.entities.spells.BasicSpell
import com.elkite.warborn.domain.entities.spells.CommonSpell
import com.elkite.warborn.domain.entities.spells.PassiveSpell
import com.elkite.warborn.domain.entities.spells.SkillSpell
import com.elkite.warborn.domain.entities.spells.TierUnlock
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object SpellAndGearParser {

    inline fun <reified T : IGear> parseSkillSpells(
        jsonArray: JsonArray?,
        category: Category,
        noinline factory: (String, String, String, String, String, String, TierUnlock, String, GearStats, Rarity, String, Category) -> T
    ): List<T> {
        if (jsonArray == null) {
            println("parseSkillSpells: Input JSON array is null.")
            return emptyList()
        }
        return jsonArray.mapNotNull { spellJson ->
            try {
                val isActive = spellJson.jsonObject["isActive"]?.jsonPrimitive?.boolean ?: true
                if (!isActive) return@mapNotNull null
                val gameId = spellJson.jsonObject["gameId"]?.jsonPrimitive?.content ?: "error"
                val skillName = spellJson.jsonObject["skillName"]?.jsonPrimitive?.content ?: "error"
                val manaCost = spellJson.jsonObject["manaCost"]?.jsonPrimitive?.content ?: "error"
                val cooldown = spellJson.jsonObject["cooldown"]?.jsonPrimitive?.content ?: "error"
                val castingRange = spellJson.jsonObject["castingRange"]?.jsonPrimitive?.content ?: "error"
                val description = spellJson.jsonObject["description"]?.jsonPrimitive?.content ?: "error"
                val tierUnlock = spellJson.jsonObject["tierUnlock"]?.jsonPrimitive?.content ?: "T0"
                val rarity = spellJson.jsonObject["rarity"]?.jsonPrimitive?.content ?: "common"
                val gearName = spellJson.jsonObject["gearName"]?.jsonPrimitive?.content ?: "error"
                val gearIcon = spellJson.jsonObject["gearIcon"]?.jsonPrimitive?.content ?: "error"
                val gearStats = spellJson.jsonObject["stats"]?.jsonObject ?: JsonObject(emptyMap())
                factory(
                    gameId,
                    skillName,
                    manaCost,
                    cooldown,
                    castingRange,
                    description,
                    TierUnlock.entries.find { it.tier == tierUnlock } ?: TierUnlock.T0,
                    gearName,
                    parseGearStats(gearStats),
                    when (rarity.lowercase()) {
                        "common" -> Rarity.common
                        "uncommon" -> Rarity.uncommon
                        "rare" -> Rarity.rare
                        "epic" -> Rarity.epic
                        "legendary" -> Rarity.legendary
                        else -> Rarity.common
                    },
                    gearIcon,
                    category
                )
            } catch (e: Exception) {
                println("parseSkillSpells: Error parsing spell: ${e.message}")
                throw e
            }
        }
    }

    fun parseGearStats(json: JsonObject): GearStats {
        return GearStats(
            bonusDamage = json["dmgBonus"]?.jsonPrimitive?.content,
            hp = json["hp"]?.jsonPrimitive?.content,
            tenacity = json["tenacity"]?.jsonPrimitive?.content,
            mpRecovery = json["mpRecovery"]?.jsonPrimitive?.content,
            ms = json["ms"]?.jsonPrimitive?.content,
            attackSpeed = json["as"]?.jsonPrimitive?.content,
            armor = json["armor"]?.jsonPrimitive?.content,
            magicResist = json["magicResi"]?.jsonPrimitive?.content,
            attackPower = json["attackPower"]?.jsonPrimitive?.content
        )
    }

    fun parseBasicSpells(jsonArray: JsonArray): List<BasicSpell> {
        return jsonArray.map { spellJson ->
            try {
                val gameId = spellJson.jsonObject["gameId"]?.jsonPrimitive?.content ?: "error"
                val skillName = spellJson.jsonObject["skillName"]?.jsonPrimitive?.content ?: "error"
                val manaCost = spellJson.jsonObject["manaCost"]?.jsonPrimitive?.content ?: "error"
                val cooldown = spellJson.jsonObject["cooldown"]?.jsonPrimitive?.content ?: "error"
                val castingRange = spellJson.jsonObject["castingRange"]?.jsonPrimitive?.content ?: "error"
                val description = spellJson.jsonObject["description"]?.jsonPrimitive?.content ?: "error"
                val tierUnlock = spellJson.jsonObject["tierUnlock"]?.jsonPrimitive?.content ?: "0"

                BasicSpell(
                    spellId = gameId,
                    spellName = skillName,
                    manaCost = manaCost,
                    cooldown = cooldown,
                    castingRange = castingRange,
                    description = description,
                    tierUnlock = TierUnlock.entries.find { it.tier == tierUnlock } ?: TierUnlock.T0,
                )
            } catch (e: Exception) {
                println("parseBasicSpells: Error parsing basic spell: ${e.message}")
                throw e
            }
        }
    }

    fun parseCommonSpells(jsonArray: JsonArray): List<CommonSpell> {
        return jsonArray.map { spellJson ->
            try {
                val gameId = spellJson.jsonObject["gameId"]?.jsonPrimitive?.content ?: "error"
                val skillName = spellJson.jsonObject["skillName"]?.jsonPrimitive?.content ?: "error"
                val manaCost = spellJson.jsonObject["manaCost"]?.jsonPrimitive?.content ?: "error"
                val cooldown = spellJson.jsonObject["cooldown"]?.jsonPrimitive?.content ?: "error"
                val castingRange = spellJson.jsonObject["castingRange"]?.jsonPrimitive?.content ?: "error"
                val description = spellJson.jsonObject["description"]?.jsonPrimitive?.content ?: "error"
                val tierUnlock = spellJson.jsonObject["tierUnlock"]?.jsonPrimitive?.content ?: "0"
                CommonSpell(
                    spellId = gameId,
                    spellName = skillName,
                    manaCost = manaCost,
                    cooldown = cooldown,
                    castingRange = castingRange,
                    description = description,
                    tierUnlock = TierUnlock.entries.find { it.tier == tierUnlock } ?: TierUnlock.T0,
                )
            } catch (e: Exception) {
                println("parseCommonSpells: Error parsing common spell: ${e.message}")
                throw e
            }
        }
    }

    fun parsePassiveSpell(json: JsonObject): PassiveSpell {
        return try {
            val gameId = json["gameId"]?.jsonPrimitive?.content ?: ""
            val skillName = json["skillName"]?.jsonPrimitive?.content ?: ""
            val manaCost = json["manaCost"]?.jsonPrimitive?.content ?: ""
            val cooldown = json["cooldown"]?.jsonPrimitive?.content ?: ""
            val castingRange = json["castingRange"]?.jsonPrimitive?.content ?: ""
            val description = json["description"]?.jsonPrimitive?.content ?: ""

            PassiveSpell(
                spellId = gameId,
                spellName = skillName,
                manaCost = manaCost,
                cooldown = cooldown,
                castingRange = castingRange,
                description = description,
                tierUnlock = TierUnlock.T0
            )
        } catch (e: Exception) {
            println("parsePassiveSpell: Error parsing passive spell: ${e.message}")
            throw e
        }
    }

    fun parseSkillSpellDrifter(json: JsonObject): SkillSpell {
        return try {
            val gameId = json["gameId"]?.jsonPrimitive?.content ?: "error"
            val skillName = json["skillName"]?.jsonPrimitive?.content ?: "error"
            val manaCost = json["manaCost"]?.jsonPrimitive?.content ?: "error"
            val cooldown = json["cooldown"]?.jsonPrimitive?.content ?: "error"
            val castingRange = json["castingRange"]?.jsonPrimitive?.content ?: "error"
            val description = json["description"]?.jsonPrimitive?.content ?: "error"
            val tierUnlock = json["tierUnlock"]?.jsonPrimitive?.content ?: "T0"

            SkillSpell(
                spellId = gameId,
                spellName = skillName,
                manaCost = manaCost,
                cooldown = cooldown,
                castingRange = castingRange,
                description = description,
                tierUnlock = TierUnlock.entries.find { it.tier == tierUnlock } ?: TierUnlock.T0,
            )
        } catch (e: Exception) {
            println("parseSkillSpellDrifter: Error parsing skill spell: ${e.message}")
            throw e
        }
    }
}