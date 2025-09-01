package com.elkite.warborn.data.entities

import com.elkite.warborn.domain.entities.old.drifter.Drifter
import com.elkite.warborn.domain.entities.old.mods.Mod
import com.elkite.warborn.domain.entities.old.spell.Spell

data class Data(
    val lastUpdate: String,
    val spells: List<Spell>,
    val drifters: List<Drifter>,
    val mods: List<Mod>,
)
