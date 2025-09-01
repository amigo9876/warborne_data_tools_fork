package com.elkite.warborn.data.repository

import com.elkite.warborn.data.network.httpClient
import com.elkite.warborn.data.repository.SpellAndGearParser.parseBasicSpells
import com.elkite.warborn.data.repository.SpellAndGearParser.parseCommonSpells
import com.elkite.warborn.data.repository.SpellAndGearParser.parsePassiveSpell
import com.elkite.warborn.data.repository.SpellAndGearParser.parseSkillSpells
import com.elkite.warborn.domain.entities.common.Category
import com.elkite.warborn.domain.entities.data.Boots
import com.elkite.warborn.domain.entities.data.Chest
import com.elkite.warborn.domain.entities.data.Data
import com.elkite.warborn.domain.entities.data.DataArmors
import com.elkite.warborn.domain.entities.data.DataDrifters
import com.elkite.warborn.domain.entities.data.DataMods
import com.elkite.warborn.domain.entities.data.DataStats
import com.elkite.warborn.domain.entities.data.DataWeapon
import com.elkite.warborn.domain.entities.data.DataWeapons
import com.elkite.warborn.domain.entities.data.Head
import com.elkite.warborn.domain.entities.data.WeaponType
import com.elkite.warborn.domain.entities.drifter.Link
import com.elkite.warborn.domain.entities.gear.BootsGear
import com.elkite.warborn.domain.entities.gear.ChestGear
import com.elkite.warborn.domain.entities.gear.HeadGear
import com.elkite.warborn.domain.entities.gear.WeaponGear
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object DataaRespository {
    private const val url = "https://elkite.github.io/warborne-data-json/"
    private const val dex_boots = "${url}/armors/dex_boots.json"
    private const val int_boots = "${url}/armors/int_boots.json"
    private const val str_boots = "${url}/armors/str_boots.json"
    private const val dex_chest = "${url}/armors/dex_chest.json"
    private const val int_chest = "${url}/armors/int_chest.json"
    private const val str_chest = "${url}/armors/str_chest.json"
    private const val dex_head = "${url}/armors/dex_head.json"
    private const val int_head = "${url}/armors/int_head.json"
    private const val str_head = "${url}/armors/str_head.json"

    private const val dex_drifter = "${url}/drifters/dex_drifter.json"
    private const val int_drifter = "${url}/drifters/int_drifter.json"
    private const val str_drifter = "${url}/drifters/str_drifter.json"
    private const val gather_drifter = "${url}/drifters/gather_drifter.json"

    private const val links = "${url}/links/links.json"

    private const val mod_armor = "${url}/mods/mod_armor.json"
    private const val mod_weapon = "${url}/mods/mod_weapon.json"

    private const val sword = "${url}/weapons/str_sword.json"
    private const val axe = "${url}/weapons/str_axe.json"
    private const val mace = "${url}/weapons/str_mace.json"
    private const val gun = "${url}/weapons/str_gun.json"
    private const val bow = "${url}/weapons/dex_bow.json"
    private const val dagger = "${url}/weapons/dex_dagger.json"
    private const val spear = "${url}/weapons/dex_spear.json"
    private const val nature = "${url}/weapons/dex_nature.json"
    private const val fire = "${url}/weapons/int_fire.json"
    private const val frost = "${url}/weapons/int_frost.json"
    private const val holy = "${url}/weapons/int_holy.json"
    private const val curse = "${url}/weapons/int_curse.json"

    private const val stats = "${url}/stats.json"

    suspend fun getData(): Data {
        try {
            println("Starting data fetch...")

            println("Parse weapons...")
            val weaponData = loadWeapons()
            println("Parse armors...")
            val armors = loadArmors()
            println("Parse Links...")
            val links = parseLinks()
            println("Parse drifters...")
            val drifters = loadDrifters(links)


            return Data(
                weapons = weaponData,
                armors = armors,
                drifters = drifters,
                mods = loadMods(),
                stats = parseStats(Json.parseToJsonElement(httpClient.get(stats).bodyAsText()).jsonObject)
            )
        } catch (e: Exception) {
            println("Error in getData(): ${e.message}")
            e.printStackTrace()
            throw e
        }
    }

    private fun parseStats(json: JsonObject): DataStats {
        val obj = json["stats"]?.jsonObject ?: return DataStats()
        return DataStats(
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

    private suspend fun loadMods() : DataMods {
        val armorMods = ModParser.parseArmorMods(httpClient.get(mod_armor).bodyAsText())
        val weaponMods = ModParser.parseWeaponMods(httpClient.get(mod_weapon).bodyAsText())

        return DataMods(
            armors = armorMods,
            weapons = weaponMods
        )
    }

    private suspend fun loadArmors(): DataArmors {
        return DataArmors(
            boots = Boots(
                dexBoots = parseBoots((httpClient.get(dex_boots).bodyAsText()), "boots_dexterity"),
                    intBoots = parseBoots(httpClient.get(int_boots).bodyAsText(), "boots_intelligence"),
                    strBoots = parseBoots(httpClient.get(str_boots).bodyAsText(), "boots_strength")
            ),
            chest = Chest(
                strChest = parseChest(httpClient.get(str_chest).bodyAsText(), "chest_strength"),
                intChest = parseChest(httpClient.get(int_chest).bodyAsText(), "chest_intelligence"),
                dexChest = parseChest(httpClient.get(dex_chest).bodyAsText(), "chest_dexterity")
            ),
            head = Head(
                strHead = parseHead(httpClient.get(str_head).bodyAsText(), "head_strength"),
                intHead = parseHead(httpClient.get(int_head).bodyAsText(), "head_intelligence"),
                dexHead = parseHead(httpClient.get(dex_head).bodyAsText(), "head_dexterity")
            )
        )
    }

    private suspend fun loadWeapons(): DataWeapons {
        return DataWeapons(
            sword = parseWeapon(httpClient.get(sword).bodyAsText(), WeaponType.sword),
            axe = parseWeapon(httpClient.get(axe).bodyAsText(), WeaponType.axe),
            mace = parseWeapon(httpClient.get(mace).bodyAsText(), WeaponType.mace),
            gun = parseWeapon(httpClient.get(gun).bodyAsText(), WeaponType.gun),
            bow = parseWeapon(httpClient.get(bow).bodyAsText(), WeaponType.bow),
            dagger = parseWeapon(httpClient.get(dagger).bodyAsText(), WeaponType.dagger),
            spear = parseWeapon(httpClient.get(spear).bodyAsText(), WeaponType.spear),
            nature = parseWeapon(httpClient.get(nature).bodyAsText(), WeaponType.nature),
            fire = parseWeapon(httpClient.get(fire).bodyAsText(), WeaponType.fire),
            frost = parseWeapon(httpClient.get(frost).bodyAsText(), WeaponType.frost),
            holy = parseWeapon(httpClient.get(holy).bodyAsText(), WeaponType.holy),
            curse = parseWeapon(httpClient.get(curse).bodyAsText(), WeaponType.curse)
        )
    }

    private suspend fun loadDrifters(links: List<Link>) : DataDrifters {
        return DataDrifters(
            strDrifters = DrifterParser.parseDrifters(links, httpClient.get(str_drifter).bodyAsText(), Category.STR),
            intDrifters = DrifterParser.parseDrifters(links,httpClient.get(int_drifter).bodyAsText(), Category.INT),
            dexDrifters = DrifterParser.parseDrifters(links,httpClient.get(dex_drifter).bodyAsText(), Category.AGI),
//            gatherDrifters = emptyList()
        )
    }


    private fun parseBoots(json: String, key: String): List<BootsGear> {
        val array = Json.parseToJsonElement(json).jsonObject[key]?.jsonArray
            ?: throw IllegalArgumentException("Key $key not found or is not a JSON array")

        return parseSkillSpells(array) { gameId, skillName, manaCost, cooldown, castingRange, description, tierUnlock, gearName, gearStats, rarity, category ->
            BootsGear(
                spellId = gameId,
                spellName = skillName,
                manaCost = manaCost,
                cooldown = cooldown,
                castingRange = castingRange,
                description = description,
                tierUnlock = tierUnlock,
                gearName = gearName,
                gearStats = gearStats,
                rarity = rarity,
                category = category
            )
        }
    }

    private fun parseChest(json: String, key: String): List<ChestGear> {
        val array = Json.parseToJsonElement(json).jsonObject[key]?.jsonArray
            ?: throw IllegalArgumentException("Key $key not found or is not a JSON array")

        return parseSkillSpells(array) { gameId, skillName, manaCost, cooldown, castingRange, description, tierUnlock, gearName, gearStats, rarity, category ->
            ChestGear(
                spellId = gameId,
                spellName = skillName,
                manaCost = manaCost,
                cooldown = cooldown,
                castingRange = castingRange,
                description = description,
                tierUnlock = tierUnlock,
                gearName = gearName,
                gearStats = gearStats,
                rarity = rarity,
                category = category
            )
        }
    }

    private fun parseHead(json: String, key: String): List<HeadGear> {
        val array = Json.parseToJsonElement(json).jsonObject[key]?.jsonArray
            ?: throw IllegalArgumentException("Key $key not found or is not a JSON array")

        return parseSkillSpells(array) { gameId, skillName, manaCost, cooldown, castingRange, description, tierUnlock, gearName, gearStats, rarity, category ->
            HeadGear(
                spellId = gameId,
                spellName = skillName,
                manaCost = manaCost,
                cooldown = cooldown,
                castingRange = castingRange,
                description = description,
                tierUnlock = tierUnlock,
                gearName = gearName,
                gearStats = gearStats,
                rarity = rarity,
                category = category
            )
        }
    }

    private fun parseWeapon(json: String, weaponType: WeaponType): DataWeapon {
        val jsonElement = Json.parseToJsonElement(json)

        val passiveSpell = parsePassiveSpell(jsonElement.jsonObject["passive"]!!.jsonObject)
        val basicAttacks = parseBasicSpells(jsonElement.jsonObject["basicAttacks"]!!.jsonArray)
        val commonSkills = parseCommonSpells(jsonElement.jsonObject["commonSkills"]!!.jsonArray)
        val weaponGears: List<WeaponGear> =
            parseSkillSpells(jsonElement.jsonObject["skills"]!!.jsonArray) { gameId, skillName, manaCost, cooldown, castingRange, description, tierUnlock, gearName, gearStats, rarity, category ->
                WeaponGear(
                    spellId = gameId,
                    spellName = skillName,
                    manaCost = manaCost,
                    cooldown = cooldown,
                    castingRange = castingRange,
                    description = description,
                    tierUnlock = tierUnlock,
                    gearName = gearName,
                    gearStats = gearStats,
                    rarity = rarity,
                    category = category
                )
            }
        return DataWeapon(
            passive = passiveSpell,
            basic = basicAttacks,
            common = commonSkills,
            skills = weaponGears,
            weaponType = weaponType
        )
    }

    private suspend fun parseLinks() : List<Link> {
        val jsonElement = Json.parseToJsonElement(httpClient.get(links).bodyAsText())
        val linksArray = jsonElement.jsonObject["links"]?.jsonArray ?: return emptyList()

        return linksArray.mapNotNull { linkJson ->
            try {
                val obj = linkJson.jsonObject
                val linkName = obj["linkName"]?.jsonPrimitive?.content ?: return@mapNotNull null
                val linkBonus = obj["linkBonus"]?.jsonPrimitive?.content ?: return@mapNotNull null
                val driftersNeeded = obj["driftersNeeded"]?.jsonPrimitive?.content?.toIntOrNull() ?: return@mapNotNull null
                val driftersId = obj["drifters"]?.jsonArray?.mapNotNull { drifterEntry ->
                    drifterEntry.jsonObject["drifterId"]?.jsonPrimitive?.content
                } ?: emptyList()

                Link(
                    linkName,
                    linkBonus,
                    driftersNeeded,
                    driftersId
                )
            } catch (e: Exception) {
                println("Error parsing link: ${e.message}")
                null
            }
        }
    }


}

