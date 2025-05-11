package com.elkite.warborn.domain.entities.gear

import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.spell.Spell

data class Loadout(
    val head: Spell? = null,
    val chest: Spell? = null,
    val boots: Spell? = null,
    val weapon: Spell? = null,
    val passive: Spell? = null,
    val commonSkill: Spell? = null,
    val basicAttack: Spell? = null,
    val drifter: Drifter? = null
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
            drifter?.let { "drifter=${it.gameId}" }
        ).joinToString("&")
    }

    fun isEmpty(): Boolean {
        return head == null && chest == null && boots == null && weapon == null && passive == null && commonSkill == null && basicAttack == null
    }

    fun getSpells(): List<Spell> {
        return listOfNotNull(head, weapon, chest, basicAttack, boots, commonSkill, passive)
    }

    override fun toString(): String {
        return "Loadout(head=$head, chest=$chest, boots=$boots, weapon=$weapon, passive=$passive, commonSkill=$commonSkill, basicAttack=$basicAttack, drifter=$drifter)"
    }
}