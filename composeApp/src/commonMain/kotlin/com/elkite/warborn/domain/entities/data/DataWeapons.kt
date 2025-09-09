package com.elkite.warborn.domain.entities.data

import com.elkite.warborn.domain.entities.gear.WeaponGear
import com.elkite.warborn.domain.entities.spells.BasicSpell
import com.elkite.warborn.domain.entities.spells.CommonSpell
import com.elkite.warborn.domain.entities.spells.PassiveSpell

data class DataWeapon(
    val skills: List<WeaponGear>,
    val passiveSpell: PassiveSpell,
    val commonSpells: List<CommonSpell>,
    val basicSpells: List<BasicSpell>,
    val weaponType: WeaponType,
)

data class DataWeapons(
    val sword: DataWeapon,
    val axe: DataWeapon,
    val mace: DataWeapon,
    val gun: DataWeapon,
    val bow: DataWeapon,
    val spear: DataWeapon,
    val dagger: DataWeapon,
    val nature: DataWeapon,
    val fire: DataWeapon,
    val frost: DataWeapon,
    val curse: DataWeapon,
    val holy: DataWeapon,
)

enum class WeaponType {
    sword,
    axe,
    mace,
    gun,
    bow,
    spear,
    dagger,
    nature,
    fire,
    frost,
    curse,
    holy
}

