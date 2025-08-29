package com.elkite.warborn.presentation.widgets.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MoreDetails(
    isCompact: Boolean,
    onCompactClick: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GearStylizedTextTitle(
            text = "Compact",
            style = MaterialTheme.typography.caption.copy(
                fontWeight = FontWeight.ExtraLight,
            )
        )
        Spacer(modifier = Modifier.width(4.dp))
        Switch(
            checked = isCompact, onCheckedChange = {
                onCompactClick(it)
            },
            modifier = Modifier.padding(end = 8.dp)
        )
    }
}