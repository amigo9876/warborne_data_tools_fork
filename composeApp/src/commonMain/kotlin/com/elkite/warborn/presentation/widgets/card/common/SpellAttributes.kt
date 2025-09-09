package com.elkite.warborn.presentation.widgets.card.common

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import com.elkite.warborn.presentation.widgets.utils.AttributeList

@Composable
fun ColumnScope.SpellAttributes(
    manaCost: String,
    cooldown: String,
    range: String,
) {
    val attributes = mutableListOf<Pair<String, String>>()

    if (manaCost.isNotEmpty()) {
        attributes.add("Mana: " to manaCost)
    }
    if (cooldown.isNotEmpty()) {
        attributes.add("Cooldown: " to "${cooldown}s")
    }
    if (range.isNotEmpty()) {
        attributes.add("Range: " to "${range}m")
    }

    AttributeList(attributes = attributes)
}