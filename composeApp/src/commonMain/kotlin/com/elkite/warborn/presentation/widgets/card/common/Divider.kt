package com.elkite.warborn.presentation.widgets.card.common

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.presentation.theme.WarborneColorTheme

@Composable
fun ColumnScope.CardDivider() =
    Divider(
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 16.dp),
        color = WarborneColorTheme.borderSkillColor,
        thickness = 1.dp
    )