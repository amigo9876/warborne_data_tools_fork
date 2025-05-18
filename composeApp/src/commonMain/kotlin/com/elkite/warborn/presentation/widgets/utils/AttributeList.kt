package com.elkite.warborn.presentation.widgets.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.elkite.warborn.presentation.theme.WarborneTheme

@Composable
fun AttributeList(
    attributes: List<Pair<String, String>>,
    colors: List<Color> = List(attributes.size) { WarborneTheme.textDescriptionColor } // Default color
) {
    Column {
        attributes.forEachIndexed { index, (label, value) ->
            val modifier = if (index % 2 == 0) {
                Modifier
                    .background(
                        brush = Brush.linearGradient(
                            listOf(
                                WarborneTheme.textBorderColor,
                                WarborneTheme.textBorderColor
                            )
                        ),
                        alpha = 0.5f
                    )
            } else {
                Modifier
            }

            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(2.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    GearStylizedText(text = label, color = colors[index])
                    GearStylizedText(text = value, color = colors[index])
                }
            }
        }
    }
}