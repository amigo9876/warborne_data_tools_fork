package com.elkite.warborn.domain.entities.old.spell

import com.elkite.warborn.domain.entities.old.Gear
import com.elkite.warborn.domain.entities.old.GearLevel
import com.elkite.warborn.domain.entities.old.GearStats
import com.elkite.warborn.domain.entities.old.GearType
import com.elkite.warborn.domain.entities.old.LoadoutType
import com.elkite.warborn.domain.entities.old.Rarity
import com.elkite.warborn.presentation.widgets.patch_balance.Balance

data class Spell(
    override val gameId: String,
    override val name: String,
    override val balance: Balance,
    val description: String,
    val type: SpellType,
    val castingRange: String,
    val cooldown: String,
    val manaCost: String,
    val requiredGearLevel: GearLevel,
    val associatedGearType: GearType,
    val gearName: String? = null,
    val gearStats: GearStats,
    val rarity: Rarity? = null,
    val stats: Stats
) : Gear(gameId, name, balance) {
    override fun toString(): String {
        return "Spell(id='${gameId}',\\\n name='$name',\\\n description='$description',\\\n type=$type," +
                "\\\n castingRange='$castingRange',\\\n cooldown='$cooldown',\\\n " +
                "manaCost='$manaCost',\\\n requiredGearLevel=$requiredGearLevel,\\\n " +
                "associatedGearType=$associatedGearType)\\\n gearName=$gearName \\\n gearStat=$gearStats"
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