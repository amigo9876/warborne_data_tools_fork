package com.elkite.warborn.data.repository

import com.elkite.warborn.data.network.httpClient
import com.elkite.warborn.data.repository.SpellAndGearParser.parseBasicSpells
import com.elkite.warborn.data.repository.SpellAndGearParser.parseCommonSpells
import com.elkite.warborn.data.repository.SpellAndGearParser.parsePassiveSpell
import com.elkite.warborn.data.repository.SpellAndGearParser.parseSkillSpells
import com.elkite.warborn.domain.entities.common.Category
import com.elkite.warborn.domain.entities.consumable.ConsumableCategory
import com.elkite.warborn.domain.entities.data.Boots
import com.elkite.warborn.domain.entities.data.Chest
import com.elkite.warborn.domain.entities.data.Data
import com.elkite.warborn.domain.entities.data.DataArmors
import com.elkite.warborn.domain.entities.data.DataConsumables
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

object DataRepository {
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
    private const val links = "${url}/drifters/links.json"

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

    private const val potions = "${url}/consumable/potions.json"
    private const val food = "${url}/consumable/food.json"
    private const val utility = "${url}/consumable/utility.json"
    private const val poisons = "${url}/consumable/poison.json"

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
            println("Parse consumables...")
            val consumables = parseConsumables()
            println("Parsing done")

            return Data(
                weapons = weaponData,
                armors = armors,
                drifters = drifters,
                mods = loadMods(),
                stats = parseStats(
                    Json.parseToJsonElement(
                        httpClient.get(stats).bodyAsText()
                    ).jsonObject
                ),
                consumables = consumables
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
            bonusDamage = obj["dmgBonus"]?.jsonPrimitive?.content,
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

    private suspend fun loadMods(): DataMods {
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
                dexBoots = parseBoots(
                    (httpClient.get(dex_boots).bodyAsText()),
                    "boots_dexterity",
                    category = Category.AGI
                ),
                intBoots = parseBoots(
                    httpClient.get(int_boots).bodyAsText(),
                    "boots_intelligence",
                    category = Category.INT
                ),
                strBoots = parseBoots(
                    httpClient.get(str_boots).bodyAsText(),
                    "boots_strength",
                    category = Category.STR
                )
            ),
            chest = Chest(
                strChest = parseChest(
                    httpClient.get(str_chest).bodyAsText(),
                    "chest_strength",
                    category = Category.STR
                ),
                intChest = parseChest(
                    httpClient.get(int_chest).bodyAsText(),
                    "chest_intelligence",
                    category = Category.INT
                ),
                dexChest = parseChest(
                    httpClient.get(dex_chest).bodyAsText(),
                    "chest_dexterity",
                    category = Category.AGI
                )
            ),
            head = Head(
                strHead = parseHead(
                    httpClient.get(str_head).bodyAsText(),
                    "head_strength",
                    category = Category.STR
                ),
                intHead = parseHead(
                    httpClient.get(int_head).bodyAsText(),
                    "head_intelligence",
                    category = Category.INT
                ),
                dexHead = parseHead(
                    httpClient.get(dex_head).bodyAsText(),
                    "head_dexterity",
                    category = Category.AGI
                )
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

    private suspend fun loadDrifters(links: List<Link>): DataDrifters {
        return DataDrifters(
            strDrifters = DrifterParser.parseDrifters(
                links,
                httpClient.get(str_drifter).bodyAsText(),
                Category.STR
            ),
            intDrifters = DrifterParser.parseDrifters(
                links,
                httpClient.get(int_drifter).bodyAsText(),
                Category.INT
            ),
            dexDrifters = DrifterParser.parseDrifters(
                links,
                httpClient.get(dex_drifter).bodyAsText(),
                Category.AGI
            ),
            gathers = DrifterParser.parseDrifters(
                links,
                httpClient.get(gather_drifter).bodyAsText(),
                Category.AGI
            )
        )
    }


    private fun parseBoots(json: String, key: String, category: Category): List<BootsGear> {
        val array = Json.parseToJsonElement(json).jsonObject[key]?.jsonArray
            ?: throw IllegalArgumentException("Key $key not found or is not a JSON array")

        return parseSkillSpells(
            array,
            category
        ) { gameId, skillName, manaCost, cooldown, castingRange, description, tierUnlock, gearName, gearStats, rarity, category ->
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

    private fun parseChest(json: String, key: String, category: Category): List<ChestGear> {
        val array = Json.parseToJsonElement(json).jsonObject[key]?.jsonArray
            ?: throw IllegalArgumentException("Key $key not found or is not a JSON array")

        return parseSkillSpells(
            array,
            category
        ) { gameId, skillName, manaCost, cooldown, castingRange, description, tierUnlock, gearName, gearStats, rarity, category ->
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

    private fun parseHead(json: String, key: String, category: Category): List<HeadGear> {
        val array = Json.parseToJsonElement(json).jsonObject[key]?.jsonArray
            ?: throw IllegalArgumentException("Key $key not found or is not a JSON array")

        return parseSkillSpells(
            array,
            category
        ) { gameId, skillName, manaCost, cooldown, castingRange, description, tierUnlock, gearName, gearStats, rarity, category ->
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
            parseSkillSpells(
                jsonElement.jsonObject["skills"]!!.jsonArray, when (weaponType) {
                    WeaponType.sword, WeaponType.axe, WeaponType.mace, WeaponType.gun -> Category.STR
                    WeaponType.bow, WeaponType.dagger, WeaponType.spear, WeaponType.nature -> Category.AGI
                    WeaponType.fire, WeaponType.frost, WeaponType.holy, WeaponType.curse -> Category.INT
                }
            ) { gameId, skillName, manaCost, cooldown, castingRange, description, tierUnlock, gearName, gearStats, rarity, category ->
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
                    category = when (weaponType) {
                        WeaponType.sword, WeaponType.axe, WeaponType.mace, WeaponType.gun -> Category.STR
                        WeaponType.bow, WeaponType.dagger, WeaponType.spear, WeaponType.nature -> Category.AGI
                        WeaponType.fire, WeaponType.frost, WeaponType.holy, WeaponType.curse -> Category.INT
                    },
                    weaponType = weaponType,
                    passiveSpell = passiveSpell,
                    basicSpells = basicAttacks,
                    commonSpells = commonSkills
                )
            }
        val dataWeapon = DataWeapon(
            skills = weaponGears,
            weaponType = weaponType,
            passiveSpell = passiveSpell,
            basicSpells = basicAttacks,
            commonSpells = commonSkills
        )

        return dataWeapon
    }

    private suspend fun parseLinks(): List<Link> {
        val jsonElement = Json.parseToJsonElement(httpClient.get(links).bodyAsText())
        val linksArray = jsonElement.jsonObject["links"]?.jsonArray ?: return emptyList()

        return linksArray.mapNotNull { linkJson ->
            try {
                val obj = linkJson.jsonObject
                val linkName = obj["linkName"]?.jsonPrimitive?.content ?: return@mapNotNull null
                val linkBonus = obj["linkBonus"]?.jsonPrimitive?.content ?: return@mapNotNull null
                val driftersNeeded = obj["driftersNeeded"]?.jsonPrimitive?.content?.toIntOrNull()
                    ?: return@mapNotNull null
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

    private suspend fun parseConsumables(): DataConsumables {
        val potionsJson = httpClient.get(potions).bodyAsText()
        val foodJson = httpClient.get(food).bodyAsText()
        val utilityJson = httpClient.get(utility).bodyAsText()
        val poisonsJson = httpClient.get(poisons).bodyAsText()

        return DataConsumables(
            potions = ConsumableParser.parseConsumables(
                potionsJson,
                "potions",
                ConsumableCategory.POTION
            ),
            food = ConsumableParser.parseConsumables(
                foodJson,
                "food",
                ConsumableCategory.FOOD
            ),
            utilities = ConsumableParser.parseConsumables(
                utilityJson,
                "utility",
                ConsumableCategory.UTILITY
            ),
            poisons = ConsumableParser.parseConsumables(
                poisonsJson,
                "poison",
                ConsumableCategory.POISON
            )
        )
    }

}

