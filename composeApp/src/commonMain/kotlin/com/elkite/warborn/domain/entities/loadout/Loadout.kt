package com.elkite.warborn.domain.entities.loadout

import com.elkite.warborn.domain.entities.consumable.Consumable
import com.elkite.warborn.domain.entities.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.BootsGear
import com.elkite.warborn.domain.entities.gear.ChestGear
import com.elkite.warborn.domain.entities.gear.HeadGear
import com.elkite.warborn.domain.entities.mod.BootsMod
import com.elkite.warborn.domain.entities.mod.ChestMod
import com.elkite.warborn.domain.entities.mod.HeadMod
import com.elkite.warborn.domain.entities.mod.WeaponMod

data class Loadout(
    val weapon: WeaponLoadout? = null,
    val head: HeadGear? = null,
    val chest: ChestGear? = null,
    val boots: BootsGear? = null,
    val drifter: Drifter? = null,
    val consumable: Consumable? = null,
    val weaponMod: WeaponMod? = null,
    val headMod: HeadMod? = null,
    val chestMod: ChestMod? = null,
    val bootsMod: BootsMod? = null,
) {
    fun toQueryParams(): String {
        return listOfNotNull(
            head?.let { "head=${it.gearName}" },
            chest?.let { "chest=${it.gearName}" },
            boots?.let { "boots=${it.gearName}" },
            weapon?.let { "weapon=${it.weapon.spellName}" },
            weapon?.let { "passive=${it.passive}" },
            weapon?.let { "commonSkill=${it.common}" },
            weapon?.let { "basicAttack=${it.basic}" },
            drifter?.let { "drifter=${it.gameId}" },
            weaponMod?.let { "modWeapon=${it.name}" },
            headMod?.let { "modHead=${it.name}" },
            chestMod?.let { "modChest=${it.name}" },
            bootsMod?.let { "modBoots=${it.name}" },
        ).joinToString("&")
    }

    override fun toString(): String {
        return "Loadout(head=$head, chest=$chest, boots=$boots, weapon=$weapon, drifter=$drifter)"
    }
}