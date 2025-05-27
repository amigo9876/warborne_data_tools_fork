package com.elkite.warborn.presentation.theme

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.elkite.warborn.presentation.theme.WarborneColorTheme.borderSkillColor
import com.elkite.warborn.presentation.theme.WarborneColorTheme.legendaryBrush

@Composable
fun Modifier.spellBorderPassive(
    isSelected: Boolean = false,
    borderWidth: Dp = 2.dp,
    borderColor: Color = borderSkillColor,
    selectedBrush: Brush = legendaryBrush,
    selectedBorderWidth: Dp = 3.dp,
    shape: CutCornerShape = CutCornerShape(12.dp)
) = this then (
        clip(shape)
            .let {
                if (isSelected) {
                    it.border(
                        width = selectedBorderWidth,
                        brush = selectedBrush,
                        shape = shape
                    )
                } else {
                    it.border(
                        width = borderWidth,
                        color = borderColor,
                        shape = shape
                    )
                }
            }
        )

@Composable
fun Modifier.spellBorder(
    isSelected: Boolean = false,
    borderWidth: Dp = 2.dp,
    borderColor: Color = borderSkillColor,
    selectedBrush: Brush = legendaryBrush,
    unSelectedBrush: Brush? = null,
    selectedBorderWidth: Dp = 3.dp,
    shape: Shape = RectangleShape
) = this then (
        clip(shape)
            .let {
                if (isSelected) {
                    it.border(
                        width = selectedBorderWidth,
                        brush = selectedBrush,
                        shape = shape
                    )
                } else {
                    if (unSelectedBrush != null) {
                        it.border(
                            width = borderWidth,
                            brush = unSelectedBrush,
                            shape = shape
                        )
                    } else {
                        it.border(
                            width = borderWidth,
                            color = borderColor,
                            shape = shape
                        )
                    }
                }
            }
        )
