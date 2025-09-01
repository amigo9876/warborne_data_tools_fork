package com.elkite.warborn.domain.entities.data

import com.elkite.warborn.domain.entities.mod.IArmorMod
import com.elkite.warborn.domain.entities.mod.IWeaponMod

data class DataMods(
    val armors: List<IArmorMod>,
    val weapons: List<IWeaponMod>,
)