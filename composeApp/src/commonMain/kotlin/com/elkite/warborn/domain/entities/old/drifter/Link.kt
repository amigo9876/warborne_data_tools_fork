package com.elkite.warborn.domain.entities.old.drifter

data class Link(
    val name: String,
    val description: String,
    val driftersNeeded: Int,
    val driftersId: List<String>,
)