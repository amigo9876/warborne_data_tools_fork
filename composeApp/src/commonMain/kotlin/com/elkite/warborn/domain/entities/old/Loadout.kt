package com.elkite.warborn.domain.entities.old

import com.elkite.warborn.domain.entities.old.drifter.Drifter
import com.elkite.warborn.domain.entities.old.mods.Mod
import com.elkite.warborn.domain.entities.old.spell.Spell

data class Loadout(
    val head: Spell? = null,
    val chest: Spell? = null,
    val boots: Spell? = null,
    val weapon: Spell? = null,
    val passive: Spell? = null,
    val commonSkill: Spell? = null,
    val basicAttack: Spell? = null,
    val drifter: Drifter? = null,
    val modWeapon: Mod? = null,
    val modHead: Mod? = null,
    val modChest: Mod? = null,
    val modBoots: Mod? = null,
) {

    fun toQueryParams(): String {
        return listOfNotNull(
            head?.let { "head=${it.gameId}" },
            chest?.let { "chest=${it.gameId}" },
            boots?.let { "boots=${it.gameId}" },
            weapon?.let { "weapon=${it.gameId}" },
            passive?.let { "passive=${it.gameId}" },
            commonSkill?.let { "commonSkill=${it.gameId}" },
            basicAttack?.let { "basicAttack=${it.gameId}" },
            drifter?.let { "drifter=${it.gameId}" },
            modWeapon?.let { "modWeapon=${it.gameId}" },
            modHead?.let { "modHead=${it.gameId}" },
            modChest?.let { "modChest=${it.gameId}" },
            modBoots?.let { "modBoots=${it.gameId}" },
        ).joinToString("&")
    }

    override fun toString(): String {
        return "Loadout(head=$head, chest=$chest, boots=$boots, weapon=$weapon, passive=$passive, commonSkill=$commonSkill, basicAttack=$basicAttack, drifter=$drifter)"
    }
}