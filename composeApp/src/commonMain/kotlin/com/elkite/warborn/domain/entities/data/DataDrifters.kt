package com.elkite.warborn.domain.entities.data

import com.elkite.warborn.domain.entities.drifter.Drifter

data class DataDrifters(
    val dexDrifters: List<Drifter>,
    val strDrifters: List<Drifter>,
    val intDrifters: List<Drifter>
)