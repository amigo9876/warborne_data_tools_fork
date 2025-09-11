package com.elkite.warborn.presentation.widgets.card.common

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText

@Composable
fun ColumnScope.SwitchContainer(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    var checked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.Bottom
    ) {
        GearStylizedText(text = title)
        Spacer(modifier = Modifier.weight(1f) )
        Switch(checked = checked, onCheckedChange = {
            checked = it
        })
    }
    CardDivider()
    if (checked) {
        content()
    }
}