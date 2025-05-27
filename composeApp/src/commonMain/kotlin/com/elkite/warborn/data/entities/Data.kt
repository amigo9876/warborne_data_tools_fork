package com.elkite.warborn.data.entities

import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.mods.Mod
import com.elkite.warborn.domain.entities.gear.spell.Spell

data class Data(
    val lastUpdate: String,
    val spells: List<Spell>,
    val drifters: List<Drifter>,
    val mods : List<Mod>,
    )
