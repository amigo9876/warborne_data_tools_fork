package com.elkite.warborn.domain.entities.loadout

import com.elkite.warborn.domain.entities.consumable.Consumable
import com.elkite.warborn.domain.entities.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.BootsGear
import com.elkite.warborn.domain.entities.gear.ChestGear
import com.elkite.warborn.domain.entities.gear.HeadGear
import com.elkite.warborn.domain.entities.gear.WeaponGear
import com.elkite.warborn.domain.entities.mod.ArmorMod
import com.elkite.warborn.domain.entities.mod.WeaponMod

data class Loadout(
    val weapon: WeaponGear? = null,
    val head: HeadGear? = null,
    val chest: ChestGear? = null,
    val boots: BootsGear? = null,
    val drifter: Drifter? = null,
    val consumable: Consumable? = null,
    val weaponMod: WeaponMod? = null,
    val headMod: ArmorMod? = null,
    val chestMod: ArmorMod? = null,
    val bootsMod: ArmorMod? = null,
    val selectedLoadoutType: SelectedLoadoutType = SelectedLoadoutType.DRIFTER
) {

    fun isEmpty(): Boolean {
        return head == null && chest == null && boots == null
                && weapon == null && drifter == null && consumable == null
                && weaponMod == null && headMod == null && chestMod == null
                && bootsMod == null
    }

    fun toQueryParams(): String {
        return listOfNotNull(
            head?.let { "head=${it.spellId}" },
            chest?.let { "chest=${it.spellId}" },
            boots?.let { "boots=${it.spellId}" },
            weapon?.let { "weapon=${it.spellId}" },
            weapon?.let { "passive=${it.passiveSpell.spellId}" },
            weapon?.activeCommonSpell?.let { "commonSkill=${it.spellId}" },
            weapon?.activeBasicSpell?.let { "basicAttack=${it.spellId}" },
            drifter?.let { "drifter=${it.gameId}" },
            weaponMod?.let { "modWeapon=${it.iconName}" },
            headMod?.let { "modHead=${it.iconName}" },
            chestMod?.let { "modChest=${it.iconName}" },
            bootsMod?.let { "modBoots=${it.iconName}" },
        ).joinToString("&")
    }

    override fun toString(): String {
        return "Loadout(head=$head, chest=$chest, boots=$boots, weapon=$weapon, drifter=$drifter)"
    }
}