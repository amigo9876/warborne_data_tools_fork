package com.elkite.warborn.presentation.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object WarborneColorTheme {

    val legendaryBorderStartColor: Color
        get() = Color(0xFFfcf4a3)
    private val legendaryBorderEndColor: Color
        get() = Color(0xFF6a2818)
    val legendaryBorderMidColor: Color
        get() = Color(0xFFcd5521)

    private val rareBorderStartColor: Color
        get() = Color(0xFF304d6c)
    private val rareBorderMidColor: Color
        get() = Color(0xFF597e96)
    private val rareBorderEndColor: Color
        get() = Color(0xFF0d2740)

    private val epicBorderStartColor: Color
        get() = Color(0xFFb95fe3)
    private val epicBorderMidColor: Color
        get() = Color(0xFF8b00fa)
    private val epicBorderEndColor: Color
        get() = Color(0xFF5823cf)

    val textDescriptionColor: Color
        get() = Color(0xFFc5dadf)
    val textBackgroundColor: Color
        get() = Color(0xFF1c2121)
    val textBorderColor: Color
        get() = Color(0xFF323736)

    val textDamageColor: Color
        get() = Color(0xFFed6757)
    val textHealColor: Color
        get() = Color(0xFF76d374)
    val textShieldColor: Color
        get() = Color(0xFF7bb1ef)

    val borderSkillHightlightColor: Color
        get() = Color(0xFFede9cf)
    val borderSkillColor: Color
        get() = Color(0xFF6b6e68)

    val dexterityColor: Color
        get() = Color(0xFF76d374)
    val strengthColor: Color
        get() = Color(0xFFed6757)
    val intelligenceColor: Color
        get() = Color(0xFF7bb1ef)


    val legendaryBrushBackground = Brush.verticalGradient(
        colorStops = arrayOf(
            0.0f to legendaryBorderMidColor,
            0.05f to legendaryBorderEndColor,
            0.3f to Color.Black
        )
    )
    val epicBrushBackground = Brush.verticalGradient(
        colorStops = arrayOf(
            0.0f to epicBorderMidColor,
            0.05f to epicBorderEndColor,
            0.3f to Color.Black
        )
    )
    val rareBrushBackground = Brush.verticalGradient(
        colorStops = arrayOf(
            0.0f to rareBorderMidColor,
            0.05f to rareBorderEndColor,
            0.3f to Color.Black
        )
    )

    val legendaryBrush = Brush.linearGradient(
        colors = listOf(
            legendaryBorderStartColor,
            legendaryBorderMidColor,
            legendaryBorderEndColor
        )
    )
    val epicBrush = Brush.linearGradient(
        colors = listOf(
            epicBorderStartColor,
            epicBorderMidColor,
            epicBorderEndColor
        )
    )
    val rareBrush = Brush.linearGradient(
        colors = listOf(
            rareBorderStartColor,
            rareBorderMidColor,
            rareBorderEndColor
        )
    )
    val weaponSpellsCardBrushSelected = Brush.linearGradient(
        colorStops = arrayOf(
            0.0f to legendaryBorderMidColor.copy(alpha = 1f),
            0.5f to legendaryBorderStartColor.copy(alpha = 1f),
            0.6f to legendaryBorderStartColor.copy(alpha = 0.8f),
            0.8f to legendaryBorderStartColor.copy(alpha = 0.5f),
            0.9f to legendaryBorderStartColor.copy(alpha = 0.3f),
            1.0f to borderSkillColor.copy(alpha = 0.05f)

        )
    )

    val weaponSpellsCardBrushUnSelected = Brush.linearGradient(
        colorStops = arrayOf(
            0.0f to legendaryBorderStartColor.copy(alpha = 0.8f),
            0.3f to legendaryBorderStartColor.copy(alpha = 0.5f),
            0.6f to legendaryBorderStartColor.copy(alpha = 0.3f),
            0.8f to legendaryBorderStartColor.copy(alpha = 0.2f),
            0.9f to borderSkillColor.copy(alpha = 0.3f),
            1.0f to borderSkillColor.copy(alpha = 0.05f)

        )
    )
}