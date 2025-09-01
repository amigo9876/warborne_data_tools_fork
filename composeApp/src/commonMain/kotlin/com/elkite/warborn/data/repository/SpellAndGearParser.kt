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
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object SpellAndGearParser {

    inline fun <reified T : IGear> parseSkillSpells(
        jsonArray: JsonArray?,
        noinline factory: (String, String, String, String, String, String, TierUnlock, String, GearStats, Rarity, Category) -> T
    ): List<T> {
        if (jsonArray == null) return emptyList()
        return jsonArray.map { spellJson ->
            val gameId = spellJson.jsonObject["gameId"]?.jsonPrimitive?.content ?: "error"
            val skillName = spellJson.jsonObject["skillName"]?.jsonPrimitive?.content ?: "error"
            val manaCost = spellJson.jsonObject["manaCost"]?.jsonPrimitive?.content ?: "error"
            val cooldown = spellJson.jsonObject["cooldown"]?.jsonPrimitive?.content ?: "error"
            val castingRange =
                spellJson.jsonObject["castingRange"]?.jsonPrimitive?.content ?: "error"
            val description = spellJson.jsonObject["description"]?.jsonPrimitive?.content ?: "error"
            val tierUnlock = spellJson.jsonObject["tierUnlock"]?.jsonPrimitive?.content ?: "T0"
            val rarity = spellJson.jsonObject["rarity"]?.jsonPrimitive?.content ?: "common"
            val gearName = spellJson.jsonObject["gearName"]?.jsonPrimitive?.content ?: "error"
            val category = spellJson.jsonObject["category"]?.jsonPrimitive?.content ?: "consumable"
            val gearStats = spellJson.jsonObject["gearStats"]?.jsonObject ?: JsonObject(emptyMap())

            factory(
                gameId,
                skillName,
                manaCost,
                cooldown,
                castingRange,
                description,
                TierUnlock.valueOf(tierUnlock),
                gearName,
                parseGearStats(gearStats),
                Rarity.valueOf(rarity),
                Category.valueOf(category)
            )
        }
    }

     fun parseGearStats(json: JsonObject): GearStats {
        val bonusDamage = json["dmgBonus"]?.jsonPrimitive?.content
        val hp = json["hp"]?.jsonPrimitive?.content
        val tenacity = json["tenacity"]?.jsonPrimitive?.content
        val mpRecovery = json["mpRecovery"]?.jsonPrimitive?.content
        val ms = json["ms"]?.jsonPrimitive?.content
        val attackSpeed = json["as"]?.jsonPrimitive?.content
        val armor = json["armor"]?.jsonPrimitive?.content
        val magicResist = json["magicResi"]?.jsonPrimitive?.content
        val attackPower = json["attackPower"]?.jsonPrimitive?.content

        return GearStats(
            bonusDamage = bonusDamage,
            hp = hp,
            tenacity = tenacity,
            mpRecovery = mpRecovery,
            ms = ms,
            attackSpeed = attackSpeed,
            armor = armor,
            magicResist = magicResist,
            attackPower = attackPower
        )
    }

     fun parseBasicSpells(jsonArray: JsonArray): List<BasicSpell> {
        return jsonArray.map { spellJson ->
            val gameId = spellJson.jsonObject["gameId"]?.jsonPrimitive?.content ?: "error"
            val skillName = spellJson.jsonObject["skillName"]?.jsonPrimitive?.content ?: "error"
            val manaCost = spellJson.jsonObject["manaCost"]?.jsonPrimitive?.content ?: "error"
            val cooldown = spellJson.jsonObject["cooldown"]?.jsonPrimitive?.content ?: "error"
            val castingRange =
                spellJson.jsonObject["castingRange"]?.jsonPrimitive?.content ?: "error"
            val description = spellJson.jsonObject["description"]?.jsonPrimitive?.content ?: "error"
            val tierUnlock = spellJson.jsonObject["tierUnlock"]?.jsonPrimitive?.content ?: "T0"

            BasicSpell(
                spellId = gameId,
                spellName = skillName,
                manaCost = manaCost,
                cooldown = cooldown,
                castingRange = castingRange,
                description = description,
                tierUnlock = TierUnlock.valueOf(tierUnlock),
            )
        }
    }

     fun parseCommonSpells(jsonArray: JsonArray): List<CommonSpell> {
        return jsonArray.map { spellJson ->
            val gameId = spellJson.jsonObject["gameId"]?.jsonPrimitive?.content ?: "error"
            val skillName = spellJson.jsonObject["skillName"]?.jsonPrimitive?.content ?: "error"
            val manaCost = spellJson.jsonObject["manaCost"]?.jsonPrimitive?.content ?: "error"
            val cooldown = spellJson.jsonObject["cooldown"]?.jsonPrimitive?.content ?: "error"
            val castingRange =
                spellJson.jsonObject["castingRange"]?.jsonPrimitive?.content ?: "error"
            val description = spellJson.jsonObject["description"]?.jsonPrimitive?.content ?: "error"
            val tierUnlock = spellJson.jsonObject["tierUnlock"]?.jsonPrimitive?.content ?: "T0"

            CommonSpell(
                spellId = gameId,
                spellName = skillName,
                manaCost = manaCost,
                cooldown = cooldown,
                castingRange = castingRange,
                description = description,
                tierUnlock = TierUnlock.valueOf(tierUnlock),
            )
        }
    }

     fun parsePassiveSpell(json: JsonObject): PassiveSpell {
        val gameId = json["gameId"]?.jsonPrimitive?.content ?: ""
        val skillName = json["skillName"]?.jsonPrimitive?.content ?: ""
        val manaCost = json["manaCost"]?.jsonPrimitive?.content ?: ""
        val cooldown = json["cooldown"]?.jsonPrimitive?.content ?: ""
        val castingRange = json["castingRange"]?.jsonPrimitive?.content ?: ""
        val description = json["description"]?.jsonPrimitive?.content ?: ""

        return PassiveSpell(
            spellId = gameId,
            spellName = skillName,
            manaCost = manaCost,
            cooldown = cooldown,
            castingRange = castingRange,
            description = description,
            tierUnlock = TierUnlock.T0
        )
    }

    fun parseSkillSpellDrifter(json: JsonObject): SkillSpell {
        val gameId = json["gameId"]?.jsonPrimitive?.content ?: "error"
        val skillName = json["skillName"]?.jsonPrimitive?.content ?: "error"
        val manaCost = json["manaCost"]?.jsonPrimitive?.content ?: "error"
        val cooldown = json["cooldown"]?.jsonPrimitive?.content ?: "error"
        val castingRange = json["castingRange"]?.jsonPrimitive?.content ?: "error"
        val description = json["description"]?.jsonPrimitive?.content ?: "error"
        val tierUnlock = json["tierUnlock"]?.jsonPrimitive?.content ?: "T0"

        return SkillSpell(
            spellId = gameId,
            spellName = skillName,
            manaCost = manaCost,
            cooldown = cooldown,
            castingRange = castingRange,
            description = description,
            tierUnlock = TierUnlock.valueOf(tierUnlock),
        )
    }
}