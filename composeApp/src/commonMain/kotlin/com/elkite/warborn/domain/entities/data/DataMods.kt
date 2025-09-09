package com.elkite.warborn.domain.entities.data

import com.elkite.warborn.domain.entities.mod.ArmorMod
import com.elkite.warborn.domain.entities.mod.WeaponMod

data class DataMods(
    val armors: List<ArmorMod>,
    val weapons: List<WeaponMod>,
)