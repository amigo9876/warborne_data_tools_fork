package com.elkite.warborn.data.repository

import com.elkite.warborn.domain.entities.common.Rarity
import com.elkite.warborn.domain.entities.mod.BootsMod
import com.elkite.warborn.domain.entities.mod.ChestMod
import com.elkite.warborn.domain.entities.mod.HeadMod
import com.elkite.warborn.domain.entities.mod.IArmorMod
import com.elkite.warborn.domain.entities.mod.IWeaponMod
import com.elkite.warborn.domain.entities.mod.ModSlot
import com.elkite.warborn.domain.entities.mod.UniversalArmorMod
import com.elkite.warborn.domain.entities.mod.UniversalWeaponMod
import com.elkite.warborn.domain.entities.mod.WeaponMod
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject

@Serializable
data class ModArgument(
    val argumentName: String,
    val argumentRange: String
)

@Serializable
data class ModData(
    val name: String,
    val iconName: String,
    val rarity: String,
    val slot: String,
    val description: String,
    val arguments: List<ModArgument>
)

object ModParser {
    fun parseArmorMods(json: String): List<IArmorMod> {
        val jsonObject = Json.parseToJsonElement(json).jsonObject
        val modsArray = jsonObject["mods"]?.jsonArray ?: return emptyList()

        return modsArray.map { element ->
            val modData = Json.decodeFromJsonElement(ModData.serializer(), element)

            val arguments = modData.arguments.map { it.argumentName to it.argumentRange }
            val rarity = Rarity.valueOf(modData.rarity)

            when (modData.slot.lowercase()) {
                "head" -> HeadMod(
                    name = modData.name,
                    iconName = modData.iconName,
                    description = modData.description,
                    arguments = arguments,
                    rarity = rarity
                )
                "chest" -> ChestMod(
                    name = modData.name,
                    iconName = modData.iconName,
                    description = modData.description,
                    arguments = arguments,
                    rarity = rarity
                )
                "boots" -> BootsMod(
                    name = modData.name,
                    iconName = modData.iconName,
                    description = modData.description,
                    arguments = arguments,
                    rarity = rarity
                )
                "all" -> UniversalArmorMod(
                    name = modData.name,
                    iconName = modData.iconName,
                    description = modData.description,
                    arguments = arguments,
                    rarity = rarity
                )
                else -> throw IllegalArgumentException("Unknown armor mod slot: ${modData.slot}")
            }
        }
    }

    fun parseWeaponMods(json: String): List<IWeaponMod> {
        val jsonObject = Json.parseToJsonElement(json).jsonObject
        val modsArray = jsonObject["mods"]?.jsonArray ?: return emptyList()

        return modsArray.map { element ->
            val modData = Json.decodeFromJsonElement(ModData.serializer(), element)

            val arguments = modData.arguments.map { it.argumentName to it.argumentRange }
            val rarity = Rarity.valueOf(modData.rarity)

            when (modData.slot.lowercase()) {
                "all" -> UniversalWeaponMod(
                    name = modData.name,
                    iconName = modData.iconName,
                    description = modData.description,
                    arguments = arguments,
                    rarity = rarity
                )

                else -> WeaponMod(
                    name = modData.name,
                    iconName = modData.iconName,
                    description = modData.description,
                    arguments = arguments,
                    rarity = rarity,
                    slot = when (modData.slot.lowercase()) {
                        "sword" -> ModSlot.SWORD
                        "axe" -> ModSlot.AXE
                        "mace" -> ModSlot.MACE
                        "gun" -> ModSlot.GUN
                        "spear" -> ModSlot.SPEAR
                        "dagger" -> ModSlot.DAGGER
                        "nature" -> ModSlot.NATURE
                        "bow" -> ModSlot.BOW
                        "fire" -> ModSlot.FIRE
                        "ice" -> ModSlot.ICE
                        "curse" -> ModSlot.CURSE
                        "holy" -> ModSlot.HOLY
                        else -> ModSlot.UNIVERSAL
                    }
                )
            }

        }
    }
}