package com.elkite.warborn.domain.entities.gear

import com.elkite.warborn.domain.entities.spell.Spell

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
            head?.let { "head=${it.id}" },
            chest?.let { "chest=${it.id}" },
            boots?.let { "boots=${it.id}" },
            weapon?.let { "weapon=${it.id}" },
            passive?.let { "passive=${it.id}" },
            commonSkill?.let { "commonSkill=${it.id}" },
            basicAttack?.let { "basicAttack=${it.id}" },
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