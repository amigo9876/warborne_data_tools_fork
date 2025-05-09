package com.elkite.warborn.domain.entities.spell

import com.elkite.warborn.domain.entities.gear.GearLevel
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.LoadoutType
import kotlinx.serialization.Serializable

@Serializable
data class Spell(
    val id: String,
    val name: String,
    val description: String,
    val type: SpellType,
    val castingRange: String,
    val cooldown: String,
    val manaCost: String,
    val requiredGearLevel: GearLevel,
    val associatedGearType: GearType,
    val gearName: String? = null,
) {
    override fun toString(): String {
        return "Spell(id='$id',\\\n name='$name',\\\n description='$description',\\\n type=$type," +
                "\\\n castingRange='$castingRange',\\\n cooldown='$cooldown',\\\n " +
                "manaCost='$manaCost',\\\n requiredGearLevel=$requiredGearLevel,\\\n " +
                "associatedGearType=$associatedGearType)\\\n gearName=$gearName"
    }

    fun getLoadoutType(): LoadoutType {
        return when (associatedGearType) {
            GearType.HEAD -> LoadoutType.HEAD
            GearType.CHEST -> LoadoutType.CHEST
            GearType.BOOTS -> LoadoutType.BOOTS
           else -> {
                when (type) {
                    SpellType.SKILL -> LoadoutType.WEAPON
                    SpellType.PASSIVE -> LoadoutType.PASSIVE
                    SpellType.BASIC_ATTACK -> LoadoutType.BASIC_ATTACK
                    SpellType.COMMON_SKILL -> LoadoutType.COMMON_SKILL
                }
            }
        }
    }

}