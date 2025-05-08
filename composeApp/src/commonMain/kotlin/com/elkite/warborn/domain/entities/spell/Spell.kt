package com.elkite.warborn.domain.entities.spell

import com.elkite.warborn.domain.entities.gear.GearLevel
import com.elkite.warborn.domain.entities.gear.GearType
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
    val associatedGearType: GearType
) {
    override fun toString(): String {
        return "Spell(id='$id',\\\n name='$name',\\\n description='$description',\\\n type=$type," +
                "\\\n castingRange='$castingRange',\\\n cooldown='$cooldown',\\\n " +
                "manaCost='$manaCost',\\\n requiredGearLevel=$requiredGearLevel,\\\n " +
                "associatedGearType=$associatedGearType)\\\n"
    }
}