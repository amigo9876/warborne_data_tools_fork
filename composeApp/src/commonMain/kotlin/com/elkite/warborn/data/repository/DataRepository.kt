package com.elkite.warborn.data.repository

import com.elkite.warborn.data.entities.Data
import com.elkite.warborn.data.network.httpClient
import com.elkite.warborn.domain.entities.gear.GearLevel
import com.elkite.warborn.domain.entities.gear.GearStats
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.Rarity
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.drifter.DrifterStats
import com.elkite.warborn.domain.entities.gear.drifter.Link
import com.elkite.warborn.domain.entities.gear.mods.Mod
import com.elkite.warborn.domain.entities.gear.mods.ModSlot
import com.elkite.warborn.domain.entities.gear.mods.ModType
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.domain.entities.gear.spell.SpellType
import com.elkite.warborn.domain.entities.gear.spell.Stats
import com.elkite.warborn.presentation.widgets.patch_balance.Balance
import com.elkite.warborn.presentation.widgets.patch_balance.BalanceStatus
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.datetime.Clock
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object DataRepository {
    private const val baseUrl = "https://elkite.github.io/warborne_data/json"
    private const val armorUrl = "$baseUrl/armor.json"
    private const val weaponUrl = "$baseUrl/weapon.json"
    private const val drifterUrl = "$baseUrl/drifter.json"
    private const val linkUrl = "$baseUrl/link.json"
    private const val modUrl = "$baseUrl/mod.json"

    suspend fun getData(): Data {
        try {
            println("Starting data fetch...")
            val armorJson = httpClient.get(armorUrl).bodyAsText()
            val weaponJson = httpClient.get(weaponUrl).bodyAsText()
            val drifterJson = httpClient.get(drifterUrl).bodyAsText()
            val linkJson = httpClient.get(linkUrl).bodyAsText()
            val modJson = httpClient.get(modUrl).bodyAsText()
            println("All JSON files fetched successfully")

            println("Parsing weapons...")
            val weaponSpells = parseWeapons(weaponJson)
            println("Parsed ${weaponSpells.size} weapon spells")

            println("Parsing armors...")
            val armorSpells = parseArmors(armorJson)
            println("Parsed ${armorSpells.size} armor spells")

            val spells = weaponSpells + armorSpells

            println("Parsing links...")
            val links = parseLinks(linkJson)
            println("Parsed ${links.size} links")

            println("Parsing drifters...")
            val drifters = parseDrifters(drifterJson, links)
            println("Parsed ${drifters.size} drifters")

            println("Parsing mods...")
            val mods = parseMods(modJson)
            println("Parsed ${mods.size} mods")

            val lastUpdate = getLastUpdateData(weaponJson)

            return Data(
                lastUpdate = lastUpdate,
                spells = spells,
                drifters = drifters,
                mods = mods
            )
        } catch (e: Exception) {
            println("Error in getData(): ${e.message}")
            e.printStackTrace()
            throw e
        }
    }

    private fun getLastUpdateData(json: String): String {
        val jsonElement = Json.parseToJsonElement(json)
        return jsonElement.jsonObject["lastDataUpdate"]?.jsonPrimitive?.content ?: Clock.System.now().toString()
    }

    private fun parseBalance(json: JsonObject): Balance {
        val lastUpdate = json["lastUpdate"]?.jsonPrimitive?.content ?: ""
        val changes = json["changes"]?.jsonPrimitive?.content ?: ""
        val statusString = json["status"]?.jsonPrimitive?.content?.lowercase() ?: "balance"
        val status = when (statusString) {
            "nerf" -> BalanceStatus.nerf
            "buff" -> BalanceStatus.buff
            else -> BalanceStatus.balance
        }

        return Balance(lastUpdate, changes, status)
    }

    private fun parseStats(json: JsonObject): Stats {
       val obj = json["stats"]?.jsonObject ?: return Stats()
        return Stats(
            bonusDamage =  obj["dmgBonus"]?.jsonPrimitive?.content,
            hp = obj["hp"]?.jsonPrimitive?.content,
            tenacity = obj["tenacity"]?.jsonPrimitive?.content,
            mpRecovery = obj["mpRecovery"]?.jsonPrimitive?.content,
            ms = obj["ms"]?.jsonPrimitive?.content,
            attackSpeed = obj["as"]?.jsonPrimitive?.content,
            armor = obj["armor"]?.jsonPrimitive?.content,
            magicResist = obj["magicResi"]?.jsonPrimitive?.content,
            attackPower = obj["attackPower"]?.jsonPrimitive?.content
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

    private fun parseWeapons(json: String): List<Spell> {
        val result = mutableListOf<Spell>()
        val jsonElement = Json.parseToJsonElement(json)

        // Get weapon section which contains the weapon types
        val weaponSection = jsonElement.jsonObject["weapon"]?.jsonObject ?: return result

        // Process each weapon type
        for ((weaponKey, spellsJsonArray) in weaponSection) {
            val gearType = try {
                GearType.valueOf(weaponKey.uppercase())
            } catch (e: Exception) {
                println("Unknown gear type: $weaponKey")
                continue
            }

            val gearStats = when {
                "sword" == weaponKey -> GearStats.STR
                "mace" == weaponKey -> GearStats.STR
                "axe" == weaponKey -> GearStats.STR
                "gun" == weaponKey -> GearStats.STR
                "bow" == weaponKey -> GearStats.AGI
                "spear" == weaponKey -> GearStats.AGI
                "dagger" == weaponKey -> GearStats.AGI
                "nature" == weaponKey -> GearStats.AGI
                "fire" == weaponKey -> GearStats.INT
                "frost" == weaponKey -> GearStats.INT
                "holy" == weaponKey -> GearStats.INT
                "curse" == weaponKey -> GearStats.INT
                else -> {
                    println("Unknown gear stats for weapon type: $weaponKey")
                    continue
                }
            }

            for (entry in spellsJsonArray.jsonArray) {
                parseSpell(entry.jsonObject, gearType, gearStats)?.let { result.add(it) }
            }
        }

        return result
    }

    private fun parseArmors(json: String): List<Spell> {
        val result = mutableListOf<Spell>()
        val jsonElement = Json.parseToJsonElement(json)

        // Get armor section which contains the armor types
        val armorSection = jsonElement.jsonObject["armor"]?.jsonObject ?: return result

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
                    println("Unknown gear stats for armor: $armorKey")
                    continue
                }
            }

            for (entry in spellsJsonArray.jsonArray) {
                parseSpell(entry.jsonObject, gearType, gearStats)?.let { result.add(it) }
            }
        }

        return result
    }

    private fun parseLinks(json: String): List<Link> {
        val jsonElement = Json.parseToJsonElement(json)

        // Get links array
        val linksArray = jsonElement.jsonObject["links"]?.jsonArray ?: return emptyList()

        return linksArray.mapNotNull { linkJson ->
            try {
                val obj = linkJson.jsonObject
                val linkName = obj["linkName"]?.jsonPrimitive?.content ?: return@mapNotNull null
                val linkBonus = obj["linkBonus"]?.jsonPrimitive?.content ?: return@mapNotNull null
                val driftersNeeded = obj["driftersNeeded"]?.jsonPrimitive?.content?.toIntOrNull() ?: return@mapNotNull null

                // Fixed: Extract drifter IDs from nested objects
                val driftersId = obj["drifters"]?.jsonArray?.mapNotNull { drifterEntry ->
                    drifterEntry.jsonObject["drifterId"]?.jsonPrimitive?.content
                } ?: emptyList()

                Link(linkName, linkBonus, driftersNeeded, driftersId)
            } catch (e: Exception) {
                println("Error parsing link: ${e.message}")
                null
            }
        }
    }

    private fun parseDrifters(json: String, links: List<Link>): List<Drifter> {
        val drifters = mutableListOf<Drifter>()
        try {
            val jsonElement = Json.parseToJsonElement(json)
            val drifterSection = jsonElement.jsonObject["drifters"]?.jsonObject ?: run {
                println("No drifters section found")
                return emptyList()
            }

            println("Found ${drifterSection.size} drifters to parse")

            for ((key, drifterJson) in drifterSection) {
                try {
                    println("Parsing drifter: $key")
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

                    println("Processing drifter: $name ($gameId)")

                    val spells = obj["spells"]?.jsonArray
                    if (spells == null) {
                        println("No spells array for drifter: $gameId")
                        continue
                    }

                    if (spells.isEmpty()) {
                        println("Empty spells array for drifter: $gameId")
                        continue
                    }

                    if (spells.size < 2) {
                        println("Drifter $gameId has insufficient spells: ${spells.size}")
                        continue
                    }

                    val strBonus = obj["strBonus"]?.jsonPrimitive?.content ?: ""
                    val dexBonus = obj["dexBonus"]?.jsonPrimitive?.content ?: ""
                    val intBonus = obj["intBonus"]?.jsonPrimitive?.content ?: ""
                    val supportBonus = obj["supportBonus"]?.jsonPrimitive?.content ?: ""
                    val supportMalus = obj["supportMalus"]?.jsonPrimitive?.content ?: ""
                    val supportBonusValue = obj["supportBonusValue"]?.jsonPrimitive?.content ?: ""
                    val supportMalusValue = obj["supportMalusValue"]?.jsonPrimitive?.content ?: ""

                    val balance = parseBalance(obj)

                    // Determine gearStats from gameId prefix since it's not in the JSON
                    val gearStats = when {
                        gameId.contains("_str_") -> GearStats.STR
                        gameId.contains("_int_") -> GearStats.INT
                        gameId.contains("_dex_") -> GearStats.AGI
                        else -> {
                            println("Cannot determine gear stats for drifter $gameId")
                            continue
                        }
                    }

                    println("Parsing active spell for $gameId...")
                    val activeSpell = parseSpell(spells[0].jsonObject, GearType.DRIFTER, gearStats)
                    if (activeSpell == null) {
                        println("Failed to parse active spell for drifter: $gameId")
                        continue
                    }

                    println("Parsing passive spell for $gameId...")
                    val passiveSpell = parseSpell(spells[1].jsonObject, GearType.DRIFTER, gearStats)
                    if (passiveSpell == null) {
                        println("Failed to parse passive spell for drifter: $gameId")
                        continue
                    }

                    val matchedLinks = links.filter { link -> gameId in link.driftersId }

                    drifters.add(
                        Drifter(
                            gameId = gameId,
                            name = name,
                            balance = balance,
                            spell = activeSpell,
                            passive = passiveSpell,
                            strBonus = strBonus,
                            dexBonus = dexBonus,
                            intBonus = intBonus,
                            supportBonus = supportBonus,
                            supportMalus = supportMalus,
                            supportBonusValue = supportBonusValue,
                            supportMalusValue = supportMalusValue,
                            links = matchedLinks,
                            gearStats = gearStats,
                            drifterStats = parseDrifterStats(obj)
                        )
                    )
                    println("Successfully parsed drifter: $name")
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

    private fun parseMods(json: String): List<Mod> {
        val mods = mutableListOf<Mod>()
        val jsonElement = Json.parseToJsonElement(json)

        // Get mods section
        val modsSection = jsonElement.jsonObject["mods"]?.jsonObject ?: return emptyList()

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
                    val slotStr = obj["slot"]?.jsonPrimitive?.content?.uppercase() ?: continue

                    // Parse balance information
                    val balance = parseBalance(obj)

                    val slot = try {
                        ModSlot.valueOf(slotStr)
                    } catch (e: Exception) {
                        println("Unknown mod slot: $slotStr")
                        continue
                    }

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
                            balance = balance,
                            description = description,
                            arguments = arguments,
                            rarity = rarity,
                            type = modType,
                            slot = slot
                        )
                    )
                } catch (e: Exception) {
                    println("Error parsing mod: ${e.message}")
                }
            }
        }

        return mods
    }

    private fun parseSpell(json: JsonObject, gearType: GearType, gearStats: GearStats): Spell? {
        return try {
            val id = json["gameId"]?.jsonPrimitive?.content
            if (id == null) {
                println("Missing gameId in spell")
                return null
            }
            val name = json["skillName"]?.jsonPrimitive?.content ?: ""
            val cooldown = json["cooldown"]?.jsonPrimitive?.content ?: ""
            val range = json["castingRange"]?.jsonPrimitive?.content ?: ""
            val manaCost = json["manaCost"]?.jsonPrimitive?.content ?: ""
            val desc = json["description"]?.jsonPrimitive?.content ?: ""
            val gearName = json["gearName"]?.jsonPrimitive?.content ?: ""

            val rarity = json["rarity"]?.jsonPrimitive?.content?.let { rarityStr ->
                when (rarityStr) {
                    "1" -> Rarity.RARE
                    "2" -> Rarity.EPIC
                    "3" -> Rarity.LEGENDARY
                    else -> null
                }
            }

            val balance = parseBalance(json)

            val typeStr = json["type"]?.jsonPrimitive?.content?.uppercase()
            if (typeStr == null) {
                println("Missing type in spell $id")
                return null
            }
            val type = try {
                when (typeStr) {
                    "BASIC_ATTACK" -> SpellType.BASIC_ATTACK
                    "COMMON_SKILL" -> SpellType.COMMON_SKILL
                    "SKILL" -> SpellType.SKILL
                    "PASSIVE" -> SpellType.PASSIVE
                    else -> SpellType.valueOf(typeStr)
                }
            } catch (e: Exception) {
                println("Unknown spell type: $typeStr for spell $id")
                return null
            }

            val unlockStr = json["unlock"]?.jsonPrimitive?.content
            if (unlockStr == null) {
                println("Missing unlock in spell $id")
                return null
            }
            val gearLevel = when (unlockStr) {
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
                    println("Unknown gear level: $unlockStr for spell $id")
                    return null
                }
            }

            Spell(
                gameId = id,
                name = name,
                balance = balance,
                description = desc,
                type = type,
                castingRange = range,
                cooldown = cooldown,
                manaCost = manaCost,
                requiredGearLevel = gearLevel,
                associatedGearType = gearType,
                gearName = gearName,
                gearStats = gearStats,
                rarity = rarity,
                stats = parseStats(json)
            )
        } catch (e: Exception) {
            println("Error parsing spell: ${e.message}")
            e.printStackTrace()
            null
        }
    }
}