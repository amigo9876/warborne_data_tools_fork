package com.elkite.warborn.presentation.widgets.card.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard

@Composable
fun CardContainer(
    modifier: Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    GearStylizedCard(
        modifier = modifier,
        composable = @Composable {
            Column(
                modifier = Modifier.wrapContentSize().padding(vertical = 16.dp, horizontal = 16.dp)
            ) {
                content()
            }
        }
    )
}